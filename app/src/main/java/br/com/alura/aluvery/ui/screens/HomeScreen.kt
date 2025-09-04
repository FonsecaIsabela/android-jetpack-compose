package br.com.alura.aluvery.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.alura.aluvery.model.Product
import br.com.alura.aluvery.sampledata.sampleCandies
import br.com.alura.aluvery.sampledata.sampleDrinks
import br.com.alura.aluvery.sampledata.sampleProducts
import br.com.alura.aluvery.sampledata.sampleSections
import br.com.alura.aluvery.ui.components.CardProductItem
import br.com.alura.aluvery.ui.components.SearchTextField
import br.com.alura.aluvery.ui.ui.AluveryTheme
import br.com.alura.aluvery.ui.ui.components.ProductsSection

//Responsabilidades do State Holder:
// State Holder deve ser o responsável em apresentar os dados, determinar o
//conteúdo que deve ser apresentado ou não, e também, implementar os
//eventos do composable.

class HomeScreenUiState(
    val sections: Map<String, List<Product>> = emptyMap(), // sessões
    val searchedProducts: List<Product> = emptyList(), // produtos que foram buscados
    val searchText: String = "", // teste de busca
    val onSearchChange: (String) -> Unit = {}
) { // evento quando a busca muda

    fun isShowSections(): Boolean {
        return searchText.isBlank()
    }
}

@Composable
fun HomeScreen(products: List<Product>) {

    val sections = mapOf(
        "Todos os produtos" to products,
        "Promoções" to sampleDrinks + sampleCandies,
        "Doces" to sampleCandies,
        "Bebidas" to sampleDrinks
    )

    var text by remember {
        mutableStateOf("")
    }

    fun constainsInNameOrDescrioption() = { product: Product ->
        product.name.contains(
            text,
            ignoreCase = true
        ) ||
                product.description?.contains(
                    text,
                    ignoreCase = true
                ) ?: false
    }

    val searchedProducts = remember(text, products) {
        if (text.isNotBlank()) {
            sampleProducts.filter(constainsInNameOrDescrioption()) + // lista de produtos já existente
                    products.filter(constainsInNameOrDescrioption()) // lista de produtos que foram adicionados
        } else emptyList()
    }

    val state = remember(products, text) {
        HomeScreenUiState(
            sections = sections, // lista de produtos já existente
            searchedProducts = searchedProducts, // lista de produtos que foram adicionados
            searchText = text, // estado da variavel
            onSearchChange = { // evento do composable
                text = it // atualiza o estado da variavel
            }
        )
    }
    HomeScreen(state = state)
}

@Composable
fun HomeScreen(
    state: HomeScreenUiState = HomeScreenUiState(),
) {
    Column {
        val sections = state.sections
        val text = state.searchText
        val searchedProducts = remember(text) {
            state.searchedProducts
        }
        SearchTextField(
            searchText = text,
            onSearchChange = state.onSearchChange,
            Modifier
                .padding(16.dp)
                .fillMaxWidth()
        )

        LazyColumn(
            Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(bottom = 16.dp)
        ) {
            if (state.isShowSections()) {
                for (section in sections) {
                    val title = section.key
                    val products = section.value
                    item {
                        ProductsSection(
                            title = title,
                            products = products
                        )
                    }
                }
            } else {
                items(searchedProducts) { p ->
                    CardProductItem(
                        product = p,
                        Modifier.padding(horizontal = 16.dp),
                    )
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun HomeScreenPreview(
) {
    AluveryTheme {
        Surface {
            HomeScreen(HomeScreenUiState(sections = sampleSections))
        }
    }
}

@Preview
@Composable
fun HomeScreenWithSearchTextPreview() {
    AluveryTheme {
        Surface {
            HomeScreen(
                state = HomeScreenUiState(
                    searchText = "a",
                    sections = sampleSections
                )
            )
        }

    }
}