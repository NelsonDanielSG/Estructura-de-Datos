package Clases;

import javax.swing.JOptionPane;
import java.util.Random;

public class Main {

	private static Random NumeroRandom = new Random();
	
	public static void main(String[] args){
		
		ArbolBinario AB = new ArbolBinario();
		ArbolBinario ABS = new ArbolBinario();
			
		int NumeroNodos,Opcion=0,Elemento;
		
		JOptionPane.showConfirmDialog(null, "Antes de empezar es necesario crear un Arbol Binario. �Procedemos?","A D V E R T E N C I A",JOptionPane.NO_OPTION);
		
		do{
			NumeroNodos = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa El Numero De Nodos: "));
		}while(NumeroNodos<1);
		
		int V[] = new int [NumeroNodos]; 
		int VectorABS[] = new int [NumeroNodos];
		
		JOptionPane.showMessageDialog(null, "Ingresando Nodos");
		
		for(int i=0;i<NumeroNodos;i++){
			Elemento = NumeroRandom.nextInt(101);
			AB.Insertar_Nodo(Elemento);
			VectorABS[i]=Elemento;
			V[i]=Elemento;
		}
							
		for(int i=0;i<NumeroNodos;i++){
			JOptionPane.showMessageDialog(null, "Nodo Ingresados: "+V[i]);
		}
		
		JOptionPane.showMessageDialog(null, "Arbol Generado Con Exito!");
		
		do{
			try{
				Opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
				"1.- Buscar Un Elemento En El �rbol\n"
				+ "2.- Eliminar Un Elemento del �rbol\n"
				+ "3.- Ver Recorridos\n"
				+ "4.- Ver Si Est� Lleno\n"
				+ "5.- Generar �rbol Sim�trico\n"
				+ "6.- Salir\n"
				+ "\n"
				+ "Elige Una Opcion: ","A R B O L E S   B I N A R I O S",JOptionPane.QUESTION_MESSAGE));
				
				switch(Opcion){
									
				case 1: //BUSCAR ELEMENTO
					
					int Valor2;
					
					if(!AB.EstaVac�o()){
						Valor2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa El Valor A Buscar: ",
								"Buscando Nodo",JOptionPane.NO_OPTION));
						AB.Buscar_Nodo(Valor2);
						if(AB.Buscar_Nodo(Valor2)==null){
							JOptionPane.showMessageDialog(null, "No Existe El Nodo En El �rbol",
									"ALGO SALI� MAL",JOptionPane.ERROR_MESSAGE);
						}
						else{
							JOptionPane.showMessageDialog(null, "Se Ha Encontrado El Nodo",
									"PERFECTO",JOptionPane.INFORMATION_MESSAGE);
						}
					}
					else{
						JOptionPane.showMessageDialog(null, "El �rbol Est� Va�o!","E R R O R",JOptionPane.ERROR_MESSAGE);
					}
					
					break;
					
				case 2://ELIMINAR ELEMENTO
					
					int Valor3;
					
