package inter.cobrancav3.cobranca;

import com.fasterxml.jackson.databind.ObjectMapper;
import inter.cobrancav3.model.RequisicaoCancelarCobranca;
import inter.exceptions.SdkException;
import inter.model.Config;
import inter.model.Erro;
import inter.utils.HttpUtils;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

import static inter.constants.Constants.CERTIFICATE_EXCEPTION_MESSAGE;
import static inter.constants.Constants.ESCOPO_BOLETO_COBRANCA_WRITE;
import static inter.constants.Constants.GENERIC_EXCEPTION_MESSAGE;
import static inter.constants.Constants.URL_COBRANCAS;

@Slf4j
public class PagarCobrancaSandbox {

    public void pagar(Config config, String codigoSolicitacao, String pagarCom) throws SdkException {
        log.info("PagarCobrancaSandbox {} {} {}", config.getClientId(), codigoSolicitacao);
        String url = URL_COBRANCAS.replace("AMBIENTE", config.getAmbiente()) + "/" + codigoSolicitacao + "/pagar";
        String json = "{ \"pagarCom\": \"" + pagarCom + "\" }";
        HttpUtils.callPost(config, url, ESCOPO_BOLETO_COBRANCA_WRITE, "Erro ao pagar cobranca", json);
    }

}