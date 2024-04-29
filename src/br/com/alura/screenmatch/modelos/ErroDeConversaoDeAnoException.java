package br.com.alura.screenmatch.modelos;

public class ErroDeConversaoDeAnoException extends RuntimeException {
    String mensagem;
    public ErroDeConversaoDeAnoException(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public String getMessage() {
        return this.mensagem;
    }
}
