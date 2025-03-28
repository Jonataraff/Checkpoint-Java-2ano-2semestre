package br.com.restaurante.cliente.service;

import br.com.restaurante.cliente.dao.ClienteDAO;
import br.com.restaurante.cliente.dao.EnderecoDAO;
import br.com.restaurante.cliente.exception.ClienteException;
import br.com.restaurante.model.Cliente;
import br.com.restaurante.model.Endereco;

public class ClienteService {
    private final ClienteDAO clienteDAO = new ClienteDAO();
    private final EnderecoDAO enderecoDAO = new EnderecoDAO();

    public int cadastrarClienteComEndereco(String nome, String email, String telefone, String rua, String cidade, String estado, String cep) throws ClienteException {
        validarDadosCliente(nome, email, telefone);
        validarDadosEndereco(rua, cidade, estado, cep);

        try {
            // Cadastra o cliente e obtém o ID
            Cliente cliente = new Cliente(nome, email, telefone);
            int clienteId = clienteDAO.cadastrarCliente(cliente);

            if (clienteId == -1) {
                throw new ClienteException("Erro ao cadastrar cliente. Nenhum ID retornado.");
            }

            // Cadastra o endereço vinculado ao cliente
            Endereco endereco = new Endereco(clienteId, rua, cidade, estado, cep);
            enderecoDAO.cadastrarEndereco(endereco);

            return clienteId;
        } catch (Exception e) {
            throw new ClienteException("Erro ao cadastrar cliente e endereço: " + e.getMessage(), e);
        }
    }

    private void validarDadosCliente(String nome, String email, String telefone) throws ClienteException {
        if (nome == null || nome.trim().isEmpty() || !nome.trim().matches("[a-zA-ZÀ-ÿ ]+")) {
            throw new ClienteException("Nome inválido! Deve conter apenas letras e não pode ser vazio.");
        }
        if (email == null || email.trim().isEmpty() || !email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new ClienteException("Email inválido! Insira um email válido.");
        }
        if (telefone == null || telefone.trim().isEmpty() || !telefone.matches("^\\(\\d{2}\\)\\s\\d{4,5}-\\d{4}$")) {
            throw new ClienteException("Telefone inválido! Formato correto: (XX) XXXXX-XXXX.");
        }
    }

    private void validarDadosEndereco(String rua, String cidade, String estado, String cep) throws ClienteException {
        if (rua == null || rua.trim().length() < 3) {
            throw new ClienteException("Erro: Rua inválida. Deve ter pelo menos 3 caracteres.");
        }
        if (cidade == null || cidade.trim().length() < 2) {
            throw new ClienteException("Erro: Cidade inválida. Deve ter pelo menos 2 caracteres.");
        }
        if (estado == null || estado.trim().length() != 2) {
            throw new ClienteException("Erro: Estado inválido. Deve ter exatamente 2 letras.");
        }
        if (cep == null || !cep.matches("\\d{8}")) {
            throw new ClienteException("Erro: CEP inválido. Deve conter exatamente 8 números.");
        }
    }

	
}


