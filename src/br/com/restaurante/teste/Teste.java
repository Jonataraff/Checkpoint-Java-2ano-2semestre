package br.com.restaurante.teste;

import br.com.restaurante.cliente.service.ClienteService;
import br.com.restaurante.cliente.exception.ClienteException;

import java.util.Scanner;

public class Teste {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ClienteService clienteService = new ClienteService();

        System.out.println("=== Cadastro de Cliente e Endereco ===");

        System.out.print("Digite o nome do cliente: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o email do cliente: ");
        String email = scanner.nextLine();

        System.out.print("Digite o telefone do cliente (formato: (XX) XXXXX-XXXX): ");
        String telefone = scanner.nextLine();

        System.out.print("Digite a rua: ");
        String rua = scanner.nextLine();

        System.out.print("Digite a cidade: ");
        String cidade = scanner.nextLine();

        System.out.print("Digite o Estado (apenas duas letras): ");
        String estado = scanner.nextLine();

        System.out.print("Digite o CEP: ");
        String cep = scanner.nextLine();

        try {
        	int clienteId = clienteService.cadastrarClienteComEndereco(nome, email, telefone, rua, cidade, estado, cep);
            System.out.println("Cadastro concluído com sucesso! Cliente ID: " + clienteId);
        } catch (ClienteException e) {
            System.err.println("Erro ao cadastrar cliente e endereço: " + e.getMessage());
        }

        scanner.close();
    }
}