package lista1unidade;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercicio03 {

    public static void main(String[] args) {
        
        Scanner entrada = new Scanner(System.in);
        double nota1, nota2, nota3;
        
        // Solicita e valida a primeira nota.
        // O método 'lerNota' encapsula a lógica de validação.
        nota1 = lerNota(entrada, "Digite a primeira nota (0 a 10): ");
        
        // Solicita e valida a segunda nota.
        nota2 = lerNota(entrada, "Digite a segunda nota (0 a 10): ");
        
        // Solicita e valida a terceira nota.
        nota3 = lerNota(entrada, "Digite a terceira nota (0 a 10): ");
        
        // Chama o método 'calculaMedia' e exibe o resultado arredondado.
        double media = calculaMedia(nota1, nota2, nota3);
        
        // Usa BigDecimal para um arredondamento preciso, evitando problemas de ponto flutuante.
        // O resultado é arredondado para duas casas decimais usando o modo 'HALF_UP' (arredonda para cima se o último dígito for >= 5).
        BigDecimal mediaFormatada = new BigDecimal(media).setScale(2, RoundingMode.HALF_UP);
        
        System.out.println("A média do aluno é: " + mediaFormatada);
        
        // Fecha o Scanner para liberar recursos do sistema.
        entrada.close();
    }
    
    /**
     * Método auxiliar para ler e validar uma nota.
     * Continua pedindo a nota até que o usuário insira um valor numérico entre 0 e 10.
     * @param scanner O objeto Scanner usado para a leitura.
     * @param mensagem A mensagem a ser exibida ao usuário.
     * @return A nota validada.
     */
    private static double lerNota(Scanner scanner, String mensagem) {
        double nota = 0;
        
        // Inicia um loop infinito para garantir que a leitura só pare quando a nota for válida.
        while (true) {
            System.out.println(mensagem);
            
            try {
                nota = scanner.nextDouble(); // Tenta ler a entrada como um 'double'.
                
                // Valida se a nota está no intervalo de 0 a 10.
                if (nota >= 0 && nota <= 10) {
                    break; // Sai do loop se a nota for válida.
                } else {
                    System.out.println("Erro: A nota deve ser entre 0 e 10. Tente novamente.");
                }
                
            } catch (InputMismatchException e) {
                // Captura a exceção se a entrada não for um número.
                System.out.println("Erro: A entrada deve ser um valor numérico. Tente novamente.");
                scanner.next(); // Limpa o buffer do Scanner para evitar loop infinito.
            }
        }
        return nota;
    }
    
    /**
     * Calcula a média aritmética de três notas.
     * @param n1 A primeira nota.
     * @param n2 A segunda nota.
     * @param n3 A terceira nota.
     * @return O valor da média.
     */
    private static double calculaMedia(double n1, double n2, double n3) {
        return (n1 + n2 + n3) / 3;
    }
}
