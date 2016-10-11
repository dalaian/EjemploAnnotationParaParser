package annotation;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;

import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.scanners.TypeAnnotationsScanner;

import data.Class20;

public class Test2 {

	public static void main(String[] args)
	{
		Reflections reflections = new Reflections("data", new MethodAnnotationsScanner(), new TypeAnnotationsScanner(), new SubTypesScanner());

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
	}

}
