package Tpe_prog3_parte_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public class GrafoDirigido<T> implements Grafo<T> {
  private ArrayList<Vertice> vertice;
  private HashMap map;
  private ArrayList<Vertice> subGrafo;
	public GrafoDirigido() {
		this.vertice =new ArrayList<Vertice>();
		this.map=new HashMap<Vertice,String>();
		this.subGrafo =new ArrayList();
	}

	@Override
	public void agregarVertice(String v1,String v2) {
		Vertice nuevo=new Vertice(v1);
		Vertice nuevo2=new Vertice(v2);

			if(this.contieneVertice(nuevo)==false) {
				this.vertice.add(nuevo);
			}
			if(this.contieneVertice(nuevo2)==false){
				this.vertice.add(nuevo2);
			}

			int pos1=this.getPosVertice(nuevo);
			int pos2=this.getPosVertice(nuevo2);

		if(this.existeArco(this.vertice.get(pos1), this.vertice.get(pos2))){
			Arco a = this.obtenerArco(this.vertice.get(pos1), this.vertice.get(pos2));
			a.setEtiqueta(a.getEtiqueta()+1);

		} else {
			this.agregarArco(this.vertice.get(pos1), this.vertice.get(pos2), 1);

		}

	}

	@Override
	public void borrarVertice(Vertice verticeId) {

	}
	public ArrayList<Vertice> getList(){return this.vertice;}
	@Override
	public void agregarArco(Vertice verticeId1,Vertice v2,Integer valor) {
		int pos = this.getPosVertice(verticeId1);
		if(pos>=0){
			if (this.contieneVertice(v2) == true) {
				this.vertice.get(pos).addAdyasentes(v2,valor);
			}
		}
	}

	@Override
	public boolean contieneVertice(Vertice vertice) {
		for(int i=0;i<this.vertice.size();i++){
			if(this.vertice.get(i).getId().equals(vertice.getId())){
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean existeArco(Vertice verticeId1, Vertice verticeId2) {
		int pos = this.getPosVertice(verticeId1);
		if(pos>=0) {
			if (this.contieneVertice(verticeId2)==true){
				return this.vertice.get(pos).contiene(verticeId2);
			}
		}
		return false;
	}

	@Override
	public Arco obtenerArco(Vertice verticeId1, Vertice verticeId2) {
		int pos=this.getPosVertice(verticeId1);
		int pos2=this.getPosVertice(verticeId2);
		if(pos>=0){
			if(this.contieneVertice(verticeId2)==true){
				return this.vertice.get(pos).getArco(verticeId2);
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
			if(this.vertice.get(i).getId().equals(verticeId.getId())){
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

	public ArrayList<String> getMasBuscado(String v,int cantidad){
		ArrayList<String>aux=new ArrayList<>();
		int pos =this.getVertice(v);
		if(pos>=0){
			Iterator temp=OrdenarPorEtiqueta(this.vertice.get(pos).getListaArco()).iterator();
			while(temp.hasNext() && cantidad>0){
				Arco a=(Arco) temp.next();
				aux.add(a.getVerticeDestino().getId());
				cantidad--;
			}
		}
		return aux;
	}

	private ArrayList<Arco> OrdenarPorEtiqueta(ArrayList listaArco) {
		ArrayList <Arco> t=listaArco;
		Collections.sort(t,new comparable());
		Collections.reverse(t);
		return t;
	}

	private int getVertice(String v) {
		for(int i=0;i<this.vertice.size();i++){
			if(this.vertice.get(i).getId().equals(v)){
				return i;
			}
		}
		return -1;
	}
	public ArrayList<String> secuenciaDeGeneros(String genero){
		ArrayList aux=new ArrayList();
		int pos =this.getVertice(genero);
		if(pos>=0){
			Iterator it=this.vertice.get(pos).getListaArco().iterator();
			while(it.hasNext()){
				Arco arco=(Arco) it.next();
				String v=arco.getVerticeDestino().getId();
				Vertice a=seleccion(this.vertice.get(this.getVertice(v)).getListaArco());
				if(!aux.contains(a)){
					aux.add(a);
				}
			}
		}
		return aux;
	}

	private Vertice seleccion(ArrayList array) {
		Integer max=0;
		Vertice verTemp = null;
		for(int i=0;i<array.size();i++){
			Arco v=(Arco)array.get(i);
			if(v.getEtiqueta()>max){
				max=v.getEtiqueta();
				verTemp=v.getVerticeDestino();
			}
		}
		return verTemp;
	}

	public Grafo dfs(String genero){
		int pos =this.getVertice(genero);
		if(pos>=0){
			Vertice v=this.vertice.get(pos);
			Iterator it=this.vertice.iterator();
			while(it.hasNext()){
				Vertice a=(Vertice) it.next();
				int posicion=this.getVertice(a.getId());
				this.map.put(this.vertice.get(posicion),"blanco");
			}

			ArrayList<String> aux=new ArrayList();
			aux.add(genero);
			Iterator it2=v.getListaArco().iterator();
			while(it2.hasNext()){
				Arco arco=(Arco)it2.next();
				if(this.map.get(arco.getVerticeDestino()).equals("blanco")) {
					return dfs_visit(arco.getVerticeDestino().getId(),genero,aux);
				}
			}
		}
		return null;
	}

	private GrafoDirigido dfs_visit(String origen, String destino, ArrayList<String> aux) {
		int posOrigen=this.getVertice(origen);
		this.map.replace(this.vertice.get(posOrigen),"amarillo");
		if(origen.equals(destino)){
			aux.add(destino);
			return subGrafo(aux);
		}else{
			Iterator it=this.vertice.get(posOrigen).getListaArco().iterator();

			while(it.hasNext()){

				Arco a=(Arco)it.next();

				int posicion=this.getVertice(a.getVerticeDestino().getId());

				if(this.map.get(this.vertice.get(posicion)).equals("blanco")){

					aux.add(this.vertice.get(posOrigen).getId());

					return dfs_visit(a.getVerticeDestino().getId(),destino,aux);
				}
			}
		}
		this.map.replace(this.vertice.get(posOrigen),"negro");
		return null;
	}

	private GrafoDirigido subGrafo(ArrayList<String> lista) {
		GrafoDirigido g=new GrafoDirigido();
		for(int i=0;i<lista.size()-1;i++) {
			System.out.println(lista.get(i)+"-"+lista.get(i+1));
			g.agregarVertice(lista.get(i),lista.get(i+1));
		}
		return g;
	}

}
