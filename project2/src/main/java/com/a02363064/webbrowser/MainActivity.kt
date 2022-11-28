package com.a02363064.webbrowser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val webView = WebView(this)
        val mainLayout = LinearLayout(this).apply{
            orientation = LinearLayout.VERTICAL
        }

        val inputURLText = EditText(this)
        val History = History()

        val goButton = Button(this).apply {
            setText("Go")
            setOnClickListener{
                History.add(inputURLText.text.toString())
                webView.loadUrl(inputURLText.text.toString())
                webView.webViewClient = WebViewClient()
            }
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply{
                weight = 2f
            }
        }

        val forwardButton = Button(this).apply {
            setText("-->")
            setOnClickListener{
                val newURL = History.forward()
                inputURLText.setText(newURL)
                webView.loadUrl(newURL)
                webView.webViewClient = WebViewClient()
            }
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply{
                weight = 2f
            }
        }

        val backButton = Button(this).apply {
            setText("<--")
            setOnClickListener{
                val newURL = History.back()
                inputURLText.setText(newURL)
                webView.loadUrl(newURL)
                webView.webViewClient = WebViewClient()
            }
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply{
                weight = 2f
            }
        }

        val buttonLayout = LinearLayout(this).apply{
            addView(goButton)
            addView(backButton)
            addView(forwardButton)
        }

        mainLayout.addView(inputURLText)
        mainLayout.addView(buttonLayout)
        mainLayout.addView(webView)
        setContentView(mainLayout)
    }
}