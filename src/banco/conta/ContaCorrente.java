package banco.conta;

import banco.Banco;
import banco.cliente.Cliente;

public non-sealed class ContaCorrente extends Conta{
    private static final int AGENCIA_PADRAO = 1000;
    private static int CONTA_PADRAO = 2;

    private static final double TAXA_SAQUE = 1.00;

    private ContaCorrente(Cliente cliente) {
        super(cliente);
        this.setAgencia(AGENCIA_PADRAO + CONTA_PADRAO);
        this.setNumero(CONTA_PADRAO);
        CONTA_PADRAO += 2;
        Banco.adicionarConta(this);
        Banco.adicionarCliente(cliente);
    }

    public static ContaCorrente criarContaCorrente(Cliente cliente) {
        return new ContaCorrente(cliente);
    }
    public static ContaCorrente criarContaCorrente(Cliente cliente, double saldoInicial) {
        ContaCorrente conta = new ContaCorrente(cliente);
        if (!conta.depositar(saldoInicial))
            throw new RuntimeException("Saldo inválido");
        return conta;
    }

    @Override
    public boolean sacar(double valor) {
        if (valor > 0 && valor <= this.getSaldo()) {
            this.setSaldo(this.getSaldo() - (valor + TAXA_SAQUE));
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
            this.setSaldo(this.getSaldo() - valor);
            contaDestino.depositar(valor);
            return true;
        }
        return false;
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato da Conta Corrente ===");
        super.imprimirExtrato();
    }
}
