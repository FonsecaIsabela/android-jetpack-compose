package br.com.alura.aluvery.ui.ui.challenge

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun ChanllengeComponents() {
    Row(modifier = Modifier
        .fillMaxWidth()
        .height(150.dp)) {
        Box(modifier = Modifier
            .fillMaxHeight()
            .width(100.dp)
            .background(Color.Blue))

        Column{
            Text("Texto 1",
            Modifier
                .fillMaxWidth()
                .background(Color.Gray)
                .padding(16.dp)
            )
            Text("Texto 2", Modifier.padding(16.dp))
        }
    }
}