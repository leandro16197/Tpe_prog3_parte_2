public class GrafoNoDirigido<T> extends GrafoDirigido<T> {

	@Override
	public void agregarArco(Vertice verticeId1, Vertice verticeId2, T etiqueta) {
		super.agregarArco(verticeId1, verticeId2, etiqueta);
		super.agregarArco(verticeId2, verticeId1, etiqueta);
	}
	
	@Override
	public void borrarArco(Vertice verticeId1, Vertice verticeId2) {
		super.borrarArco(verticeId1, verticeId2);
		super.borrarArco(verticeId2, verticeId1);
	}

}
