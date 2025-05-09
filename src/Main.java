import banco.Banco;
import banco.cliente.Cliente;
import banco.conta.Conta;

import static banco.conta.ContaPoupanca.*;
import static banco.conta.ContaCorrente.*;

public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Ana", 25);
        Cliente cliente2 = new Cliente("Bruno", 32);

        Conta contaCorrente1 = criarContaCorrente(cliente1);
        Conta contaPoupanca1 = criarContaPoupanca(cliente1, 1000.00);
        Conta contaCorrente2 = criarContaCorrente(cliente2, 500.0D);
        Conta contaPoupanca2 = criarContaPoupanca(cliente2);

        //Realizando Saques
        if (contaCorrente1.sacar(100.0D))   //Não possui saldo suficiente
            System.out.println("Saque realizado com sucesso!");
        else
            System.out.println("Saque não realizado.");

        if (contaCorrente2.sacar(100.0D))
            System.out.println("Saque realizado com sucesso!");
        else
            System.out.println("Saque não realizado.");

        if (contaPoupanca1.sacar(100.0D))
            System.out.println("Saque realizado com sucesso!");
        else
            System.out.println("Saque não realizado.");

        if (contaPoupanca2.sacar(100.0D))   //Não possui saldo suficiente
            System.out.println("Saque realizado com sucesso!");
        else
            System.out.println("Saque não realizado.");

        System.out.println();
        //Realizando Depósitos
        if (contaCorrente1.depositar(-250.0D))  //Valor negativo
            System.out.println("Depósito realizado com sucesso!");
        else
            System.out.println("Depósito não realizado.");

        if (contaCorrente2.depositar(250.0D))
            System.out.println("Depósito realizado com sucesso!");
        else
            System.out.println("Depósito não realizado.");

        if (contaPoupanca1.depositar(250.0D))
            System.out.println("Depósito realizado com sucesso!");
        else
            System.out.println("Depósito não realizado.");

        if (contaPoupanca2.depositar(250.0D))
            System.out.println("Depósito realizado com sucesso!");
        else
            System.out.println("Depósito não realizado.");

        System.out.println();
        //Realizando Transferências
        if (contaCorrente1.transferir(100.0D, contaCorrente2)) //Não possui saldo suficiente
            System.out.println("Transferência realizada com sucesso!");
        else
            System.out.println("Transferência não realizada.");

        if (contaCorrente2.transferir(100.0D, contaCorrente1))
            System.out.println("Transferência realizada com sucesso!");
        else
            System.out.println("Transferência não realizada.");

        System.out.println();
        //Contas criadas

        System.out.println("Contas criadas:");
        Banco.listaConta().forEach(Conta::imprimirExtrato);

        System.out.println();
        //Clientes cadastrados
        System.out.println("Clientes cadastrados:");
        Banco.listaCliente().forEach(System.out::print);

    }
}
