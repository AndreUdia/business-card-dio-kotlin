package com.cabomaldade.businescarddio.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cabomaldade.businescarddio.data.BusinessCard
import com.cabomaldade.businescarddio.data.BusinessCardRepository

/*
This class is the one tha communicate with the main view
A factory will be create in this class for injection
 */


class MainViewModel (private val businessCardRepository: BusinessCardRepository) : ViewModel() {

    fun insert(businessCard: BusinessCard) {
        businessCardRepository.insert(businessCard)
    }

    fun getAll() : LiveData<List<BusinessCard>> {
        return businessCardRepository.getAll()
    }
}

class MainViewModelFactory(private val repository: BusinessCardRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(repository) as T
        } else {
            throw IllegalArgumentException("Unknown Viewmodel Class")
        }
    }
}