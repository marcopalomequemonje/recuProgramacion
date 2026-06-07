package swrpg;

import swrpg.dao.PersonajeDAO;
import swrpg.dao.PlanetaDAO;
import swrpg.exception.CreditosInsuficientesException;
import swrpg.logic.TiendaLogic;
import swrpg.model.Especie;
import swrpg.model.Personaje;
import swrpg.model.Planeta;
import swrpg.model.Profesion;

import java.util.List;

public class Main {
    public static void main(String[] args) throws CreditosInsuficientesException {
        System.out.println("=== 🌌 STAR WARS RPG SYSTEM LOADED 🌌 ===");

        /* //COMPROBACION PLANETAS
        PlanetaDAO planetaDAO = new PlanetaDAO();
        List<Planeta> planetas = planetaDAO.listarTodosLosPlanetas();

        for (Planeta planeta : planetas) {
            System.out.println(planeta);
        }
       Planeta planeta = new Planeta(1,"Urano",4);
        Especie especie = new Especie(1,"prueba",50);
        Profesion profesion = new Profesion(1,"Albañil",true);
        Personaje p = new Personaje();
        p.setId(3);
        p.setNombre("Obi-Wan");
        p.setIdEspecie(especie);
        p.setIdProfesion(profesion);
        p.setIdPlanetaActual(planeta);
        PersonajeDAO personajeDAO = new PersonajeDAO();
        personajeDAO.registrarPersonaje(p);
        TiendaLogic tiendaLogic = new TiendaLogic();
        System.out.println(tiendaLogic.consultarPrecioEquipo(2));
        System.out.println(tiendaLogic.consultarCreditosDispo(2));
        tiendaLogic.comprarEquipamiento(2,2);*/
        PlanetaDAO planetaDAO = new PlanetaDAO();
        System.out.println(planetaDAO.obtenerPlanetaMasPeligroso());
    }
}
