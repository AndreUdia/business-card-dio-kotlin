package com.cabomaldade.businescarddio.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity // room
data class BusinessCard (
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val telephone: String,
    val businessName: String,
    val mail: String,
    val cardColorBackground: String
)