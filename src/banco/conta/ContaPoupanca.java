package banco.conta;

import banco.Banco;
import banco.cliente.Cliente;
import banco.exceptions.ContaException;

public non-sealed class ContaPoupanca extends Conta {
    private static final int AGENCIA_PADRAO = 1000;
    private static int CONTA_PADRAO = 1;

    private ContaPoupanca(Cliente cliente) {
        super(cliente);
        this.setAgencia(AGENCIA_PADRAO + CONTA_PADRAO);
        this.setNumero(CONTA_PADRAO);
        CONTA_PADRAO += 2;
        Banco.adicionarConta(this);
        Banco.adicionarCliente(cliente);
    }

    public static ContaPoupanca criarContaPoupanca(Cliente cliente) {
        return new ContaPoupanca(cliente);
    }
    public static ContaPoupanca criarContaPoupanca(Cliente cliente, double saldoInicial) throws ContaException {
        ContaPoupanca conta = new ContaPoupanca(cliente);
        if (!conta.depositar(saldoInicial))
            throw new ContaException("Saldo inválido");
        return conta;
    }

    @Override
    public boolean sacar(double valor) {
        if (valor > 0 && valor <= this.getSaldo()) {
            this.setSaldo(this.getSaldo() - valor);
            return true;
        }
        return false;
    }
    @Override
    public boolean depositar(double valor) {
        if (valor > 0) {
            this.setSaldo(this.getSaldo() + valor);
            return true;
        }
        return false;
    }
    @Override
    public boolean transferir(double valor, IConta contaDestino) {
        if (valor > 0 && valor <= this.getSaldo()) {
            this.sacar(valor);
            contaDestino.depositar(valor);
            return true;
        }
        return false;
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato da Conta Poupança ===");
        super.imprimirExtrato();
    }
}
