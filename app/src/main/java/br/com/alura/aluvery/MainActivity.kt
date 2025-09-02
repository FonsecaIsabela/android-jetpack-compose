package br.com.alura.aluvery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Surface
import br.com.alura.aluvery.sampledata.sampleSections
import br.com.alura.aluvery.ui.ui.AluveryTheme
import br.com.alura.aluvery.ui.ui.Screens.HomeScreen

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AluveryTheme {
                Surface {
                    HomeScreen(
                        sections = sampleSections
                    )
                }
            }
        }
    }
}
