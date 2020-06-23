package com.aldemir.convidados.view.guestForm

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aldemir.convidados.service.repository.GuestRepository
import com.aldemir.convidados.service.model.GuestModel

class GuestFormViewModel(application: Application): AndroidViewModel(application) {

    private val mContext = application.applicationContext
    private val mGuestRepository: GuestRepository = GuestRepository.getInstance(mContext)

    private var mSaveGuest = MutableLiveData<Boolean>()
    val saveGuest: LiveData<Boolean> = mSaveGuest

    fun save(name: String, presence: Boolean) {

        val guest = GuestModel(name = name, presence = presence)
        val saved = mGuestRepository.save(guest)
       mSaveGuest.postValue(saved)
    }

}