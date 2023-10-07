package com.example.tugasweek4.data

import com.example.tugasweek4.model.Line_Chat

class DummyDataChats {
    fun get_data_line(): List<Line_Chat> {
        return listOf(
            Line_Chat("Lebron James",  "Practice starts in 10, where are you?", "4/10/2023"),
            Line_Chat("Kobe Bryant", "Hey, how's it going?", "3/10/2023"),
            Line_Chat("Michael Jordan", "I heard you had a great game last night!", "2/10/2023"),
            Line_Chat("Stephen Curry",  "Let's grab dinner tonight.", "1/10/2023"),
            Line_Chat("Kevin Durant", "Can you pass me the ball more often?", "30/9/2023"),
            Line_Chat("Magic Johnson", "We need to work on our defense.", "30/9/2023"),
            Line_Chat("Larry Bird",  "I'll be late for practice tomorrow.", "28/9/2023"),
            Line_Chat("Tim Duncan",  "I'm excited about the upcoming game.", "25/9/2023"),
            Line_Chat("Shaquille O'Neal",  "I need new sneakers.", "21/9/2023"),
            Line_Chat("Charles Barkley", "Let's hit the gym early.", "18/9/2023")
        )
    }
}