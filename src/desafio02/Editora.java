package desafio02;

public class Editora {
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Editora{" +
                "nome='" + nome + '\'' +
                '}';
    }
}
