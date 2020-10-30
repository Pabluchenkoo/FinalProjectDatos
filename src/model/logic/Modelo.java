package model.logic;

import java.io.FileReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


import java.util.Date;


import com.opencsv.CSVReader;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReaderBuilder;

import model.data_structures.ArregloDinamico;
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
	
	private RedBlackBST hora;

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
					String horaInicio = start_Time.toString().split(" ")[1];
					
					hora.put(horaInicio, nuevo);
				}
				System.out.println("datos:" + numeroAccidentes );
			}


		} 
		catch (Exception e) 
		{

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
	
	public String REQ1(Date fecha)throws Exception
	{
		
		int total = 0;
		if(arbolRB ==null) 
		{
			total = 0;
			throw new Exception("marica no metio los datos, perdon carlos"); 
		}
			
		DateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		
		String fInicial = fecha + " 00:00:00";
		
		String fFinal = fecha + " 23:59:59";
		
		Date fechaInicial = null;
		
		Date fechaFinal = null;
		
		fechaInicial = formato.parse(fInicial);
		
		fechaFinal = formato.parse(fFinal);
		
		ArrayList accidentes = (ArrayList) arbolRB.valuesInRange(fechaInicial, fechaFinal);
		
		if(accidentes == null)
		{
			throw new Exception( "No existen accidentes en esta fecha");
		}
		
		int s1 =0;
		
		int s2 =0;
		
		int s3 =0;
		
		int s4 =0;
		
		for(int i =0; i < accidentes.size(); i++)
		{
			Accidente accidente = (Accidente)accidentes.get(i);
			
			if(accidente.getSeverity()==1)
			{
				s1++;
				total++;
			}
			
			else if(accidente.getSeverity()==2)
			{
				s2++;
				total++;
			}
			
			else if(accidente.getSeverity()==3)
			{
				s3++;
				total++;
			}
			
			else
			{
				s4++;
				total++;
			}
		}
		
		String r ="total de accidentes: " + total + "\n De severidad 1 " + s1 + 
		"\n De severidad 2: " + s2 + "\n De severidad 3:" + s3 + "\n De severidad 4"
		+ s4;
		
		return r;
	}
	public String REQ2(Date pFecha) throws Exception
	{
		String respuesta = "";
		{
	        String fecha = "2019-12-05";
	        
	        Date inicial = new SimpleDateFormat("yyyy-MM-dd").parse(fecha);
	        
	        ArregloDinamico<Date> accidentesFecha = (ArregloDinamico<Date>) arbolRB.keysInRange(inicial, pFecha);
	        
	        ArregloDinamico<Accidente> valoresFecha = (ArregloDinamico<Accidente>) arbolRB.valuesInRange(inicial, pFecha);
	        
	        int total = valoresFecha.size();
	        
	        Date masAccidentes = null;
	        
	        if(total == 0) 
	        {
	            throw new Exception("No hay fechas");
	        }

	        int contador = 0;
	        
	        for (int i = 0; i < accidentesFecha.size(); i++)
	        {
	            Date fechaAccidentes = accidentesFecha.darElemento(i);
	            for (int j = 0; j < valoresFecha.size(); j++)
	            {
	                Date fechaComparacion = valoresFecha.darElemento(j).getStart_Time();
	                
	                int comparacion = 0;
	                
	                if (fechaAccidentes.compareTo(fechaComparacion) == 0)
	                {
	                    comparacion++;
	                }
	                
	                if (comparacion > contador)
	                {
	                    contador = comparacion;
	                    masAccidentes = fechaAccidentes;
	                }
	            }
	        }
	        respuesta = "accidentes antes de la fecha:" + total + 
	        		"\n fecha con mas accidentes: " + masAccidentes ;
	        
	        return respuesta;
	    }
	}
	
	public String REQ3(Date fecha1, Date fecha2) throws Exception
	{
		ArregloDinamico<Accidente> accidentes = (ArregloDinamico<Accidente>) arbolRB.valuesInRange(fecha1, fecha2);



        int total = 0;
		if(accidentes == null)
		{
			throw new Exception( "No existen accidentes en esta fecha");
		}
		
		int s1 =0;
		
		int s2 =0;
		
		int s3 =0;
		
		int s4 =0;
		
		for(int i =0; i < accidentes.size(); i++)
		{
			Accidente accidente = (Accidente)accidentes.darElemento(i);
			
			if(accidente.getSeverity()==1)
			{
				s1++;
				total++;
			}
			
			else if(accidente.getSeverity()==2)
			{
				s2++;
				total++;
			}
			
			else if(accidente.getSeverity()==3)
			{
				s3++;
				total++;
			}
			
			else
			{
				s4++;
				total++;
			}
		}
		
		if(s1>s2 && s1>s3 && s1 >s4)
		{
			return "total de accidentes: " + total + "la severidad con mayor numero de accidentes es la severidad 1:" + s1   ;
		}
		else if(s2>s1 && s2>s3 && s2 >s4)
		{
			return "total de accidentes: " + total + "la severidad con mayor numero de accidentes es la severidad 2:" + s2   ;
		}
		else if(s3>s1 && s3>s2 && s3 >s4)
		{
			return "total de accidentes: " + total + "la severidad con mayor numero de accidentes es la severidad 3:" + s3   ;
		}
		else if(s4>s1 && s4>s2 && s4 >s3)
		{
			return "total de accidentes: " + total + "la severidad con mayor numero de accidentes es la severidad 4:" + s4   ;
		}
		return "total de accidentes: " + total;
		
		
	}

	
	public String REQ5(String pHora) throws Exception
	{
		DateFormat formato = new SimpleDateFormat("hh:mm:ss");
		Date calendario = (Date)formato.parse(pHora);
		if (calendario.getMinutes() >= 0 && calendario.getMinutes() <= 29)
		{
			calendario.setMinutes(00);
		}
		else 
		{
			calendario.setMinutes(30);;
		}
		
		if (calendario.getSeconds() >= 0 && calendario.getSeconds() <=29)
		{
			calendario.setSeconds(0);
		}
		else 
		{
			calendario.setSeconds(30);
		}
		
		String fecha = "00:00:00";
		
		String fecha2 = "23:59:59";
		
		Date horaFinal = new SimpleDateFormat("hh:mm:ss").parse(fecha2);
		
		Date incial = new SimpleDateFormat("hh:mm:ss").parse(fecha);
		
		ArregloDinamico<Accidente> todosLosAccidentes = (ArregloDinamico<Accidente>) hora.valuesInRange(incial, horaFinal);
		
		ArregloDinamico<Accidente> valuesHora = (ArregloDinamico<Accidente>) hora.valuesInRange(incial, calendario);
		
		ArregloDinamico<Accidente> s0 = new ArregloDinamico<Accidente>(800000);
		
		ArregloDinamico<Accidente> s1 = new ArregloDinamico<Accidente>(800000);
		
		ArregloDinamico<Accidente> s2 = new ArregloDinamico<Accidente>(800000);
		
		
		ArregloDinamico<Accidente> s3 = new ArregloDinamico<Accidente>(800000);
		
		int total = valuesHora.size();
		
		int cantidadAccidentesComparacion = todosLosAccidentes.size();
		
		int porcentaje = (total * 100) / cantidadAccidentesComparacion;
		
		for (int i = 0; i < valuesHora.size(); i++)
		{
			Accidente valor = valuesHora.darElemento(i);
			if (valor.getSeverity() == 0)
			{
				s0.agregarAlFinal(valor);
			}
			else if (valor.getSeverity() == 1)
			{
				s1.agregarAlFinal(valor);
			}
			else if (valor.getSeverity() == 2)
			{
				s2.agregarAlFinal(valor);
			}
			else
			{
				s3.agregarAlFinal(valor);
			}
		}
		String respuesta = "cantidad de accidentes en el rango: " 
		+ total + " \n El porcentaje de accidentes entre ese rango: " + porcentaje 
		+ "%" + " \n Accidentes con gravedad 0 fueron: " + s0.size() 
		+ " \n Accidentes con gravedad 1 fueron: " + s1.size() + 
		" \n Accidentes con gravedad 2 fueron: " + s2.size() + "\n" 
		+ "\n Accidentes con gravedad 3 fueron: " + s3.size();
		return respuesta;
	}

	}
	
	


