
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

public class OwnerSignup extends javax.swing.JFrame
{

    Client c;

    public OwnerSignup()
    {
        initComponents();
        setSize(570, 630);
        setVisible(true);
         setResizable(false);
        setTitle("Owner SignUp");
         int width=Toolkit.getDefaultToolkit().getScreenSize().width;
        int height=Toolkit.getDefaultToolkit().getScreenSize().height;
      int x=(width/2)-(this.getWidth()/2);
      int y=(height/2)-(this.getHeight()/2);
        setLocation(x, y);
        try {
             File f=new File(System.getProperty("user.home")+"\\images\\e.jpg");
                    Image scaledInstance = ImageIO.read(f).getScaledInstance(lb_background.getWidth(), lb_background.getHeight(),
                            Image.SCALE_SMOOTH);
                    lb_background.setIcon(new ImageIcon(scaledInstance));
        } catch (Exception e) {
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tf_owneremail = new javax.swing.JTextField();
        tf_owner_name = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cb_sec_ques = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        tf_sec_ans = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tf_contact = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        pf_ownerpassword = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        pf_owner_confirpassword = new javax.swing.JPasswordField();
        bt_owner_sign_up = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        lb_background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Email");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 130, 110, 40);

        jLabel2.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Name");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 170, 130, 40);
        getContentPane().add(tf_owneremail);
        tf_owneremail.setBounds(190, 130, 250, 30);
        getContentPane().add(tf_owner_name);
        tf_owner_name.setBounds(190, 170, 250, 30);

        jLabel3.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Sec_ques");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 230, 120, 30);

        cb_sec_ques.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "What is your favourite city", "What is your favorite game", "What is your favorite movie"}));
        getContentPane().add(cb_sec_ques);
        cb_sec_ques.setBounds(190, 230, 250, 30);

        jLabel4.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Contact");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(30, 340, 120, 30);

        tf_sec_ans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_sec_ansActionPerformed(evt);
            }
        });
        getContentPane().add(tf_sec_ans);
        tf_sec_ans.setBounds(190, 290, 250, 30);

        jLabel5.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Password");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(30, 400, 90, 30);
        getContentPane().add(tf_contact);
        tf_contact.setBounds(190, 340, 250, 30);

        jLabel6.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Sec_ans");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(30, 290, 100, 30);
        getContentPane().add(pf_ownerpassword);
        pf_ownerpassword.setBounds(190, 400, 250, 30);

        jLabel7.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Confirm password");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(20, 450, 140, 30);
        getContentPane().add(pf_owner_confirpassword);
        pf_owner_confirpassword.setBounds(190, 450, 250, 30);

        bt_owner_sign_up.setBackground(new java.awt.Color(0, 0, 0));
        bt_owner_sign_up.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        bt_owner_sign_up.setForeground(new java.awt.Color(255, 255, 255));
        bt_owner_sign_up.setText("SIGN UP");
        bt_owner_sign_up.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_owner_sign_upActionPerformed(evt);
            }
        });
        getContentPane().add(bt_owner_sign_up);
        bt_owner_sign_up.setBounds(190, 520, 150, 40);

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("LOGIN");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(363, 520, 120, 40);

        jLabel8.setFont(new java.awt.Font("Georgia", 3, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("   OWNER  SIGN UP");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(80, 40, 430, 60);

        lb_background.setText("jLabel9");
        getContentPane().add(lb_background);
        lb_background.setBounds(0, 0, 570, 620);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_owner_sign_upActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_bt_owner_sign_upActionPerformed
    {//GEN-HEADEREND:event_bt_owner_sign_upActionPerformed

        try
          {
            String email = tf_owneremail.getText();
            String name = tf_owner_name.getText();
            String sec_ques = (String) cb_sec_ques.getSelectedItem();
            String sec_ans = tf_sec_ans.getText();
            String contact = tf_contact.getText();
            String password = pf_ownerpassword.getText();
            String confirmpassword = pf_owner_confirpassword.getText();

            if (email.isEmpty() || name.isEmpty() || sec_ques.isEmpty() || sec_ans.isEmpty() || contact.isEmpty() || password.isEmpty() || confirmpassword.isEmpty())
              {
                JOptionPane.showMessageDialog(this, "Please provide required fields");
              } else if (!password.equals(confirmpassword))
              {
                JOptionPane.showMessageDialog(this, "Password do not match");
              } else
              {
                c = new Client();
                new Thread(c).start();

              }
          } catch (Exception e)
          {
            e.printStackTrace();
          }

    }//GEN-LAST:event_bt_owner_sign_upActionPerformed

    private void tf_sec_ansActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_sec_ansActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_sec_ansActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    OwnerLogin ob=new OwnerLogin();

    }//GEN-LAST:event_jButton1ActionPerformed
    class Client implements Runnable
    {

        Socket sock;
        DataOutputStream dos;
        DataInputStream dis;

        public Client()
        {

        }

        @Override
        public void run()
        {

            try
              {
                sock = new Socket("127.0.0.1", 4200);

                dos = new DataOutputStream(sock.getOutputStream());
                dis = new DataInputStream(sock.getInputStream());

                String email = tf_owneremail.getText();
                String name = tf_owner_name.getText();
                String sec_ques = (String) cb_sec_ques.getSelectedItem();
                String sec_ans = tf_sec_ans.getText();
                String contact = tf_contact.getText();
                String password = pf_ownerpassword.getText();

                dos.writeBytes("Sign Up\r\n");
                dos.writeBytes(email + "\r\n");
                dos.writeBytes(name + "\r\n");
                dos.writeBytes(sec_ques + "\r\n");
                dos.writeBytes(sec_ans + "\r\n");
                dos.writeBytes(contact + "\r\n");
                dos.writeBytes(password + "\r\n");

                String resp = dis.readLine();
                if (resp.equals("email already exists"))
                  {
                    JOptionPane.showMessageDialog(OwnerSignup.this, "email already exists");
                  } else if (resp.equals("Sign Up successful"))
                  {
                    JOptionPane.showMessageDialog(OwnerSignup.this, "Sign Up successful");
                  }

              } catch (Exception e)
              {
                e.printStackTrace();
              }

        }

    }

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
            java.util.logging.Logger.getLogger(OwnerSignup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (InstantiationException ex)
          {
            java.util.logging.Logger.getLogger(OwnerSignup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (IllegalAccessException ex)
          {
            java.util.logging.Logger.getLogger(OwnerSignup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (javax.swing.UnsupportedLookAndFeelException ex)
          {
            java.util.logging.Logger.getLogger(OwnerSignup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new OwnerSignup().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_owner_sign_up;
    private javax.swing.JComboBox<String> cb_sec_ques;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel lb_background;
    private javax.swing.JPasswordField pf_owner_confirpassword;
    private javax.swing.JPasswordField pf_ownerpassword;
    private javax.swing.JTextField tf_contact;
    private javax.swing.JTextField tf_owner_name;
    private javax.swing.JTextField tf_owneremail;
    private javax.swing.JTextField tf_sec_ans;
    // End of variables declaration//GEN-END:variables
}
