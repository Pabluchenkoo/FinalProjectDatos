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

import model.data_structures.DiGraph;
import model.data_structures.Edge;
import model.data_structures.TablaHashLinearProbing;
import model.data_structures.Vertex;


public class Modelo 
{
	 

	public static final SimpleDateFormat FORMATO_FECHA = new SimpleDateFormat("yyyy-MM-dd");

	public static final SimpleDateFormat FORMATO_HORA = new SimpleDateFormat("HH:mm");

	public static final String DATA_VIAJES = "./data/201801-1-CitiBike-tripdata.csv";

	private DiGraph<Integer,Estacion> grafoViajes;
	private ArrayList<Viaje> viajes;
	
    private AlgoritmoKosajaru<Integer, String> Kosajaru;

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
	
	public ArrayList<Viaje> viajesEnRangoEdad(int rango, int anoPresente)
    {
        ArrayList<Viaje> enRango = new ArrayList<Viaje>();
        for (Viaje viaje : viajes) {
            int edad = anoPresente-viaje.getAnoNacimiento();
            if(rango == 1 )
            {
                if(edad>=0 && edad<=10){enRango.add(viaje);}
            }
            else if(rango ==2)
            {
                if(edad>10 && edad<21){enRango.add(viaje);}
            }
            else if(rango ==3)
            {
                if(edad>20 && edad<31){enRango.add(viaje);}
            }
            else if(rango ==4)
            {
                if(edad>30 && edad<41){enRango.add(viaje);}
            }
            else if(rango ==5)
            {
                if(edad>40 && edad<51){enRango.add(viaje);}
            }
            else if(rango ==6)
            {
                if(edad>50 && edad<61){enRango.add(viaje);}
            }
            else
            {
                if(edad>60){enRango.add(viaje);}
            }
        }

        return enRango;

    }
	
	public void REQ1(int id1, int id2) 
	{
		String respuesta = "";
		if (grafoViajes.getVertex(id1) == null)
			{
			System.out.println("El id de la estacion 1 no se encuentra");
			}
		if(grafoViajes.getVertex(id2) == null)
		{
			System.out.println("El id de la estacion 2 no se encuentra");
		}
		System.out.println("\nEn total se tienen " + Kosajaru.cantidadDeClusters() + " componentes fuertemente conectados.\n");
		if (!Kosajaru.fuertementeConectados(id1, id2)) 
		{
			System.out.println(" Las estaciones no estan fuertemente conectadas");
		}
		System.out.println("Las estaciones estan fuertemente conectadas");
		
	}	
	
	public void REQ2(int minutosMin, int minutosMax, int idEstacion, Integer cantidadImpresiones) 
	{
		
		System.out.println("cluster a buscar : " + Kosajaru.darClusterDe(idEstacion));
		DiGraph <Integer, String> graphoDeCluster = Kosajaru.formarGrafoParaCluster(Kosajaru.darClusterDe(idEstacion));
		System.out.println("Estaciones del cluster: " + Kosajaru.darIDsEnCluster(Kosajaru.darClusterDe(idEstacion)));
		
		if(graphoDeCluster.numVertices()<2)
			{
			System.out.println("No es posible establecer una ruta circular en esa estacion debido a que existen muy pocos vertices adyacentes a el\n");
			}
		
		AlgoritmoJohnson AJ = new AlgoritmoJohnson();
		List <List<Vertex<Integer,String>>> listaDeListas = AJ.simpleCyles(graphoDeCluster, graphoDeCluster.getVertex(idEstacion));
		double[] tiempoCadaRuta = new double[ listaDeListas.size() ];
		
		for(int i =0 ; i<listaDeListas.size() ;i++ )
		{
			List<Vertex<Integer,String>> listaActual = listaDeListas.get(i);
			double tiempoRuta = 0;
			
			for(int j = 1; j<listaActual.size();j++) 
			{
				tiempoRuta += graphoDeCluster.getVertex(listaActual.get(j-1).getId()).getEdge(listaActual.get(j).getId()).weight();
			}
			
			tiempoRuta += ((listaActual.size()-1)*20);
			tiempoCadaRuta[i] = tiempoRuta;
		}
		
		ArrayList<Integer> viajesFiltrados = new ArrayList<Integer>();
		
		for(int i = 0; i<tiempoCadaRuta.length;i++)
			{
				if(tiempoCadaRuta[i]>=minutosMin  && tiempoCadaRuta[i]<=minutosMax)
					{
					viajesFiltrados.add(i);
					}
			}
		
		if(viajesFiltrados.isEmpty()) 
		{
			int tiempoMinRuta = (int)tiempoCadaRuta[0];
			int tiempoMaxRuta = (int)tiempoCadaRuta[0];
			
			for (double doubleeact : tiempoCadaRuta) 
			{
				int intAct = (int)doubleeact;
				
				if(intAct<tiempoMinRuta) 
					{
					tiempoMinRuta = intAct;
					}
				if(intAct>tiempoMaxRuta) 
					{
					tiempoMaxRuta = intAct;
					}
			}
			System.out.println("\n Se establecieron: " + tiempoCadaRuta.length +" rutas circulares, pero no se pudieron a encontrar en ese rango de tiempo\n" 
			 +"Con un minimo de: " + tiempoMinRuta + " y un maximo de " + tiempoMaxRuta + " minutos");
		}
		System.out.println("\n Se han encontrado : " + viajesFiltrados.size() + " viajes circulares que parten y finalizan en la estacion entrada ");
		System.out.println("\n que tienen una duracion media de " + minutosMin + " a " + minutosMax + " minutos");
		System.out.println("\n Se imprimieron : "+ cantidadImpresiones);
		System.out.println("\n Rutas circulares disponibles:\n");
		
		int contador = 1;
		for (Integer integer : viajesFiltrados) 
		{
			if(contador>cantidadImpresiones)
				{
				break;
				}
			
			List <Vertex<Integer,String>> listaActual = listaDeListas.get(integer);
			System.out.println("\n Opcion " + contador + ":");
			
			for(int j = 1; j<listaActual.size();j++) 
			{
				System.out.println("\n Segmento "+ j + ": " + graphoDeCluster.getVertex(listaActual.get(j-1).getId()).getInfo() + "de la estacion con id:"+listaActual.get(j-1).getId() + " a la estacion  " + 
				graphoDeCluster.getVertex(listaActual.get(j).getId()).getInfo() + "con id: " + listaActual.get(j).getId() 
				+ "hay : " + (int)graphoDeCluster.getVertex(listaActual.get(j-1).getId()).getEdge(listaActual.get(j).getId()).weight() + " minutos de trayecto mas 20 minutos de parada");
			}
			contador++;
		}
	}
	
