import java.io.*;

public class LeerTxt {
    public static void LeerArchivo (CentroControl centroControl) {
        try (
                var file = new BufferedReader(new FileReader("datos.txt"))
                ){
            String linea;
            while ((linea = file.readLine()) != null){
                try {


                String v [] = linea.split("[|]");
                if (v[0].equalsIgnoreCase("NAVE")){
                    Nave nave = new Nave(0,v[2], v[3],Integer.parseInt(v[4]));
                    centroControl.addElementoEstelar(v[1],nave,v[5]);
                }
                else {
                    Tripulante tripulante = new Tripulante(0, v[2], v[3]);
                    centroControl.addElementoEstelar(v[1], tripulante, v[4]);
                }

                } catch (Exception e) {
                    System.out.println("ERROR: "+e.getMessage());
                }
            }
        } catch (Exception e) {
            System.out.println("ERROR: No se pudo abrir el archivo");
        }
    }
}
