package com.jalalkun.profileappcompose.data.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jalalkun.profileappcompose.data.model.DataProfile
import com.jalalkun.profileappcompose.data.repository.ProfileRepository
import com.jalalkun.profileappcompose.data.utils.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ProfileViewModel(private val profileRepository: ProfileRepository): ViewModel() {
    private val _getProfiles = MutableStateFlow<Resource>(Resource.Loading)
    var profilesFlow = _getProfiles.asStateFlow()
    private val size = 30
    private var page = 1

    val dataProfiles = mutableListOf<DataProfile>()

    fun success(){
        page++
    }

    fun getProfiles(){
        viewModelScope.launch {
            profileRepository.getProfiles(
                size = size,
                page = page
            ).collect{
                _getProfiles.emit(it)
            }
        }
    }

    fun dismissError(){
        viewModelScope.launch {
            _getProfiles.emit(Resource.Dismiss)
        }
    }
}