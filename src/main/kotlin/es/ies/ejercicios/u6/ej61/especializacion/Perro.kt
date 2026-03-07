package es.ies.ejercicios.u6.ej61.especializacion

class Perro(nombre:String): Animal(nombre) {

    override fun hacerSonido(): String {
        return "Wof Wof... wrrrrrr Wof..."
    }

    fun moverCola(): String{
        return "fiuh fiuh *mueve la cola*"
    }

}