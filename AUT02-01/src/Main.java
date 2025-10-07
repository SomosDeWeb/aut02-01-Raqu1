import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        int opcion, edad, pos, i;
        String nombre;
        double notaMedia, mediaTotal, suma, mejorNota;
        boolean matriculado, encontrado;


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

                    Estudiante alumno = new Estudiante(nombre,edad,notaMedia,matriculado);
                    listadoEstudiantes.add(alumno);
                    System.out.println("Estudinate añadido correctamente.");
                    break;

                case 2:
                    System.out.println("\n=== Lista de Estudiantes ===");
                    if (listadoEstudiantes.isEmpty())
                        System.out.println("·> No hay alumnos registrados.");
                    else {
                        for (Estudiante estudiante : listadoEstudiantes) {
                            System.out.println(estudiante.listarDatos());
                        }
                    }
                    break;

                case 3:
                    encontrado = false;
                    System.out.println("Introduce el nombre del estudiante a buscar: ");
                    nombre = sc.nextLine();
                    for (Estudiante listadoEstudiante : listadoEstudiantes) {
                        if (listadoEstudiante.getNombre().equals(nombre)) {
                            System.out.println("\nEstudiante encontrado.");
                            System.out.println(listadoEstudiante.listarDatos());
                            encontrado = true;
                        }
                    }

                case 4:
                    suma = 0;
                    if (listadoEstudiantes.isEmpty()){
                        System.out.println("No hay alumnos registrados.");
                        } else {
                            for (Estudiante estudiante : listadoEstudiantes)
                                suma += estudiante.getMedia();
                            mediaTotal = suma / listadoEstudiantes.size();
                        System.out.println("La media total de los alumnos registrados es de: " + mediaTotal + "\n");
                    }

                case 5:
                    mejorNota = Double.MAX_VALUE;
                    pos = 0;
                    i = 0;
                    if(listadoEstudiantes.isEmpty())
                        System.out.println("No hay alumnos registrados.");
                    else {
                        for (Estudiante estudiante : listadoEstudiantes) {
                            if (estudiante.getMedia() > mejorNota) {
                                notaMedia = estudiante.getMedia();
                                pos = i;
                            }
                            i++;
                        }
                        System.out.println("El alumno con mejor nota es: ");
                        System.out.println(listadoEstudiantes.get(pos).listarDatos());
                    }

            }

        } while (opcion != 6);

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