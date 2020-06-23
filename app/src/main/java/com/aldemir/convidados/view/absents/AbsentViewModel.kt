package com.aldemir.convidados.view.absents

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AbsentViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Ausentes Fragment"
    }
    val text: LiveData<String> = _text
}