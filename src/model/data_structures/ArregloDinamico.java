package model.data_structures;

import java.util.Iterator;

/**
 * 2019-01-23
 * Estructura de Datos Arreglo Dinamico de Strings.
 * El arreglo al llenarse (llegar a su maxima capacidad) debe aumentar su capacidad.
 * @author Fernando De la Rosa
 *
 */
public abstract class ArregloDinamico <T extends Comparable<T>> implements IArregloDinamico<T>{
		/**
		 * Capacidad maxima del arreglo
		 */
        private int tamanoMax;
		/**
		 * Numero de elementos presentes en el arreglo (de forma compacta desde la posicion 0)
		 */
        private int tamanoAct;
        /**
         * Arreglo de elementos de tamaNo maximo
         */
        private T elementos[ ];

        /**
         * Construir un arreglo con la capacidad maxima inicial.
         * @param max Capacidad maxima inicial
         */
		@SuppressWarnings("unchecked")
		public ArregloDinamico( int max )
        {
               elementos = (T[]) new Object[max];
               tamanoMax = max;
               tamanoAct = 0;
        }
        
		@SuppressWarnings("unchecked")
		public void agregar( T dato )
        {
               if ( tamanoAct == tamanoMax )
               {  // caso de arreglo lleno (aumentar tamaNo)
                    tamanoMax = 2 * tamanoMax;
                    T [ ] copia = elementos;
                    elementos = (T[]) new Object[tamanoMax];
                    for ( int i = 0; i < tamanoAct; i++)
                    {
                     	 elementos[i] = copia[i];
                    } 
            	    System.out.println("Arreglo lleno: " + tamanoAct + " - Arreglo duplicado: " + tamanoMax);
               }	
               elementos[tamanoAct] = dato;
               tamanoAct++;
       }

		public int darCapacidad() {
			return tamanoMax;
		}

		public int darTamano() {
			return tamanoAct;
		}

		public T darElemento(int i) {
			// TODO implementar
			return elementos[i];
		}

		public T buscar(T dato) {
			// TODO implementar
			// Recomendacion: Usar el criterio de comparacion natural (metodo compareTo()) definido en Strings.int i, j, aux;
			T respuesta=null;
			boolean encontro = false;
			for(int i =0;i< tamanoAct && !encontro;i++)
			{
				if(elementos[i].compareTo(dato)==0)
				{
					respuesta= elementos[i];
					encontro = true;
				}
				
				
			}
			
			return respuesta;
			
			//
		//	 T respuesta = null; 
			//	int i, j;
			//T aux;
			//  for (i = 0; i < elementos.length - 1; i++) 
			//  {
			//      for (j = 0; j < elementos.length - i - 1; j++) 
			//      {	         
			//          if (elementos[j + 1].compareTo(elementos[j]) == 0)	       
			//          {
			//              
			//          }
			//          
			//      }
			//      
			//  }
		        
		                    			
			
			
		}
		
		

		public T eliminar(T dato) 
		{
			// TODO implementar
			// Recomendacion: Usar el criterio de comparacion natural (metodo compareTo()) definido en Strings.
			
			T respuesta = null;
			boolean encontro = false;
			for(int i =0; i< tamanoAct;i++)
			{
				
				if(elementos[i].compareTo(dato)==0)
				{
					
				}
			}
			
			return respuesta;
		}

		

}
