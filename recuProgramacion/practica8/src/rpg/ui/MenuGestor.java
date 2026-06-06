package rpg.ui;

import rpg.dao.PersonajeDAO;
import rpg.exception.CiudadNoValidaException;
import rpg.exception.PersonajeDAOException;
import rpg.model.Ciudad;
import rpg.model.Item;
import rpg.model.Personaje;
import rpg.utils.Log;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
            } catch (PersonajeDAOException e) {
                Log.registrar("ERROR AL CREAR EL PERSONAJE EN LA BD");
                System.out.println("ERROR: " + e.getMessage());

            } catch (CiudadNoValidaException e) {
                Log.registrar("CIUDAD NO VÁLIDA");
                System.out.println(e.getMessage());
                ;
            } catch (Exception e) {
                System.out.println("ERROR: " + e.getMessage());
            }
        }
    }

    public void crearPersonaje() throws PersonajeDAOException {
        Personaje personaje = Vista.pedirPersonaje();
        if (personaje != null) {
            PersonajeDAO personajeDAO = new PersonajeDAO();
            personajeDAO.crearPersonaje(personaje);
            System.out.println("Personaje creado correctamente");
            Log.registrar("SE CREÓ UN NUEVO PERSONAJE: " + personaje.getNombre());
        }
    }

    public void viajar() throws PersonajeDAOException {
        Personaje personaje = Vista.pedirPersonajeViajar();
        if (personaje != null) {
            PersonajeDAO personajeDAO = new PersonajeDAO();
            personajeDAO.modificarPersonaje(personaje);
            System.out.println("Personaje cambiado de ciudad correctamente");
        }
    }

    public void comprarItems() {
        Personaje personaje = Vista.comprarItem();
        Log.registrar("SE REALIZÓ UNA COMPRA PARA EL PERSONAJE: " + personaje.getNombre());
    }

    public void cobrarImpuestos() throws CiudadNoValidaException, PersonajeDAOException {
        System.out.println("VAMOS A COBRAR IMPUESTOS MOROSO");
        Ciudad ciudad = Vista.mostrarCiudades();
        PersonajeDAO personajeDAO = new PersonajeDAO();
        List<Personaje> personajes = personajeDAO.findAll();
        Iterator<Personaje> personajeIterator = personajes.iterator();
        while (personajeIterator.hasNext()){
            Personaje personaje = personajeIterator.next();
            if (personaje.getCiudad_actual().getId() == ciudad.getId() ) {
                personaje.setOro(personaje.getOro() - 20);
                if (personaje.getOro() < 0) {
                    personajeIterator.remove();
                    personaje.setCiudad_actual(null);
                    personajeDAO.modificarPersonaje(personaje);
                }
            }
        }
        System.out.println("LISTADO DE PERSONAJES");
        for (Personaje personaje : personajes){
            System.out.println(personaje);
        }
    }
}
