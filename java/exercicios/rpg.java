package pessoal;

import java.util.Random;
import java.util.Scanner;

public class rpg {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        Random rand = new Random();

        int MeuHP = 67;
        int goblinHP = 60;
        int movimento;

        while (MeuHP > 0 && goblinHP > 0) {

            System.out.println("Seu HP: " + MeuHP);
            System.out.println("Hp do goblin: " + goblinHP);

            System.out.println("1 - Atacar o Goblin");
            System.out.println("2 - Fugir");

            System.out.print("Selecione uma ação:");
            movimento = entrada.nextInt();

            switch (movimento) {
                case 1:
                    int criticoGoblin = rand.nextInt(20) + 1;
                    int critico = rand.nextInt(20) + 1;

                    if (critico == 20) {
                        critico = (rand.nextInt(12) + 1) * 2;
                        System.out.println("CRÍTICO!! dano causado:" + critico);
                        goblinHP -= critico;

                    } else {
                        int dano = rand.nextInt(12) + 1;
                        System.out.println("Você atacou o Goblin dano causado:" + dano);
                        goblinHP -= dano;
                    }

                    if (goblinHP > 0) {
                        if (criticoGoblin == 20) {
                            criticoGoblin = (rand.nextInt(12) + 1) * 2;
                            System.out.println("CRÍTICO!! dano recebido:" + criticoGoblin);
                            MeuHP -= criticoGoblin;
                            break;
                        } else {
                            int dano = rand.nextInt(10) + 1;
                            System.out.println("O goblin te atacou. Dano causado:" + dano);
                            MeuHP -= dano;
                        }
                    } else {
                        System.out.println("Parabéns, você derrotou o goblin!!");
                        System.out.println("EXP ganho: 150");
                    }
                    break;
                case 2:
                    System.out.println("Voce fugiu!");
                    return;

                default:
                    System.out.println("Opção inválida");
            }
        }
        if (MeuHP < 0) {
            System.out.println("Você morreu!, perdeu 1 Level");
        }
        entrada.close();
    }
}