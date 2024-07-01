package contabancaria;

public abstract class Conta implements IConta {

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;
    
    protected int agencia;
    protected int numeroConta;
    protected double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numeroConta = SEQUENCIAL++;
        this.cliente = cliente;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    @Override
    public void sacar(double valor) {
        if (valor > 0 && saldo >= valor) {
            this.saldo -= valor;
            System.out.println("Saque realizado com sucesso.");
        } else {
            System.out.println("Saldo insuficiente para saque. Informe um valor valido.");
        }
    }

    @Override
    public void depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
            System.out.println("Deposito realizado com sucesso.");
        } else {
            System.out.println("Informe um valor válido.");
        }
    }

    @Override
    public void transferir(double valor, IConta contaDestino) {
        if (valor > 0 && saldo >= valor) {
            this.sacar(valor);
            contaDestino.depositar(valor);
            System.out.println("Transferencia realizada com sucesso.");
        } else {
            System.out.println("Saldo insuficiente. Informe um valor valido.");
        }
    }

    protected void imprimirInfosConta() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Conta: %d", this.numeroConta));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }

}
