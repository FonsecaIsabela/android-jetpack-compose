package br.com.alura.aluvery.ui.ui.challenge

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.alura.aluvery.R

@Preview(showBackground = true)
@Composable
fun ChallengeKitsPreview() {
    Surface(
        Modifier
            .padding(8.dp),
        shape = RoundedCornerShape(8.dp),
        shadowElevation = 4.dp
    ) {
        Row(
            Modifier
                .height(200.dp)
                .fillMaxWidth()
        ) {
            val imageSize = 100.dp
            Box(
                Modifier
                    .fillMaxHeight()
                    .width(imageSize)
                    .background(Brush.verticalGradient(listOf(
                        MaterialTheme.colorScheme.primary,
                        MaterialTheme.colorScheme.secondary)))
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = null,
                    Modifier
                        .size(imageSize)
                        .align(Alignment.Center)
//                        .offset(x = 50.dp,y = (-50).dp)
                        .offset(imageSize / 2)
                        .clip(CircleShape)
                        .border(BorderStroke(2.dp, Brush.verticalGradient(listOf(
                            MaterialTheme.colorScheme.primary,
                            MaterialTheme.colorScheme.secondary))), CircleShape))

            }
            Spacer(modifier = Modifier.width(imageSize / 2)) // Espaçamento entre a imagem e o texto
            Column(
                Modifier
                    .padding(16.dp)
                    .fillMaxHeight()
                    .padding(16.dp)
                    .align(Alignment.CenterVertically)
            ) {
                Text(
                    text = LoremIpsum(50).values.first(),
                    overflow = TextOverflow.Ellipsis,
                    lineHeight = 20.sp
                )
            }
        }

    }
}