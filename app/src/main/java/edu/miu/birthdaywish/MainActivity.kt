package edu.miu.birthdaywish

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.miu.birthdaywish.ui.theme.BirthdayWishTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BirthdayWishTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    Column (
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var textFieldState by remember { mutableStateOf("") }
        var text by remember { mutableStateOf("") }
        var showGift by remember { mutableStateOf(false) }
        val imageId = if (showGift) {
                R.drawable.smartwatch
            } else {
                R.drawable.gift
        }
        Text(
            text = "Birthday Greetings",
            color = Color.Blue,
            fontSize = 35.sp,
            modifier = modifier
        )
        Spacer(modifier = Modifier.height(40.dp))
        OutlinedTextField(
            value = textFieldState,
            onValueChange = { textFieldState = it },
            label = { Text("Enter your friend name") }
        )
        Spacer(modifier = Modifier.height(40.dp))
        Text(
            text = text,
            fontSize = 25.sp,
            color = Color.Blue
        )
        Spacer(modifier = Modifier.height(40.dp))
        Image(
            painter = painterResource(id = imageId),
            contentDescription = "gift"
        )
        Spacer(modifier = Modifier.height(40.dp))
        Button(
            onClick = { 
                text = "Happy Birthday $textFieldState"
                showGift = !showGift
            }
        ) {
            Text(text = "Surprise")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BirthdayWishTheme {
        Greeting()
    }
}