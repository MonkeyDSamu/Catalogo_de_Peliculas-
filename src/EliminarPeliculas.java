import java.util.ArrayList;
import java.util.Scanner;

public class EliminarPeliculas {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<String> peliculas = new ArrayList<>();

        peliculas.add("Titanic");
        peliculas.add("Avatar");
        peliculas.add("Rapidos y Furiosos");
        peliculas.add("Avengers");

        int opcion = 0;

        do {
            System.out.println("\n--- CATALOGO DE PELICULAS ---");
            System.out.println("1. Ver peliculas");
            System.out.println("2. Eliminar pelicula");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opcion: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Error: debe ingresar un numero.");
                scanner.nextLine();
                continue;
            }

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1:
                    System.out.println("\nPeliculas registradas:");
                    for (int i = 0; i < peliculas.size(); i++) {
                        System.out.println((i + 1) + ". " + peliculas.get(i));
                    }
                    break;

                case 2:
                    if (peliculas.isEmpty()) {
                        System.out.println("No hay peliculas para eliminar.");
                        break;
                    }

                    System.out.println("\nPeliculas registradas:");
                    for (int i = 0; i < peliculas.size(); i++) {
                        System.out.println((i + 1) + ". " + peliculas.get(i));
                    }

                    System.out.print("Ingrese el numero de la pelicula: ");

                    if (!scanner.hasNextInt()) {
                        System.out.println("Error: opcion incorrecta.");
                        scanner.nextLine();
                        break;
                    }

                    int numero = scanner.nextInt();
                    scanner.nextLine();

                    if (numero < 1 || numero > peliculas.size()) {
                        System.out.println("La pelicula no existe.");
                        break;
                    }

                    System.out.print("¿Esta seguro de eliminarla? (si/no): ");
                    String confirmar = scanner.nextLine();

                    if (confirmar.equalsIgnoreCase("si")) {
                        String eliminada = peliculas.remove(numero - 1);
                        System.out.println("Pelicula eliminada: " + eliminada);
                    } else if (confirmar.equalsIgnoreCase("no")) {
                        System.out.println("Eliminacion cancelada.");
                    } else {
                        System.out.println("Respuesta incorrecta.");
                    }
                    break;

                case 3:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opcion incorrecta. Intente nuevamente.");
            }
        
        } while (opcion != 3);

        scanner.close();
        
    }
}
