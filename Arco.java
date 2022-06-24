package Tpe_prog3_parte_2;

public class Arco<T> {

	private Vertice verticeOrigen;
	private Vertice verticeDestino;
	private Integer etiqueta;

	public Arco(Vertice verticeOrigen, Vertice verticeDestino, int i) {
		this.verticeOrigen = verticeOrigen;
		this.verticeDestino = verticeDestino;
		this.etiqueta = i;
	}
	
	public Vertice getVerticeOrigen() {
		return verticeOrigen;
	}
	
	public Vertice getVerticeDestino() {
		return verticeDestino;
	}

	public Integer getEtiqueta() {
		return etiqueta;
	}

	public void setEtiqueta(Integer cantidad){
		this.etiqueta=+cantidad;
	}

	@Override
	public boolean equals(Object o) {
		Arco a=(Arco)o;
		if(this.verticeOrigen.getId()==a.getVerticeOrigen().getId() && this.verticeDestino.getId()==a.getVerticeDestino().getId()){
			return true;
		}
		return false;
	}


}
