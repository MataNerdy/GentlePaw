package com.example.gentlepaws

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GentleApp()
        }
    }
}

@Composable
fun GentleApp() {
    val animals = listOf(
        R.drawable.puppy_1,
        R.drawable.kitten_1,
        R.drawable.sloth_1
    )

    val quotes = listOf(
        "Ты не обязан быть сильным сегодня.",
        "Ты заслуживаешь отдыха.",
        "Можно просто выдохнуть.",
        "Сегодня достаточно просто быть.",
        "Даже маленький шаг — уже шаг.",
        "С тобой уже всё не так уж плохо."
    )

    var currentAnimal by remember { mutableIntStateOf(animals.random()) }
    var currentQuote by remember { mutableStateOf(quotes.random()) }

    fun nextCard() {
        var newAnimal = currentAnimal
        while (newAnimal == currentAnimal && animals.size > 1) {
            newAnimal = animals[Random.nextInt(animals.size)]
        }

        var newQuote = currentQuote
        while (newQuote == currentQuote && quotes.size > 1) {
            newQuote = quotes[Random.nextInt(quotes.size)]
        }

        currentAnimal = newAnimal
        currentQuote = newQuote
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF9F4F6))
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Лапка поддержки 🐾",
            fontSize = 28.sp,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(24.dp))

        Card(
            shape = RoundedCornerShape(24.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(12.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = currentAnimal),
                    contentDescription = "animal",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(260.dp)
                        .clip(RoundedCornerShape(16.dp)),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = currentQuote,
                    fontSize = 22.sp,
                    textAlign = TextAlign.Center,
                    lineHeight = 30.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = { nextCard() },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFE6A8C2)
            )
        ) {
            Text(
                text = "Ещё",
                fontSize = 20.sp
            )
        }
    }
}