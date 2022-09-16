package Framework.Utils;

import Model.Movement;

import java.io.IOException;

public class PropertiesSaver {
    public static void setValuesPropertiesUser(String nome, String email, String senha) throws IOException {
        FilesOperation.setProperties("user", "nome", nome);
        FilesOperation.setProperties("user", "email", email);
        FilesOperation.setProperties("user", "senha", senha);
    }

    public static void setValuesPropertiesMovement(Movement m) throws IOException {
        FilesOperation.setProperties("movement", "tipo_da_movimentacao", m.getTipoDaMovimentacao());
        FilesOperation.setProperties("movement", "data_movimentacao", m.getDataDaMovimentacao().toString());
        FilesOperation.setProperties("movement", "data_pagamento", m.getDataDoPagamento().toString());
        FilesOperation.setProperties("movement", "descricao", m.getDescricao());
        FilesOperation.setProperties("movement", "interessado", m.getInteressado());
        FilesOperation.setProperties("movement", "valor", m.getValor().toString());
        FilesOperation.setProperties("movement", "conta", m.getConta());
    }

    public static void setValuesPropertiesBalanceZeraSaldo() throws IOException {
        FilesOperation.setProperties("balance", "balance", "0");
    }

    public static void setValuePropertiesBalanceAtualizaSaldo(Movement m) throws IOException {
        Double balance = Double.parseDouble(FilesOperation.getProperties("balance").getProperty("balance"));
        balance = (m.getTipoDaMovimentacao().equals("Receita")) ? (balance + m.getValor()) : (balance - m.getValor());
        FilesOperation.setProperties("balance", "balance", balance.toString());
    }

}
