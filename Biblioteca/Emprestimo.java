package Biblioteca2;

import java.util.Calendar;
import java.util.Date;

import ProjetoBiblioteca.Relogio;

public class Emprestimo {

	private Date dataEmprestimo;
	private Date dataDevolucao;
	private Aluno aluno;

	public Emprestimo(Aluno aluno) {
		this.dataEmprestimo = Calendar.getInstance().getTime();
		this.aluno = aluno;
		this.dataDevolucao = null;
	}

	public Emprestimo(Date date, Aluno aluno) {
		this.dataEmprestimo = date;
		this.aluno = aluno;
		this.dataDevolucao = null;
	}

	public void finalizar() {
		this.dataDevolucao = Relogio.getTime();
	}

	public Date getDataEmprestimo() {
		return this.dataEmprestimo;
	}

	public Date getDataDevolucao() {
		return this.dataDevolucao;
	}

	public Aluno getAluno() {
		return this.aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

}
