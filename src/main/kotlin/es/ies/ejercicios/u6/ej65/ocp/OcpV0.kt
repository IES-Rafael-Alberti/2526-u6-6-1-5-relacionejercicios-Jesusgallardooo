package es.ies.ejercicios.u6.ej65.ocp

import es.ies.ejercicios.u6.ej64.Resumible
/**
 * v0 (viola OCP): para añadir un nuevo formato hay que modificar este `when`.
 */

interface FormatoInforme {
    fun generar(titulo: String, items: List<Resumible>): String
}

class InformeCsv : FormatoInforme {

    override fun generar(titulo: String, items: List<Resumible>): String =
        buildString {
            appendLine("titulo,$titulo")
            appendLine("item")
            for (item in items) {
                appendLine(item.resumen().replace(",", ";"))
            }
        }
}

class InformeMarkdownFormato : FormatoInforme {

    override fun generar(titulo: String, items: List<Resumible>): String =
        buildString {
            appendLine("# $titulo")
            for (item in items) {
                appendLine("- ${item.resumen()}")
            }
        }
}

class GeneradorInforme {
    fun generar(formato: FormatoInforme, titulo: String, items: List<Resumible>): String {
        return formato.generar(titulo, items)
    }
}

fun main() {

    val items = listOf<Resumible>(
        object : Resumible {
            override fun resumen(): String = "Elemento A"
        },
        object : Resumible {
            override fun resumen(): String = "Elemento B"
        },
    )

    val generador = GeneradorInforme()

    val formato: FormatoInforme = InformeMarkdownFormato()
    // val formato: FormatoInforme = InformeCsv() //otra opción de formato.

    println(generador.generar(formato, "Demo OCP", items))
}

