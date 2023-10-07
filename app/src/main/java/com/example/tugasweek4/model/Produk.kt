package com.example.tugasweek4.model

import androidx.annotation.DrawableRes

class Produk (
    @DrawableRes val image_path: Int,
    val product_name: String,
    val price: Int,
    val location: String,
    val sold: Int
){
}