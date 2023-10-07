package com.example.tugasweek4.model

import android.annotation.SuppressLint
import androidx.annotation.DrawableRes
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

class Feed (
    val nama: String,
    @DrawableRes val foto_profile: Int,
    @DrawableRes val foto_konten: Int,
    val love: Boolean,
    val bookMark: Boolean,
    val like: Int,
    val caption: String,
    val tanggal: String

){
    fun getTanggal (tanggal: String): String {
        val inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val outputFormatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy", Locale.ENGLISH)
        val localDate = LocalDate.parse(tanggal, inputFormatter)
        return localDate.format(outputFormatter)
    }

    fun getBulan (tanggal: String): String {
        val inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val outputFormatter = DateTimeFormatter.ofPattern("MMMM dd", Locale.ENGLISH)
        val localDate = LocalDate.parse(tanggal, inputFormatter)
        return localDate.format(outputFormatter)
    }
}