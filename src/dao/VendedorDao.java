package dao;

import conexion.Conexion;
import modelo.Vendedor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VendedorDao
{

    public static List<Vendedor> listarVendedores()
    {
        List<Vendedor> vendedores = new ArrayList<>();
        String sql = "SELECT * FROM Vendedor";

        try (Connection conn = Conexion.conectar(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql))
        {

            while (rs.next())
            {
                Vendedor vendedor = new Vendedor(
                        rs.getInt("Id_Vendedor"),
                        rs.getString("Dni"),
                        rs.getString("Nombre"),
                        rs.getString("Telefono"),
                        rs.getBoolean("Estado")
                );
                vendedores.add(vendedor);
            }

        } catch (SQLException e)
        {
            System.err.println("Error al listar los vendedores: " + e.getMessage());
        }
        return vendedores;
    }

    public static List<Vendedor> listarVendedoresInactivos()
    {
        List<Vendedor> vendedores = new ArrayList<>();
        String sql = "SELECT Id_Vendedor, Dni, Nombre, Telefono, Estado FROM Vendedor WHERE Estado = 0";

        try (Connection conn = Conexion.conectar(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql))
        {
            while (rs.next())
            {
                Vendedor vendedor = new Vendedor(
                        rs.getInt("Id_Vendedor"),
                        rs.getString("Dni"),
                        rs.getString("Nombre"),
                        rs.getString("Telefono"),
                        rs.getBoolean("Estado")
                );
                vendedores.add(vendedor);
            }
        } catch (SQLException e)
        {
            System.err.println("Error al listar vendedores inactivos: " + e.getMessage());
        }
        return vendedores;
    }

    public static List<Vendedor> listarVendedoresActivos()
    {
        List<Vendedor> vendedores = new ArrayList<>();
        String sql = "SELECT Id_Vendedor, Dni, Nombre, Telefono, Estado FROM Vendedor WHERE Estado = 1";

        try (Connection conn = Conexion.conectar(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql))
        {
            while (rs.next())
            {
                Vendedor vendedor = new Vendedor(
                        rs.getInt("Id_Vendedor"),
                        rs.getString("Dni"),
                        rs.getString("Nombre"),
                        rs.getString("Telefono"),
                        rs.getBoolean("Estado")
                );
                vendedores.add(vendedor);
            }
        } catch (SQLException e)
        {
            System.err.println("Error al listar vendedores activos: " + e.getMessage());
        }
        return vendedores;
    }

    public static List<Vendedor> listarVendedoresPorFiltros(boolean filtroId, boolean filtroDni, boolean filtroNombre, boolean filtroTelefono, boolean filtroEstado, Boolean estado)
    {
        List<Vendedor> vendedores = new ArrayList<>();

        StringBuilder sql = new StringBuilder("SELECT ");
        boolean hasFilters = false;

        if (filtroId)
        {
            sql.append("Id_Vendedor, ");
            hasFilters = true;
        }
        if (filtroDni)
        {
            sql.append("Dni, ");
            hasFilters = true;
        }
        if (filtroNombre)
        {
            sql.append("Nombre, ");
            hasFilters = true;
        }
        if (filtroTelefono)
        {
            sql.append("Telefono, ");
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

        sql.append(" FROM Vendedor");

        if (estado != null)
        {
            sql.append(" WHERE Estado = ").append(estado);
        }

        try (Connection conn = Conexion.conectar(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql.toString()))
        {
            while (rs.next())
            {
                Vendedor vendedor = new Vendedor();

                if (filtroId)
                {
                    vendedor.setIdVendedor(rs.getInt("Id_Vendedor"));
                }
                if (filtroDni)
                {
                    vendedor.setDni(rs.getString("Dni"));
                }
                if (filtroNombre)
                {
                    vendedor.setNombre(rs.getString("Nombre"));
                }
                if (filtroTelefono)
                {
                    vendedor.setTelefono(rs.getString("Telefono"));
                }
                if (filtroEstado)
                {
                    vendedor.setEstado(rs.getBoolean("Estado"));
                }
                vendedores.add(vendedor);
            }
        } catch (SQLException e)
        {
            System.err.println("Error al listar vendedores con filtros: " + e.getMessage());
        }
        return vendedores;
    }

    public static int obtenerIdVendedorPorDni(String dni)
    {
        String sql = "SELECT Id_Vendedor FROM Vendedor WHERE Dni = ?";
        try (Connection conn = Conexion.conectar(); PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setString(1, dni);
            ResultSet rs = stmt.executeQuery();

            if (rs.next())
            {
                return rs.getInt("Id_Vendedor");
            }
        } catch (SQLException e)
        {
            System.err.println("Error al obtener el ID del vendedor: " + e.getMessage());
        }
        return -1;
    }

    public static boolean agregarVendedor(Vendedor vendedor)
    {
        String sql = "INSERT INTO Vendedor (Dni, Nombre, Telefono, Estado) VALUES (?, ?, ?, ?)";

        try (Connection conn = Conexion.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql))
        {

            pstmt.setString(1, vendedor.getDni());
            pstmt.setString(2, vendedor.getNombre());
            pstmt.setString(3, vendedor.getTelefono());
            pstmt.setBoolean(4, vendedor.isEstado());

            pstmt.executeUpdate();
            return true;
        } catch (SQLException e)
        {
            System.err.println("Error al agregar el vendedor: " + e.getMessage());
            return false;
        }
    }

    public static boolean actualizarVendedor(Vendedor vendedor)
    {
        String sql = "UPDATE Vendedor SET Dni = ?, Nombre = ?, Telefono = ?, Estado = ? WHERE Id_Vendedor = ?";

        try (Connection conn = Conexion.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql))
        {

            pstmt.setString(1, vendedor.getDni());
            pstmt.setString(2, vendedor.getNombre());
            pstmt.setString(3, vendedor.getTelefono());
            pstmt.setBoolean(4, vendedor.isEstado());
            pstmt.setInt(5, vendedor.getIdVendedor());

            pstmt.executeUpdate();
            return true;
        } catch (SQLException e)
        {
            System.err.println("Error al actualizar el vendedor: " + e.getMessage());
            return false;
        }
    }

    public static boolean eliminarVendedor(int idVendedor)
    {
        String sql = "DELETE FROM Vendedor WHERE Id_Vendedor = ?";

        try (Connection conn = Conexion.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setInt(1, idVendedor);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e)
        {
            System.err.println("Error al eliminar el vendedor: " + e.getMessage());
            return false;
        }
    }
}
