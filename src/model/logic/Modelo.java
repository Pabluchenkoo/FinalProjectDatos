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

	private BinarySearchTree arbol;

	/**
	 * Constructor del modelo del mundo con capacidad predefinida
	 */
	public Modelo()
	{
		arbol = new BinarySearchTree();
	}

	int t = 0;
	public void cargarBST() throws Exception
	{
		try {
			
			String casting = ACCIDENTES_2019;

			CSVParser parser1 = new CSVParserBuilder().withSeparator(',').build();

			FileReader fr1 = new FileReader(casting);

			CSVReader reader1 = new CSVReaderBuilder(fr1).withCSVParser(parser1).build();

			String[] fila1 = null;

			while((fila1 = reader1.readNext()) != null) 
			{

				int k = 0; 
				
				String iD= fila1[k];
				k++;
				
				String source = fila1[k];
				k++;
				
				double TMC = Double.parseDouble(fila1[k]);
				k++;
				
				double severity = Double.parseDouble(fila1[k]);
				k++;
				
				Date start_Time = fila1[k]; // 
				k++;
				
				Date end_Time = fila1[k]; // 
				k++;
				
				double start_Lat = Double.parseDouble(fila1[k]);
				k++;
				
				double start_Lng = Double.parseDouble(fila1[k]);
				k++;
				double end_Lat = Double.parseDouble(fila1[k]);
				k++;
				
				double end_Lng = Double.parseDouble(fila1[k]);
				k++;
				double distance_mi = Double.parseDouble(fila1[k]);
				k++;
				
				String description = fila1[k];
				k++;
				
				double number = Double.parseDouble(fila1[k]);
				k++;
				
				String street = fila1[k];
				k++;
				
				String side =fila1[k];
				k++;
				
				String city = fila1[k];
				k++;
				
				String county = fila1[k];
				k++;
				
				String state =fila1[k];
				k++;
				
				String zipcode = fila1[k];
				k++;
				
				String country =fila1[k];
				k++;
				
				String timezone =fila1[k];
				k++;
				
				String airportCode =fila1[k];
				k++;
				
				Date weather_Timestamp = fila1[k]; //Carlos
				k++;
				
				double temperaturaF = Double.parseDouble(fila1[k]);
				k++;
				
				double windChillF =Double.parseDouble(fila1[k]);
				k++;
				
				double humidity = Double.parseDouble(fila1[k]);
				k++;
				
				double pressure =Double.parseDouble(fila1[k]);
				k++;
				
				double visibility =Double.parseDouble(fila1[k]);
				k++;
				
				String wind_Direction =fila1[k];
				k++;
				
				double windSpeed =Double.parseDouble(fila1[k]);
				k++;
				
				double precipitation =Double.parseDouble(fila1[k]);
				k++;
				
				String weatherCondition =fila1[k];
				k++;
				
				boolean amenity = Boolean.parseBoolean(fila1[k]);
				k++;
				
				boolean bump = Boolean.parseBoolean(fila1[k]);
				k++;
				boolean crossing = Boolean.parseBoolean(fila1[k]);
				k++;
				boolean giveWay = Boolean.parseBoolean(fila1[k]);
				k++;
				boolean junction = Boolean.parseBoolean(fila1[k]);
				k++;
				boolean noExit = Boolean.parseBoolean(fila1[k]);
				k++;
				boolean railway = Boolean.parseBoolean(fila1[k]);
				k++;
				boolean roundAbout = Boolean.parseBoolean(fila1[k]);
				k++;
				boolean station = Boolean.parseBoolean(fila1[k]);
				k++;
				boolean stop = Boolean.parseBoolean(fila1[k]);
				k++;
				boolean trafficCalming = Boolean.parseBoolean(fila1[k]);
				k++;
				boolean trafficSignal = Boolean.parseBoolean(fila1[k]);
				k++;
				boolean turningLoop = Boolean.parseBoolean(fila1[k]);
				k++;
				String sunriseSunset =fila1[k];
				k++;
				String civilTwilight =fila1[k];
				k++;
				String nauticalTwilight =fila1[k];
				k++;
				String astronomicalTwilight =fila1[k];
				k++;
				
				
				Accidente Accidente = new Accidente(iD, source, TMC, severity, start_Time, 
						end_Time, start_Lat, start_Lng, end_Lat, end_Lng, distance_mi,
						description, number, street, side, city, county,
						state , zipcode, country, timezone, airportCode, weather_Timestamp, temperaturaF,windChillF,
						humidity, pressure, visibility, wind_Direction, windSpeed, precipitation, weatherCondition,
						amenity, bump, crossing, giveWay, junction, noExit, railway, roundAbout,station,stop,
						trafficCalming,trafficSignal,turningLoop,sunriseSunset,civilTwilight,nauticalTwilight,astronomicalTwilight);
				
					arbol.put(date.toString(), nuevo);
//				if(! fila1[0].equals("ID"))
//				{
//					String fecha = fila1[4].substring(0, 10);
//					Date date = new SimpleDateFormat("yyyy-MM-dd").parse(fecha);
//
//					Accidente nuevo = new Accidente(date,Integer.parseInt(fila1[3]));
//
//					arbol.put(date.toString(), nuevo);
//					t++;
//
//				}
			}

			reader1.close();

		} 
		catch (Exception e) {
			throw new Exception(e.getMessage() +"pifeo");
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
		return (String)arbol.min();
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
			if (accidentes.get(i).darSeverity() == 1)
			{
				gravedad1++;
			}
			
			else if (accidentes.get(i).darSeverity() == 2)
			{
				gravedad2++;
			}
			else if (accidentes.get(i).darSeverity() == 3)
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
			vista.printMessage("Fecha: " + lista.get(i).darFechaInicio().toString() + " Severidad: "+ lista.get(i).darSeverity());
		}
	}
}
