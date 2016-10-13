package estructuras;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Set;

import org.reflections.Reflections;

import annotation.MetodoVisiblePorParser;

public class MetodosVisibles extends Diccionario
{

	@Override
	public List<Class<?>> cargarClases(Reflections reflection) 
	{
		return null;
	}

	@Override
	public Set<Method> cargarMetodos(Reflections reflection) 
	{
		return reflection.getMethodsAnnotatedWith(MetodoVisiblePorParser.class);	
	}

}
