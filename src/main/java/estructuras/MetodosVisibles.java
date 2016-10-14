package estructuras;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Set;

import org.reflections.Reflections;

import annotation.MetodoVisiblePorParser;

public class MetodosVisibles extends Diccionario
{

	public Set<Method> cargarMetodos() 
	{
		return super.reflections.getMethodsAnnotatedWith(MetodoVisiblePorParser.class);	
	}

}
