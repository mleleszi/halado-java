import teszt.Nev;

import java.util.*;
import java.util.stream.Collectors;


public class MyClass {
    public static void main(String[] args) {
        List<Nev> nevekLista = new ArrayList<>();
        nevekLista.stream().filter(nev -> nev.getKeresztnev().equals("Sandor")).findFirst().orElse(null).getVezeteknev();
    }
}