					if(!AB.EstaVac�o()){
						Valor3 = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa El Valor A Eliminar: ",
								"Eliminando Nodo",JOptionPane.NO_OPTION));
						AB.Eliminar_Nodo(Valor3);
						if(!AB.Eliminar_Nodo(Valor3)==false){
							JOptionPane.showMessageDialog(null, "No Existe El Nodo En El �rbol",
									"ALGO SALI� MAL",JOptionPane.ERROR_MESSAGE);
						}
						else{
							JOptionPane.showMessageDialog(null, "Se Ha Eliminado El Nodo",
									"PERFECTO",JOptionPane.INFORMATION_MESSAGE);
						}
					}
					else{
						JOptionPane.showMessageDialog(null, "El �rbol Est� Va�o!","E R R O R",JOptionPane.ERROR_MESSAGE);
					}
					
					break;
					
				case 3://VER RECORRIDOS
					
					int Recorrido;
					
					do{
						
						Recorrido = Integer.parseInt(JOptionPane.showInputDialog(null,
								"1.- Recorrido Por Anchura\n"
								+ "2.- Recorrido InOrden\n"
								+ "3.- Recorrido PreOrden\n"
								+ "4.- Recorrido PostOrden\n"
								+ "5.- Hacer otro Recorrido\n"
								+ "6.- Volver Al Men� Principal\n"
								+ "7.- Salir del programa\n"
							    + "\n"
								+ "Elige Una Opcion: ","RECORRIDOS",JOptionPane.QUESTION_MESSAGE));
						
						switch(Recorrido){
						
							case 1://RECORRIDO POR ANCHURA
															
								AB.Recorrido_Anchura(AB.Raiz);
																
								break;
	
							case 2://RECORRIDO INORDEN
	
								if (!AB.EstaVac�o()) {
									AB.Recorrido_InOrden(AB.Raiz);
								} else {
									JOptionPane.showConfirmDialog(null, "El �rbol Est� Vac�o", "�E R R O R!",
											JOptionPane.ERROR_MESSAGE);
								}
	
								break;
	
							case 3://RECORRIDO PREORDEN
	
								if (!AB.EstaVac�o()) {
									AB.Recorrido_PreOrden(AB.Raiz);
								} else {
									JOptionPane.showConfirmDialog(null, "El �rbol Est� Vac�o", "�E R R O R!",
											JOptionPane.ERROR_MESSAGE);
								}
	
								break;
	
							case 4://RECORRIDO POSTORDEN
	
								if (!AB.EstaVac�o()) {
									AB.Recorrido_PostOrden(AB.Raiz);
								} else {
									JOptionPane.showConfirmDialog(null, "El �rbol Est� Vac�o", "�E R R O R!",
											JOptionPane.ERROR_MESSAGE);
								}
	
								break;
	
							case 5://REALIZAR OTRO RECORRIDO
								
								JOptionPane.showConfirmDialog(null, "�Seguro Que Desea Realizar Otro Recorrido?", 
										"�NUEVO RECORRIDO?",JOptionPane.ERROR_MESSAGE);
	
								break;
	
							case 6://VOLVER MENU PRINCIPAL
	
								JOptionPane.showConfirmDialog(null, "�Seguro Que Desea Volver Al Men� Principal?",
										"VOLVER AL MEN� PRINCIPAL", JOptionPane.INFORMATION_MESSAGE);
		
								break;
	
							case 7://SALIR
	
								JOptionPane.showConfirmDialog(null, "�Seguro Que Desea Salir De La Aplicaci�n?",
										"APLICACI�N FINALIZADA", JOptionPane.INFORMATION_MESSAGE);
	
								JOptionPane.showMessageDialog(null, "Aplicaci�n Finalizada");
	
								System.exit(0);
	
								break;
							
						}
						
					}while(Recorrido!=6);
																			
				case 4:
					
					int Respuesta;
					
					Respuesta = AB.Arbol_Lleno(NumeroNodos);
					
					if(Respuesta==1){
						JOptionPane.showMessageDialog(null, "El �rbol ES Un AB Lleno!","E X I T O",JOptionPane.NO_OPTION);
					}
					else{
						JOptionPane.showMessageDialog(null, "El �rbol NO Es un AB Lleno!","E R R O R",JOptionPane.ERROR_MESSAGE);
					}
					
					break;
					
				case 5://GENERAR �RBOL SIM�TRICO
					
					for(int i=0;i<NumeroNodos;i++){
						ABS.Arbol_Sim�trico(VectorABS[i]);
					}
					ABS.Recorrido_InOrden(ABS.Raiz);
				
					
					break;
					
				case 6: //SALIR
					
					JOptionPane.showConfirmDialog(null,"�Seguro Que Desea Salir De La Aplicaci�n?",
							"APLICACI�N FINALIZADA",JOptionPane.INFORMATION_MESSAGE);
					
					JOptionPane.showMessageDialog(null, "Aplicaci�n Finalizada");
					
					System.exit(0);
					
					break;
					
				default:	
					
					int OpcionSubMenu;
					
					do{
												
						OpcionSubMenu = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingresa Una Opci�n V�lida: \n"
								+ "1.- Volver Men� Principal\n"
								+ "2.- Salir\n","E R R O R",JOptionPane.NO_OPTION));
					}while(OpcionSubMenu<1 || OpcionSubMenu>2);
					
					if(OpcionSubMenu==2){
						
						JOptionPane.showConfirmDialog(null,"�Seguro Que Desea Salir De La Aplicaci�n?",
						"APLICACI�N FINALIZADA",JOptionPane.INFORMATION_MESSAGE);
						
						JOptionPane.showMessageDialog(null, "Aplicaci�n Finalizada");
						
						System.exit(0);
					}
					
					break;
					
				}			
				
			}
			catch(NumberFormatException N){
				JOptionPane.showConfirmDialog(null,"�Seguro Que Desea Salir De La Aplicaci�n?",
						"APLICACI�N FINALIZADA",JOptionPane.INFORMATION_MESSAGE);
				
				JOptionPane.showMessageDialog(null, "Aplicaci�n Finalizada");
				
				System.exit(0);
			}
		}while(Opcion!=6);
		
	}
	
}
