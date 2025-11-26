package com.example.sampleapi.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sampleapi.data.model.PostModel

@Composable
fun PostScreen(
    postState: PostState?
){
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        when(postState){
            is PostState.Loading ->
                Box(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            is PostState.Success -> {
                Text(text = "${postState.post?.title}",
                    modifier = Modifier.padding(16.dp),
                    fontSize = 30.sp)
            }
            is PostState.Error -> Text(
                fontSize = 30.sp,
                text = "Error: ${postState.message}")
            else -> {}
        }

    }
}


@Preview(showBackground = true)
@Composable
fun PostScreenPreview(){
    val postDataSuccess = PostState.Success(
        post = PostModel(
        body = "Hello World is a good message",
        id = 8,
        title = "Hello World",
        userId = 3))

    val postDataError = PostState.Error("error fetching data")
    val postDataLoading = PostState.Loading

    PostScreen(postState =  postDataSuccess)
}