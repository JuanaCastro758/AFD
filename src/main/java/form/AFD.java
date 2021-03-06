/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import VerificarAFD.Tokens;
import documento.Documento;
import documento.MetodoDocumento;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Chiko malo
 */
public class AFD extends javax.swing.JFrame {

    /**
     * Creates new form AFD
     */
    public static String doc="";
    public static String[] lineas;
    String[][] palabra=new String[20][20];
    private int fila=0;
    private int columna=0;
    String[][] lista=new String[20][6];
    int f0=0,f1=0,f2=0,f3=0,f4=0,f5=0;
    int p1=0,p2=0;
    boolean error=false;
    DefaultTableModel modelo=new DefaultTableModel();
    public AFD() {
        initComponents();
        this.setLocationRelativeTo(null);
        mostrarArchivo();
        insertar();
        modelo.addColumn("Identificador");
        modelo.addColumn("Numero");
        modelo.addColumn("Decimal");
        modelo.addColumn("Puntuacion");
        modelo.addColumn("Operador");
        modelo.addColumn("Agrupacion");
        this.jTable1.setModel(modelo);
        agregar();
        
    }
    public void mostrarArchivo(){
        Nuevo_Archivo doc1=new Nuevo_Archivo();
        Archivo doc2=new Archivo();
        MetodoDocumento metodos=new MetodoDocumento();
        doc=metodos.verificarDoc(doc1.documento, doc2.nombre);
        Documento leer=new Documento(doc);
        jTextArea1.append(leer.leer());
        extraerPalabras(leer.leer());
        
    }
    
    public void extraerPalabras(String cadena){
        String newCadena="";
        for(int i=0;i<(cadena.length());i++){
            if(cadena.charAt(i)!=' ' && cadena.charAt(i)!='\n'){
                newCadena=newCadena+cadena.charAt(i);
            } else {
                if(cadena.charAt(i)==' '){
                    palabra[fila][columna]=newCadena;
                    newCadena="";
                    columna++;
                    p1++;
                }
                if(cadena.charAt(i)=='\n'){
                    fila++;
                    columna=0;
                }
            }
        }
    }
    
    public void insertar(){
        //lista columna:      0            1        2          3           4           5       
        //              Identificador | Entero | Decimal | Puntuacion | Operador | Agrupacion  
        Tokens token=new Tokens();
        for(int i=0;i<20;i++){
            for(int j=0;j<20;j++){
                if(palabra[i][j]!=null){
                    if(token.numero(palabra[i][j])==true){
                        //numero Enteros columna 1
                        lista[f1][1]="[ "+(i+1)+" ][ "+(j+1)+" ]   "+palabra[i][j];
                        f1++; p2++;
                    }else if(token.letra(palabra[i][j])==true){
                        //identificador Columna 0
                        lista[f0][0]="[ "+(i+1)+" ][ "+(j+1)+" ]   "+palabra[i][j];
                        f0++; p2++;
                    }else if(token.signo(palabra[i][j])==true){
                        //signo puntuacion columna 3
                        lista[f3][3]="[ "+(i+1)+" ][ "+(j+1)+" ]   "+palabra[i][j];
                        f3++; p2++;
                    }else if(token.operador(palabra[i][j])==true){
                        //Operador columna 4
                        lista[f4][4]="[ "+(i+1)+" ][ "+(j+1)+" ]   "+palabra[i][j];
                        f4++; p2++;
                    }else if(token.signoAgrupacion(palabra[i][j])==true){
                        //signo de agrupacion columna 5
                        lista[f5][5]="[ "+(i+1)+" ][ "+(j+1)+" ]   "+palabra[i][j];
                        f5++; p2++;
                    }else if(token.decimal(palabra[i][j])==true){
                        //verificar numero decimal columna 2
                        lista[f2][2]="[ "+(i+1)+" ][ "+(j+1)+" ]   "+palabra[i][j];
                        f2++; p2++;
                    }else{
                        //manejar los erroresencontados
                        error=true;
                        jTextArea3.append("[ "+(i+1)+" ][ "+(j+1)+" ]   "+palabra[i][j]+"\n");
                    }
                    
                }/**/
            }
        }
    }
    
