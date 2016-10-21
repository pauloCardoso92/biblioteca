package br.com.biblioteca.dominio.controller;

import java.util.List;

public interface InterfaceController<T> {
	
	public abstract boolean persist() throws Exception;
	
	public abstract boolean update() throws Exception;
	
	public abstract boolean delete() throws Exception;
	
	public abstract List<T> getAll() throws Exception;
	
}