

package Vista.Tienda;

import ConexionMysql.Dao;
import Entidad.Complementos;
import Entidad.Impresora;
import Entidad.Laptop;
import Entidad.Pc;
import Entidad.Producto;
import Entidad.Tablet;
import Entidad.Usuario;
import Negocio.GestorPrincipal;
import UtilJava.SobreponePanel;
import Vista.Inicio;
import static Vista.Tienda.FrameIniciarCesion.usuarioregistrado;
import Vista.Usuario.FormularioRegistraUsuario;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import Algoritmica3.ArbolAvl;
import Algoritmica3.Backtraking;
import Algoritmica3.InsertionSort;
import javax.swing.JLabel;

public final class TiendaVirtual extends javax.swing.JFrame {
   
    
    private Usuario usuario;
    
    private ArbolAvl ab;// 1 = inicio secion 2= no inicio
    ArrayList<Producto> pro2;
    static ArrayList<Producto> lscarrito;
    
    static ArrayList<Laptop> lsLap;
    static ArrayList<Tablet> lsTap;
    static ArrayList<Pc> lsPc ;
    static ArrayList<Impresora> lsImpresora;
    static ArrayList<Complementos> lsComplementos;
    private Producto[][] matriz;
    private int filas,colum;
    private InsertionSort ordenando;
    
     
    public TiendaVirtual() {
        
        initComponents();
        setResizable(false);
        filas=3;
        colum=50;
        matriz = new Producto[filas][colum];
        lscarrito= new ArrayList<>();
        lsLap= Dao.getDaoLaptop().ListarLaptop();
        lsTap= Dao.getDaoTablet().ListarTablet();
        lsPc = GestorPrincipal.getGestorPc().lsPc();
        lsImpresora = GestorPrincipal.getGestorImpresora().lsImpresoras();
        lsComplementos=GestorPrincipal.getGestorComple().lsComplementos();
        OrdenarPorCampos();
//        ab= new abb();
        setLocationRelativeTo(null);
        setResizable(false);
        pro2 = new ArrayList<>();
        SobreponePanel.SobrePonerPAnel(jPanEnviaInfo, new PanelImagen());
        jPanel1.setBorder(BorderFactory.createTitledBorder("-->> Recomendados... <<--"));
        usuario=usuarioregistrado;
        
        ab= new ArbolAvl();
        ordenando= new InsertionSort();
        if(usuario==null){//no ha iniciado secion
            jMenu5.setEnabled(false);
            jMenu6.setEnabled(false);
            jMenu4.setEnabled(true);
            jMenu3.setEnabled(true);
        }
        else{
            jMenu5.setEnabled(true);
            jMenu6.setEnabled(true);
            jMenu4.setEnabled(false);
            jMenu3.setEnabled(false);
        }
        
//        ListarRecomendados();
//        LlenandoArbol();
        Ordenando();
        MostrarProductos(pro2);
        
    }
      public  void OrdenarPorCampos(){
    
    InsertionSort.InsercionDirectaPc(lsPc);
    InsertionSort.InsercionDirectaImpresoras(lsImpresora);
    InsertionSort.InsercionDirectaTablet(lsTap);
    InsertionSort.InsercionDirectalaptop(lsLap);
    
    }

    public static JPanel RetornaPanelLaptop(Laptop lap,int x,int y){

        JMiniPanelLaptop jp1 = new JMiniPanelLaptop(lap);
        jp1.setBounds(x,y,180,240);
        jp1.setVisible(true);
        return jp1;
    }
    
    public static JPanel RetornaPanelTablet(Tablet lap,int x,int y){

        JMiniPaneTablet jp1 = new JMiniPaneTablet(lap);
        jp1.setBounds(x,y,180,240); 
        jp1.setVisible(true);
        return jp1;
    }
    
    public static JPanel RetornaPanelPc(Pc lap,int x,int y){

        JMiniPanelPc jp1 = new JMiniPanelPc(lap);
        jp1.setBounds(x,y,180,240); 
        jp1.setVisible(true);
        return jp1;
    }
    
    public static JPanel RetornaPanelComplementos(Complementos comp,int x,int y){

        JMiniPanelComplemntos jp1 = new JMiniPanelComplemntos(comp);
        jp1.setBounds(x,y,180,240); 
        jp1.setVisible(true);
        return jp1;
    }
    
