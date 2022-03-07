
import java.awt.Image;
import java.awt.Toolkit;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class AddParking extends javax.swing.JFrame
{

    String photofile = "";
    Client c;
    ArrayList<Area> areas;
    String email;

    public AddParking(String email)
    {
        initComponents();
        areas = new ArrayList<>();
        setSize(450, 430);
        setVisible(true);
        setTitle("Add Parking to Database");
         int width=Toolkit.getDefaultToolkit().getScreenSize().width;
        int height=Toolkit.getDefaultToolkit().getScreenSize().height;
      int x=(width/2)-(this.getWidth()/2);
      int y=(height/2)-(this.getHeight()/2);
        setLocation(x, y);
        try {
            File f=new File(System.getProperty("user.home")+"\\images\\underground.jpg");
                    Image scaledInstance = ImageIO.read(f).getScaledInstance(lb_background_addparking.getWidth(), lb_background_addparking.getHeight(),
                            Image.SCALE_SMOOTH);
                    lb_background_addparking.setIcon(new ImageIcon(scaledInstance));
        } catch (Exception e) {
        e.printStackTrace();
        }
        c = new Client();
        this.email = email;
        new Thread(c).start();
        getCategories();

    }

    public void getCategories()
    {
        try
          {
            c.dos.writeBytes("Add Parking Categories\r\n");
          } catch (Exception e)
          {
            e.printStackTrace();
          }
    }

    public void getAreas()
    {
        try
          {
            c.dos.writeBytes("Add Parking Areas\r\n");
          } catch (Exception e)
          {
            e.printStackTrace();
          }
    }

    class Client implements Runnable
    {

        Socket sock;
        DataOutputStream dos;
        DataInputStream dis;

        public Client()
        {
            try
              {
                sock = new Socket("127.0.0.1", 4200);

                dos = new DataOutputStream(sock.getOutputStream());
                dis = new DataInputStream(sock.getInputStream());
              } catch (Exception e)
              {
              }
        }

        @Override
        public void run()
        {

            try
              {
                while (true)
                  {
                    String resp = dis.readLine();
                    if (resp.equals("sending categories"))
                      {
                        while (true)
                          {
                            String cname = dis.readLine();
                            if (cname.equals("all categories done"))
                              {
                                getAreas();
                                break;
                              }
                            cb_parkingcategory.addItem(cname);
                          }

                      } else if (resp.equals("sending areas"))
                      {
                        while (true)
                          {
                            String areaname = dis.readLine();

                            if (areaname.equals("all areas done"))
                              {
                                break;
                              } else if (areaname.contains("~~"))
                              {
                                String[] split = areaname.split("~~");
                                areas.add(new Area(split[1], split[0]));
                                cb_parkingarea.addItem(split[0]);
                              }
                          }

                      } else if (resp.equals("parking already exists in this area"))
                      {
                        JOptionPane.showMessageDialog(AddParking.this, "parking already exists in this area");
                      } else if (resp.equals("parking added successfully"))
                      {
                        JOptionPane.showMessageDialog(AddParking.this, "parking added successfully");
                        tf_parkingname.setText("");
                      }

                  }

              } catch (Exception e)
              {
                e.printStackTrace();
              }

        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cb_parkingcategory = new javax.swing.JComboBox<>();
        cb_parkingarea = new javax.swing.JComboBox<>();
        tf_parkingname = new javax.swing.JTextField();
        bt_browse_parking_image = new javax.swing.JButton();
        lb_browse_parkingimage = new javax.swing.JLabel();
        bt_addparking = new javax.swing.JButton();
        lb_background_addparking = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setBackground(new java.awt.Color(0, 102, 255));
        jLabel1.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 255));
        jLabel1.setText("PARKING NAME");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 20, 130, 30);

        jLabel2.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 255));
        jLabel2.setText("PARKING CATEGORY");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 60, 170, 40);

        jLabel3.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 255));
        jLabel3.setText("PARKING AREA");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 110, 120, 30);

        getContentPane().add(cb_parkingcategory);
        cb_parkingcategory.setBounds(210, 70, 190, 30);

        getContentPane().add(cb_parkingarea);
        cb_parkingarea.setBounds(210, 120, 190, 30);
        getContentPane().add(tf_parkingname);
        tf_parkingname.setBounds(210, 20, 190, 30);

        bt_browse_parking_image.setBackground(new java.awt.Color(0, 102, 255));
        bt_browse_parking_image.setFont(new java.awt.Font("Georgia", 3, 18)); // NOI18N
        bt_browse_parking_image.setForeground(new java.awt.Color(255, 255, 255));
        bt_browse_parking_image.setText("BROWSE");
        bt_browse_parking_image.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_browse_parking_imageActionPerformed(evt);
            }
        });
        getContentPane().add(bt_browse_parking_image);
        bt_browse_parking_image.setBounds(210, 180, 190, 40);
        getContentPane().add(lb_browse_parkingimage);
        lb_browse_parkingimage.setBounds(20, 180, 130, 100);

        bt_addparking.setBackground(new java.awt.Color(0, 102, 255));
        bt_addparking.setFont(new java.awt.Font("Georgia", 3, 18)); // NOI18N
        bt_addparking.setForeground(new java.awt.Color(255, 255, 255));
        bt_addparking.setText("ADD PARKING");
        bt_addparking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_addparkingActionPerformed(evt);
            }
        });
        getContentPane().add(bt_addparking);
        bt_addparking.setBounds(210, 310, 190, 40);

        lb_background_addparking.setText("jLabel4");
        getContentPane().add(lb_background_addparking);
        lb_background_addparking.setBounds(0, -6, 440, 400);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    class Area
    {

        String id;
        String areaname;

        public Area(String id, String areaname)
        {
            this.id = id;
            this.areaname = areaname;
        }

        @Override
        public String toString()
        {
            return areaname; //To change body of generated methods, choose Tools | Templates.
        }

    }


    private void bt_addparkingActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_bt_addparkingActionPerformed
    {//GEN-HEADEREND:event_bt_addparkingActionPerformed
        String parkingname = tf_parkingname.getText();
        String parkingcategory = (String) cb_parkingcategory.getSelectedItem();
        int selectedIndex = cb_parkingarea.getSelectedIndex();
        String areaid = areas.get(selectedIndex).id;
        if(parkingname.isEmpty())
          {
            JOptionPane.showMessageDialog(this,"Please fill the reqd data");
          }
        else
          {
        if (photofile.equals(""))
          {
         
               File f=new File(System.getProperty("user.home")+"\\images\\dummy.jpg");
              photofile = f.getPath();
          }
        try
          {
            c.dos.writeBytes("add parking values\r\n");
            c.dos.writeBytes(parkingname + "\r\n");
            c.dos.writeBytes(parkingcategory + "\r\n");
            c.dos.writeBytes(areaid + "\r\n");
            c.dos.writeBytes(email + "\r\n");
            c.dos.writeBytes(photofile + "\r\n");
          } catch (Exception ex)
          {
            ex.printStackTrace();
          }

          }
    }//GEN-LAST:event_bt_addparkingActionPerformed

    private void bt_browse_parking_imageActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_bt_browse_parking_imageActionPerformed
    {//GEN-HEADEREND:event_bt_browse_parking_imageActionPerformed
        try
          {
            JFileChooser jf = new JFileChooser();
            int showOpenDialog = jf.showOpenDialog(this);

            if (showOpenDialog == JFileChooser.APPROVE_OPTION)
              {
                File f = jf.getSelectedFile();
                photofile = f.getPath();
                Image img = ImageIO.read(f);
                Image bimg = img.getScaledInstance(lb_browse_parkingimage.getWidth(), lb_browse_parkingimage.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon imgic = new ImageIcon(bimg);
                lb_browse_parkingimage.setIcon(imgic);
              } else
              {
             File f=new File(System.getProperty("user.home")+"\\images\\dummy.jpg");
              photofile = f.getPath();
              }

          } catch (Exception e)
          {
            e.printStackTrace();
          }
    }//GEN-LAST:event_bt_browse_parking_imageActionPerformed

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
            java.util.logging.Logger.getLogger(AddParking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (InstantiationException ex)
          {
            java.util.logging.Logger.getLogger(AddParking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (IllegalAccessException ex)
          {
            java.util.logging.Logger.getLogger(AddParking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (javax.swing.UnsupportedLookAndFeelException ex)
          {
            java.util.logging.Logger.getLogger(AddParking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                // new AddParking("a@gmail.com").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_addparking;
    private javax.swing.JButton bt_browse_parking_image;
    public javax.swing.JComboBox<String> cb_parkingarea;
    public javax.swing.JComboBox<String> cb_parkingcategory;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lb_background_addparking;
    private javax.swing.JLabel lb_browse_parkingimage;
    private javax.swing.JTextField tf_parkingname;
    // End of variables declaration//GEN-END:variables
}
