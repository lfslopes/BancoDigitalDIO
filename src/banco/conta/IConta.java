package banco.conta;

public interface IConta {
    // Saca um saldo da conta, caso haja saldo o suficiente. Se não houver, retorna false.
    boolean sacar (double valor);
    // Deposita um valor na conta, caso o valor seja positivo. Se não for, retorna false.
    boolean depositar(double valor);
    // Transfere um valor de uma conta para outra, caso haja saldo o suficiente. Se não houver, retorna false.
    boolean transferir (double valor, IConta contaDestino);
    // Retorna o saldo da conta.
    void imprimirExtrato();
}
