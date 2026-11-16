import java.util.Scanner;

/**
 * @author Samu
 */
public class BusquedaModificacion {

    public static int buscarPosicion(String[] titulos, int cantidad, String tituloBuscado) {
        for (int i = 0; i < cantidad; i++) {
            if (titulos[i].equalsIgnoreCase(tituloBuscado.trim())) {
                return i;
            }
        }
        return -1;
    }

    public static void mostrarPelicula(int pos, String[] titulos, String[] directores,
                                       String[] generos, int[] years) {
        System.out.println("Titulo:   " + titulos[pos]);
        System.out.println("Director: " + directores[pos]);
        System.out.println("Genero:   " + generos[pos]);
        System.out.println("Year:     " + years[pos]);
    }

    public static void buscarPelicula(Scanner sc, String[] titulos, String[] directores,
                                      String[] generos, int[] years, int cantidad) {
        System.out.println("\n--- Buscar pelicula ---");

        if (cantidad == 0) {
            System.out.println("No hay peliculas registradas.");
            return;
        }

        System.out.print("Ingrese el titulo a buscar: ");
        String tituloBuscado = sc.nextLine();

        int pos = buscarPosicion(titulos, cantidad, tituloBuscado);

        if (pos == -1) {
            System.out.println("La pelicula \"" + tituloBuscado + "\" no existe en el catalogo.");
        } else {
            System.out.println("Pelicula encontrada:");
            mostrarPelicula(pos, titulos, directores, generos, years);
        }
    }

    public static void modificarPelicula(Scanner sc, String[] titulos, String[] directores,
                                         String[] generos, int[] years, int cantidad) {
        System.out.println("\n--- Modificar pelicula ---");

        if (cantidad == 0) {
            System.out.println("No hay peliculas registradas.");
            return;
        }

        System.out.print("Ingrese el titulo de la pelicula a modificar: ");
        String tituloBuscado = sc.nextLine();

        int pos = buscarPosicion(titulos, cantidad, tituloBuscado);

        if (pos == -1) {
            System.out.println("La pelicula \"" + tituloBuscado + "\" no existe en el catalogo.");
            return;
        }

        System.out.println("Datos actuales:");
        mostrarPelicula(pos, titulos, directores, generos, years);
        System.out.println("(Deje vacio y presione Enter para conservar el valor actual)");

        System.out.print("Nuevo titulo: ");
        String nuevoTitulo = sc.nextLine().trim();
        if (!nuevoTitulo.isEmpty()) {
            titulos[pos] = nuevoTitulo;
        }

        System.out.print("Nuevo director: ");
        String nuevoDirector = sc.nextLine().trim();
        if (!nuevoDirector.isEmpty()) {
            directores[pos] = nuevoDirector;
        }

        System.out.print("Nuevo genero: ");
        String nuevoGenero = sc.nextLine().trim();
        if (!nuevoGenero.isEmpty()) {
            generos[pos] = nuevoGenero;
        }

        System.out.print("New year: ");
        String newYear = sc.nextLine().trim();
        if (!newYear.isEmpty()) {
            try {
                years[pos] = Integer.parseInt(newYear);
            } catch (NumberFormatException e) {
                System.out.println("Year no valido, se conserva el anterior.");
            }
        }

        System.out.println("Pelicula modificada correctamente:");
        mostrarPelicula(pos, titulos, directores, generos, years);
    }
}
