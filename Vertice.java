package Tpe_prog3_parte_2;

import java.util.ArrayList;

public class Vertice<T> {
    private String id;
    private ArrayList<Arco> adyasentes;

    public Vertice(String nombre) {
        this.id = nombre;
       this.adyasentes=new ArrayList<Arco>();
    }

    public void addAdyasentes(Vertice v1,Integer arco){
        if(this.contiene(v1)==false){
            Arco a=new Arco(this,v1,arco);
            this.adyasentes.add(a);
        }
    }

    public boolean contiene(Vertice destino){
        for(int i=0;i<this.adyasentes.size();i++){
            if(this.adyasentes.get(i).getVerticeDestino().getId().equals(destino.getId())){
                return true;
            }
        }
        return false;
    }
    public Arco getArco(Vertice id){
        for(int i=0;i<this.adyasentesSize();i++){
            if(this.adyasentes.get(i).getVerticeDestino().equals(id)){
                return this.adyasentes.get(i);
            }
        }
        return null;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<Vertice> getIdAdyasentes(){
        ArrayList<Vertice> aux=new ArrayList<Vertice>();
        for(int i=0;i<this.adyasentes.size();i++){
            aux.add(this.adyasentes.get(i).getVerticeDestino());
        }
        return aux;
    }
    public int adyasentesSize(){
        return this.adyasentes.size();
    }

    public ArrayList<Arco> getListaArco(){
        return this.adyasentes;
    }

    public boolean deleteArco(Vertice id){
        if(this.contiene(id)==true){
            for(int i=0;i<this.adyasentes.size();i++){
                if(this.adyasentes.get(i).getVerticeDestino().getId()==id.getId()){
                    return this.adyasentes.remove(this.adyasentes.get(i));
                }
            }
        }
        return false;
    }
    @Override
    public boolean equals(Object obj) {
        Vertice o =(Vertice) obj;
        if(this.getId() == o.getId()){
            return true;
        }
        return false;
    }
    public String toString(){
        return this.getId();
    }


}
