package com.example.tugasweek4.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tugasweek4.data.DummyDataInstagram
import com.example.tugasweek4.model.Suggestion

@Composable
fun suggesInsView (Suggestion: List<Suggestion>){
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = Color.Black)
    ){
        LazyRow(
            modifier = Modifier
                .padding(10.dp,5.dp)
        ) {
            items (Suggestion){
                suggesCard(it,
                    Modifier
                        .fillMaxWidth()
                )
            }
        }
    }

}


@Composable
fun suggesCard (suggestion: Suggestion, modifier: Modifier = Modifier){
    Card (
        modifier = Modifier
            .padding(10.dp,10.dp,10.dp,10.dp)
    ) {
        Box(
            modifier = Modifier
                .border(1.dp, Color.White, shape = RoundedCornerShape(15.dp))
        ){
            Column (
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.Black)
                    .padding(10.dp, 15.dp, 10.dp, 15.dp)
            ){
                Image (
                    painter = painterResource(id = suggestion.foto_profile),
                    contentDescription = "Logo Instagram",
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = suggestion.nama,
                    fontSize = 13.sp,
                    color = Color.White,
                    modifier = Modifier
                        .padding(5.dp,5.dp),
                    fontWeight = FontWeight.Bold
                )
                Box(
                    modifier = Modifier
                        .background(color = Color.Blue, shape = RoundedCornerShape(8.dp)),
                    Alignment.Center
                ){
                    Text(
                        text = "Follow",
                        color = Color.Black,
                        modifier = Modifier
                            .padding(10.dp,5.dp,10.dp,5.dp),
                        fontSize = 10.sp

                    )
                }
            }
            Icon(
                imageVector = Icons.Filled.Close,
                contentDescription = "tombol",
                tint = Color.White,
                modifier = Modifier
                    .padding(87.dp,5.dp,10.dp,5.dp)

            )
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun suggesInsPreview(){
    suggesInsView(DummyDataInstagram().loadSuggestion())
}