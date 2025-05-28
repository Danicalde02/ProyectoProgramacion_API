package proyecto.sistemaContratos.servicio;

import org.springframework.stereotype.Service;
import proyecto.sistemaContratos.modelo.Inventario;
import proyecto.sistemaContratos.repositorio.InventarioRepositorio;
import java.util.List;
import java.util.Optional;

@Service
public class InventarioServicio {
    private final InventarioRepositorio repositorio;

    public InventarioServicio(InventarioRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public List<Inventario> getAll() {
        return repositorio.buscarTodos();
    }

    public Optional<Inventario> getById(int id) {
        return repositorio.buscarPorId(id);
    }

    public Inventario create(Inventario Inventario) {
        return repositorio.guardar(Inventario);
    }

    public Inventario update(int id, Inventario Inventario) {
        return repositorio.actualizar(id, Inventario);
    }

    public boolean delete(int id) {
        return repositorio.eliminar(id);
    }
}
