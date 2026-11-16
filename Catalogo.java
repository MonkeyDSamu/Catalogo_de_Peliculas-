/**
 * Almacena las películas en arrays paralelos:
 * la posición i de cada array corresponde a la misma película.
 */
public class Catalogo {

    public static final int CAPACIDAD = 100;

    private final String[] titulos = new String[CAPACIDAD];
    private final String[] directores = new String[CAPACIDAD];
    private final String[] generos = new String[CAPACIDAD];
    private final int[] anios = new int[CAPACIDAD];
    private final double[] calificaciones = new double[CAPACIDAD];
    private int total = 0;

    public boolean estaVacio() {
        return total == 0;
    }

    public boolean estaLleno() {
        return total == CAPACIDAD;
    }

    /** Guarda una película. Devuelve false si el catálogo está lleno. */
    public boolean agregar(String titulo, String director, String genero, int anio, double calificacion) {
        if (estaLleno()) {
            return false;
        }
        titulos[total] = titulo;
        directores[total] = director;
        generos[total] = genero;
        anios[total] = anio;
        calificaciones[total] = calificacion;
        total++;
        return true;
    }

    /** Imprime todas las películas registradas. */
    public void mostrarTodas() {
        if (estaVacio()) {
            System.out.println("No hay películas registradas.");
            return;
        }
        System.out.println("========================================");
        System.out.println("Películas registradas");
        System.out.println("========================================");
        for (int i = 0; i < total; i++) {
            System.out.println("Película #" + (i + 1));
            imprimirDatos(i);
            System.out.println("----------------------------------------");
        }
    }

    /** Busca por título (sin distinguir mayúsculas) e imprime el resultado. */
    public void buscarPorTitulo(String titulo) {
        for (int i = 0; i < total; i++) {
            if (titulos[i].equalsIgnoreCase(titulo)) {
                System.out.println("Película encontrada.");
                imprimirDatos(i);
                return;
            }
        }
        System.out.println("No se encontró la película.");
    }

    /**
     * Elimina la película en la posición indicada (1 a total) y desplaza
     * las siguientes una posición a la izquierda en todos los arrays.
     * Devuelve el título eliminado, o null si la posición no es válida.
     */
    public String eliminar(int posicion) {
        if (posicion < 1 || posicion > total) {
            return null;
        }
        int indice = posicion - 1;
        String eliminada = titulos[indice];

        for (int i = indice; i < total - 1; i++) {
            titulos[i] = titulos[i + 1];
            directores[i] = directores[i + 1];
            generos[i] = generos[i + 1];
            anios[i] = anios[i + 1];
            calificaciones[i] = calificaciones[i + 1];
        }

        total--;
        titulos[total] = null;
        directores[total] = null;
        generos[total] = null;
        anios[total] = 0;
        calificaciones[total] = 0;
        return eliminada;
    }

    public int getTotal() {
        return total;
    }

    private void imprimirDatos(int i) {
        System.out.println("Título: " + titulos[i]);
        System.out.println("Director: " + directores[i]);
        System.out.println("Género: " + generos[i]);
        System.out.println("Año: " + anios[i]);
        System.out.println("Calificación: " + calificaciones[i]);
    }
}
