package model.logic;

import java.io.FileReader;
import java.text.SimpleDateFormat;


import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import model.data_structures.DiGraph;


public class Modelo 
{
	 

	public static final SimpleDateFormat FORMATO_FECHA = new SimpleDateFormat("yyyy-MM-dd");

	public static final SimpleDateFormat FORMATO_HORA = new SimpleDateFormat("HH:mm");

	public static final String DATA_VIAJES = "./data/2013-07 - Citi Bike trip data.csv";

	private DiGraph<Integer,Estacion> grafoViajes;


	public Modelo()
	{
		grafoViajes = new DiGraph<Integer, Estacion>();
	}


	
	public String leerArchivo( ) throws Exception
	{
		String csv = DATA_VIAJES;
		CSVParser parser = new CSVParserBuilder().withSeparator(',').build();
		int cantidad = 0;
		try 
		{
			
			CSVReader reader = new CSVReaderBuilder(new FileReader(csv)).withSkipLines(1).withCSVParser(parser).build();
			
			String[] campos;
			
			while ((campos = reader.readNext()) != null)
			{
				double x = Double.parseDouble(campos[0]);
				
				double tiempo = x/60;
				
				double latitudInicial = Double.parseDouble(campos[5]);
				
				double longitudInicial = Double.parseDouble(campos[6]);
				
				int idEstacion = Integer.parseInt(campos[3]);
				
				String nombreEstacion = campos[4];
				
				int idEstacionLlegada = Integer.parseInt(campos[7]);
				
				String nombreEstacionLlegada = campos[8];
				
				double latitudLlegada = Double.parseDouble(campos[9]);
				
				double longitudLlegada = Double.parseDouble(campos[10]);
				
				Estacion nueva = new Estacion(nombreEstacion, idEstacion, longitudInicial, latitudInicial);
				
				Estacion llegada = new Estacion(nombreEstacionLlegada, idEstacionLlegada, longitudLlegada, latitudLlegada);
		
				try {
					
					grafoViajes.insertVertex(idEstacion, nueva);
				}
				catch (Exception e) 
				{
					e.printStackTrace();
				}

				try 
				{
					grafoViajes.insertVertex(idEstacionLlegada, llegada);
				}
				catch (Exception e) 
				{
					e.printStackTrace();
				}

				grafoViajes.addEdge(idEstacion, idEstacionLlegada, tiempo);

				cantidad++;
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		String info = "";
		info += "total de viajes : "+ cantidad + "\n";
		
		info += "total de estaciones: "+ grafoViajes.numVertices() +"\n";
		
		info += "total de arcos: "+ grafoViajes.numEdges() + "\n";

		return info;
	}

	



	



}
	


