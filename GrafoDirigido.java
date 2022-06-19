import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class GrafoDirigido<T> implements Grafo<T> {
  private ArrayList<Vertice> vertice;

	public GrafoDirigido() {
		this.vertice =new ArrayList<Vertice>();
	}

	@Override
	public void agregarVertice(Vertice vertice, Vertice vertice2) {
		Integer contador=0;
			if(this.contieneVertice(vertice)==false) {
				this.vertice.add(new Vertice(vertice.toString()));
				this.agregarArco(vertice,vertice2, (T) contador);
				contador++;
			}

	}

	@Override
	public void borrarVertice(Vertice verticeId) {

	}
	public ArrayList getList(){return this.vertice;}
	@Override
	public void agregarArco(Vertice verticeId1, Vertice verticeId2, T etiqueta) {
		int pos = this.getPosVertice(verticeId1);
		if(pos>0){
			if (this.contieneVertice(verticeId2) == true) {
				this.vertice.get(pos).addAdyasentes(verticeId2,etiqueta);
			}
		}
	}

	@Override
	public void borrarArco(Vertice verticeId1, Vertice verticeId2) {
		int pos = this.getPosVertice(verticeId1);
		if(pos>0){
			if (this.contieneVertice(verticeId2) == true) {
				this.vertice.get(pos).deleteArco(verticeId2.toString());
			}
		}
	}

	@Override
	public boolean contieneVertice(Vertice verticeId) {
		for(int i=0;i<this.vertice.size();i++){
			if(this.vertice.get(i).getId()==verticeId.toString()){
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean existeArco(Vertice verticeId1, Vertice verticeId2) {
		int pos = this.getPosVertice(verticeId1);
		if(pos>0) {
			if (this.contieneVertice(verticeId2)==true){
				return this.vertice.get(pos).contiene(verticeId2.toString());
			}
		}
		return false;
	}

	@Override
	public Arco<T> obtenerArco(Vertice verticeId1, Vertice verticeId2) {
		int pos=this.getPosVertice(verticeId1);
		if(pos>0){
			if(this.contieneVertice(verticeId2)==true){
				return this.vertice.get(pos).getArco(verticeId2.toString());
			}
		}
		return null;
	}

	@Override
	public int cantidadVertices() {
		return this.vertice.size() ;
	}

	@Override
	public int cantidadArcos() {
		int total=0;
		for(int i=0;i<this.vertice.size();i++){
			total=total+this.vertice.get(i).adyasentesSize();
		}
		return total;
	}

	@Override
	public Iterator<Integer> obtenerVertices() {
		Iterator<Integer> it=this.getIdVertice().iterator();
		while(it.hasNext()){
			it.next();
		}
		return it;
	}

	@Override
	public Iterator<Integer> obtenerAdyacentes(Vertice verticeId) {
		int pos=this.getPosVertice(verticeId);
		if(pos>0){
			Iterator<Integer>it=this.vertice.get(pos).getIdAdyasentes().iterator();
			while(it.hasNext()){
				it.next();
			}
			return it;
		}
		return null;
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos() {
		ArrayList<Arco<T>>aux=new ArrayList<>();
		for(int i=0;i<this.vertice.size();i++){
			aux.addAll(this.vertice.get(i).getIdAdyasentes());
		}
		Iterator it=aux.iterator();
		while(it.hasNext()){
			it.next();
		}
		return it;
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos(Vertice verticeId) {
		int pos=this.getPosVertice(verticeId);
		if(pos>0){
			Iterator it=this.vertice.get(pos).getListaArco().iterator();
			while (it.hasNext()){
				it.next();
			}
			return it;
		}
		return null;
	}
	private int getPosVertice(Vertice verticeId){
		for(int i=0;i<this.vertice.size();i++){
			if(this.vertice.get(i).getId().equals(verticeId.toString())){
				return i;
			}
		}
		return -1;
	}
	private ArrayList<Integer> getIdVertice(){
		ArrayList aux=new ArrayList<Integer>();
		for(int i=0;i<this.vertice.size();i++){
			aux.add(this.vertice.get(i).getId());
		}
		return aux;
	}

	public ArrayList<Vertice> getMasBuscado(Vertice v,int cantidad){
		ArrayList<Vertice>aux=new ArrayList<>();
		Iterator it=ordenArcos(v.getAdyasentes());
		while(it.hasNext() && cantidad!=0){
			Vertice siguiente=(Vertice)it.next();
			if(cantidad>0) {
				aux.add(siguiente);
				cantidad--;
			}
		}
		return aux;
	}

	private Iterator ordenArcos(ArrayList adyasentes) {
		ArrayList aux=new ArrayList();
		aux = adyasentes;
		Collections.sort(aux);
		Collections.reverse(aux);
		Iterator it=aux.iterator();
		return it;
	}

}
