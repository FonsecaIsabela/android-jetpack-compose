package br.com.alura.aluvery.ui.ui.challenge

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.alura.aluvery.ui.ui.AluveryTheme

@Composable
fun MyFirstComposable() {
    Text(text = "Meu primeiro texto")
    Text(text = "Meu segundo texto maior")
}

@Preview(showBackground = true)
@Composable
fun MyFirstComposablePreviewLayout1() {
    Column {
        Text("Texto 1")
        Text("Texto 2")
    }
}

@Preview(showBackground = true)
@Composable
fun MyFirstComposablePreviewLayout2() {
    Row {
        Text("Texto 1")
        Text("Texto 2")
    }
}

@Preview(showBackground = true)
@Composable
fun MyFirstComposablePreviewLayout3() {
    Box {
        Text("Texto 1")
        Text("Texto 2")
    }
}

@Preview(showBackground = true)
@Composable
fun CustomLayoutPreview() {
    Column(modifier = Modifier
        .padding(8.dp)
        .background(Color.Blue)
        .padding(8.dp)
        .fillMaxSize()
    ) {
        Text("Texto 1")
        Text("Texto 2")
        Row(modifier = Modifier
            .padding(8.dp, 16.dp)
            .background(Color.Green)
            .fillMaxWidth(0.9f)) {
            Text("Texto 3")
            Text("Texto 4")
        }
        Box(modifier = Modifier
            .padding(8.dp)
            .background(Color.Red)
            .padding(8.dp)) {
            Row(modifier = Modifier
                .padding(8.dp)
                .background(Color.Cyan)
                .padding(8.dp)
                .fillMaxWidth()) {
                Text("Texto 5")
                Text("Texto 6")
            }
            Column(modifier = Modifier
                .padding(8.dp)
                .background(Color.Yellow)
                .padding(8.dp)){
                Text("Texto 7")
                Text("Texto 8")
            }
        }
    }
}


@Preview
@Composable
fun MyFirstComposablePreview() {
    AluveryTheme {
        Surface {
            Text(text = "Meu primeiro texto")
            Text(text = "Meu segundo texto maior")
        }
    }
}