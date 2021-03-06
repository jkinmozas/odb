/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import javax.swing.table.DefaultTableModel;
import modelo.Articulo;
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
public class JFVerArticulos extends javax.swing.JFrame {

    ODB odbfac;
    static int id ;
    String filename = "C:\\Users\\Joaquin\\Documents\\NetBeansProjects\\ODB\\src\\neodatis.test";

    public void actualizarTabla() {
        odbfac = ODBFactory.open(filename);
        jTable1.removeAll();
        DefaultTableModel tmart = new DefaultTableModel();
        while (tmart.getRowCount() > 0) {
            tmart.removeRow(0);
        }
        tmart.addColumn("ID");
        tmart.addColumn("ID Tienda");
        tmart.addColumn("Nombre");
        tmart.addColumn("Descripcion");
        tmart.addColumn("Precio");

        Object[] columnaArt = new Object[5];
//        //Testing only
//        id=1;
        IQuery query = new CriteriaQuery(Articulo.class, Where.equal("tiendaId", id));
        Objects<Articulo> objects = odbfac.getObjects(query);
        
        while (objects.hasNext()) {
            Articulo a = new Articulo();
            a = (Articulo) objects.next();
            columnaArt[0] = a.getId();
            columnaArt[1] = a.getTiendaId();
            columnaArt[2] = a.getNombre();
            columnaArt[3] = a.getDescripcion();
            columnaArt[4] = a.getPrecio();
            tmart.addRow(columnaArt);
        }
        jTable1.setModel(tmart);
        odbfac.close();
    }

    /**
     * Creates new form JFVerArticulos
     */
    public JFVerArticulos(int id) {
        initComponents();
        this.id = id;
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
        jButtonBorrarArticulo = new javax.swing.JButton();
        jButtonModificarArticulo = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItemTienda = new javax.swing.JMenuItem();
        jMenuItemArticulo = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

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

        jButtonBorrarArticulo.setText("Borrar");
        jButtonBorrarArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBorrarArticuloActionPerformed(evt);
            }
        });

        jButtonModificarArticulo.setText("Modificar");
        jButtonModificarArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarArticuloActionPerformed(evt);
            }
        });

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonModificarArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(57, 57, 57)
                .addComponent(jButtonBorrarArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonBorrarArticulo)
                    .addComponent(jButtonModificarArticulo)
                    .addComponent(jButton1))
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
        JDAnadirArticulo jdaa = new JDAnadirArticulo(this, rootPaneCheckingEnabled);
        jdaa.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemArticuloActionPerformed

    private void jButtonBorrarArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBorrarArticuloActionPerformed
        // TODO add your handling code here:
        odbfac = ODBFactory.open(filename);
        IQuery querydelete = new CriteriaQuery(Articulo.class, Where.equal("id", Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString())));
        Objects<Articulo> objects2 = odbfac.getObjects(querydelete);

        Articulo a = new Articulo();
        a = objects2.getFirst();
        odbfac.delete(a);
        odbfac.close();
        actualizarTabla();

    }//GEN-LAST:event_jButtonBorrarArticuloActionPerformed

    private void jButtonModificarArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarArticuloActionPerformed
        // TODO add your handling code here:
        int id = Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
        JDModificarArticulo jdma = new JDModificarArticulo(this, rootPaneCheckingEnabled, id);
        jdma.setVisible(true);
    }//GEN-LAST:event_jButtonModificarArticuloActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
actualizarTabla();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(JFVerArticulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFVerArticulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFVerArticulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFVerArticulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFVerArticulos(id).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonBorrarArticulo;
    private javax.swing.JButton jButtonModificarArticulo;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemArticulo;
    private javax.swing.JMenuItem jMenuItemTienda;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
