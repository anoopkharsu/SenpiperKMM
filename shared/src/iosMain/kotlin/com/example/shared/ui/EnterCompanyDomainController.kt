package com.example.shared.ui

import androidx.compose.ui.window.ComposeUIViewController
import com.example.composeui.ui.enterCompany.EnterCompanyScreen

fun EnterCompanyDomainController(
    hashMap: HashMap<String, String>,
    url: (String) -> Unit,
    companyName:(String)->Unit,
    fetchResult: (String,String) -> Unit
) = ComposeUIViewController {
    EnterCompanyScreen(hashMap,url,companyName,fetchResult)
}