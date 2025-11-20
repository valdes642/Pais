/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class Registro_Poblacional_Internacional extends javax.swing.JFrame {

    private TableRowSorter<DefaultTableModel> sorter;

    public Registro_Poblacional_Internacional() {
        initComponents();
        this.setLocationRelativeTo(null);

        // 1. Configurar el Sorter
        DefaultTableModel model = (DefaultTableModel) tableRegistro.getModel();
        sorter = new TableRowSorter<>(model);
        tableRegistro.setRowSorter(sorter);

        // 2. Configurar el ComboBox
        jcombotabla.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pais", "Ciudad", "Idioma" }));

        // 3. Cargar datos iniciales
        cargarTablaPais();
        llenarComboPaisesSeleccion();
    }

    // ==========================================
    //          MÉTODOS DE CARGA (VISTAS)
    // ==========================================

    private void cargarTablaPais() {
        DefaultTableModel model = (DefaultTableModel) tableRegistro.getModel();
        model.setRowCount(0);
        model.setColumnCount(0);
        
        model.addColumn("Código");
        model.addColumn("Nombre");
        model.addColumn("Continente");
        model.addColumn("Población");
        
        sorter.setModel(model);

        String sql = "SELECT codigoPais, nombrePais, continentePais, poblacionPais FROM Pais";

        // CAMBIO: Instanciamos la clase ConexionDB como en el tutorial [cite: 9]
        ConexionDB con = new ConexionDB();
        
        try (Connection conn = con.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("codigoPais"),
                    rs.getString("nombrePais"),
                    rs.getString("continentePais"),
                    rs.getInt("poblacionPais")
                });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar País: " + e.getMessage());
        }
    }

    private void cargarTablaCiudad() {
        DefaultTableModel model = (DefaultTableModel) tableRegistro.getModel();
        model.setRowCount(0);
        model.setColumnCount(0);
        
        model.addColumn("ID");
        model.addColumn("Nombre Ciudad");
        model.addColumn("Población");
        model.addColumn("Pertenece a (País)");
        
        sorter.setModel(model);

        String sql = "SELECT idCiudad, nombreCiudad, poblacionCiudad, codigoPais FROM Ciudad";

        // CAMBIO: Instanciamos la clase ConexionDB
        ConexionDB con = new ConexionDB();

        try (Connection conn = con.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("idCiudad"),
                    rs.getString("nombreCiudad"),
                    rs.getInt("poblacionCiudad"),
                    rs.getString("codigoPais")
                });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar Ciudad: " + e.getMessage());
        }
    }

    private void cargarTablaIdioma() {
        DefaultTableModel model = (DefaultTableModel) tableRegistro.getModel();
        model.setRowCount(0);
        model.setColumnCount(0);
        
        model.addColumn("ID");
        model.addColumn("Idioma");
        model.addColumn("Es Oficial?");
        model.addColumn("País");
        
        sorter.setModel(model);

        String sql = "SELECT idIdioma, nombreIdioma, oficial, codigoPais FROM Idioma";

        // CAMBIO: Instanciamos la clase ConexionDB
        ConexionDB con = new ConexionDB();

        try (Connection conn = con.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String esOficial = rs.getBoolean("oficial") ? "Sí" : "No";
                model.addRow(new Object[]{
                    rs.getInt("idIdioma"),
                    rs.getString("nombreIdioma"),
                    esOficial,
                    rs.getString("codigoPais")
                });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar Idioma: " + e.getMessage());
        }
    }

  
    private void llenarComboPaisesSeleccion() {
        jcombotabla.removeAllItems();
        jcombotabla.addItem("Seleccione...");
        
        ConexionDB con = new ConexionDB(); // Instancia conexión
        
        try (Connection conn = con.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT nombrePais FROM Pais ORDER BY nombrePais")) {
            while (rs.next()) {
                jcombotabla.addItem(rs.getString("nombrePais"));
            }
        } catch (SQLException e) { }
    }

    private void limpiarCampos() {
        jTextField3.setText(""); 
        jTextField1.setText(""); 
        jTextField2.setText(""); 
        jTextField4.setText(""); 
        if(jcombotabla.getItemCount() > 0) jcombotabla.setSelectedIndex(0);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableRegistro = new javax.swing.JTable();
        txtBuscar = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        jcombotabla = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI Historic", 3, 24)); // NOI18N
        jLabel1.setText("Registro Poblacional Internacional");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Código");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Nombre");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Continente");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Población");

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        btnBuscar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(255, 0, 51));
        btnEliminar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnAgregar.setBackground(new java.awt.Color(102, 255, 102));
        btnAgregar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        tableRegistro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombre", "Continente", "Población"
            }
        ));
        tableRegistro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableRegistroMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableRegistro);

        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Buscar entre la informacion ingresada:");

        btnModificar.setBackground(new java.awt.Color(102, 255, 255));
        btnModificar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnModificar.setForeground(new java.awt.Color(255, 255, 255));
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        jcombotabla.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcombotabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcombotablaActionPerformed(evt);
            }
        });

        jLabel7.setText("Tablas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(btnAgregar)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel7)
                                .addComponent(jLabel3)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnModificar)
                                .addGap(25, 25, 25))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnEliminar)
                                    .addComponent(jcombotabla, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 110, Short.MAX_VALUE)))))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscar))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jcombotabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel2)
                                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(50, 50, 50))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(216, 216, 216)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnModificar)
                                    .addComponent(btnEliminar)
                                    .addComponent(btnAgregar))))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
