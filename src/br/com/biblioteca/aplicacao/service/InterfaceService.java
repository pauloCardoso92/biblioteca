package br.com.biblioteca.aplicacao.service;

import java.util.List;

public interface InterfaceService<T> {
	
	public abstract boolean persist(T entity);
	
	public abstract boolean update(T entity);
	
	public abstract boolean delete(T entity);
	
	public abstract List<T> getAll();
	
}