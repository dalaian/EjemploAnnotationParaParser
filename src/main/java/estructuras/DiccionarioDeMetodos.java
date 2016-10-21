package estructuras;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DiccionarioDeMetodos
{
	private static Map<String, Set<Method>> parOrdenadoDeClasesMetodosVisibles;
	private static Class<?>[] clasesVisibles;	
	
	public static void inicializar(Class<?>[] clasesVisibles)
	{
		DiccionarioDeMetodos.clasesVisibles = new Class<?>[clasesVisibles.length];
		System.arraycopy(clasesVisibles, 0, DiccionarioDeMetodos.clasesVisibles, 0, clasesVisibles.length);
		//TODO falta obtener las clases del parser, pero Cristian nos dijo que cuando uno compilaba todas clases iban para ahi
		
		parOrdenadoDeClasesMetodosVisibles = new HashMap<String, Set<Method>>();
	}
	
	public static void cargar() 
	{
		for(int i = 0 ; i < clasesVisibles.length ; i++)
		{
			for (Method metodo : clasesVisibles[i].getMethods()) 
			{
				//TODO validar que tiene la anotacion
				//method.getAnnotation(MetodoVisiblePorParser.class);
				String llaveDelMetodo = i + metodo.getName();
				if( parOrdenadoDeClasesMetodosVisibles.get(llaveDelMetodo) == null )
				{
					Set<Method> metodosDeUnParOrdenado = new HashSet<Method>();
					parOrdenadoDeClasesMetodosVisibles.put( llaveDelMetodo, metodosDeUnParOrdenado);
				}
				parOrdenadoDeClasesMetodosVisibles.get(llaveDelMetodo).add(metodo);
			}
		}
	}	
	
	public static Set<Method> obtenerMetodo(Class<?> clase, String nombreMetodo)
	{
		for(int i = 0 ; i < clasesVisibles.length ; i++)
		{
			if (clasesVisibles[i].equals(clase))
			{
				return parOrdenadoDeClasesMetodosVisibles.get( i + nombreMetodo );
			}
		}
		//TODO retornar una exception que indique que no se encontro el metodo
		return null;
	}

}