package annotation;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.scanners.TypeAnnotationsScanner;

import estructuras.ClasesVisibles;
import estructuras.MetodosVisibles;


public class Test2 {
	static Reflections reflections = new Reflections("data", new MethodAnnotationsScanner(), new TypeAnnotationsScanner(), new SubTypesScanner(false));
	public static void main(String[] args)
	{
		
		/*
		Set<Method> allMethods = reflections.getMethodsAnnotatedWith(MetodoVisiblePorParser.class);
		
		Hashtable<Integer,List<Method>> contenedor = new Hashtable<Integer,List<Method>>();
		 

		System.out.println("Methods");
		
		for (Method method : allMethods)
		{
			String hash = method.getDeclaringClass().getName() + method.getName();
			hash = hash.toLowerCase();
			List<Method> methods = contenedor.get(hash.hashCode());
			if(methods == null)
			{
				methods = new ArrayList<Method>();
			}
			methods.add(method);
			contenedor.put(hash.hashCode(), methods);
		}

		Class20 class20 = new Class20();
		
		String key = class20.getClass().getName() + "multiply";
		List<Method> method = contenedor.get(key.toLowerCase().hashCode());
		System.out.println("hash");
		System.out.println(method.get(0).getName());
		*/
		
		run();
	}
	
	public static void run()
	{
		System.out.println();
		ClasesVisibles clases = new ClasesVisibles();
		MetodosVisibles metodos = new MetodosVisibles();
		
		List<Class<?>> classesVisibles = clases.cargarClases(reflections); 
		Set<Method> metodosVisibles = metodos.cargarMetodos(reflections);
		
		Map<String, Method> parOrdenadoDeClasesMetodosVisibles = new HashMap<String, Method>();
		for (Method method : metodosVisibles) 
		{
			parOrdenadoDeClasesMetodosVisibles.put(Integer.toString(classesVisibles.indexOf(method.getDeclaringClass())) + method.getName(), method);
		}
		
		System.out.println(parOrdenadoDeClasesMetodosVisibles.get("21join3"));
		System.out.println(System.currentTimeMillis());
	}

}
