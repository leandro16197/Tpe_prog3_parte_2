
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVReader {
    String path="C:\\Users\\Lang Tecnologia\\IdeaProjects\\TPE_prog3_parte_2\\src\\Genero\\dataset1.csv";

    public void read(Grafo grafo) {
        ArrayList<String[]> lines = this.readContent();
        for(int i=0;i<lines.size();i++){
            String [] informacion=lines.get(i)[0].split(",");
            Vertice vertice=new Vertice(informacion[0]);
            String []aux=informacion[1].split(" ");
            for(int j=0;i<aux.length;i++){
                Vertice nuevo=new Vertice(aux[j]);
                grafo.agregarVertice(vertice,nuevo);
            }
        }
    }

    private ArrayList<String[]> readContent() {
        ArrayList<String[]> lines = new ArrayList<String[]>();

        File file = new File(this.path);
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) {
                line = line.trim();
                lines.add(line.split(";"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (bufferedReader != null)
                try {
                    bufferedReader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
        }

        return lines;
    }

}