package lista1unidade;

// Importa a classe InputMismatchException, usada para tratar entradas inválidas (não numéricas).
import java.util.InputMismatchException;
// Importa a classe Scanner, essencial para ler dados do teclado.
import java.util.Scanner;

// Declaração da classe principal do programa. O nome da classe deve ser igual ao nome do arquivo.
public class Exercicio02 {

	// O método 'main' é o ponto de entrada da aplicação. O programa começa a ser executado aqui.
	public static void main(String[] args) {
		
		// Cria uma instância da classe Scanner para capturar a entrada do usuário através do teclado (System.in).
		Scanner leitor = new Scanner(System.in);
		
		// Declara e inicializa a variável 'tempCelcius' para armazenar a temperatura em Celsius.
		// O tipo 'double' é usado porque temperaturas podem ter casas decimais.
		double tempCelcius = 0;
		
		// Exibe uma mensagem na tela para o usuário, pedindo a temperatura.
		System.out.println("Digite a temperatura em Celsius: ");
		
		// Inicia um loop infinito (while(true)) para garantir que o programa só prossiga
		// quando o usuário fornecer uma entrada numérica válida.
		while (true) {
			
			// O bloco 'try' contém o código que pode gerar uma exceção (erro).
			try {
				// Tenta ler o próximo número do tipo double digitado pelo usuário.
				tempCelcius = leitor.nextDouble();
				
				// Se a leitura for bem-sucedida, a instrução 'break' é executada,
				// saindo do loop 'while' e permitindo que o programa continue.
				break;
				
			} catch (InputMismatchException e) {
				// O bloco 'catch' é executado se a exceção 'InputMismatchException' ocorrer.
				// Essa exceção é lançada quando a entrada do usuário não corresponde ao tipo esperado (double).
				
				// Exibe uma mensagem de erro amigável para o usuário.
				System.out.println("Erro: A entrada deve ser um número real. Tente novamente.");
				
                // A chamada 'leitor.next()' é crucial. Ela consome (descarta) a entrada inválida do buffer do Scanner.
				// Sem isso, o loop entraria em um ciclo infinito, tentando ler a mesma entrada incorreta repetidamente.
                leitor.next();
			}
		}
		
		// Após a validação da entrada, exibe o resultado da conversão.
		// Chama o método 'converteCelciusFahrenheit' passando a temperatura lida.
		// O valor retornado é concatenado à string de saída.
		System.out.println("A temperatura em Fahrenheit é: " + converteCelciusFahrenheit(tempCelcius) + "°F");
		
		// Boa prática: fecha o objeto 'leitor' para liberar os recursos do sistema.
		leitor.close();

	}
	
	/**
	 * Método privado para converter uma temperatura de Celsius para Fahrenheit.
	 * * @param tempCelcius A temperatura em graus Celsius.
	 * @return O valor da temperatura convertido para graus Fahrenheit.
	 */
	private static double converteCelciusFahrenheit(double tempCelcius) {
		// A fórmula de conversão é: (Celsius * 9/5) + 32.
		return (tempCelcius * 9/5) + 32;
	}

}
