package swrpg.logic;

import swrpg.model.Nave;

import java.util.Iterator;
import java.util.List;

public class FlotaLogic {
    public void aplicarLLuviaMeteoritos (List<Nave> naves) {
        Iterator<Nave> it = naves.iterator();
        while (it.hasNext()){
            Nave nave = it.next();
            nave.setIntegridadCasco(nave.getIntegridadCasco()-40);
            if (nave.getIntegridadCasco() <= 0){
                it.remove();
                System.out.println(nave.getNombre());
            }
        }
    }
}
