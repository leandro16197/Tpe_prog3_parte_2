package Tpe_prog3_parte_2;

import java.util.Iterator;

public interface Grafo<T> {
	
	// Agrega un vertice 
	public void agregarVertice(String v1,String v2);

	// Borra un vertice
	public void borrarVertice(Vertice verticeId);

	// Agrega un arco con una etiqueta, que conecta el verticeId1 con el verticeId2
	public void agregarArco(Vertice verticeId1, Vertice verticeId2,Integer a);

	// Borra el arco que conecta el verticeId1 con el verticeId2
	//public void borrarArco(Vertice verticeId1, Vertice verticeId2);

	// Verifica si existe un vertice
	public boolean contieneVertice(Vertice verticeId);

	// Verifica si existe un arco entre dos vertices
	public boolean existeArco(Vertice verticeId1, Vertice verticeId2);
	
	// Obtener el arco que conecta el verticeId1 con el verticeId2
	public Arco<T> obtenerArco(Vertice verticeId1, Vertice verticeId2);

	// Devuelve la cantidad total de vertices en el grafo
	public int cantidadVertices();

	// Devuelve la cantidad total de arcos en el grafo
	public int cantidadArcos();

	// Obtiene un iterador que me permite recorrer todos los vertices almacenados en el grafo 
	public Iterator<Integer> obtenerVertices();

	// Obtiene un iterador que me permite recorrer todos los vertices adyacentes a verticeId 
	public Iterator<Integer> obtenerAdyacentes(Vertice verticeId);

	// Obtiene un iterador que me permite recorrer todos los arcos del grafo
	public Iterator<Arco<T>> obtenerArcos();
		
	// Obtiene un iterador que me permite recorrer todos los arcos que parten desde verticeId
	public Iterator<Arco<T>> obtenerArcos(Vertice verticeId);
	
	
}
