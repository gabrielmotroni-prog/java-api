package desafio03.modelos;

public class Usuario {
    private String email;
    private String senha;

    public Usuario(String email, String senha){

        if(senha.length() < 8 ){
            throw new SenhaInvalidaException("Senha deve conter no mínimo 8 caractéres");
        }
    }
}
