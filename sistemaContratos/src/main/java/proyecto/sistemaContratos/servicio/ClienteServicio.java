package proyecto.sistemaContratos.servicio;

import org.springframework.stereotype.Service;
import proyecto.sistemaContratos.modelo.Cliente;
import proyecto.sistemaContratos.repositorio.ClienteRepositorio;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteServicio {
    private final ClienteRepositorio repositorio;

    //Asi se inyecta un repositorio via constructor en springboot
    public ClienteServicio(ClienteRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public List<Cliente> getAll() {
        return repositorio.buscarTodos();
    }

    public Optional<Cliente> getById(int id) {
        return repositorio.buscarPorId(id);
    }

    public Cliente create(Cliente cliente) {
        return repositorio.guardar(cliente);
    }

    public Cliente update(int id, Cliente cliente) {
        return repositorio.actualizar(id, cliente);
    }

    public boolean delete(int id) {
        return repositorio.eliminar(id);
    }
}

