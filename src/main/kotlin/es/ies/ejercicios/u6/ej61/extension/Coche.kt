package es.ies.ejercicios.u6.ej61.extension

class Coche(marca: String, val modelo: String, combustible: String, val nPuertas: Int) : Vehiculo(marca, combustible) {

    fun abrirMaletero(): String {
        return "$marca $modelo abriendo maletero"
    }

    fun repostar(): String {
        return "$marca $modelo repostando $combustible"
    }

    fun encenderAireAcondicionado(): String {
        return "$marca $modelo: Aire acondicionado encendido"
    }

    override fun mover(): String {
        return "$marca $modelo: Coche circulando por carretera"
    }

    override fun mostrarInfo(): String {
        return "Coche $marca $modelo, $combustible, $nPuertas puertas"
    }

    fun lavarCoche(): String {
        return "$marca $modelo: Lavando coche"
    }
}