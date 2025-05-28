package proyecto.sistemaContratos.repositorio;

import org.springframework.stereotype.Repository;
import proyecto.sistemaContratos.modelo.Contrato;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContratoRepositorio {
    private final List<Contrato> contratos = new ArrayList<>();
    private int nextId = 1;

    public List<Contrato> buscarTodos() {
        return contratos;
    }

    public Optional<Contrato> buscarPorId(int id) {
        return contratos.stream().filter(c -> c.getIdContrato() == id).findFirst();
    }

    public Contrato guardar(Contrato contrato) {
        contrato.setIdContrato(nextId++);
        contratos.add(contrato);
        return contrato;
    }

    public Contrato actualizar(int id, Contrato contratoUpdated) {
        Optional<Contrato> existing = buscarPorId(id);
        if (existing.isPresent()) {
            Contrato existingContrato = existing.get();
            existingContrato.setCliente(contratoUpdated.getCliente());
            existingContrato.setFechaInicio(contratoUpdated.getFechaInicio());
            existingContrato.setFechaFin(contratoUpdated.getFechaFin());
            existingContrato.setEstadoContrato(contratoUpdated.getEstadoContrato());
            existingContrato.setTipoContrato(contratoUpdated.getTipoContrato());
            existingContrato.setValorContrato(contratoUpdated.getValorContrato());
            return existingContrato;
        }
        return null;
    }

    public boolean eliminar(int id) {
        return contratos.removeIf(c -> c.getIdContrato() == id);
    }
}