String seleccion = jcombotabla.getSelectedItem().toString();
        if (!seleccion.equals("Pais")) {
            JOptionPane.showMessageDialog(this, "Por favor cambie a la tabla 'Pais' para agregar registros.");
            return;
        }

        try {
            String sql = "INSERT INTO Pais(codigoPais, nombrePais, continentePais, poblacionPais, tipoGobierno) VALUES(?,?,?,?,?)";
            ConexionDB con = new ConexionDB();

            try (Connection conn = con.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
                
                String codigo = jTextField3.getText();
                String nombre = jTextField1.getText();
                String continente = jTextField2.getText();
                int poblacion;
                
                try {
                    poblacion = Integer.parseInt(jTextField4.getText());
                } catch (NumberFormatException e) {
                    throw new Exception("La población debe ser un número entero.");
                }

                if (poblacion < 0) {
                    throw new Exception("La población no puede ser negativa.");
                }

                pstmt.setString(1, codigo);
                pstmt.setString(2, nombre);
                pstmt.setString(3, continente);
                pstmt.setInt(4, poblacion);
                pstmt.setInt(5, 1); 

                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(this, "País guardado exitosamente.");
                
                limpiarCampos();
                cargarTablaPais();
                llenarComboPaisesSeleccion();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
String seleccion = jcombotabla.getSelectedItem().toString();
        if (!seleccion.equals("Pais")) {
            JOptionPane.showMessageDialog(this, "Solo se permite eliminar en la tabla 'Pais'.");
            return;
        }

        int selectedRow = tableRegistro.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione una fila para eliminar.");
            return;
        }

        String codigo = tableRegistro.getValueAt(selectedRow, 0).toString();
        int confirm = JOptionPane.showConfirmDialog(this, "¿Seguro que desea eliminar: " + codigo + "?");

        if (confirm == JOptionPane.YES_OPTION) {
            String sql = "DELETE FROM Pais WHERE codigoPais = ?";
            
            // CAMBIO: Instancia conexión
            ConexionDB con = new ConexionDB();

            try (Connection conn = con.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {

                pstmt.setString(1, codigo);
                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(this, "Registro eliminado.");
                limpiarCampos();
                cargarTablaPais();
                llenarComboPaisesSeleccion();

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error al eliminar: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
String texto = txtBuscar.getText();
        if (texto.trim().length() == 0) {
            sorter.setRowFilter(null);
        } else {
            sorter.setRowFilter(javax.swing.RowFilter.regexFilter("(?i)" + texto));
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
      
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
String seleccion = jcombotabla.getSelectedItem().toString();
        if (!seleccion.equals("Pais")) {
            JOptionPane.showMessageDialog(this, "Solo se permite modificar en la tabla 'Pais'.");
            return;
        }

        int selectedRow = tableRegistro.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione una fila para modificar.");
            return;
        }

        try {
            String codigoOriginal = tableRegistro.getValueAt(selectedRow, 0).toString();
            String sql = "UPDATE Pais SET nombrePais=?, continentePais=?, poblacionPais=? WHERE codigoPais=?";
            
            // CAMBIO: Instancia conexión
            ConexionDB con = new ConexionDB();

            try (Connection conn = con.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
                
                int poblacion;
                try {
                    poblacion = Integer.parseInt(jTextField4.getText());
                } catch (NumberFormatException e) {
                    throw new Exception("La población debe ser un número.");
                }

                if (poblacion < 0) throw new Exception("La población no puede ser negativa.");

                pstmt.setString(1, jTextField1.getText());
                pstmt.setString(2, jTextField2.getText());
                pstmt.setInt(3, poblacion);
                pstmt.setString(4, codigoOriginal);

                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(this, "Registro modificado.");
                limpiarCampos();
                cargarTablaPais();
                llenarComboPaisesSeleccion();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void tableRegistroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableRegistroMouseClicked

    }//GEN-LAST:event_tableRegistroMouseClicked

    private void jcombotablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcombotablaActionPerformed
        // TODO add your handling code her
        String seleccion = jcombotabla.getSelectedItem().toString();
        limpiarCampos();
        
        if (seleccion.equals("Pais")) {
            cargarTablaPais();
            btnAgregar.setEnabled(true);
            btnModificar.setEnabled(true);
            btnEliminar.setEnabled(true);
        } else if (seleccion.equals("Ciudad")) {
            cargarTablaCiudad();
        } else if (seleccion.equals("Idioma")) {
            cargarTablaIdioma();
        }
    }//GEN-LAST:event_jcombotablaActionPerformed
    
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
            java.util.logging.Logger.getLogger(Registro_Poblacional_Internacional.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registro_Poblacional_Internacional.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registro_Poblacional_Internacional.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registro_Poblacional_Internacional.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registro_Poblacional_Internacional().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JComboBox<String> jcombotabla;
    private javax.swing.JTable tableRegistro;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables

}