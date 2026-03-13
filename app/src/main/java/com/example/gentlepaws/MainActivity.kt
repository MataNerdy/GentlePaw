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
    var showWelcome by remember { mutableStateOf(true) }

    if (showWelcome) {
        WelcomeScreen(
            onStartClick = { showWelcome = false }
        )
    } else {
        SupportScreen()
    }
}


@Composable
fun WelcomeScreen(onStartClick: () -> Unit) {
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
            fontSize = 30.sp,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Маленькое место, где тебя ждут тепло, зверушки и добрые слова.",
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            color = Color(0xFF6B5B63),
            lineHeight = 26.sp
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = onStartClick,
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFE6A8C2)
            )
        ) {
            Text(
                text = "Нажми, если нужна лапка поддержки",
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }
    }
}

@Composable
fun SupportScreen() {
    val animals = listOf(
        R.drawable.puppy_1,
        R.drawable.kitten_1,
        R.drawable.sloth_1,
        R.drawable.kitten_2,
        R.drawable.puppy_2,
        R.drawable.kitten_3,
        R.drawable.sloth_2,
        R.drawable.kitten_4,
        R.drawable.snake_1,
        R.drawable.snake_2,
        R.drawable.fox_1
    )

    val quotes = listOf(
        "Ты не обязан быть сильным сегодня.",
        "Ты заслуживаешь отдыха.",
        "Сегодня достаточно просто быть.",
        "Даже маленький шаг - уже шаг.",
        "Даже если сейчас тяжело, ты всё равно важен.",
        "Ты достоин любви и тепла.",
        "Ты не обязан быстро прийти в норму.",
        "Твои чувства имеют значение.",
        "Тебе не нужно быть неуязвимым.",
        "Ты заслуживаешь бережного отношения.",
        "Тебе можно грустить столько, сколько нужно.",
        "Ты не заслужил боли, которую тебе причинили.",
        "Ты не обязан всегда со всем справляться.",
        "Ты - моя стая.",
        "Тебя правда достаточно.",
        "Тебя любят."
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

        Spacer(modifier = Modifier.height(24.dp))

        Card(
            shape = RoundedCornerShape(24.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = currentAnimal),
                    contentDescription = "animal",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(600.dp)
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
                fontSize = 18.sp
            )
        }
    }
}