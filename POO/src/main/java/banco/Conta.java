package banco;

public class Conta {

    private static final double TAXA_JUROS = 0.0083;
    private final String titular;
    private double saldo;
    private double juros;


    public Conta(String titular, double saldo) {
        this.titular = titular;
        this.saldo = saldo;

    }

    public void depositar(double valor) {

        if (valor <= 0) {
            System.out.println("Deposito inválido");
            return;
        }

        saldo += valor;

        System.out.println("deposito realizado!");
        System.out.println("saldo atual: R$" + saldo);
    }

    public void sacar(double valor) {

        if (valor <= 0) {
            System.out.println("valor de saque inválido");
            return;
        }

        if (valor > saldo) {
            System.out.println("Saldo insuficiente");
            return;
        }

        saldo -= valor;

        System.out.println("Saque realizado!");
        System.out.println("Saldo atual: R$" + saldo);

    }

    public void investir(double valor, int tempo) {

        if (valor <= 0) {
            System.out.println("Valor inválido");
            return;
        }

        if (valor > saldo) {
            System.out.println("Saldo insuficiente");
            return;
        }

        double investimento = valor;

        saldo -= valor;

        for (int i = 0; i < tempo; i++) {

            investimento *= TAXA_JUROS;
        }

        juros = investimento - valor;
        saldo += investimento;
    }

    public void status() {
        System.out.println("====== Status ======");
        System.out.println("Titular: " + titular);
        System.out.println("Saldo atual: R$" + saldo);
        System.out.println("====================");

    }

    public double getSaldo() {
        return saldo;
    }

    public double getJuros() {
        return juros;
    }
}




