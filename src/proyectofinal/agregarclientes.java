/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;

import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author jes_c
 */
public class agregarclientes extends javax.swing.JFrame {
   Connection con = null;
    Statement stmt = null;
    String titulos[] = {"Id","Nombre","Apellido Mat","Apellido Pat"};
    String fila[] = new String[4];
    DefaultTableModel modelo;
     TableRowSorter trs;
     
    public agregarclientes() {
        initComponents();
        this.setTitle("Clientes");
        this.setResizable(false);
         try{
               LoginNutriSoft LG = new LoginNutriSoft();
               String url = LG.url;
               String usuario = LG.usuario;
               String contraseña = LG.contraseña; 
               Class.forName(LG.driver).newInstance();
                con = DriverManager.getConnection(url,usuario,contraseña);
                if(con!=null)
                    System.out.println("Se ha estableciso una conexion con la base de datos"+"\n"+url);
                stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("Select* from pacientes");
                
                modelo = new DefaultTableModel(null,titulos);
                while(rs.next()){
                    fila[0]=rs.getString("id_empleados");
                    fila[1]=rs.getString("Nombre");
                    fila[2]=rs.getString("Apellido_Paterno");
                    fila[3]=rs.getString("Apellido_Materno");
                    
                    modelo.addRow(fila);
                    
                }
                tabla_cli.setModel(modelo);
                TableColumn cm = tabla_cli.getColumn("Id");
                TableColumn cn = tabla_cli.getColumn("Nombre");
                TableColumn cd = tabla_cli.getColumn("Apellido Mat");
                TableColumn ct = tabla_cli.getColumn("Apellido Pat");
                
         }
         catch(ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
             JOptionPane.showMessageDialog(null,"Error al extraer los datos de la tabla");
         }
    }

    //CREAMOS METODO SOBREESCRITO PARA ESTABLECER EL ICONO DE NUESTRO SISTEMA.
    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/NS.png"));
        return retValue;
    }
    
    public void agregar()
    {
        int fila = tabla_cli.getSelectedRow()+1;
        System.out.println(fila);
    if(fila==0)
        {
            javax.swing.JOptionPane.showMessageDialog(this, "Debe de seleccionar un registro","AVISO!", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        }

    else if (fila>=0) {

     try { 
         String valor = tabla_cli.getValueAt((fila-1), 0).toString();
            LoginNutriSoft LG = new LoginNutriSoft();
               String url = LG.url;
               String usuario = LG.usuario;
               String contraseña = LG.contraseña; 
               Class.forName(LG.driver).newInstance();
                  con = DriverManager.getConnection(url,usuario,contraseña); 
                  if ( con != null ) 
                    System.out.println("Se ha establecido una conexión a la base de datos " +  
                                       "\n " + url ); 
  
                  stmt = con.createStatement(); 
                  ResultSet rs = stmt.executeQuery("select* from pacientes where id_empleados = '"+valor+"'");
                  
                  while(rs.next())
                  {
                      txtmemTAB.setText(rs.getString("id_empleados"));
                      txtnomTAB.setText(rs.getString("Nombre")+("").concat(rs.getString("Apellido_Paterno")+("").concat(rs.getString("Apellido_Materno"))));
                  }
                  NuevasCitas.txtidcliente.setText(txtmemTAB.getText());
                  NuevasCitas.txtnomcliente.setText(txtnomTAB.getText());
                    } 
                  catch( SQLException e ) { 
                      e.printStackTrace(); 
                  } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
        } 
  
              finally { 
                  if ( con != null ) { 
                      try    { 
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

        txtmemTAB = new javax.swing.JTextField();
        txtnomTAB = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_cli = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(getIconImage());

        tabla_cli.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id_paciente", "Nombre", "A_paterno", "A_materno"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla_cli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tabla_cliKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_cli);

        jButton1.setText("Agregar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 420, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tabla_cliKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabla_cliKeyPressed
      // TODO add your handling code here:
    }//GEN-LAST:event_tabla_cliKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     agregar(); 
     dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(agregarclientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(agregarclientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(agregarclientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(agregarclientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new agregarclientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla_cli;
    private javax.swing.JTextField txtmemTAB;
    private javax.swing.JTextField txtnomTAB;
    // End of variables declaration//GEN-END:variables
}
