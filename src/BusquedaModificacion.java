import java.util.Scanner;

/**
 * Catalogo de Peliculas - Integrante 3
 * Busqueda y modificacion de peliculas (UPDATE).
 *
 * @author Samu
 *
 * Los metodos reciben los arrays donde se guardan las peliculas
 * (titulos, directores, generos, anios) y la cantidad de peliculas registradas.
 *
 * Ejemplo de uso desde el menu (switch):
 *   case 3:
 *       BusquedaModificacion.buscarPelicula(sc, titulos, directores, generos, anios, cantidad);
 *       break;
 *   case 4:
 *       BusquedaModificacion.modificarPelicula(sc, titulos, directores, generos, anios, cantidad);
 *       break;
 */
public class BusquedaModificacion {

    /**
     * Compara el titulo buscado con los titulos guardados (sin importar
     * mayusculas o minusculas). Devuelve la posicion o -1 si no existe.
     */
    public static int buscarPosicion(String[] titulos, int cantidad, String tituloBuscado) {
        for (int i = 0; i < cantidad; i++) {
            if (titulos[i].equalsIgnoreCase(tituloBuscado.trim())) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Muestra los datos de la pelicula que esta en la posicion indicada.
     */
    public static void mostrarPelicula(int pos, String[] titulos, String[] directores,
                                       String[] generos, int[] anios) {
        System.out.println("Titulo:   " + titulos[pos]);
        System.out.println("Director: " + directores[pos]);
        System.out.println("Genero:   " + generos[pos]);
        System.out.println("Anio:     " + anios[pos]);
    }

    /**
     * Busca una pelicula por titulo y muestra sus datos.
     * Si no existe, muestra un mensaje.
     */
    public static void buscarPelicula(Scanner sc, String[] titulos, String[] directores,
                                      String[] generos, int[] anios, int cantidad) {
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
            mostrarPelicula(pos, titulos, directores, generos, anios);
        }
    }

    /**
     * Busca una pelicula por titulo y permite modificar sus datos.
     * Si el usuario deja un campo vacio, se conserva el valor actual.
     */
    public static void modificarPelicula(Scanner sc, String[] titulos, String[] directores,
                                         String[] generos, int[] anios, int cantidad) {
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
        mostrarPelicula(pos, titulos, directores, generos, anios);
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
        String nuevoAnio = sc.nextLine().trim();
        if (!nuevoAnio.isEmpty()) {
            try {
                anios[pos] = Integer.parseInt(nuevoAnio);
            } catch (NumberFormatException e) {
                System.out.println("Anio no valido, se conserva el anterior.");
            }
        }

        System.out.println("Pelicula modificada correctamente:");
        mostrarPelicula(pos, titulos, directores, generos, anios);
    }
}
