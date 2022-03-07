
import java.awt.Image;
import java.awt.Toolkit;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.net.Socket;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Owner_home extends javax.swing.JFrame
{

    String email;

    public Owner_home(String email)
    {
        initComponents();
        setSize(500, 500);
        setVisible(true);
        setResizable(false);
        setTitle("Welcome");
        lb_owner_welcome.setText("WELCOME "+email);
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
        this.email = email;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jp_manage_parking = new javax.swing.JPanel();
        bt_add_parking = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        bt_manageparking = new javax.swing.JButton();
        bt_manage_parking = new javax.swing.JButton();
        lb_owner_welcome = new javax.swing.JLabel();
        lb_background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jp_manage_parking.setLayout(null);

        bt_add_parking.setBackground(new java.awt.Color(0, 0, 0));
        bt_add_parking.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        bt_add_parking.setForeground(new java.awt.Color(255, 255, 255));
        bt_add_parking.setText("ADD PARKING");
        bt_add_parking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_add_parkingActionPerformed(evt);
            }
        });
        jp_manage_parking.add(bt_add_parking);
        bt_add_parking.setBounds(140, 70, 140, 40);

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel1.setText("MANAGE PARKING");
        jp_manage_parking.add(jLabel1);
        jLabel1.setBounds(90, 0, 250, 40);

        bt_manageparking.setBackground(new java.awt.Color(0, 0, 0));
        bt_manageparking.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        bt_manageparking.setForeground(new java.awt.Color(255, 255, 255));
        bt_manageparking.setText("ADD SLOTS");
        bt_manageparking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_manageparkingActionPerformed(evt);
            }
        });
        jp_manage_parking.add(bt_manageparking);
        bt_manageparking.setBounds(140, 190, 140, 40);

        bt_manage_parking.setBackground(new java.awt.Color(0, 0, 0));
        bt_manage_parking.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        bt_manage_parking.setForeground(new java.awt.Color(255, 255, 255));
        bt_manage_parking.setText("MANAGE PARKING");
        bt_manage_parking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_manage_parkingActionPerformed(evt);
            }
        });
        jp_manage_parking.add(bt_manage_parking);
        bt_manage_parking.setBounds(120, 130, 180, 40);

        getContentPane().add(jp_manage_parking);
        jp_manage_parking.setBounds(20, 140, 440, 250);

        lb_owner_welcome.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        lb_owner_welcome.setForeground(new java.awt.Color(255, 255, 255));
        lb_owner_welcome.setText("WELCOME");
        getContentPane().add(lb_owner_welcome);
        lb_owner_welcome.setBounds(40, 10, 390, 30);

        lb_background.setText("jLabel2");
        getContentPane().add(lb_background);
        lb_background.setBounds(0, -16, 490, 430);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_add_parkingActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_bt_add_parkingActionPerformed
    {//GEN-HEADEREND:event_bt_add_parkingActionPerformed
        AddParking obj = new AddParking(this.email);
    }//GEN-LAST:event_bt_add_parkingActionPerformed

    private void bt_manageparkingActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_bt_manageparkingActionPerformed
    {//GEN-HEADEREND:event_bt_manageparkingActionPerformed
        new AddParkingSlots(email);
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_manageparkingActionPerformed

    private void bt_manage_parkingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_manage_parkingActionPerformed
        ManageParking obj=new ManageParking(email);
    }//GEN-LAST:event_bt_manage_parkingActionPerformed

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
            java.util.logging.Logger.getLogger(Owner_home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (InstantiationException ex)
          {
            java.util.logging.Logger.getLogger(Owner_home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (IllegalAccessException ex)
          {
            java.util.logging.Logger.getLogger(Owner_home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (javax.swing.UnsupportedLookAndFeelException ex)
          {
            java.util.logging.Logger.getLogger(Owner_home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
               // new Owner_home("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_add_parking;
    private javax.swing.JButton bt_manage_parking;
    private javax.swing.JButton bt_manageparking;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jp_manage_parking;
    private javax.swing.JLabel lb_background;
    private javax.swing.JLabel lb_owner_welcome;
    // End of variables declaration//GEN-END:variables
}
