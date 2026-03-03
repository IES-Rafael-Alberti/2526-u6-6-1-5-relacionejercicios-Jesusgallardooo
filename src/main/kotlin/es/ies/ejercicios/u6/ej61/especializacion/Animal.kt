package es.ies.ejercicios.u6.ej61.especializacion

open class Animal(val nombre: String){

    open fun hacerSonido(): String{
        return "$nombre hace un sonido!"
    }
}