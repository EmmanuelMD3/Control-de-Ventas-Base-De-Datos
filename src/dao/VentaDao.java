package dao;

import conexion.Conexion;
import modelo.Venta;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VentaDao
{

    public List<Venta> listarVentas()
    {
        List<Venta> ventas = new ArrayList<>();
        String sql = "SELECT * FROM Ventas";

        try (Connection conn = Conexion.conectar(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql))
        {

            while (rs.next())
            {
                Venta venta = new Venta(
                        rs.getInt("Id_Ventas"),
                        rs.getInt("Id_Cliente"),
                        rs.getInt("Id_Vendedor"),
                        rs.getString("Numero_Ventas"),
                        rs.getDate("Fecha_Ventas"),
                        rs.getDouble("Monto"),
                        rs.getBoolean("Estado")
                );
                ventas.add(venta);
            }

        } catch (SQLException e)
        {
            System.err.println("Error al listar las ventas: " + e.getMessage());
        }
        return ventas;
    }

    public static int agregarVenta(Venta venta)
    {
        String sql = "INSERT INTO Ventas (Id_Cliente, Id_Vendedor, Numero_Ventas, Fecha_Ventas, Monto, Estado) "
                + "VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
        {

            pstmt.setInt(1, venta.getIdCliente());
            pstmt.setInt(2, venta.getIdVendedor());
            pstmt.setString(3, venta.getNumeroVenta());
            pstmt.setDate(4, new java.sql.Date(venta.getFechaVenta().getTime()));
            pstmt.setDouble(5, venta.getMonto());
            pstmt.setBoolean(6, venta.isEstado());

            pstmt.executeUpdate();

            ResultSet generatedKeys = pstmt.getGeneratedKeys();
            if (generatedKeys.next())
            {
                return generatedKeys.getInt(1); 
            }
        } catch (SQLException e)
        {
            System.err.println("Error al agregar la venta: " + e.getMessage());
        }
        return -1; 
    }

    public boolean actualizarVenta(Venta venta)
    {
        String sql = "UPDATE Ventas SET Id_Cliente = ?, Id_Vendedor = ?, Numero_Ventas = ?, "
                + "Fecha_Ventas = ?, Monto = ?, Estado = ? WHERE Id_Ventas = ?";

        try (Connection conn = Conexion.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql))
        {

            pstmt.setInt(1, venta.getIdCliente());
            pstmt.setInt(2, venta.getIdVendedor());
            pstmt.setString(3, venta.getNumeroVenta());
            pstmt.setDate(4, new java.sql.Date(venta.getFechaVenta().getTime()));
            pstmt.setDouble(5, venta.getMonto());
            pstmt.setBoolean(6, venta.isEstado());
            pstmt.setInt(7, venta.getIdVenta());

            pstmt.executeUpdate();
            return true;
        } catch (SQLException e)
        {
            System.err.println("Error al actualizar la venta: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarVenta(int idVenta)
    {
        String sql = "DELETE FROM Ventas WHERE Id_Ventas = ?";

        try (Connection conn = Conexion.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql))
        {

            pstmt.setInt(1, idVenta);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e)
        {
            System.err.println("Error al eliminar la venta: " + e.getMessage());
            return false;
        }
    }
}
