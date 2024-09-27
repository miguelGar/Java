package org.example.testPc;

import org.example.mundopc.*;

public class mundoPc {

    public static void main(String[] args) {
        Monitor monitorLenovo = new Monitor("Lenovo", 27);
        Teclado trcladoDenius = new Teclado("USB", "Genius");
        Raton raton = new Raton("USB", "GHUB");
        Computadora computadoraLenovo = new Computadora("Lenovo", monitorLenovo, trcladoDenius, raton);

        Monitor monitorGrande = new Monitor("nEW", 27);
        Teclado trcladoDemon = new Teclado("USB", "Gen");
        Raton ratonGre = new Raton("USB", "SMART");
        Computadora computadoraHP = new Computadora("Gaming", monitorLenovo, trcladoDenius, raton);


        Orden orden1 = new Orden();
        orden1.agregarComputadoras(computadoraLenovo);
        orden1.agregarComputadoras(computadoraHP);

        orden1.mostrarOrden();
    }
}
