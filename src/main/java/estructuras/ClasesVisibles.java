package estructuras;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.reflections.Reflections;

public class ClasesVisibles extends Diccionario
{
	@Override
	public List<Class<?>> cargarClases(Reflections reflection) 
	{
		List<Class <?>> arregloDeClases = new ArrayList<Class<?>>();
		
		for(String nombreDeClase : reflection.getAllTypes())
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

	@Override
	public Set<Method> cargarMetodos(Reflections reflection) {
		// TODO Auto-generated method stub
		return null;
	}


}
