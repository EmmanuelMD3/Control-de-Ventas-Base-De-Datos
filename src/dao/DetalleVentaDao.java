package dao;

import conexion.Conexion;
import modelo.Detalle_Venta;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DetalleVentaDao
{

    public static List<Detalle_Venta> listarDetalleVentas()
    {
        List<Detalle_Venta> detallesVenta = new ArrayList<>();
        String sql = "SELECT * FROM Detalle_Venta";

        try (Connection conn = Conexion.conectar(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql))
        {

            while (rs.next())
            {
                Detalle_Venta detalle = new Detalle_Venta(
                        rs.getInt("Id_Detalle_Venta"),
                        rs.getInt("Id_Ventas"),
                        rs.getInt("Id_Producto"),
                        rs.getInt("Cantidad"),
                        rs.getDouble("Precio")
                );
                detallesVenta.add(detalle);
            }
        } catch (SQLException e)
        {
            System.err.println("Error al listar los detalles de venta: " + e.getMessage());
        }
        return detallesVenta;
    }

    public static double calcularSumaPrecio()
    {
        double totalPrecio = 0.0;
        String sql = "SELECT SUM(Precio) AS TotalPrecio FROM Detalle_Venta";

        try (Connection conn = Conexion.conectar(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql))
        {
            if (rs.next())
            {
                totalPrecio = rs.getDouble("TotalPrecio");
            }
        } catch (SQLException e)
        {
            System.err.println("Error al calcular la suma de precios: " + e.getMessage());
        }
        return totalPrecio;
    }

    public static boolean agregarDetalleVenta(Detalle_Venta detalleVenta)
    {
        String sql = "INSERT INTO Detalle_Venta (Id_Ventas, Id_Producto, Cantidad, Precio) VALUES (?, ?, ?, ?)";
        try (Connection conn = Conexion.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql))
        {

            pstmt.setInt(1, detalleVenta.getIdVentas());
            pstmt.setInt(2, detalleVenta.getIdProducto());
            pstmt.setInt(3, detalleVenta.getCantidad());
            pstmt.setDouble(4, detalleVenta.getPrecio());

            return pstmt.executeUpdate() > 0;
        } catch (SQLException e)
        {
            System.err.println("Error al agregar el detalle de venta: " + e.getMessage());
            return false;
        }
    }

    public static List<Detalle_Venta> listarTop5ProductosMasVendidos()
    {
        List<Detalle_Venta> detallesVenta = new ArrayList<>();
        String sql = "SELECT TOP 5 Id_Producto, SUM(Cantidad) AS Total_Vendido "
                + "FROM Detalle_Venta "
                + "GROUP BY Id_Producto "
                + "ORDER BY Total_Vendido DESC";

        try (Connection conn = Conexion.conectar(); PreparedStatement stmt = conn.prepareStatement(sql))
        {
            ResultSet rs = stmt.executeQuery();

            while (rs.next())
            {
                Detalle_Venta detalle = new Detalle_Venta();
                detalle.setIdProducto(rs.getInt("Id_Producto"));
                detalle.setCantidad(rs.getInt("Total_Vendido")); // Total de cantidad vendida para ese producto
                detallesVenta.add(detalle);
            }
        } catch (SQLException e)
        {
            System.err.println("Error al listar los 5 productos más vendidos: " + e.getMessage());
        }
        return detallesVenta;
    }

}
