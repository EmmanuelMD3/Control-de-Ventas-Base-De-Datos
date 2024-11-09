package dao;

import conexion.Conexion;
import modelo.Producto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoDao
{

    public static List<Producto> listarProductos()
    {
        List<Producto> productos = new ArrayList<>();
        String sql = "SELECT * FROM Producto";

        try (Connection conn = Conexion.conectar(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql))
        {

            while (rs.next())
            {
                Producto producto = new Producto(
                        rs.getInt("Id_Producto"),
                        rs.getString("Nombre"),
                        rs.getDouble("Precio"),
                        rs.getInt("Stock"),
                        rs.getBoolean("Estado")
                );
                productos.add(producto);
            }

        } catch (SQLException e)
        {
            System.err.println("Error al listar los productos: " + e.getMessage());
        }
        return productos;
    }

    public static List<Producto> listarProductosConStockEntre20y40()
    {
        List<Producto> productos = new ArrayList<>();
        String sql = "SELECT Id_Producto, Nombre, Precio, Stock, Estado FROM Producto WHERE Stock BETWEEN 20 AND 40";

        try (Connection conn = Conexion.conectar(); PreparedStatement stmt = conn.prepareStatement(sql))
        {
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                Producto producto = new Producto(
                        rs.getInt("Id_Producto"),
                        rs.getString("Nombre"),
                        rs.getDouble("Precio"),
                        rs.getInt("Stock"),
                        rs.getBoolean("Estado")
                );
                productos.add(producto);
            }
        } catch (SQLException e)
        {
            System.err.println("Error al listar productos con stock entre 20 y 40: " + e.getMessage());
        }
        return productos;
    }

    public static List<Producto> listarProductosConStockMayorA20()
    {
        List<Producto> productos = new ArrayList<>();
        String sql = "SELECT Id_Producto, Nombre, Precio, Stock, Estado "
                + "FROM Producto "
                + "GROUP BY Id_Producto, Nombre, Precio, Stock, Estado "
                + "HAVING Stock >= 20";

        try (Connection conn = Conexion.conectar(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql))
        {
            while (rs.next())
            {
                Producto producto = new Producto(
                        rs.getInt("Id_Producto"),
                        rs.getString("Nombre"),
                        rs.getDouble("Precio"),
                        rs.getInt("Stock"),
                        rs.getBoolean("Estado")
                );
                productos.add(producto);
            }
        } catch (SQLException e)
        {
            System.err.println("Error al listar productos con stock mayor a 20: " + e.getMessage());
        }
        return productos;
    }

    public static double obtenerDesviacionEstandarPrecioProductos()
    {
        double desviacionEstandar = 0.0;
        String sql = "SELECT STDDEV_SAMP(Precio) AS DesviacionEstandarPrecio FROM Producto";

        try (Connection conn = Conexion.conectar(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql))
        {
            if (rs.next())
            {
                desviacionEstandar = rs.getDouble("DesviacionEstandarPrecio");
            }
        } catch (SQLException e)
        {
            System.err.println("Error al obtener la desviación estándar de precios de productos: " + e.getMessage());
        }
        return desviacionEstandar;
    }

    public static double obtenerPromedioPrecioProductos()
    {
        double promedioPrecio = 0.0;
        String sql = "SELECT AVG(Precio) AS PromedioPrecio FROM Producto";

        try (Connection conn = Conexion.conectar(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql))
        {
            if (rs.next())
            {
                promedioPrecio = rs.getDouble("PromedioPrecio");
            }
        } catch (SQLException e)
        {
            System.err.println("Error al obtener el promedio de precios de productos: " + e.getMessage());
        }
        return promedioPrecio;
    }

    public static Producto obtenerProductoConPrecioMinimo()
    {
        String sql = "SELECT Id_Producto, Nombre, Precio, Stock, Estado FROM Producto WHERE Precio = (SELECT MIN(Precio) FROM Producto)";
        Producto productoMinimo = null;

        try (Connection conn = Conexion.conectar(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql))
        {
            if (rs.next())
            {
                productoMinimo = new Producto(
                        rs.getInt("Id_Producto"),
                        rs.getString("Nombre"),
                        rs.getDouble("Precio"),
                        rs.getInt("Stock"),
                        rs.getBoolean("Estado")
                );
            }
        } catch (SQLException e)
        {
            System.err.println("Error al obtener el producto con precio mínimo: " + e.getMessage());
        }
        return productoMinimo;
    }

    public static List<Producto> listarProductosConPrecioMayorQueTodos(double precioLimite)
    {
        List<Producto> productos = new ArrayList<>();
        String sql = "SELECT Id_Producto, Nombre, Precio, Stock, Estado "
                + "FROM Producto WHERE Precio > ALL (SELECT Precio FROM Producto WHERE Precio <= ?)";

        try (Connection conn = Conexion.conectar(); PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setDouble(1, precioLimite);
            ResultSet rs = stmt.executeQuery();

            while (rs.next())
            {
                Producto producto = new Producto(
                        rs.getInt("Id_Producto"),
                        rs.getString("Nombre"),
                        rs.getDouble("Precio"),
                        rs.getInt("Stock"),
                        rs.getBoolean("Estado")
                );
                productos.add(producto);
            }
        } catch (SQLException e)
        {
            System.err.println("Error al listar productos con precio mayor a " + precioLimite + ": " + e.getMessage());
        }
        return productos;
    }

    public static Producto obtenerProductoConPrecioMaximo()
    {
        String sql = "SELECT Id_Producto, Nombre, Precio, Stock, Estado FROM Producto ORDER BY Precio DESC LIMIT 1";
        Producto producto = null;

        try (Connection conn = Conexion.conectar(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql))
        {
            if (rs.next())
            {
                producto = new Producto(
                        rs.getInt("Id_Producto"),
                        rs.getString("Nombre"),
                        rs.getDouble("Precio"),
                        rs.getInt("Stock"),
                        rs.getBoolean("Estado")
                );
            }
        } catch (SQLException e)
        {
            System.err.println("Error al obtener el producto con el precio máximo: " + e.getMessage());
        }
        return producto;
    }

    public static List<Producto> listarProductosOrdenadosPorPrecio()
    {
        List<Producto> productos = new ArrayList<>();
        String sql = "SELECT Id_Producto, Nombre, Precio, Stock, Estado FROM Producto ORDER BY Precio DESC";

        try (Connection conn = Conexion.conectar(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql))
        {
            while (rs.next())
            {
                Producto producto = new Producto(
                        rs.getInt("Id_Producto"),
                        rs.getString("Nombre"),
                        rs.getDouble("Precio"),
                        rs.getInt("Stock"),
                        rs.getBoolean("Estado")
                );
                productos.add(producto);
            }
        } catch (SQLException e)
        {
            System.err.println("Error al listar productos ordenados por precio: " + e.getMessage());
        }
        return productos;
    }

    public static List<Producto> listarProductosPorFiltros(boolean filtroId, boolean filtroNombre, boolean filtroPrecio, boolean filtroStock, boolean filtroEstado, Boolean estado)
    {
        List<Producto> productos = new ArrayList<>();

        StringBuilder sql = new StringBuilder("SELECT ");
        boolean hasFilters = false;

        if (filtroId)
        {
            sql.append("Id_Producto, ");
            hasFilters = true;
        }
        if (filtroNombre)
        {
            sql.append("Nombre, ");
            hasFilters = true;
        }
        if (filtroPrecio)
        {
            sql.append("Precio, ");
            hasFilters = true;
        }
        if (filtroStock)
        {
            sql.append("Stock, ");
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

        sql.append(" FROM Producto");

        if (estado != null)
        {
            sql.append(" WHERE Estado = ").append(estado);
        }

        try (Connection conn = Conexion.conectar(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql.toString()))
        {
            while (rs.next())
            {
                Producto producto = new Producto();

                if (filtroId)
                {
                    producto.setIdProducto(rs.getInt("Id_Producto"));
                }
                if (filtroNombre)
                {
                    producto.setNombre(rs.getString("Nombre"));
                }
                if (filtroPrecio)
                {
                    producto.setPrecio(rs.getDouble("Precio"));
                }
                if (filtroStock)
                {
                    producto.setStock(rs.getInt("Stock"));
                }
                if (filtroEstado)
                {
                    producto.setEstado(rs.getBoolean("Estado"));
                }
                productos.add(producto);
            }
        } catch (SQLException e)
        {
            System.err.println("Error al listar productos con filtros: " + e.getMessage());
        }
        return productos;
    }

    public static boolean actualizarStockEnBaseDeDatos(int idProducto, int nuevoStock)
    {
        String sql = "UPDATE Producto SET Stock = ? WHERE Id_Producto = ?";
        try (Connection conn = Conexion.conectar(); PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setInt(1, nuevoStock);
            stmt.setInt(2, idProducto);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e)
        {
            System.err.println("Error al actualizar el stock: " + e.getMessage());
            return false;
        }
    }

    public static modelo.Producto buscarProductoPorId(int idProducto)
    {
        String sql = "SELECT * FROM Producto WHERE Id_Producto = ?";
        try (Connection conn = Conexion.conectar(); PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setInt(1, idProducto);
            ResultSet rs = stmt.executeQuery();

            if (rs.next())
            {
                return new modelo.Producto(
                        rs.getInt("Id_Producto"), // ID del producto
                        rs.getString("Nombre"),
                        rs.getDouble("Precio"),
                        rs.getInt("Stock"),
                        rs.getBoolean("Estado")
                );
            }
        } catch (SQLException e)
        {
            System.err.println("Error al buscar el producto: " + e.getMessage());
        }
        return null;
    }

    public static boolean agregarProducto(Producto producto)
    {
        String sql = "INSERT INTO Producto (Nombre, Precio, Stock, Estado) VALUES (?, ?, ?, ?)";

        try (Connection conn = Conexion.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql))
        {

            pstmt.setString(1, producto.getNombre());
            pstmt.setDouble(2, producto.getPrecio());
            pstmt.setInt(3, producto.getStock());
            pstmt.setBoolean(4, producto.isEstado());

            pstmt.executeUpdate();
            System.out.println("Producto Agregado Con Exito");
            return true;
        } catch (SQLException e)
        {
            System.err.println("Error al agregar el producto: " + e.getMessage());
            return false;
        }
    }

    public static boolean actualizarProducto(Producto producto)
    {
        String sql = "UPDATE Producto SET Nombre = ?, Precio = ?, Stock = ?, Estado = ? WHERE Id_Producto = ?";

        try (Connection conn = Conexion.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql))
        {

            pstmt.setString(1, producto.getNombre());
            pstmt.setDouble(2, producto.getPrecio());
            pstmt.setInt(3, producto.getStock());
            pstmt.setBoolean(4, producto.isEstado());
            pstmt.setInt(5, producto.getIdProducto());

            pstmt.executeUpdate();
            return true;
        } catch (SQLException e)
        {
            System.err.println("Error al actualizar el producto: " + e.getMessage());
            return false;
        }
    }

    public static boolean eliminarProducto(int idProducto)
    {
        String sql = "DELETE FROM Producto WHERE Id_Producto = ?";

        try (Connection conn = Conexion.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql))
        {

            pstmt.setInt(1, idProducto);
            pstmt.executeUpdate();
            System.out.println("Producto Eliminado con Exito");
            return true;
        } catch (SQLException e)
        {
            System.err.println("Error al eliminar el producto: " + e.getMessage());
            return false;
        }
    }
}
