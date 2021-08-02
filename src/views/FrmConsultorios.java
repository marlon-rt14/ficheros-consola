/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import app.FacadeConsultorios;
import app.FacadeMedicamentos;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author marlon97
 */
public class FrmConsultorios extends javax.swing.JFrame {

	/**
	 * Creates new form FrmConsultorios
	 */
	
	FacadeConsultorios facadeConsultorio = new FacadeConsultorios();
	
	public FrmConsultorios() {
		initComponents();
		this.getContentPane().setBackground(Color.white);
		llenarTabla();
	}

	public void llenarTabla(){
		
		
		
		ArrayList<String> listaConsultorios = facadeConsultorio.getConsultorios();
		if (listaConsultorios != null) {
			DefaultTableModel dtm = (DefaultTableModel) tblConsultorios.getModel();
			dtm.setRowCount(0);
			for (String linea : listaConsultorios) {
				String[] datos = linea.split(",");
				Object[] fila = new Object[datos.length];
				for (int i = 0; i < datos.length; i++) {
					fila[i] = datos[i];
				}
				dtm.addRow(fila);
			}
		} else {
//			JOptionPane.showMessageDialog(null,
//				"No se puede leer el archivo de citas.",
//				"Advertencia",
//				JOptionPane.WARNING_MESSAGE);
		}
		
	}
	
	@SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                jScrollPane1 = new javax.swing.JScrollPane();
                tblConsultorios = new javax.swing.JTable();
                btnCerrar = new javax.swing.JButton();

                setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
                setTitle("Consultorios");
                setMinimumSize(new java.awt.Dimension(535, 407));

                tblConsultorios.setModel(new javax.swing.table.DefaultTableModel(
                        new Object [][] {

                        },
                        new String [] {
                                "ID", "Nombre"
                        }
                ) {
                        boolean[] canEdit = new boolean [] {
                                false, false
                        };

                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                                return canEdit [columnIndex];
                        }
                });
                tblConsultorios.setSelectionBackground(new java.awt.Color(153, 255, 153));
                tblConsultorios.setSelectionForeground(new java.awt.Color(0, 0, 0));
                tblConsultorios.getTableHeader().setReorderingAllowed(false);
                jScrollPane1.setViewportView(tblConsultorios);
                if (tblConsultorios.getColumnModel().getColumnCount() > 0) {
                        tblConsultorios.getColumnModel().getColumn(0).setPreferredWidth(100);
                        tblConsultorios.getColumnModel().getColumn(0).setMaxWidth(100);
                }

                btnCerrar.setText("Cerrar");
                btnCerrar.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnCerrarActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(btnCerrar)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE))
                                .addGap(18, 18, 18))
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCerrar)
                                .addGap(17, 17, 17))
                );

                pack();
        }// </editor-fold>//GEN-END:initComponents

        private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
                // TODO add your handling code here:
		this.dispose();
        }//GEN-LAST:event_btnCerrarActionPerformed

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
			java.util.logging.Logger.getLogger(FrmConsultorios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(FrmConsultorios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(FrmConsultorios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(FrmConsultorios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new FrmConsultorios().setVisible(true);
			}
		});
	}

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton btnCerrar;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JTable tblConsultorios;
        // End of variables declaration//GEN-END:variables
}