    public static JPanel RetornaPanelImpresora(Impresora imp,int x,int y){

        JMiniPanelImpresora jp1 = new JMiniPanelImpresora(imp);
        jp1.setBounds(x,y,180,240); 
        jp1.setVisible(true);
        return jp1;
    }
    public static JPanel RetornaSolucion(int x,int y,Backtraking back){

        Separador jp1 = new Separador(back);
        jp1.setBounds(x,y,583,45); 
        jp1.setVisible(true);
        return jp1;
    }
    
    public static JPanel Separador(int i,int x,int y,int t){

        Soluciones jp1 = new Soluciones(i,t);
        jp1.setBounds(x,y,583,45); 
        jp1.setVisible(true);
        return jp1;
    }
     
     
     public static void MostrarPaquetes ( ArrayList<Producto> pro,Backtraking back){
        try {
       
       //ArrayList<JPanel> c = new ArrayList<>();
        JPanel c [] = new JPanel[pro.size()];
        ArrayList<JPanel> LsTodos = new ArrayList<>();
        int x=35,y=78,contador=0,k=-1,t=0;
        int z=35,w=30;
        Laptop lap;
        Tablet tab;
        Pc pc;
        Complementos comp;
        Impresora imp;
        
        jPanel1.add(RetornaSolucion(z, w,back));
        int sol = 0;
        for(int i=0; i<back.getSolucion();i++){
            jPanel1.add(Separador(i,x, y,back.getSolucion()));
            y=y+50;
            for(int j=0; j<back.getS().length;j++){
                if(back.getSol(i,j)==1){
                    if(pro.get(j) instanceof Laptop){
                        k++;
                        lap= Dao.getDaoLaptop().PrecioLaptop((int)pro.get(j).getPrecio());
                        //c[k]=RetornaPanelLaptop(lap, x, y);
                        LsTodos.add(RetornaPanelLaptop(lap, x, y));
                     
                    }
                    if(pro.get(j) instanceof Tablet){
                        k++;    
                        tab= Dao.getDaoTablet().PrecioTablet((int)pro.get(j).getPrecio());
                        //c[k]=RetornaPanelTablet(tab, x, y);
                        LsTodos.add(RetornaPanelTablet(tab, x, y));
                    }

                    if(pro.get(j) instanceof Pc){
                        k++;    
                        pc=Dao.getDaoPc().PrecioPc((int)pro.get(j).getPrecio());
                        // c[k]=RetornaPanelPc(pc, x, y);
                        LsTodos.add(RetornaPanelPc(pc, x, y));
                    }

                    if(pro.get(j) instanceof Complementos){
                        k++;
                        comp=Dao.getDaoComple().PrecioComplementos((int)pro.get(j).getPrecio());
                       // c[k]=RetornaPanelComplementos(comp, x, y);
                        LsTodos.add(RetornaPanelComplementos(comp, x, y));
                    }
                    if(pro.get(j) instanceof Impresora){
                        k++;
                        imp=Dao.getDaoImpresora().PrecioImpresora((int)pro.get(j).getPrecio());
                       // c[k]=RetornaPanelImpresora(imp, x, y);
                        LsTodos.add(RetornaPanelImpresora(imp, x, y));
                    }
                    
                    if(contador>= 0 && contador <2 && sol==back.getSolucion()){
                        x=x+200;
                        contador++;
                    }else{
                        x=35;
                        y=y+250;
                        contador=0;
                    }
                }
                
                sol++;
                
                
            }
            
            
        }
    
      for(int h=0; h<LsTodos.size();h++){
               jPanel1.add(LsTodos.get(h));
      }
     
        }catch(Exception e ){
            System.out.println(e);
        }
        
    }
    public void Ordenando(){
        if(lsLap!=null && lsTap !=null && lsPc!=null && lsComplementos!= null && lsImpresora!=null){
            int i=0,j=0;
            while(j<lsLap.size()){
                pro2.add(lsLap.get(j));
                j++;
            }
            j=0;
            while(j<lsTap.size()){
                pro2.add(lsTap.get(j));
                j++;
            }
            j=0;
            while(j<lsPc.size()){
                pro2.add(lsPc.get(j));
                j++;
            }
            j=0;
            while(j<lsComplementos.size()){
                pro2.add(lsComplementos.get(j));
                j++;
            }
            j=0;
            while(j<lsImpresora.size()){
                pro2.add(lsImpresora.get(j));
                j++;
            }
            
            ordenando.InsercionDirecta(pro2);
            
        }
    }
    public void LlenandoArbol(){
        if(lsLap!=null && lsTap !=null && lsPc!=null && lsComplementos!= null && lsImpresora!=null){
        int i=0,j=0;
        while(i<lsLap.size()){
            ab.insertar(lsLap.get(i));
            i++;
        }
        while(j<lsTap.size()){
            ab.insertar(lsTap.get(j));
            j++;
        }
        j=0;
        while(j<lsPc.size()){
            ab.insertar(lsPc.get(j));
            j++;
        }
        j=0;
        while(j<lsComplementos.size()){
            ab.insertar(lsComplementos.get(j));
            j++;
        }
        j=0;
        while(j<lsImpresora.size()){
            ab.insertar(lsImpresora.get(j));
            j++;
        }
        ab.invertOrden();
        //obtiene el arraylist creao anteriormente
        pro2=ab.retornar();
        
    }else{
            JOptionPane.showMessageDialog(this, "No se encontraron Productos,Revice su base de datos !!!", "ERROR AL CARGAR PRODUCTOS", JOptionPane.ERROR_MESSAGE);
        }
    }
  
    
    public void ordenado(){
        
    }
    
