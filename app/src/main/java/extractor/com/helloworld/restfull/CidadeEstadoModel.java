package extractor.com.helloworld.restfull;

import java.util.ArrayList;
import java.util.List;

public class CidadeEstadoModel {

    public class Estado{
        private String sigla;
        private String nome;
        private List<String> cidades;

        @Override
        public String toString() {
            return sigla;
        }

        public String getSigla() {
            return sigla;
        }

        public void setSigla(String sigla) {
            this.sigla = sigla;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public List<String> getCidades() {
            return cidades;
        }

        public void setCidades(List<String> cidades) {
            this.cidades = cidades;
        }
    }

    private ArrayList<Estado> estados;

    public ArrayList<Estado> getEstados() {
        return estados;
    }

    public void setEstados(ArrayList<Estado> estados) {
        this.estados = estados;
    }
}
