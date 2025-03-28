package br.com.restaurante.model;

public class Endereco {
    private int id;
    private int clienteId;
    private String rua;
    private String cidade;
    private String estado;
    private String cep;

    public Endereco(int clienteId, String rua, String cidade, String estado, String cep) {
        this.clienteId = clienteId;
        this.rua = rua;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getClienteId() { return clienteId; }
    public void setClienteId(int clienteId) { this.clienteId = clienteId; }
    public String getRua() { return rua; }
    public void setRua(String rua) { this.rua = rua; }
    public String getCidade() { return cidade; }
    public void setCidade(String cidade) { this.cidade = cidade; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public String getCep() { return cep; }
    public void setCep(String cep) { this.cep = cep; }

    @Override
    public String toString() {
        return rua + ", " + cidade + " - " + estado + ", CEP: " + cep;
    }
}