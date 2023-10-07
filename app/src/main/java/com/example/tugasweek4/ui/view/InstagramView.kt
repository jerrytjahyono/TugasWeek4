package com.example.tugasweek4.ui.view

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tugasweek4.R
import com.example.tugasweek4.data.DummyDataInstagram
import com.example.tugasweek4.model.Feed
import com.example.tugasweek4.model.Story
import com.example.tugasweek4.model.Suggestion

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun InstagramView(FeedList: List<Feed>, StoryList: List<Story>, SuggestionList: List<Suggestion>){

    Scaffold (
        bottomBar = {
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color(0xFF000000), shape = RectangleShape)
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
    ) {
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = Color.Black)
    ){
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ){
            item {
                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxSize(1f)
                        .padding(10.dp, 10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,

                ){
                    Image(
                        painter = painterResource(id = R.drawable.logo_instagram),
                        contentDescription = "Logo Instagram",
                        colorFilter = ColorFilter.tint(Color.White)
                    )

                    Row {
                        Image (
                            painter = painterResource(id = R.drawable.like),
                            contentDescription = "Logo Instagram",
                            modifier = Modifier
                                .padding(horizontal = 27.dp)
                        )

                        Image (
                            painter = painterResource(id = R.drawable.dm),
                            contentDescription = "Logo Instagram",
                            colorFilter = ColorFilter.tint(Color.White),
                        )
                    }

                }
            }
            item {
                LazyRow {
                    item {
                        val context = LocalContext.current
                        Column (
                            horizontalAlignment = Alignment.CenterHorizontally,modifier = Modifier
                                .padding(10.dp, 0.dp, 5.dp, 0.dp)
                                .clickable(
                                    onClick = {
                                        Toast
                                            .makeText(context, "your story", Toast.LENGTH_LONG)
                                            .show()
                                    }
                                )
                        ){
                            Box {
                                Image (
                                    painter = painterResource(id = R.drawable.ic_navbarperson),
                                    contentDescription = "Logo Instagram",
                                    colorFilter = ColorFilter.tint(Color.White),
                                    modifier = Modifier
                                        .size(80.dp)
                                )
                                Image (
                                    painter = painterResource(id = R.drawable.story),
                                    contentDescription = "Logo Instagram",
                                    modifier = Modifier
                                        .size(80.dp)
                                )
                            }
                            Text(
                                text = "Your Story",
                                color = Color.White,
                                fontSize = 10.sp,
                                modifier = Modifier
                                    .padding(vertical = 5.dp)
                            )
                        }
                    }
                    items(StoryList){
                        storyCard(it)
                    }
                }
            }
            FeedList.forEachIndexed {
                index, feed -> item { 
                    feedCard(feed = feed)
            }
                if (index % 6 == 0 ){
                    item {
                        LazyRow(
                            modifier = Modifier
                                .fillMaxWidth()
                        ){
                            items(SuggestionList){
                                suggestionCard(suggestion = it)
                            }
                        }
                    }
                }
            }
        }
    }
    }
}

