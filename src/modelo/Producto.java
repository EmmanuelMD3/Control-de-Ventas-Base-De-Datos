package modelo;

public class Producto
{
    private int idProducto;
    private String nombre;
    private double precio;
    private int stock;
    private boolean estado;

    public Producto()
    {
    }
    
    
    // Constructor
    public Producto(int idProducto, String nombre, double precio, int stock, boolean estado)
    {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.estado = estado;
    }

    // Getters y setters
    public int getIdProducto()
    {
        return idProducto;
    }

    public void setIdProducto(int idProducto)
    {
        this.idProducto = idProducto;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public double getPrecio()
    {
        return precio;
    }

    public void setPrecio(double precio)
    {
        this.precio = precio;
    }

    public int getStock()
    {
        return stock;
    }

    public void setStock(int stock)
    {
        this.stock = stock;
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
