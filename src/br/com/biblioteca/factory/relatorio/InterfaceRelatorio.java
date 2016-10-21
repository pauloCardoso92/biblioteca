package br.com.biblioteca.factory.relatorio;

import java.util.HashMap;
import java.util.List;

public interface InterfaceRelatorio<T> {
	
	@SuppressWarnings("rawtypes")
	public abstract List<T> getResultSet(HashMap parametros);
	
}
