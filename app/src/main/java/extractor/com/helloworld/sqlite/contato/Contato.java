package extractor.com.helloworld.sqlite.contato;

/**
 * Created by aluno on 24/04/2015.
 */
public class Contato {

    private Integer id;
    private String nome;
    private String telefone;
    private String rua;
    private String email;
    private String cidade;

    public Contato() {}

    public Contato(Integer id) {
        this.id = id;
    }

    public Contato(Integer id, String nome, String telefone, String rua, String email, String cidade) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.rua = rua;
        this.email = email;
        this.cidade = cidade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}
