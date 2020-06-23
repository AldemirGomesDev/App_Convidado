package com.aldemir.convidados.view.allGuests

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AllGuestViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is All Fragment"
    }
    val text: LiveData<String> = _text
}