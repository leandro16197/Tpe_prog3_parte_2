package Tpe_prog3_parte_2;


import java.util.Comparator;

public interface Ordenamiento extends Comparator<Arco> {
    @Override
    int compare(Arco o, Arco t1);
}
