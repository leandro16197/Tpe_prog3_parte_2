package Tpe_prog3_parte_2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

    public class CSVReader {
        public static void read(Grafo grafo) {
            String csvFile="src\\Tpe_prog3_parte_2\\Genero\\dataset4.csv";
            String line = "";
            String cvsSplitBy = ",";

            try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
                while ((line = br.readLine()) != null) {
                    String[] items = line.split(cvsSplitBy);
                    for(int j=0;j<items.length-1;j++){
                        grafo.agregarVertice(items[j],items[j+1]);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
