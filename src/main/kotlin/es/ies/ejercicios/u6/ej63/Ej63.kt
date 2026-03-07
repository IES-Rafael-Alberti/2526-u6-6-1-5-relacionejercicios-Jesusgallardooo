package es.ies.ejercicios.u6.ej63

/**
 * Ejercicio 6.3 — Incidencia de constructores en la herencia (RA7.c).
 *
 * Punto de partida: revisa `Figuras.kt` y completa lo indicado en `docs/ejercicios/6.3.md`.
 */
object Ej63

fun main() {

    println("Ejercicio 6.3 (plantilla)")
    println("- Completa la jerarquía y los constructores en `es.ies.ejercicios.u6.ej63`")
    println("- Añade logs en init/constructores para ver el orden de inicialización")
    println("- Actualiza este main para instanciar usando distintos constructores")


    println("<<< RECTANGULO >>>")
    val r1 = Rectangulo("rojo", "r1", 10, 5)

    println("\n<<< RECTANGULO SECUNDARIO >>>")
    val r2 = Rectangulo(4, 6)

    println("\n<<< CUADRADO >>>")
    val c1 = Rectangulo(5)

    println("\n<<< CIRCULO >>>")
    val cir = Circulo(8)

    println("\n<<< TRIANGULO >>>")
    val t1 = Triangulo(3, 4)

    println("\n<<< TRIANGULO EQUILATERO >>>")
    val t2 = Triangulo(5)
}
