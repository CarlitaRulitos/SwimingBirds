import java.util.Date;

public class Despacho {
    private int idTran;
    private Date fechaSol;
    private int codCliente;
    private String razonSocial;
    private int codArticulo;
    private String nombreArticulo;
    private int valorUni;
    private int cantidadUnidades;
    private int montoTotal;
    private String estado;
    private Date fechaDesp;

    public Despacho(int idTran, Date fechaSol, int codCliente, String razonSocial, int codArticulo, String nombreArticulo, int valorUni, int cantidadUnidades, int montoTotal, String estado, Date fechaDesp) {
        this.idTran = idTran;
        this.fechaSol = fechaSol;
        this.codCliente = codCliente;
        this.razonSocial = razonSocial;
        this.codArticulo = codArticulo;
        this.nombreArticulo = nombreArticulo;
        this.valorUni = valorUni;
        this.cantidadUnidades = cantidadUnidades;
        this.montoTotal = montoTotal;
        this.estado = estado;
        this.fechaDesp = fechaDesp;
    }

    public int getIdTran() {
        return idTran;
    }

    public void setIdTran(int idTran) {
        this.idTran = idTran;
    }

    public Date getFechaSol() {
        return fechaSol;
    }

    public void setFechaSol(Date fechaSol) {
        this.fechaSol = fechaSol;
    }

    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public int getCodArticulo() {
        return codArticulo;
    }

    public void setCodArticulo(int codArticulo) {
        this.codArticulo = codArticulo;
    }

    public String getNombreArticulo() {
        return nombreArticulo;
    }

    public void setNombreArticulo(String nombreArticulo) {
        this.nombreArticulo = nombreArticulo;
    }

    public int getValorUni() {
        return valorUni;
    }

    public void setValorUni(int valorUni) {
        this.valorUni = valorUni;
    }

    public int getCantidadUnidades() {
        return cantidadUnidades;
    }

    public void setCantidadUnidades(int cantidadUnidades) {
        this.cantidadUnidades = cantidadUnidades;
    }

    public int getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(int montoTotal) {
        this.montoTotal = montoTotal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaDesp() {
        return fechaDesp;
    }

    public void setFechaDesp(Date fechaDesp) {
        this.fechaDesp = fechaDesp;
    }
}
