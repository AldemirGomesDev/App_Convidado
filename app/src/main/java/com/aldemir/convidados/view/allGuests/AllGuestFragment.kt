package com.aldemir.convidados.view.allGuests

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.aldemir.convidados.R
import com.aldemir.convidados.view.adapter.GuestAdapter
import kotlinx.android.synthetic.main.fragment_all.view.*

class AllGuestFragment : Fragment() {

    private lateinit var allGuestViewModel: AllGuestViewModel
    private val mAdapter: GuestAdapter = GuestAdapter()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        allGuestViewModel = ViewModelProvider(this).get(AllGuestViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_all, container, false)


        val recyclerView = root.recyclerView_all
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = mAdapter

        observer()

        return root
    }

    override fun onResume() {
        super.onResume()
        allGuestViewModel.load()
    }

    private fun observer() {
        allGuestViewModel.guestList.observe(viewLifecycleOwner, Observer {
            mAdapter.updateGuests(it)
        })
    }
}
