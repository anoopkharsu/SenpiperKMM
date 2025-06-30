package com.example.shared.ui.enterCompany

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.shared.models.SPResult
import com.example.shared.network.KtorService
import com.example.shared.ui.Black
import com.example.shared.ui.Gray
import com.example.shared.ui.Purple
import com.example.shared.ui.White
import com.senpiper.android.network.KtorClientFactory
import io.ktor.client.HttpClient
import kotlinx.coroutines.launch

var baseUrlName = ""
var finalBaseUrl =""
var client : HttpClient? = null
var KtorService : KtorService? = null
@Composable
fun EnterCompanyScreen(hashMap: HashMap<String, String>, spResult: (SPResult)->Unit, url: (String) -> Unit, companyName:(String)->Unit)
{
    client = KtorClientFactory().createClient()
    var baseurl by remember{ mutableStateOf("") }
    Scaffold(
        topBar = {EnterCompanyToolbar("Enter domain name",{}) },
        content = { paddingValues ->
            EnterCompanyContent(paddingValues,hashMap,
                {
                    baseurl=it
                    companyName(it)
                },
                {
                    url(finalBaseUrl)
                }
            )
        },
        bottomBar = {EnterCompanyBottomBar(baseurl,{spResult(it)})},
        modifier = Modifier.background(White)
    )
}

@Composable
fun EnterCompanyBottomBar(baseurl: String,spResult: (SPResult) -> Unit) {
    val coroutineScope = rememberCoroutineScope()
    var result by remember { mutableStateOf<SPResult?>(null) }


    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(horizontal = 12.dp)
            .background(White),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Text(
            text = "Don't remember company domain name?",
            fontSize = 16.sp,
            color = Black,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Medium,
        )
        Spacer(Modifier.weight(1f))
        FloatingActionButton(
            onClick = {

                coroutineScope.launch {
                    try {
                        result = KtorService?.fetchCompanyConfig(baseUrlName)
                        println("API Success: ${result?.response}")
                        if (result != null) {
                            spResult(result!!)
                        } else {
                            println("API Error: No response received")
                        }
                    }
                    catch (e: Exception) {
                        println("API ERROR: ${e.message}")
                        e.printStackTrace()
                    }

                }
            },
            modifier = Modifier.background(Purple,RoundedCornerShape(28.dp)).size(40.dp),

        ) {
            androidx.compose.material3.Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                contentDescription = "enterCompany",
                tint = White
            )
        }

    }
}

@Composable
fun EnterCompanyContent(paddingValues: PaddingValues, hashMap: HashMap<String, String>,baseurl:(String)->Unit,url:(String)->Unit) {
    var baseUrl by remember { mutableStateOf("Senpiper Production") }
    var domainName by remember { mutableStateOf("") }
    var showDialog by remember { mutableStateOf(false) }
    var baseUrlList = hashMap.keys.toList()
    Column(modifier = Modifier.padding(paddingValues).padding(horizontal = 12.dp).fillMaxWidth())
    {
        Text(
            text = "Choose Base URL",
            fontSize = 16.sp,
            color = Black,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Medium,
            modifier = Modifier
                .padding(vertical = 10.dp)
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    width = 1.dp,
                    color = Black,
                    shape = RoundedCornerShape(2.dp)
                ).clickable{
                    showDialog = true
                }
        ) {
            Text(
                text = baseUrl,
                fontSize = 16.sp,
                color = Black,
                modifier = Modifier.padding(10.dp)
            )
        }
        Text(
            text = "Choose Base URL",
            fontSize = 16.sp,
            color = Black,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Medium,
            modifier = Modifier
                .padding(vertical = 10.dp)
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    width = 1.dp,
                    color = Black,
                    shape = RoundedCornerShape(2.dp)
                )
        ) {
            BasicTextField(
                value = domainName,
                onValueChange = {domainName = it
                                baseUrlName = it.toString().trim().toLowerCase()},
                textStyle = TextStyle(color = Black, fontSize = 16.sp),
                modifier = Modifier.padding(10.dp).fillMaxWidth(),
                singleLine = true,
                decorationBox = { innerTextField ->
                    if (domainName.isEmpty()) {
                        Text(
                            text = "Company domain name",
                            color = Gray,
                            fontSize = 16.sp
                        )
                    }
                    innerTextField()
                }
            )
//            TextField(
//                value = domainName,
//                onValueChange = { domainName = it },
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(10.dp),
//                singleLine = true,
//               textStyle =  TextStyle(color = Black, fontSize = 16.sp),
//            )
        }
        openDialog(list = baseUrlList,
            showDialog = showDialog,
            showDialog1 = {showDialog = it},
            {baseUrl = it
             finalBaseUrl = hashMap.get(it) ?: ""
                url(finalBaseUrl)
                KtorService = null
                KtorService = KtorService(client!!, finalBaseUrl)
            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EnterCompanyToolbar(
    title: String,
    onBackClick: () -> Unit
) {
    Row(
        modifier = Modifier.padding(12.dp)
            .fillMaxWidth()
            .height(IntrinsicSize.Min),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = onBackClick,
            modifier = Modifier
                .size(40.dp)
        ) {
            androidx.compose.material3.Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "Back",
                tint = Black
            )
        }

        Text(
            text = title,
            fontSize = 20.sp,
            color = Black,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Medium,
            modifier = Modifier
                .padding(start = 12.dp)
                .weight(1f),
        )
    }
}

@Composable
fun openDialog(list:List<String>,
               showDialog:Boolean,
               showDialog1:(Boolean)->Unit,
                onItemSelected: (String) -> Unit)
{
    if(showDialog) {
        Dialog(
            onDismissRequest = {showDialog1(false) },
            content = {
                LazyColumn(
                    modifier = Modifier.background(White)
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    items(list.size)
                    {
                        Text(
                            text = list.get(it),
                            fontSize = 16.sp,
                            color = Black,
                            fontFamily = FontFamily.SansSerif,
                            fontWeight = FontWeight.Medium,
                            modifier = Modifier.clickable{
                                onItemSelected(list.get(it))
                                showDialog1(false)

                            }
                                .padding(vertical = 10.dp)
                        )
                    }
                }
            }
        )
    }
}

