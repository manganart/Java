package ProyectoPokemon.Clases;

import ProyectoPokemon.Utils.Pokedex;

public class Tipo {

    public String nombre;


    public Tipo(String nombre){
        this.nombre = nombre;
        Pokedex.checkTipoExiste(nombre);
        //COmprobar si existe y si existe, se setea el nombre correctamente. SIno, pues no

        //Estableccer tipo
        //->Comprobar tipo ataque
    }


}