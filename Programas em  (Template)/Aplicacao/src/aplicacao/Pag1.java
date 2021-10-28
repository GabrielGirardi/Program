/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacao;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.sql.*;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


/**
 *
 * @author gabriel.girardi
 */
public class Pag1 extends javax.swing.JPanel {

    /**
     * Creates new form Pag1
     */
    public Pag1() {
        initComponents();
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
        CustID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        CustName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        CustNum = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jLabel1.setText("ID do Cliente:");

        jLabel2.setText("Nome Completo:");

        jLabel3.setText("Telefone:");

        CustNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CustNumActionPerformed(evt);
            }
        });

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Gerar PDF");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(CustID, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CustName, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CustNum, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                        .addComponent(jButton2)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(CustID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(CustName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CustNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(57, 57, 57))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     try {
                 String url = "jdbc:mysql://localhost:3306/SalesOrdersExample";
                 String user ="root";
                 String pass = "1001";
                 
                 Connection conn = DriverManager.getConnection(url, user, pass);
                 Statement stmt = conn.createStatement();
                 String Query = "SELECT * FROM customers WHERE CustomerID = '"+CustID.getText()+"'";
                 ResultSet rs = stmt.executeQuery(Query);
                 while(rs.next()){
                     CustName.setText(rs.getString(2) + " " + rs.getString(3));
                     CustNum.setText(rs.getString(8) + " " + rs.getString(9));
                 }
     }catch(SQLException e){
         JOptionPane.showMessageDialog(null, e.toString());
     }   
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       String path = "";
       JFileChooser j = new JFileChooser();
       j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
       int x = j.showSaveDialog(this);
       if(x == JFileChooser.APPROVE_OPTION){
           
           path = j.getSelectedFile().getPath();
       }                                      
        try {
         String url = "jdbc:mysql://localhost:3306/SalesOrdersExample";
         String user ="root";
         String pass = "1001";
         String infor = "";
         Connection conn = DriverManager.getConnection(url, user, pass);
         Statement stmt = conn.createStatement();
          String Query = "SELECT \n" 
              +"          CONCAT('O cliente ID ',\n"
              +"                    CustomerID,\n"
              +"                    ' se chama: ',\n" 
              +"                    CustFirstName,\n"
              +"                     ' ',\n"
              +"                    CustLastName,\n"                   
              +"                    'mora em ',\n"                   
              +"                    CustStreetAddress,\n"           
              +"                    ' na cidade ',\n "                   
              +"                    CustCity,\n"            
              +"                    '/',\n"                   
              +"                    CustState,\n"          
              +"                    'CEP: ',\n"        
              +"                    CustZipCode,\n"          
              +"                    '-',\n"
              +"                    CustAreaCode,\n"          
              +"                   ', o numero do contato: ',\n"          
              +"                 CustPhoneNumber) As relatorio\n"
              +   "FROM\n"
              +"   customers\n"        
              +"Where CustomerID = '"+CustID.getText()+"';";
      
              ResultSet rs = stmt.executeQuery(Query);
               while(rs.next()){
                   infor = rs.getString(1);
               }
                 String file_name = path + "\\" + CustID.getText()+CustName.getText()+".pdf";
            
                
                   Document doc = new Document();
                   PdfWriter.getInstance(doc, new FileOutputStream(file_name));
                   doc.open();
                   Paragraph pa = new Paragraph (infor);
                   doc.add(pa);
                   doc.close();
                   System.out.println("Save complete");
       
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.toString());
        
         }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.toString());
}
    }//GEN-LAST:event_jButton2ActionPerformed

    private void CustNumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CustNumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CustNumActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CustID;
    private javax.swing.JTextField CustName;
    private javax.swing.JTextField CustNum;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
