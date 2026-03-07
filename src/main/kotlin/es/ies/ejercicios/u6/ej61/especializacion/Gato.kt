package es.ies.ejercicios.u6.ej61.especializacion

class Gato(nombre: String):Animal(nombre) {

    override fun hacerSonido(): String {
        return "Meow... Meow..."
    }

    fun ronronear(): String{
        return "Rrrrrrr Rrrrrrrr Rrrrrrr... *ronroneo*"
    }

}