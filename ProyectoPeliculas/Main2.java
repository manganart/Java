package ProyectoPeliculas;

import ProyectoPeliculas.Clases.Pelicula;
import ProyectoPeliculas.Utils.JsonReaderUtil;

import java.util.ArrayList;
import java.lang.invoke.SwitchPoint;
import java.util.Collection;
import java.util.Comparator;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        String pelisPath = "IMDB-api/Top250Movies.json";
        ArrayList<Pelicula> peliculas = JsonReaderUtil.loadJsonFile(pelisPath);

        do {
            System.out.println("1. Imprimir las películas de mayor a menor nota. \n2.Imprimir las películas de menor a mayor nota. \n3.Imprimir las películas cuyo año de publicación sea del 2000 hasta la actualidad. \n4.Imprimir las películas cuyo año de publicación sea del 2000 hasta la actualidad que tengan una nota por encima de 8.8 (incluído). \n5.Imprimir las películas cuyo año de publicación sea del 2000 hasta la actualidad que tengan una nota por encima de una nota que diga el usuario por teclado. \n6.Imprimir por pantalla una película que el usuario introduce por teclado. \n7.Imprimir por pantalla las peliculas de un director que el usuario introduce por teclado.");
            Scanner scan = new Scanner(System.in);
            ;
            int eleccion = scan.nextInt();
            scan.nextLine();

            switch (eleccion) {
                case 1:
                    for (int i = 0; i < peliculas.size(); i++) {
                        double mayorNota = 0.0;

                        if (mayorNota <= Double.parseDouble(peliculas.get(i).getImDbRating())) {
                            mayorNota = Double.parseDouble(peliculas.get(i).getImDbRating());
                        }
                        System.out.println(mayorNota + " " + peliculas.get(i).getFullTitle());

                    }

                    return;

                case 2:
                    for (int i = peliculas.size() - 1; i > 0; i--) {

                        System.out.println(peliculas.get(i).getImDbRating() + " " + peliculas.get(i).getFullTitle());

                    }
                    return;
                case 3:
                    for (int i = 0; i < peliculas.size(); i++) {

                        if (Integer.parseInt(peliculas.get(i).getYear()) > 2000) {

                            System.out.println(" - " + peliculas.get(i).getFullTitle() + " " + peliculas.get(i).getYear());
                        }

                    }
                    return;
                case 4:
                    for (int i = 0; i < peliculas.size(); i++) {

                        if (Integer.parseInt(peliculas.get(i).getYear()) > 2000 && Double.parseDouble(peliculas.get(i).getImDbRating()) >= 8.8) {

                            System.out.println(" - " + peliculas.get(i).getImDbRating() + " " + peliculas.get(i).getFullTitle() + " " + peliculas.get(i).getYear());
                        }

                    }
                    return;
                case 5:
                    System.out.println("Introduzca la nota: ");
                    double nota = scan.nextDouble();
                    for (int i = 0; i < peliculas.size(); i++) {

                        if (Integer.parseInt(peliculas.get(i).getYear()) > 2000 && Double.parseDouble(peliculas.get(i).getImDbRating()) >= nota) {

                            System.out.println(" - " + peliculas.get(i).getImDbRating() + " " + peliculas.get(i).getFullTitle() + " " + peliculas.get(i).getYear());
                        }

                    }

                    return;
                case 6:
                    System.out.print("Introduzca la película: ");
                    String nombrePelicula = scan.nextLine();
                    for (int i = 0; i < peliculas.size(); i++) {
                        if (peliculas.get(i).getTitle().contains(nombrePelicula)) {
                            System.out.println(" - " + peliculas.get(i).getImDbRating() + " " + peliculas.get(i).getFullTitle() + " " + peliculas.get(i).getYear());

                        }

                    }

                    return;
                case 7:
                    System.out.print("Introduzca el director: ");
                    String nombreDirector = scan.nextLine();
                    for (int i = 0; i < peliculas.size(); i++) {
                        if (peliculas.get(i).getCrew().contains(nombreDirector)) {
                            System.out.println(" - " + peliculas.get(i).getImDbRating() + " " + peliculas.get(i).getFullTitle() + " " + peliculas.get(i).getYear());

                        }else if (!peliculas.get(i).getCrew().contains(nombreDirector)){
                            System.out.println("Director no encontrado");
                            break;
                        }
                    }


                    return;
            }


        } while (true);
    }
}
