package com.example.gentlepaws

import android.os.Bundle
import androidx.compose.foundation.layout.Box
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
                text = "Нажми сюда",
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
        R.drawable.fox_1,
        R.drawable.fenec_1,
        R.drawable.lynx_1,
        R.drawable.lynx_2,
        R.drawable.linx_3,
        R.drawable.robot_2,
        R.drawable.sloth_3,
        R.drawable.snowcat_1,
        R.drawable.snowcat_2,
        R.drawable.wolf_1,
    )

    val quotes = listOf(
        "Ты не обязан быть сильным сегодня.",
        "Ты заслуживаешь отдыха.",
        "Сегодня достаточно просто быть.",
        "Даже маленький шаг — уже шаг.",
        "Даже если сейчас тяжело, ты всё равно важен.",
        "Ты достоин любви и тепла.",
        "Тебе можно быть неидеальным.",
        "Твои чувства имеют значение.",
        "Тебе не нужно быть неуязвимым.",
        "Ты заслуживаешь бережного отношения.",
        "Ты не обязан всегда со всем справляться.",
        "Ты — моя стая.",
        "Тебя правда достаточно.",
        "Тебя любят.",
        "Ты — котик, и у тебя все получится.",
        "Тебе можно остановиться и позаботиться о себе.",
        "Ты имеешь право быть бережным к себе.",
        "Иногда самое важное — это просто дать себе передышку.",
        "Можно не торопиться. Твоё восстановление важно.",
        "Тебе можно выбрать мягкость вместо усилия.",
        "Ты заслуживаешь отдыха.",
        "Забота о себе — это не слабость.",
        "Ты имеешь право на паузу.",
        "Ты важен просто потому, что ты есть.",
        "Твоя жизнь имеет значение.",
        "Твои чувства не случайны и не лишние.",
        "Твоё присутствие в этом мире драгоценно.",
        "Твой путь важен.",
        "Ты не обязан доказывать свою ценность.",
        "Ты уже достаточно ценен.",
        "Твои старания заметны.",
        "Ты имеешь право быть уставшим.",
        "Твои усилия не проходят мимо.",
        "Тебя можно увидеть настоящим.",
        "Твоя искренность ценна и заметна.",
        "Тебя принимают не только когда ты идеален",
        "Ты дорог и ценен.",
        "Твоё тепло имеет значение для других.",
        "Кто-то очень рад тому, что ты есть.",
        "Тебе не нужно ломать себя, чтобы стать лучше.",
        "Ты не обязан превращаться в идеальную версию себя.",
        "Рост может быть мягким.",
        "Твоя ценность не зависит от продуктивности.",
        "Ты не проект, который нужно бесконечно улучшать.",
        "Иногда достаточно просто быть.",
        "Ты имеешь право на уважение и признание.",
        "Ты — человек, а не функция.",
        "Можно выдохнуть.",
        "Тебе можно быть собой.",
        "Тебя достаточно.",
        "Ты не обязан быть идеальным.",
        "Можно быть живым, а не сильным.",
        "Ты не один.",
        "Ты не обязан всё выдерживать.",
        "Ты важен.",
        "Можно на время отпустить напряжение.",
        "Иногда достаточно просто пережить этот день.",
        "Ты достоин любви и заботы.",
        "Тебя можно любить таким, какой ты есть.",
        "Ты уже пережил многое — и всё ещё здесь.",
        "Твоя стойкость заслуживает уважения.",
        "Ты справишься.",
        "Многие бури достаточно просто переждать"
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

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = currentAnimal),
            contentDescription = "animal",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0x11000000))
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(60.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ) {
            Card(
                shape = RoundedCornerShape(24.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White.copy(alpha = 0.2f))
                        .padding(24.dp),
                ) {
                    Text(
                        text = currentQuote,
                        modifier = Modifier.fillMaxWidth(),
                        fontSize = 22.sp,
                        textAlign = TextAlign.Center,
                        lineHeight = 30.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = { nextCard() },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFE6A8C2)
                ),
                shape = RoundedCornerShape(20.dp)
            ) {
                Text(
                    text = "Ещё",
                    fontSize = 18.sp
                )
            }
        }
    }
}