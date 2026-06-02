import rpg.dao.ClaseDAO;
import rpg.dao.RazaDAO;
import rpg.model.Clase;
import rpg.model.Raza;
import rpg.ui.MenuGestor;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MenuGestor menuGestor = new MenuGestor();
        menuGestor.menuPrincipalGestor();
        /*
        ClaseDAO claseDAO = new ClaseDAO();
        List<Clase> clases = claseDAO.findAll();
        int indexclases = 0;
        for (Clase clase : clases){
            System.out.println(indexclases+" "+ clase);
            indexclases++;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduzca el nombre del nuevo perosnaje");
        String nombre = scanner.nextLine();
        System.out.println("Introduzca el numero de raza que desees: ");
        int idraza = scanner.nextInt();
        System.out.println("Introduzca el numero de clase que desees: ");
        int nclase = scanner.nextInt();

        //Personaje personaje = new Personaje(0,nombre,1,);*/
    }
}
