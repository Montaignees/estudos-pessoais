package banco;

import java.util.Scanner;


public class Banco {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int menu;
        int tempo;
        double valor;

        System.out.print("nome do titular: ");
        Conta conta = new Conta(sc.next(), 0);

        do {

            System.out.println("========= Banco =========");
            System.out.println("1 - Depositar");
            System.out.println("2 - Sacar");
            System.out.println("3 - Ver Status");
            System.out.println("4 - Poupança");
            System.out.println("5 - sair");
            System.out.println("=========================");

            System.out.println("Digite aqui sua opção: ");
            menu = sc.nextInt();

            switch (menu) {
                case 1:
                    System.out.println("indique quanto você deseja depositar: ");
                    valor = sc.nextDouble();
                    conta.depositar(valor);
                    break;

                case 2:
                    System.out.println("indique quanto você deseja depositar: ");
                    valor = sc.nextDouble();
                    conta.sacar(valor);
                    break;

                case 3:
                    conta.status();
                    break;

                case 4:
                    System.out.println("====== Poupança ======");
                    System.out.println("taxa de rentabilidade mensal: 0,83%");
                    System.out.println("Quanto deseja investir?");
                    valor = sc.nextDouble();

                    System.out.println("Quanto tempo deseja investir?");
                    tempo = sc.nextInt();

                    conta.investir(valor, tempo);

                    System.out.println("====== Poupança ======");
                    System.out.printf("Rendimento após %d meses: R$ %.2f%n", tempo, (conta.getJuros()));
                    System.out.printf("Novo saldo: R$ %.2f%n", conta.getSaldo());
                    break;
            }

        } while (menu != 5);

    }
}
