/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author strange
 */
public class SignupEmple extends javax.swing.JFrame {
    Connection con =null;
    Statement stmt =null;
    
    public SignupEmple() {
        initComponents();
    }
    
     public void registrar()
   {
       String cadena1, cadena2, cadena3, cadena4,cadena5,cadena6,cadena7;    
      cadena1 = NameTxtFieldEmpl.getText(); //Nombre del empleado
      cadena2 = LastnPaTxtFieldEmpl.getText();//Apellido Paterno
      cadena3 = LastnMaTxtFieldEmpl.getText();//Apellido Materno
      cadena4 = PhoneTxtFieldEmpl.getText();//Telefono del empleado
      cadena5 = EmailTxtFieldEmpl.getText();//Correo del empleado
      cadena6 = UserTxtFieldEmpl.getText();//usuario para inciar sesion
      cadena7 = PassTxtFieldEmpl.getText();//contraseña para iniciar sesion

     if (cadena1.equals("") || (cadena2.equals("")) || (cadena3.equals("")) || (cadena4.equals("")) || (cadena5.equals("")) || (cadena6.equals("")) || (cadena7.equals(""))){
            
     javax.swing.JOptionPane.showMessageDialog(this,"Debe llenar todos los campos \n","AVISO!",javax.swing.JOptionPane.INFORMATION_MESSAGE);
     }
     
     else {
        try {
           
            LoginNutriSoft LG = new LoginNutriSoft();
            String url = LG.url;
            String usuario = LG.usuario;
            String contraseña = LG.contraseña; 
            System.out.print(url);
             Class.forName("com.mysql.cj.jdbc.Driver").newInstance(); 
             con = DriverManager.getConnection(url,usuario,contraseña); 
             if ( con != null ) 
                    System.out.println("Se ha establecido una conexión a la base de datos "); 
                  stmt = con.createStatement(); 
                  ResultSet rs = stmt.executeQuery("select* from empleados");
                        //primer registro
                      if(rs.next()==false)
                      {
                        stmt.executeUpdate("INSERT INTO empleados(`Nombre`, `Apellido Paterno`, `Apellido Materno`, `Telefono`, `correo electronico`, `usuario`, `contraseña`) VALUES('"+cadena1+"','"+cadena2+"','"+cadena3+"','"+cadena4+"','"+cadena5+"','"+cadena6+"','"+cadena7+"')");
                        System.out.println("Los valores han sido agregados a la base de datos");
                        javax.swing.JOptionPane.showMessageDialog(this,"Registro exitoso! \n","AVISO!",javax.swing.JOptionPane.INFORMATION_MESSAGE);
                      }
                      else
                      {
                          //checa que no exista un registro ya hecho con ese usuario
                          rs = stmt.executeQuery("Select* from empleados");
                          if(rs.next()==true)
                          {
                             rs = stmt.executeQuery("select* from empleados where usuario = '"+cadena6+"'");
                             if(rs.next()==true)
                                {
                                javax.swing.JOptionPane.showMessageDialog(this,"¡Ya se registro este usuario!\n","AVISO!",javax.swing.JOptionPane.INFORMATION_MESSAGE);
                                }
                             else
                                {
                                stmt.executeUpdate("INSERT INTO empleados(`Nombre`, `Apellido Paterno`, `Apellido Materno`, `Telefono`, `correo electronico`, `usuario`, `contraseña`) VALUES('"+cadena1+"','"+cadena2+"','"+cadena3+"','"+cadena4+"','"+cadena5+"','"+cadena6+"','"+cadena7+"')");
                                javax.swing.JOptionPane.showMessageDialog(this,"Registro exitoso! \n","AVISO!",javax.swing.JOptionPane.INFORMATION_MESSAGE);
                                }
                         }
                      }
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException ex) {}  
        
        finally {
            if (con != null) {
                try {
                    con.close();
                    stmt.close();
                } catch ( SQLException e ) { 
                         System.out.println( e.getMessage());
                }
            }
        }
         
        }
        this.NameTxtFieldEmpl.setText("");
        this.LastnPaTxtFieldEmpl.setText("");
        this.LastnMaTxtFieldEmpl.setText("");
        this.PhoneTxtFieldEmpl.setText("");  
        this.EmailTxtFieldEmpl.setText("");
        this.UserTxtFieldEmpl.setText("");
        this.PassTxtFieldEmpl.setText("");
        
      
   }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        HeaderRegEmpl = new javax.swing.JPanel();
        TitleRegEmpl = new javax.swing.JLabel();
        PanelRegEmpl = new javax.swing.JPanel();
        NameRegEmpl = new javax.swing.JLabel();
        LastnPatEmpl = new javax.swing.JLabel();
        LastnMaEmpl = new javax.swing.JLabel();
        PhoneEmpl = new javax.swing.JLabel();
        EmailEmpl = new javax.swing.JLabel();
        UserEmpl = new javax.swing.JLabel();
        PassEmpl = new javax.swing.JLabel();
        NameTxtFieldEmpl = new javax.swing.JTextField();
        LastnPaTxtFieldEmpl = new javax.swing.JTextField();
        LastnMaTxtFieldEmpl = new javax.swing.JTextField();
        PhoneTxtFieldEmpl = new javax.swing.JTextField();
        EmailTxtFieldEmpl = new javax.swing.JTextField();
        UserTxtFieldEmpl = new javax.swing.JTextField();
        PassTxtFieldEmpl = new javax.swing.JTextField();
        RegBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        HeaderRegEmpl.setBackground(new java.awt.Color(255, 255, 255));

