package com.aldemir.convidados.view.presents

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PresentViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Presentes Fragment"
    }
    val text: LiveData<String> = _text
}