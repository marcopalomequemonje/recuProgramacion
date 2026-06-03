package rpg.ui;

import rpg.dao.*;
import rpg.exception.*;
import rpg.model.*;

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
            throw new OpcionNumeroException();
        }
        if (opcion < 0 || opcion > 4){
            throw new OpcionNoValidaException();
        }
        return opcion;
    }

    public static Personaje pedirPersonaje () {
        try {
            System.out.println("VAMOS A CREAR TU PERSONAJE");
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
        throw new RazaNoValidaException();
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
            throw new ClaseNoValidaException();
        }
    }
    public static Ciudad mostrarCiudades () throws Exception{
        System.out.println("Listado de Ciudades");
        CiudadDAO ciudadDAO = new CiudadDAO();
        List<Ciudad> ciudades = ciudadDAO.findAll();
        int index = 1;
        for (Ciudad ciudad : ciudades){
            System.out.println(index+". "+ciudad.getNombre()+", "+ciudad.getNivel_minimo_acceso());
            index++;
        }
        System.out.println("Elige una ciudad");
        try {
            int idciudad = Integer.parseInt(sc.nextLine());
            return ciudades.get(idciudad-1);

        } catch (Exception e) {
            throw new CiudadNoValidaException();
        }
    }

    public static Personaje pedirPersonajeViajar (){
        try {
            System.out.println("VAMOS A VIAJAR A UNA CIUDAD");
            Personaje personaje = mostrarPersonajes();
            Ciudad ciudad = mostrarCiudades();
            if (personaje.getNivel() < ciudad.getNivel_minimo_acceso()){
                throw new NivelInsuficienteException();
            }
            personaje.setCiudad_actual(ciudad);
            System.out.println(personaje);
            return personaje;
        } catch (Exception e) {
            System.out.println("ERROR: "+e.getMessage());
        }
        return null;
    }

    public static Personaje mostrarPersonajes () throws Exception{
        System.out.println("Listado de Personajes");
        PersonajeDAO personajeDAO = new PersonajeDAO();
        List<Personaje> personajes = personajeDAO.findAll();
        int index = 1;
        for (Personaje personaje : personajes){
            System.out.println(index+". "+personaje.getNombre()+", "+personaje.getRaza().getNombre()+", "+personaje.getNivel()+", "
                    +personaje.getOro() +", "+personaje.getCiudad_actual().getNombre());
            index++;
        }
        System.out.println("Elige el personaje");
        try {
            int idpersonaje = Integer.parseInt(sc.nextLine());
            return personajes.get(idpersonaje-1);

        } catch (Exception e) {
            throw new PersonajeNoValidoException();
        }
    }

    public static Item mostrarItems() throws Exception{
        System.out.println("Listado de Items");
        ItemsDAO itemsDAO= new ItemsDAO();
        List<Item> items = itemsDAO.findAll();
        int index = 1;
        for (Item item : items){
            System.out.println(index+". "+item.getNombre()+", precio: "+item.getPrecio_oro());
            index++;
        }
        System.out.println("Elige el numero del Item que deseas comprar");
        try {
            int idItem = Integer.parseInt(sc.nextLine());
            return items.get(idItem-1);

        } catch (Exception e) {
            throw new ItemNoValidoException();
        }
    }

    public static Personaje comprarItem(){
        System.out.println("VAMONOS DE COMPRAS");
        int unidades = 0;
        try {
            Personaje personaje = mostrarPersonajes();
            Item item = mostrarItems();
            System.out.println("¿Cuantas unidades deseas comprar?");
            try {
                unidades = Integer.parseInt(sc.nextLine());
            }catch (Exception e) {
                throw new OpcionNumeroException();
            }
            int cantidadPagar = item.getPrecio_oro() * unidades;

            if (personaje.getOro() < cantidadPagar){
                throw new FondosInsuficientesException();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        return null;
    }
}
