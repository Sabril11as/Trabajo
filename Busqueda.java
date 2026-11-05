public class Busqueda {

    public static int binaria(String[] a, String palabra) {
        int inicio = 0;
        int fin = a.length - 1;

        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;

            int resultado = a[medio].compareTo(palabra);

            if (resultado == 0) {
                return medio;
            } else if (resultado < 0) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }
        }

        return -1;
    }
}