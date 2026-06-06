public class Main {
    public static void main(String[] args) {

            /*Tripulante tripulante1 = new Tripulante(1, "PEPITO", "CaDeTE");
            Tripulante tripulante2 = new Tripulante(2, "PEPITA", "CAPitan");
            tripulante1.setRango("almirante");
            //
            Nave nave1 = new Nave(3,"Orión", "Carga",500);
            Nave nave2 = new Nave(4,"Tomate", "Guerra",1000);

            centroControl.addElementoEstelar("t1",tripulante1,null);
            centroControl.addElementoEstelar("p1", nave1,"ALFA");
            centroControl.addElementoEstelar("t4",tripulante2, "BETA");
            centroControl.addElementoEstelar("p4", nave2, "ALFA");*/
            CentroControl centroControl = new CentroControl();
            LeerTxt.LeerArchivo(centroControl);
            centroControl.listadoAgrupado();


    }
}