package br.com.uniph.dominio.entidade;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

//@Entity
@Table(name = "TB_TURMA")
public class Turma {

//	ManyToMany(fetch = FetchType.la)
//	@JoinTable(name = "TBALUNOPORTURMA", joinColumns = (JoinColumn(name = "CODIGO_TURMA"),
//			), invers)
	private List<Aluno> alunos;
	
	private List<Disciplina> disciplinas;
	
}
