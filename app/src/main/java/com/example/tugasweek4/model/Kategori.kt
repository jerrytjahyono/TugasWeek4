package com.example.tugasweek4.model

import androidx.annotation.DrawableRes

class Kategori (
    @DrawableRes val image_path: Int,
    val category_name: String,
    val number_of_items: Int
) {
}