package proyecto.sistemaContratos.repositorio;

import proyecto.sistemaContratos.modelo.Cliente;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ClienteRepositorio {
    private final List<Cliente> clientes = new ArrayList<>();
    private int nextId = 1;

    public List<Cliente> buscarTodos() {
        return clientes;
    }

    public Optional<Cliente> buscarPorId(int id) {
        return clientes.stream().filter(c -> c.getIdCliente() == id).findFirst();
    }

    public Cliente guardar(Cliente cliente) {
        cliente.setIdCliente(nextId++);
        clientes.add(cliente);
        return cliente;
    }

    public Cliente actualizar(int id, Cliente clienteUpdated) {
        Optional<Cliente> existing = buscarPorId(id);
        if (existing.isPresent()) {
            Cliente existingCliente = existing.get();
            existingCliente.setNombre(clienteUpdated.getNombre());
            existingCliente.setCorreo(clienteUpdated.getCorreo());
            existingCliente.setEstadoCliente(clienteUpdated.getEstadoCliente());
            return existingCliente;
        }
        return null;
    }

    public boolean eliminar(int id) {
        return clientes.removeIf(c -> c.getIdCliente() == id);
    }
}
