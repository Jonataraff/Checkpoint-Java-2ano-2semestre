package br.com.restaurante.cliente.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import br.com.restaurante.model.Endereco;

public class EnderecoDAO {
    private static final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";
    private static final String USER = "RM552939";
    private static final String PASSWORD = "201104";

    public void cadastrarEndereco(Endereco endereco) {
        String sql = "INSERT INTO ENDERECO (CLIENTE_ID, RUA, CIDADE, ESTADO, CEP) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, endereco.getClienteId());
            stmt.setString(2, endereco.getRua());
            stmt.setString(3, endereco.getCidade());
            stmt.setString(4, endereco.getEstado());
            stmt.setString(5, endereco.getCep());

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Endereço cadastrado com sucesso!");
            } else {
                System.out.println("Erro ao cadastrar endereço.");
            }

        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar endereço: " + e.getMessage());
        }
    }
}