    public static void MostrarProductos(ArrayList pro){
        System.out.println(pro.size());
        try {
        //Crea un arraylist
        
        JPanel c[]=new JPanel[50];
        int x=35,y=30,contador=0;
        Laptop lap= new Laptop();
        Tablet tab = new  Tablet();
        Pc pc=new Pc();
        Complementos comp=new Complementos();
        Impresora imp = new Impresora();
        
        for(int m=0;m<pro.size();m++){
            if(pro.get(m) instanceof Laptop){
                lap=(Laptop) pro.get(m);
                System.out.println(lap.getPreferencia());
                c[m]=RetornaPanelLaptop(lap, x, y);
            }
            if(pro.get(m) instanceof Tablet){
                tab=(Tablet) pro.get(m);
                System.out.println(tab.getPreferencia());
                c[m]=RetornaPanelTablet(tab, x, y);
            }
            if(pro.get(m) instanceof Pc){
                pc=(Pc) pro.get(m);
                System.out.println(pc.getPreferencia());
                c[m]=RetornaPanelPc(pc, x, y);
            }
            if(pro.get(m) instanceof Complementos){
                comp=(Complementos) pro.get(m);
                System.out.println(comp.getPreferencia());
                c[m]=RetornaPanelComplementos(comp, x, y);
            }
            if(pro.get(m) instanceof Impresora){
                imp=(Impresora) pro.get(m);
                System.out.println(imp.getPreferencia());
                c[m]=RetornaPanelImpresora(imp, x, y);
            }
            if(contador>= 0 && contador <2){
                x=x+200;
                contador++;
            }
            else{
                x=35;
                y=y+250;
                contador=0;
            }
            jPanel1.add(c[m]);
        }
        }catch(Exception e ){
            System.out.println(e);
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

        jPanEnviaInfo = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuPc = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuTablet = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        jMenuComplementos = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        jMenuImpresora = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        jMenuItem5 = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanEnviaInfo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanEnviaInfoLayout = new javax.swing.GroupLayout(jPanEnviaInfo);
        jPanEnviaInfo.setLayout(jPanEnviaInfoLayout);
        jPanEnviaInfoLayout.setHorizontalGroup(
            jPanEnviaInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 234, Short.MAX_VALUE)
        );
        jPanEnviaInfoLayout.setVerticalGroup(
            jPanEnviaInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 13000));
        jPanel1.setRequestFocusEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 13000, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 754, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/botonlogo.png"))); // NOI18N
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Prod_now.jpg"))); // NOI18N
        jMenu2.add(jSeparator2);

