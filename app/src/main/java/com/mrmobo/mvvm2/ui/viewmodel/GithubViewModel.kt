package com.mrmobo.mvvm2.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.mrmobo.mvvm2.data.models.SearchResponse
import com.mrmobo.mvvm2.data.models.User
import com.mrmobo.mvvm2.data.repos.GithubRepository
import kotlinx.coroutines.*
import retrofit2.Response

class GithubViewModel : ViewModel(){
    val users = MutableLiveData<List<User>>()
    fun fetchUsers(){
        viewModelScope.launch {
            val response:Response<List<User>> = withContext(Dispatchers.IO){GithubRepository.getUsers()}
            if (response.isSuccessful){
                response.body()?.let {
                    users.postValue(it)
                }
            }
        }
    }

    fun searchUsers(name: String) = liveData(Dispatchers.IO){
        val response:Response<SearchResponse> = withContext(Dispatchers.IO) { GithubRepository.searchUsers(name)}
            if (response.isSuccessful){
                response.body()?. let {
                    emit(it.items)
                }
            }
        }
    }

fun ViewModel.runIO(
    dispatchers: CoroutineDispatcher = Dispatchers.IO,
    function: suspend  CoroutineScope.() -> Unit
){
    viewModelScope.launch ( dispatchers ){
        function()
    }
}