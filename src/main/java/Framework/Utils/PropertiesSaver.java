package Framework.Utils;

import Model.Movement;

import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;

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

    public static void zeraSaldo() throws IOException {
        FilesOperation.setProperties("balance", "balance", "0");
    }

    public static void atualizaSaldo(Movement m) throws IOException {
        Double balance = Double.parseDouble(FilesOperation.getProperties("balance").getProperty("balance"));
        if(m.getTipoDaMovimentacao().equals("Receita")){
            balance = balance + m.getValor();
        } else {
            balance = balance - m.getValor();
        }

        //DecimalFormat df = new DecimalFormat("0,00");
        //df.setRoundingMode(RoundingMode.HALF_UP);
        //balance = Double.parseDouble(df.format(balance)); // TODO CORRIGIR

        System.out.println("ANTES DE GRAVAR: " + balance);
        FilesOperation.setProperties("balance", "balance", balance.toString());
    }

}
