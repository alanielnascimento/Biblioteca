package Biblioteca2;

import java.util.ArrayList;

public class Livro {

	private int codigo, paginas;
	private String titulo;
	private String autor;
	private int ano;
	private ArrayList<Emprestimo> emprestimos = new ArrayList<>();

	public Livro(int codigo, String titulo, String autor, int ano, int paginas) throws Exception {
		super();
		if (ano > 2020) {

			throw new Exception();
		} // ISEMPTY INDICA SE ESTRING É VAZIA.
		if (titulo.isEmpty()) {

			throw new IllegalArgumentException();
		}

		this.codigo = codigo;
		this.titulo = titulo;
		this.autor = autor;
		this.ano = ano;
		this.paginas = paginas;
	}
	public Livro(String csv) {
		String[] campos = csv.split(" ;");
		this.codigo = Integer.parseInt(campos[0]);
		this.titulo = campos[1];
		this.autor = campos[2];
		this.ano = Integer.parseInt(campos[3]);
		this.paginas = Integer.parseInt(campos[4]);
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getPaginas() {
		return paginas;
	}

	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}

	public boolean isDisponivel() {
		for (Emprestimo livro : emprestimos)
			if (livro.getDataDevolucao() == null)
				return false;
		return true;
	}

	public String toString() {
		String output = "";
		output += "Código: " + this.getCodigo() + "\n";
		output += "Titulo: " + this.getTitulo() + "\n";
		output += "Autor: " + this.getAutor() + "\n";
		output += "Ano: " + this.getAno() + "\n";
		output += "Páginas: " + this.getPaginas();
		if (!this.isDisponivel())
			output += "\nEmprestado para: " + this.emprestimos.get(this.emprestimos.size() - 1).getAluno().getNome();
		output += "\n";
		return output;
	}

	public void emprestar(Aluno aluno) {
		this.emprestimos.add(new Emprestimo(aluno));
	}

}
