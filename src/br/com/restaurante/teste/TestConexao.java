package br.com.restaurante.teste;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConexao {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";
        String user = "RM552939"; 
        String password = "201104";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Conexão estabelecida com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro na conexão: " + e.getMessage());
        }
    }
}