import contabancaria.Cliente;
import contabancaria.ContaCorrente;
import contabancaria.ContaPoupanca;
import contabancaria.IConta;

public class Main {
    public static void main(String[] args) throws Exception {

        Cliente Cliente1 = new Cliente();
        Cliente1.setNome("Cliente 1");

        IConta cc = new ContaCorrente(Cliente1);
        cc.depositar(100);
        cc.imprimirExtrato();

        System.out.println("==============================");

        IConta poupanca = new ContaPoupanca(Cliente1);
        poupanca.imprimirExtrato();

        System.out.println("==============================");

        cc.transferir(100, poupanca);

        System.out.println("==============================");

        cc.imprimirExtrato();
        poupanca.imprimirExtrato();

    }
}
