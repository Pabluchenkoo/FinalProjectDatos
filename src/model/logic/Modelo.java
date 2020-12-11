package model.logic;

import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.text.View;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import model.data_structures.ArregloDinamico;
import model.data_structures.DiGraph;
import model.data_structures.Edge;
import model.data_structures.TablaHashLinearProbing;
import model.data_structures.Vertex;


public class Modelo 
{

	public static final SimpleDateFormat FORMATO_FECHA = new SimpleDateFormat("yyyy-MM-dd");

	public static final SimpleDateFormat FORMATO_HORA = new SimpleDateFormat("HH:mm");

	public static final String DATA_TAXIS = "./data/taxi-trips-wrvz-psew-subset-small.csv";
	
	private ArregloDinamico<Taxis> taxis;
	
	private TablaHashLinearProbing<String,ArregloDinamico<Taxis>> linearCompa�ias;
	
	
	public Modelo()
	{
		taxis = new ArregloDinamico<>(1000000);
		
		linearCompa�ias = new TablaHashLinearProbing<>(1000000);
	}


	
	public void leerArchivo( ) throws Exception
	{	
		try 
		{
			CSVParser parser = new CSVParserBuilder().withSeparator(',').build();
			
			FileReader filereader = new FileReader(DATA_TAXIS);
		     
			 CSVReader csvReader = ( new CSVReaderBuilder(filereader)).withCSVParser(parser).build();
			 
			 csvReader.readNext();         
			 String [] data;
			 int contador = 0;
			 
		     while ((data = csvReader.readNext()) != null) 
		     {
		       
					
					int k = 0; 

					String TripID = data[k];
					k++;
					
					String TaxiID = data[k];
					k++;
					
					String TripStartTimestamp  = data[k];  
					k++;
					
					String TripEndTimestamp  = data[k];  
					k++;
					
					String TripSeconds = data[k];
					
					String TripMiles = data[k];
					
					String PickupCensusTract = data[k];
					k++;
					
					String DropoffCensusTract = data[k];
					k++;
					
					String PickupCommunityArea = data[k];
					k++;
					
					String DropoffCommunityArea = data[k];
					k++;
					
					String Fare = data[k];
					k++;
					
					String Tips = data[k];
					k++;
					
					String Tolls = data[k];
					k++;
					
					String Extras = data[k];
					k++;
					
					String TripTotal = data[k];
					k++;
					
					String PaymentType = data[k];
					k++;
					
					String Company = data[k];
					k++;
					
					String PickupCentroidLatitude = data[k];
					k++;
					
					String PickupCentroidLongitude = data[k];
					k++;
					
					String PickupCentroidLocation = data[k];
					k++;
					
					String DropoffCentroidLatitude = data[k];
					k++;
					
					String DropoffCentroidLongitude = data[k];
					k++;
					
					String DropoffCentroidLocation = data[k];
					k++;	
					
					
					Taxis taxi1 = new Taxis(TripID, TaxiID, TripStartTimestamp, TripEndTimestamp, TripSeconds, 
							TripMiles, PickupCensusTract, DropoffCensusTract, PickupCommunityArea, DropoffCommunityArea, 
							Fare, Tips, Tolls, Extras, TripTotal, PaymentType, Company, PickupCentroidLatitude, PickupCentroidLongitude,
							PickupCentroidLocation, DropoffCentroidLatitude, DropoffCentroidLongitude, DropoffCentroidLocation);	
					
					taxis.agregarAlFinal(taxi1);
					contador++;
					System.out.println(contador);
					String llave = Company;
					ArregloDinamico<Taxis> valor = new ArregloDinamico<>(1000000);
					valor.agregarAlFinal(taxi1);
					linearCompa�ias.put(llave, valor);
	
		     }
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	// Parte A 
	/* Requerimiento 1*/
	
	public int cantidadTaxis()
	{
		
		System.out.println("la cantidad de taxis es: " + taxis.darTamano());
		return taxis.darTamano();
		
	}
	
	/* Requerimiento 2 */
	
	public int compa�iasTaxiInscrito()
	{
		ArregloDinamico compa�ias = new ArregloDinamico(100000);
		for(int i =0; i < taxis.darTamano();i ++)
		{
			String compa�ia = taxis.darElemento(i).getCompany();
			
			for(int k=0; k<compa�ias.darTamano();k++)
			{
				if(!compa�ia.equals(compa�ias.obtenerElementoPos(k)))
				{
					compa�ias.agregar(compa�ia);
				}
			}

		}	
		System.out.println("la cantidad de compañias con un taxi inscrito es " + compa�ias.darTamano());
		return compa�ias.size();
		
	}
	
	/* requerimiento 3         */
	
	
	/*devuelve un arreglo con las compañias 
	 *
	 *
	 */
	public ArregloDinamico<String> Compa�ias()
	{
		ArregloDinamico<String> compa�ias = new ArregloDinamico<String>(100000);
		for (int i =0; i<taxis.darTamano();i++)
		{
			String compa�iai = taxis.darElemento(i).getCompany();
			
			int numTaxis = 0;
			if(compa�ias.estaPresente(compa�iai) != 1)
			{
				compa�ias.agregar(compa�iai);
			}
			
	
		}
		return compa�ias;
	

	}
	

	
	public void topTaxisAfiliados()
	{
		//ArregloDinamico<String> llaves = linearCompañias.keySet();
		int cantidadTaxis = 0;
		for(int i =0 ; i < linearCompa�ias.size();i++)
		{	
			String llave1 = linearCompa�ias.keySet().darElemento(i);
			
		
			System.out.println("compa�ia: " + llave1 + "  taxis inscritos: "+ cantidadTaxis);
		}
		
		
		
	}
	
	public void prueba()
	{
		int cantidadTaxis=1;
		for(int i = 0 ; i <= linearCompa�ias.size()-1 ; i++)
		{
			String compa�ia = linearCompa�ias.keySet().darElemento(i);
			
			for (int j = i+1; j<linearCompa�ias.size()-1 ; j++)
			{
				String comparar = linearCompa�ias.keySet().darElemento(j);
				
				if (compa�ia==comparar)
				{
					cantidadTaxis++;	
				}
			}
			System.out.println("Compa�ia: " + compa�ia+ " Cantidad de taxis: " +cantidadTaxis);			
		}
		
	}
	
}
	


