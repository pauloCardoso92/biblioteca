package br.com.biblioteca.aplicacao.testes;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import br.com.biblioteca.factory.conexao.ConnectionFactoryDAO;

public class TestFactoryQuerySQLNative {

	private Session session = (Session) ConnectionFactoryDAO.getEntityManager().getDelegate();
	
	public void getColaboradoresClientes(){
		String sql = "SELECT " +
				"p.id_pessoa," +
				"p.nome," +
				"c.id_cliente," +
				"d.id_dependente " +
			" FROM " +
				" pessoa p" +
				" LEFT JOIN cliente c ON(c.id_pessoa = p.id_pessoa)" +
				" LEFT JOIN dependente d ON(d.id_pessoa = p.id_pessoa)" +
			" WHERE" +
				" c.id_pessoa IS NOT NULL " +
				" OR d.id_pessoa IS NOT NULL";
		SQLQuery sqlQuery = session.createSQLQuery(sql);
		sqlQuery.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		exibeDados(sqlQuery.list());
	}

	@SuppressWarnings("rawtypes")
	private void exibeDados(List registros) {
		System.out.println("\n\n");
		for (Object object : registros) {
			Map row = (Map) object;
			System.out.print("id_pessoa: " + row.get("id_pessoa"));
			System.out.println(", Nome: " + row.get("nome"));
		}
	}
	
}