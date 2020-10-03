package Biblioteca2;

import java.util.Scanner;

public class Teclado {

	private Scanner scanner;

	public Teclado() {
		scanner = new Scanner(System.in);
	}

	public String lerTexto(String mensagem) {
		System.out.print(mensagem);
		String texto = scanner.nextLine();
		return texto;
	}

	public int lerNumero(String mensagem) {
		int numero = 0;

		while (true) {
			System.out.print(mensagem);
			try {
				//numero = Double.parseDouble(scanner.nextLine());
				numero = Integer.parseInt(scanner.nextLine());
				break;
			} catch (NumberFormatException ex) {
				System.out.println("Digite uma opção válida! ");
			}
		}

		return numero;
	}

	public String lerOpcao(String mensagem, String opcoesValidas) {
		String opcao = "";

		while (true) {
			System.out.print(mensagem);

			opcao = scanner.nextLine();
			if (opcoesValidas.contains(opcao)) {
				break;
			} else {
				System.out.println("Opção inválida! ");
			}
		}

		return opcao;
	}

	
}