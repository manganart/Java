package ProyectoPeliculas.services;

import ProyectoPeliculas.Clases.Pelicula;
import ProyectoPeliculas.Main;
import ProyectoPeliculas.MainCreacion;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.UUID;

public class PeliculasService {

    // ________________
    //Colorines:
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_RESET = "\u001B[0m";
    // -----------------------------------------------------------
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    // ________________

    public static boolean addPelicula() {
        // Añadir una película nueva.
        Scanner scan = new Scanner(System.in);

        // NOMBRE
        scan.nextLine();
        System.out.print("Dime el nombre de la película: ");
        String nombrePeli = scan.nextLine();

        // AÑO
        int anio = 0;
        try {
            scan.nextLine();
            System.out.println("Dime el año de publicación  de la película: ");
            anio = scan.nextInt();
            scan.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Año erróneo....");
        }

        // CREW
        // DIRECTOR
        System.out.print("Dime el nombre del director/a: ");
        String nombreDir = scan.nextLine();
        // ACTOR1
        System.out.print("Dime el nombre del actor1: ");
        String nombreAct1 = scan.nextLine();
        // ACTOR2
        System.out.print("Dime el nombre del actor2: ");
        String nombreAct2 = scan.nextLine();

        // ID
        // Clase para generar ID aleatorias
        String id = UUID.randomUUID().toString();

        // NOTA
        double nota = 0.0;
        try {
            System.out.println("Dime la nota de la película: ");
            nota = scan.nextDouble();
            scan.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Nota errónea....");
        }

        Pelicula peliNueva = new Pelicula(id, nombrePeli, anio + "", nombreDir, nombreAct1, nombreAct2, nota + "");

        boolean peliExiste = false;
        for (int i = 0; i < MainCreacion.peliculas.size(); i++) {
            if (MainCreacion.peliculas.get(i).getId().equals(peliNueva.getId())) {
                System.out.println("Película ya existente");
                peliExiste = true;
                break;
            }

        }

        if (!peliExiste) {
            // Vamos a comprobar la posición en la que tenemos que meter la peli

            for (int i = 0; i < MainCreacion.peliculas.size(); i++) {
                double notaPeliNueva = Double.parseDouble(peliNueva.getImDbRating());
                double notaPeliLista = Double.parseDouble(MainCreacion.peliculas.get(i).getImDbRating());

                if (notaPeliNueva > notaPeliLista) {
                    // Insertamos la peliNueva en la posición de la peli de la lista
                    peliNueva.setRank(MainCreacion.peliculas.get(i).getRank());
                    MainCreacion.peliculas.add(i, peliNueva);

                    for (int j = i + 1; j < MainCreacion.peliculas.size(); j++) {
                        int rankingAntiguo = Integer.parseInt(MainCreacion.peliculas.get(j).getRank());
                        int rankingNuevo = rankingAntiguo + 1;
                        MainCreacion.peliculas.get(j).setRank(rankingNuevo + "");

                    }

                }
                break;
            }

            System.out.println("Película correctamente añadida.");

        }
        return true;
    }

    public static void mostrarPelicuolasDesc() {
        for (int i = 0; i < MainCreacion.peliculas.size(); i++) {
            System.out.printf(ANSI_GREEN + "---(%s)-----------\n" + ANSI_RESET, MainCreacion.peliculas.get(i).getRank());
            System.out.printf("- Título (año): %s\n", MainCreacion.peliculas.get(i).getFullTitle());
            System.out.printf(ANSI_WHITE + "\t* Nota: %s\n" + ANSI_RESET, MainCreacion.peliculas.get(i).getImDbRating());
            System.out.printf(ANSI_WHITE + "\t* Crew: %s\n" + ANSI_RESET, MainCreacion.peliculas.get(i).getCrew());
        }
    }

