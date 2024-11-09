package dao;

import conexion.Conexion;
import modelo.Cliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDao
{

    public static List<Cliente> listarClientes()
    {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM Cliente";

        try (Connection conn = Conexion.conectar(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql))
        {

            while (rs.next())
            {
                Cliente cliente = new Cliente(
                        rs.getInt("Id_Cliente"),
                        rs.getString("Dni"),
                        rs.getString("Nombres"),
                        rs.getString("Direccion"),
                        rs.getBoolean("Estado")
                );
                clientes.add(cliente);
            }

        } catch (SQLException e)
        {
            System.err.println("Error al listar clientes: " + e.getMessage());
        }
        return clientes;
    }

    public static List<Cliente> listarClientesEnMetepec()
    {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT Id_Cliente, Dni, Nombres, Direccion, Estado FROM Cliente WHERE Direccion = 'Metepec'";

        try (Connection conn = Conexion.conectar(); PreparedStatement stmt = conn.prepareStatement(sql))
        {
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                Cliente cliente = new Cliente(
                        rs.getInt("Id_Cliente"),
                        rs.getString("Dni"),
                        rs.getString("Nombres"),
                        rs.getString("Direccion"),
                        rs.getBoolean("Estado")
                );
                clientes.add(cliente);
            }
        } catch (SQLException e)
        {
            System.err.println("Error al listar clientes en Metepec: " + e.getMessage());
        }
        return clientes;
    }

    public static List<Cliente> listarClientesPorDireccionToluca()
    {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT Id_Cliente, Dni, Nombres, Direccion, Estado FROM Cliente WHERE Direccion LIKE '%Toluca%'";

        try (Connection conn = Conexion.conectar(); PreparedStatement stmt = conn.prepareStatement(sql))
        {
            ResultSet rs = stmt.executeQuery();

            while (rs.next())
            {
                Cliente cliente = new Cliente(
                        rs.getInt("Id_Cliente"),
                        rs.getString("Dni"),
                        rs.getString("Nombres"),
                        rs.getString("Direccion"),
                        rs.getBoolean("Estado")
                );
                clientes.add(cliente);
            }
        } catch (SQLException e)
        {
            System.err.println("Error al listar clientes por dirección Toluca: " + e.getMessage());
        }
        return clientes;
    }

    public static int contarClientesInactivos()
    {
        int totalInactivos = 0;
        String sql = "SELECT COUNT(*) AS Total FROM Cliente WHERE Estado = 0";

        try (Connection conn = Conexion.conectar(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql))
        {
            if (rs.next())
            {
                totalInactivos = rs.getInt("Total");
            }
        } catch (SQLException e)
        {
            System.err.println("Error al contar los clientes inactivos: " + e.getMessage());
        }
        return totalInactivos;
    }

    public static List<Cliente> listarClientesInactivos()
    {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM Cliente WHERE Estado = 0";

        try (Connection conn = Conexion.conectar(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql))
        {
            while (rs.next())
            {
                Cliente cliente = new Cliente(
                        rs.getInt("Id_Cliente"),
                        rs.getString("Dni"),
                        rs.getString("Nombres"),
                        rs.getString("Direccion"),
                        rs.getBoolean("Estado")
                );
                clientes.add(cliente);
            }
        } catch (SQLException e)
        {
            System.err.println("Error al listar clientes inactivos: " + e.getMessage());
        }
        return clientes;
    }

    public static List<Cliente> listarClientesActivos()
    {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM Cliente WHERE Estado = 1";

        try (Connection conn = Conexion.conectar(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql))
        {
            while (rs.next())
            {
                Cliente cliente = new Cliente(
                        rs.getInt("Id_Cliente"),
                        rs.getString("Dni"),
                        rs.getString("Nombres"),
                        rs.getString("Direccion"),
                        rs.getBoolean("Estado")
                );
                clientes.add(cliente);
            }
        } catch (SQLException e)
        {
            System.err.println("Error al listar los clientes activos: " + e.getMessage());
        }
        return clientes;
    }

    public static int contarClientes(boolean soloActivos)
    {
        int totalClientes = 0;
        String sql = "SELECT COUNT(*) AS Total FROM Cliente";

        if (soloActivos)
        {
            sql += " WHERE Estado = 1";
        }

        try (Connection conn = Conexion.conectar(); PreparedStatement stmt = conn.prepareStatement(sql))
        {
            ResultSet rs = stmt.executeQuery();

            if (rs.next())
            {
                totalClientes = rs.getInt("Total");
            }
        } catch (SQLException e)
        {
            System.err.println("Error al contar los clientes: " + e.getMessage());
        }
        return totalClientes;
    }

    public static List<Cliente> listarClientesPorFiltros(boolean filtroId, boolean filtroDni, boolean filtroNombres, boolean filtroDireccion, boolean filtroEstado, Boolean estado)
    {
        List<Cliente> clientes = new ArrayList<>();

        StringBuilder sql = new StringBuilder("SELECT ");
        boolean hasFilters = false;

        if (filtroId)
        {
            sql.append("Id_Cliente, ");
            hasFilters = true;
        }
        if (filtroDni)
        {
            sql.append("Dni, ");
            hasFilters = true;
        }
        if (filtroNombres)
        {
            sql.append("Nombres, ");
            hasFilters = true;
        }
        if (filtroDireccion)
        {
            sql.append("Direccion, ");
            hasFilters = true;
        }
        if (filtroEstado)
        {
            sql.append("Estado, ");
            hasFilters = true;
        }

        if (!hasFilters)
        {
            sql.append("1 ");
        } else
        {
            sql.setLength(sql.length() - 2);
        }

        sql.append(" FROM Cliente");

        if (estado != null)
        {
            sql.append(" WHERE Estado = ").append(estado);
        }

        try (Connection conn = Conexion.conectar(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql.toString()))
        {
            while (rs.next())
            {
                Cliente cliente = new Cliente();

                if (filtroId)
                {
                    cliente.setIdCliente(rs.getInt("Id_Cliente"));
                }
                if (filtroDni)
                {
                    cliente.setDni(rs.getString("Dni"));
                }
                if (filtroNombres)
                {
                    cliente.setNombres(rs.getString("Nombres"));
                }
                if (filtroDireccion)
                {
                    cliente.setDireccion(rs.getString("Direccion"));
                }
                if (filtroEstado)
                {
                    cliente.setEstado(rs.getBoolean("Estado"));
                }
                clientes.add(cliente);
            }
        } catch (SQLException e)
        {
            System.err.println("Error al listar clientes con filtros: " + e.getMessage());
        }
        return clientes;
    }

    public static int obtenerIdClientePorDni(String dni)
    {
        String sql = "SELECT Id_Cliente FROM Cliente WHERE Dni = ?";
        try (Connection conn = Conexion.conectar(); PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setString(1, dni);
            ResultSet rs = stmt.executeQuery();

            if (rs.next())
            {
                return rs.getInt("Id_Cliente");
            }
        } catch (SQLException e)
        {
            System.err.println("Error al obtener el ID del cliente: " + e.getMessage());
        }
        return -1;
    }

    public static modelo.Cliente buscarClientePorDni(String dni)
    {
        String sql = "SELECT * FROM Cliente WHERE Dni = ?";
        try (Connection conn = Conexion.conectar(); PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setString(1, dni);
            ResultSet rs = stmt.executeQuery();

            if (rs.next())
            {
                return new modelo.Cliente(
                        rs.getInt("Id_Cliente"),
                        rs.getString("Dni"),
                        rs.getString("Nombres"),
                        rs.getString("Direccion"),
                        rs.getBoolean("Estado")
                );
            }
        } catch (SQLException e)
        {
            System.err.println("Error al buscar el cliente: " + e.getMessage());
        }
        return null;
    }

    public static boolean agregarCliente(Cliente cliente)
    {
        if (existeClienteConDni(cliente.getDni()))
        {
            System.err.println("El DNI ya existe en la base de datos.");
            return false;
        }

        String sql = "INSERT INTO Cliente (Dni, Nombres, Direccion, Estado) VALUES (?, ?, ?, ?)";
        try (Connection conn = Conexion.conectar(); PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setString(1, cliente.getDni());
            stmt.setString(2, cliente.getNombres());
            stmt.setString(3, cliente.getDireccion());
            stmt.setBoolean(4, cliente.isEstado());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e)
        {
            System.err.println("Error al agregar cliente: " + e.getMessage());
            return false;
        }
    }

    private static boolean existeClienteConDni(String dni)
    {
        String sql = "SELECT COUNT(*) FROM Cliente WHERE Dni = ?";
        try (Connection conn = Conexion.conectar(); PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setString(1, dni);
            ResultSet rs = stmt.executeQuery();
            if (rs.next())
            {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e)
        {
            System.err.println("Error al verificar DNI: " + e.getMessage());
        }
        return false;
    }

    public static boolean actualizarCliente(Cliente cliente)
    {
        String sql = "UPDATE Cliente SET Dni = ?, Nombres = ?, Direccion = ?, Estado = ? WHERE Id_Cliente = ?";

        try (Connection conn = Conexion.conectar(); PreparedStatement stmt = conn.prepareStatement(sql))
        {

            stmt.setString(1, cliente.getDni());
            stmt.setString(2, cliente.getNombres());
            stmt.setString(3, cliente.getDireccion());
            stmt.setBoolean(4, cliente.isEstado());
            stmt.setInt(5, cliente.getIdCliente());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e)
        {
            System.err.println("Error al actualizar cliente: " + e.getMessage());
            return false;
        }
    }

    public static boolean eliminarCliente(int idCliente)
    {
        String sql = "DELETE FROM Cliente WHERE Id_Cliente = ?";

        try (Connection conn = Conexion.conectar(); PreparedStatement stmt = conn.prepareStatement(sql))
        {

            stmt.setInt(1, idCliente);

            return stmt.executeUpdate() > 0;

        } catch (SQLException e)
        {
            System.err.println("Error al eliminar cliente: " + e.getMessage());
            return false;
        }
    }
}
