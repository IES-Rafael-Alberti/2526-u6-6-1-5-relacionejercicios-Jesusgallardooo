package es.ies.ejercicios.u6.ej61.especializacion

fun main() {
    println("=== ESPECIALIZACIÓN: ANIMALES ===")

    val animal1: Animal = Perro("Snoopy")
    val animal2: Animal = Gato("Garfield")
    val animal3: Animal = Perro("Rex")

    // Comportamiento especializado
    println(animal1.nombre + ": " + animal1.hacerSonido())
    println(animal2.nombre + ": " + animal2.hacerSonido())
    println(animal3.nombre + ": " + animal3.hacerSonido())

    println("\n--- Métodos específicos ---")

    if (animal1 is Perro) {
        println(animal1.nombre + ": " + animal1.moverCola())
    }

    if (animal2 is Gato) {
        println(animal2.nombre + ": " + animal2.ronronear())
    }

}