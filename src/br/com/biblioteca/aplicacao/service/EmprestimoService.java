package br.com.biblioteca.aplicacao.service;

import java.util.ArrayList;
import java.util.List;

import br.com.biblioteca.aplicacao.util.Mensagem;
import br.com.biblioteca.aplicacao.validacoes.ValidaCampos;
import br.com.biblioteca.dominio.entidade.Emprestimo;
import br.com.biblioteca.dominio.entidade.Pessoa;
import br.com.biblioteca.infraestrutura.DAO.EmprestimoDAO;

public class EmprestimoService implements InterfaceService<Emprestimo>{
	
	private EmprestimoDAO emprestimoDAO = new EmprestimoDAO();
	private List<Emprestimo> emprestimos = new ArrayList<Emprestimo>(); 
	private ValidaCampos validaCampos = ValidaCampos.getInstance();
	private Mensagem mensagem = Mensagem.getInstance();
	
	@Override
	public boolean persist(Emprestimo entity) {
		if(validaCampos(entity) == false){
			return false;
		}try{
			emprestimoDAO.save(entity); 
			emprestimos.add(entity);
			mensagem.exibeMensagemINFOCadastroComSucesso();
			return true;
		}catch(Exception ex){
			mensagem.exibeMensagemERRORPersistirDados(ex);
			ex.printStackTrace();
		}return false;
	}

	@Override
	public boolean update(Emprestimo entity) {
		if(validaCampos(entity) == false){
			return false;
		}try {
			emprestimoDAO.update(entity);
			emprestimos.removeAll(emprestimos);
			mensagem.exibeMensagemINFOAlteradoComSucesso();
			return true;
		} catch (Exception ex) {
			mensagem.exibeMensagemERRORAlterarDados(ex);
			ex.printStackTrace();
		}return false;
	}

	@Override
	public boolean delete(Emprestimo entity) {
		return false;
	}

	@Override
	public List<Emprestimo> getAll() {
		if(this.emprestimos.isEmpty())
			this.emprestimos = buscaTodosBD();
		return this.emprestimos;
	}
	
	private boolean validaCampos(Emprestimo emprestimo){
		if(!validaCampos.isDataPreenchida(emprestimo.getDataEmprestimo(), emprestimo.getDataDevolucao())){
			mensagem.exibeMensagemERRORCamposObrigatorios();
			return false;
		}if(emprestimo.getSituacao().equals("devolvido") && emprestimo.getDataRealDevolucao() == null){
			mensagem.exibeMensagemERROR("Preencha a data real de devolução!");
			return false;
		}return true;
	}

	private List<Emprestimo> buscaTodosBD(){
		try {
			return emprestimoDAO.getAll();
		} catch (Exception ex) {
			mensagem.exibeMensagemERRORObterDados(ex);
			ex.printStackTrace();
		}return null;
	}
	
	public List<Pessoa> getPessoaClienteDependente(String nome){
		return emprestimoDAO.buscarClienteDependentePorNome(nome);
	}
	
}