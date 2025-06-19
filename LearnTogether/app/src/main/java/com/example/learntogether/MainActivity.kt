package com.example.learntogether

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learntogether.ui.theme.LearnTogetherTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LearnTogetherTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){
                    GreetingImage(
                        tittle = stringResource(R.string.text_tittle),
                        textPresent = stringResource(R.string.text_present),
                        textContent = stringResource(R.string.text_content),
                        modifier = Modifier.padding(8.dp)

                    )
                }
            }
        }
    }
}

@Composable
fun GreetingText(tittle: String, textPresent: String, textContent: String, modifier: Modifier = Modifier) {
    Column (
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ){
        Text(
            text = tittle,
            fontSize = 24.sp,
            modifier = Modifier
                .padding(16.dp)
                .align(alignment = Alignment.CenterHorizontally)
        )
        Text(
            text = textPresent,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(16.dp)
        )
        Text(
            text = textContent,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(16.dp)
        )

    }
}

@Composable
fun GreetingImage(tittle: String, textPresent: String, textContent: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.bg_compose_background)
    Box(modifier) {
        Image(
            painter = image,
            contentDescription = null
        )
        GreetingText(
            tittle = tittle,
            textPresent = textPresent,
            textContent = textContent,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        )

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LearnTogetherTheme {
        GreetingImage(
            tittle = stringResource(R.string.text_tittle),
            textPresent = stringResource(R.string.text_present),
            textContent = stringResource(R.string.text_content)
        )
    }
}