package com.example.sampleapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

import androidx.compose.ui.tooling.preview.Preview
import com.example.sampleapi.presentation.PostScreen
import com.example.sampleapi.presentation.PostState
import com.example.sampleapi.presentation.PostViewModel
import com.example.sampleapi.ui.theme.SampleApiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SampleApiTheme {
               // Post Screen Here and have it take in a state
                // of post data

                val viewModel: PostViewModel = viewModel()
                val postState by viewModel.postData.observeAsState(PostState.Loading)
                PostScreen(postState = postState)
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SampleApiTheme {
        Greeting("Android")
    }
}