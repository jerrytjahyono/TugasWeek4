package com.example.tugasweek4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.tugasweek4.data.DummyDataChats
import com.example.tugasweek4.data.DummyDataFoto
import com.example.tugasweek4.data.DummyDataInstagram
import com.example.tugasweek4.data.DummyDataToko
import com.example.tugasweek4.ui.theme.TugasWeek4Theme
import com.example.tugasweek4.ui.view.ChatsView
import com.example.tugasweek4.ui.view.InstagramView
import com.example.tugasweek4.ui.view.KontenFotoView
import com.example.tugasweek4.ui.view.TokoSetiaJayaView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TugasWeek4Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    InstagramView(DummyDataInstagram().loadFeed(), DummyDataInstagram().loadStory(), DummyDataInstagram().loadSuggestion())
                }
            }
        }
    }
}
