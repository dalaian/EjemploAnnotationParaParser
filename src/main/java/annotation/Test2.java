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

import estructuras.DiccionarioDeClases;
import estructuras.MetodosVisibles;


public class Test2 {
	private static Reflections reflections = new Reflections("data", new MethodAnnotationsScanner(), new TypeAnnotationsScanner(), new SubTypesScanner(false));
	public static void main(String[] args)
	{
		run();
	}
	
	public static void run()
	{
		System.out.println();
		DiccionarioDeClases clases = new DiccionarioDeClases();
		
		
	}

}
