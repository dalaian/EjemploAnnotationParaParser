package annotation;

import java.lang.reflect.Method;

import data.Class20;
import estructuras.DiccionarioDeClases;


public class Test2
{
	public static void main(String[] args)
	{
		DiccionarioDeClases clases = new DiccionarioDeClases();
		Class20 class20 = new Class20();
		
		for(Method metodo : clases.obtenerMetodo(class20.getClass(), "method1"))
		{
			System.out.println(metodo.getName());
		}
		
	}
}
