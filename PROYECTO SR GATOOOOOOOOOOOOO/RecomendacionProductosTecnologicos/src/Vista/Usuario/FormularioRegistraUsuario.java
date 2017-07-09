/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista.Usuario;

import Entidad.Usuario;
//import Negocio.GestorAdmin;
import Negocio.GestorPrincipal;
import UtilJava.*;
//import Vista.Tienda.*;
import java.io.FileInputStream;
import javax.swing.JOptionPane;

/**
 *
 * @author RIKARDO
 */
public class FormularioRegistraUsuario extends javax.swing.JPanel {

    /**
     * Creates new form FormularioRegistraUsuario
     */
    boolean iniciocesion;
    public int edad , celular,dni,longitud;
    public  String apepater,apemater,correo,nombre,usuario,contrasena;
    public  FileInputStream foto ;
    
    Usuario usu;
    public FormularioRegistraUsuario() {
        initComponents();
        setBounds(0, 0, 680, 429);
        iniciocesion=false;
        usu= new Usuario();
        
        Validaciones.SoloLetras(jTextField2);
        Validaciones.SoloLetras(jTextField3);
        Validaciones.SoloLetras(jTextField4);
        Validaciones.SoloNumeros(jTextField1);
        Validaciones.SoloNumeros(jTextField5);
        Validaciones.SoloNumeros(jTextField9);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jBexaminar = new javax.swing.JButton();
        jButtonTomar = new javax.swing.JButton();
        jButtonRegistrar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Registre sus Datos Correctamente : "));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("DNI :");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 65, -1));
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, 134, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Nombre : ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 65, -1));
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 120, 134, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("A.Paterno :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, -1, -1));
        jPanel1.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 150, 134, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("A.Materno :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, -1, -1));
        jPanel1.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 180, 134, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Celular :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 210, 65, -1));
        jPanel1.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 210, 134, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("E-Mail :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 240, 65, -1));
        jPanel1.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 240, 134, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Usuario :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 270, 65, -1));
        jPanel1.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 270, 134, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Password :");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 300, 65, -1));
        jPanel1.add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 300, 134, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/user.png"))); // NOI18N
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 100, -1, -1));

        jBexaminar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBexaminar.setText("Examinar");
        jBexaminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBexaminarActionPerformed(evt);
            }
        });
        jPanel1.add(jBexaminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 300, -1, -1));

        jButtonTomar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonTomar.setText("Tomar");
        jPanel1.add(jButtonTomar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 300, -1, -1));

        jButtonRegistrar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonRegistrar.setText("Registrar");
        jButtonRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistrarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 370, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("edad :");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 330, 65, -1));
        jPanel1.add(jTextField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 330, 134, -1));

        jLabel11.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("REGISTRO DE USUARIOS");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 40, 268, 25));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ReistroUsuario.jpg"))); // NOI18N
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 430));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBexaminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBexaminarActionPerformed
        ClaseCargarImagen.CargandoImagen(usu, jLabel9, jPanel1);
    }//GEN-LAST:event_jBexaminarActionPerformed

    private void jButtonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistrarActionPerformed
        boolean a=false;
        boolean c=false;
        boolean b=false;
        try{
            if(Integer.parseInt(jTextField1.getText())>40000000 && Integer.parseInt(jTextField1.getText())<99999999){
                usu.setDni(Integer.parseInt(jTextField1.getText()));
                a=true;
            }
            usu.setNombre(jTextField2.getText());
            usu.setApell_paterno(jTextField3.getText());
            usu.setApell_materno(jTextField4.getText());
            usu.setCorreo(jTextField6.getText());

            if(Integer.parseInt(jTextField9.getText())>18 && Integer.parseInt(jTextField9.getText())<65){
                usu.setEdad(Integer.parseInt(jTextField9.getText()));
                b=true;
            }
            if(Integer.parseInt(jTextField5.getText())>900000000 && Integer.parseInt(jTextField5.getText())<1000000000){
                usu.setCelular(Integer.parseInt(jTextField5.getText()));
                c=true;
            }
            usu.setUser(jTextField7.getText());
            usu.setPassword(jTextField8.getText());

    ////        boolean check = GestorPrincipal.getGestorUsuario().RegistrarUsuario(usu);
    //        boolean check=GestorPrincipal.getGestorUsuario().ExisteUsuario(dni);
            if(a&&b&&c){
                boolean ok = GestorPrincipal.getGestorUsuario().RegistrarUsuario(usu);
                if(ok)
                    JOptionPane.showMessageDialog(null, "Gracias Por Regitrarse !! ", "Registro Completo", JOptionPane.YES_OPTION);
            }
            else
                JOptionPane.showMessageDialog(null, "Revice su DNI o los datos Ingresados :D !! ", "Error en el REgitro", JOptionPane.ERROR_MESSAGE);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "RELLENE LOS CAMPOS !! ", "Error en el REgitro", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jButtonRegistrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBexaminar;
    private javax.swing.JButton jButtonRegistrar;
    private javax.swing.JButton jButtonTomar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}