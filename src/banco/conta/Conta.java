package banco.conta;

import banco.cliente.Cliente;
import banco.exceptions.ContaException;

import java.util.Locale;

public sealed abstract class Conta implements IConta permits ContaCorrente, ContaPoupanca {
    private int agencia;
    private int numero;
    private double saldo;
    private Cliente cliente;

    protected Conta(Cliente cliente) throws ContaException {
        if (cliente == null)
            throw new ContaException("Cliente nulo");
        if (cliente.getIdade() < 18)
            throw new ContaException("Cliente menor de idade");
        if (cliente.getNome() == null || cliente.getNome().isEmpty())
            throw new ContaException("Nome do cliente inválido");

        this.cliente = cliente;
        this.saldo = 0;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("Cliente: " + this.cliente.getNome());
        System.out.println("Agência: " + this.getAgencia());
        System.out.println("Número: " + this.getNumero());
        System.out.println("Saldo: R$ " + String.format(Locale.forLanguageTag("BR"), "%.2f", this.getSaldo()));
    }
}