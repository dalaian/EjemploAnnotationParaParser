package estructuras;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.reflections.Reflections;

public class DiccionarioDeClases extends Diccionario
{
	private MetodosVisibles metodos = new MetodosVisibles();
	private List<Class<?>> classesVisibles;
	public DiccionarioDeClases()
	{
		metodos.cargarMetodos();
		asociarMetodosConClases();
	}

	private List<Class<?>> cargarClases() 
	{
		//TODO Si la clase no esta agregarla en la lista de clases visibles.
		//Class claseDelMetodo = method.getDeclaringClass();
		List<Class <?>> arregloDeClases = new ArrayList<Class<?>>();
		
		for(String nombreDeClase : super.reflections.getAllTypes())
		{
			try 
			{
				arregloDeClases.add(Class.forName(nombreDeClase));
			} 
			catch (ClassNotFoundException e) 
			{
				e.printStackTrace();
			}
		}
		return arregloDeClases;
	}
	
	private void asociarMetodosConClases()
	{
		Set<Method> metodosVisibles = metodos.cargarMetodos();		
		Map<String, Method> parOrdenadoDeClasesMetodosVisibles = new HashMap<String, Method>();
		for (Method method : metodosVisibles) 
		{
			
			parOrdenadoDeClasesMetodosVisibles.put(Integer.toString(classesVisibles.indexOf(method.getDeclaringClass())) + method.getName(), method);
		}
	}



}
