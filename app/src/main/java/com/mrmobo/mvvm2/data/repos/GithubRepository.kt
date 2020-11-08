package com.mrmobo.mvvm2.data.repos

import com.mrmobo.mvvm2.data.api.Client

object GithubRepository{
    suspend fun getUsers() = Client.api.getUser()
    suspend fun searchUsers(name:String) = Client.api.searchUser(name)
}