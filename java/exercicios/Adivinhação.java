import java.util.Random;
import java.util.Scanner;

public class adivinhar {
    public static void main(String[] args) {
        int tentativa;
        boolean acertou = false;

        Scanner leitor = new Scanner(System.in);
        Random rand = new Random();
        int numeroRand = rand.nextInt(100);

        for (int i = 1; i <= 5; i++) {

            System.out.print("Tente adivinhar um número de 0 - 100: ");
            tentativa = leitor.nextInt();

            if (tentativa == numeroRand) {
                System.out.print("parábens você acertou o número!!");
                acertou = true;
                break;

            } else if (tentativa > numeroRand) {
                System.err.println("Muito alto, tente novamente.");

            } else {
                System.err.println("Muito baixo, tente novamente.");

            }

        }

        if (acertou!= true) {
            System.err.println("infelizmente você perdeu. O número era: " + numeroRand);
        }
        leitor.close();
    }
}
