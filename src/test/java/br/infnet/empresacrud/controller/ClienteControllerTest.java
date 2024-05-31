package br.infnet.empresacrud.controller;

import br.infnet.empresacrud.model.Cliente;
import br.infnet.empresacrud.service.ClienteService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ClienteControllerTest {

    @Mock
    private ClienteService clienteService;

    @InjectMocks
    private ClienteController clienteController;

    @Test
    void getAllClientes_ReturnsListOfClientes() {
        // Mocking some clientes
        Cliente cliente1 = new Cliente();
        cliente1.setId(1L);
        cliente1.setNome("João");
        cliente1.setEmail("joao@example.com");
        cliente1.setTelefone("123456789");

        Cliente cliente2 = new Cliente();
        cliente2.setId(2L);
        cliente2.setNome("Maria");
        cliente2.setEmail("maria@example.com");
        cliente2.setTelefone("987654321");

        List<Cliente> clientes = Arrays.asList(cliente1, cliente2);

        // Stubbing the service method
        when(clienteService.findAll()).thenReturn(clientes);

        // Calling the controller method
        List<Cliente> result = clienteController.getAllClientes();

        // Verifying the result
        assertEquals(2, result.size());
        assertEquals(cliente1.getNome(), result.get(0).getNome());
        assertEquals(cliente2.getNome(), result.get(1).getNome());
    }

    @Test
    void getClienteById_ReturnsClienteIfExists() {
        // Mocking a cliente
        Cliente cliente = new Cliente();
        cliente.setId(1L);
        cliente.setNome("João");
        cliente.setEmail("joao@example.com");
        cliente.setTelefone("123456789");

        // Stubbing the service method
        when(clienteService.findById(1L)).thenReturn(cliente);

        // Calling the controller method
        ResponseEntity<Cliente> responseEntity = clienteController.getClienteById(1L);

        // Verifying the response entity
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(cliente.getNome(), responseEntity.getBody().getNome());
    }

    @Test
    void getClienteById_ReturnsNotFoundIfClienteDoesNotExist() {
        // Stubbing the service method to return null
        when(clienteService.findById(1L)).thenReturn(null);

        // Calling the controller method
        ResponseEntity<Cliente> responseEntity = clienteController.getClienteById(1L);

        // Verifying the response entity
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
    }

    @Test
    void createCliente_ReturnsCreatedCliente() {
        // Mocking a cliente to be created
        Cliente cliente = new Cliente();
        cliente.setNome("João");
        cliente.setEmail("joao@example.com");
        cliente.setTelefone("123456789");

        // Stubbing the service method
        when(clienteService.save(cliente)).thenReturn(cliente);

        // Calling the controller method
        Cliente createdCliente = clienteController.createCliente(cliente);

        // Verifying the created cliente
        assertEquals(cliente.getNome(), createdCliente.getNome());
        assertEquals(cliente.getEmail(), createdCliente.getEmail());
        assertEquals(cliente.getTelefone(), createdCliente.getTelefone());
    }

    @Test
    void updateCliente_ReturnsUpdatedCliente() {
        // Mocking an existing cliente and its updated details
        Cliente existingCliente = new Cliente();
        existingCliente.setId(1L);
        existingCliente.setNome("João");
        existingCliente.setEmail("joao@example.com");
        existingCliente.setTelefone("123456789");

        Cliente updatedCliente = new Cliente();
        updatedCliente.setId(1L);
        updatedCliente.setNome("Maria");
        updatedCliente.setEmail("maria@example.com");
        updatedCliente.setTelefone("987654321");

        // Stubbing the service method to return the existing cliente
        when(clienteService.findById(1L)).thenReturn(existingCliente);

        // Stubbing the service method to return the updated cliente after saving
        when(clienteService.save(existingCliente)).thenReturn(updatedCliente);

        // Calling the controller method
        ResponseEntity<Cliente> responseEntity = clienteController.updateCliente(1L, updatedCliente);

        // Verifying the response entity
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        // Verifying the updated cliente in the response body
        assertEquals(updatedCliente.getNome(), responseEntity.getBody().getNome());
        assertEquals(updatedCliente.getEmail(), responseEntity.getBody().getEmail());
        assertEquals(updatedCliente.getTelefone(), responseEntity.getBody().getTelefone());
    }

    @Test
    void deleteCliente_ReturnsNoContent() {
        // Stubbing the service method to return an existing cliente
        Cliente cliente = new Cliente();
        cliente.setId(1L);
        cliente.setNome("João");
        cliente.setEmail("joao@example.com");
        cliente.setTelefone("123456789");
        when(clienteService.findById(1L)).thenReturn(cliente);

        // Calling the controller method
        ResponseEntity<Void> responseEntity = clienteController.deleteCliente(1L);

        // Verifying the response entity
        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());

        // Verifying that the service method to delete the cliente was called once
        verify(clienteService, times(1)).deleteById(1L);
    }
}
