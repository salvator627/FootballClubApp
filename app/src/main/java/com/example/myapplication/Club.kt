package com.example.myapplication

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Club (
    val name : String,
    val league : String,
    val stadium: String,
    val coach : String,
    val image : Int
):Parcelable