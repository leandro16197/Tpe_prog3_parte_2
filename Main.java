package Tpe_prog3_parte_2;

public class Main {

    public static void main(String[] args) {
        GrafoDirigido grafo = new GrafoDirigido();
        CSVReader reader = new CSVReader();
        reader.read(grafo);
        System.out.println(grafo.getList());
        System.out.println(grafo.getMasBuscado("informática",1000000));

    }

}
