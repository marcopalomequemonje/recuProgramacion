package rpg.ui;

import rpg.dao.PersonajeDAO;
import rpg.exception.PersonajeDAOException;
import rpg.model.Item;
import rpg.model.Personaje;

public class MenuGestor {
    public void menuPrincipalGestor() {
        boolean salir = false;
        while (!salir) {
            try {
                int op = Vista.menuPrincipal();
                switch (op) {
                    case 1:
                        crearPersonaje();
                        break;
                    case 2:
                        viajar();
                        break;
                    case 3:
                        comprarItems();
                        break;
                    case 4:
                        cobrarImpuestos();
                        break;
                    case 0:
                        System.out.println("FIN DEL PROGRAMA");
                        salir = true;
                        break;
                }
            } catch (Exception e) {
                System.out.println("ERROR: "+e.getMessage());;
            }
        }
    }

    public void crearPersonaje () throws PersonajeDAOException {
        Personaje personaje = Vista.pedirPersonaje();
        if (personaje != null){
            PersonajeDAO personajeDAO = new PersonajeDAO();
            personajeDAO.crearPersonaje(personaje);
            System.out.println("Personaje creado correctamente");
        }
    }

    public void viajar () throws PersonajeDAOException {
        Personaje personaje = Vista.pedirPersonajeViajar();
        if (personaje != null){
            PersonajeDAO personajeDAO = new PersonajeDAO();
            personajeDAO.modificarPersonaje(personaje);
            System.out.println("Personaje cambiado de ciudad correctamente");
        }
    }

    public void comprarItems (){
        Personaje personaje = Vista.comprarItem();
    }

    public void cobrarImpuestos (){
        System.out.println("VAMOS A COBRAR IMPUESTOS MOROSO");
    }
}
