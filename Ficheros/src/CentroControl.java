import java.util.*;

public class CentroControl {
    private Map<String, ElementoEstelar> almacenamiento;
    private Set<String> ids;
    private Map<String, List<Nave>> agrupacion;


    public CentroControl() {
        this.almacenamiento = new HashMap<>();
        this.ids = new HashSet<>();
        this.agrupacion = new HashMap<>();
        List<Nave> navesNebulosa = new ArrayList<>();
        agrupacion.put("NEBULOSA",navesNebulosa);
    }

    public void addElementoEstelar (String id, ElementoEstelar elementoEstelar, String sector) throws FleetException{
        boolean result = ids.add(id);
        if (result == false){
            throw new FleetException();
        }
        almacenamiento.put(id,elementoEstelar);
        if (elementoEstelar instanceof Nave){
            agruparNaves(sector, elementoEstelar);
        }
    }
    public void agruparNaves (String sector, ElementoEstelar elementoEstelar){
        Nave nave = (Nave) elementoEstelar;
        if (sector == null){
            List<Nave> naves = agrupacion.get("NEBULOSA");
            naves.add(nave);
            agrupacion.put("NEBULOSA", naves);
        }
        else if (agrupacion.containsKey(sector)){
            List<Nave> naves = agrupacion.get(sector);
            naves.add(nave);
            agrupacion.put(sector, naves);
        }
        else {
            List <Nave> naves = new ArrayList<>();
            naves.add(nave);
            agrupacion.put(sector,naves);
        }

    }
    public void listadoAgrupado (){
        for (String sector : agrupacion.keySet()){
            System.out.println(sector);
            List<Nave> naves = agrupacion.get(sector);
            for (Nave nave : naves){
                System.out.println(nave);
            }
        }
    }
}
