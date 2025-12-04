
package Vista;
import Conexion.ConexionNueva;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import Controles.CiudadControl;
import Modelo.Ciudad;
import java.awt.event.ActionEvent;


import javax.swing.table.DefaultTableModel;

public class Vista extends javax.swing.JFrame {    
    public Vista() {
        initComponents();
        cargarDatosPais();
        cargarDatosIdiomas();
        cargarDatosCiudad();
        
    }

    private void cargarDatosPais() {
        DefaultTableModel model = (DefaultTableModel) jTablePais.getModel();
        model.setRowCount(0);

        String sql = "SELECT * FROM Pais";

        // AQUÍ ESTÁ EL CAMBIO:
        // Antes decía: Conexion.ConexionBD.conectar()
        // Ahora dice:  Conexion.ConexionNueva.conectar()
        try (Connection conn = Conexion.ConexionNueva.conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                // ... (el resto de tu código sigue igual)
                String codigo = rs.getString("codigoPais");
                String nombre = rs.getString("nombrePais");
                String continente = rs.getString("continentePais");
                int poblacion = rs.getInt("poblacionPais");
                boolean tipoGobierno = rs.getBoolean("tipoGobierno");

                Object[] fila = {
                    codigo, nombre, continente, poblacion, tipoGobierno ? "Democracia" : "Otro"
                };
                model.addRow(fila);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar datos de la NUEVA BD: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void cargarDatosCiudad() {
    DefaultTableModel model = (DefaultTableModel) jTableCiudades.getModel();
    model.setRowCount(0);

    String sql = "SELECT nombreCiudad, poblacionCiudad FROM Ciudad";

    try (Connection conn = Conexion.ConexionBD.conectar();
         PreparedStatement ps = conn.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {
            String nombreCiudad = rs.getString("nombreCiudad");
            
            int poblacion = rs.getInt("poblacionCiudad"); 
            
            Object[] fila = {
                nombreCiudad,
                poblacion,
            };

            model.addRow(fila);
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al cargar datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}
    
    private void cargarDatosIdiomas() {
    DefaultTableModel model = (DefaultTableModel) jTableCiudades1.getModel();
    model.setRowCount(0);

    String sql = "SELECT nombreIdioma, oficial FROM idioma";

    try (Connection conn = Conexion.ConexionBD.conectar();
         PreparedStatement ps = conn.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {
            String idioma = rs.getString("nombreIdioma");
            
            int oficialDB = rs.getInt("oficial"); 

            String esOficialTexto = (oficialDB == 1) ? "Sí" : "No";

            Object[] fila = {
                idioma,        
                esOficialTexto
            };

            model.addRow(fila);
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al cargar datos de idiomas: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }
    private String obtenerCodigoPais(String nombrePais) {
        if (nombrePais == null) return "";
        if (nombrePais.equals("Argentina")) return "ARG";
        if (nombrePais.equals("Brasil")) return "BRA";
        if (nombrePais.equals("Chile")) return "CHL";
        return "";
    }

    // Método reutilizable para llenar cualquier tabla según el país
    private void llenarTablaComparacion(javax.swing.JTable tabla, String codigoPais) {
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        model.setRowCount(0); // Limpiar tabla

        String sql = "SELECT nombreCiudad, poblacionCiudad FROM Ciudad WHERE codigoPais = ?";

        // Usamos ConexionNueva como en tu método cargarDatosPais
        try (Connection conn = Conexion.ConexionNueva.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, codigoPais);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String ciudad = rs.getString("nombreCiudad");
                int poblacion = rs.getInt("poblacionCiudad");
                model.addRow(new Object[]{ciudad, poblacion});
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar comparación: " + e.getMessage());
        }
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanelPaises = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtPoblacion = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePais = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnCrear = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnConsultar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        chkTipoGobierno = new javax.swing.JCheckBox();
        cboxContinente = new javax.swing.JComboBox<>();
        jPanelCiudades = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableCiudades = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnConsultarCiudad = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jPanelCiudades1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableCiudades1 = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btnConsultarIdioma1 = new javax.swing.JButton();
        jComboBox2 = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jComboBox4 = new javax.swing.JComboBox<>();
        btnComparar = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableCiudades2 = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableCiudades3 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PAISES DEL MUNDO");
        setLocationByPlatform(true);

        jLabel3.setText("Nombre");

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        jLabel4.setText("Continente");

        jLabel5.setText("Población");

        jTablePais.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Código", "Nombre", "Continente", "Población", "Tipo de gobierno"
            }
        ));
        jScrollPane1.setViewportView(jTablePais);
        if (jTablePais.getColumnModel().getColumnCount() > 0) {
            jTablePais.getColumnModel().getColumn(0).setHeaderValue("Código");
            jTablePais.getColumnModel().getColumn(2).setHeaderValue("Continente");
            jTablePais.getColumnModel().getColumn(4).setHeaderValue("Tipo de gobierno");
        }

        jLabel1.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        jLabel1.setText("Registro Poblacional Internacional");

        btnCrear.setText("Agregar");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        jLabel2.setText("Código");

        btnConsultar.setText("Consultar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jLabel16.setText("Tipo de gobierno");

        chkTipoGobierno.setText("Democracia");

        cboxContinente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Asia", "Europa", "America", "Africa", "Oceania", "Antarctica" }));
        cboxContinente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxContinenteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelPaisesLayout = new javax.swing.GroupLayout(jPanelPaises);
        jPanelPaises.setLayout(jPanelPaisesLayout);
        jPanelPaisesLayout.setHorizontalGroup(
            jPanelPaisesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPaisesLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanelPaisesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelPaisesLayout.createSequentialGroup()
                        .addComponent(btnCrear)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnConsultar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar))
                    .addGroup(jPanelPaisesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel1)
                        .addGroup(jPanelPaisesLayout.createSequentialGroup()
                            .addGroup(jPanelPaisesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel2)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5)
                                .addComponent(jLabel16))
                            .addGap(18, 18, 18)
                            .addGroup(jPanelPaisesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                                .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                                .addComponent(txtPoblacion, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                                .addComponent(chkTipoGobierno)
                                .addComponent(cboxContinente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanelPaisesLayout.setVerticalGroup(
            jPanelPaisesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPaisesLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanelPaisesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanelPaisesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelPaisesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelPaisesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cboxContinente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelPaisesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtPoblacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelPaisesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(chkTipoGobierno))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelPaisesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCrear)
                    .addComponent(btnConsultar)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar))
                .addGap(21, 21, 21))
        );

