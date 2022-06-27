package Tpe_prog3_parte_2;

public class Main {

    public static void main(String[] args) {
        GrafoDirigido grafo = new GrafoDirigido();
        CSVReader reader = new CSVReader();
        reader.read(grafo);
        System.out.println(grafo.getList());
        GrafoDirigido g=new GrafoDirigido();
        g=(GrafoDirigido) grafo.dfs("viajes");
        if(g!=null){
            System.out.println(g.getList());
        }


    }

}
