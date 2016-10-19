package estructuras;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DiccionarioDeClases extends Diccionario
{
	private MetodosVisibles metodos;
	private List<Class<?>> clasesVisibles = new ArrayList<Class<?>>();
	private Map<String, Set<Method>> parOrdenadoDeClasesMetodosVisibles = new HashMap<String, Set<Method>>();
	
	public DiccionarioDeClases()
	{
		metodos = new MetodosVisibles();
		asociarMetodosConClases();
	}
	
	private void asociarMetodosConClases()
	{
		Set<Method> metodosVisibles = metodos.cargarMetodos();
		
		for (Method metodo : metodosVisibles) 
		{
			Class<?> claseDelMetodo = metodo.getDeclaringClass();
			if( !clasesVisibles.contains(claseDelMetodo) )
			{
				clasesVisibles.add(claseDelMetodo);
			}
			
			String llaveDelMetodo = Integer.toString(clasesVisibles.indexOf(claseDelMetodo)) + metodo.getName();
			if( parOrdenadoDeClasesMetodosVisibles.get(llaveDelMetodo) == null )
			{
				Set<Method> metodosDeUnParOrdenado = new HashSet<Method>();
				parOrdenadoDeClasesMetodosVisibles.put( llaveDelMetodo, metodosDeUnParOrdenado);
			}
			parOrdenadoDeClasesMetodosVisibles.get(llaveDelMetodo).add(metodo);
		}
	}

	public Set<Method> obtenerMetodo(Class<?> clase, String nombreMetodo)
	{
		return parOrdenadoDeClasesMetodosVisibles.get( Integer.toString(clasesVisibles.indexOf(clase)) + nombreMetodo );
	}

}
