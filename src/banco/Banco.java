package banco;

import banco.cliente.Cliente;
import banco.conta.Conta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Banco {
    private static final List<Cliente> clientes = new ArrayList<>();
    private static final List<Conta> contas = new ArrayList<>();

    public static void adicionarConta(Conta conta) {
        contas.add(conta);
    }
    public static void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public static List<Cliente> listaCliente() {
        return Collections.unmodifiableList(clientes);
    }
    public static List<Conta> listaConta() {
        return Collections.unmodifiableList(contas);
    }
}