	public void REQ3()
	{
		int top1Llegada=0;
		int top2Llegada=0;
		int top3Llegada = 0;
		int top1Salida=0;
		int top2Salida=0;
		int top3Salida=0;	
		
		String nombreTop1Llegada = "";
		String nombreTop2Llegada= "";
		String nombreTop3Llegada= "";
		String nombreTop1Salida= "";
		String nombreTop2Salida= "";
		String nombreTop3Salida= "";
		
		int menorUtilizada1 = Integer.MAX_VALUE;
		int menorUtilizada2 = Integer.MAX_VALUE;
		int menorUtilizada3 = Integer.MAX_VALUE;
		
		String nombreMenorUtilizada1 = ""; 
		String nombreMenorUtilizada2 = "";
		String nombreMenorUtilizada3 = "";
		
		List<Vertex<Integer, Estacion>> listaVertices =  (List<Vertex<Integer, Estacion>>) grafoViajes.vertices();
		
		for (Vertex<Integer, Estacion> vertex : listaVertices) 
		{
			Estacion nombre = vertex.getInfo();
			int llegada = 0;
			
			for (Viaje viaje : viajes) 
			{
				if(viaje.getIdFinal() == vertex.getId())
				{
					llegada++;
				}
			}
			
			vertex.setViajesLlegando(llegada);
			int salida = vertex.getViajesSaliendo();
			int suma = llegada + salida;
			
			if(llegada>top3Llegada) 
			{
				if(llegada > top1Llegada)
				{
					top3Llegada = top2Llegada;
					nombreTop3Llegada = nombreTop2Llegada;
					top2Llegada = top1Llegada;
					nombreTop2Llegada = nombreTop1Llegada;
					top1Llegada = llegada;
					nombreTop1Llegada = nombre.toString();
				}
				else if(llegada > top2Llegada)
				{
					top3Llegada = top2Llegada;
					nombreTop3Llegada = nombreTop2Llegada;
					top2Llegada = llegada;
					nombreTop2Llegada = nombre.toString() ;
				}
				else
				{
					top3Llegada = llegada;
					nombreTop3Llegada = nombre.toString() ;
				}
			}
			if(salida > top3Salida)	
			{
				if(salida > top1Salida)
				{
					top3Salida = top2Salida;
					nombreTop3Salida = nombreTop2Salida;
					top2Salida = top1Salida;
					nombreTop2Salida = nombreTop1Salida;
					top1Salida = salida;
					nombreTop1Salida = nombre.toString();
				}
				else if(salida > top2Salida)
				{
					top3Salida = top2Salida;
					nombreTop3Salida = nombreTop2Salida;
					top2Salida = salida;
					nombreTop2Salida = nombre.toString();
				}
				else
				{
					top3Salida = salida;
					nombreTop3Salida = nombre.toString();
				}
			}
			if(suma < menorUtilizada3)
			{
				if(suma<menorUtilizada1)
				{
					menorUtilizada3 = menorUtilizada2;
					nombreMenorUtilizada3 = nombreMenorUtilizada2;
					menorUtilizada2 = menorUtilizada1;
					nombreMenorUtilizada2 = nombreMenorUtilizada1;
					menorUtilizada1 = suma;
					nombreMenorUtilizada1 = nombre.toString();
				}
				else if(suma < menorUtilizada2)
				{
					menorUtilizada3 = menorUtilizada2;
					nombreMenorUtilizada3 = nombreMenorUtilizada2;
					menorUtilizada2 = suma;
					nombreMenorUtilizada2 = nombre.toString();
				}
				else
				{
					menorUtilizada3 = suma;
					nombreMenorUtilizada3 = nombre.toString();
				}
			}
		}
		System.out.println( "El top 3 de estaciones con mas llegadas son:\n 1." + nombreTop1Llegada + "\n 2."+ nombreTop2Llegada +"\n 3."+ nombreTop3Llegada + ".\n\n "
				+ "El top 3 de estaciones con mas salidas son:\n 1." + nombreTop1Salida + "\n 2."+ nombreTop2Salida + "\n 3."+ nombreTop3Salida + ".\n\n "
				+ "El top 3 de estaciones menos utilizadas son:\n 1." + nombreMenorUtilizada1 + "\n 2."+ nombreMenorUtilizada2 + "\n 3."+ nombreMenorUtilizada3);
	}
	public void REQ5 (int rango)
	{
		int anoActual = 2020;
		
		ArrayList<Viaje> viajesEnRango = viajesEnRangoEdad(rango, anoActual);
		TablaHashLinearProbing<Integer, Integer> Origen = new TablaHashLinearProbing<>(50);
		TablaHashLinearProbing<Integer, Integer> Destino = new TablaHashLinearProbing<>(50);
		
		int idMaxOrigen;
		int numMaxViajesOrigen;
		int idMaxDestino;
		int numMaxViajesDestino;
		
		for (Viaje viaje : viajesEnRango) 
		{
			int numViajesOrigen;
			int numViajesDestino;
			
			if(Origen.get(viaje.getIdInicio())==null)
			{
				Origen.put(viaje.getIdInicio(), 0);
				
				for (Viaje viaje2 : viajesEnRango) 
				{
					if(viaje.getIdInicio()==viaje2.getIdInicio()) 
					{
						numViajesOrigen++;
					}
				}
				if(numViajesOrigen>numMaxViajesOrigen) 
				{	
					numMaxViajesOrigen = numViajesOrigen; 
					idMaxOrigen = viaje.getIdInicio();
				}
			}
			if(Destino.get(viaje.getIdFinal())==null)
			{
				Destino.put(viaje.getIdFinal(), 0);
				
				for (Viaje viaje2 : viajesEnRango) 
				{
					if(viaje.getIdFinal()==viaje2.getIdFinal())
						{
						numViajesDestino++;
						}
				}
				if(numViajesDestino>numMaxViajesDestino) 
				{	
					numMaxViajesDestino = numViajesDestino; 
					idMaxDestino = viaje.getIdFinal();
				}
			}
		}
		
		AlgoritmoJohnson AJ = new AlgoritmoJohnson();
		List <List<Vertex<Integer,String>>> listaDeCaminos = AJ.cycles(grafoViajes, grafoViajes.getVertex(idMaxOrigen), grafoViajes.getVertex(idMaxDestino));
		
		if(listaDeCaminos.size()==0)
		{
			System.out.println("No hay ningun camino entre las estaciones dentro del rango de edad");
		}
		
		double duracionMinima = Integer.MAX_VALUE;
		List<Vertex<Integer, String>> listaMinima = null;
		
		for (List<Vertex<Integer, String>> list : listaDeCaminos) 
		{
			double duracionCamino;
			for (int i =0;i<(list.size()-1);i++ ) 
			{
				List<Edge<Integer, String>> listaArcos = list.get(i).edges();
				boolean encontro = false;
				
				for(int j =0; j<listaArcos.size() && !encontro; j++)
				{
					if(listaArcos.get(j).getDest().equals(list.get(i+1)))
					{
						duracionCamino += listaArcos.get(j).weight();
						encontro = true;
					}
				}
			}
			if(duracionCamino<duracionMinima)
			{
				duracionMinima = duracionCamino;
				listaMinima = list;
			}
		}
		for(int i =(listaMinima.size()-1); i>=0;i--)
		{
			System.out.println( "\n" + listaMinima.get(i).getInfo());
		}
		String respuesta;
		respuesta += "\n La duracion de este recorrido es de " + duracionMinima;
		
		listaDeCaminos=null;
		listaMinima=null;
		viajesEnRango = null;
		Destino = null;
		Origen = null;
		
		System.out.println("La ruta de inicio es: " + grafoViajes.getVertex(idMaxOrigen).getInfo() +"\n"
				+ "La ruta final es: " + grafoViajes.getVertex(idMaxDestino).getInfo() + "\n"
				+ "La lista de estaciones en la ruta es: \n" + respuesta);
	}

	



	



}
	


