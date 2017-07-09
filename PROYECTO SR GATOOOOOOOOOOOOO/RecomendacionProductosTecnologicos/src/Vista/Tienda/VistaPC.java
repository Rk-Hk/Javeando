/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista.Tienda;

import Entidad.Pc;
import static Vista.Tienda.TiendaVirtual.lsPc;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Jeremy
 */


public class VistaPC extends javax.swing.JPanel {

    /**
     * Creates new form VistaPC
     */
    
    static Pc PcPatodo;
    
    
    private int desli;
    
    public VistaPC() {
        initComponents();
        setBounds(0, 0, 242, 519);
        etiquetaValor.setText(jSdeslisador.getValue()+"");
        PcPatodo=null;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSdeslisador = new javax.swing.JSlider();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        etiquetaValor = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        jRadioButton7 = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jRadioButton8 = new javax.swing.JRadioButton();
        jRadioButton9 = new javax.swing.JRadioButton();
        jRadioButton10 = new javax.swing.JRadioButton();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Caracteristicas "));

        jLabel1.setText("Marca");

        jLabel2.setText("Precio Maximo");

        jSdeslisador.setMajorTickSpacing(100);
        jSdeslisador.setMaximum(5000);
        jSdeslisador.setMinimum(1000);
        jSdeslisador.setPaintTicks(true);
        jSdeslisador.setValue(3000);
        jSdeslisador.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSdeslisadorStateChanged(evt);
            }
        });

        jLabel3.setText("1000");

        jLabel4.setText("5000");

        etiquetaValor.setText("0.00");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione", "Ubuntu", "Windows", "Mac", "Personalizado" }));

        jLabel5.setText("S.O");

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        buttonGroup2.add(jRadioButton5);
        jRadioButton5.setText("250");

        buttonGroup2.add(jRadioButton6);
        jRadioButton6.setText("500");

        buttonGroup2.add(jRadioButton7);
        jRadioButton7.setText("1 ");
        jRadioButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton7ActionPerformed(evt);
            }
        });

        jLabel6.setText("Disco Duro");

        jLabel7.setText("Ram");

        buttonGroup3.add(jRadioButton8);
        jRadioButton8.setText("4");

        buttonGroup3.add(jRadioButton9);
        jRadioButton9.setText("8");

        buttonGroup3.add(jRadioButton10);
        jRadioButton10.setText("16");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione", "Lenovo", "Toshiba", "hp", "asus", "sony" }));

        jLabel8.setText("T");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(etiquetaValor)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jSdeslisador, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel4)))
                                    .addComponent(jButton1)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(jRadioButton5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRadioButton6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRadioButton7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jRadioButton8)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButton9)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButton10))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etiquetaValor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSdeslisador, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton5)
                    .addComponent(jRadioButton6)
                    .addComponent(jRadioButton7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton8)
                    .addComponent(jRadioButton9)
                    .addComponent(jRadioButton10))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(46, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jSdeslisadorStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSdeslisadorStateChanged
        etiquetaValor.setText(jSdeslisador.getValue()+"");
        desli=jSdeslisador.getValue();
    }//GEN-LAST:event_jSdeslisadorStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String marca,so;
        double precio;
        int ram=0,discoduro=0,i=0;
        boolean bol = false;
        
        ArrayList<Pc> profin = new ArrayList<>();
        Pc lapaux= new Pc();
        
        if(jRadioButton5.isSelected())
            ram=Integer.parseInt(jRadioButton5.getText());
        else
            if(jRadioButton6.isSelected())
                ram=Integer.parseInt(jRadioButton6.getText());
            else
                if(jRadioButton7.isSelected())
                    ram=Integer.parseInt(jRadioButton7.getText());
        
        if(jRadioButton8.isSelected())
            discoduro=Integer.parseInt(jRadioButton8.getText());
        else
            if(jRadioButton9.isSelected())
                discoduro=Integer.parseInt(jRadioButton9.getText());
            else
                if(jRadioButton10.isSelected())
                    discoduro=Integer.parseInt(jRadioButton10.getText());
                
        if(jComboBox1.getSelectedItem().toString().equalsIgnoreCase("Seleccione") || jComboBox2.getSelectedItem().toString().equalsIgnoreCase("Seleccione")
                || ram==0 || discoduro ==0){
            JOptionPane.showMessageDialog(this, "Revise todos los campos", "REGISTRO", JOptionPane.ERROR_MESSAGE);
        }else{
            
            so=jComboBox1.getSelectedItem().toString();
            marca=jComboBox2.getSelectedItem().toString();
            precio=desli;
            PcPatodo= new Pc(so, ram, discoduro, null, precio, marca, null, null, 0, null);
            
            
            while(i<lsPc.size()){
                lapaux = lsPc.get(i);
                if(PcPatodo.getSO().equalsIgnoreCase(lapaux.getSO())&& PcPatodo.getMarca().equalsIgnoreCase(lapaux.getMarca())&& 
                   PcPatodo.getDiscoDuro()==lapaux.getDiscoDuro()&& PcPatodo.getRam()==lapaux.getRam()&&PcPatodo.getPrecio()<=lapaux.getPrecio()){
                    profin.add(lapaux);
                    bol=true;
                }
                i++;
            }
            
            TiendaVirtual.LimpiaPanel();
            if(bol){
                TiendaVirtual.MostrarProductos(profin);
            }else{
                JOptionPane.showMessageDialog(this, "NO SE ENCONTRARON PCs CON ESAS CARACTERISTICAS", "LO SENTIMOS :c", JOptionPane.PLAIN_MESSAGE);
            }
            TiendaVirtual.ActualizaPanel();
            
            
            
            
            
            
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jRadioButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton7ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JLabel etiquetaValor;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JRadioButton jRadioButton10;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JRadioButton jRadioButton8;
    private javax.swing.JRadioButton jRadioButton9;
    private javax.swing.JSlider jSdeslisador;
    // End of variables declaration//GEN-END:variables
}
