package inter.banking.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import inter.banking.model.enums.TipoRetornoPagamentoPixEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RespostaIncluirPix {

    private TipoRetornoPagamentoPixEnum tipoRetorno;
    /**
     * Id transação do pagamento Pix
     */
    private String endToEndId;
    /**
     * Id da tabela pagamento ou devolução Pix para aprovação
     */
    private String codigoSolicitacao;
    private String dataPagamento;
    private String dataOperacao;
    private String idAprovacao;

    @Builder.Default
    private Map<String, Object> camposAdicionais = new HashMap<>();

    @JsonAnyGetter
    public Map<String, Object> getCamposAdicionais() {
        return camposAdicionais;
    }

    @JsonAnySetter
    public void setCamposAdicionais(final String nome, final Object valor) {
        this.camposAdicionais.put(nome, valor);
    }

}