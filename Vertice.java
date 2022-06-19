import java.util.ArrayList;

public class Vertice<T> {
    private String id;
    private ArrayList<Arco> adyasentes;

    public Vertice(String id) {
        this.id = id;
       this.adyasentes=new ArrayList<Arco>();
    }

    public void addAdyasentes(Vertice id2,T etiqueta){
        if(this.contiene(id2.toString())==false){
            this.adyasentes.add(new Arco(this.id,id2.toString(),etiqueta));
        }
    }

    public boolean contiene(String destino){
        for(int i=0;i<this.adyasentes.size();i++){
            if(this.adyasentes.get(i).getVerticeDestino()==destino){
                return true;
            }
        }
        return false;
    }
    public Arco<T> getArco(String id){
        for(int i=0;i<this.adyasentesSize();i++){
            if(this.adyasentes.get(i).getVerticeDestino()==id){
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
    public ArrayList<String> getIdAdyasentes(){
        ArrayList<String> aux=new ArrayList<String>();
        for(int i=0;i<this.adyasentes.size();i++){
            aux.add(this.adyasentes.get(i).getVerticeDestino());
        }
        return aux;
    }
    public int adyasentesSize(){
        return this.adyasentes.size();
    }
    public ArrayList getAdyasentes() {
        return adyasentes;
    }
    public ArrayList<Arco> getListaArco(){
        return this.adyasentes;
    }
    public boolean deleteArco(String id){
        if(this.contiene(id)==true){
            for(int i=0;i<this.adyasentes.size();i++){
                if(this.adyasentes.get(i).getVerticeDestino()==id){
                    return this.adyasentes.remove(this.adyasentes.get(i));
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return id;
    }
}
