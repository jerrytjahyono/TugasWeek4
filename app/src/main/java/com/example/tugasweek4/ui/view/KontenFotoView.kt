package com.example.tugasweek4.ui.view

import android.annotation.SuppressLint
import android.graphics.Paint.Align
import androidx.compose.animation.defaultDecayAnimationSpec
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.materialIcon
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tugasweek4.R
import com.example.tugasweek4.data.DummyDataFoto
import com.example.tugasweek4.data.DummyDataToko
import com.example.tugasweek4.model.Foto
import com.example.tugasweek4.model.Line_Chat

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KontenFotoView(FotoList: List<Foto>){

    Scaffold (
        bottomBar = {
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color(0xFF242524), shape = RectangleShape)
                    .padding(14.dp, 10.dp, 14.dp, 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,

            ) {

                Image(
                    painter = painterResource(id = R.drawable.home),
                    contentDescription = "Home Navbar",
                    modifier = Modifier
                        .size(30.dp),
                    colorFilter = ColorFilter.tint(Color.White)
                )

                Image(
                    painter = painterResource(id = R.drawable.search),
                    contentDescription = "Search Navbar",
                    modifier = Modifier
                        .size(30.dp),
                    colorFilter = ColorFilter.tint(Color.White)
                )

                Image(
                    painter = painterResource(id = R.drawable.post),
                    contentDescription = "Search Navbar",
                    modifier = Modifier
                        .size(30.dp),
                    colorFilter = ColorFilter.tint(Color.White)
                )

                Image(
                    painter = painterResource(id = R.drawable.reels),
                    contentDescription = "Search Navbar",
                    modifier = Modifier
                        .size(30.dp),
                    colorFilter = ColorFilter.tint(Color.White)
                )

                Image(
                    painter = painterResource(id = R.drawable.ic_navbarperson),
                    contentDescription = "Search Navbar",
                    modifier = Modifier
                        .size(30.dp),
                    colorFilter = ColorFilter.tint(Color.White)
                )
            }

        }
    ){
        Column (
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .background(color = Color(0xFF242524))
        ){
            LazyVerticalGrid(
                columns = GridCells.Fixed(3)
            ){
                item(span = { GridItemSpan(3) }){
                    Box(
                        modifier = Modifier
                            .padding(10.dp, 10.dp, 10.dp, 10.dp)
                            .border(
                                1.dp,
                                color = Color.LightGray,
                                shape = RoundedCornerShape(25.dp)
                            )
                            .padding(10.dp, 17.dp, 10.dp, 17.dp)
                    ) {
                        Row {
                            Icon(
                                imageVector = Icons.Rounded.Search,
                                contentDescription = "Search",
                                modifier = Modifier
                                    .padding(horizontal = 5.dp),
                                tint = Color.Black
                            )
                            Text(text = "Search",
                                color = Color.White,
                                modifier = Modifier
                                    .padding(horizontal = 20.dp, vertical = 2.dp)
                            )
                        }

                    }
                }
                items(FotoList){
                    FotoCard(it
                    )
                }

            }
        }

    }
}

@Composable
fun FotoCard(foto: Foto, modifier: Modifier = Modifier){
    Box (
        modifier = Modifier
            .aspectRatio(1f)
    ){
        Image(
            painter = painterResource(id = foto.image_path),
            contentDescription = "Foto Kategori",
            contentScale = ContentScale.Crop
        )
    }


}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun KontenFotoPreview(){
    KontenFotoView(DummyDataFoto().jelajah())
}