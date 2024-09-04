package br.com.restaurante.cliente.test;
import br.com.restaurante.cliente.exception.ClienteException;
import br.com.restaurante.cliente.model.Cliente;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
        List<Cliente> clientes = new ArrayList<>();

        System.out.print("Digite o ID do cliente: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Digite o nome do cliente: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o email do cliente: ");
        String email = scanner.nextLine();

        System.out.print("Digite o telefone do cliente: ");
        String telefone = scanner.nextLine();

        System.out.print("Digite o endereço do cliente: ");
        String endereco = scanner.nextLine();

        Cliente cliente1 = new Cliente(id, nome, email, telefone, endereco);

        Cliente cliente2 = new Cliente(2, "Maria", "maria@example.com", "987654321", "Rua B, 456");
        Cliente cliente3 = new Cliente(3, "Jonas", "jonas@example.com", "543754321", "Rua C, 678");
        Cliente cliente4 = new Cliente(4, "Carlo", "carlo@example.com", "987658473", "Rua D, 890");

        try {
            cliente1.cadastrarCliente(clientes, cliente1);
            cliente2.cadastrarCliente(clientes, cliente2);
            cliente3.cadastrarCliente(clientes, cliente3);
            cliente4.cadastrarCliente(clientes, cliente4);

            cliente1.listarClientes(clientes);

            cliente1.consultarCliente(clientes, 1);

            Cliente clienteAtualizado = new Cliente(1, "João Silva", "joao.silva@example.com", "123456789", "Rua A, 123");
            cliente1.atualizarCliente(clientes, 1, clienteAtualizado);
            cliente1.consultarCliente(clientes, 1);

            cliente1.listarClientes(clientes);

        } catch (ClienteException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}