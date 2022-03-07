
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.omg.PortableServer.THREAD_POLICY_ID;

public class UserHome extends javax.swing.JFrame {

    String useremail;
    ArrayList<String> al_photos;

    public UserHome(String useremail) {
        initComponents();
        setSize(500, 500);
        setVisible(true);
        setResizable(false);
        setTitle("Welcome");

        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        int x = (width / 2) - (this.getWidth() / 2);
        int y = (height / 2) - (this.getHeight() / 2);
        setLocation(x, y);
        final PanelSlider42<JPanel> slider = new PanelSlider42<JPanel>(jp_slider);
        final JPanel jPanel = slider.getBasePanel();
        File f=new File(System.getProperty("user.home")+"\\images\\d.jpg");
        File f1=new File(System.getProperty("user.home")+"\\images\\a.jpg");
        File f2=new File(System.getProperty("user.home")+"\\images\\b.jpg");
        File f3=new File(System.getProperty("user.home")+"\\images\\c.jpg");
        String image1 = f.getPath();
        String image2 = f1.getPath();
        String image3 = f2.getPath();
        String image4 = f3.getPath();
//                URL resource3 = getClass().getResource("c.jpg");
        String images[] = {image1, image2, image3, image4};

        for (int i = 0; i < images.length; i++) {
            try {
                JLabel lb = new JLabel();

                BufferedImage image = ImageIO.read(new File(images[i]));
                BufferedImage img = UserHome.resize(image, 500, 210);
                lb.setIcon(new ImageIcon(img));
                slider.addComponent(lb);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        slider.test();

        jPanel.setBounds(0, 0, 500, 210);
        jp_slider.add(jPanel);

        try {
            File f4=new File(System.getProperty("user.home")+"\\images\\back.jpg");
                    Image scaledInstance = ImageIO.read(f4).getScaledInstance(lb_background.getWidth(), lb_background.getHeight(),
                            Image.SCALE_SMOOTH);
                    lb_background.setIcon(new ImageIcon(scaledInstance));
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.useremail = useremail;
        lb_user_welcome.setText("Welcome  " + useremail);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb_user_welcome = new javax.swing.JLabel();
        jp_slider = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        lb_background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        lb_user_welcome.setFont(new java.awt.Font("Myanmar Text", 3, 36)); // NOI18N
        lb_user_welcome.setForeground(new java.awt.Color(255, 255, 255));
        lb_user_welcome.setText("Welcome");
        getContentPane().add(lb_user_welcome);
        lb_user_welcome.setBounds(110, 20, 450, 40);

        jp_slider.setLayout(null);
        getContentPane().add(jp_slider);
        jp_slider.setBounds(0, 110, 590, 200);

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("BOOK PARKING");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(30, 340, 160, 40);

        lb_background.setText("jLabel1");
        getContentPane().add(lb_background);
        lb_background.setBounds(0, 0, 630, 490);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        BookParking bookParking = new BookParking(useremail);
        bookParking.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(UserHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               // new UserHome("").setVisible(true);

            }
        });
    }

    public static BufferedImage resize(BufferedImage image, int width, int height) {
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
        Graphics2D g2d = (Graphics2D) bi.createGraphics();
        g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
        g2d.drawImage(image, 0, 0, width, height, null);
        g2d.dispose();
        System.out.println(bi);
        return bi;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jp_slider;
    private javax.swing.JLabel lb_background;
    private javax.swing.JLabel lb_user_welcome;
    // End of variables declaration//GEN-END:variables
}