    public static void eliminarPeliculas() {
        Scanner scan = new Scanner(System.in);
        int eleccion;

        do {
            System.out.println(ANSI_BLUE_BACKGROUND + ANSI_BLACK + """

                    1. Eliminar por ranking.
                    2. Eliminar por nombre.
                    0. Salir

                    """+ ANSI_RESET);

            eleccion = scan.nextInt();
            scan.nextLine();

            switch (eleccion) {
                case 1:
                    String rangoEliminar = "";
                    System.out.print("Dígame el ranking que quiere eliminar: ");
                    rangoEliminar = scan.nextLine();

                    for (int i = 0; i < MainCreacion.peliculas.size(); i++) {

                        if (MainCreacion.peliculas.get(i).getRank().equals(rangoEliminar)) {
                            MainCreacion.peliculas.remove(i);
                        }
                    }
                    break;
                case 2:
                    String nombreEliminar = "";
                    System.out.print("Dígame el título que quiere eliminar: ");
                    nombreEliminar = scan.nextLine();

                    for (int i = 0; i < MainCreacion.peliculas.size(); i++) {

                        if (MainCreacion.peliculas.get(i).getTitle().equals(nombreEliminar)) {
                            MainCreacion.peliculas.remove(i);
                        }
                    }
                    break;

                case 0:
                    System.out.println("Volviendo al menú.");
                    break;
                default:

                    break;
            }

        } while (eleccion != 0);

    }

    public static void modificarPelicula() {
        Scanner scan = new Scanner(System.in);
        boolean peliExiste2;
        try {
            System.out.println("Qué película desea modificar.");
            String peliculaModificarElegir = scan.nextLine();

            for (int i = 0; i < MainCreacion.peliculas.size(); i++) {

                if (peliculaModificarElegir.equalsIgnoreCase(MainCreacion.peliculas.get(i).getTitle())) {
                    int selector;
                    peliExiste2 = true;

                    do {


                        System.out.println(ANSI_BLUE_BACKGROUND + ANSI_BLACK +"¿Qué parte quieres modificar:\n" + "1. Título\n" + "2. Año\n" + "3. Nota\n" + "4. Director\n" + "5. Reparto. Solo actores principales \n" + "0. Salir\n"+ ANSI_RESET);
                        selector = scan.nextInt();
                        scan.nextLine();

                        switch (selector) {
                            case 1:

                                String newNameFilm = scan.nextLine();
                                MainCreacion.peliculas.get(i).setTitle(newNameFilm);

                                break;
                            case 2:
                                String newYearFilm = scan.nextLine();
                                MainCreacion.peliculas.get(i).setYear(newYearFilm);
                                break;
                            case 3:
                                String newImdbRatingFilm = scan.nextLine();
                                MainCreacion.peliculas.get(i).setImDbRating(newImdbRatingFilm);
                                break;
                            case 4:
                                String[] partesCrew = MainCreacion.peliculas.get(i).getCrew().split(", ");

                                // Obtener las partes individuales
                                String dir;
                                String act1 = partesCrew[1];
                                String act2 = partesCrew[2];

                                // Preguntar al usuario por el nuevo director
                                System.out.println("¿Qué director desea establecer?");
                                String respuesta = scan.nextLine();
                                dir = respuesta;

                                // Actualizar la cadena crew en la instancia de Pelicula
                                MainCreacion.peliculas.get(i).setCrew(dir + " ( dir.), ", act1, act2);

                                break;
                            case 5:
                                String[] partesCrew2 = MainCreacion.peliculas.get(i).getCrew().split(", ");
                                String dir2 = partesCrew2[0];
                                String act1a = partesCrew2[1];
                                String act2a = partesCrew2[2];
                                System.out.println("¿Cuáles son los actores??");
                                System.out.println("\nActor uno: ");
                                act1a = scan.next();
                                System.out.println("Actor dos: ");
                                act2a = scan.next();


                                MainCreacion.peliculas.get(i).setCrew(dir2 + ", ", act1a, act2a);


                                break;
                            case 0:
                                break;
                            default:
                                System.out.println("Volviendo al menú.");
                                break;

                        }

                    } while (selector != 0);

                }
            }

        } catch (Error e) {
            System.out.println("Película no encontrada");

        }
    }

