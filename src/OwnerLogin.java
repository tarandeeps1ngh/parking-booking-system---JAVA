
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

public class OwnerLogin extends javax.swing.JFrame {

    Client c;

    public OwnerLogin() {
        initComponents();
        setSize(500, 500);
        setVisible(true);
         setVisible(true);
        setTitle("Owner Login");
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tf_owner_email = new javax.swing.JTextField();
        pf_owner_password = new javax.swing.JPasswordField();
        bt_owner_login = new javax.swing.JButton();
        lb_background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Email");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(39, 39, 80, 40);

        jLabel2.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Password");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 100, 80, 30);
        getContentPane().add(tf_owner_email);
        tf_owner_email.setBounds(140, 40, 250, 40);
        getContentPane().add(pf_owner_password);
        pf_owner_password.setBounds(140, 100, 250, 40);

        bt_owner_login.setBackground(new java.awt.Color(0, 0, 0));
        bt_owner_login.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        bt_owner_login.setForeground(new java.awt.Color(255, 255, 255));
        bt_owner_login.setText("LOGIN");
        bt_owner_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_owner_loginActionPerformed(evt);
            }
        });
        getContentPane().add(bt_owner_login);
        bt_owner_login.setBounds(140, 180, 110, 40);

        lb_background.setText("jLabel3");
        getContentPane().add(lb_background);
        lb_background.setBounds(0, -16, 580, 510);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_owner_loginActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_bt_owner_loginActionPerformed
    {//GEN-HEADEREND:event_bt_owner_loginActionPerformed
        try {
            String email = tf_owner_email.getText();
            String password = pf_owner_password.getText();

            if (email.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please provide required fields");
            } else {
                c = new Client();
                new Thread(c).start();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_bt_owner_loginActionPerformed

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

                String email = tf_owner_email.getText();

                String password = pf_owner_password.getText();

                dos.writeBytes("Login\r\n");
                dos.writeBytes(email + "\r\n");
                dos.writeBytes(password + "\r\n");

                String resp = dis.readLine();
                if (resp.equals("login successfull")) {
                    JOptionPane.showMessageDialog(OwnerLogin.this, "Login successful");
                    dispose();
                    Owner_home obj = new Owner_home(email);
                } else if (resp.equals("Login failed")) {
                    JOptionPane.showMessageDialog(OwnerLogin.this, "Login failed");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

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
            java.util.logging.Logger.getLogger(OwnerLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OwnerLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OwnerLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OwnerLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
              //  new OwnerLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_owner_login;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lb_background;
    private javax.swing.JPasswordField pf_owner_password;
    private javax.swing.JTextField tf_owner_email;
    // End of variables declaration//GEN-END:variables
}
