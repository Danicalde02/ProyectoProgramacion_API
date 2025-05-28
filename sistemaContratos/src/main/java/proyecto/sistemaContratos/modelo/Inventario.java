package proyecto.sistemaContratos.modelo;

public class Inventario {
    private int idInventario;
    private String modelo;
    private String serial;
    private String numeroparte;
    private int valorunitario;
    private EstadoInventario estadoInventario;
    private TipoEquipo tipoEquipo;


    public int getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(int idInventario) {
        this.idInventario = idInventario;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getNumeroParte() {
        return numeroparte;
    }

    public void setNumeroParte(String numeroparte) {
        this.numeroparte = numeroparte;
    }

    public int getValorUnitario() {
        return valorunitario;
    }

    public void setValorUnitario(int valorunitario) {
        this.valorunitario = valorunitario;
    }

    public EstadoInventario getEstadoInventario() {
        return estadoInventario;
    }

    public void setEstadoInventario(EstadoInventario estadoInventario) {
        this.estadoInventario = estadoInventario;
    }

    public TipoEquipo getTipoEquipo() {
        return tipoEquipo;
    }

    public void setTipoEquipo(TipoEquipo tipoEquipo) {
        this.tipoEquipo = tipoEquipo;
    }
}
