package com.example.shared.ui.enterCompany

import androidx.compose.ui.window.ComposeUIViewController
import com.example.shared.models.SPResult
import platform.UIKit.UIViewController

fun mainViewController(hashMap: HashMap<String, String>, spResult: (SPResult)->Unit, url: (String) -> Unit, companyName:(String)->Unit): UIViewController {
    val uiViewController = ComposeUIViewController {
        EnterCompanyScreen(
            hashMap = hashMap,
            spResult = spResult,
            url = url,
            companyName = companyName
        )
    }
    return uiViewController
}