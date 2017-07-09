/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UtilJava;

import Entidad.Producto;
import Entidad.Usuario;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author nelsoncuenta
 */
 
public class ClaseCargarImagen {
     public static  int clicFoto =0;
   
    public static ImageIcon PasarImagenIcon(Image ima, javax.swing.JLabel label){
    ImageIcon imagen= new ImageIcon(ima.getScaledInstance(label.getWidth(),label.getHeight(),Image.SCALE_DEFAULT));
 return imagen;
}
  public static ImageIcon PasarImagenIcon2(Image ima){
    ImageIcon imagen= new ImageIcon(ima.getScaledInstance(100,100,Image.SCALE_DEFAULT));
 return imagen;
}   
public static void leerImagen(File f,javax.swing.JLabel jlabel){
    try {
      BufferedImage entrada=ImageIO.read(f); // image
     jlabel.setIcon(PasarImagenIcon(entrada,jlabel));
     jlabel.updateUI();
     //this.jLabel11.setIcon(new ImageIcon(entrada));
        } catch(Exception e){
        JOptionPane.showMessageDialog(null,"El arhivo seleccionado \n  no es una imagen!");
    }
}
public static void CargandoImagen(Usuario usu ,javax.swing.JLabel label, javax.swing.JPanel panel){
     FileNameExtensionFilter filtro = new FileNameExtensionFilter("Solo Archivos tipo: jpeg ","jpeg","jpg");
     JFileChooser jfc = new JFileChooser();
          
     jfc.addChoosableFileFilter(filtro);
     int selection= jfc.showOpenDialog(panel);
      if(selection==JFileChooser.APPROVE_OPTION){
          try {
             
              FileInputStream foto= new FileInputStream(jfc.getSelectedFile());
              usu.setFotoCarnet(foto);
              
              int longitud=(int) jfc.getSelectedFile().length();
              usu.setLongitudFoto(longitud);
              
          } catch (Exception e) {
              JOptionPane.showMessageDialog(null,"No se pudo obtener la direccion de la Foto");
          }
          leerImagen(jfc.getSelectedFile(),label);
          
               
      }}

public static void CargandoImagen(Producto usu , String ruta){
          try {
               
              FileInputStream foto= new FileInputStream(ruta);
              usu.setImageProduc(foto);
              clicFoto=1;
              usu.setLongitud(ruta.length());
              
          } catch (Exception e) {
              JOptionPane.showMessageDialog(null,"No se pudo obtener la direccion de la Foto");
          }

}
public static void CargandoImagenProducto(Producto usu ,javax.swing.JLabel label, javax.swing.JPanel panel){
     FileNameExtensionFilter filtro = new FileNameExtensionFilter("Solo Archivos tipo: jpeg ","jpeg","jpg");
     JFileChooser jfc = new JFileChooser();
          
     jfc.addChoosableFileFilter(filtro);
     int selection= jfc.showOpenDialog(panel);
      if(selection==JFileChooser.APPROVE_OPTION){
          try {
               
              FileInputStream foto= new FileInputStream(jfc.getSelectedFile());
              System.out.println(jfc.getSelectedFile().toString());
              usu.setImageProduc(foto);
              clicFoto=1;
              
              int longitud=(int) jfc.getSelectedFile().length();
              usu.setLongitud(longitud);
              
          } catch (Exception e) {
              JOptionPane.showMessageDialog(null,"No se pudo obtener la direccion de la Foto");
          }
          leerImagen(jfc.getSelectedFile(),label);
          
               
      }
}


     //metodo que dada una cadena de bytes la convierte en una imagen con extension jpeg
    public static Image ConvertirImagenByte(byte[] bytes) throws IOException {
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        Iterator readers = ImageIO.getImageReadersByFormatName("jpeg");
        ImageReader reader = (ImageReader) readers.next();
        Object source = bis; // File or InputStream
        ImageInputStream iis = ImageIO.createImageInputStream(source);
        reader.setInput(iis, true);
        ImageReadParam param = reader.getDefaultReadParam();
        return reader.read(0, param);
    }
    
             
   
    
}
