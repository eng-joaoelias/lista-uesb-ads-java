package lista1unidade;

// Importa a classe BigDecimal para realizar arredondamentos com precisão,
// evitando os problemas de imprecisão de números de ponto flutuante (double/float).
import java.math.BigDecimal;
// Importa o modo de arredondamento necessário, neste caso, para cima (HALF_UP).
import java.math.RoundingMode;
// Importa a exceção para tratar entradas que não correspondem ao tipo de dado esperado.
import java.util.InputMismatchException;
// Importa a classe Scanner para ler entradas do usuário a partir do teclado.
import java.util.Scanner;

// Declaração da classe principal 'Exercicio04'.
public class Exercicio04 {

	// O método 'main' é o ponto de entrada da aplicação Java.
	public static void main(String[] args) {
		
		// Cria uma instância do Scanner para ler as entradas do usuário.
		// O System.in representa a entrada padrão, geralmente o teclado.
		Scanner entrada = new Scanner(System.in);
		
		// Chama o método 'lerValor' para obter a base do retângulo.
		// A mensagem é passada como argumento para o método exibir na tela.
		double base = lerValor(entrada, "Digite a base do retângulo:");
		
		// Chama o método 'lerValor' novamente para obter a altura do retângulo.
		double altura = lerValor(entrada, "Digite a altura do retângulo:");
		
		// Calcula a área do retângulo chamando o método 'calculaAreaRetangulo'.
		double area = calculaAreaRetangulo(base, altura);
		
		// Cria um objeto BigDecimal com o valor da área para realizar um arredondamento preciso.
		// setScale(2, RoundingMode.HALF_UP) define 2 casas decimais e arredonda para cima,
		// se o terceiro dígito for 5 ou maior.
		BigDecimal areaFormatada = new BigDecimal(area).setScale(2, RoundingMode.HALF_UP);
		
		// Exibe o resultado final da área formatada.
		System.out.println("A área do retângulo é: " + areaFormatada);
		
		// Fecha o Scanner para liberar os recursos do sistema.
		// É uma boa prática fechar o Scanner no final do método 'main' para evitar vazamento de recursos.
		entrada.close();
	}
	
	/**
	 * Método auxiliar para ler um valor numérico com tratamento de erro.
	 * Ele garante que a entrada do usuário seja um número, solicitando novamente em caso de erro.
	 * @param entrada O objeto Scanner que será usado para a leitura.
	 * @param textoASerExibido A mensagem que o método deve mostrar ao usuário.
	 * @return O valor numérico válido fornecido pelo usuário.
	 */
	private static double lerValor(Scanner entrada, String textoASerExibido) {
		double valor = 0;
		// Exibe a mensagem de solicitação de entrada.
		System.out.println(textoASerExibido);
		
		// Inicia um loop infinito para pedir a entrada até que seja válida.
		while (true) {
			try {
				// Tenta ler um número de ponto flutuante (double).
				valor = entrada.nextDouble();
				// Se a leitura for bem-sucedida, sai do loop.
				break;
			} catch (InputMismatchException e) {
				// Se a entrada não for um número (ex: "abc"), este bloco é executado.
				System.out.println("Entrada inválida! Digite um número.");
				// Limpa o buffer do Scanner, consumindo a entrada inválida para evitar um loop infinito.
				entrada.next();
			}
		}
		// Retorna o valor numérico válido.
		return valor;
	}
	
	/**
	 * Método para calcular a área de um retângulo.
	 * @param base A medida da base do retângulo.
	 * @param altura A medida da altura do retângulo.
	 * @return O valor da área, que é o produto da base pela altura.
	 */
	private static double calculaAreaRetangulo(double base, double altura) {
		return base * altura;
	}

}
