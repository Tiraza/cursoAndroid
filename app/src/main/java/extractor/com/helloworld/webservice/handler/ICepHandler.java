package extractor.com.helloworld.webservice.handler;

import java.util.Vector;

public interface ICepHandler {
    public void RequisicaoIniciada();
    public void RequisicaoFechada();
    public void RequisicaoFinalizada(String obterLogradouroAuth, Vector<String> result);
    public void RequisicaoFinalizadaComErro(Exception ex);
}
