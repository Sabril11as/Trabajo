public class Ordenamientos {

    public static void intercambiar(String[] a, int i, int j) {
        String temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void seleccion(String[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int posMenor = i;

            for (int j = i + 1; j < a.length; j++) {
                if (a[j].compareTo(a[posMenor]) < 0) {
                    posMenor = j;
                }
            }

            intercambiar(a, i, posMenor);
        }
    }

    public static void insercion(String[] a) {
        for (int i = 1; i < a.length; i++) {
            String actual = a[i];
            int j = i - 1;

            while (j >= 0 && a[j].compareTo(actual) > 0) {
                a[j + 1] = a[j];
                j--;
            }

            a[j + 1] = actual;
        }
    }

    public static void burbuja(String[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j].compareTo(a[j + 1]) > 0) {
                    intercambiar(a, j, j + 1);
                }
            }
        }
    }

    public static void mezcla(String[] a, int inicio, int fin) {
        if (inicio < fin) {
            int medio = (inicio + fin) / 2;

            mezcla(a, inicio, medio);
            mezcla(a, medio + 1, fin);

            unir(a, inicio, medio, fin);
        }
    }

    public static void unir(String[] a, int inicio, int medio, int fin) {
        String[] aux = new String[fin - inicio + 1];
        int i = inicio;
        int j = medio + 1;
        int k = 0;

        while (i <= medio && j <= fin) {
            if (a[i].compareTo(a[j]) <= 0) {
                aux[k] = a[i];
                i++;
            } else {
                aux[k] = a[j];
                j++;
            }
            k++;
        }

        while (i <= medio) {
            aux[k] = a[i];
            i++;
            k++;
        }

        while (j <= fin) {
            aux[k] = a[j];
            j++;
            k++;
        }

        for (k = 0; k < aux.length; k++) {
            a[inicio + k] = aux[k];
        }
    }

    public static void rapido(String[] a, int inicio, int fin) {
        if (inicio < fin) {
            int posPivote = particionar(a, inicio, fin);

            rapido(a, inicio, posPivote - 1);
            rapido(a, posPivote + 1, fin);
        }
    }

    public static int particionar(String[] a, int inicio, int fin) {
        String pivote = a[fin];
        int i = inicio - 1;

        for (int j = inicio; j < fin; j++) {
            if (a[j].compareTo(pivote) < 0) {
                i++;
                intercambiar(a, i, j);
            }
        }

        intercambiar(a, i + 1, fin);
        return i + 1;
    }
}