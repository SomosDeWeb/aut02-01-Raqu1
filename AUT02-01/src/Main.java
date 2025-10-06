import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        int opcion, edad;
        String nombre;
        double notaMedia, mediaTotal;
        boolean matriculado;

        ArrayList<Estudiante> listadoEstudiantes = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        do {
            Menu.visualizarMenu();

            System.out.println("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    do {
                        System.out.println("\nIntroduce un nombre: ");
                        nombre = sc.nextLine();
                    } while (nombre.isEmpty());

                    do {
                        System.out.println("Introduce la edad: ");
                        edad = sc.nextInt();
                        sc.nextLine();
                    } while (edad < 0 || edad >= 100);

                    do {
                        System.out.println("Introduce la nota media: ");
                        notaMedia = sc.nextDouble();
                        sc.nextLine();
                    } while (notaMedia < 0 || notaMedia >= 100);

                    System.out.println("Está matriculado (true/false): ");
                    matriculado = sc.nextBoolean();
                    sc.nextLine();

                    Estudiante obj = new Estudiante(nombre,edad,notaMedia,matriculado);
                    listadoEstudiantes.add(obj);
                    System.out.println("Estudinate añadido correctamente.");
                    break;


            }

        } while (opcion > 2);

    }
        public static class Menu {
            public static void visualizarMenu() {
                System.out.println("""
                    === Gestor de Estudiantes ===
                    1. Añadir estudiante
                    2. Listar estudiantes
                    3. Buscar por nombre
                    4. Calcular nota media general
                    5. Mostrar mejor estudiante
                    6. Salir
                    """);


            }
        }

    }