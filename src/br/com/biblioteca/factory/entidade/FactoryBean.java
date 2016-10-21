package br.com.biblioteca.factory.entidade;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public abstract class FactoryBean {
	
	public static Object getObject(String idBeanApplicationContext){
		@SuppressWarnings("resource")
		BeanFactory bf = new ClassPathXmlApplicationContext("META-INF/applicationContext.xml");
		Object obj = bf.getBean(idBeanApplicationContext); 
		return obj;
	}

}
