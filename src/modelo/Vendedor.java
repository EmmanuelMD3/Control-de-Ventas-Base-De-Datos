package modelo;

public class Vendedor
{
    private int idVendedor;
    private String dni;
    private String nombre;
    private String telefono;
    private boolean estado;

    public Vendedor()
    {
    }
   
    // Constructor
    public Vendedor(int idVendedor, String dni, String nombre, String telefono, boolean estado)
    {
        this.idVendedor = idVendedor;
        this.dni = dni;
        this.nombre = nombre;
        this.telefono = telefono;
        this.estado = estado;
    }

    // Getters y setters
    public int getIdVendedor()
    {
        return idVendedor;
    }

    public void setIdVendedor(int idVendedor)
    {
        this.idVendedor = idVendedor;
    }

    public String getDni()
    {
        return dni;
    }

    public void setDni(String dni)
    {
        this.dni = dni;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public String getTelefono()
    {
        return telefono;
    }

    public void setTelefono(String telefono)
    {
        this.telefono = telefono;
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
