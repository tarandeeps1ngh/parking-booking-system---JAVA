
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

public class UserLogin extends javax.swing.JFrame {

    Client c;

    public UserLogin() {
        initComponents();
        setSize(500, 330);
        setVisible(true);
         setResizable(false);
        setTitle("Welcome");
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        int x = (width / 2) - (this.getWidth() / 2);
        int y = (height / 2) - (this.getHeight() / 2);
        setLocation(x, y);
        try {
            File f=new File(System.getProperty("user.home")+"\\images\\c.jpg");
                    Image scaledInstance = ImageIO.read(f).getScaledInstance(lb_background.getWidth(), lb_background.getHeight(),
                            Image.SCALE_SMOOTH);
                    lb_background.setIcon(new ImageIcon(scaledInstance));
        } catch (Exception e) {
        }
    }

    class Client implements Runnable {

        Socket sock;
        DataOutputStream dos;
        DataInputStream dis;

        public Client() {

        }

        @Override
        public void run() {

            try {
                sock = new Socket("127.0.0.1", 4200);

                dos = new DataOutputStream(sock.getOutputStream());
                dis = new DataInputStream(sock.getInputStream());

                String email = tf_user_email.getText();

                String password = pf_user_password.getText();

                dos.writeBytes("User Login\r\n");
                dos.writeBytes(email + "\r\n");
                dos.writeBytes(password + "\r\n");

                String resp = dis.readLine();
                if (resp.equals("User login successfull")) {
                    JOptionPane.showMessageDialog(UserLogin.this, "Login successful");
                    dispose();
                    UserHome obj = new UserHome(email);

                } else if (resp.equals("User Login failed")) {
                    JOptionPane.showMessageDialog(UserLogin.this, "Login failed");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tf_user_email = new javax.swing.JTextField();
        pf_user_password = new javax.swing.JPasswordField();
        bt_user_login = new javax.swing.JButton();
        lb_background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Name");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(39, 39, 80, 40);

        jLabel2.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Password");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 100, 80, 30);
        getContentPane().add(tf_user_email);
        tf_user_email.setBounds(140, 40, 250, 40);
        getContentPane().add(pf_user_password);
        pf_user_password.setBounds(140, 100, 250, 40);

        bt_user_login.setBackground(new java.awt.Color(0, 0, 0));
        bt_user_login.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        bt_user_login.setForeground(new java.awt.Color(255, 255, 255));
        bt_user_login.setText("LOGIN");
        bt_user_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_user_loginActionPerformed(evt);
            }
        });
        getContentPane().add(bt_user_login);
        bt_user_login.setBounds(140, 180, 110, 40);

        lb_background.setText("jLabel3");
        getContentPane().add(lb_background);
        lb_background.setBounds(0, -6, 490, 310);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_user_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_user_loginActionPerformed
        try {
            String email = tf_user_email.getText();
            String password = pf_user_password.getText();

            if (email.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please provide required fields");
            } else {
                c = new Client();
                new Thread(c).start();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_bt_user_loginActionPerformed

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
            java.util.logging.Logger.getLogger(UserLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_user_login;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lb_background;
    private javax.swing.JPasswordField pf_user_password;
    private javax.swing.JTextField tf_user_email;
    // End of variables declaration//GEN-END:variables
}