        TitleRegEmpl.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        TitleRegEmpl.setText("REGISTRO DE EMPLEADOS");

        javax.swing.GroupLayout HeaderRegEmplLayout = new javax.swing.GroupLayout(HeaderRegEmpl);
        HeaderRegEmpl.setLayout(HeaderRegEmplLayout);
        HeaderRegEmplLayout.setHorizontalGroup(
            HeaderRegEmplLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderRegEmplLayout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(TitleRegEmpl)
                .addContainerGap(116, Short.MAX_VALUE))
        );
        HeaderRegEmplLayout.setVerticalGroup(
            HeaderRegEmplLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HeaderRegEmplLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(TitleRegEmpl)
                .addContainerGap())
        );

        getContentPane().add(HeaderRegEmpl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 400, 40));

        PanelRegEmpl.setBackground(new java.awt.Color(255, 255, 255));

        NameRegEmpl.setText("Nombre:");

        LastnPatEmpl.setText("Apellido paterno:");

        LastnMaEmpl.setText("Apellido materno:");

        PhoneEmpl.setText("Celular:");

        EmailEmpl.setText("Email:");

        UserEmpl.setText("Usuario:");

        PassEmpl.setText("Contraseña:");

        NameTxtFieldEmpl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                NameTxtFieldEmplKeyTyped(evt);
            }
        });

        LastnPaTxtFieldEmpl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                LastnPaTxtFieldEmplKeyTyped(evt);
            }
        });

        LastnMaTxtFieldEmpl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                LastnMaTxtFieldEmplKeyTyped(evt);
            }
        });

        PhoneTxtFieldEmpl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                PhoneTxtFieldEmplKeyTyped(evt);
            }
        });

        EmailTxtFieldEmpl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EmailTxtFieldEmplKeyTyped(evt);
            }
        });

        UserTxtFieldEmpl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                UserTxtFieldEmplKeyTyped(evt);
            }
        });

        PassTxtFieldEmpl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                PassTxtFieldEmplKeyTyped(evt);
            }
        });

        RegBtn.setText("Registrar");
        RegBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelRegEmplLayout = new javax.swing.GroupLayout(PanelRegEmpl);
        PanelRegEmpl.setLayout(PanelRegEmplLayout);
        PanelRegEmplLayout.setHorizontalGroup(
            PanelRegEmplLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelRegEmplLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(PanelRegEmplLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PassEmpl)
                    .addGroup(PanelRegEmplLayout.createSequentialGroup()
                        .addGroup(PanelRegEmplLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LastnPatEmpl)
                            .addComponent(NameRegEmpl))
                        .addGap(37, 37, 37)
                        .addGroup(PanelRegEmplLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(NameTxtFieldEmpl)
                            .addComponent(LastnPaTxtFieldEmpl, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)))
                    .addGroup(PanelRegEmplLayout.createSequentialGroup()
                        .addGroup(PanelRegEmplLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LastnMaEmpl)
                            .addComponent(PhoneEmpl)
                            .addComponent(EmailEmpl)
                            .addComponent(UserEmpl))
                        .addGap(35, 35, 35)
                        .addGroup(PanelRegEmplLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LastnMaTxtFieldEmpl, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                            .addComponent(PhoneTxtFieldEmpl)
                            .addComponent(EmailTxtFieldEmpl)
                            .addComponent(UserTxtFieldEmpl)
                            .addComponent(PassTxtFieldEmpl))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(RegBtn)
                .addContainerGap())
        );
        PanelRegEmplLayout.setVerticalGroup(
            PanelRegEmplLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelRegEmplLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelRegEmplLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NameRegEmpl)
                    .addComponent(NameTxtFieldEmpl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RegBtn))
                .addGap(18, 18, 18)
                .addGroup(PanelRegEmplLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LastnPatEmpl)
                    .addComponent(LastnPaTxtFieldEmpl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelRegEmplLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LastnMaEmpl)
                    .addComponent(LastnMaTxtFieldEmpl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelRegEmplLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PhoneEmpl)
                    .addComponent(PhoneTxtFieldEmpl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelRegEmplLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EmailEmpl)
                    .addComponent(EmailTxtFieldEmpl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelRegEmplLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UserEmpl)
                    .addComponent(UserTxtFieldEmpl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelRegEmplLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PassEmpl)
                    .addComponent(PassTxtFieldEmpl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        getContentPane().add(PanelRegEmpl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 400, 330));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void RegBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegBtnActionPerformed
        //Ejecuta la funcion de registrar 
        registrar();
    }//GEN-LAST:event_RegBtnActionPerformed

    private void PhoneTxtFieldEmplKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PhoneTxtFieldEmplKeyTyped
    char c = evt.getKeyChar();
         int numerocaracteres=10;
        
        if(PhoneTxtFieldEmpl.getText().length() >= numerocaracteres)
        {
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Solo se pueden 10 digitos en el telefono");
        }
        
        if((c<'0' || c> '9')) evt.consume();                                        
    }//GEN-LAST:event_PhoneTxtFieldEmplKeyTyped

    private void NameTxtFieldEmplKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NameTxtFieldEmplKeyTyped
    char c = evt.getKeyChar();
        int numerocaracteres=25;

        if(NameTxtFieldEmpl.getText().length() >= numerocaracteres)
        {
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Solo se pueden 25 digitos del nombre");
        }
        if((c<'a' || c>'z') && (c<'A' || c> 'Z') && (c<' ' || c> ' ') ) evt.consume();     // TODO add your handling code here:
    }//GEN-LAST:event_NameTxtFieldEmplKeyTyped

    private void LastnPaTxtFieldEmplKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_LastnPaTxtFieldEmplKeyTyped
        char c = evt.getKeyChar();
        int numerocaracteres=25;

        if(LastnPaTxtFieldEmpl.getText().length() >= numerocaracteres)
        {
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Solo se pueden 25 digitos del apellido paterno");
        }
        if((c<'a' || c>'z') && (c<'A' || c> 'Z') && (c<' ' || c> ' ') ) evt.consume();        // TODO add your handling code here:
    }//GEN-LAST:event_LastnPaTxtFieldEmplKeyTyped

    private void LastnMaTxtFieldEmplKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_LastnMaTxtFieldEmplKeyTyped
        char c = evt.getKeyChar();
        int numerocaracteres=25;

        if(LastnMaTxtFieldEmpl.getText().length() >= numerocaracteres)
        {
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Solo se pueden 25 digitos del apellido materno");
        }
        if((c<'a' || c>'z') && (c<'A' || c> 'Z') && (c<' ' || c> ' ') ) evt.consume();        // TODO add your handling code here:
    }//GEN-LAST:event_LastnMaTxtFieldEmplKeyTyped

    private void EmailTxtFieldEmplKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_EmailTxtFieldEmplKeyTyped
        char c = evt.getKeyChar();
        int numerocaracteres=30;

        if(EmailTxtFieldEmpl.getText().length() >= numerocaracteres)
        {
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Solo se pueden 30 digitos para el correo electronico");
        }
        if((c<'a' || c>'z') && (c<'A' || c> 'Z') && (c<' ' || c> ' ') ) evt.consume();    // TODO add your handling code here:
    }//GEN-LAST:event_EmailTxtFieldEmplKeyTyped

    private void UserTxtFieldEmplKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_UserTxtFieldEmplKeyTyped
        char c = evt.getKeyChar();
        int numerocaracteres=10;

        if(UserTxtFieldEmpl.getText().length() >= numerocaracteres)
        {
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Solo se pueden 10 digitos de usuario");
        }
        if((c<'a' || c>'z') && (c<'A' || c> 'Z') && (c<' ' || c> ' ') ) evt.consume();  // TODO add your handling code here:
    }//GEN-LAST:event_UserTxtFieldEmplKeyTyped

    private void PassTxtFieldEmplKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PassTxtFieldEmplKeyTyped
            char c = evt.getKeyChar();
        int numerocaracteres=10;

        if(PassTxtFieldEmpl.getText().length() >= numerocaracteres)
        {
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Solo se pueden 10 digitos de contraseña");
        }
        if((c<'a' || c>'z') && (c<'A' || c> 'Z') && (c<' ' || c> ' ') ) evt.consume();    // TODO add your handling code here:
    }//GEN-LAST:event_PassTxtFieldEmplKeyTyped

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
            java.util.logging.Logger.getLogger(SignupEmple.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SignupEmple.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SignupEmple.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignupEmple.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignupEmple().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel EmailEmpl;
    private javax.swing.JTextField EmailTxtFieldEmpl;
    private javax.swing.JPanel HeaderRegEmpl;
    private javax.swing.JLabel LastnMaEmpl;
    private javax.swing.JTextField LastnMaTxtFieldEmpl;
    private javax.swing.JTextField LastnPaTxtFieldEmpl;
    private javax.swing.JLabel LastnPatEmpl;
    private javax.swing.JLabel NameRegEmpl;
    private javax.swing.JTextField NameTxtFieldEmpl;
    private javax.swing.JPanel PanelRegEmpl;
    private javax.swing.JLabel PassEmpl;
    private javax.swing.JTextField PassTxtFieldEmpl;
    private javax.swing.JLabel PhoneEmpl;
    private javax.swing.JTextField PhoneTxtFieldEmpl;
    private javax.swing.JButton RegBtn;
    private javax.swing.JLabel TitleRegEmpl;
    private javax.swing.JLabel UserEmpl;
    private javax.swing.JTextField UserTxtFieldEmpl;
    // End of variables declaration//GEN-END:variables
}
