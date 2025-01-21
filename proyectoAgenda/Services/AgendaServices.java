package proyectoAgenda.Services;

import proyectoAgenda.clases.Persona;

import java.util.ArrayList;

public class AgendaServices {
    private static ArrayList<Persona> agenda = new ArrayList<Persona>();

    public boolean addPersona(Persona persona) {
        //Hay que comprobar si la persona existe en el arr y si no existe se añade
        try {
            if (!this.checkPersona(persona.getDni())) {
                AgendaServices.agenda.add(persona);
                return checkPersona(persona.getDni());
            }
        } catch (NullPointerException e) {
            System.out.println("Error en los datos ...");
        }

        return false;
    }


    public boolean deletePersona(Persona persona) {
        //Hay que comprobar si esa persona está en el Arr, si está se elimina
        for (int i = 0; i < agenda.size(); i++) {
            if (agenda.get(i).getDni().equals(persona.getDni())) {
                AgendaServices.agenda.remove(i);


                return true;

            }
        }

        return false;
    }

    public boolean checkPersona(String dni) {
        boolean personaExiste = false;
        //Comprueba si la persona está en el arr o no
        for (int i = 0; i < agenda.size(); i++) {
            if (agenda.get(i).getDni().equals(dni)) {
                System.out.printf("La persona ya está registrada");
                personaExiste = true;
            }
        }

        return false;
    }
}
