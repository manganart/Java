package ProyectoPeliculas;

import ProyectoPeliculas.Clases.Pelicula;
import ProyectoPeliculas.Utils.JsonReaderUtil;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String pelisPath = "IMDB-api/Top250Movies.json";
        ArrayList<Pelicula> peliculas = JsonReaderUtil.loadJsonFile(pelisPath);

        //En este punuto, deberíamos tener un array list de 250 películas

        for (int i = 0; i < peliculas.size(); i++) {
            System.out.println(peliculas.get(i).getTitle());
        }


        //Mostrar las 10 mejores películas según IMDB
        ArrayList<Pelicula> best10Movies = new ArrayList<Pelicula>();

        double mayorNota = 0.0;

        for (int i = 0; i < peliculas.size(); i++) {
            //double.parseDouble --> transforma String a double
            if (mayorNota <= Double.parseDouble(peliculas.get(i).getImDbRating())) ;
            mayorNota = Double.parseDouble(peliculas.get(i).getImDbRating());

        }
        System.out.println(" ");
        System.out.println("La nota mayor de todas las películas es: " + mayorNota);
        System.out.println(" ");


        //Voy a comprobar las peliculas que tengan esa nota para incluirlas en el Arraylist
        //Cuando compruebe esa nota resto  0.1 y vuelvo a comprobar las pelis que tengan esa nota
        //Hasta que la nota sea 0.0 o el ArrayList tenga 10 elementos


        //Lo que hemos hecho aquí es ordenar de menor a mayor la lista de películas
        /**for (int i = 0; i < peliculas.size(); i++) {
         for (int j = 0; j < peliculas.size() - i - 1; j++) {
         if (Double.parseDouble(peliculas.get(i).getImDbRating()) < Double.parseDouble(peliculas.get(j).getImDbRating())) {

         Pelicula peli = peliculas.get(j + 1);
         peliculas.set(j + 1, peliculas.get(j));
         peliculas.set(j, peli);
         }

         }


         }**/
        System.out.println(" ");
        //Buscar las películas de antes del 2000
        //1º un for para recorrer la lista de películas
        for (int i = 0; i < peliculas.size(); i++) {
            //Ahora tengo que hacer una condición para comprobar cuales son antes del 2k
            if (Integer.parseInt(peliculas.get(i).getYear()) < 2000) {

                System.out.println(" - " + peliculas.get(i).getFullTitle());
            }

        }


        //Buscar las películas que tengan nota menos que 8.5
        System.out.println(" ");
        for (int i = 0; i < peliculas.size(); i++) {
            if (Double.parseDouble(peliculas.get(i).getImDbRating()) < 8.5) {

                System.out.println(" + " + peliculas.get(i).getFullTitle());
            }

        }


        //Buscar la película más antigua de la lista
        //Cojo la primera película de la posición de la lista
        Pelicula peliMasAntigua = peliculas.get(0);
        //Recorro el arrayList
        for (int i = 0; i < peliculas.size(); i++) {

            int anioPeli = Integer.parseInt(peliculas.get(i).getYear());

            if (anioPeli < Integer.parseInt(peliMasAntigua.getYear())) {
                peliMasAntigua = peliculas.get(i);



            }

        }
        System.out.println(" ");
        System.out.println(" 6 " + peliMasAntigua.getFullTitle());

        //Buscar la película más moderna de la lista

        for (int i = 0; i < peliculas.size(); i++) {

            int anioPeli = Integer.parseInt(peliculas.get(i).getYear());

            if (anioPeli > Integer.parseInt(peliMasAntigua.getYear())) {
                peliMasAntigua = peliculas.get(i);



            }

        }
        System.out.println(" ");
        System.out.println(" 7 " + peliMasAntigua.getFullTitle());


        System.out.println(" ");
        //Buscar las películas protagonizadas por Emma Stone
        for (int i = 0; i < peliculas.size(); i++) {
            //.contains(<name>) --> Sirve para encontrar un String dentro de un texto mayor
            if (peliculas.get(i).getCrew().contains("Emma Stone")) {

                System.out.println(" 0 " + peliculas.get(i).getFullTitle());
            }

        }

        System.out.println(" ");
        //Buscar las películas protagonizadas por Robin Williams
        for (int i = 0; i < peliculas.size(); i++) {
            //.contains(<name>) --> Sirve para encontrar un String dentro de un texto mayor
            if (peliculas.get(i).getCrew().contains("Robin Williams")) {

                System.out.println(" 4 " + peliculas.get(i).getFullTitle());
            }

        }




    }
}

