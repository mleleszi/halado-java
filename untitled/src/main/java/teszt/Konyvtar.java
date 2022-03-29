package teszt;

import java.util.ArrayList;
import java.util.List;

public class Konyvtar {
    private List<Software> softwares;

    public Konyvtar() {
        this.softwares = new ArrayList<>();
    }

    public void add(Software software) {
        if(softwares.contains(software)) {
            System.out.println("nem lehet hozzaadni, mar benne van a konyvtarban!");
        }

        softwares.add(software);
        System.out.println(software.getClass().getSimpleName() + " hozzaadva!");
    }

    public void delete(Software software) {
        if(!softwares.contains(software)) {
            System.out.println("nem lehet törölni, nincsen benne a konyvtarban!");
        }
        softwares.remove(software);
        System.out.println(software.getClass().getSimpleName() + " törölve!");
    }
}
