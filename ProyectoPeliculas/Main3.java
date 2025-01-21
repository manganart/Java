package ProyectoPeliculas;

import ProyectoPeliculas.Clases.Pelicula;
import ProyectoPeliculas.Utils.JsonReaderUtil;
import ProyectoPeliculas.services.PeliculasService;

import java.util.ArrayList;

public class Main3 {

    public static ArrayList<Pelicula> peliculas = null;

    public static void main(String[] args) {
        String pelisPath = "IMDB-api/Top250Movies.json";
        peliculas = JsonReaderUtil.loadJsonFile(pelisPath);


        //Opción para añadir una película:
        PeliculasService.addPelicula();


    }
}
