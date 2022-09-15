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
        FilesOperation.setProperties("movement", "data_movimentacao", m.getDataDaMovimentacao());
        FilesOperation.setProperties("movement", "data_pagamento", m.getDataDoPagamento());
        FilesOperation.setProperties("movement", "descricao", m.getDescricao());
        FilesOperation.setProperties("movement", "interessado", m.getInteressado());
        FilesOperation.setProperties("movement", "valor", m.getValor().toString());
        FilesOperation.setProperties("movement", "conta", m.getConta());
    }

}
