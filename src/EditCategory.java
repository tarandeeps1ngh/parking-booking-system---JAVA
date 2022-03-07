
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


public class EditCategory extends javax.swing.JFrame {
 String photofile = "";
    
 String cname;
 String cdesc;
 String cphoto;
    public EditCategory(String cname,String cdesc,String cphoto) {
        initComponents();
        setSize(500,500);
        setVisible(true);
         setTitle("Edit Category");
        setResizable(false);
         int width=Toolkit.getDefaultToolkit().getScreenSize().width;
        int height=Toolkit.getDefaultToolkit().getScreenSize().height;
      int x=(width/2)-(this.getWidth()/2);
      int y=(height/2)-(this.getHeight()/2);
        setLocation(x, y);
        try {
             File f=new File(System.getProperty("user.home")+"\\images\\c.jpg");
                    Image scaledInstance = ImageIO.read(f).getScaledInstance(lb_background.getWidth(), lb_background.getHeight(),
                            Image.SCALE_SMOOTH);
                    lb_background.setIcon(new ImageIcon(scaledInstance));
        } catch (Exception e) {
        }
        this.cname=cname;
        this.cdesc=cdesc;
        this.cphoto=cphoto;
        tf_edit.setText(cname);
          tf_edit.setEnabled(false);
        try{
         File f = new File(cphoto);
                photofile = f.getPath();
                Image img = ImageIO.read(f);
                Image bimg = img.getScaledInstance(lb_browse_image.getWidth(), lb_browse_image.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon imgic = new ImageIcon(bimg);
                lb_browse_image.setIcon(imgic);
        }catch(Exception e)
          {
            e.printStackTrace();
          }
        }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tf_edit = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        ta_edit = new javax.swing.JTextArea();
        bt_browse = new javax.swing.JButton();
        lb_browse_image = new javax.swing.JLabel();
        bt_update = new javax.swing.JButton();
        lb_cname = new javax.swing.JLabel();
        lb_cdesc = new javax.swing.JLabel();
        lb_cphoto = new javax.swing.JLabel();
        lb_background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);
        getContentPane().add(tf_edit);
        tf_edit.setBounds(230, 20, 170, 30);

        ta_edit.setColumns(20);
        ta_edit.setRows(5);
        jScrollPane1.setViewportView(ta_edit);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(230, 80, 166, 96);

        bt_browse.setBackground(new java.awt.Color(0, 0, 0));
        bt_browse.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        bt_browse.setForeground(new java.awt.Color(255, 255, 255));
        bt_browse.setText("BROWSE");
        bt_browse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_browseActionPerformed(evt);
            }
        });
        getContentPane().add(bt_browse);
        bt_browse.setBounds(230, 190, 110, 40);
        getContentPane().add(lb_browse_image);
        lb_browse_image.setBounds(360, 190, 150, 100);

        bt_update.setBackground(new java.awt.Color(0, 0, 0));
        bt_update.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        bt_update.setForeground(new java.awt.Color(255, 255, 255));
        bt_update.setText("UPDATE");
        bt_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_updateActionPerformed(evt);
            }
        });
        getContentPane().add(bt_update);
        bt_update.setBounds(230, 280, 110, 40);

        lb_cname.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        lb_cname.setForeground(new java.awt.Color(255, 255, 255));
        lb_cname.setText("Category Name");
        getContentPane().add(lb_cname);
        lb_cname.setBounds(20, 30, 120, 17);

        lb_cdesc.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        lb_cdesc.setForeground(new java.awt.Color(255, 255, 255));
        lb_cdesc.setText("Category Description");
        getContentPane().add(lb_cdesc);
        lb_cdesc.setBounds(20, 80, 160, 30);

        lb_cphoto.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        lb_cphoto.setForeground(new java.awt.Color(255, 255, 255));
        lb_cphoto.setText("Category Photo");
        getContentPane().add(lb_cphoto);
        lb_cphoto.setBounds(20, 190, 140, 30);

        lb_background.setText("jLabel1");
        getContentPane().add(lb_background);
        lb_background.setBounds(0, -16, 660, 530);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_browseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_browseActionPerformed
         try
          {
            JFileChooser jf = new JFileChooser();
            int showOpenDialog = jf.showOpenDialog(this);

            if (showOpenDialog == JFileChooser.APPROVE_OPTION)
              {
                File f = jf.getSelectedFile();
                photofile = f.getPath();
                Image img = ImageIO.read(f);
                Image bimg = img.getScaledInstance(lb_browse_image.getWidth(), lb_browse_image.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon imgic = new ImageIcon(bimg);
                lb_browse_image.setIcon(imgic);
              } else
              {
                
File f=new File(System.getProperty("user.home")+"\\images\\dummy.jpg");
              photofile = f.getPath();              
              }

          } catch (Exception e)
          {
            e.printStackTrace();
          }
    }//GEN-LAST:event_bt_browseActionPerformed

    private void bt_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_updateActionPerformed
          
        String ctdesc = ta_edit.getText();
        if (ctdesc.isEmpty())
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

                ResultSet rs = stmt.executeQuery("select * from category where cname='" + cname + "'");
                System.out.println("ResultSet Created\n\n");
                if(rs.next())
                
                  {
                    if (photofile.equals(""))
                      {
               File f=new File(System.getProperty("user.home")+"\\images\\dummy.jpg");
              photofile = f.getPath();
                      }
                    
              //      rs.updateString("cname", ctname);
                    rs.updateString("cdescription", ctdesc);
                    rs.updateString("cphoto", photofile);
                   rs.updateRow();
                    JOptionPane.showMessageDialog(this, "Updated successfully");
                    tf_edit.setText("");
                    ta_edit.setText("");

                  }

              } catch (Exception e)
              {
                e.printStackTrace();
              }
    }//GEN-LAST:event_bt_updateActionPerformed
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
            java.util.logging.Logger.getLogger(EditCategory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditCategory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditCategory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditCategory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new EditCategory("","","").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_browse;
    private javax.swing.JButton bt_update;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_background;
    private javax.swing.JLabel lb_browse_image;
    private javax.swing.JLabel lb_cdesc;
    private javax.swing.JLabel lb_cname;
    private javax.swing.JLabel lb_cphoto;
    private javax.swing.JTextArea ta_edit;
    private javax.swing.JTextField tf_edit;
    // End of variables declaration//GEN-END:variables
}
