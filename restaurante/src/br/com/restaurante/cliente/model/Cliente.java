package br.com.restaurante.cliente.model;
import br.com.restaurante.cliente.exception.ClienteException;
import java.util.List;

public class Cliente {
	private int id;
    private String nome;
    private String email;
    private String telefone;
    private String endereco;
    
    public Cliente(int id, String nome, String email, String telefone, String endereco) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
    }
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	
    public void cadastrarCliente(List<Cliente> clientes, Cliente cliente) throws ClienteException {
        if (cliente == null) {
            throw new ClienteException("O cliente a ser cadastrado não pode ser nulo.");
        }
        clientes.add(cliente);
        System.out.println("Cliente cadastrado com sucesso: " + cliente.getNome());
    }

    public void atualizarCliente(List<Cliente> clientes, int idCliente, Cliente clienteAtualizado) throws ClienteException {
        if (clienteAtualizado == null) {
            throw new ClienteException("O cliente a ser atualizado não pode ser nulo.");
        }
        for (Cliente cliente : clientes) {
            if (cliente.getId() == idCliente) {
                cliente.setNome(clienteAtualizado.getNome());
                cliente.setEmail(clienteAtualizado.getEmail());
                cliente.setTelefone(clienteAtualizado.getTelefone());
                cliente.setEndereco(clienteAtualizado.getEndereco());
                System.out.println("Cliente atualizado com sucesso: " + cliente.getNome());
                return;
            }
        }
        throw new ClienteException("Cliente com ID " + idCliente + " não encontrado.");
    }

    public void consultarCliente(List<Cliente> clientes, int idCliente) throws ClienteException {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == idCliente) {
                System.out.println("Nome: " + cliente.getNome());
                System.out.println("Email: " + cliente.getEmail());
                System.out.println("Telefone: " + cliente.getTelefone());
                System.out.println("Endereço: " + cliente.getEndereco());
                return;
            }
        }
        throw new ClienteException("Cliente com ID " + idCliente + " não encontrado.");
    }

    public void listarClientes(List<Cliente> clientes) throws ClienteException {
        if (clientes == null || clientes.isEmpty()) {
            throw new ClienteException("Nenhum cliente cadastrado.");
        }
        for (Cliente cliente : clientes) {
            System.out.println("ID: " + cliente.getId() + " - Cliente: " + cliente.getNome());
        }
    }
}

