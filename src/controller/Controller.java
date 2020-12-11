package controller;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.logic.Modelo;
import view.View;

public class Controller {

	/* Instancia del Modelo*/
	private Modelo modelo;
	
	/* Instancia de la Vista*/
	private View view;
	
	/**
	 * Crear la vista y el modelo del proyecto
	 * @param capacidad tamaNo inicial del arreglo
	 */
	public Controller ()
	{
		view = new View();
		modelo = new Modelo();
	}
		
	public void run()
	{
		Scanner lector = new Scanner(System.in);
		boolean fin = false;
		String dato = "";
		String respuesta = "";
		
		
		while( !fin ){
			view.printMenu();

			int option = lector.nextInt();
			switch(option){
			case 1:
				view.printMessage("Cargar datos: ");
			    try {
					modelo.leerArchivo();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
			    //view.printMessage("Datos cargados");						
				break;

			/*
			case 2:
				try 
				{
				view.printMessage("Ingresar primer id: ");
				dato = lector.next();
                int id1 = Integer.parseInt(dato);
                view.printMessage("Ingresar segundo id: ");
				dato = lector.next();
                int id2 = Integer.parseInt(dato);
				modelo.REQ1(id1, id2);;
				} 
				catch (Exception e) 
				{
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
							
				break;

			case 3:
				try 
				{
				view.printMessage("Ingrese el tiempo minimo en minutos: ");
				dato = lector.next();
                int minutosMin = Integer.parseInt(dato);
                view.printMessage("Ingrese el tiempo maximo en minutos: ");
				dato = lector.next();
                int minutosMax = Integer.parseInt(dato);
                view.printMessage("Ingrese el id de la estacion: ");
				dato = lector.next();
                int idEstacion = Integer.parseInt(dato);
                view.printMessage("Cantidad de impresiones: ");
				dato = lector.next();
                Integer cantidadImpresiones = Integer.parseInt(dato);
				modelo.REQ2(minutosMin, minutosMax, idEstacion, cantidadImpresiones);
				} 
				catch (Exception e) 
				{
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
							
				break;					
				

			case 4:
				try 
				{
				modelo.REQ3();
				} 
				catch (Exception e) 
				{
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
							
				break;

			case 5: 
				try 
				{
					view.printMessage("Ingresar rango: ");
					dato = lector.next();
                    int rango = Integer.parseInt(dato);
					modelo.REQ5(rango);;
				} 
				catch (Exception e) 
				{
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
				break;
			case 6: 
				view.printMessage("--------- \n Hasta pronto !! \n---------"); 
				lector.close();
				fin = true;
				break;	

			default: 
				view.printMessage("--------- \n Opcion Invalida !! \n---------");
				break;
			}
	}	
	}*/
			}
		}
	}
}
