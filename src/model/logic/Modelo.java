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

				if(! fila1[0].equals("ID"))
				{
					String fecha = fila1[4].substring(0, 10);
					Date date = new SimpleDateFormat("yyyy-MM-dd").parse(fecha);

					Accidente nuevo = new Accidente(date,Integer.parseInt(fila1[3]));

					arbol.put(date.toString(), nuevo);
					t++;

				}
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
