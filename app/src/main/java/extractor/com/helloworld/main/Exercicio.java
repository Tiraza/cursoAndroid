package extractor.com.helloworld.main;

public class Exercicio {

    private String nome;
    private Class classe;

    public Exercicio(){}

    public Exercicio (String nome, Class classe){
        this.nome = nome;
        this.classe = classe;
    }

    public Class getClasse() {
        return classe;
    }

    public void setClasse(Class classe) {
        this.classe = classe;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
