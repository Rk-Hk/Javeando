

package Vista.Admin;

import Entidad.Impresora;
import Negocio.GestorPrincipal;
import ReportePdf.Reportes;
import static UtilJava.ClaseCargarImagen.CargandoImagenProducto;
import static UtilJava.ClaseCargarImagen.PasarImagenIcon;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
 
/**
 *
 * @author nelsoncuenta
 */
public class JframeRegistoImpresoras extends javax.swing.JFrame {
       
    /**
     * Creates new form JframeRegistro_Usuario
     */
    private int clicFoto=0;
    DefaultTableModel  modelo;
    
    String data[][]={};
    // String tipo, String serie, double precio, String marca, String modelo, String descripcion
    String columna[]={"serie","Tipo","Marca","Modelo","Precio","Preferencia"};
    
   
    public int preferencia=0;
    public Double precio;
    public String serie, marca,modeloImpre,descripcion;
    public  FileInputStream foto ;
    Impresora usu;
 
 
    public JframeRegistoImpresoras() {
        initComponents();
        usu = new Impresora();
        modelo = new  DefaultTableModel(data, columna);
        jTable2.setModel(modelo);
        //usu =new Usuario(nombre, apepater, apemater, edad, celular, dni, longitud, correo, foto, apepater, usuario);
        CargandoTablaimpresoras();
        // Validaciones.SoloNumeros(jTextField8);
         setLocationRelativeTo(null);
         jButton4.setEnabled(false);
         jButton10ActualizaBD.setEnabled(false);
        
         
         
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox2 = new javax.swing.JComboBox();
        jButton6 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jTextField10 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton10ActualizaBD = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setBackground(new java.awt.Color(204, 0, 255));
        jLabel1.setFont(new java.awt.Font("Calibri", 1, 30)); // NOI18N
        jLabel1.setText("   ADMINISTRAR REGISTROS IMPRESORAS");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(153, 153, 153), null), "Datos de la Impresora", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(204, 0, 0))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("SERIE");

        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("MARCA");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("MODELO");

        jTextField3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("DESCRIPCION");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("PRECIO:");

        jTextField8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("TIPO");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("FOTO DE LA IMPRESORA");

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/user.png"))); // NOI18N
        jLabel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/picture-24.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("SUBIR FOTO ");

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 9)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/rotate-32.png"))); // NOI18N
        jButton2.setText("LIMPIAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/documents_folder-24.png"))); // NOI18N

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/contacts-24.png"))); // NOI18N

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/contacts-24.png"))); // NOI18N

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jRadioButton1.setText("ACTUALIZAR FOTO B.D");
        jRadioButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jRadioButton1MousePressed(evt);
            }
        });

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jRadioButton2.setText("ACTUALIZAR DATOS  B.D");
        jRadioButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jRadioButton2MousePressed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione", "Canon", "HP", "Sansung", "Epson" }));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione", "Tinta Continua", "Laser", "Ploters" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jRadioButton1)
                        .addGap(12, 12, 12)
                        .addComponent(jRadioButton2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel20)
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jComboBox2, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(46, 46, 46))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jButton2)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel12)
                        .addGap(10, 10, 10)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel18))
                .addGap(126, 126, 126))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel16)
                        .addGap(16, 16, 16)
                        .addComponent(jLabel20))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel10)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12)
                                    .addComponent(jRadioButton2)
                                    .addComponent(jRadioButton1)))
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel13)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(4, 4, 4))
        );

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 9)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/search-24.png"))); // NOI18N
        jButton6.setText("BUSCAR /SERIE");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 9)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/close-24.png"))); // NOI18N
        jButton3.setText("SALIR ");
        jButton3.setToolTipText("");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 9)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/add_user-32.png"))); // NOI18N
        jButton1.setText("REGISTRAR");
        jButton1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTextField10MousePressed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/mysql.png"))); // NOI18N
        jButton4.setText("ACTUALIZA FOTO B.D");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 9)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_cup-24.png"))); // NOI18N
        jButton7.setText("ELIMINAR");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Tahoma", 1, 9)); // NOI18N
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Adobe_Acrobat.png"))); // NOI18N
        jButton8.setText("VER REPORTE");
        jButton8.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel14.setBackground(new java.awt.Color(255, 255, 51));
        jLabel14.setFont(new java.awt.Font("Segoe UI Black", 1, 25)); // NOI18N
        jLabel14.setText("Lista de Impresoras");

        jTable2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable2.setSelectionBackground(new java.awt.Color(255, 204, 0));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTable2MousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable2);

        jButton10ActualizaBD.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jButton10ActualizaBD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/mysql2.png"))); // NOI18N
        jButton10ActualizaBD.setText("ACTUALIZA DATOS B.D");
        jButton10ActualizaBD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActualizaBDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(240, 240, 240)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 1158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6)
                        .addGap(42, 42, 42)
                        .addComponent(jButton1)
                        .addGap(36, 36, 36)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(jButton8)
                        .addGap(64, 64, 64)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(440, 440, 440)
                        .addComponent(jLabel14))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton10ActualizaBD, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 967, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(jButton10ActualizaBD, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(151, 151, 151))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
  
    
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        this.clicFoto=1;
        CargandoImagenProducto(usu, jLabel11, jPanel2); 
        
       
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        limpiarCampos();
        jTextField10.setText("");
        this.jButton1.setEnabled(true);
        this.jButton6.setEnabled(true);
        this.jTextField1.requestFocus();
        this.buttonGroup1.clearSelection();
        

    }//GEN-LAST:event_jButton2ActionPerformed
    
    
    
    
    
    
    public  void CargandoTablaimpresoras(){
         Impresora usu=null;
      
        ArrayList<Impresora> lsImpresora= GestorPrincipal.getGestorImpresora().lsImpresoras();
       
        
        if(lsImpresora.size()==-1){
            JOptionPane.showMessageDialog(this,"No hay ninguna Impresora Registrada!!");
            
        }
        else{
        

        for(int i=0; i<lsImpresora.size(); i++){
              usu=lsImpresora.get(i);
             
                    String b[]= {usu.getSerie(),
                                usu.getTipo(),
                                usu.getMarca(),
                                usu.getModelo(),
                                String.valueOf(usu.getPrecio()),
                                String.valueOf(usu.getPreferencia())
                                                                }  ;
                      modelo.addRow(b);
            }
        }
   }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(jComboBox1.getSelectedItem().toString().equalsIgnoreCase("Seleccione") || jComboBox2.getSelectedItem().toString().equalsIgnoreCase("Seleccione")){
            JOptionPane.showMessageDialog(this, "Rellene Todos Los campos !! ", "ERROR DE REGISTRO", JOptionPane.ERROR_MESSAGE);
        }else{
            usu.setSerie(jTextField1.getText());
            usu.setMarca(jComboBox1.getSelectedItem().toString());
            usu.setModelo(jTextField3.getText());
            usu.setTipo(jComboBox2.getSelectedItem().toString());
            usu.setDescripcion(jTextArea1.getText());
            usu.setPrecio(Double.parseDouble(jTextField8.getText()));
            usu.setPreferencia(preferencia);
        
        }

        boolean estado =GestorPrincipal.getGestorImpresora().RegistrarImpresora(usu);
        
        if(estado){
           JOptionPane.showMessageDialog(this,"Registro Exitoso!!");
           String  a[] = {jTextField1.getText(),
                         jComboBox1.getSelectedItem().toString(),
                         jComboBox2.getSelectedItem().toString(),
                         jTextField3.getText(),
                         jTextArea1.getText(),
                         jTextField8.getText(), 
                             "0"
                          };
            modelo.addRow(a);
         
            limpiarCampos();
        }

          
         this.jTextField1.requestFocus();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
         Impresora usu;
         String  BusqueSerie=jTextField10.getText();
         try{
         usu =GestorPrincipal.getGestorImpresora().BuscarLaptop(BusqueSerie);
         ///.-------
         jTextField1.setText(usu.getSerie());
         jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { usu.getMarca()}));
         jTextField3.setText(usu.getModelo());
         jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { usu.getTipo()}));
         jTextArea1.setText(usu.getDescripcion());
         jTextField8.setText(String.valueOf(usu.getPrecio()));
         jLabel11.setIcon(PasarImagenIcon(usu.getFotovuelta(),jLabel11));
    }catch(Exception e ){
       
        JOptionPane.showMessageDialog(null,"LA SERIE INGRESADA NO SE ENCUENTRA REGISTRADA !! ","ERROR",JOptionPane.ERROR_MESSAGE);
            }        
       
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
         boolean modificado=false;
     int fila = jTable2.getSelectedRow();
     if(fila==-1){
     JOptionPane.showMessageDialog(this,"Selecciones una fila","ALERTA",JOptionPane.WARNING_MESSAGE);
     }
     else {
       
        
         
         String serieTabla = jTable2.getValueAt(fila,0).toString();
      int ordenImpresora= GestorPrincipal.getGestorImpresora().OrdenImpresora(serieTabla);
      
        usu.setSerie(jTextField1.getText());
        usu.setMarca(jComboBox1.getSelectedItem().toString());
            
        usu.setModelo(jTextField3.getText());
        usu.setTipo(jComboBox2.getSelectedItem().toString());
        usu.setDescripcion(jTextArea1.getText());
        usu.setPrecio(Double.parseDouble(jTextField8.getText()));
        
         modificado = GestorPrincipal.getGestorImpresora().ModificarImpresoraConFoto(usu,ordenImpresora);
       
          // modificando la tabla de Impresoras
             //serie
             jTable2.setValueAt(jTextField1.getText(),fila,0);
             //tipo
             jTable2.setValueAt(jComboBox1.getSelectedItem().toString(),fila,1);
             //marca
             jTable2.setValueAt(jComboBox2.getSelectedItem().toString(),fila,2);
             //modelo
             jTable2.setValueAt(jTextField3.getText(),fila,3);
             // descripcion
             jTable2.setValueAt(jTextArea1.getText(),fila,4);
             //precio
             jTable2.setValueAt(jTextField8.getText(),fila,5);
             // preferencia
           
       
             if(modificado){
             JOptionPane.showMessageDialog(this,"Moficacion de los Datos Exitoso!!!!");}
                           

     
             
     // limpiamos todo 
            
             
              limpiarCampos();
              this.jTextField1.requestFocus();
              jButton6.setEnabled(true);
              jButton1.setEnabled(true);
     }
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
 
        boolean estado=false;   
        int filaSelec = jTable2.getSelectedRow();
        String  SerieTabla=  modelo.getValueAt(filaSelec,0).toString();
          //int dniTabla= (int) modelo.getValueAt(filaSelec,0);

        if(filaSelec==-1){
            JOptionPane.showMessageDialog(this,"Seleccione una Fila!!","Error",JOptionPane.WARNING_MESSAGE);
        }else {
            try{ 
            int resp=JOptionPane.showConfirmDialog(this,"¿ Desea eliminar la Fila?","Eliminar",JOptionPane.YES_NO_OPTION);
              if(resp == JOptionPane.YES_OPTION){
                  modelo.removeRow(filaSelec);
                  estado=GestorPrincipal.getGestorImpresora().Eliminar(SerieTabla);
                   if(estado){
                        JOptionPane.showMessageDialog(this,"Se Elimino !!! la Fila");
                   }

                  }

            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"No pudo eliminar la Fila!!!!","Error",JOptionPane.ERROR_MESSAGE);
            }
            limpiarCampos();
        }
 
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jTextField10MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField10MousePressed
        limpiarCampos();
        this.jButton1.setEnabled(true);
        this.jButton6.setEnabled(true);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/user.png")));    

    }//GEN-LAST:event_jTextField10MousePressed

    private void jTable2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MousePressed
        Impresora usu=null;
        limpiarCampos();
        this.jButton1.setEnabled(false);
        this.jButton6.setEnabled(false);
        try{
            int  fila = jTable2.getSelectedRow();

            String TablaSerie =  jTable2.getValueAt(fila,0).toString();

            usu = GestorPrincipal.getGestorImpresora().BuscarLaptop(TablaSerie);
            jTextField1.setText(usu.getSerie());
            jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { usu.getMarca() }));
            jTextField3.setText(usu.getModelo());
            jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { usu.getTipo() }));
            jTextArea1.setText(usu.getDescripcion());
            jTextField8.setText(String.valueOf(usu.getPrecio()));
            jLabel11.setIcon(PasarImagenIcon(usu.getFotovuelta(),jLabel11));

        }catch(Exception e){
            JOptionPane.showMessageDialog(this,"Selecciones solo una Fila!!","Alerta",JOptionPane.WARNING_MESSAGE);

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable2MousePressed

    private void jRadioButton1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton1MousePressed
        jButton4.setEnabled(true);
        jButton5.setEnabled(true);
        jButton10ActualizaBD.setEnabled(false);
        

// TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1MousePressed

    private void jRadioButton2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton2MousePressed
       
        jButton5.setEnabled(false);
        jButton4.setEnabled(false);
        jButton10ActualizaBD.setEnabled(true);
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione", "Canon", "HP", "Sansung", "Epson" }));
       jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione", "Tinta Continua", "Laser", "Ploters" }));
        
             // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton2MousePressed

    private void jButton10ActualizaBDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActualizaBDActionPerformed
   // TODO add your handling code here:
        boolean modificado=false;
        int fila = jTable2.getSelectedRow();
        if(fila==-1){
        JOptionPane.showMessageDialog(this,"Selecciones una fila","ALERTA",JOptionPane.WARNING_MESSAGE);
        }
        else {



            String serieTabla = jTable2.getValueAt(fila,0).toString();
         int ordenImpresora= GestorPrincipal.getGestorImpresora().OrdenImpresora(serieTabla);

           usu.setSerie(jTextField1.getText());
           usu.setMarca(jComboBox1.getSelectedItem().toString());
           usu.setModelo(jTextField3.getText());
           usu.setTipo(jComboBox2.getSelectedItem().toString());
           usu.setDescripcion(jTextArea1.getText());
           usu.setPrecio(Double.parseDouble(jTextField8.getText()));

            modificado = GestorPrincipal.getGestorImpresora().ModificarImpresoraSinFoto(usu,ordenImpresora);

             // modificando la tabla de Impresoras
                //serie
                jTable2.setValueAt(jTextField1.getText(),fila,0);
                //tipo
                jTable2.setValueAt(jComboBox1.getSelectedItem().toString(),fila,1);
                //marca
                jTable2.setValueAt(jComboBox2.getSelectedItem().toString(),fila,2);
                //modelo
                jTable2.setValueAt(jTextField3.getText(),fila,3);
                // descripcion
                jTable2.setValueAt(jTextArea1.getText(),fila,4);
                //precio
                jTable2.setValueAt(jTextField8.getText(),fila,5);
                // preferencia


                if(modificado){
                JOptionPane.showMessageDialog(this,"Moficacion de los Datos Exitoso!!!!");}




        // limpiamos todo 


                 limpiarCampos();
               this.jTextField1.requestFocus();
                jButton6.setEnabled(true);
                jButton1.setEnabled(true);
        }
        
// TODO add your handling code here:
    }//GEN-LAST:event_jButton10ActualizaBDActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        Reportes.ExportarReportes("impresora.jrxml");
    }//GEN-LAST:event_jButton8ActionPerformed
public  void limpiarCampos(){
        this.jTextField1.setText("");
        
       jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione", "Canon", "HP", "Sansung", "Epson" }));
       jTextField3.setText("");
       jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione", "Tinta Continua", "Laser", "Ploters" }));
       this.jTextField8.setText("");
       this.jTextArea1.setText("");
     
       
       jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/user.png")));
}
   
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
            java.util.logging.Logger.getLogger(JframeRegistoImpresoras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JframeRegistoImpresoras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JframeRegistoImpresoras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JframeRegistoImpresoras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JframeRegistoImpresoras().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10ActualizaBD;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField8;
    // End of variables declaration//GEN-END:variables
}
