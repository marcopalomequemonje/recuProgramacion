package rpg.ui;

import rpg.dao.CiudadDAO;
import rpg.dao.ClaseDAO;
import rpg.dao.RazaDAO;
import rpg.model.Ciudad;
import rpg.model.Clase;
import rpg.model.Personaje;
import rpg.model.Raza;

import java.util.List;
import java.util.Scanner;

public class Vista {
    static Scanner sc = new Scanner(System.in);
    static int opcion = 0;

    //MENU PRINCIPAL
    public static int menuPrincipal () throws Exception {
        System.out.println("MENU PRINCIPAL");
        System.out.println("1. Crear Personaje");
        System.out.println("2. Viajar a ciudad");
        System.out.println("3. Comprar Items");
        System.out.println("4. Cobro de Impuestos");
        System.out.println("0. Salir");
        System.out.println("Introduce opción: ");
        try {
            opcion = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            throw new Exception("LA OPCIÓN DEBE SER UN NUMERO");
        }
        if (opcion < 0 || opcion > 4){
            throw new Exception("OPCIÓN NO VALIDA");
        }
        return opcion;
    }

    public static Personaje pedirPersonaje () {
        try {
            System.out.println("CREACIÓN DE PERSONAJE");
            System.out.println("Introduzca el nombre del personaje");
            String nombre = sc.nextLine();
            Raza raza = mostrarRazas();
            Clase clase = mostrarClases();
            Ciudad ciudad = mostrarCiudades();
            int nivel = 1;
            int vida = 500;
            int oro = 100;
            Personaje personaje = new Personaje(0,nombre,nivel,oro,vida,raza,clase,ciudad);
            return personaje;
        } catch (Exception e) {
            System.out.println("ERROR: "+e.getMessage());
        }
        return null;
    }

    public static Raza mostrarRazas () throws Exception{
        System.out.println("Listado de Razas");
        RazaDAO razaDAO = new RazaDAO();
        List<Raza> razas = razaDAO.findAll();
        int index = 1;
        for (Raza raza : razas){
            System.out.println(index+". "+raza.getNombre());
            index++;
        }
        System.out.println("Introduzca una raza");
        try {
            int idraza = Integer.parseInt(sc.nextLine());
            return razas.get(idraza-1);

        } catch (Exception e) {
        throw new Exception("Raza no valida");
        }
    }


    public static Clase mostrarClases () throws Exception{
        System.out.println("Listado de Clases");
        ClaseDAO claseDAO = new ClaseDAO();
        List<Clase> clases = claseDAO.findAll();
        int index = 1;
        for (Clase clase : clases){
            System.out.println(index+". "+clase.getNombre());
            index++;
        }
        System.out.println("Introduzca una clase");
        try {
            int idclase = Integer.parseInt(sc.nextLine());
            return clases.get(idclase-1);

        } catch (Exception e) {
            throw new Exception("Clase no valida");
        }
    }
    public static Ciudad mostrarCiudades () throws Exception{
        System.out.println("Listado de Ciudades");
        CiudadDAO ciudadDAO = new CiudadDAO();
        List<Ciudad> ciudades = ciudadDAO.findAll();
        int index = 1;
        for (Ciudad ciudad : ciudades){
            System.out.println(index+". "+ciudad.getNombre());
            index++;
        }
        System.out.println("Introduzca una ciudad");
        try {
            int idciudad = Integer.parseInt(sc.nextLine());
            return ciudades.get(idciudad-1);

        } catch (Exception e) {
            throw new Exception("Ciudad no valida");
        }
    }

    public static Personaje pedirPersonajeViajar (){


        return null;
    }
}
