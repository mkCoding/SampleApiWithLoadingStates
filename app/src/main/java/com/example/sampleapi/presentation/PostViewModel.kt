package com.example.sampleapi.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sampleapi.data.model.PostModel
import com.example.sampleapi.domain.ApiRepository
import kotlinx.coroutines.launch

class PostViewModel: ViewModel() {
    val repository = ApiRepository()

    // create postData variable
    private val _postData = MutableLiveData<PostState?>()
    val postData:LiveData<PostState?> = _postData

    init {
        loadPostData()
    }

     fun loadPostData(){
         _postData.value = PostState.Loading

        viewModelScope.launch {
            try {

                val data = repository.getPost()
                _postData.value = PostState.Success(post = data)
            }
            catch (e:Exception){
                _postData.value = PostState.Error(e.message?:"Error retrieving Data")
            }

        }

    }
}

sealed class PostState{
    object Loading: PostState()
    data class Success(val post:PostModel): PostState()
    data class Error(val message:String) :PostState()
}