    public void agregar(){
        if(error==false){
            int x=0;
            String[] datos=new String[6];
            for(int i=0;i<20;i++){
                datos[0]=lista[i][0];
                datos[1]=lista[i][1];
                datos[2]=lista[i][2];
                datos[3]=lista[i][3];
                datos[4]=lista[i][4];
                datos[5]=lista[i][5];
                modelo.addRow(datos);
            }
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

        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jLabel1.setText("AUTOMATA FINITO DETERMINISTA");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, -1, -1));

        jButton2.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jButton2.setText("Inicio");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 102, 0));
        jPanel1.setForeground(new java.awt.Color(102, 0, 255));

        jPanel2.setBackground(new java.awt.Color(255, 102, 0));
        jPanel2.setForeground(new java.awt.Color(102, 0, 255));
        jPanel1.add(jPanel2);

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Tempus Sans ITC", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("------------Busqueda de Patrones------------");
        jPanel1.add(jLabel6);

        jPanel3.setBackground(new java.awt.Color(255, 102, 0));
        jPanel3.setForeground(new java.awt.Color(102, 0, 255));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Tempus Sans ITC", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("------------Busqueda de Patrones------------");
        jPanel3.add(jLabel9);

        jPanel4.setBackground(new java.awt.Color(255, 102, 0));
        jPanel4.setForeground(new java.awt.Color(102, 0, 255));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Tempus Sans ITC", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("------------Busqueda de Patrones------------");
        jPanel4.add(jLabel10);

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Tempus Sans ITC", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("------------Busqueda de Patrones------------");
        jPanel4.add(jLabel11);

        jPanel3.add(jPanel4);

        jPanel1.add(jPanel3);

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Tempus Sans ITC", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("------------Busqueda de Patrones------------");
        jPanel1.add(jLabel12);

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Tempus Sans ITC", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("------------Busqueda de Patrones------------");
        jPanel1.add(jLabel13);

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Tempus Sans ITC", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("------------Busqueda de Patrones------------");
        jPanel1.add(jLabel14);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 350, 30));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 160, 30));

        jButton3.setBackground(new java.awt.Color(204, 0, 0));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Buscar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 380, -1, -1));

        jTextArea2.setEditable(false);
        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, 280, 110));

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(204, 204, 255));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane4.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 433, 237));

        jTable1.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 70, 830, 230));

        jPanel5.setBackground(new java.awt.Color(255, 153, 0));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Tempus Sans ITC", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("[ Fila ][ Columna ]------------------------Reporte de Tokens------------------------");
        jPanel5.add(jLabel8);

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 30, 830, 30));

        jPanel6.setBackground(new java.awt.Color(255, 0, 0));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Tempus Sans ITC", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("-------------------Reporte de errores-------------------");
        jPanel6.add(jLabel7);

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 320, 460, 30));

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jScrollPane3.setViewportView(jTextArea3);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 360, 340, 150));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try{
            Inicio seleccion1=new Inicio();
            seleccion1.setVisible(true);
            this.setVisible(false);
        }catch(Exception e){
            System.out.println(e.getMessage()+"Error en el boton inicio");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try{
            jTextArea2.setText("");
            String text=jTextField1.getText();
            for(int i=0;i<20;i++){
                for(int j=0;j<20;j++){
                    if(palabra[i][j]!=null){
                        int y=0;
                        for(int x=0;x<text.length();x++){
                            String letra=""+text.charAt(x);
                            if(letra.equalsIgnoreCase(""+palabra[i][j].charAt(x))){
                                y++;
                            }
                        }
                        if(y==text.length()){
                            jTextArea2.append("[ "+(i+1)+" ][ "+(j+1)+" ]   "+palabra[i][j]+"\n");
                        }
                    }
                }
            }
        }catch(Exception e){
            System.out.println("Error en la busqueda de patrones, bonton 3 "+e);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(AFD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AFD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AFD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AFD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AFD().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
