package br.com.uniph.infraestrutura.persistencia;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Test;

import br.com.uniph.dominio.entidade.Aluno;

public class PersistenciaTest {

	@Test
	public void deveCriarOEntityManagerFactoryEEntityManager() {	
		EntityManager em = JPAUtil.getEntityManager();
		
		em.close();
	}

	@Test
	public void devePersistirUmAluno() {
		EntityManager em = JPAUtil.getEntityManager();
		
//		Aluno aluno = new Aluno();
//		aluno.setNomeCompleto("José Roberto");
//		aluno.setCpf("999999999");
//		aluno.setDataDeCadastro(Calendar.getInstance());
//		aluno.setEmail("ze@bol.com.br");
//		aluno.setRg("2222222");
//		aluno.setTelefone("938383");
//		
//		// INSERT
//		em.getTransaction().begin();
//		em.persist(aluno);
//		em.getTransaction().commit();
		
		// HQL
		
		// DELETE
//		String delete = "DELETE Aluno a WHERE a.nomeCompleto = :nome";
//		em.getTransaction().begin();
//		Query q = em.createQuery(delete).setParameter("nome", "José Roberto");
//		Query q = em.createQuery(delete).setParameter("nome", "Juca");
//		q.executeUpdate();
//		em.getTransaction().commit();
		
		// UPDATE
		String update = "UPDATE Aluno a SET a.nomeCompleto = :nome WHERE a.id = :id";
		em.getTransaction().begin();
		Query q1  = em.createQuery(update);
		q1.setParameter("nome", "Mário do Armário");
		q1.setParameter("id", 5l);
		q1.executeUpdate();
		em.getTransaction().commit();
		
		String sql = "SELECT a FROM Aluno a";
		Query query = em.createQuery(sql);
		
		System.out.println();
		
		List<Aluno> list = query.getResultList();
		
		if (list == null || list.isEmpty()) {
			System.out.println("Vazio");
		}
		
		for (Aluno a : list) {
			 System.out.println(a.getNomeCompleto() + " " + a.getId());
		}
		
		em.close();
	}

}
