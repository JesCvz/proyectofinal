/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

public class LoginNutriSoft extends javax.swing.JFrame {
    Connection con =null;
    Statement stmt =null;
    SignupEmple R1 = new SignupEmple();
    String url = "jdbc:mysql://localhost:3306/nutrisoft?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    String usuario = "root";
//    String contraseña = "JM5038766866"; 
    String contraseña = ""; 
    String driver = "com.mysql.cj.jdbc.Driver";
    /**
     * Creates new form LoginNutriSoft
     */
    public LoginNutriSoft() {
        initComponents();
        this.setTitle("Inicio de sesion");
    }
    //CREAMOS METODO SOBREESCRITO PARA ESTABLECER EL ICONO DE NUESTRO SISTEMA.
    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/NS.png"));
        return retValue;
    }
    public void inicio()
    {
        String Usuario = "56";
        String Contraseña = "C1";
        ResultSet rs = null;     
        String Pass = new String(PassTxtField.getPassword());
        String cadena1,cadena2,cadena3;
        String cap = "";
     
       cadena1 = UserTxtField.getText();
       cadena2 = PassTxtField.getText();
       String sql="SELECT* FROM  empleados WHERE usuario = '"+cadena1+"' && contraseña = '"+cadena2+"'"; 
      
      if(UserTxtField.getText().equals(Usuario) && Pass.equals(Contraseña))
        {
         Menu M1 = new Menu();
         M1.setVisible(true);
         dispose();
        }
      else if (UserTxtField.getText().equals("")) {
         
         javax.swing.JOptionPane.showMessageDialog(this,"Debe de ingresar datos en el campo de usuario y/o contraseña ","AVISO!",javax.swing.JOptionPane.INFORMATION_MESSAGE);
     }
     else {
     
     try { 
                
            Class.forName(driver).newInstance(); 
            con = DriverManager.getConnection(url,usuario,contraseña); 
            if ( con != null ) 
            System.out.println("Se ha establecido una conexión a la base de datos " + "\n " + url + "\n"); 
            stmt = con.createStatement(); 
            rs = stmt.executeQuery("select* from empleados WHERE usuario = '"+cadena1+"' && contraseña = '"+cadena2+"'");
            if(rs.next())
            {
               rs = stmt.executeQuery(sql);
               while(rs.next()) {
                                  javax.swing.JOptionPane.showMessageDialog(this,"Bienvenido \n","AVISO!",javax.swing.JOptionPane.INFORMATION_MESSAGE);
                                  Menu M1 = new Menu();
                                  M1.setVisible(true);
                                  dispose();
                                }
            }
            else{
                JOptionPane.showMessageDialog(null,"No hay ningun registro de ese usuario/contraseña");
            }
        }        
                 
          catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            
            JOptionPane.showMessageDialog(null,"Error al extraer los datos de la tabla");
        }
  
      finally { 
               if ( con != null ) { 
                try  { 
                      con.close(); 
                      stmt.close(); 
                      } catch( SQLException e ) { 
                          System.out.println( e.getMessage()); 
                          } 
                        } 
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

        LogoLogin = new javax.swing.JLabel();
        bgLogin = new javax.swing.JPanel();
        UserTxtField = new javax.swing.JTextField();
        PassTxtField = new javax.swing.JPasswordField();
        UserTxt = new javax.swing.JLabel();
        PassTxt = new javax.swing.JLabel();
        LoginBtn = new javax.swing.JButton();
        SignupBtn = new javax.swing.JButton();
        bgColor = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LogoLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/LogoOfLogin.png"))); // NOI18N
        getContentPane().add(LogoLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 150, 121));

        bgLogin.setBackground(new java.awt.Color(255, 255, 255));

        UserTxt.setText("Usuario:");

        PassTxt.setText("Contraseña:");

        LoginBtn.setText("Ingresar");
        LoginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginBtnActionPerformed(evt);
            }
        });

        SignupBtn.setText("Registrarse");
        SignupBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SignupBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bgLoginLayout = new javax.swing.GroupLayout(bgLogin);
        bgLogin.setLayout(bgLoginLayout);
        bgLoginLayout.setHorizontalGroup(
            bgLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLoginLayout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(bgLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(SignupBtn)
                    .addComponent(LoginBtn)
                    .addGroup(bgLoginLayout.createSequentialGroup()
                        .addGroup(bgLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(UserTxt)
                            .addComponent(PassTxt))
                        .addGap(18, 18, 18)
                        .addGroup(bgLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(UserTxtField, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                            .addComponent(PassTxtField))))
                .addContainerGap(109, Short.MAX_VALUE))
        );
        bgLoginLayout.setVerticalGroup(
            bgLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLoginLayout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(bgLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UserTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UserTxt))
                .addGap(18, 18, 18)
                .addGroup(bgLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PassTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PassTxt))
                .addGap(18, 18, 18)
                .addComponent(LoginBtn)
                .addGap(18, 18, 18)
                .addComponent(SignupBtn)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        getContentPane().add(bgLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 400, 250));

        bgColor.setBackground(new java.awt.Color(255, 255, 255));
        bgColor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/white-background-2.jpg"))); // NOI18N
        getContentPane().add(bgColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 400));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void LoginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginBtnActionPerformed
        inicio(); 
    }//GEN-LAST:event_LoginBtnActionPerformed

    private void SignupBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SignupBtnActionPerformed
        R1.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_SignupBtnActionPerformed

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
            java.util.logging.Logger.getLogger(LoginNutriSoft.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginNutriSoft.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginNutriSoft.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginNutriSoft.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginNutriSoft().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LoginBtn;
    private javax.swing.JLabel LogoLogin;
    private javax.swing.JLabel PassTxt;
    private javax.swing.JPasswordField PassTxtField;
    private javax.swing.JButton SignupBtn;
    private javax.swing.JLabel UserTxt;
    private javax.swing.JTextField UserTxtField;
    private javax.swing.JLabel bgColor;
    private javax.swing.JPanel bgLogin;
    // End of variables declaration//GEN-END:variables
}
