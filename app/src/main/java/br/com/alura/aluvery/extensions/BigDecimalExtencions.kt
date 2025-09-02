package br.com.alura.aluvery.ui.ui.components.extencions

import android.icu.text.NumberFormat
import java.math.BigDecimal
import java.util.Locale

fun BigDecimal.toBrazilianCurrency(): String {
    return NumberFormat
        .getCurrencyInstance(Locale("pt", "br"))
        .format(this)
}