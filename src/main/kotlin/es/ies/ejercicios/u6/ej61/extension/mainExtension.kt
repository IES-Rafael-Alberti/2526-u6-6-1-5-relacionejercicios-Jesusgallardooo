package es.ies.ejercicios.u6.ej61.extension


fun main() {
    println("=================================")
    println("EXTENSIÓN: VEHÍCULOS")
    println("=================================")

    val vehiculo1: Vehiculo = Coche("Seat", "Ibiza", "gasolina", 2)
    val vehiculo2: Vehiculo = Moto("Yamaha", "aerox", "gasolina", false)
    val vehiculo3: Vehiculo = Coche("BMW", "x6", "diesel", 4)

    println("\n--- Comportamiento común (polimorfismo) ---")
    vehiculo1.mostrarInfo()
    vehiculo1.mover()

    println()
    vehiculo2.mostrarInfo()
    vehiculo2.mover()

    println()
    vehiculo3.mostrarInfo()
    vehiculo3.mover()

    println("\n--- Comportamiento específico (EXTENSIÓN) ---")

    if (vehiculo1 is Coche) {
        println("${vehiculo1.marca}: Extendiendo funcionalidad de Coche")
        vehiculo1.repostar()
        vehiculo1.abrirMaletero()
        vehiculo1.encenderAireAcondicionado()
        println("  → Este coche tiene ${vehiculo1.nPuertas} puertas")
    }

    println()

    if (vehiculo2 is Moto) {
        println("${vehiculo2.marca}: Extendiendo funcionalidad de Moto")
        vehiculo2.hacerCaballito()
        vehiculo2.apoyarPata()
        if (vehiculo2.tieneSidecar) {
            println("  → Esta moto tiene sidecar")
        } else {
            println("  → Esta moto no tiene sidecar")
        }
    }

    println()

    if (vehiculo3 is Coche) {
        println("${vehiculo3.marca}: Extendiendo funcionalidad de Coche")
        vehiculo3.repostar()
        vehiculo3.lavarCoche()
        println("  → Este coche es un deportivo de ${vehiculo3.nPuertas} puertas")
    }

    println("\n=================================")
    println("FIN DEL EJEMPLO DE EXTENSIÓN")
    println("=================================")
}