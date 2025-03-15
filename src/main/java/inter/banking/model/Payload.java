package inter.banking.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Payload {

    private String chave;
    private String codigoSolicitacao;
    private String dataHoraMovimento;
    private String dataHoraSolicitacao;
    private String endToEnd;
    private Recebedor recebedor;
    private String status;
    private String tipoMovimentacao;
    private String valor;

    private List<Erro> erros;
}
