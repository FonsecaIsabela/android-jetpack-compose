package br.com.alura.aluvery.ui.components

import android.icu.text.DecimalFormat
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.alura.aluvery.R
import br.com.alura.aluvery.model.Product
import br.com.alura.aluvery.ui.ui.AluveryTheme
import coil.compose.AsyncImage
import java.math.BigDecimal


class ProdutoFormUiSate(
    val url: String = "",
    val name: String = "",
    val price: String = "",
    val description: String = "",
    val isShowPreview: Boolean = url.isNotBlank(),
    val onUrlChange: (String) -> Unit = {},
    val onNameChange: (String) -> Unit = {},
    val onPriceChange: (String) -> Unit = {},
    val onDescriptionChange: (String) -> Unit = {}
)

@Composable
fun ProdutoFormScreen(
    onSaveClick: (Product) -> Unit = {}
) {
    var url by remember { // estado da variavel
        mutableStateOf("")
    }

    var name by remember { // estado da variavel
        mutableStateOf("")
    }

    var price by remember { // estado da variavel
        mutableStateOf("")
    }

    var description by remember { // estado da variavel
        mutableStateOf("")
    }

    val formatter = remember { // estado da variavel
        DecimalFormat("#.##") // formata o valor para o padrão da moeda
    }

    ProdutoFormScreen(
        state = ProdutoFormUiSate(
            url = url,
            name = name,
            price = price,
            description = description,
            onUrlChange = {
                url = it
            },
            onNameChange = {
                name = it
            },
            onPriceChange = {
                try {
                    price = formatter.format(BigDecimal(it))
                } catch (e: IllegalArgumentException) {
                    if (it.isBlank()) {
                        price = it
                    }
                }
            },
            onDescriptionChange = {
                description = it
            }
        ),
        onSaveClick = {
            val convertedPrice = try {
                BigDecimal(price)
            } catch (e: NumberFormatException) {
                BigDecimal.ZERO
            }
            val product = Product(
                name = name,
                image = url,
                price = convertedPrice,
                description = description
            )
            onSaveClick(product)
        }
    )

}

@Composable
fun ProdutoFormScreen(
    state: ProdutoFormUiSate = ProdutoFormUiSate(),
    onSaveClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    val url = state.url
    val name = state.name
    val price = state.price
    val description = state.description

    Column(
        modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
            .verticalScroll(rememberScrollState()), // faz com que a tela rola
        verticalArrangement = Arrangement.spacedBy(16.dp) // espaçamento entre todos os elementos vertical
    ) {
        Spacer(modifier)
        Text(
            text = "Criando o produto",
            Modifier
                .fillMaxWidth(), fontSize = 28.sp
        )
        if (url.isNotBlank()) {
            AsyncImage(
                model = url, contentDescription = null,
                Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop, // redimensiona a imagem para caber na tela
                placeholder = painterResource(id = R.drawable.placeholder), // imagem de carregamento
                error = painterResource(id = R.drawable.placeholder) // imagem de erro
            )
        }
        TextField(
            value = url,
            onValueChange = state.onUrlChange,
            Modifier.fillMaxWidth(),
            label = {
                Text(text = "Url da imagem")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Uri,
                imeAction = ImeAction.Next
            )
        )
        TextField(
            value = name,
            onValueChange = state.onNameChange,
            Modifier.fillMaxWidth(),
            label = {
                Text(text = "Nome")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next,
                capitalization = KeyboardCapitalization.Words
            )
        )
        TextField(
            value = price,
            onValueChange = state.onPriceChange,
            Modifier.fillMaxWidth(),
            label = {
                Text(text = "Preço")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Decimal,
                imeAction = ImeAction.Next
            )
        )
        TextField(
            value = description,
            onValueChange = state.onDescriptionChange,
            Modifier
                .fillMaxWidth()
                .heightIn(100.dp),
            label = {
                Text(text = "Descrição")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                capitalization = KeyboardCapitalization.Sentences
            )
        )
        Button(
            onClick = onSaveClick,
            Modifier.fillMaxWidth()
        ) {
            Text(text = "Salvar")
        }
        Spacer(modifier)
    }
}

@Preview(showSystemUi = true)
@Composable
fun ProdutoFormScreenPreview() {
    AluveryTheme {
        Surface {
            ProdutoFormScreen(state = ProdutoFormUiSate())
        }
    }
}