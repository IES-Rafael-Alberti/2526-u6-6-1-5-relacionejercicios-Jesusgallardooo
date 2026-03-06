package es.ies.ejercicios.u6.ej65.srp

import es.ies.ejercicios.u6.ej64.Alumno
import es.ies.ejercicios.u6.ej64.InformeMarkdown
import es.ies.ejercicios.u6.ej64.Persona
import es.ies.ejercicios.u6.ej64.RegistroPersonas
import es.ies.ejercicios.u6.ej64.Resumible

/**
 * v0 (mejorable): demasiadas responsabilidades mezcladas:
 * - prepara datos
 * - normaliza y registra personas
 * - genera informe
 * - hace logs
 */

// única responsabilidad: crear o preparar los datos.
class PreparadorDatos {
    fun obtenerItems(): List<Resumible> {
        return listOf(
            Persona(" Ana ", 20),
            Alumno("Luis", 19, "1DAM"),
            Persona("Marta", 18),
        )
    }
}

// única responsabilidad: gestionar el registro de personas
class ServicioRegistro {
    private val registro = RegistroPersonas()

    fun registrarPersonas(items: List<Resumible>) {
        for (item in items) {
            if (item is Persona) registro.registrar(item)
        }
    }

    fun buscar(nombre: String): Persona? {
        return registro.buscar(nombre)
    }
}

// única responsabilidad: crear el informe
class GeneradorInforme {
    fun generar(items: List<Resumible>): String {
        val informe = InformeMarkdown()
        return informe.generar("Listado", items)
    }
}

// única responsabilidad: coordinar los servicios, no abarca todas las funcionaliades.
class InformeAppService {
    fun ejecutar() {

        println("[SRP] Preparando datos...")
        val preparador = PreparadorDatos()
        val items = preparador.obtenerItems()

        println("[SRP] Registrando personas...")
        val servicioRegistro = ServicioRegistro()
        servicioRegistro.registrarPersonas(items)

        println("[SRP] Generando informe Markdown...")
        val generador = GeneradorInforme()
        val salida = generador.generar(items)

        println("[SRP] Resultado:")
        println(salida)

        println("[SRP] Buscar 'ana' -> ${servicioRegistro.buscar("ana")?.resumen()}")
    }
}

fun main() {
    InformeAppService().ejecutar()
}

