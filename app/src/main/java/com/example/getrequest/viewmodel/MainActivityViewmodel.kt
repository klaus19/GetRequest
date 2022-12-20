package com.example.getrequest.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.getrequest.network.User
import com.example.getrequest.network.UserNetwork
import kotlinx.coroutines.launch

class MainActivityViewmodel:ViewModel(){

    val myResponse: MutableLiveData<User> = MutableLiveData()
    val myResponseList: MutableLiveData<List<User>> = MutableLiveData()

    fun getPost() {
        viewModelScope.launch {
            myResponse.value = UserNetwork.retrofit.getPost()
        }
    }

    fun getPosts() {
        viewModelScope.launch {
            myResponseList.value = UserNetwork.retrofit.getPosts()
        }
    }

}