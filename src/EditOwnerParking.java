
import java.awt.Image;
import java.awt.Toolkit;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.net.Socket;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


public class EditOwnerParking extends javax.swing.JFrame {
String photofile = "";
    
 String parkingname;
 String parkingarea;
 String photo;
 String areaid;
 Client c;
 String email;
    
    public EditOwnerParking(String parkingname,String parkingarea,String pphoto,String areaid,String email) {
        initComponents();
        setSize(500,500);
        setVisible(true);
         setTitle("Edit Owner Parking");
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
        this.parkingarea=parkingarea;
        this.parkingname=parkingname;
        this.photo=pphoto;
        this.areaid=areaid;
        this.email=email;
        c=new Client();
        new Thread(c).start();
        tf_edit_ownerparkingname.setText(parkingname);
        cb_edit_ownerparkingarea.addItem(parkingarea);
        try{
         File f = new File(photo);
                photofile = f.getPath();
                Image img = ImageIO.read(f);
                Image bimg = img.getScaledInstance(lb_browse_parkingimage.getWidth(), lb_browse_parkingimage.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon imgic = new ImageIcon(bimg);
                lb_browse_parkingimage.setIcon(imgic);
        }catch(Exception e)
          {
            e.printStackTrace();
          }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cb_edit_ownerparkingarea = new javax.swing.JComboBox<>();
        tf_edit_ownerparkingname = new javax.swing.JTextField();
        bt_edit_browse_parking_image = new javax.swing.JButton();
        lb_browse_parkingimage = new javax.swing.JLabel();
        bt_updateparking = new javax.swing.JButton();
        lb_background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("PARKING NAME");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 20, 130, 30);

        jLabel3.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("PARKING AREA");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 110, 120, 30);

        getContentPane().add(cb_edit_ownerparkingarea);
        cb_edit_ownerparkingarea.setBounds(170, 110, 190, 30);
        getContentPane().add(tf_edit_ownerparkingname);
        tf_edit_ownerparkingname.setBounds(170, 20, 190, 30);

        bt_edit_browse_parking_image.setBackground(new java.awt.Color(0, 0, 0));
        bt_edit_browse_parking_image.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        bt_edit_browse_parking_image.setForeground(new java.awt.Color(255, 255, 255));
        bt_edit_browse_parking_image.setText("BROWSE");
        bt_edit_browse_parking_image.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_edit_browse_parking_imageActionPerformed(evt);
            }
        });
        getContentPane().add(bt_edit_browse_parking_image);
        bt_edit_browse_parking_image.setBounds(170, 180, 130, 40);
        getContentPane().add(lb_browse_parkingimage);
        lb_browse_parkingimage.setBounds(310, 180, 120, 100);

        bt_updateparking.setBackground(new java.awt.Color(0, 0, 0));
        bt_updateparking.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        bt_updateparking.setForeground(new java.awt.Color(255, 255, 255));
        bt_updateparking.setText("UPDATE PARKING");
        bt_updateparking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_updateparkingActionPerformed(evt);
            }
        });
        getContentPane().add(bt_updateparking);
        bt_updateparking.setBounds(170, 310, 180, 40);

        lb_background.setText("jLabel2");
        getContentPane().add(lb_background);
        lb_background.setBounds(0, -6, 570, 530);

        pack();
    }// </editor-fold>//GEN-END:initComponents
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
                      if (resp.equals("Updated successfully"))
                      {
                        JOptionPane.showMessageDialog(EditOwnerParking.this, "Updated successfully");
                        tf_edit_ownerparkingname.setText("");
                      } 

                  }

              } catch (Exception e)
              {
                e.printStackTrace();
              }

        }

    }
    private void bt_edit_browse_parking_imageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_edit_browse_parking_imageActionPerformed
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
            }
            else
            {
            File f=new File(System.getProperty("user.home")+"\\images\\dummy.jpg");
              photofile = f.getPath();
            }

        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_bt_edit_browse_parking_imageActionPerformed

    private void bt_updateparkingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_updateparkingActionPerformed
        String newparkingname = tf_edit_ownerparkingname.getText();
        
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
                c.dos.writeBytes("update parking values\r\n");
                c.dos.writeBytes(newparkingname + "\r\n");
                c.dos.writeBytes(areaid + "\r\n");
              
                c.dos.writeBytes(parkingarea + "\r\n");
                c.dos.writeBytes(photofile + "\r\n");
              c.dos.writeBytes(email + "\r\n");
              c.dos.writeBytes(parkingname + "\r\n");
            } catch (Exception ex)
            {
                ex.printStackTrace();
            }

        }
    }//GEN-LAST:event_bt_updateparkingActionPerformed

    
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
            java.util.logging.Logger.getLogger(EditOwnerParking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditOwnerParking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditOwnerParking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditOwnerParking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               // new EditOwnerParking("","","","","").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_edit_browse_parking_image;
    private javax.swing.JButton bt_updateparking;
    public javax.swing.JComboBox<String> cb_edit_ownerparkingarea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lb_background;
    private javax.swing.JLabel lb_browse_parkingimage;
    private javax.swing.JTextField tf_edit_ownerparkingname;
    // End of variables declaration//GEN-END:variables
}
