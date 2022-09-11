package Model;

public class Movement {

    private String tipoDaMovimentacao;
    private String dataDaMovimentacao;
    private String dataDoPagamento;
    private String descricao;
    private String interessado;
    private Double valor;
    private String conta;
    private String situaca;

    public String getTipoDaMovimentacao() {
        return tipoDaMovimentacao;
    }

    public void setTipoDaMovimentacao(String tipoDaMovimentacao) {
        this.tipoDaMovimentacao = tipoDaMovimentacao;
    }

    public String getDataDaMovimentacao() {
        return dataDaMovimentacao;
    }

    public void setDataDaMovimentacao(String dataDaMovimentacao) {
        this.dataDaMovimentacao = dataDaMovimentacao;
    }

    public String getDataDoPagamento() {
        return dataDoPagamento;
    }

    public void setDataDoPagamento(String dataDoPagamento) {
        this.dataDoPagamento = dataDoPagamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getInteressado() {
        return interessado;
    }

    public void setInteressado(String interessado) {
        this.interessado = interessado;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public String getSituaca() {
        return situaca;
    }

    public void setSituaca(String situaca) {
        this.situaca = situaca;
    }
}