    public static void imprimirMayorMenor() {

        for (int i = 0; i < MainCreacion.peliculas.size(); i++) {
            double mayorNota = 0.0;

            if (mayorNota <= Double.parseDouble(MainCreacion.peliculas.get(i).getImDbRating())) {
                mayorNota = Double.parseDouble(MainCreacion.peliculas.get(i).getImDbRating());
            }
            System.out.println(mayorNota + " " + MainCreacion.peliculas.get(i).getFullTitle());

        }

    }


    public static void imprimirMenorMayor() {
        for (int i = MainCreacion.peliculas.size() - 1; i > 0; i--) {

            System.out.println(MainCreacion.peliculas.get(i).getImDbRating() + " " + MainCreacion.peliculas.get(i).getFullTitle());

        }

    }

    public static void imprimir2000() {
        for (int i = 0; i < MainCreacion.peliculas.size(); i++) {

            if (Integer.parseInt(MainCreacion.peliculas.get(i).getYear()) > 2000) {

                System.out.println(" - " + MainCreacion.peliculas.get(i).getFullTitle() + " " + MainCreacion.peliculas.get(i).getYear());
            }

        }
    }

    public static void imrpimir2KNota8() {
        for (int i = 0; i < MainCreacion.peliculas.size(); i++) {

            if (Integer.parseInt(MainCreacion.peliculas.get(i).getYear()) > 2000 && Double.parseDouble(MainCreacion.peliculas.get(i).getImDbRating()) >= 8.8) {

                System.out.println(" - " + MainCreacion.peliculas.get(i).getImDbRating() + " " + MainCreacion.peliculas.get(i).getFullTitle() + " " + MainCreacion.peliculas.get(i).getYear());
            }

        }
    }

    public static void imprimirNotaUser2K() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Introduzca la nota: ");
        double nota = scan.nextDouble();
        for (int i = 0; i < MainCreacion.peliculas.size(); i++) {

            if (Integer.parseInt(MainCreacion.peliculas.get(i).getYear()) > 2000 && Double.parseDouble(MainCreacion.peliculas.get(i).getImDbRating()) >= nota) {

                System.out.println(" - " + MainCreacion.peliculas.get(i).getImDbRating() + " " + MainCreacion.peliculas.get(i).getFullTitle() + " " + MainCreacion.peliculas.get(i).getYear());
            }

        }
    }

    public static void imprimirPelicula() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Introduzca la película: ");
        String nombrePelicula = scan.nextLine();
        for (int i = 0; i < MainCreacion.peliculas.size(); i++) {
            if (MainCreacion.peliculas.get(i).getTitle().contains(nombrePelicula)) {
                System.out.println(ANSI_BLUE +" - " + MainCreacion.peliculas.get(i).getImDbRating() + " " + MainCreacion.peliculas.get(i).getFullTitle() + " " + MainCreacion.peliculas.get(i).getYear()+"\n"+ANSI_RESET);

            }

        }
    }

    public static void imprimirPorDir() {
        Scanner scan = new Scanner(System.in);

        System.out.print("Introduzca el director: ");
        String nombresDirector = scan.nextLine();
        for (int i = 0; i < MainCreacion.peliculas.size(); i++) {
            if (MainCreacion.peliculas.get(i).getCrew().contains(nombresDirector)) {
                System.out.println(" - " + MainCreacion.peliculas.get(i).getImDbRating() + " " + MainCreacion.peliculas.get(i).getFullTitle() + " " + MainCreacion.peliculas.get(i).getYear());

            } else if (!MainCreacion.peliculas.get(i).getCrew().contains(nombresDirector)) {
                System.out.println("Director no encontrado");
                break;
            }
        }
    }


}
