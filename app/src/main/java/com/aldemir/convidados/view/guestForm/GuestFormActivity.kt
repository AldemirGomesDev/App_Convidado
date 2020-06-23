package com.aldemir.convidados.view.guestForm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.aldemir.convidados.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_guest_form.*

class GuestFormActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mViewModel: GuestFormViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guest_form)

        mViewModel = ViewModelProvider(this).get(GuestFormViewModel::class.java)

        setListeners()
        observe()
    }

    override fun onClick(view: View) {
        val id = view.id
        if(id == R.id.buttom_save) {

            val name = edit_name.text.toString()
            val presence = radio_present.isChecked

            mViewModel.save(name, presence)

        }
    }

    private fun observe(){
        mViewModel.saveGuest.observe(this, Observer {
            if(it) {
                edit_name.setText("")
                radio_present.isChecked = false
                radio_absent.isChecked = false
                Toast.makeText(this, "Sucesso.", Toast.LENGTH_LONG).show()
            }else {
                Toast.makeText(this, "Falha.", Toast.LENGTH_LONG).show()
            }
        })
    }
    private fun setListeners() {
        buttom_save.setOnClickListener(this)
    }

}
