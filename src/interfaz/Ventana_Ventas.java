/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaz;

import dao.ClienteDao;
import dao.DetalleVentaDao;
import dao.ProductoDao;
import static dao.ProductoDao.actualizarStockEnBaseDeDatos;
import dao.VendedorDao;
import dao.VentaDao;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import modelo.Detalle_Venta;
import modelo.Venta;

/**
 *
 * @author chemo
 */
public class Ventana_Ventas extends javax.swing.JFrame
{
    String numeroVenta = "NV" + System.currentTimeMillis();
    /**
     * Creates new form Ventana_Ventas
     */
    public Ventana_Ventas()
    {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        numSerie = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        codCliente = new javax.swing.JTextField();
        codProducto = new javax.swing.JTextField();
        precio = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        muestraCliente = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        muestraProducto = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        muestraStock = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        cancelar = new javax.swing.JButton();
        geneVenta = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        pagar = new javax.swing.JTextArea();
        cantidadProducto = new javax.swing.JSpinner();
        jLabel12 = new javax.swing.JLabel();
        codVendedor = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(500, 600));
        setPreferredSize(new java.awt.Dimension(540, 700));
        addWindowListener(new java.awt.event.WindowAdapter()
        {
            public void windowOpened(java.awt.event.WindowEvent evt)
            {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setMinimumSize(new java.awt.Dimension(530, 650));
        jPanel1.setPreferredSize(new java.awt.Dimension(520, 700));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Tienda de Abarrotes");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, -1, -1));

        jLabel7.setText("PRECIO:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel2.setText("TIENDITA");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, -1, -1));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        numSerie.setEditable(false);
        numSerie.setColumns(20);
        numSerie.setRows(5);
        jScrollPane1.setViewportView(numSerie);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 90, 130, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/almacenar.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Numero de Serie:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, -1, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 540, 10));

        jLabel5.setText("COD. CLIENTE:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        jLabel6.setText("COD. PRODUCTO:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

        jLabel8.setText("CANTIDAD:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, -1, -1));

        codCliente.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                codClienteActionPerformed(evt);
            }
        });
        jPanel1.add(codCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 90, -1));

