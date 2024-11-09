package modelo;

import java.util.Date;

public class Venta
{
    private int idVenta;
    private int idCliente;
    private int idVendedor;
    private String numeroVenta;
    private Date fechaVenta;
    private double monto;
    private boolean estado;

    // Constructor
    public Venta(int idVenta, int idCliente, int idVendedor, String numeroVenta,
            Date fechaVenta, double monto, boolean estado)
    {
        this.idVenta = idVenta;
        this.idCliente = idCliente;
        this.idVendedor = idVendedor;
        this.numeroVenta = numeroVenta;
        this.fechaVenta = fechaVenta;
        this.monto = monto;
        this.estado = estado;
    }

    // Getters y setters
    public int getIdVenta()
    {
        return idVenta;
    }

    public void setIdVenta(int idVenta)
    {
        this.idVenta = idVenta;
    }

    public int getIdCliente()
    {
        return idCliente;
    }

    public void setIdCliente(int idCliente)
    {
        this.idCliente = idCliente;
    }

    public int getIdVendedor()
    {
        return idVendedor;
    }

    public void setIdVendedor(int idVendedor)
    {
        this.idVendedor = idVendedor;
    }

    public String getNumeroVenta()
    {
        return numeroVenta;
    }

    public void setNumeroVenta(String numeroVenta)
    {
        this.numeroVenta = numeroVenta;
    }

    public Date getFechaVenta()
    {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta)
    {
        this.fechaVenta = fechaVenta;
    }

    public double getMonto()
    {
        return monto;
    }

    public void setMonto(double monto)
    {
        this.monto = monto;
    }

    public boolean isEstado()
    {
        return estado;
    }

    public void setEstado(boolean estado)
    {
        this.estado = estado;
    }
}
