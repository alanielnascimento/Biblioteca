package Biblioteca2;

public class Aluno {

	private int matricula;
	private String nome;
	private String telefone;
	private int totalEmprestimo;

	public Aluno(int matricula, String nome, String telefone) {

		this.matricula = matricula;
		this.nome = nome;
		this.telefone = telefone;
		this.totalEmprestimo = 0;

	}

	public Aluno(String csv) {
		String[] campos = csv.split(" ;");
		this.matricula = Integer.parseInt(campos[0]);
		this.nome = campos[1];
		this.telefone = campos[2];

	}

	public void addEmprestimo() {
		this.totalEmprestimo++;
	}

	public int getEmprestimos() {
		return totalEmprestimo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public int getMatricula() {
		return matricula;
	}

	@Override
	public String toString() {
		return "MATRICULA: " + matricula + ", NOME: " + nome + ", TELEFONE: " + telefone;
	}

}
