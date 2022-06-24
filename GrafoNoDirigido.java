package Tpe_prog3_parte_2;

public class GrafoNoDirigido<T> extends GrafoDirigido<T> {

	@Override
	public void agregarArco(Vertice verticeId1, Vertice verticeId2,Integer a) {
		super.agregarArco(verticeId1, verticeId2,a);
		super.agregarArco(verticeId2, verticeId1,a);
	}


}
