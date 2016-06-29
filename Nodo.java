package Clases;

public class Nodo {

	int Dato;
	Nodo HijoIzquierdo, HijoDerecho;
	
	public Nodo(int Key){
		this.Dato=Key;
		this.HijoDerecho=null;
		this.HijoIzquierdo=null;
	}
	
}
