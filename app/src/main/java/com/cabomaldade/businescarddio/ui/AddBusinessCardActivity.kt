package com.cabomaldade.businescarddio.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cabomaldade.businescarddio.databinding.ActivityAddBusinessCardBinding


class AddBusinessCardActivity : AppCompatActivity() {

    private val binding by lazy { ActivityAddBusinessCardBinding.inflate(layoutInflater) }

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

            }
            btnSubmit.setOnClickListener {

            }
        }
    }
}