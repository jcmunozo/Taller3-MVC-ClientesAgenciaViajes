package co.unicauca.clientes.vista;

import co.unicauca.clientes.modelo.Cliente;
import co.unicauca.clientes.modelo.ClientesDB;
import java.util.ArrayList;
import java.util.Observable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Libardo Pantoja, Ricardo Zambrano Es el segundo observador
 */
public class GUIClientesProfesion extends javax.swing.JFrame implements java.util.Observer {

    /**
     * Constructor
     *
     * @param h horizontal position
     * @param v vertical position
     */
    public GUIClientesProfesion(int h, int v) {
        initComponents();
        setSize(400, 200);
        setLocation(h, v);
        setVisible(true);
        inicializarTabla();
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
        tblClientes = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Clientes por profesion");

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblClientes);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(GUIClientesProfesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIClientesProfesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIClientesProfesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIClientesProfesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIClientesProfesion(400, 200).setVisible(true);
            }
        });
    }

    private void inicializarTabla() {
        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Nombres", "Profesión", "Sexo"
                }
        ));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblClientes;
    // End of variables declaration//GEN-END:variables
    @Override
    public void update(Observable obs, Object obj) {
        ClientesDB cliDB = (ClientesDB) obs;
        ArrayList<Cliente> clientes = cliDB.getClientesPorProfesion();
        this.setTitle("Clientes por profesión: " + cliDB.getProfesion());
        llenarTabla(clientes);
    }

    private void llenarTabla(ArrayList<Cliente> clientes) {
        this.inicializarTabla();
        DefaultTableModel model = (DefaultTableModel) tblClientes.getModel();

        Object rowData[] = new Object[3];
        for (Cliente cli: clientes) {
            rowData[0] = cli.getNombres();
            rowData[1] = cli.getProfesion();
            rowData[2] = cli.getSexo();
            model.addRow(rowData);
        }
    }

}
