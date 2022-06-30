package Tpe_prog3_parte_2;

public class Main {

    public static void main(String[] args) {
        GrafoDirigido grafo = new GrafoDirigido();
        CSVReader reader = new CSVReader();
        reader.read(grafo);
        GrafoDirigido g=(GrafoDirigido) grafo.dfs("viajes");
        System.out.println(g.getList());//lista de vertises del subGrafo
    }

}
