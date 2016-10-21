package br.com.biblioteca.factory.relatorio;

import java.util.HashMap;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import br.com.biblioteca.dominio.entidade.Cliente;
import br.com.biblioteca.relatorio.controller.InterfaceParametros;

public class RelatorioClientes implements InterfaceRelatorio<Cliente>, InterfaceParametros  {
	
	private static RelatorioClientes relatorioClientes;
	private GenericRelatorioFactory relatorioFactory = GenericRelatorioFactory.getInstance();
	
	private RelatorioClientes(){
	}

	public static RelatorioClientes getInstance() {
		if(relatorioClientes == null){
			return new RelatorioClientes();
		}return relatorioClientes;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Cliente> getResultSet(HashMap parametros) {
		Criteria criteria = relatorioFactory.getSession().createCriteria(Cliente.class);
		criteria.createAlias("pessoa", "p");
		if(parametros.get(NOME) != null){
			criteria.add(Restrictions.like("p.nome", parametros.get(NOME)));
		}
		if(parametros.get(SEXO) != null){
			criteria.add(Restrictions.eq("p.sexo", parametros.get(SEXO)));
		}
		if(parametros.get(SITUACAO) != null){
			criteria.add(Restrictions.eq("p.situacao", parametros.get(SITUACAO)));
		}
		if(parametros.get(ORDENACAO) != null){
			criteria.addOrder(Property.forName("p."+(String) parametros.get(ORDENACAO)).asc());
		}
		return criteria.list();
	}

}
