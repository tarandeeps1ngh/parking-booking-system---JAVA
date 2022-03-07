
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


public class EditArea extends javax.swing.JFrame
{

    String photofile="";
    String areaname, areaphoto;
    public EditArea(String areaname,String areaphoto)
    {
        initComponents();
        this.areaname=areaname;
                this.areaphoto=areaphoto;
                setSize(500,500);
                setVisible(true);
                 setTitle("Edit Area");
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
                try{
         File f = new File(areaphoto);
                photofile = f.getPath();
                Image img = ImageIO.read(f);
                Image bimg = img.getScaledInstance(lb_browse_editarea.getWidth(), lb_browse_editarea.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon imgic = new ImageIcon(bimg);
                lb_browse_editarea.setIcon(imgic);
                tf_editarea.setText(areaname);
        }catch(Exception e)
          {
            e.printStackTrace();
          }
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tf_editarea = new javax.swing.JTextField();
        bt_browse_editarea = new javax.swing.JButton();
        lb_browse_editarea = new javax.swing.JLabel();
        bt_update_area = new javax.swing.JButton();
        lb_background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Area Name");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 20, 100, 30);

        jLabel2.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Area Photo");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 90, 90, 20);
        getContentPane().add(tf_editarea);
        tf_editarea.setBounds(160, 20, 210, 40);

        bt_browse_editarea.setBackground(new java.awt.Color(0, 0, 0));
        bt_browse_editarea.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        bt_browse_editarea.setForeground(new java.awt.Color(255, 255, 255));
        bt_browse_editarea.setText("BROWSE");
        bt_browse_editarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_browse_editareaActionPerformed(evt);
            }
        });
        getContentPane().add(bt_browse_editarea);
        bt_browse_editarea.setBounds(160, 100, 110, 40);
        getContentPane().add(lb_browse_editarea);
        lb_browse_editarea.setBounds(280, 100, 110, 90);

        bt_update_area.setBackground(new java.awt.Color(0, 0, 0));
        bt_update_area.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        bt_update_area.setForeground(new java.awt.Color(255, 255, 255));
        bt_update_area.setText("UPDATE");
        bt_update_area.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_update_areaActionPerformed(evt);
            }
        });
        getContentPane().add(bt_update_area);
        bt_update_area.setBounds(160, 230, 110, 40);

        lb_background.setText("jLabel3");
        getContentPane().add(lb_background);
        lb_background.setBounds(0, -6, 570, 510);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_update_areaActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_bt_update_areaActionPerformed
    {//GEN-HEADEREND:event_bt_update_areaActionPerformed
        String newareaname = tf_editarea.getText();
        if (newareaname.isEmpty())
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
                if(rs.next())
                
                  {
                    if (photofile.equals(""))
                      {
File f=new File(System.getProperty("user.home")+"\\images\\dummy.jpg");
              photofile = f.getPath();
                      }
                    
              //      rs.updateString("cname", ctname);
                    rs.updateString("areaname",newareaname);
                    rs.updateString("areaphoto", photofile);
                   rs.updateRow();
                    JOptionPane.showMessageDialog(this, "Updated successfully");
                    tf_editarea.setText("");
                    //ta_edit.setText("");

                  }

              } catch (Exception e)
              {
                e.printStackTrace();
              }
          }
    }//GEN-LAST:event_bt_update_areaActionPerformed

    private void bt_browse_editareaActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_bt_browse_editareaActionPerformed
    {//GEN-HEADEREND:event_bt_browse_editareaActionPerformed
        try
          {
            JFileChooser jf = new JFileChooser();
            int showOpenDialog = jf.showOpenDialog(this);

            if (showOpenDialog == JFileChooser.APPROVE_OPTION)
              {
                File f = jf.getSelectedFile();
                photofile = f.getPath();
                Image img = ImageIO.read(f);
                Image bimg = img.getScaledInstance(lb_browse_editarea.getWidth(), lb_browse_editarea.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon imgic = new ImageIcon(bimg);
                lb_browse_editarea.setIcon(imgic);
              } else
              {
File f=new File(System.getProperty("user.home")+"\\images\\dummy.jpg");
              photofile = f.getPath();              }

          } catch (Exception e)
          {
            e.printStackTrace();
          }
    }//GEN-LAST:event_bt_browse_editareaActionPerformed

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
            java.util.logging.Logger.getLogger(EditArea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (InstantiationException ex)
          {
            java.util.logging.Logger.getLogger(EditArea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (IllegalAccessException ex)
          {
            java.util.logging.Logger.getLogger(EditArea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (javax.swing.UnsupportedLookAndFeelException ex)
          {
            java.util.logging.Logger.getLogger(EditArea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                //new EditArea("","").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_browse_editarea;
    private javax.swing.JButton bt_update_area;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lb_background;
    private javax.swing.JLabel lb_browse_editarea;
    private javax.swing.JTextField tf_editarea;
    // End of variables declaration//GEN-END:variables
}
