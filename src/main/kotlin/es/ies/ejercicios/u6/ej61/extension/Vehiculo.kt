package es.ies.ejercicios.u6.ej61.extension

open class Vehiculo(val marca: String, val combustible: String) {
    open fun mover(): String {
        return "$marca: Vehículo en movimiento"
    }

    fun detener(): String {
        return "$marca: Vehículo detenido"
    }

    open fun mostrarInfo(): String {
        return "Vehículo $marca, combustible: $combustible"
    }
}