        codProducto.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jPanel1.add(codProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, 90, -1));

        precio.setEditable(false);
        precio.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                precioActionPerformed(evt);
            }
        });
        jPanel1.add(precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, 90, -1));

        jButton2.setText("BUSCAR");
        jButton2.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 210, 80, -1));

        jButton3.setText("AGREGAR");
        jButton3.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 250, 80, -1));

        jLabel9.setText("CLIENTE:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 170, -1, -1));

        jLabel10.setText("PRODUCTO:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 210, -1, -1));

        jButton1.setText("BUSCAR");
        jButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 170, 80, -1));

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        muestraCliente.setEditable(false);
        muestraCliente.setColumns(20);
        muestraCliente.setRows(5);
        jScrollPane2.setViewportView(muestraCliente);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 170, 130, 30));

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        muestraProducto.setEditable(false);
        muestraProducto.setColumns(20);
        muestraProducto.setRows(5);
        jScrollPane3.setViewportView(muestraProducto);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 210, 130, 30));

        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane4.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        muestraStock.setEditable(false);
        muestraStock.setColumns(20);
        muestraStock.setRows(5);
        jScrollPane4.setViewportView(muestraStock);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 250, 130, 30));

        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {
                "No.", "CODIGO", "PRODUCTO", "CATIDAD", "PRE. UNITARIO", "TOTAL"
            }
        )
        {
            boolean[] canEdit = new boolean []
            {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex)
            {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(tablaProductos);

        jPanel1.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 520, 260));

        jLabel11.setText("STOCK:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 250, -1, -1));

        cancelar.setText("CANCELAR");
        cancelar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                cancelarActionPerformed(evt);
            }
        });
        jPanel1.add(cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 610, -1, -1));

        geneVenta.setText("GENERAR VENTA");
        geneVenta.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                geneVentaActionPerformed(evt);
            }
        });
        jPanel1.add(geneVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 610, -1, -1));

        jLabel13.setText("TOTAL A PAGAR:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 600, -1, 20));

        jScrollPane6.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane6.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        pagar.setColumns(20);
        pagar.setRows(5);
        jScrollPane6.setViewportView(pagar);

        jPanel1.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 620, 130, 30));

        cantidadProducto.setModel(new javax.swing.SpinnerNumberModel(1, 1, 100, 1));
        jPanel1.add(cantidadProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 290, 90, -1));

        jLabel12.setText("COD. VENDEDOR:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 290, -1, -1));
        jPanel1.add(codVendedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 290, 180, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 660));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void codClienteActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_codClienteActionPerformed
    {//GEN-HEADEREND:event_codClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codClienteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton1ActionPerformed
    {//GEN-HEADEREND:event_jButton1ActionPerformed
        buscarCliente();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void precioActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_precioActionPerformed
    {//GEN-HEADEREND:event_precioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_precioActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton2ActionPerformed
    {//GEN-HEADEREND:event_jButton2ActionPerformed
        buscarProducto();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_cancelarActionPerformed
    {//GEN-HEADEREND:event_cancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelarActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton3ActionPerformed
    {//GEN-HEADEREND:event_jButton3ActionPerformed
        agregarProductoATabla();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void geneVentaActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_geneVentaActionPerformed
    {//GEN-HEADEREND:event_geneVentaActionPerformed
        generarVenta();
    }//GEN-LAST:event_geneVentaActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt)//GEN-FIRST:event_formWindowOpened
    {//GEN-HEADEREND:event_formWindowOpened
        numSerie.setText(numeroVenta);
    }//GEN-LAST:event_formWindowOpened

    private void generarVenta()
    {
        String dniCliente = codCliente.getText().trim();
        String dniVendedor = codVendedor.getText().trim();

        int idCliente = ClienteDao.obtenerIdClientePorDni(dniCliente);
        int idVendedor = VendedorDao.obtenerIdVendedorPorDni(dniVendedor);

        if (idCliente == -1)
        {
            javax.swing.JOptionPane.showMessageDialog(this, "Cliente no encontrado.");
            return;
        }
        if (idVendedor == -1)
        {
            javax.swing.JOptionPane.showMessageDialog(this, "Vendedor no encontrado.");
            return;
        }

        
        
        
        Date fechaVenta = new Date();
        double monto = Double.parseDouble(pagar.getText());
        boolean estado = true;

        Venta nuevaVenta = new Venta(0, idCliente, idVendedor, numeroVenta, fechaVenta, monto, estado);

        int idVenta = VentaDao.agregarVenta(nuevaVenta);
        if (idVenta == -1)
        {
            javax.swing.JOptionPane.showMessageDialog(this, "Error al generar la venta.");
            return;
        }

        DefaultTableModel modeloTabla = (DefaultTableModel) tablaProductos.getModel();
        for (int i = 0; i < modeloTabla.getRowCount(); i++)
        {
            int idProducto = Integer.parseInt(modeloTabla.getValueAt(i, 1).toString());
            int cantidad = Integer.parseInt(modeloTabla.getValueAt(i, 3).toString());
            double precio = Double.parseDouble(modeloTabla.getValueAt(i, 4).toString());

            Detalle_Venta detalleVenta = new Detalle_Venta(0, idVenta, idProducto, cantidad, precio);
            DetalleVentaDao.agregarDetalleVenta(detalleVenta);
        }

        javax.swing.JOptionPane.showMessageDialog(this, "Venta y detalle de venta generados exitosamente.");
    }

    private void agregarProductoATabla()
    {
        String codigoProducto = codProducto.getText();
        String nombreProducto = muestraProducto.getText();
        String precioTexto = precio.getText();
        String stockTexto = muestraStock.getText();
        int cantidad = (int) cantidadProducto.getValue();

        if (codigoProducto.isEmpty() || nombreProducto.isEmpty() || precioTexto.isEmpty() || stockTexto.isEmpty() || cantidad <= 0)
        {
            javax.swing.JOptionPane.showMessageDialog(this, "Por favor, selecciona un producto válido y una cantidad mayor a 0.");
            return;
        }

        double precioUnitario = Double.parseDouble(precioTexto);
        int stockDisponible = Integer.parseInt(stockTexto);

        if (cantidad > stockDisponible)
        {
            javax.swing.JOptionPane.showMessageDialog(this, "La cantidad seleccionada excede el stock disponible.");
            return;
        }

        double subtotal = precioUnitario * cantidad;

        int nuevoStock = stockDisponible - cantidad;
        muestraStock.setText(String.valueOf(nuevoStock));

        actualizarStockEnBaseDeDatos(Integer.parseInt(codigoProducto), nuevoStock);

        DefaultTableModel modeloTabla = (DefaultTableModel) tablaProductos.getModel();
        modeloTabla.addRow(new Object[]
        {
            modeloTabla.getRowCount() + 1,
            codigoProducto,
            nombreProducto,
            cantidad,
            precioUnitario,
            subtotal
        });

        actualizarTotalAPagar();
    }

    private void actualizarTotalAPagar()
    {
        DefaultTableModel modeloTabla = (DefaultTableModel) tablaProductos.getModel();
        double totalAPagar = 0.0;

        for (int i = 0; i < modeloTabla.getRowCount(); i++)
        {
            double subtotal = (double) modeloTabla.getValueAt(i, 5);
            totalAPagar += subtotal;
        }

        pagar.setText(String.format("%.2f", totalAPagar));
    }

    private void buscarProducto()
    {
        String idTexto = this.codProducto.getText().trim();

        if (idTexto.isEmpty())
        {
            javax.swing.JOptionPane.showMessageDialog(this, "Por favor ingresa el código de producto.");
            return;
        }

        try
        {
            int idProducto = Integer.parseInt(idTexto);

            modelo.Producto producto = ProductoDao.buscarProductoPorId(idProducto);

            if (producto != null)
            {
                this.muestraProducto.setText(producto.getNombre());
                this.precio.setText(String.valueOf(producto.getPrecio()));
                this.muestraStock.setText(String.valueOf(producto.getStock()));
            } else
            {
                javax.swing.JOptionPane.showMessageDialog(this, "Producto no encontrado.");
                this.muestraProducto.setText("");
                this.precio.setText("");
                this.muestraStock.setText("");
            }
        } catch (NumberFormatException e)
        {
            javax.swing.JOptionPane.showMessageDialog(this, "El código de producto debe ser un número.");
        }
    }

    private void buscarCliente()
    {
        String dni = this.codCliente.getText().trim();

        if (dni.isEmpty())
        {
            javax.swing.JOptionPane.showMessageDialog(this, "Por favor ingresa el DNI del cliente.");
            return;
        }

        modelo.Cliente cliente = ClienteDao.buscarClientePorDni(dni);

        if (cliente != null)
        {
            this.muestraCliente.setText(cliente.getNombres());
        } else
        {
            javax.swing.JOptionPane.showMessageDialog(this, "Cliente no encontrado.");
            this.codCliente.setText("");
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(Ventana_Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(Ventana_Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(Ventana_Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(Ventana_Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new Ventana_Ventas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelar;
    private javax.swing.JSpinner cantidadProducto;
    private javax.swing.JTextField codCliente;
    private javax.swing.JTextField codProducto;
    private javax.swing.JTextField codVendedor;
    private javax.swing.JButton geneVenta;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea muestraCliente;
    private javax.swing.JTextArea muestraProducto;
    private javax.swing.JTextArea muestraStock;
    private javax.swing.JTextArea numSerie;
    private javax.swing.JTextArea pagar;
    private javax.swing.JTextField precio;
    private javax.swing.JTable tablaProductos;
    // End of variables declaration//GEN-END:variables
}