        jTabbedPane1.addTab("Paises", jPanelPaises);

        jTableCiudades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Ciudad", "Población"
            }
        ));
        jScrollPane2.setViewportView(jTableCiudades);

        jLabel9.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        jLabel9.setText("Registro ciudades por pais");

        jLabel10.setText("Pais");

        btnConsultarCiudad.setText("Consultar");
        btnConsultarCiudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarCiudadActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Argentina", "Brasil", "Chile" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelCiudadesLayout = new javax.swing.GroupLayout(jPanelCiudades);
        jPanelCiudades.setLayout(jPanelCiudadesLayout);
        jPanelCiudadesLayout.setHorizontalGroup(
            jPanelCiudadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCiudadesLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(jPanelCiudadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addGroup(jPanelCiudadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnConsultarCiudad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCiudadesLayout.createSequentialGroup()
                            .addComponent(jLabel10)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanelCiudadesLayout.setVerticalGroup(
            jPanelCiudadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCiudadesLayout.createSequentialGroup()
                .addGroup(jPanelCiudadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCiudadesLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelCiudadesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addGroup(jPanelCiudadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(60, 60, 60)
                        .addComponent(btnConsultarCiudad)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Ciudades", jPanelCiudades);

        jTableCiudades1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Idioma", "Oficial"
            }
        ));
        jScrollPane3.setViewportView(jTableCiudades1);

        jLabel11.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        jLabel11.setText("Registro idioma por pais");

        jLabel12.setText("Pais");

        btnConsultarIdioma1.setText("Consultar");
        btnConsultarIdioma1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarIdioma1ActionPerformed(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Argentina", "Brasil", "Chile" }));

        javax.swing.GroupLayout jPanelCiudades1Layout = new javax.swing.GroupLayout(jPanelCiudades1);
        jPanelCiudades1.setLayout(jPanelCiudades1Layout);
        jPanelCiudades1Layout.setHorizontalGroup(
            jPanelCiudades1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCiudades1Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(jPanelCiudades1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11)
                    .addGroup(jPanelCiudades1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnConsultarIdioma1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCiudades1Layout.createSequentialGroup()
                            .addComponent(jLabel12)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanelCiudades1Layout.setVerticalGroup(
            jPanelCiudades1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCiudades1Layout.createSequentialGroup()
                .addGroup(jPanelCiudades1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCiudades1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelCiudades1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addGroup(jPanelCiudades1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(60, 60, 60)
                        .addComponent(btnConsultarIdioma1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Idiomas", jPanelCiudades1);

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Argentina", "Brasil", "Chile" }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Argentina", "Brasil", "Chile" }));
        jComboBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox4ActionPerformed(evt);
            }
        });

        btnComparar.setText("Comparar");
        btnComparar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompararActionPerformed(evt);
            }
        });

        jTableCiudades2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Ciudad", "Población"
            }
        ));
        jScrollPane4.setViewportView(jTableCiudades2);

        jTableCiudades3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Ciudad", "Población"
            }
        ));
        jScrollPane5.setViewportView(jTableCiudades3);

        jLabel6.setText("Comparacion entre ciudades");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(239, 239, 239))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(btnComparar)
                        .addGap(45, 45, 45)
                        .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(217, 217, 217)
                        .addComponent(jLabel6)))
                .addContainerGap(285, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(44, 44, 44)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(558, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnComparar))
                .addGap(49, 49, 49)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(87, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(134, Short.MAX_VALUE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(82, 82, 82)))
        );

        jTabbedPane1.addTab("Comparacion", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCompararActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompararActionPerformed
        // TODO add your handling code here:
        String nombrePaisIzquierda = jComboBox3.getSelectedItem().toString();
        String nombrePaisDerecha = jComboBox4.getSelectedItem().toString();

        // 2. Obtener los códigos (ARG, BRA, CHL)
        String codigoIzquierda = obtenerCodigoPais(nombrePaisIzquierda);
        String codigoDerecha = obtenerCodigoPais(nombrePaisDerecha);

        // 3. Llenar las tablas usando el método auxiliar
        llenarTablaComparacion(jTableCiudades2, codigoIzquierda);
        llenarTablaComparacion(jTableCiudades3, codigoDerecha);

        // Opcional: Mensaje si los paises son iguales
        if (codigoIzquierda.equals(codigoDerecha)) {
            JOptionPane.showMessageDialog(this, "Has seleccionado el mismo país en ambos lados.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnCompararActionPerformed

    private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox4ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void btnConsultarIdioma1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarIdioma1ActionPerformed
// 1. Obtener el nombre del país del ComboBox
        String nombrePais = jComboBox2.getSelectedItem().toString();
        
        // 2. Obtener el código (ARG, BRA, CHL) usando tu método auxiliar existente
        String codigoPais = obtenerCodigoPais(nombrePais);

        // 3. Obtener el modelo de la tabla y limpiarlo
        DefaultTableModel model = (DefaultTableModel) jTableCiudades1.getModel();
        model.setRowCount(0); 

        // 4. Definir la consulta SQL
        String sql = "SELECT nombreIdioma, oficial FROM Idioma WHERE codigoPais = ?";

        // 5. Conectar y ejecutar (Usando ConexionNueva como en tus otros métodos)
        try (Connection conn = Conexion.ConexionNueva.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, codigoPais);
            ResultSet rs = ps.executeQuery();

            boolean hayDatos = false;

            while (rs.next()) {
                hayDatos = true;
                String idioma = rs.getString("nombreIdioma");
                
                // Convertir el campo 'oficial' (1 o 0) a "Sí" o "No"
                int oficialInt = rs.getInt("oficial"); 
                String esOficial = (oficialInt == 1) ? "Sí" : "No";

                model.addRow(new Object[]{idioma, esOficial});
            }

            if (!hayDatos) {
                JOptionPane.showMessageDialog(this, "No se encontraron idiomas registrados para " + nombrePais);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al consultar idiomas: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnConsultarIdioma1ActionPerformed

    private void btnConsultarCiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarCiudadActionPerformed
        // TODO add your handling code here:
        // 1. Obtener el país seleccionado del combo
        String nombrePais = jComboBox1.getSelectedItem().toString();

        // 2. Convertir el nombre a código (usando tu método auxiliar)
        String codigoPais = obtenerCodigoPais(nombrePais);

        // 3. Preparar la tabla de Ciudades
        DefaultTableModel model = (DefaultTableModel) jTableCiudades.getModel();
        model.setRowCount(0); // Limpiar datos anteriores

        // 4. Crear la consulta SQL
        String sql = "SELECT nombreCiudad, poblacionCiudad FROM Ciudad WHERE codigoPais = ?";

        // 5. Conectar y buscar
        try (Connection conn = Conexion.ConexionNueva.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, codigoPais);
            ResultSet rs = ps.executeQuery();

            boolean hayDatos = false;

            while (rs.next()) {
                hayDatos = true;
                String nombre = rs.getString("nombreCiudad");
                int poblacion = rs.getInt("poblacionCiudad");

                // Agregar fila a la tabla: [Nombre Ciudad, Población]
                model.addRow(new Object[]{nombre, poblacion});
            }

            if (!hayDatos) {
                JOptionPane.showMessageDialog(this, "No hay ciudades registradas para " + nombrePais, "Sin resultados", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al consultar ciudades: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnConsultarCiudadActionPerformed

    private void cboxContinenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxContinenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboxContinenteActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
String codigoBuscado = txtCodigo.getText().trim();
// Asumiendo que cboxContinente SIEMPRE tiene un item seleccionado (ej: "Todos" o un continente válido)
String continenteSeleccionado = cboxContinente.getSelectedItem().toString(); 

DefaultTableModel model = (DefaultTableModel) jTablePais.getModel();
model.setRowCount(0);

String sql;
boolean buscarPorCodigo = !codigoBuscado.isEmpty();

if (buscarPorCodigo) {
    // Si hay código, buscar SÓLO por código.
    sql = "SELECT codigoPais, nombrePais, continentePais, poblacionPais, tipoGobierno FROM Pais WHERE codigoPais = ?";
} else {
    // Si no hay código, buscar por continente.
    // **NOTA:** Si quieres que se muestren *todos* los países cuando NO se introduce un código y el continente es "Todos", 
    // debes agregar una lógica aquí para modificar 'sql'. Por ejemplo:
    /*
    if (continenteSeleccionado.equals("Todos")) {
        sql = "SELECT codigoPais, nombrePais, continentePais, poblacionPais, tipoGobierno FROM Pais";
    } else {
        sql = "SELECT codigoPais, nombrePais, continentePais, poblacionPais, tipoGobierno FROM Pais WHERE continentePais = ?";
    }
    */
    sql = "SELECT codigoPais, nombrePais, continentePais, poblacionPais, tipoGobierno FROM Pais WHERE continentePais = ?";
}

// Se usa try-with-resources para Connection y PreparedStatement
try (Connection conn = Conexion.ConexionBD.conectar();
     PreparedStatement ps = conn.prepareStatement(sql)) {

    // Se asignan los parámetros
    if (buscarPorCodigo) {
        ps.setString(1, codigoBuscado);
    } else {
        // Se maneja el caso donde el continente podría no ser un parámetro si la lógica superior lo modifica (ej. "Todos")
        /*
        if (!continenteSeleccionado.equals("Todos")) {
            ps.setString(1, continenteSeleccionado);
        }
        */
        ps.setString(1, continenteSeleccionado);
    }

    // Se ejecuta la consulta
    ResultSet rs = ps.executeQuery();

    boolean hayResultados = false;

    // Se procesan los resultados
    while (rs.next()) {
        hayResultados = true;

        // Se obtienen los datos. Usar getInt y getBoolean directamente puede ser más limpio si la columna 
        // NO acepta NULLS, pero el código original ya maneja bien los objetos para NULLS.
        String codigo = rs.getString("codigoPais");
        String nombre = rs.getString("nombrePais");
        String continente = rs.getString("continentePais");
        
        // Manejo de valores que pueden ser NULL en la BD
        // El código original ya maneja esto correctamente
        Object poblacionObj = rs.getObject("poblacionPais");
        Integer poblacion = (poblacionObj != null) ? (Integer) poblacionObj : null;

        Object tipoGobiernoObj = rs.getObject("tipoGobierno");
        // Si tipoGobierno es BIT o BOOLEAN, se puede usar rs.getBoolean, pero rs.getObject y casting es más robusto si es nullable.
        // Se asume el mismo manejo del original: un Boolean (TRUE/FALSE) o NULL.
        Boolean tipoGobierno = (tipoGobiernoObj != null) ? (Boolean) tipoGobiernoObj : null; 

        // Se preparan los datos para la fila de la tabla
        Object[] fila = {
            (codigo != null ? codigo : "N/A"),
            (nombre != null ? nombre : "N/A"),
            (continente != null ? continente : "N/A"),
            (poblacion != null ? poblacion.toString() : "N/A"), // Convertir Integer a String para la tabla
            // Mapeo del booleano a texto
            (tipoGobierno != null ? (tipoGobierno ? "Democracia" : "Otro") : "N/A")
        };

        model.addRow(fila);
    }

    // Mostrar mensaje si no hay resultados
    if (!hayResultados) {
        JOptionPane.showMessageDialog(this,
            "No se encontraron países con ese criterio.",
            "Sin resultados",
            JOptionPane.INFORMATION_MESSAGE);
    }

} catch (Exception e) {
    // Manejo de errores de conexión o SQL
    JOptionPane.showMessageDialog(this,
        "Error al consultar: " + e.getMessage(),
        "Error de Base de Datos",
        JOptionPane.ERROR_MESSAGE);
}
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        //Acá codificará el Evento para Crear un País.
    }//GEN-LAST:event_btnCrearActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        //Acá codificará el Evento para Actualizar un País.
    }//GEN-LAST:event_btnModificarActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed
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
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnComparar;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnConsultarCiudad;
    private javax.swing.JButton btnConsultarIdioma1;
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox<String> cboxContinente;
    private javax.swing.JCheckBox chkTipoGobierno;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelCiudades;
    private javax.swing.JPanel jPanelCiudades1;
    private javax.swing.JPanel jPanelPaises;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableCiudades;
    private javax.swing.JTable jTableCiudades1;
    private javax.swing.JTable jTableCiudades2;
    private javax.swing.JTable jTableCiudades3;
    private javax.swing.JTable jTablePais;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPoblacion;
    // End of variables declaration//GEN-END:variables
}
