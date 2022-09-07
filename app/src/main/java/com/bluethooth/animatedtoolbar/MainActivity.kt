package com.bluethooth.animatedtoolbar

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.bluethooth.animatedtoolbar.ui.theme.AnimatedToolbarTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimatedToolbarTheme {
                val searchBoxState = remember { mutableStateOf(SearchBoxState.Closed) }
                val currentText = remember { mutableStateOf("") }
                MainToolBar(
                    searchBoxState = searchBoxState.value,
                    onSearchTrigger = {
                        searchBoxState.value = SearchBoxState.Opened
                    },
                    onSearchBoxClose = {
                        searchBoxState.value = SearchBoxState.Closed
                    },
                    ontextChange = {
                        currentText.value = it
                    },
                    onSearchClick = {
                        Toast.makeText(this@MainActivity, " Search Button clicked", Toast.LENGTH_LONG).show()
                    },
                    ontextState = currentText.value
                )
            }
        }
    }
}

