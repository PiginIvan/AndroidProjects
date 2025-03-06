package com.example.lab3.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lab3.Greeting

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                ) {
                    CounterScreen()
                }
            }
        }
    }
}

@Composable
fun CounterScreen() {
    var count by remember { mutableIntStateOf(0) }

    Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
    ) {
        Card(
                modifier = Modifier.padding(16.dp),
                shape = RoundedCornerShape(16.dp),
                elevation = CardDefaults.cardElevation(8.dp)
        ) {
            Column(
                    modifier = Modifier.padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Текущее значение:", style = MaterialTheme.typography.headlineMedium)
                Text("$count", style = MaterialTheme.typography.displayLarge)

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    CounterButton(text = "-", onClick = { count = Greeting().dec(count) })
                    CounterButton(text = "+", onClick = { count = Greeting().inc(count) })
                    CounterButton(text = "🎲", onClick = { count = Greeting().random() })
                }
            }
        }
    }
}

@Composable
fun CounterButton(text: String, onClick: () -> Unit) {
    Button(
            onClick = onClick,
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.size(60.dp)
    ) {
        Text(text, style = MaterialTheme.typography.bodyLarge)
    }
}

@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        CounterScreen()
    }
}