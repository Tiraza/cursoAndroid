package extractor.com.helloworld.webservice.service;

import android.os.AsyncTask;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.SoapFault;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import java.util.Vector;

import extractor.com.helloworld.webservice.handler.ICepHandler;

public class CEPService {

    public String URL = "http://www.byjg.com.br/site/webservice.php/ws/cep";
    public int timeOut = 6000;
    public String USUARIO = "eltonjose";
    public String SENHA = "123456";
    public ICepHandler cepHandler;

    public CEPService(ICepHandler cepHandler) {
        this.cepHandler = cepHandler;
    }

    public void obterLogradouroAuthAsync(final String cep) throws Exception{

        new AsyncTask<Void, Void, Vector<String>>(){

            @Override
            protected void onPreExecute() {
                cepHandler.RequisicaoIniciada();
            }

            @Override
            protected Vector<String> doInBackground(Void... params) {
                return obterLogradouroAuth(cep);
            }

            @Override
            protected void onPostExecute(Vector<String> result) {
                cepHandler.RequisicaoFechada();
                if(result != null){
                    cepHandler.RequisicaoFinalizada("obterLogradouroAuth", result);
                }
            }
        }.execute();
    }

    private Vector<String> obterLogradouroAuth(String cep) {
        Vector<String> vector = new Vector<>();

        SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        soapEnvelope.implicitTypes = true;
        soapEnvelope.dotNet = true;

        SoapObject soapRequest = new SoapObject("urn:CEPService", "obterLogradouroAuth");
        soapRequest.addProperty("cep", cep);
        soapRequest.addProperty("usuario", USUARIO);
        soapRequest.addProperty("senha", SENHA);

        soapEnvelope.setOutputSoapObject(soapRequest);
        HttpTransportSE httpTransport = new HttpTransportSE(URL,timeOut);

        try {
            httpTransport.call("urn:CEPService/obterLogradouroAuth", soapEnvelope);

            Object retObj = soapEnvelope.bodyIn;

            if(retObj instanceof SoapFault){
                SoapFault fault = (SoapFault) retObj;
                Exception ex = new Exception(fault.faultstring);
                if (cepHandler != null){
                    cepHandler.RequisicaoFinalizadaComErro(ex);
                }
            } else {
                SoapObject result = (SoapObject) retObj;
                if(result.getPropertyCount() > 0){
                    Object obj = result.getProperty(0);
                    String resultVariable;

                    if(obj !=null && obj.getClass().equals(SoapPrimitive.class)){
                        SoapPrimitive j = (SoapPrimitive) obj;
                        resultVariable = j.toString();
                    } else {
                        resultVariable = (String) obj;
                    }

                    vector.add(resultVariable);
                    return vector;
                }

            }
        } catch (Exception ex) {
            ex.printStackTrace();
            if(cepHandler != null){
                cepHandler.RequisicaoFinalizadaComErro(ex);
            }
        }

        vector.add("");
        return vector;
    }

    public void obterCEPAuthSync(final String logradouro, final String cidade, final String estado) throws Exception {

        new AsyncTask<Void, Void, Vector<String>>(){

            @Override
            protected void onPreExecute() {
                cepHandler.RequisicaoIniciada();
            }

            @Override
            protected Vector<String> doInBackground(Void... params) {
                return obterCEPAuthS(logradouro, cidade, estado);
            }

            @Override
            protected void onPostExecute(Vector<String> result) {
                cepHandler.RequisicaoFechada();
                if(result != null){
                    cepHandler.RequisicaoFinalizada("obterCEPAuth", result);
                }
            }
        }.execute();

    }

    private Vector<String> obterCEPAuthS(String logradouro, String cidade, String estado) {
        SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        soapEnvelope.implicitTypes = true;
        soapEnvelope.dotNet = true;

        SoapObject soapRequest = new SoapObject("urn:CEPService", "obterCEPAuth");
        soapRequest.addProperty("logradouro", logradouro);
        soapRequest.addProperty("localidade", cidade);
        soapRequest.addProperty("UF", estado);
        soapRequest.addProperty("usuario", USUARIO);
        soapRequest.addProperty("senha", SENHA);

        soapEnvelope.setOutputSoapObject(soapRequest);
        HttpTransportSE httpTransport = new HttpTransportSE(URL,timeOut);

        try {
            httpTransport.call("urn:CEPService/obterCEPAuth", soapEnvelope);

            Object retObj = soapEnvelope.bodyIn;

            if(retObj instanceof SoapFault){
                SoapFault fault = (SoapFault) retObj;
                Exception ex = new Exception(fault.faultstring);
                if (cepHandler != null){
                    cepHandler.RequisicaoFinalizadaComErro(ex);
                }
            } else {
                SoapObject result = (SoapObject) retObj;
                if (result.getPropertyCount() > 0) {
                    Object obj = result.getProperty(0);
                    Vector<String> vector = (Vector<String>) result.getProperty(0);
                    return vector;
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            if(cepHandler != null){
                cepHandler.RequisicaoFinalizadaComErro(ex);
            }
        }

        return null;
    }
}
