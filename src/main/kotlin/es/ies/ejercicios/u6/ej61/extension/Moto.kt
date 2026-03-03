package es.ies.ejercicios.u6.ej61.extension

class Moto(marca: String, val modelo: String, combustible: String, val tieneSidecar: Boolean) : Vehiculo(marca, combustible) {

    fun hacerCaballito(): String {
        return "$marca $modelo haciendo el caballito"
    }

    fun apoyarPata(): String {
        return "$marca $modelo apoyando la pata de cabra"
    }

    fun ponerCasco(): String {
        return "Te pones el casco para conducir la $marca $modelo"
    }

    override fun mover(): String {
        return "$marca $modelo: Moto circulando"
    }

    override fun mostrarInfo(): String {
        val sidecar = if (tieneSidecar) "con sidecar" else "sin sidecar"
        return "Moto $marca $modelo $sidecar, combustible: $combustible"
    }
}