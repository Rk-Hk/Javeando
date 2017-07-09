

package ReportePdf;
import static ConexionMysql.ConexionMsql.ConectarMysql;
import java.sql.Connection;

import java.sql.Statement;
import javax.swing.JOptionPane;
//import net.sf.jasperreports.engine.JRException;
//import net.sf.jasperreports.engine.JasperCompileManager;
//import net.sf.jasperreports.engine.JasperExportManager;
//import net.sf.jasperreports.engine.JasperFillManager;
//import net.sf.jasperreports.engine.JasperPrint;
//import net.sf.jasperreports.engine.JasperReport;
//import net.sf.jasperreports.view.JasperViewer;

public class Reportes {

    Connection conexion;
    Statement instrucion;

    public Reportes() {
        
    }

//METODO PARA EXPORTAR A PDF UN REPORTE   

    public static void  ExportarReportes(String ruta) {
          
      Connection con = ConectarMysql();
        try {
            
//                 
//                 JasperReport  reporte = JasperCompileManager.compileReport(ruta);
//                  JasperPrint print = JasperFillManager.fillReport(reporte,null,con);
//                  JasperViewer.viewReport(print, false);
// TODO add your handling code here:
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"No se pudo Abrir el Reporte!!");
          // Logger.getLogger(JframeRegistoUsuarioAdmin.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    }
    public  static void  CerrarReporte(){
    
       
    }

   
}
