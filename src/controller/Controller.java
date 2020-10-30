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
		modelo = new Modelo(1000000);
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
				    modelo.cargarBST(); 
				    view.printMessage("Datos cargados");						
					break;

				
				case 2:
					try 
					{
					view.printMessage("Ingresar fecha en el formato yyyy-MM-dd:");
					dato = lector.next();
                    Date fecha = new SimpleDateFormat("yyyy-MM-dd").parse(dato);
					modelo.REQ1(fecha);
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
					view.printMessage("Ingresar fecha en el formato yyyy-MM-dd:");
					dato = lector.next();
                    Date fecha = new SimpleDateFormat("yyyy-MM-dd").parse(dato);
					modelo.REQ2(fecha);
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
					view.printMessage("Ingresar fecha1 en el formato yyyy-MM-dd:");
					dato = lector.next();
                    Date fecha1 = new SimpleDateFormat("yyyy-MM-dd").parse(dato);
                    view.printMessage("Ingresar fecha2 en el formato yyyy-MM-dd:");
					dato = lector.next();
                    Date fecha2 = new SimpleDateFormat("yyyy-MM-dd").parse(dato);
					modelo.REQ3(fecha1,fecha2);
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
					view.printMessage("Ingresar hora:");
					dato = lector.next();	
				
					modelo.REQ5(dato);
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
		
	}	
}
