package modelo;

public class Detalle_Venta
{
    private int idDetalleVenta;
    private int idVentas;
    private int idProducto;
    private int cantidad;
    private double precio;

    public Detalle_Venta()
    {
    }
    
    public Detalle_Venta(int idDetalleVenta, int idVentas, int idProducto, int cantidad, double precio)
    {
        this.idDetalleVenta = idDetalleVenta;
        this.idVentas = idVentas;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public int getIdDetalleVenta()
    {
        return idDetalleVenta;
    }

    public void setIdDetalleVenta(int idDetalleVenta)
    {
        this.idDetalleVenta = idDetalleVenta;
    }

    public int getIdVentas()
    {
        return idVentas;
    }

    public void setIdVentas(int idVentas)
    {
        this.idVentas = idVentas;
    }

    public int getIdProducto()
    {
        return idProducto;
    }

    public void setIdProducto(int idProducto)
    {
        this.idProducto = idProducto;
    }

    public int getCantidad()
    {
        return cantidad;
    }

    public void setCantidad(int cantidad)
    {
        this.cantidad = cantidad;
    }

    public double getPrecio()
    {
        return precio;
    }

    public void setPrecio(double precio)
    {
        this.precio = precio;
    }
}
