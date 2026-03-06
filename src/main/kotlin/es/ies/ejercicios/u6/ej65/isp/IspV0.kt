package es.ies.ejercicios.u6.ej65.isp

import es.ies.ejercicios.u6.ej64.Persona

/**
 * v0 (viola ISP): interfaz "gorda" que fuerza a implementar métodos que algunos clientes no necesitan.
 */

interface RepositorioLecturaPersonas {
    fun buscar(nombre: String): Persona?
}

interface RepositorioEscrituraPersonas {
    fun guardar(persona: Persona)
}

interface RepositorioExportacionPersonas {
    fun exportarCsv(): String
}

interface RepositorioBorradoPersonas {
    fun borrarTodo()
}

class RepositorioMemoria :
    RepositorioLecturaPersonas,
    RepositorioEscrituraPersonas,
    RepositorioExportacionPersonas,
    RepositorioBorradoPersonas {

    private val map = mutableMapOf<String, Persona>()

    override fun guardar(persona: Persona) {
        map[persona.nombre] = persona
    }

    override fun buscar(nombre: String): Persona? = map[nombre]

    override fun exportarCsv(): String =
        buildString {
            appendLine("nombre,edad")
            for (p in map.values) {
                appendLine("${p.nombre},${p.edad}")
            }
        }

    override fun borrarTodo() {
        map.clear()
    }
}


class BuscadorPersonas(private val repo: RepositorioLecturaPersonas) {
    fun buscar(nombre: String): Persona? = repo.buscar(nombre)
}

fun main() {
    val repo = RepositorioMemoria()
    repo.guardar(Persona("Ana", 20))

    val buscador = BuscadorPersonas(repo)

    println("Buscar Ana -> ${buscador.buscar("Ana")?.resumen()}")
}

