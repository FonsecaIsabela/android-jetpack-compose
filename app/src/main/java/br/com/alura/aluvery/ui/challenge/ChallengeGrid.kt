package br.com.alura.aluvery.ui.challenge

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.alura.aluvery.model.Product
import br.com.alura.aluvery.sampledata.sampleProducts
import br.com.alura.aluvery.ui.ui.AluveryTheme
import br.com.alura.aluvery.ui.ui.components.ProductItem


@Composable
fun ChallengeGrid(
    products: List<Product>
) {

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(16.dp),
    ) {
        //span = quantidade de colunas que o item vai ocupar
        item(span = {
            GridItemSpan(2)
        }) {
            Text("Todos produtos", fontSize = 32.sp)
        }
        items(products) { p ->
            ProductItem(produto = p)
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun ChallengeGridPreview() {
    AluveryTheme {
        Surface {
            ChallengeGrid(sampleProducts)
        }
    }
}