package views;

import app.FacadeMedicamentos;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FrmMedicamentos extends javax.swing.JFrame {

	private FacadeMedicamentos facadeMedicamentos;

	public FrmMedicamentos() {
		initComponents();
		this.getContentPane().setBackground(Color.white);
		this.setExtendedState(MAXIMIZED_BOTH);
		facadeMedicamentos = new FacadeMedicamentos();
		iniciarDisenio();
		removerLineasVacias();
		llenarTabla();
	}

	public void removerLineasVacias() {
		try {
			facadeMedicamentos.removeSeparator();
		} catch (IOException ex) {
//			JOptionPane.showMessageDialog(this,
//				"Error al leer el archivo medicamentos.txt para remover lineas vacias",
//				"Error", JOptionPane.ERROR_MESSAGE);
			//Logger.getLogger(FrmMedicamentos.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void llenarTabla() {
		ArrayList<String> listaMedicamentos = facadeMedicamentos.getMedicamentos();
		if (listaMedicamentos != null) {
			DefaultTableModel dtm = (DefaultTableModel) tblMedicamentos.getModel();
			dtm.setRowCount(0);
			for (String linea : listaMedicamentos) {
				String[] datos = linea.split(",");
				Object[] fila = new Object[datos.length];
				for (int i = 0; i < datos.length; i++) {
					fila[i] = datos[i];
				}
				dtm.addRow(fila);
			}
		} else {
//			JOptionPane.showMessageDialog(null,
//				"No se puede leer el archivo de medicamentos para llenar la tabla.",
//				"Advertencia",
//				JOptionPane.WARNING_MESSAGE);
		}

	}

	public void limpiar() {
		txtId.setText("");
		txtNombreComercial.setText("");
		txtPrincipioActivo.setText("");
		txtTipo.setText("");
		txtPeso.setText("");
		txtStock.setText("");
	}

	private void iniciarDisenio() {
		//this.txtId.setBorder(new EmptyBorder(5, 5, 5, 5));

		//this.txtId.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, new Color(0, 204, 0)));
		this.txtNombreComercial.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, new Color(0, 204, 0)));
		this.txtPrincipioActivo.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, new Color(0, 204, 0)));
		this.txtTipo.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, new Color(0, 204, 0)));
		this.txtPeso.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, new Color(0, 204, 0)));
		this.txtStock.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, new Color(0, 204, 0)));
	}

	@SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                pnlPaciente = new javax.swing.JPanel();
                jLabel1 = new javax.swing.JLabel();
                txtId = new javax.swing.JTextField();
                jLabel2 = new javax.swing.JLabel();
                txtPrincipioActivo = new javax.swing.JTextField();
                jLabel3 = new javax.swing.JLabel();
                txtTipo = new javax.swing.JTextField();
                jLabel4 = new javax.swing.JLabel();
                jLabel5 = new javax.swing.JLabel();
                btnLimpiar = new javax.swing.JButton();
                jLabel8 = new javax.swing.JLabel();
                txtNombreComercial = new javax.swing.JTextField();
                txtPeso = new javax.swing.JTextField();
                txtStock = new javax.swing.JTextField();
                jScrollPane2 = new javax.swing.JScrollPane();
                tblMedicamentos = new javax.swing.JTable();
                jPanel1 = new javax.swing.JPanel();
                btnGuardar = new javax.swing.JButton();
                btnEliminar = new javax.swing.JButton();
                btnCerrar = new javax.swing.JButton();

                setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
                setTitle("Agendar Citas");
                setMinimumSize(new java.awt.Dimension(1008, 666));

                pnlPaciente.setBackground(new java.awt.Color(255, 255, 255));
                pnlPaciente.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 255, 102), 2, true), "MEDICAMENTOS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("sansserif", 1, 14), new java.awt.Color(0, 204, 0))); // NOI18N

                jLabel1.setText("ID:");

                txtId.setEnabled(false);

                jLabel2.setText("Principio activo:");

                jLabel3.setText("Tipo:");

                jLabel4.setText("Gramaje o peso:");

                jLabel5.setText("Cantidad de estock:");

                btnLimpiar.setText("Limpiar");
                btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnLimpiarActionPerformed(evt);
                        }
                });

                jLabel8.setText("Nombre comercial:");

                javax.swing.GroupLayout pnlPacienteLayout = new javax.swing.GroupLayout(pnlPaciente);
                pnlPaciente.setLayout(pnlPacienteLayout);
                pnlPacienteLayout.setHorizontalGroup(
                        pnlPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlPacienteLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(pnlPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtTipo)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel1)
                                        .addComponent(txtPrincipioActivo)
                                        .addGroup(pnlPacienteLayout.createSequentialGroup()
                                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                                                .addComponent(btnLimpiar))
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel8)
                                        .addComponent(txtNombreComercial)
                                        .addComponent(txtPeso)
                                        .addComponent(txtStock))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
                pnlPacienteLayout.setVerticalGroup(
                        pnlPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlPacienteLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnLimpiar))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNombreComercial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPrincipioActivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(24, Short.MAX_VALUE))
                );

                tblMedicamentos.setModel(new javax.swing.table.DefaultTableModel(
                        new Object [][] {

                        },
                        new String [] {
                                "ID", "Nombre comercial", "Principio activo", "Tipo", "Peso", "Stock"
                        }
                ) {
                        boolean[] canEdit = new boolean [] {
                                false, false, false, false, false, false
                        };

                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                                return canEdit [columnIndex];
                        }
                });
                tblMedicamentos.setSelectionBackground(new java.awt.Color(153, 255, 153));
                tblMedicamentos.setSelectionForeground(new java.awt.Color(0, 0, 0));
                tblMedicamentos.setShowGrid(false);
                tblMedicamentos.getTableHeader().setReorderingAllowed(false);
                tblMedicamentos.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                tblMedicamentosMouseClicked(evt);
                        }
                });
                jScrollPane2.setViewportView(tblMedicamentos);
                if (tblMedicamentos.getColumnModel().getColumnCount() > 0) {
                        tblMedicamentos.getColumnModel().getColumn(0).setPreferredWidth(50);
                        tblMedicamentos.getColumnModel().getColumn(0).setMaxWidth(50);
                }

                jPanel1.setBackground(new java.awt.Color(255, 255, 255));
                jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 255, 102), 3, true));

                btnGuardar.setText("Guardar");
                btnGuardar.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnGuardarActionPerformed(evt);
                        }
                });

                btnEliminar.setText("Eliminar");
                btnEliminar.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnEliminarActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(btnEliminar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                                .addComponent(btnGuardar)
                                .addGap(40, 40, 40))
                );
                jPanel1Layout.setVerticalGroup(
                        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnGuardar)
                                        .addComponent(btnEliminar))
                                .addContainerGap(57, Short.MAX_VALUE))
                );

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
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(pnlPaciente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 656, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(btnCerrar)))
                                .addGap(23, 23, 23))
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnCerrar))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(pnlPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(21, Short.MAX_VALUE))
                );

                pack();
        }// </editor-fold>//GEN-END:initComponents

        private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
		// TODO add your handling code here:
		if (txtId.getText().trim().length() == 0) {
			String nombreComercial = txtNombreComercial.getText();
			String principioActivo = txtPrincipioActivo.getText();
			String tipo = txtTipo.getText();
			String peso = txtPeso.getText();
			String stock = txtStock.getText();

			facadeMedicamentos.setMedicamento(nombreComercial, principioActivo, tipo, peso, stock);
			//limpiar();
			llenarTabla();
		} else {
			int op = JOptionPane.showConfirmDialog(this, "¿Esta seguro que desea acutalizar los datos?",
				"Confirmación", JOptionPane.YES_NO_OPTION);
			if (op == JOptionPane.YES_OPTION) {
				int id = Integer.parseInt(txtId.getText());
				String nombreComercial = txtNombreComercial.getText();
				String principioActivo = txtPrincipioActivo.getText();
				String tipo = txtTipo.getText();
				String peso = txtPeso.getText();
				String stock = txtStock.getText();

				try {
					facadeMedicamentos.updateMedicamento(id, nombreComercial,
						principioActivo, tipo, peso, stock);
				} catch (IOException ex) {
					JOptionPane.showMessageDialog(this,
						"Error al leer el archivo medicamentos para actualizar datos.txt",
						"Error", JOptionPane.ERROR_MESSAGE);
					//Logger.getLogger(FrmMedicamentos.class.getName()).log(Level.SEVERE, null, ex);
				}

				llenarTabla();
			}
		}
        }//GEN-LAST:event_btnGuardarActionPerformed


        private void tblMedicamentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMedicamentosMouseClicked
		// TODO add your handling code here:

		String id = tblMedicamentos.getValueAt(tblMedicamentos.getSelectedRow(), 0).toString();
		String linea = "";
		BufferedReader lector = null;
		try {
			lector = new BufferedReader(new FileReader(facadeMedicamentos.rutaMedicamentos));
			while ((linea = lector.readLine()) != null) {
				String[] datos = linea.split(",");
				if (datos[0].equals(id)) {
					txtId.setText(datos[0]);
					txtNombreComercial.setText(datos[1]);
					txtPrincipioActivo.setText(datos[2]);
					txtTipo.setText(datos[3]);
					txtPeso.setText(datos[4]);
					txtStock.setText(datos[5]);
				}
			}
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(this,
				"No se puede leer el archivo de medicamentos para llenar la tabla.",
				"Advertencia",
				JOptionPane.WARNING_MESSAGE);
		} finally {
			if (lector != null) {
				try {
					lector.close();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		}
        }//GEN-LAST:event_tblMedicamentosMouseClicked

        private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
		// TODO add your handling code here:
		if (txtId.getText().trim().length() > 0) {
			int op = JOptionPane.showConfirmDialog(this, "¿Esta seguro que desea eliminar este paciente?",
				"Confirmación", JOptionPane.YES_NO_OPTION);
			if (op == JOptionPane.YES_OPTION) {
				try {
					facadeMedicamentos.deleteMedicamento(Integer.parseInt(txtId.getText()));
				} catch (IOException ex) {
					JOptionPane.showMessageDialog(this,
						"Error al leer el archivo medicamentos.txt para eliminar el medicamento actual",
						"Error", JOptionPane.ERROR_MESSAGE);
					//Logger.getLogger(FrmMedicamentos.class.getName()).log(Level.SEVERE, null, ex);
				}
				limpiar();
				llenarTabla();
			}
		} else {
			JOptionPane.showMessageDialog(rootPane, "No se ha seleccionado ningun paciente",
				"Informacion", JOptionPane.INFORMATION_MESSAGE);
		}
        }//GEN-LAST:event_btnEliminarActionPerformed

        private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
		// TODO add your handling code here:
		limpiar();
        }//GEN-LAST:event_btnLimpiarActionPerformed

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
			java.util.logging.Logger.getLogger(FrmMedicamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(FrmMedicamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(FrmMedicamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(FrmMedicamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>
		//</editor-fold>
		//</editor-fold>
		//</editor-fold>
		//</editor-fold>
		//</editor-fold>
		//</editor-fold>
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new FrmMedicamentos().setVisible(true);
			}
		});
	}

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton btnCerrar;
        private javax.swing.JButton btnEliminar;
        private javax.swing.JButton btnGuardar;
        private javax.swing.JButton btnLimpiar;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JLabel jLabel4;
        private javax.swing.JLabel jLabel5;
        private javax.swing.JLabel jLabel8;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JScrollPane jScrollPane2;
        private javax.swing.JPanel pnlPaciente;
        private javax.swing.JTable tblMedicamentos;
        private javax.swing.JTextField txtId;
        private javax.swing.JTextField txtNombreComercial;
        private javax.swing.JTextField txtPeso;
        private javax.swing.JTextField txtPrincipioActivo;
        private javax.swing.JTextField txtStock;
        private javax.swing.JTextField txtTipo;
        // End of variables declaration//GEN-END:variables
}
