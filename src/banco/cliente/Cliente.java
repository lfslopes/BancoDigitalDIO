package banco.cliente;

public class Cliente implements Comparable<Cliente>{
    private final int id;
    private String nome;
    private int idade;
    private static int idCounter = 1;

    public Cliente(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
        this.id = idCounter;
        idCounter++;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return this.getNome() + "\n";
    }
    @Override
    public int compareTo(Cliente cliente) {
        return Integer.compare(this.getId(), cliente.getId());
    }
}
