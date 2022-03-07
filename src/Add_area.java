
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashSet;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class Add_area extends javax.swing.JFrame
{

    String photofile="";
    public Add_area()
    {
        initComponents();
        setSize(500,500);
        setVisible(true);
        setResizable(false);
        setTitle("Add Areas For Parkings");
         int width=Toolkit.getDefaultToolkit().getScreenSize().width;
        int height=Toolkit.getDefaultToolkit().getScreenSize().height;
      int x=(width/2)-(this.getWidth()/2);
      int y=(height/2)-(this.getHeight()/2);
        setLocation(x, y);
        try {
            File f=new File(System.getProperty("user.home")+"\\images\\a.jpg");
                    Image scaledInstance = ImageIO.read(f).getScaledInstance(lb_background.getWidth(), lb_background.getHeight(),
                            Image.SCALE_SMOOTH);
                    lb_background.setIcon(new ImageIcon(scaledInstance));
            
            
        } catch (Exception e) {
        e.printStackTrace();
        
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tf_area_name = new javax.swing.JTextField();
        bt_browse_area = new javax.swing.JButton();
        lb_browse_area = new javax.swing.JLabel();
        bt_addarea = new javax.swing.JButton();
        lb_background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("AREA NAME");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(24, 32, 110, 40);

        jLabel2.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("AREA PHOTO");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 110, 110, 30);
        getContentPane().add(tf_area_name);
        tf_area_name.setBounds(140, 30, 240, 40);

        bt_browse_area.setBackground(new java.awt.Color(0, 0, 0));
        bt_browse_area.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        bt_browse_area.setForeground(new java.awt.Color(255, 255, 255));
        bt_browse_area.setText("BROWSE");
        bt_browse_area.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_browse_areaActionPerformed(evt);
            }
        });
        getContentPane().add(bt_browse_area);
        bt_browse_area.setBounds(140, 110, 110, 30);
        getContentPane().add(lb_browse_area);
        lb_browse_area.setBounds(270, 120, 160, 110);

        bt_addarea.setBackground(new java.awt.Color(0, 0, 0));
        bt_addarea.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        bt_addarea.setForeground(new java.awt.Color(255, 255, 255));
        bt_addarea.setText("ADD");
        bt_addarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_addareaActionPerformed(evt);
            }
        });
        getContentPane().add(bt_addarea);
        bt_addarea.setBounds(140, 290, 120, 30);

        lb_background.setText("jLabel3");
        getContentPane().add(lb_background);
        lb_background.setBounds(0, -6, 490, 490);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_browse_areaActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_bt_browse_areaActionPerformed
    {//GEN-HEADEREND:event_bt_browse_areaActionPerformed
         try
          {
            JFileChooser jf = new JFileChooser();
            int showOpenDialog = jf.showOpenDialog(this);

            if (showOpenDialog == JFileChooser.APPROVE_OPTION)
              {
                File f = jf.getSelectedFile();
                photofile = f.getPath();
                Image img = ImageIO.read(f);
                Image bimg = img.getScaledInstance(lb_browse_area.getWidth(), lb_browse_area.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon imgic = new ImageIcon(bimg);
                lb_browse_area.setIcon(imgic);
              } else
              {
               File f=new File(System.getProperty("user.home")+"\\images\\dummy.jpg");
              photofile = f.getPath();
              }

          } catch (Exception e)
          {
            e.printStackTrace();
          }
    }//GEN-LAST:event_bt_browse_areaActionPerformed

    private void bt_addareaActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_bt_addareaActionPerformed
    {//GEN-HEADEREND:event_bt_addareaActionPerformed
         String areaname = tf_area_name.getText();
       
        if (areaname.isEmpty())
          {
            JOptionPane.showMessageDialog(this, "Please provide required details");
          } else
          {
            try
              {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Driver Loading done");

                Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/parkingbookingsystem", "root", "system");
                System.out.println("Connection Created");

                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);
                System.out.println("Statement Created");

                ResultSet rs = stmt.executeQuery("select * from areas where areaname='" + areaname + "'");
                System.out.println("ResultSet Created\n\n");
                if (rs.next())
                  {
                    JOptionPane.showMessageDialog(this, "area already exists");

                  } else
                  {
                    if (photofile.equals(""))
                      {
           File f=new File(System.getProperty("user.home")+"\\images\\dummy.jpg");
              photofile = f.getPath();
                      }
                    rs.moveToInsertRow();
                    rs.updateString("areaname", areaname);
                    rs.updateString("areaphoto", photofile);
                    rs.insertRow();
                    JOptionPane.showMessageDialog(this, "Added successfully");
                    tf_area_name.setText("");
                    

                  }

              } catch (Exception e)
              {
                e.printStackTrace();
              }
          }
    }//GEN-LAST:event_bt_addareaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
          {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
              {
                if ("Nimbus".equals(info.getName()))
                  {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                  }
              }
          } catch (ClassNotFoundException ex)
          {
            java.util.logging.Logger.getLogger(Add_area.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (InstantiationException ex)
          {
            java.util.logging.Logger.getLogger(Add_area.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (IllegalAccessException ex)
          {
            java.util.logging.Logger.getLogger(Add_area.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (javax.swing.UnsupportedLookAndFeelException ex)
          {
            java.util.logging.Logger.getLogger(Add_area.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                //new Add_area().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_addarea;
    private javax.swing.JButton bt_browse_area;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lb_background;
    private javax.swing.JLabel lb_browse_area;
    private javax.swing.JTextField tf_area_name;
    // End of variables declaration//GEN-END:variables
}
