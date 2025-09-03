package br.com.alura.aluvery.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import br.com.alura.aluvery.dao.ProductDao
import br.com.alura.aluvery.ui.components.ProdutoFormScreen
import br.com.alura.aluvery.ui.ui.AluveryTheme

class ProdutoFormActivity : ComponentActivity() {

    private val dao = ProductDao()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AluveryTheme {
                Surface {
                    ProdutoFormScreen(onSaveClick = { product ->
                        dao.save(product)
                        finish()
                    })
                }
            }
        }
    }
}

