package Tpe_prog3_parte_2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVReader {
    String path="src\\Tpe_prog3_parte_2\\Genero\\dataset1.csv";

    public void read(Grafo grafo) {
        ArrayList<String[]> lines = this.readContent();
        for(int i=0;i<lines.size();i++){
            String [] informacion=lines.get(i)[0].split(",");

           for(int j=0;j<informacion.length-1;j++){
               grafo.agregarVertice(informacion[j],informacion[j+1]);

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