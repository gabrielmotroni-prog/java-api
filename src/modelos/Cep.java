package modelos;

public class Cep {

    private String cep;
    private String rua;
    private String complemento;
    private String bairro;
    private String cidade;
    private String ibge;
    private String ddd;


    public Cep(CepViaCep cepViaCep){
        this.cep = cepViaCep.cep();
        this.bairro = cepViaCep.bairro();
        this.cidade = cepViaCep.localidade();
        this.rua = cepViaCep.logradouro();
        this.complemento = cepViaCep.logradouro();
        this.ddd = cepViaCep.ddd();
        this.ibge = cepViaCep.ibge();
    }
    public Cep(String cep, String rua, String complemento, String bairro, String cidade, String ibge, String ddd) {
        this.cep = cep;
        this.rua = rua;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.ibge = ibge;
        this.ddd = ddd;
    }

    public String getCep() {
        return cep;
    }

    public String getRua() {
        return rua;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getIbge() {
        return ibge;
    }

    public String getDdd() {
        return ddd;
    }

    @Override
    public String toString() {
        return "Cep{" +
                "cep='" + cep + '\'' +
                ", rua='" + rua + '\'' +
                ", complemento='" + complemento + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cidade='" + cidade + '\'' +
                ", ibge='" + ibge + '\'' +
                ", ddd='" + ddd + '\'' +
                '}';
    }
}
