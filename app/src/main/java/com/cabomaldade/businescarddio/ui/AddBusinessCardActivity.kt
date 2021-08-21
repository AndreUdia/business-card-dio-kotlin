package com.cabomaldade.businescarddio.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.cabomaldade.businescarddio.App
import com.cabomaldade.businescarddio.R
import com.cabomaldade.businescarddio.data.BusinessCard
import com.cabomaldade.businescarddio.databinding.ActivityAddBusinessCardBinding
import com.cabomaldade.businescarddio.utils.retrieveRandomColorInHexadecimal
import com.google.android.material.snackbar.Snackbar


class AddBusinessCardActivity : AppCompatActivity() {

    private val binding by lazy { ActivityAddBusinessCardBinding.inflate(layoutInflater) }

    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        insertListeners()
    }

    private fun insertListeners() {
        binding.apply {
            btnReturn.setOnClickListener {
                finish()
            }
            btnColorPicker.setOnClickListener {
                // This will be implemented in a future version - for now I will use a random color
            }
            btnSubmit.setOnClickListener {
                val businessCard = BusinessCard (
                    name = binding.tilName.editText?.text.toString(),
                    businessName = binding.tilBusinessName.editText?.text.toString(),
                    telephone = binding.tilPhoneNumber.editText?.text.toString(),
                    mail = binding.tilMailAddress.editText?.text.toString(),
                    cardColorBackground = retrieveRandomColorInHexadecimal()
                )
                mainViewModel.insert(businessCard)
                Snackbar.make(it, R.string.label_show_success,Snackbar.LENGTH_LONG).show()
                finish()
            }
        }
    }
}