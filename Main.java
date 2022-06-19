public class Main {

    public static void main(String[] args) {
        GrafoDirigido grafo = new GrafoDirigido();
        CSVReader reader = new CSVReader();
        reader.read(grafo);
        Vertice nuevo=new Vertice("viajes");
        System.out.println(grafo.getList());
    }

}
