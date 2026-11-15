import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Catalogo catalogo = new Catalogo();

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = leerOpcion();
            switch (opcion) {
                case 1 -> agregarPelicula();
                case 2 -> catalogo.mostrarTodas();
                case 3 -> buscarPelicula();
                case 0 -> System.out.println("¡Hasta pronto!");
                default -> System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 0);
    }

    private static void mostrarMenu() {
        System.out.println();
        System.out.println("===== CATÁLOGO DE PELÍCULAS =====");
        System.out.println("1. Agregar película");
        System.out.println("2. Mostrar películas");
        System.out.println("3. Buscar película");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static int leerOpcion() {
        // -1 representa una entrada no numérica (cae en "opción no válida")
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static void agregarPelicula() {
        if (catalogo.estaLleno()) {
            System.out.println("El catálogo está lleno (máximo " + Catalogo.CAPACIDAD + " películas).");
            return;
        }
        String titulo = leerTexto("Ingrese el título: ");
        String director = leerTexto("Ingrese el director: ");
        String genero = leerTexto("Ingrese el género: ");
        int anio = leerAnio("Ingrese el año: ");
        double calificacion = leerCalificacion("Ingrese la calificación: ");

        catalogo.agregar(titulo, director, genero, anio, calificacion);
        System.out.println("Película agregada correctamente.");
    }

    private static void buscarPelicula() {
        String titulo = leerTexto("Ingrese el título de la película: ");
        catalogo.buscarPorTitulo(titulo);
    }

    private static String leerTexto(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String texto = scanner.nextLine().trim();
            if (!texto.isEmpty()) {
                return texto;
            }
            System.out.println("El valor no puede estar vacío.");
        }
    }

    private static int leerAnio(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                int anio = Integer.parseInt(scanner.nextLine().trim());
                if (anio > 0) {
                    return anio;
                }
            } catch (NumberFormatException e) {
                // se vuelve a preguntar
            }
            System.out.println("Ingrese un año válido (número entero positivo).");
        }
    }

    private static double leerCalificacion(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                // acepta "9.0" y "9,0"
                double nota = Double.parseDouble(scanner.nextLine().trim().replace(',', '.'));
                if (nota >= 0 && nota <= 10) {
                    return nota;
                }
            } catch (NumberFormatException e) {
                // se vuelve a preguntar
            }
            System.out.println("Ingrese una calificación válida entre 0 y 10.");
        }
    }
}
