package com.example.tugasweek4.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tugasweek4.R
import com.example.tugasweek4.data.DummyDataChats
import com.example.tugasweek4.data.DummyDataToko
import com.example.tugasweek4.model.Line_Chat
import com.example.tugasweek4.model.Produk
import com.example.tugasweek4.model.Kategori

@Composable
fun TokoSetiaJayaView(categoriList: List<Kategori>, produkList: List<Produk>){
    Column (
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(color = Color(0xFFFFFFFF))
    ) {
        Row {
            Text(
                text = "Setiajaya",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(20.dp,20.dp)
            )
            Icon(
                imageVector = Icons.Filled.MoreVert,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(180.dp, 20.dp, 0.dp, 0.dp),
            )
        }
        Image(
            painter = painterResource(id = R.drawable.profile) ,
            contentDescription = "Label Promosi",
            modifier = Modifier
                .fillMaxWidth()
                .size(230.dp, 230.dp)
        )

        Text(text = "Categories",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(20.dp,10.dp)
        )

        LazyRow(
            modifier = Modifier
                .padding(10.dp,5.dp)
        ) {
            items (categoriList){
                CategoryCard(it,
                    Modifier
                        .fillMaxWidth()
                )
            }
        }

        Text(
            text = "Product",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(20.dp,10.dp)
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(2)
        ){
            items(produkList){
                ProdukCard(it,
                    Modifier
                        .padding(10.dp,10.dp,10.dp,10.dp)
                )
            }
        }
    }
}

@Composable
fun CategoryCard (categori: Kategori, modifier: Modifier = Modifier){
    Card (
        modifier = modifier
            .padding(10.dp,5.dp,10.dp,10.dp),
            elevation = CardDefaults.cardElevation(20.dp)
    ){
        Column (
            modifier = Modifier
                .size(100.dp, 140.dp)
                .background(color = Color.White),
            horizontalAlignment = Alignment.CenterHorizontally,

        ) {
            Image(
                painter = painterResource(id = categori.image_path),
                contentDescription = "Foto Kategori",
                modifier = Modifier
                    .size(80.dp)
                    .padding(vertical = 10.dp)
            )
            Text(
                text = categori.category_name,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
            Text(
                text = "${categori.number_of_items} Products",
                fontSize = 12.sp,
                modifier = Modifier
            )
        }
    }
}

@Composable
fun ProdukCard (produk: Produk, modifier: Modifier = Modifier){
    Card (
        modifier = modifier
            .padding(16.dp,0.dp,10.dp,10.dp),
        elevation = CardDefaults.cardElevation(20.dp)
    ){
        Column (
            modifier = Modifier
                .background(color = Color.White, shape = RectangleShape)
        ){
                Image(
                    painter = painterResource(id = produk.image_path),
                    contentDescription = "Foto Produk",
                    modifier = Modifier
                        .size(150.dp, 150.dp)
                        .height(150.dp),
                    contentScale = ContentScale.FillWidth
                )

                Text(
                    text = produk.product_name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    modifier = Modifier
                        .padding(horizontal = 10.dp, vertical = 2.dp)

                )

                Text(
                    text = "Rp. ${produk.price}",
                    fontSize = 12.sp,
                    modifier = Modifier
                        .padding(horizontal = 10.dp, vertical = 2.dp)
                )

                Text(
                    text = "Kota ${produk.location}",
                    fontSize = 12.sp,
                    modifier = Modifier
                        .padding(horizontal = 10.dp, vertical = 2.dp)
                )

                Text(
                    text = "${produk.sold} Sold",
                    fontSize = 12.sp,
                    modifier = Modifier
                        .padding(horizontal = 10.dp, vertical = 2.dp)
                )
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TokoSetiaJayaPreview(){
    TokoSetiaJayaView(DummyDataToko().get_data_tokopedia_category(),DummyDataToko().get_data_tokopedia_product())
}
