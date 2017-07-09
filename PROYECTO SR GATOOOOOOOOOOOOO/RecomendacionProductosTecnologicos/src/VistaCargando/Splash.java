
package VistaCargando;

import GrafoCaminoCorto.GrafoEmpresa;
import Vista.Inicio;
import de.javasoft.plaf.synthetica.SyntheticaBlackEyeLookAndFeel;
import java.text.ParseException;
//import de.javasoft.plaf.synthetica.SyntheticaBlackEyeLookAndFeel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Splash extends javax.swing.JFrame implements Runnable {

    int num = 0;
    Thread t;

    public Splash() {
        initComponents();
       // setIconImage(new ImageIcon(getClass().getResource("../Imagen/logoFinal.PNG")).getImage());
        setTitle("R2N INMOBILIARIA");
        Barra.setVisible(false);
        setIconImage(new ImageIcon(getClass().getResource("../Imagenes/LogoSR.PNG")).getImage());
    }

    public void Llena_Barra() {
        if (Barra.getValue() <= 100) {
            num += 3;//Valor con el que se va llenar el ProgressBar. Se llenará de 3 en 3
            //Le podemos dar un valor mas alto para que se llene mas rapido o un valor mas bajo
            //para que se llene mas lento
            Barra.setValue(num);
            Barra.setStringPainted(true);
            if(Barra.getValue()==30){
                jLabel2.setText("Conectando con la BD ...");
            }
            if(Barra.getValue()==60){
                jLabel2.setText("Cargando Informacion ...");
            }
            if(Barra.getValue()==90){
                jLabel2.setText("            Welcome");
            }
        } else {
            Barra.setValue(0);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        Barra = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SplashScreen con JProgressBar");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Conectando con la BD...");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, 300, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cool-loading-animated-gif-1.gif"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 250));
        jPanel1.add(Barra, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 260, 10));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Hilo hl = new Hilo(this);
        hl.start();
    }//GEN-LAST:event_formWindowOpened

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Splash().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar Barra;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    public void run() {
        try {
            this.setLocationRelativeTo(null);
            this.setVisible(true);
            t.sleep(6000);//Tiempo que deseamos que se muestre nuestro Splash: 6000 milisegundos = 6 segundos
                         //Debemos ajustarlo bien para que nuestro Splash desaparezaca justo cuando el ProgressBar
                        //acabe de llenarse.
            this.dispose();
            UIManager.setLookAndFeel(new SyntheticaBlackEyeLookAndFeel());
            Inicio i = new Inicio();
            i.setVisible(true);
            
            
//            frmPrincipal p = new frmPrincipal();
//            p.setLocationRelativeTo(null);
//            p.setVisible(true);
        } catch (InterruptedException ex) {
            Logger.getLogger(Splash.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Splash.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Splash.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
