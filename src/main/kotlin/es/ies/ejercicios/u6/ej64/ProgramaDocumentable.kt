package es.ies.ejercicios.u6.ej64

/**
 * Representa un elemento que puede generar un resumen en texto.
 */
interface Resumible {
    fun resumen(): String
}


/**
 * Plantilla informe
 * Genera informes a partir de elementos (Resumible).
 *
 * Define el flujo de generación del informe y permite que las subclases
 * personalicen el formato de los elementos.
 */
abstract class PlantillaInforme : Resumible {
    fun generar(titulo: String, items: List<Resumible>): String {
        val sb = StringBuilder()

        sb.appendLine(cabecera(titulo))

        for (item in items) {
            sb.appendLine(formatearItem(item))
        }

        sb.appendLine(pie())
        return sb.toString()
    }

    protected open fun cabecera(titulo: String): String = titulo

    protected abstract fun formatearItem(item: Resumible): String

    protected open fun pie(): String = "-- fin --"

    override fun resumen(): String = "PlantillaInforme"
}

/**
 * Informe markdown
 * Implementa la clase [PlantillaInforme] para generar un informe en formato .md.
 *
 */
class InformeMarkdown : PlantillaInforme() {
    override fun cabecera(titulo: String): String = "# $titulo"

    override fun formatearItem(item: Resumible): String = "- ${item.resumen()}"
}

/**
 * Informe csv
 *Implementa la clase [PlantillaInforme] para generar un informe en formato csv.
 *
 */
class InformeCsv : PlantillaInforme() {
    override fun cabecera(titulo: String): String = "titulo,$titulo\nitem"

    override fun formatearItem(item: Resumible): String = item.resumen().replace(",", ";")
}

/**
 * Persona
 * Representa a una persona con [nombre] y [edad]
 *
 */
open class Persona(
    val nombre: String,
    val edad: Int,
) : Resumible {
    init {
        println("[Persona:init] nombre=$nombre edad=$edad")
    }

    constructor(nombre: String) : this(nombre, edad = 0) {
        println("[Persona:secondary] constructor(nombre)")
    }

    override fun resumen(): String = "$nombre ($edad)"
}

/**
 * Alumno
 * Especialización de la clase [Persona] que añade el curso del alumno.
 *
 */
class Alumno : Persona {
    val curso: String

    constructor(nombre: String, edad: Int, curso: String) : super(nombre, edad) {
        this.curso = curso
        println("[Alumno:secondary] nombre=$nombre edad=$edad curso=$curso")
    }

    constructor(nombre: String, curso: String) : this(nombre, edad = 0, curso = curso) {
        println("[Alumno:secondary] constructor(nombre, curso)")
    }

    override fun resumen(): String = "Alumno: ${super.resumen()} curso=$curso"
}


/**
 * Registro personas
 * Gestiona el registro y la búsqueda de personas por nombre normalizado.
 *
 */
class RegistroPersonas {
    private val personasPorNombre = mutableMapOf<String, Persona>()

    fun registrar(persona: Persona) {
        val clave = normalizarNombre(persona.nombre)
        personasPorNombre[clave] = persona
    }

    fun buscar(nombre: String): Persona? = personasPorNombre[normalizarNombre(nombre)]

    /**
     * Normalizar nombre
     * normaliza el nombre para evitar duplicados por mayúsculas o por espacios.
     *
     * @param nombre
     * @return nombre normalizado.
     */
    private fun normalizarNombre(nombre: String): String {
        return nombre.trim().lowercase()
    }
}