        jMenuPc.setText("PC's");
        jMenuPc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuPcActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuPc);
        jMenu2.add(jSeparator1);

        jMenuTablet.setText("Tablet");
        jMenuTablet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuTabletActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuTablet);
        jMenu2.add(jSeparator4);

        jMenuComplementos.setText("Complementos");
        jMenuComplementos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuComplementosActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuComplementos);
        jMenu2.add(jSeparator5);

        jMenuImpresora.setText("Impresoras");
        jMenuImpresora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuImpresoraActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuImpresora);
        jMenu2.add(jSeparator6);

        jMenuItem5.setText("Laptop's");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);
        jMenu2.add(jSeparator3);

        jMenuItem1.setText("Paquetes");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuBar1.add(jMenu2);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/registrate.png"))); // NOI18N
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu3MouseClicked(evt);
            }
        });
        jMenu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu3ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu3);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Login_Is.png"))); // NOI18N
        jMenu4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu4MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu4);

        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ver_carro.png"))); // NOI18N
        jMenu5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu5MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu5);

        jMenu6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/loginout.png"))); // NOI18N
        jMenu6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu6MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu6);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanEnviaInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanEnviaInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel2.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuPcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuPcActionPerformed
        jPanEnviaInfo.removeAll();
        jPanel1.removeAll();
        SobreponePanel.SobrePonerPAnel(jPanEnviaInfo,new VistaPC());

        MostrarProductos(lsPc);
    }//GEN-LAST:event_jMenuPcActionPerformed

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        Inicio i = new Inicio();
        i.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenu1MouseClicked

    private void jMenu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseClicked

        if(usuario==null){
            jMenu3.setEnabled(true);
            SobreponePanel.SobrePonerPAnel(jPanel2, new FormularioRegistraUsuario());
        }
        else
            jMenu3.setEnabled(false);
    }//GEN-LAST:event_jMenu3MouseClicked

    private void jMenu4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu4MouseClicked
                
        if(usuario==null){   // no inicio secion
            jMenu4.setEnabled(true);
            FrameIniciarCesion fi = new FrameIniciarCesion(jPanel2);
            fi.setVisible(true);
            this.setVisible(false);
        }else{
            jMenu4.setEnabled(false);
        }
    }//GEN-LAST:event_jMenu4MouseClicked

    private void jMenu5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu5MouseClicked
        if(usuario!=null){//Si ha iniciado sesion
            jMenu5.setEnabled(true);
            JOptionPane.showMessageDialog(this, "SUS COMPRAS SON :D Sr : "+usuario.getNombre(), "INICIE SESION", JOptionPane.WARNING_MESSAGE);
            // accion que se quiere realizar
            FrameCarrito carrito = new FrameCarrito();
            carrito.setVisible(true);
        }else{
            
            jMenu5.setEnabled(false);
            JOptionPane.showMessageDialog(this, "Porfavor Inicie Sesion o Registrese :D ", "INICIE SESION", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jMenu5MouseClicked

    private void jMenu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu3ActionPerformed
        
    }//GEN-LAST:event_jMenu3ActionPerformed

    private void jMenu6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu6MouseClicked
        if(usuario!=null){//Si ha iniciado sesion
            jMenu5.setEnabled(true);
            Usuario us=null;
            usuarioregistrado=us;
            TiendaVirtual tien = new TiendaVirtual();
            tien.setVisible(true);
            dispose();
        }else{
            jMenu5.setEnabled(false);
            JOptionPane.showMessageDialog(this, "Porfavor Inicie Sesion o Registrese :D ");
        }
    }//GEN-LAST:event_jMenu6MouseClicked

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        jPanEnviaInfo.removeAll();
        jPanel1.removeAll();
        SobreponePanel.SobrePonerPAnel(jPanEnviaInfo,new VistaLaptop());

        MostrarProductos(lsLap);


    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuTabletActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuTabletActionPerformed
        jPanEnviaInfo.removeAll();
        jPanel1.removeAll();
        SobreponePanel.SobrePonerPAnel(jPanEnviaInfo,new VistaTablet());

        MostrarProductos(lsTap);
    }//GEN-LAST:event_jMenuTabletActionPerformed

    private void jMenuImpresoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuImpresoraActionPerformed
        jPanEnviaInfo.removeAll();
        jPanel1.removeAll();
        SobreponePanel.SobrePonerPAnel(jPanEnviaInfo,new VistaImpresora());

        MostrarProductos(lsImpresora);
    }//GEN-LAST:event_jMenuImpresoraActionPerformed

    private void jMenuComplementosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuComplementosActionPerformed
        jPanEnviaInfo.removeAll();
        jPanel1.removeAll();
        SobreponePanel.SobrePonerPAnel(jPanEnviaInfo,new VistaComplementos());

        MostrarProductos(lsComplementos);
    }//GEN-LAST:event_jMenuComplementosActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
  jPanEnviaInfo.removeAll();
        jPanel1.removeAll();
        SobreponePanel.SobrePonerPAnel(jPanEnviaInfo,new PanelPaquete());
       TiendaVirtual.LimpiaPanel();        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    
    static void LimpiaPanel(){
        jPanel1.removeAll();
    }
    static void ActualizaPanel(){
        jPanel1.updateUI();
    }
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
            java.util.logging.Logger.getLogger(TiendaVirtual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TiendaVirtual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TiendaVirtual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TiendaVirtual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TiendaVirtual().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuComplementos;
    private javax.swing.JMenuItem jMenuImpresora;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuPc;
    private javax.swing.JMenuItem jMenuTablet;
    private javax.swing.JPanel jPanEnviaInfo;
    private static javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    // End of variables declaration//GEN-END:variables
}
