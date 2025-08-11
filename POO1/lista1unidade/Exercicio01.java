package lista1unidade;

import java.util.InputMismatchException; // Importa a exceção específica para entradas inválidas.
import java.util.Scanner;

public class Exercicio01 {

    public static void main(String[] args) {
        // Cria uma instância da classe Scanner para ler a entrada do usuário.
        Scanner leitor = new Scanner(System.in);
        
        // As variáveis são inicializadas fora dos loops para que possam ser acessadas depois.
        int num1 = 0;
        int num2 = 0;
        
        // Loop para ler o primeiro número.
        // Ele continuará pedindo uma entrada até que um número inteiro válido seja fornecido.
        while (true) {
            System.out.println("Digite o primeiro número: ");
            try {
                num1 = leitor.nextInt(); // Tenta ler um número inteiro.
                break; // Se a leitura for bem-sucedida, sai do loop.
            } catch (InputMismatchException e) {
                // Captura a exceção específica para quando a entrada não é um número.
                System.out.println("Erro: A entrada deve ser um número inteiro. Tente novamente.");
                leitor.next(); // Limpa o buffer do Scanner para evitar um loop infinito.
            }
        }

        // Loop similar para o segundo número.
        while (true) {
            System.out.println("Digite o segundo número: ");
            try {
                num2 = leitor.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Erro: A entrada deve ser um número inteiro. Tente novamente.");
                leitor.next(); // Limpa o buffer do Scanner.
            }
        }
        
        // O restante do código permanece o mesmo.
        System.out.println("A soma dos números é: " + somarNumeros(num1, num2));
        
        // Boa prática: fechar o Scanner para liberar recursos.
        leitor.close();
    }

    /**
     * Método para somar dois números inteiros.
     * @param val1 O primeiro número.
     * @param val2 O segundo número.
     * @return A soma dos dois números.
     */
    private static int somarNumeros(int val1, int val2) {
        return val1 + val2;
    }
}
