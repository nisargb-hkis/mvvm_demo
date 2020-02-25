package com.example.mvvmnisargdemo.ui.home.profile

import androidx.lifecycle.ViewModel
import com.example.mvvmnisargdemo.data.repositories.UserRepository

class ProfileViewModel(
    repository: UserRepository
) : ViewModel() {
    val user = repository.getUser()
}
