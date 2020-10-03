package Biblioteca2;

import java.util.ArrayList;

public class Biblioteca2 {
	private static ArrayList<Livro> livros = new ArrayList<>();
	private static ArrayList<Aluno> alunos = new ArrayList<>();

	public static void main(String[] args) {
		Teclado t = new Teclado();

		int proximoId = 0;

		while (true) {
			System.out.println("************************************");
			System.out.println("*        Biblioteca Online         *");
			System.out.println("************************************");
			System.out.println("* 1.  Cadastrar livro              *");
			System.out.println("* 2.  Listar livros                *");
			System.out.println("* 3.  Consultar livro              *");
			System.out.println("* 4.  Editar livro                 *");
			System.out.println("* 5.  Remover livro                *");
			System.out.println("* 6.  Cadastrar Aluno              *");
			System.out.println("* 7.  Listar Aluno                 *");
			System.out.println("* 8.  Consultar Aluno              *");
			System.out.println("* 9.  Editar Aluno                 *");
			System.out.println("* 10. Remover Aluno                *");
			System.out.println("* 11. Emprestar Livro              *");
			System.out.println("* 12. Relatorio de Emprestimos     *");
			System.out.println("* 0.  Sair                         *");
			System.out.println("************************************");

			int opcao = (int) t.lerNumero("Selecione uma opção: ");

			if (opcao == 0) { // sair
				break;
			}

			int codigo, ano, matricula, paginas;
			String titulo, autor, nome, telefone;
			Livro l;
			Aluno a;

			switch (opcao) {
			case 1: // Cadastrar livro
				codigo = proximoId;
				titulo = t.lerTexto("Título: ");
				autor = t.lerTexto("Autor(a): ");
				ano = t.lerNumero("Ano: ");
				paginas = t.lerNumero("Páginas: ");

				try {
					l = new Livro(codigo, titulo, autor, ano, paginas);
					livros.add(l);

					System.out.println("Livro adicionado, Codigo = " + l.getCodigo());
					proximoId++;

				} catch (IllegalArgumentException e) {
					System.err.println("Titulo vazio!" + e);
				} catch (Exception e) {
					System.err.println("Livro do ano " + ano + " ainda não existe!" + e);
				}

				break;
			case 2: // Listar livros
				for (Livro livro : livros) {
					System.out.println(livro.getCodigo() + " - " + livro.getTitulo());
				}
				System.out.println(livros.size() + " livros cadastrados");
				break;
			case 3:// Consultar livros
				codigo = (int) t.lerNumero("Qual o codigo do livro: ");

				int i = 0;

				for (Livro livro : livros) {
					if (livro.getCodigo() == codigo) {
						System.out.println(livro);
						break;
					}
					i++;
				}
				if (i == livros.size()) {
					System.out.println("Não existe livro com esse código!");
				}

				break;
			case 4: // Editar livros
				codigo = (int) t.lerNumero("Código do livro:  ");
				int e = 0;

				for (Livro livro : livros) {
					if (livro.getCodigo() == codigo) {
						while (true) {
							System.out.println(" ");
							System.out.println("####         Editar Livro        ###");
							System.out.println("************************************");
							System.out.println("* 1. Editar Titulo                 *");
							System.out.println("* 2. Editar Autor(a)               *");
							System.out.println("* 0. Voltar                        *");
							System.out.println("************************************");

							int op = (int) t.lerNumero("Selecione uma opção: ");

							if (op == 0) { // voltar
								break;
							}
							switch (op) {
							case 1:
								for (Livro lo : livros) {
									if (lo.getCodigo() == codigo) {
										titulo = t.lerTexto("Novo Titulo: ");
										lo.setTitulo(titulo);
									}
								}
								break;
							case 2:
								for (Livro li : livros) {
									if (li.getCodigo() == codigo) {
										autor = t.lerTexto("Novo Autor(a): ");
										li.setAutor(autor);
									}
								}
								break;
							default:
								System.out.println("Digite uma opção válida");
							}
						}
					}
					e++;
				}
				if (e == livros.size()) {
					System.out.println("Não existe livro com esse código!");
				}

				break;
			case 5: // Excluir livros
				codigo = (int) t.lerNumero("Qual o codigo do livro: ");

				int indice = 0;

				for (Livro li : livros) {
					if (li.getCodigo() == codigo) { // achei o equipamento com o id informado !!!
						break;
					}

					indice++;
				}

				if (indice == livros.size()) {
					System.out.println("Livro não encontrado");
				} else {
					livros.remove(indice);
					System.out.println("Livro removido com sucesso!");
				}

				break;
			case 6: // Cadastrar Aluno
				matricula = (int) t.lerNumero("Matricula: ");
				nome = t.lerTexto("Nome: ");
				telefone = t.lerTexto("Contato: ");

				a = new Aluno(matricula, nome, telefone);

				alunos.add(a);
				System.out.println("Aluno Cadastrado, Matricula = " + a.getMatricula());
				break;

			case 7: // Listar alunos
				for (Aluno al : alunos) {
					System.out.println(al.getMatricula() + " - " + al.getNome());
				}
				System.out.println(alunos.size() + " alunos cadastrados");
				break;

			case 8:// Consultar alunos
				matricula = (int) t.lerNumero("Qual a matricula do aluno: ");

				int cont = 0;

				for (Aluno aluno : alunos) {
					if (aluno.getMatricula() == matricula) {
						System.out.println(aluno);
						break;
					}
					cont++;
				}
				if (cont == alunos.size()) {
					System.out.println("Aluno não cadastrado!");
				}

				break;
			case 9: // Editar alunos
				matricula = (int) t.lerNumero("Matricula:  ");
				int z = 0;

				for (Aluno aluno : alunos) {
					if (aluno.getMatricula() == matricula) {
						while (true) {
							System.out.println(" ");
							System.out.println("####         Editar Aluno        ###");
							System.out.println("************************************");
							System.out.println("* 1. Editar Nome                   *");
							System.out.println("* 2. Editar Telefone               *");
							System.out.println("* 0. Voltar                        *");
							System.out.println("************************************");

							int op = (int) t.lerNumero("Selecione uma opção: ");

							if (op == 0) { // voltar
								break;
							}
							switch (op) {
							case 1:
								for (Aluno al : alunos) {
									if (al.getMatricula() == matricula) {
										nome = t.lerTexto("Novo Nome: ");
										al.setNome(nome);
									}
								}
								break;
							case 2:
								for (Aluno alu : alunos) {
									if (alu.getMatricula() == matricula) {
										telefone = t.lerTexto("Novo Telefone: ");
										alu.setTelefone(telefone);
									}
								}
								break;
							default:
								System.out.println("Digite uma opção válida");
							}
						}
					}
					z++;
				}
				if (z == alunos.size()) {
					System.out.println("Aluno não encontrado!");
				}

				break;
			case 10: // Excluir alunos

				matricula = (int) t.lerNumero("Matricula do aluno: ");

				int m = 0;

				for (Aluno aluno : alunos) {
					if (aluno.getMatricula() == matricula) { // achei o equipamento com o id informado !!!
						break;
					}

					m++;
				}

				if (m == alunos.size()) {
					System.out.println("Aluno não encontrado");
				} else {
					alunos.remove(m);
					System.out.println("Aluno removido com sucesso!");
				}

				break;
			case 11: // Emprestar livros

				if (livros.size() == 0) {
					System.out.println("\nNão existem livros cadastrados");
					break;
				}
				if (alunos.size() == 0) {
					System.out.println("\nNão existem alunos cadastrados");
					break;
				}
				System.out.println("\n----- Livros -----");
				int count = 0;
				for (int l1 = 0; l1 < livros.size(); l1++) {
					if (livros.get(l1).isDisponivel()) {
						System.out.println(l1 + " - " + livros.get(l1).getTitulo());
						count++;
					}
				}
				if (count > 0) {
					System.out.print("\nDigite o id do livro para emptrestar: ");
					int escolhaLivro = (int) t.lerNumero("");
					if (livros.get(escolhaLivro).isDisponivel()) {
						for (int j = 0; j < alunos.size(); j++) {
							System.out.println("\n----- Alunos -----");
							System.out.println(j + " - matricula: " + alunos.get(j).getMatricula() + ", Nome: "
									+ alunos.get(j).getNome());
						}
						System.out.print("\nId do Aluno: ");
						int escolhaEstudante = (int) t.lerNumero("");

						if (alunos.get(escolhaEstudante).getEmprestimos() > 3) {
							System.out.println("\nEste aluno ja atingiu o limite de emprestimos");
						} else {
							livros.get(escolhaLivro).emprestar(alunos.get(escolhaEstudante));
							alunos.get(escolhaEstudante).addEmprestimo();
						}
					} else {
						System.out.println("Este livro não está disponivel");
					}
				} else {
					System.out.println("\nNão a livros disponiveis");
				}

				break;
			case 12: // Relatorio

				if (livros.size() == 0) {
					System.out.println("\nNao existe livros cadastrados");
					return;
				}
				System.out.println("---- > Livros Emprestados < ----");
				for (Livro livro : livros) {
					if (!livro.isDisponivel())
						System.out.println(livro);
				}
				System.out.println("---- > Livros Disponiveis < ----");
				for (Livro livro : livros) {
					if (livro.isDisponivel())
						System.out.println(livro);
				}

				break;

			default:
				System.out.println("Digite uma opção válida!");

			}

		}
		System.out.println("Obrigado por usar a biblioteca!");
	}

}