@Composable
fun feedCard (feed: Feed){

    var isExpanded by remember { mutableStateOf(false) }

    Card (
        Modifier
            .padding(vertical = 10.dp)
    ){
        Column (
            modifier = Modifier
                .background(color = Color.Black)
                .fillMaxWidth()
        ){
            Row (
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row {
                    Image(
                        painter = painterResource(id = feed.foto_profile),
                        contentDescription = "Logo Instagram",
                        modifier = Modifier
                            .padding(10.dp)
                            .size(40.dp)
                            .clip(CircleShape),
                        contentScale = ContentScale.Crop
                    )
                    Text(
                        text = feed.nama,
                        fontSize = 13.sp,
                        color = Color.White,
                        modifier = Modifier
                            .padding(0.dp, 20.dp, 0.dp, 0.dp)

                    )
                }
                Icon(
                    imageVector = Icons.Filled.MoreVert,
                    contentDescription = "tombol",
                    tint = Color.White,
                    modifier = Modifier
                        .padding(0.dp, 20.dp, 10.dp, 0.dp)
                        .size(30.dp)

                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
            ){
                val context = LocalContext.current
                Image (
                    painter = painterResource(id = feed.foto_konten),
                    contentDescription = "Logo Instagram",
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable(
                            onClick = {
                                Toast
                                    .makeText(context, "Upload", Toast.LENGTH_LONG)
                                    .show()
                            }
                        ),
                    contentScale = ContentScale.Crop
                )
            }
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp, 10.dp, 10.dp, 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Row {
                    val context = LocalContext.current

                    if (!feed.love) {
                        Image(
                            painter = painterResource(id = R.drawable.like),
                            contentDescription = "Logo Instagram",
                            Modifier.padding(horizontal = 10.dp)
                        )
                    } else {
                        Image(
                            painter = painterResource(id = R.drawable.like_red),
                            contentDescription = "Logo Instagram",
                            Modifier.padding(horizontal = 10.dp)
                        )
                    }
                    Image (
                        painter = painterResource(id = R.drawable.comment),
                        contentDescription = "Logo Instagram",
                        modifier = Modifier
                            .padding(horizontal = 10.dp)
                            .clickable(
                                onClick = {
                                    Toast
                                        .makeText(context, "Comment Button", Toast.LENGTH_LONG)
                                        .show()
                                }
                            )
                    )

                    Image (
                        painter = painterResource(id = R.drawable.messanger),
                        contentDescription = "Logo Instagram",
                        modifier = Modifier
                            .padding(horizontal = 10.dp)
                            .clickable(
                                onClick = {
                                    Toast
                                        .makeText(context, "Share Button", Toast.LENGTH_LONG)
                                        .show()
                                }
                            )

                    )

                }
                if (!feed.bookMark){
                Image (
                        painter = painterResource(id = R.drawable.save),
                        contentDescription = "Logo Instagram"
                    )
                } else {
                    Image (
                        painter = painterResource(id = R.drawable.saved_light),
                        contentDescription = "Logo Instagram",
                        Modifier.padding(horizontal = 10.dp)
                    )
                }
            }

            if (feed.like > 1) {
                Text(
                    text = "${feed.like} likes",
                    color = Color.White,
                    fontSize = 13.sp,
                    modifier = Modifier
                        .padding(horizontal = 10.dp)
                )
            }else{
                Text(text = "${feed.like} likes",
                color = Color.White,
                fontSize = 13.sp,
                modifier = Modifier
                    .padding(horizontal = 10.dp)
                )
            }

            Column (
                modifier = Modifier.clickable { isExpanded = !isExpanded}
            ){
                Text(
                    text = "${feed.nama} ${feed.caption}",
                    modifier = Modifier
                        .padding(10.dp,2.dp),
                    maxLines = if (isExpanded) Int.MAX_VALUE else 2,
                    color = Color.White
                )
            }

            if (feed.tanggal.contains("2023")) {
                Text(
                    text = feed.getBulan(feed.tanggal),
                    modifier = Modifier
                        .padding(horizontal = 10.dp),
                    fontSize = 10.sp
                )
            } else {
                Text(
                    text = feed.getTanggal(feed.tanggal),
                    modifier = Modifier
                        .padding(horizontal = 10.dp),
                    fontSize = 10.sp
                )
            }

        }
    }

}

@Composable
fun storyCard (story: Story){
    val context = LocalContext.current
    Card {
        Modifier
            .background(Color.Black)
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .background(Color.Black)
                .padding(horizontal = 5.dp)
                .clickable(
                    onClick = {
                        Toast
                            .makeText(context, "${story.nama} story", Toast.LENGTH_LONG)
                            .show()
                    }
                )
        ){
            Box (
                modifier = Modifier
                .aspectRatio(1f)
            ){
                Image (
                    painter = painterResource(id = story.foto_profile),
                    contentDescription = "Logo Instagram",
                    modifier = Modifier
                        .size(80.dp)
                        .clip(CircleShape)
                        .border(6.dp, color = Color.Black, shape = CircleShape),
                    contentScale = ContentScale.Crop
                )
                Image (
                    painter = painterResource(id = R.drawable.story),
                    contentDescription = "Logo Instagram",
                    modifier = Modifier
                        .size(80.dp)
                )
            }
            Text(
                text = story.nama,
                fontSize = 10.sp,
                color = Color.White,
                modifier = Modifier
                    .padding(vertical = 5.dp)
            )

        }
    }
}

@Composable
fun suggestionCard (suggestion: Suggestion, modifier: Modifier = Modifier){
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
fun InstagramPreview(){
    InstagramView(DummyDataInstagram().loadFeed(), DummyDataInstagram().loadStory(), DummyDataInstagram().loadSuggestion())
}