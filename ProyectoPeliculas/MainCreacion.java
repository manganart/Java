package ProyectoPeliculas;

import ProyectoPeliculas.Clases.Pelicula;
import ProyectoPeliculas.Utils.JsonReaderUtil;
import ProyectoPeliculas.services.PeliculasService;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class MainCreacion {

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
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static ArrayList<Pelicula> peliculas = null;

    public static void main(String[] args) {
        String pelisPath = "IMDB-api/Top250Movies.json";
        peliculas = JsonReaderUtil.loadJsonFile(pelisPath);

/*
Hacer un menú para dar la opción de crear un nuevo registro
 */
        Scanner scan = new Scanner(System.in);


        int opc = 1;
        while (opc != 0) {
            try {
                System.out.format(ANSI_YELLOW_BACKGROUND + ANSI_BLACK + "Bienvenido al CRUD de Peliculas\r\n" + //
                        "                                        \r\n" +
                        "                1. Insertar película.\r\n" + //
                        "                2. Mostrar películas de mayor a menor.\r\n" + //
                        "                3. Eliminar una película (Por nombre y por Rank).\r\n" + //
                        "                4. Modificar película (Título, Año, Crew)                       \r\n" + //
                        "                5. Imprimir las películas de mayor a menor nota. \r\n" +
                        "                6. Imprimir las películas de menor a mayor nota. \r\n" +
                        "                7. Imprimir las películas cuyo año de publicación sea del 2000 hasta la actualidad. \r\n" +
                        "                8. Imprimir las películas cuyo año de publicación sea del 2000 hasta la actualidad que tengan una nota por encima de 8.8 (incluído). \r\n" +
                        "                9. Imprimir las películas cuyo año de publicación sea del 2000 hasta la actualidad que tengan una nota por encima de una nota que diga el usuario por teclado. \r\n" +
                        "                10. Imprimir por pantalla una película que el usuario introduce por teclado. \r\n" +
                        "                11. Imprimir por pantalla las peliculas de un director que el usuario introduce por teclado. \r\n" +
                        "                0. Salir.\r\n" + //

                        "                +---------+---------+-------+---------+---------+---------+-------+---------+---------+---------+-------+---------+---------+---------+---------+---------+---------+\r\n" + //
                        "                Escoja una opción: \r\n" + ANSI_RESET

                );

                opc = scan.nextInt();

                switch (opc) {
                    case 1:
                        PeliculasService.addPelicula();

                        break;

                    case 2:
                        PeliculasService.mostrarPelicuolasDesc();

                        break;

                    case 3:
                        PeliculasService.eliminarPeliculas();

                        break;

                    case 4:
                        PeliculasService.modificarPelicula();

                        break;

                    case 5:
                        PeliculasService.imprimirMayorMenor();

                        break;

                    case 6:
                        PeliculasService.imprimirMenorMayor();

                        break;

                    case 7:
                        PeliculasService.imprimir2000();

                        break;

                    case 8:
                        PeliculasService.imrpimir2KNota8();

                        break;

                    case 9:
                        PeliculasService.imprimirNotaUser2K();

                        break;

                    case 10:
                        PeliculasService.imprimirPelicula();

                        break;

                    case 11:
                        PeliculasService.imprimirPorDir();

                        break;


                    case 0:
                        System.out.println("Adios.");
                        break;
                    default:
                        System.out.println("Opción no válida");
                }


            } catch (InputMismatchException e) {
                System.out.println("Opción incorrecta.");
            }
        }


        //Opción para añadir una película:
        // PeliculasService.addPelicula();


    }
}
