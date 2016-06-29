package Clases;

import javax.swing.JOptionPane;
import java.util.LinkedList;

public class ArbolBinario {
	
	LinkedList<Nodo> Cola = new LinkedList<Nodo>();
	LinkedList<Nodo> ColaAux = new LinkedList<Nodo>();

	Nodo Raiz;
	
	public ArbolBinario(){
		Raiz=null;
	}
	
	public void Insertar_Nodo(int Key){
		
		Nodo NuevoNodo = new Nodo(Key);
		
		if(Raiz==null){
			Raiz=NuevoNodo;
		}
		else{
			Nodo Auxiliar=Raiz;
			Nodo Padre;
			while(true){
				Padre=Auxiliar;
				if(Key<Auxiliar.Dato){
					Auxiliar=Auxiliar.HijoIzquierdo;
					if(Auxiliar==null){
						Padre.HijoIzquierdo=NuevoNodo;
						return;
					}
				}
				else{
					Auxiliar=Auxiliar.HijoDerecho;
					if(Auxiliar==null){
						Padre.HijoDerecho=NuevoNodo;
						return;
					}
				}
			}
		}
	}
	
	public boolean EstaVacío(){
		return Raiz==null;
	}
	
	public void Recorrido_InOrden(Nodo R){
		if(R!=null){
			Recorrido_InOrden(R.HijoIzquierdo);
			System.out.print(R.Dato+", ");
			Recorrido_InOrden(R.HijoDerecho);
		}
	}
	
	public void Recorrido_PreOrden(Nodo R){
		if(R!=null){
			System.out.print(R.Dato+", ");
			Recorrido_PreOrden(R.HijoIzquierdo);
			Recorrido_PreOrden(R.HijoDerecho);
		}
	}
	
	public void Recorrido_PostOrden(Nodo R){
		if(R!=null){
			Recorrido_PostOrden(R.HijoIzquierdo);
			Recorrido_PostOrden(R.HijoDerecho);
			System.out.print(R.Dato+", ");
		}
	}
	
	public Nodo Buscar_Nodo(int Key){
		Nodo Auxiliar=Raiz;
		while(Auxiliar.Dato!=Key){
			if(Key<Auxiliar.Dato){
				Auxiliar=Auxiliar.HijoIzquierdo;
			}
			else{
				Auxiliar=Auxiliar.HijoDerecho;
			}
			if(Auxiliar==null){
				return null;
			}
		}
		return Auxiliar;
	}
	
	public boolean Eliminar_Nodo(int Key){
		Nodo Auxiliar=Raiz;
		Nodo Padre=Raiz;
		boolean Izq=true;
		while(Auxiliar.Dato!=Key){
			Padre=Auxiliar;
			if(Key<Auxiliar.Dato){
				Izq=true;
				Auxiliar=Auxiliar.HijoIzquierdo;
			}
			else{
				Izq=false;
				Auxiliar=Auxiliar.HijoDerecho;
			}
			if(Auxiliar==null){
				System.out.print("no esta el nodo");/////////////
				return false;
			}
		}
		if(Auxiliar.HijoIzquierdo==null && Auxiliar.HijoDerecho==null){
			if(Auxiliar==Raiz){
				Raiz=null;
			}
			else if(Izq){
				Padre.HijoIzquierdo=null;
			}
			else{
				Padre.HijoDerecho=null;
			}	
		}
		else if(Auxiliar.HijoDerecho==null){
			if(Auxiliar==Raiz){
				Raiz=Auxiliar.HijoIzquierdo;
			}
			else if(Izq){
				Padre.HijoIzquierdo=Auxiliar.HijoIzquierdo;
			}
			else{
				Padre.HijoDerecho=Auxiliar.HijoIzquierdo;
			}		
		}
		else if(Auxiliar.HijoIzquierdo==null){
			if(Auxiliar==Raiz){
				Raiz=Auxiliar.HijoDerecho;
			}
			else if(Izq){
				Padre.HijoIzquierdo=Auxiliar.HijoDerecho;
			}
			else{
				Padre.HijoDerecho=Auxiliar.HijoIzquierdo;
			}				
		}
		else{
			Nodo Reemplazo=Obtener_Reemplazante(Auxiliar);
			if(Auxiliar==Raiz){
				Raiz=Reemplazo;	
			}
			else if(Izq){
				Padre.HijoIzquierdo=Reemplazo;
			}
			else{
				Padre.HijoDerecho=Reemplazo;
			}
			Reemplazo.HijoIzquierdo=Auxiliar.HijoIzquierdo;
		}
		return true;
	}
	
	public Nodo Obtener_Reemplazante(Nodo Cambio){
		Nodo ReemplazarPadre=Cambio;
		Nodo Reemplazo=Cambio;
		Nodo Auxiliar=Cambio.HijoDerecho;
		while(Auxiliar!=null){
			ReemplazarPadre=Reemplazo;
			Reemplazo=Auxiliar;
			Auxiliar=Auxiliar.HijoIzquierdo;
		}
		if(Reemplazo!=Cambio.HijoDerecho){
			ReemplazarPadre.HijoIzquierdo=Reemplazo.HijoDerecho;
			Reemplazo.HijoDerecho=Cambio.HijoDerecho;
		}
		return Reemplazo;
	}
	
	public void Arbol_Simétrico(int Key){
		
		Nodo NuevoABS = new Nodo(Key);
			
			if(Raiz==null){
				Raiz=NuevoABS;
			}
			else{
				Nodo Auxiliar=Raiz;
				Nodo Padre;
				while(true){
					Padre=Auxiliar;
					if(Key<Auxiliar.Dato){
						Auxiliar=Auxiliar.HijoDerecho;
						if(Auxiliar==null){
							Padre.HijoDerecho=NuevoABS;
							return;
						}
					}
					else{
						Auxiliar=Auxiliar.HijoIzquierdo;
						if(Auxiliar==null){
							Padre.HijoIzquierdo=NuevoABS;
							return;
						}
					}
				}
			}
				
	}
	
	public int Arbol_Lleno(int N){
	
		int Mod=N%2;
		return Mod;
		
	}
	
	public void Recorrido_Anchura(Nodo R){
			
		Nodo Aux;
		
		if(R!=null){
			Cola.offer(R);
			while(!Cola.isEmpty()){
				Aux=Cola.poll();
				ColaAux.offer(Aux);
				if(Aux.HijoIzquierdo!=null){
					Cola.offer(Aux.HijoIzquierdo);
				}
				if(Aux.HijoDerecho!=null){
					Cola.offer(Aux.HijoDerecho);
				}
			}
			System.out.println(ColaAux);
		}
	}
	

	
}























