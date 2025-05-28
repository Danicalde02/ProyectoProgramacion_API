package proyecto.sistemaContratos.controlador;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import  proyecto.sistemaContratos.modelo.Contrato;
import  proyecto.sistemaContratos.servicio.ContratoServicio;

import java.util.List;

@RestController
@RequestMapping("/api/contratos")
public class ContratoControlador {
    private final ContratoServicio servicio;

    public ContratoControlador(ContratoServicio servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    public ResponseEntity<List<Contrato>> getAll() {
        return ResponseEntity.ok(servicio.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contrato> getById(@PathVariable int id) {
        return servicio.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Contrato> create(@RequestBody Contrato contrato) {
        return ResponseEntity.ok(servicio.create(contrato));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contrato> update(@PathVariable int id, @RequestBody Contrato contrato) {
        Contrato updated = servicio.update(id, contrato);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        return servicio.delete(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}