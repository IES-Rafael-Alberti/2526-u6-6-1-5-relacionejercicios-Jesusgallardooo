package es.ies.ejercicios.u6.ej65.lsp

import es.ies.ejercicios.u6.ej64.Persona

/**
 * Contrato: un repositorio que permite guardar y buscar personas.
 */

interface RepositorioLecturaPersonas {
    fun buscar(nombre: String): Persona?
}

interface RepositorioEscrituraPersonas {
    fun guardar(persona: Persona)
}


class RepositorioPersonas :
    RepositorioLecturaPersonas,
    RepositorioEscrituraPersonas {

    private val map = mutableMapOf<String, Persona>()

    override fun guardar(persona: Persona) {
        map[persona.nombre] = persona
    }

    override fun buscar(nombre: String): Persona? = map[nombre]
}

/**
 * v0 (posible violación de LSP): una subclase rompe el contrato esperado de "guardar".
 * El código cliente que acepta [RepositorioPersonasV0] puede fallar al sustituirlo por esta subclase.
 */


class RepositorioSoloLectura(
    private val datos: Map<String, Persona>
) : RepositorioLecturaPersonas {

    override fun buscar(nombre: String): Persona? = datos[nombre]
}


fun cliente(
    lectura: RepositorioLecturaPersonas,
    escritura: RepositorioEscrituraPersonas
) {
    escritura.guardar(Persona("Ana", 20))
    println("Buscar Ana -> ${lectura.buscar("Ana")?.resumen()}")
}

fun main() {

    println("[LSP] Repositorio normal")
    val repo = RepositorioPersonas()
    cliente(repo, repo)

    println("\n[LSP] Repositorio solo lectura")
    val soloLectura = RepositorioSoloLectura(mapOf("Ana" to Persona("Ana", 20)))

    println("Buscar Ana -> ${soloLectura.buscar("Ana")?.resumen()}")
}

