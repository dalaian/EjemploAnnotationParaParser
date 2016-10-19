package estructuras;

import java.lang.reflect.Method;
import java.util.Set;

import annotation.MetodoVisiblePorParser;

public class MetodosVisibles extends Diccionario
{
	public Set<Method> cargarMetodos() 
	{
		return super.reflections.getMethodsAnnotatedWith(MetodoVisiblePorParser.class);	
	}
}