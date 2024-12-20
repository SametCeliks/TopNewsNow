package com.samet.topnews

import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun NewsArticalPage(url : String){
    //url i web görüntüsü haline getirme - convert url to web view
    AndroidView(factory = { context->
        WebView(context).apply {
            settings.javaScriptEnabled=true
            webViewClient = WebViewClient()
            loadUrl(url)
        }
    })
}