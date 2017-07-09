package UtilJava;


import Entidad.Compra;
import java.util.ArrayList;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class Grafica
{
    
    public void graficar( ArrayList<Compra> ls,String titulo)
    {   Compra com=null;
       
       DefaultPieDataset data = new DefaultPieDataset();
        
        for(int d=0;d<ls.size();d++)  
           
        {    com= ls.get(d);
           data.setValue(com.getNombreProducto(),com.getTotal());  
        }
        JFreeChart chart = ChartFactory.createPieChart(titulo,data,true,true,true);
        ChartFrame frame=new ChartFrame(titulo,chart);
        frame.pack();
        frame.setVisible(true);
    }
     public void graficarbarras(ArrayList<Compra> ls,String datah,String datav,String titulo)
        {
        Compra com = null;
       DefaultCategoryDataset data = new DefaultCategoryDataset();
        for(int d=0;d<ls.size();d++)
        { com = ls.get(d);
         data.setValue(com.getTotal(),com.getNombreProducto(),com.getNombreProducto());  
        }
        JFreeChart chart = ChartFactory.createBarChart(titulo,datah,datav,data, PlotOrientation.VERTICAL, false,true, false);
        ChartFrame frame=new ChartFrame(titulo,chart);
        frame.pack();
        frame.setVisible(true);
    }   
   
  
    
    
}