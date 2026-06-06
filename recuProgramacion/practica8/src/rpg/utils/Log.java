package rpg.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Log {
    public static void registrar(String mensaje){
        try (
                var file = new BufferedWriter(new FileWriter("info.log", true))
            ){
            LocalDateTime ahora = LocalDateTime.now();
            String horaespaniola = ahora.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
            file.write("["+horaespaniola+"] "+mensaje);
            file.newLine();
        } catch (Exception e) {
            System.out.println("ERROR AL ESCRIBIR EN EL LOG");;
        }
    }
}
