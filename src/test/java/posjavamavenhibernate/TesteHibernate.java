package posjavamavenhibernate;

import java.util.List;

import org.junit.Test;

import dao.DaoGeneric;
import model.UsuarioPessoa;

public class TesteHibernate {

	@Test
	public void testeHibernateUtil() {

		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();

		UsuarioPessoa pessoa = new UsuarioPessoa();

		pessoa.setNome("Fernando");
		pessoa.setIdade(78);
		pessoa.setSobrenome("Souza");
		pessoa.setLogin("fernando7P8");
		pessoa.setSenha("123");

		daoGeneric.salvar(pessoa);
	}

	@Test
	public void testeBuscar() {

		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		
		UsuarioPessoa pessoa = new UsuarioPessoa();
		
		pessoa.setId(4L);
		pessoa.setIdade(24);
		pessoa.setNome("Raimundo");
		pessoa.setSobrenome(" da Silva");
		pessoa.setLogin("raimundo74R");
		pessoa.setSenha("Ra74R@");
		
		pessoa = daoGeneric.updateMerge(pessoa);
		
		System.out.println(pessoa);

	}
	
	@Test
	public void testeUpdate() {

		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		
		UsuarioPessoa pessoa = new UsuarioPessoa();
		
		pessoa.setId(1L);
		
		pessoa = daoGeneric.pesquisar(pessoa);
		
		System.out.println(pessoa);

	}
	
	@Test
	public void testaDelete() {
		
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		
		UsuarioPessoa pessoa = daoGeneric.pesquisar(3L, UsuarioPessoa.class);
		
		daoGeneric.deletarPorId(pessoa);
	}
	
	@Test
	public void testConsultar() {
		
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		
		List<UsuarioPessoa> list = daoGeneric.listar(UsuarioPessoa.class);
		
		for (UsuarioPessoa usuarioPessoa : list) {
			
			System.out.println(usuarioPessoa);
			System.out.println("---------------------------------");
		}
	}
}
