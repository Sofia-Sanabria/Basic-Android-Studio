package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeQuadrantTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){
                    GreetingCuadrante()
                }
            }
        }
    }
}

@Composable
fun Cuadrante(
    tittle: String,
    text: String,
    colorFondo: Color,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(colorFondo)
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                text = tittle,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(text = text)
        }
    }
}

@Composable
fun GreetingCuadrante() {
    Column(Modifier.fillMaxSize()) {
        Row(Modifier.weight(1f)) {
            Cuadrante(
                tittle = "Text composable",
                text = "Displays text and follows the recommended Material Design guidelines.",
                colorFondo = Color(0xFFEADDFF),
                modifier = Modifier.weight(1f)
            )
            Cuadrante(
                tittle = "Image composable",
                text = "Creates a composable that lays out and draws a given Painter class object.",
                colorFondo = Color(0xFFD0BCFF),
                modifier = Modifier.weight(1f)
            )
        }
        Row(Modifier.weight(1f)) {
            Cuadrante(
                tittle = "Row composable",
                text = "A layout composable that places its children in a horizontal sequence.",
                colorFondo = Color(0xFFB69DF8),
                modifier = Modifier.weight(1f)
            )
            Cuadrante(
                tittle = "Column composable",
                text = "A layout composable that places its children in a vertical sequence.",
                colorFondo = Color(0xFFF6EDFF),
                modifier = Modifier.weight(1f)
            )
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeQuadrantTheme {
        GreetingCuadrante()
    }
}