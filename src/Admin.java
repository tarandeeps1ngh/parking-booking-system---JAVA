
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.net.URI;
import java.net.URL;
import java.sql.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Admin extends javax.swing.JFrame {

    public Admin() {
        initComponents();
        setTitle("Login to access Admin Interface");
        setResizable(false);
        setSize(500, 350);
        setVisible(true);
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        int x = (width / 2) - (this.getWidth() / 2);
        int y = (height / 2) - (this.getHeight() / 2);
        setLocation(x, y);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    File f=new File(System.getProperty("user.home")+"\\images\\login.png");
                    Image scaledInstance = ImageIO.read(f).getScaledInstance(lblogin.getWidth(), lblogin.getHeight(),
                            Image.SCALE_SMOOTH);
                    lblogin.setIcon(new ImageIcon(scaledInstance));

                 File f1=new File(System.getProperty("user.home")+"\\images\\fp2.png");
                    Image scaledInstance1 = ImageIO.read(f1).getScaledInstance(lbFP.getWidth(),
                            lbFP.getHeight(),
                            Image.SCALE_SMOOTH);
                    lbFP.setIcon(new ImageIcon(scaledInstance1));
                    File f2=new File(System.getProperty("user.home")+"\\images\\logo2.jpg");

                    Image scaledInstance2 = ImageIO.read(f2).getScaledInstance(lbmaincover.getWidth(),lbmaincover.getHeight(), Image.SCALE_SMOOTH);
                    setIconImage(scaledInstance2);

                 
                    lbmaincover.setIcon(new ImageIcon(scaledInstance2));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tf_username = new javax.swing.JTextField();
        pf_password = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        lblogin = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbFP = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbmaincover = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Georgia", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 255));
        jLabel1.setText("E-mail");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 110, 110, 20);

        jLabel2.setFont(new java.awt.Font("Georgia", 3, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 255));
        jLabel2.setText("Password");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 160, 110, 20);

        tf_username.setFont(new java.awt.Font("Georgia", 3, 18)); // NOI18N
        tf_username.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(tf_username);
        tf_username.setBounds(150, 100, 300, 30);

        pf_password.setFont(new java.awt.Font("Georgia", 3, 18)); // NOI18N
        pf_password.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(pf_password);
        pf_password.setBounds(150, 150, 300, 30);

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("ADMIN LOGIN");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(60, 20, 390, 40);

        lblogin.setText("jLabel4");
        lblogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbloginMousePressed(evt);
            }
        });
        getContentPane().add(lblogin);
        lblogin.setBounds(150, 200, 110, 70);

        jLabel4.setFont(new java.awt.Font("Georgia", 3, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("LOGIN");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(140, 290, 130, 20);

        lbFP.setText("jLabel4");
        lbFP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbFPMousePressed(evt);
            }
        });
        getContentPane().add(lbFP);
        lbFP.setBounds(350, 200, 90, 70);

        jLabel5.setFont(new java.awt.Font("Georgia", 3, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 204));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Forgot Password");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(310, 290, 170, 20);
        getContentPane().add(lbmaincover);
        lbmaincover.setBounds(0, 0, 510, 330);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbloginMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbloginMousePressed
        // TODO add your handling code here:
        checkLogin();
    }//GEN-LAST:event_lbloginMousePressed

    private void lbFPMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbFPMousePressed
        checkFP();        // TODO add your handling code here:
    }//GEN-LAST:event_lbFPMousePressed

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
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               new Admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lbFP;
    private javax.swing.JLabel lblogin;
    private javax.swing.JLabel lbmaincover;
    private javax.swing.JPasswordField pf_password;
    private javax.swing.JTextField tf_username;
    // End of variables declaration//GEN-END:variables

    private void checkLogin() {
        String username = tf_username.getText();
        String password = pf_password.getText();
        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please provide required fields");
        } else {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Driver Loading done");

                Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/parkingbookingsystem", "root", "system");
                System.out.println("Connection Created");

                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);
                System.out.println("Statement Created");

                ResultSet rs = stmt.executeQuery("select * from Admin where email='" + username + "' and password='" + password + "'");
                System.out.println("ResultSet Created\n\n");
                if (rs.next()) {
                    JOptionPane.showMessageDialog(this, "Login Successfull");
                    dispose();
                    Admin_Home obj = new Admin_Home(username);
                } else {
                    JOptionPane.showMessageDialog(this, "Login Failed");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void checkFP() {
        String s = JOptionPane.showInputDialog(this, "Enter your email");
        if (s.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please provide required field");
        } else {
            try {

                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Driver Loading done");

                Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/parkingbookingsystem", "root", "system");
                System.out.println("Connection Created");

                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);
                System.out.println("Statement Created");
                ResultSet rs = stmt.executeQuery("select * from Admin where email='" + s + "'");
                System.out.println("ResultSet Created\n\n");
                if (rs.next()) {

                    String sec_ques = rs.getString("sec_ques");
                    String ans = JOptionPane.showInputDialog(this, sec_ques);
                    if (ans.isEmpty()) {
                        JOptionPane.showMessageDialog(this, "Please provide ans");
                    } else {
                        ResultSet rs1 = stmt.executeQuery("select * from Admin where email='" + s + "' and sec_ans='" + ans + "'");
                        if (rs1.next()) {
                            String password = rs1.getString("password");
                            JOptionPane.showMessageDialog(this, "your password is " + password);
                        } else {
                            JOptionPane.showMessageDialog(this, "Wrong answer");
                        }

                    }

                } else {
                    JOptionPane.showMessageDialog(this, "Wrong email");
                }
            } catch (Exception e) {
            }
        }
    }
}
