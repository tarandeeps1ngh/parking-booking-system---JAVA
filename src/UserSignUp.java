
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


public class UserSignUp extends javax.swing.JFrame {
Client c;
    public UserSignUp() {
        initComponents();
        setVisible(true);
          setResizable(false);
        setTitle("User SignUp");
        setSize(530,620);
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
        }
    }
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

                  String email = tf_user_email.getText();
            String sec_ques = (String) cb_user_sec_ques.getSelectedItem();
            String sec_ans = tf_user_sec_ans.getText();
            String contact = tf_user_contact.getText();
            String password = pf_userpassword.getText();
            String confirmpassword = pf_user_confirpassword.getText();
                dos.writeBytes("User Sign Up\r\n");
                dos.writeBytes(email + "\r\n");
                dos.writeBytes(sec_ques + "\r\n");
                dos.writeBytes(sec_ans + "\r\n");
                dos.writeBytes(contact + "\r\n");
                dos.writeBytes(password + "\r\n");

                String resp = dis.readLine();
                if (resp.equals("user email already exists"))
                  {
                    JOptionPane.showMessageDialog(UserSignUp.this, "email already exists");
                  } else if (resp.equals("User Sign Up successful"))
                  {
                    JOptionPane.showMessageDialog(UserSignUp.this, "Sign Up successful");
                    dispose();
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
        tf_user_email = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cb_user_sec_ques = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        tf_user_sec_ans = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tf_user_contact = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        pf_userpassword = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        pf_user_confirpassword = new javax.swing.JPasswordField();
        bt_user_sign_up = new javax.swing.JButton();
        bt_login = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lb_background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Name");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 80, 90, 40);
        getContentPane().add(tf_user_email);
        tf_user_email.setBounds(190, 80, 250, 30);

        jLabel3.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("sec_ques");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 150, 90, 30);

        cb_user_sec_ques.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "What is your favourite city", "What is your favorite game", "What is your favorite movie"}));
        getContentPane().add(cb_user_sec_ques);
        cb_user_sec_ques.setBounds(190, 150, 250, 30);

        jLabel4.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("contact");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(20, 280, 60, 30);
        getContentPane().add(tf_user_sec_ans);
        tf_user_sec_ans.setBounds(190, 220, 250, 30);

        jLabel5.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("password");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(20, 360, 90, 30);
        getContentPane().add(tf_user_contact);
        tf_user_contact.setBounds(190, 290, 250, 30);

        jLabel6.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("sec_ans");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(20, 230, 60, 20);
        getContentPane().add(pf_userpassword);
        pf_userpassword.setBounds(190, 360, 250, 30);

        jLabel7.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("confirm password");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(20, 430, 140, 30);
        getContentPane().add(pf_user_confirpassword);
        pf_user_confirpassword.setBounds(190, 440, 250, 30);

        bt_user_sign_up.setBackground(new java.awt.Color(0, 0, 0));
        bt_user_sign_up.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        bt_user_sign_up.setForeground(new java.awt.Color(255, 255, 255));
        bt_user_sign_up.setText("SIGN UP");
        bt_user_sign_up.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_user_sign_upActionPerformed(evt);
            }
        });
        getContentPane().add(bt_user_sign_up);
        bt_user_sign_up.setBounds(190, 520, 120, 50);

        bt_login.setBackground(new java.awt.Color(0, 0, 0));
        bt_login.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        bt_login.setForeground(new java.awt.Color(255, 255, 255));
        bt_login.setText("Login");
        bt_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_loginActionPerformed(evt);
            }
        });
        getContentPane().add(bt_login);
        bt_login.setBounds(360, 520, 100, 50);

        jLabel2.setFont(new java.awt.Font("Georgia", 3, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("USER SIGN UP");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(120, 10, 310, 40);

        lb_background.setText("jLabel8");
        getContentPane().add(lb_background);
        lb_background.setBounds(0, 0, 530, 600);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_user_sign_upActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_user_sign_upActionPerformed

        try
        {
            String email = tf_user_email.getText();
            String sec_ques = (String) cb_user_sec_ques.getSelectedItem();
            String sec_ans = tf_user_sec_ans.getText();
            String contact = tf_user_contact.getText();
            String password = pf_userpassword.getText();
            String confirmpassword = pf_user_confirpassword.getText();

            if (email.isEmpty() || sec_ques.isEmpty() || sec_ans.isEmpty() || contact.isEmpty() || password.isEmpty() || confirmpassword.isEmpty())
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
    }//GEN-LAST:event_bt_user_sign_upActionPerformed

    private void bt_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_loginActionPerformed
      UserLogin ul=new UserLogin();
              
    }//GEN-LAST:event_bt_loginActionPerformed

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
            java.util.logging.Logger.getLogger(UserSignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserSignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserSignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserSignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserSignUp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_login;
    private javax.swing.JButton bt_user_sign_up;
    private javax.swing.JComboBox<String> cb_user_sec_ques;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel lb_background;
    private javax.swing.JPasswordField pf_user_confirpassword;
    private javax.swing.JPasswordField pf_userpassword;
    private javax.swing.JTextField tf_user_contact;
    private javax.swing.JTextField tf_user_email;
    private javax.swing.JTextField tf_user_sec_ans;
    // End of variables declaration//GEN-END:variables
}
