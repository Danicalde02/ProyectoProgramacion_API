package proyecto.sistemaContratos.controlador;

import proyecto.sistemaContratos.modelo.Inventario;
import proyecto.sistemaContratos.repositorio.InventarioRepositorio;

import java.util.List;
import java.util.Optional;

public class InventarioControlador {
    private final InventarioRepositorio repositorio;

    public InventarioControlador(InventarioRepositorio repositorio) {
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
