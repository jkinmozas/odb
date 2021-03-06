/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import javax.swing.table.DefaultTableModel;
import modelo.Articulo;
import modelo.Tienda;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

/**
 *
 * @author Joaquin
 */
public class JFVerTiendas extends javax.swing.JFrame {

    ODB odbfac;
    String filename = "C:\\Users\\Joaquin\\Documents\\NetBeansProjects\\ODB\\src\\neodatis.test";

    public void actualizarTabla() {
        odbfac = ODBFactory.open(filename);
        DefaultTableModel tmtien = new DefaultTableModel();
        while (tmtien.getRowCount() > 0) {
            tmtien.removeRow(0);
        }

        tmtien.addColumn("ID");
        tmtien.addColumn("Nombre");
        tmtien.addColumn("NIF");
        tmtien.addColumn("Direccion");
        tmtien.addColumn("Telefono");

        Object[] columnTien = new Object[5];
        Objects<Tienda> objects = odbfac.getObjects(Tienda.class);
        while (objects.hasNext()) {
            Tienda t = new Tienda();
            t = objects.next();
            columnTien[2] = t.getNif();
            columnTien[0] = t.getId();
            columnTien[1] = t.getNombre();
            columnTien[3] = t.getTelefono();
            columnTien[4] = t.getDireccion();
            tmtien.addRow(columnTien);
        }
        jTable1.setModel(tmtien);
        odbfac.close();
    }

    /**
     * Creates new form JFMenu
     */
    public JFVerTiendas() {
        initComponents();
        actualizarTabla();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButtonverArticulos = new javax.swing.JButton();
        jButtonBorrar = new javax.swing.JButton();
        jButtonModificar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItemTienda = new javax.swing.JMenuItem();
        jMenuItemArticulo = new javax.swing.JMenuItem();
        jMenuItemDatos = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButtonverArticulos.setText("Ver Articulos");
        jButtonverArticulos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonverArticulosActionPerformed(evt);
            }
        });

        jButtonBorrar.setText("Borrar");
        jButtonBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBorrarActionPerformed(evt);
            }
        });

        jButtonModificar.setText("Modificar");
        jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarActionPerformed(evt);
            }
        });

        jMenu1.setText("Añadir");

        jMenuItemTienda.setText("Tienda");
        jMenuItemTienda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemTiendaActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemTienda);

        jMenuItemArticulo.setText("Articulo");
        jMenuItemArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemArticuloActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemArticulo);

        jMenuItemDatos.setText("Datos prueba");
        jMenuItemDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemDatosActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemDatos);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jButtonModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(jButtonBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(jButtonverArticulos)
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonverArticulos)
                    .addComponent(jButtonBorrar)
                    .addComponent(jButtonModificar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemTiendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemTiendaActionPerformed
        // TODO add your handling code here:
        JDAnadirTienda jdat = new JDAnadirTienda(this, rootPaneCheckingEnabled);
        jdat.setVisible(true);
        //VISTA AÑADIR TIENDA

    }//GEN-LAST:event_jMenuItemTiendaActionPerformed

    private void jMenuItemArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemArticuloActionPerformed
//VISTA AÑADIR ARTICULO
        // TODO add your handling code here:
        JDAnadirArticulo jdaa = new JDAnadirArticulo(this, rootPaneCheckingEnabled);
        jdaa.setVisible(true);
    }//GEN-LAST:event_jMenuItemArticuloActionPerformed

    private void jButtonBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBorrarActionPerformed
        // TODO add your handling code here:.
        
        odbfac = ODBFactory.open(filename);
        IQuery querydelete = new CriteriaQuery(Tienda.class, Where.equal("id", Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString())));
        Objects<Tienda> objects = odbfac.getObjects(querydelete);
        Tienda t = new Tienda();
        t=objects.getFirst();
        odbfac.delete(t);
        odbfac.close();
        actualizarTabla();
        
        
    }//GEN-LAST:event_jButtonBorrarActionPerformed

    private void jButtonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarActionPerformed
        // TODO add your handling code here:
        int id = Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
        JDModificarTienda jdmt = new JDModificarTienda(this, rootPaneCheckingEnabled, id);
        jdmt.setVisible(true);
    }//GEN-LAST:event_jButtonModificarActionPerformed

    private void jButtonverArticulosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonverArticulosActionPerformed
        // TODO add your handling code here:
        System.out.println(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());  
        JFVerArticulos jfva = new JFVerArticulos(Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString()));
      
        jfva.setVisible(true);
    }//GEN-LAST:event_jButtonverArticulosActionPerformed

    private void jMenuItemDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemDatosActionPerformed
        // TODO add your handling code here:
        odbfac=ODBFactory.open(filename);
        System.out.println("abierta");
        for(int i =0; i<10;i++){
            System.out.println("tienda "+i);
            Tienda t = new Tienda(i, "nif"+i, "nombre"+i, 999990+i , "direccion"+i);
            odbfac.store(t);
            
        }for(int j=0;j<5;j++){
            int i=0;
                System.out.println("articulo"+ j+" "+i++);
                Articulo a = new Articulo(j, "nombre"+j, "descripcion"+ j, 2.552, i++);
                odbfac.store(a);
            }
        odbfac.close();
        actualizarTabla();
    }//GEN-LAST:event_jMenuItemDatosActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFVerTiendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFVerTiendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFVerTiendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFVerTiendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFVerTiendas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBorrar;
    private javax.swing.JButton jButtonModificar;
    private javax.swing.JButton jButtonverArticulos;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemArticulo;
    private javax.swing.JMenuItem jMenuItemDatos;
    private javax.swing.JMenuItem jMenuItemTienda;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
