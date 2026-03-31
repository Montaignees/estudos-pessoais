import java.util.Scanner;
import java.text.DecimalFormat;

public class caixaEletronico {
    public static void main(String[] args) {

        DecimalFormat df = new DecimalFormat("#.##");

        
        int menu;
        double saldo = 0;
        double investir;
        int tempo;

        Scanner entrada = new Scanner(System.in);

        do {
            System.out.println("1 - Ver saldo");
            System.out.println("2 - Depositar");
            System.out.println("3 - Sacar");
            System.out.println("4 - Poupança");
            System.out.println("5 - Sair");

            System.out.print("Escolha sua ação: ");
            menu = entrada.nextInt();

            switch (menu) {
                case 1:
                    System.out.println("Seu saldo atual é: " + saldo + " R$");
                    break;

                case 2:
                    System.out.print("Valor para depósito: ");
                    double deposito = entrada.nextDouble();

                    if (deposito <= 0) {
                        System.out.println("Valor inválido.");
                    } else {
                        saldo += deposito;
                        System.out.println("Depósito realizado. Saldo: " + saldo + " R$");
                    }
                    break;

                case 3:
                    System.out.print("Valor para saque: ");
                    double saque = entrada.nextDouble();

                    if (saque > saldo) {
                        System.out.println("Saldo insuficiente.");
                    } else {
                        saldo -= saque;
                        System.out.println("Saque realizado. Saldo: " + saldo + " R$");
                    }
                    break;

                case 4:
                    System.out.print("Valor para investir: ");
                    investir = entrada.nextDouble();

                    if (investir <= saldo) {
                        saldo -= investir;

                        System.out.print("Quantos anos? ");
                        tempo = entrada.nextInt() * 12;

                        for (int i = 0; i < tempo; i++) {
                            investir *= 1.0115;
                        }

                        String resultado = df.format(investir);
                        System.out.println("Valor final: " + resultado + " R$");

                    } else {
                        System.out.println("Saldo insuficiente.");
                    }
                    break;

                case 5:
                    System.out.println("saindo...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (menu != 5);

        entrada.close();
    }
}

