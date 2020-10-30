package model.logic;

import java.io.FileReader;


import java.text.SimpleDateFormat;
import java.util.ArrayList;


import java.util.Date;


import com.opencsv.CSVReader;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReaderBuilder;


import model.data_structures.BinarySearchTree;
import model.data_structures.Lista;
import model.data_structures.RedBlackBST;
import view.View;



/**
 * Definicion del modelo del mundo
 * @param <T>
 *
 */
public class Modelo<T> {
	/**
	 * Atributos del modelo del mundo
	 */

	private View vista= new View();

	final static String ACCIDENTES_2019 = "data/us_accidents_dis_2019.csv";

	private BinarySearchTree<String,Accidente> arbol;
	
	private RedBlackBST arbolRB;

	/**
	 * Constructor del modelo del mundo con capacidad predefinida
	 */
	public Modelo(int capacidad)
	{
		arbol = new BinarySearchTree();
		arbolRB = new RedBlackBST();
	}

	int t = 0;
	public void cargarBST()
	{
		
		try {
			
			CSVParser parser1 = new CSVParserBuilder().withSeparator(',').build();

			FileReader fr1 = new FileReader(ACCIDENTES_2019);

			CSVReader reader1 = new CSVReaderBuilder(fr1).withCSVParser(parser1).build();
			
			reader1.readNext();

			String[] data = null;
			
			int numeroAccidentes=0;
			
			while((data = reader1.readNext()) != null) 
			{
				numeroAccidentes ++;
				
				int k = 0; 
				
				String iD= data[k];
				k++;
				
				String source = data[k];
				k++;
				
				String TMC =data[k];
				k++;
				
				double severity = Double.parseDouble(data[k]);
				k++;
				
				Date start_Time = new SimpleDateFormat("yyyy-MM-dd").parse(data[k].substring(0, 10)); // 
				k++;
				
				Date end_Time = new SimpleDateFormat("yyyy-MM-dd").parse(data[k].substring(0, 10)); // 
				k++;
				
				
				double start_Lat = Double.parseDouble(data[k]);
				k++;
				
				double start_Lng = Double.parseDouble(data[k]);
				k++;
				String end_Lat = data[k];
				k++;
				
				String end_Lng = data[k];
				k++;
				String distance_mi = data[k];
				k++;
				
				String description = data[k];
				k++;
				
				String number = data[k];
				k++;
				
				String street = data[k];
				k++;
				
				String side =data[k];
				k++;
				
				String city = data[k];
				k++;
				
				String county = data[k];
				k++;
				
				String state =data[k];
				k++;
				
				String zipcode = data[k];
				k++;
				
				String country =data[k];
				k++;
				
				String timezone =data[k];
				k++;
				
				String airportCode =data[k];
				k++;
				
				String weather_Timestamp = data[k]; //Carlos
				k++;
				
				String temperaturaF = data[k];
				k++;
				
				String windChillF =data[k];
				k++;
				
				String humidity = data[k];
				k++;
				
				String pressure =data[k];
				k++;
				
				String visibility =data[k];
				k++;
				
				String wind_Direction =data[k];
				k++;
				
				String windSpeed =data[k];
				k++;
				
				String precipitation =data[k];
				k++;
				
				String weatherCondition =data[k];
				k++;
				
				boolean amenity = Boolean.parseBoolean(data[k]);
				k++;
				
				boolean bump = Boolean.parseBoolean(data[k]);
				k++;
				boolean crossing = Boolean.parseBoolean(data[k]);
				k++;
				boolean giveWay = Boolean.parseBoolean(data[k]);
				k++;
				boolean junction = Boolean.parseBoolean(data[k]);
				k++;
				boolean noExit = Boolean.parseBoolean(data[k]);
				k++;
				boolean railway = Boolean.parseBoolean(data[k]);
				k++;
				boolean roundAbout = Boolean.parseBoolean(data[k]);
				k++;
				boolean station = Boolean.parseBoolean(data[k]);
				k++;
				boolean stop = Boolean.parseBoolean(data[k]);
				k++;
				boolean trafficCalming = Boolean.parseBoolean(data[k]);
				k++;
				boolean trafficSignal = Boolean.parseBoolean(data[k]);
				k++;
				boolean turningLoop = Boolean.parseBoolean(data[k]);
				k++;
				String sunriseSunset =data[k];
				k++;
				String civilTwilight =data[k];
				k++;
				String nauticalTwilight =data[k];
				k++;
				String astronomicalTwilight =data[k];
				k++;
				
				if(! iD.equals("ID"))
				{
				
				Accidente nuevo = new Accidente(iD, source, TMC, severity, start_Time, 
						end_Time, start_Lat, start_Lng, end_Lat, end_Lng, distance_mi,
						description, number, street, side, city, county,
						state , zipcode, country, timezone, airportCode, weather_Timestamp, temperaturaF,windChillF,
						humidity, pressure, visibility, wind_Direction, windSpeed, precipitation, weatherCondition,
						amenity, bump, crossing, giveWay, junction, noExit, railway, roundAbout,station,stop,
						trafficCalming,trafficSignal,turningLoop,sunriseSunset,civilTwilight,nauticalTwilight,astronomicalTwilight);
				
//					arbol.put(start_Time.toString(), nuevo);
					arbolRB.put(start_Time.toString(), nuevo);
				}
				System.out.println("datos:" + numeroAccidentes  );
			}


		} 
		catch (Exception e) {

//			throw new Exception(e.getMessage() +"dssssss");

			e.printStackTrace();

		}

	}
	
	public int darNumTotalAccidentes() throws Exception
	{
		ArrayList<T> x = (ArrayList<T>) arbol.valuesInRange(arbol.min(), arbol.max());
			return x.size();
	}
	
	public int darAltura() {
		return arbol.height();
	}
	
	public String darMin() {
		return arbol.min();
	}
	
	public String darMax() {
		return (String)arbol.max();
	}
	
	public int darNumKeys() {
		Lista lista = (Lista)arbol.keySet();
		return lista.size();
	}
	
	public String detallesGravedad(String key) {
		int gravedad1 = 0;
		int gravedad2 = 0;
		int gravedad3 = 0;
		int gravedad4 = 0;
		String respuesta = null;
		ArrayList<Accidente> accidentes = (ArrayList<Accidente>)arbol.get(key);
		for (int i = 0; i < accidentes.size(); i++) 
		{
			if (accidentes.get(i).getSeverity() == 1)
			{
				gravedad1++;
			}
			
			else if (accidentes.get(i).getSeverity() == 2)
			{
				gravedad2++;
			}
			else if (accidentes.get(i).getSeverity() == 3)
			{
				gravedad3++;
			}
			
			else
			{
				gravedad4++;
			}
				
		}
		respuesta = "El numero de accidentes por gravedad es: \nGravedad 1: " + gravedad1 + "\nGravedad 2: " + gravedad2 + "\nGravedad 3: " + gravedad3 + "\nGravedad 4: " + gravedad4;
		return respuesta;
	}

	public void get(String key)
	{
		ArrayList<Accidente> lista = arbol.get(key);

		for (int i = 0; i < lista.size(); i++) 
		{
			vista.printMessage("Fecha: " + lista.get(i).getStart_Time().toString() + " Severidad: "+ lista.get(i).getSeverity());
		}
	}
	
//	public int buscarAccidentesFecha(Date pFecha)
//	{
//		ArrayList<Accidente> lista;
//		int contador = 0;
//		
//		for (int i = 0; i < arbol.size() ; i++)
//		{
//			Date actual = arbol.get(pFecha);
//			if ()
//		}
//		
//		return contador;
//	}

}
