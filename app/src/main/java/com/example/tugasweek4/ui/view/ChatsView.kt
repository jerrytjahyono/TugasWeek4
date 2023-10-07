package com.example.tugasweek4.ui.view

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tugasweek4.data.DummyDataChats
import com.example.tugasweek4.model.Line_Chat

@Composable
fun ChatsView (chatsList: List<Line_Chat>){
    Column (
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(color = Color.Black)
    ) {
        Row {
            Text(
                text = "Chats",
                fontSize = 18.sp,
                fontWeight = Bold,
                color = Color.White,
                modifier = Modifier
                    .padding(20.dp,20.dp)
            )
            Icon(
                imageVector = Icons.Filled.MoreVert,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(240.dp, 20.dp, 0.dp, 0.dp),
                tint = Color.White
            )
        }
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
            ){
                items(chatsList){
                    ChatCard(it,
                        Modifier
                            .padding(8.dp)
                            .fillMaxSize())
                }
            }

    }

}

@Composable
fun ChatCard(chats: Line_Chat, modifier: Modifier = Modifier){

    val context = LocalContext.current
    Row(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(20.dp, 10.dp)
            .clickable(
                onClick = {
                    Toast.makeText(context,"${chats.nama} Clicked",Toast.LENGTH_LONG).show()
                }
            ),
            verticalAlignment = Alignment.CenterVertically
        ){
            Icon(
                imageVector = Icons.Filled.AccountCircle,
                contentDescription = "Profile Picture",
                tint = Color.White,
                modifier = Modifier
                    .size(60.dp,60.dp)

            )
            Column (
                modifier = Modifier
                    .weight(1f)
                    .padding(10.dp, 10.dp),

            ){
                Text(
                    text = chats.nama,
                    color = Color.White,
                    fontSize = 15.sp,
                    fontWeight = Bold,
                )
                Text(
                    text = chats.pesan,
                    color = Color.White,
                    fontSize = 15.sp
                )

            }
            Text(
                text = chats.waktu,
                color = Color.White,
                fontSize = 10.sp
            )

        }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ChatsPreview(){
    ChatsView(DummyDataChats().get_data_line())
}


