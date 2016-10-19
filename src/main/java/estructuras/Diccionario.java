package estructuras;

import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.scanners.TypeAnnotationsScanner;

public abstract class Diccionario
{
	protected Reflections reflections = new Reflections("data", new MethodAnnotationsScanner(), new TypeAnnotationsScanner(), new SubTypesScanner(false));
}
