package proyecto.sistemaContratos.servicio;

import org.springframework.stereotype.Service;
import proyecto.sistemaContratos.modelo.Contrato;
import proyecto.sistemaContratos.repositorio.ContratoRepositorio;
import java.util.List;
import java.util.Optional;

@Service
public class ContratoServicio {
    private final ContratoRepositorio repositorio;

    public ContratoServicio(ContratoRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public List<Contrato> buscarTodos() {
        return repositorio.buscarTodos();
    }

    public Optional<Contrato> getById(int id) {
        return repositorio.buscarPorId(id);
    }

    public Contrato create(Contrato contrato) {
        return repositorio.guardar(contrato);
    }

    public Contrato update(int id, Contrato contrato) {
        return repositorio.actualizar(id, contrato);
    }

    public boolean delete(int id) {
        return repositorio.eliminar(id);
    }
}
