package com.example.tugasweek4.data

import com.example.tugasweek4.R
import com.example.tugasweek4.model.Produk
import com.example.tugasweek4.model.Kategori

class DummyDataToko {
    fun get_data_tokopedia_category(): List<Kategori> {
        return listOf(
            Kategori(image_path = R.drawable.mobils, category_name = "Cars", number_of_items = 100),
            Kategori(image_path = R.drawable.gadget, category_name = "Gadgets", number_of_items = 50),
            Kategori(image_path = R.drawable.elektronik, category_name = "Electronics", number_of_items = 75),
            Kategori(image_path = R.drawable.pakaian, category_name = "Clothing", number_of_items = 200),
            Kategori(image_path = R.drawable.furnitur, category_name = "Furniture", number_of_items = 120),
            Kategori(image_path = R.drawable.buku, category_name = "Books", number_of_items = 300),
            Kategori(image_path = R.drawable.sports, category_name = "Sports", number_of_items = 80),
            Kategori(image_path = R.drawable.beauty, category_name = "Beauty", number_of_items = 150),
        )
    }

    fun get_data_tokopedia_product(): List<Produk> {
        return listOf(
            Produk(
                image_path = R.drawable.samsungs23,
                product_name = "Samsung S23",
                price = 699000,
                location = "New York",
                sold = 50
            ),

            Produk(
                image_path = R.drawable.laptopabc,
                product_name = "Laptop ABC",
                price = 129009,
                location = "Los Angeles",
                sold = 30
            ),
            Produk(
                image_path = R.drawable.smartwatchqrs,
                product_name = "Smartwatch QRS",
                price = 19009,
                location = "San Francisco",
                sold = 20
            ),
            Produk(
                image_path = R.drawable.canoneos718d,
                product_name = "Canon EOS 718D",
                price = 5990000,
                location = "Chicago",
                sold = 10
            )
        )
    }
}