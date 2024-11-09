package dao;

import modelo.Cliente;
import modelo.Producto;
import modelo.Detalle_Venta;
import modelo.Vendedor;
import modelo.Venta;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import poo_lecturas.Lecturas;

public class Principal
{

    public static void main(String[] args)
    {
        ClienteDao clienteDao = new ClienteDao();
        ProductoDao productoDao = new ProductoDao();
        DetalleVentaDao detalleVentaDao = new DetalleVentaDao();
        VendedorDao vendedorDao = new VendedorDao();
        VentaDao ventaDao = new VentaDao();

        System.out.println("=== SISTEMA DE GESTIÓN DE VENTAS ===");

        String menu[] =
        {
            "*SELECCIONE UNA OPCCION*", "1. Clientes", "2. Productos", "3. Ventas", "4. Vendedores", "5. Detalles Venta", "6. Salir"
        };
        int opcPrincipal;

        String subMenuClientes[] =
        {
            "***MENU CLIENTES***", "1. Agregar Clientes", "2. Eliminar Clientes", "3. Mostrar Clientes", "4. Modificar Clientes", "5. Salir"
        };
        int opcSubMenuClientes;

        String subMenuProducto[] =
        {
            "***MENU PRODUCTO***", "1. Agregar Producto", "2. Eliminar Producto", "3. Modificar Producto", "4. Mostrar Prodcutos", "5. Salir"
        };
        int opcSubMenuProducto;

        String subMenuVendedor[] =
        {
            "***MENU VENDEDOR***", "1. Agregar Vendedor", "2. Eliminar Vendedor", "3. Modificar Vendedor", "4. Mostrar Vendedor", "5. Salir"
        };
        int opcSubMenuVendedor;

        String subMenuDetalleVenta[] =
        {
            "***MENU DETALLE VENTA***", "1. Mostrar Detalle venta", "2. Salir"
        };
        int opcSubMenuDetalleVenta;

        String subMenuVenta[] =
        {
            "***MENU VENTA***", "1. Mostrar Venta", "2. Salir"
        };
        int opcSubMenuVenta;

        boolean salir = false;

        do
        {
            for (int i = 0; i < menu.length; i++)
            {
                System.out.println(menu[i]);
            }
            opcPrincipal = Lecturas.LeerEntero();

            switch (opcPrincipal)
            {
                case 1:
                    do
                    {
                        for (int i = 0; i < subMenuClientes.length; i++)
                        {
                            System.out.println(subMenuClientes[i]);
                        }
                        opcSubMenuClientes = Lecturas.LeerEntero();

                        switch (opcSubMenuClientes)
                        {
                            case 1:
                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                            case 4:
                                break;
                            case 5:
                                System.out.println("Saliendo...");
                                break;
                            default:
                                System.out.println("Opccion Incorrecta...");
                        }
                    } while (opcSubMenuClientes != 5);
                    break;
                case 2:
                    do
                    {
                        for (int i = 0; i < subMenuProducto.length; i++)
                        {
                            System.out.println(subMenuProducto[i]);
                        }
                        opcSubMenuProducto = Lecturas.LeerEntero();
                        switch (opcSubMenuProducto)
                        {
                            case 1:
                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                            case 4:
                                break;
                            case 5:
                                System.out.println("Saliendo...");
                                break;
                            default:
                                System.out.println("Opccion Incorrecta...");
                        }
                    } while (opcSubMenuProducto != 5);
                    break;
                case 3:
                    do
                    {
                        for (int i = 0; i < subMenuVenta.length; i++)
                        {
                            System.out.println(subMenuVenta[i]);
                        }
                        opcSubMenuVenta = Lecturas.LeerEntero();

                        switch (opcSubMenuVenta)
                        {
                            case 1:
                                break;
                            case 2:
                                System.out.println("Saliendo...");
                                break;
                            default:
                                System.out.println("Opccion Incorrecta");
                        }
                    } while (opcSubMenuVenta != 2);
                    break;
                case 4:
                    do
                    {
                        for (int i = 0; i < subMenuVendedor.length; i++)
                        {
                            System.out.println(subMenuVendedor[i]);
                        }
                        opcSubMenuVendedor = Lecturas.LeerEntero();

                        switch (opcSubMenuVendedor)
                        {
                            case 1:
                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                            case 4:
                                break;
                            case 5:
                                System.out.println("Saliendo...");
                                break;
                            default:
                                System.out.println("Opccion Incorrecta");
                        }
                    } while (opcSubMenuVendedor != 5);
                    break;
                case 5:
                    do
                    {
                        for (int i = 0; i < subMenuVendedor.length; i++)
                        {
                            System.out.println(subMenuVendedor[i]);
                        }
                        opcSubMenuVendedor = Lecturas.LeerEntero();

                        switch (opcSubMenuVendedor)
                        {
                            case 1:
                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                            case 4:
                                break;
                            case 5:
                                break;
                            default:
                                System.out.println("Opccion Incorrecta");
                        }
                    } while (opcSubMenuVendedor != 5);
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcPrincipal != 6);
    }

   

    public static Producto datos()
    {
        System.out.println("ID: ");
        int id = Lecturas.LeerEntero();
        System.out.println("Nombre: ");
        String nombre = Lecturas.LeerCadena();
        System.out.println("Precio: ");
        double precio = Lecturas.LeerDoble();
        System.out.println("Stock: ");
        int stock = Lecturas.LeerEntero();
        System.out.println("Estado: ");
        boolean estado = Lecturas.LeerBooleano();

        return new Producto(stock, nombre, precio, stock, estado);
    }

    private static void gestionarClientes(ClienteDao dao)
    {
        System.out.println("Clientes registrados:");
        List<Cliente> clientes = dao.listarClientes();
        for (Cliente c : clientes)
        {
            System.out.println(c.getIdCliente() + " - " + c.getNombres() + " (Estado: " + c.isEstado() + ")");
        }
    }

    private static void gestionarProductos(ProductoDao dao)
    {
        System.out.println("Productos disponibles:");
        List<Producto> productos = dao.listarProductos();
        for (Producto p : productos)
        {
            System.out.println(p.getIdProducto() + " - " + p.getNombre() + " (Stock: " + p.getStock() + ")");
        }
    }

    private static void gestionarVentas(VentaDao dao)
    {
        System.out.println("Ventas registradas:");
        List<Venta> ventas = dao.listarVentas();
        for (Venta v : ventas)
        {
            System.out.println(v.getIdVenta() + " - " + v.getNumeroVenta() + " (Monto: $" + v.getMonto() + ")");
        }
    }

    private static void gestionarVendedores(VendedorDao dao)
    {
        System.out.println("Vendedores registrados:");
        List<Vendedor> vendedores = dao.listarVendedores();
        for (Vendedor v : vendedores)
        {
            System.out.println(v.getIdVendedor() + " - " + v.getNombre() + " (Tel: " + v.getTelefono() + ")");
        }
    }

    private static void gestionarDetallesVenta(DetalleVentaDao dao)
    {
        System.out.println("Detalles de ventas:");
        List<Detalle_Venta> detalles = dao.listarDetalleVentas();
        for (Detalle_Venta dv : detalles)
        {
            System.out.println("Venta ID: " + dv.getIdVentas() + " - Producto ID: " + dv.getIdProducto()
                    + " (Cantidad: " + dv.getCantidad() + ")");
        }
    }
}
