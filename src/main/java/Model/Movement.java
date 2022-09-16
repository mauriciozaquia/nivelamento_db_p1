package Model;

import java.util.Date;

public class Movement {

    private String tipoDaMovimentacao;
    private Date dataDaMovimentacao;
    private Date dataDoPagamento;
    private String descricao;
    private String interessado;
    private Double valor;
    private String conta;
    private String situacao;

    public String getTipoDaMovimentacao() {
        return tipoDaMovimentacao;
    }

    public void setTipoDaMovimentacao(String tipoDaMovimentacao) {
        this.tipoDaMovimentacao = tipoDaMovimentacao;
    }

    public Date getDataDaMovimentacao() {
        return dataDaMovimentacao;
    }

    public void setDataDaMovimentacao(Date dataDaMovimentacao) {
        this.dataDaMovimentacao = dataDaMovimentacao;
    }

    public Date getDataDoPagamento() {
        return dataDoPagamento;
    }

    public void setDataDoPagamento(Date dataDoPagamento) {
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

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
}
