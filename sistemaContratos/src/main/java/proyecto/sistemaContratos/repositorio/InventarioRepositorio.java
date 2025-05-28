package proyecto.sistemaContratos.repositorio;

import org.springframework.stereotype.Repository;
import proyecto.sistemaContratos.modelo.Inventario;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class InventarioRepositorio {
    private final List<Inventario> Inventarios = new ArrayList<>();
    private int nextId = 1;

    public List<Inventario> buscarTodos() {
        return Inventarios;
    }

    public Optional<Inventario> buscarPorId(int id) {
        return Inventarios.stream().filter(i -> i.getIdInventario() == id).findFirst();
    }

    public Inventario guardar(Inventario Inventario) {
        Inventario.setIdInventario(nextId++);
        Inventarios.add(Inventario);
        return Inventario;
    }

    public Inventario actualizar(int id, Inventario InventarioUpdated) {
        Optional<Inventario> existing = buscarPorId(id);
        if (existing.isPresent()) {
            Inventario existingInventario = existing.get();
            existingInventario.setModelo(InventarioUpdated.getModelo());
            existingInventario.setSerial(InventarioUpdated.getSerial());
            existingInventario.setEstadoInventario(InventarioUpdated.getEstadoInventario());
            existingInventario.setNumeroParte(InventarioUpdated.getNumeroParte());
            existingInventario.setValorUnitario(InventarioUpdated.getValorUnitario());
            return existingInventario;
        }
        return null;
    }

    public boolean eliminar(int id) {
        return Inventarios.removeIf(i -> i.getIdInventario() == id);
    }
}
