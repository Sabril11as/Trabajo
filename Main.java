import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Tamaño del arreglo: ");
        int n = sc.nextInt();
        sc.nextLine();

        String[] palabras = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Palabra " + (i + 1) + ": ");
            palabras[i] = sc.nextLine();
        }

        System.out.println();
        System.out.println("1. Selección");
        System.out.println("2. Inserción");
        System.out.println("3. Burbuja");
        System.out.println("4. Mezcla");
        System.out.println("5. Rápido");
        System.out.print("Elija un algoritmo: ");
        int opcion = sc.nextInt();
        sc.nextLine();

        switch (opcion) {
            case 1:
                Ordenamientos.seleccion(palabras);
                break;
            case 2:
                Ordenamientos.insercion(palabras);
                break;
            case 3:
                Ordenamientos.burbuja(palabras);
                break;
            case 4:
                Ordenamientos.mezcla(palabras, 0, n - 1);
                break;
            case 5:
                Ordenamientos.rapido(palabras, 0, n - 1);
                break;
            default:
                System.out.println("Opción inválida.");
                return;
        }

        System.out.println();
        System.out.println("Arreglo ordenado:");
        for (int i = 0; i < n; i++) {
            System.out.println(palabras[i]);
        }

        String continuar = "s";
        while (continuar.equals("s")) {
            System.out.println();
            System.out.print("Palabra a buscar: ");
            String palabra = sc.nextLine();

            int posicion = Busqueda.binaria(palabras, palabra);

            if (posicion >= 0) {
                System.out.println("Encontrada en la posición " + posicion);
            } else {
                System.out.println("La palabra no está en el arreglo.");
            }

            System.out.print("¿Buscar otra? (s/n): ");
            continuar = sc.nextLine();
        }
    }
}