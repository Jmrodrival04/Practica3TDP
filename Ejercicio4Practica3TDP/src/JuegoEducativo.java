import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JuegoEducativo {

    private static List<Nivel> niveles = new ArrayList<>();

    public static void main(String[] args) {
        inicializarNiveles();
        jugarNiveles();
    }


    private static void inicializarNiveles() {
        // Nivel 1
        Nivel nivel1 = new Nivel(1);
        nivel1.agregarDesafio(new Desafio("¿Cuál es la instrucción para imprimir en consola en Java?", "System.out.println"));
        niveles.add(nivel1);

        // Nivel 2
        Nivel nivel2 = new Nivel(2);
        nivel2.agregarDesafio(new Desafio("¿Cómo se declara una variable entera en Java?", "int"));
        nivel2.agregarDesafio(new Desafio("¿Cuál es la sintaxis correcta para declarar un ArrayList en Java?", "ArrayList<Tipo> nombre = new ArrayList<>();"));
        niveles.add(nivel2);

        // Nivel 3
        Nivel nivel3 = new Nivel(3);
        nivel3.agregarDesafio(new Desafio("¿Cuál es la sintaxis correcta para declarar un arreglo en Java?", "tipo[] nombre;"));
        nivel3.agregarDesafio(new Desafio("Escribe un ejemplo de un bucle for en Java.", "for(int i = 0; i < n; i++) {}"));
        niveles.add(nivel3);

        // Nivel 4
        Nivel nivel4 = new Nivel(4);
        nivel4.agregarDesafio(new Desafio("Explica cómo funciona el bucle 'while' en Java.", "Repite un bloque de código mientras se cumpla una condición."));
        nivel4.agregarDesafio(new Desafio("¿Cómo se puede capturar una excepción en Java?", "try { } catch (Exception e) { }"));
        niveles.add(nivel4);

        // Nivel 5
        Nivel nivel5 = new Nivel(5);
        nivel5.agregarDesafio(new Desafio("¿Qué característica de Java permite ejecutar múltiples hilos simultáneamente?", "Multithreading o hilos."));
        nivel5.agregarDesafio(new Desafio("Menciona una diferencia entre 'ArrayList' y 'LinkedList' en Java.", "ArrayList es mejor para almacenar y acceder a datos, mientras que LinkedList es mejor para manipular datos."));
        niveles.add(nivel5);

        // Nivel 6
        Nivel nivel6 = new Nivel(6);
        nivel6.agregarDesafio(new Desafio("¿Qué es polimorfismo en Java?", "La capacidad de un método para hacer diferentes cosas basado en el objeto con el que se está interactuando."));
        nivel6.agregarDesafio(new Desafio("Explica el concepto de encapsulación en Java.", "Restringir el acceso directo a algunos componentes de un objeto."));
        niveles.add(nivel6);
    }
    private static void jugarNiveles() {
        Scanner scanner = new Scanner(System.in);
        for (Nivel nivel : niveles) {
            System.out.println("Bienvenido al nivel de dificultad " + nivel.getDificultad() + ". Responde las siguientes preguntas:");

            for (Desafio desafio : nivel.getDesafios()) {
                System.out.println(desafio.getPregunta());
                String respuesta = scanner.nextLine();

                if (desafio.comprobarRespuesta(respuesta)) {
                    System.out.println("¡Correcto!");
                } else {
                    System.out.println("Incorrecto. La respuesta correcta era: " + respuesta);
                    // Vuelve a intentar el mismo nivel si falla
                    break;
                }
            }
        }
        System.out.println("¡Felicidades! Has completado todos los niveles.");
        scanner.close();
    }
}