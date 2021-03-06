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
//	private int numeroTaxis = 0;
	
	private TablaHashLinearProbing< String, Double > linearCompañias;
	
	
	public Modelo()
	{
		taxis = new ArregloDinamico<>(1000000);
		
		linearCompañias = new TablaHashLinearProbing<>(1000000);
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
//			 int contador = 0;
			 boolean termino = false;
//			 String llaveAnterior = "";
//			 int contador1=1;
//			 int contador2=0;
			 Double number = 1.0;
		     while ((data = csvReader.readNext()) != null && !termino == true) 
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
					
					int numero = 1;
					
					Taxis taxi1 = new Taxis(TripID, TaxiID, TripStartTimestamp, TripEndTimestamp, TripSeconds, 
							TripMiles, PickupCensusTract, DropoffCensusTract, PickupCommunityArea, DropoffCommunityArea, 
							Fare, Tips, Tolls, Extras, TripTotal, PaymentType, Company, PickupCentroidLatitude, PickupCentroidLongitude,
							PickupCentroidLocation, DropoffCentroidLatitude, DropoffCentroidLongitude, DropoffCentroidLocation, numero);	
					
					taxis.agregarAlFinal(taxi1);
					
//					contador++;
//					System.out.println(taxi1.getTripID());
//					System.out.println(taxi1.getPaymentType());
					
					
//					if(contador==5)
//					{
//						termino=true;
//					}
					
					
					String llave = Company;
					
					if(linearCompañias.contains(llave))
					{

						linearCompañias.put(llave, number + 1 );
					}
					else
					{					
						linearCompañias.put(llave, number);
					}
					
					
					
					
					System.out.println(llave);
					
					System.out.println(number);
					
//					if(!llave.equals(llaveAnterior))
//					{
//						
//						llaveAnterior = llave;
//						
//						if(contador1 == 1 && contador2==0)
//						{
//							contador2 ++;
//						}
//						else
//						{
//							numero = contador2;
//							linearCompañias.put(llave, valor);
//							llaveAnterior=llave;
//						}
//			
//					}
//					else
//					{
//						contador2++;
//						
//					}
					
					
					//System.out.println(contador);
					
	
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
	
	public int compañiasTaxiInscrito()
	{
		ArregloDinamico compañias = new ArregloDinamico(100000);
		for(int i =0; i < taxis.darTamano();i ++)
		{
			String compañia = taxis.darElemento(i).getCompany();
			
			for(int k=0; k<compañias.darTamano();k++)
			{
				if(!compañia.equals(compañias.obtenerElementoPos(k)))
				{
					compañias.agregar(compañia);
				}
			}

		}	
		System.out.println("la cantidad de compañias con un taxi inscrito es " + compañias.darTamano());
		return compañias.size();
		
	}
	
	/* requerimiento 3         */
	
	
	/*devuelve un arreglo con las compañias 
	 *
	 *
	 */
	public ArregloDinamico<String> Compañias()
	{
		ArregloDinamico<String> compañias = new ArregloDinamico<String>(100000);
		for (int i =0; i<taxis.darTamano();i++)
		{
			String compañiai = taxis.darElemento(i).getCompany();
			
			int numTaxis = 0;
			if(compañias.estaPresente(compañiai) != 1)
			{
				compañias.agregar(compañiai);
			}
			
	
		}
		return compañias;
	

	}
	

	
	public void tasisPorCompañias()
	{
		
		ArregloDinamico<String> keys = linearCompañias.keySet();
		
		ArregloDinamico<Double> values = linearCompañias.valueSet();
		
		for(int i =0 ; i < keys.size();i++)
		{	
			Double valor = linearCompañias.valueSet().darElemento(i);
			
			System.out.println(keys.darElemento(i));
			
			System.out.println(values.darElemento(i));
			
			
			
		}
		

		System.out.println(keys.size());
		
		
		
	}
	
	
		
	}
	

	


