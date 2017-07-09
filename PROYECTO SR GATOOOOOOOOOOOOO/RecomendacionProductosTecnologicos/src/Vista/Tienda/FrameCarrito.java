/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Tienda;

import Entidad.Complementos;
import Entidad.Compra;
import Entidad.Impresora;
import Entidad.Laptop;
import Entidad.Pc;
import Entidad.Producto;
import Entidad.Tablet;
import PaqueteEstructuras.PilaListaGenerica;
import static Vista.Tienda.TiendaVirtual.lscarrito;
import javax.swing.JPanel;

/**
 *
 * @author RIKARDO
 */
public class FrameCarrito extends javax.swing.JFrame {

    /**
     * Creates new form FrameCarrito
     */
    public static PilaListaGenerica<Producto> lscarro;
    public static double imp;

    public FrameCarrito() {
        lscarro = new PilaListaGenerica<>();
        imp = 0;
//        lscarro=lscarrito;
        initComponents();
        setResizable(false);
        ConvertiraPila();
        ApilandoProductos();
        jLabel1.setText(imp + "");
        this.setBounds(0, 0, 600, 390);
        this.setResizable(false);
        this.setLocationRelativeTo(this);

    }

    public void ConvertiraPila() {
        System.out.println(lscarrito.size());
        Producto pro = new Producto();
        for (int i = 0; i < lscarrito.size(); i++) {
            pro = lscarrito.get(i);
            lscarro.insertarDato(pro);
        }
    }

    public JPanel RetornarPilaLap(Laptop lap1, int x, int y) {
        PilaLaptop plap = new PilaLaptop(lap1);
        plap.setBounds(x, y, 540, 40);
        plap.setVisible(true);
        return plap;
    }

    public JPanel RetornarPilaImpre(Impresora lap1, int x, int y) {
        PilaImpresora plap = new PilaImpresora(lap1);
        plap.setBounds(x, y, 540, 40);
        plap.setVisible(true);
        return plap;
    }

    public JPanel RetornarPilaPc(Pc lap1, int x, int y) {
        PilaPc plap = new PilaPc(lap1);
        plap.setBounds(x, y, 540, 40);
        plap.setVisible(true);
        return plap;
    }

    public JPanel RetornarPilaComplementos(Complementos lap1, int x, int y) {
        PilaComplementos plap = new PilaComplementos(lap1);
        plap.setBounds(x, y, 540, 40);
        plap.setVisible(true);
        return plap;
    }

    public JPanel RetornarPilaTablet(Tablet lap1, int x, int y) {
        PilaTablet plap = new PilaTablet(lap1);
        plap.setBounds(x, y, 540, 40);
        plap.setVisible(true);
        return plap;
    }

    public void ApilandoProductos() {
        JPanel d[] = new JPanel[50];
        Laptop lap = null;
        Tablet tab = null;
        Pc pc = null;
        Impresora impre = null;
        Complementos comle = null;
        int x = 0, y = 0, m = 0;

//        while(!lscarro.estaVacia()){
//            System.out.println(lscarro.getDatoCima());
        System.out.println("lscar" + lscarrito.size());
        for (int i = 0; i < lscarrito.size(); i++) {
            if (lscarro.getDatoCima() instanceof Laptop) {
                System.out.println("Entre lap");
                lap = (Laptop) lscarro.getDatoCima();
                imp = imp + lap.getPrecio();
                d[m] = RetornarPilaLap(lap, x, y);
            }
            if (lscarro.getDatoCima() instanceof Impresora) {
                System.out.println("Entre imp");
                impre = (Impresora) lscarro.getDatoCima();
                imp = imp + impre.getPrecio();
                d[m] = RetornarPilaImpre(impre, x, y);
            }
            if (lscarro.getDatoCima() instanceof Tablet) {
                System.out.println("Entre tab");
                tab = (Tablet) lscarro.getDatoCima();
                imp = imp + tab.getPrecio();
                d[m] = RetornarPilaTablet(tab, x, y);
            }
            if (lscarro.getDatoCima() instanceof Pc) {
                System.out.println("Entre pc");
                pc = (Pc) lscarro.getDatoCima();
                imp = imp + pc.getPrecio();
                d[m] = RetornarPilaPc(pc, x, y);
            }
            if (lscarro.getDatoCima() instanceof Complementos) {
                System.out.println("Entre comp");
                comle = (Complementos) lscarro.getDatoCima();
                lscarro.sacarDato();
                imp = imp + comle.getPrecio();
                d[m] = RetornarPilaComplementos(comle, x, y);
            }

            y = y + 45;
            jPanel2.add(d[m]);
            m++;
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setPreferredSize(new java.awt.Dimension(600, 370));

        jButton1.setText("Comprar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Volver");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 581, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 309, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanel2);

        jLabel2.setText("Precio Total:  $");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(109, 109, 109)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        PanelCarro panCar = new PanelCarro();
        panCar.setVisible(true);
        

//aqui mandamos a la base de datos los productos para el usuario !!
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();


    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(FrameCarrito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameCarrito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameCarrito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameCarrito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameCarrito().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
