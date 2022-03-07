
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.net.URL;
import java.util.StringTokenizer;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class FinalSlotsBill extends javax.swing.JFrame {

    String slotname;
    int count;
    int bill;

    public FinalSlotsBill(int count, String Slotname) {
        initComponents();
        setSize(500, 500);
        setVisible(true);
        setResizable(false);
        setTitle("Welcome");
        this.count = count;
        this.slotname = Slotname;
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        int x = (width / 2) - (this.getWidth() / 2);
        int y = (height / 2) - (this.getHeight() / 2);
        setLocation(x, y);
        try {
            File f=new File(System.getProperty("user.home")+"\\images\\logo2.jpg");
            Image scaledInstance = ImageIO.read(f).getScaledInstance(lb_background.getWidth(), lb_background.getHeight(),
                    Image.SCALE_SMOOTH);
            lb_background.setIcon(new ImageIcon(scaledInstance));
        } catch (Exception e) {
        }

        StringTokenizer st = new StringTokenizer(slotname, "~~");
        while (st.hasMoreTokens()) {
            String singlename = st.nextToken();
            if (singlename.contains("Medium")) {
                bill = bill + 30;
            }
            if (singlename.contains("Big")) {
                bill = bill + 50;
            }
            if (singlename.contains("Small")) {
                bill = bill + 20;
            }

        }

        File f=new File(System.getProperty("user.home")+"\\images\\dummy.jpg");
        String photo1 = f.getPath();
        String[] split = slotname.split("~~");
        //  String photo1 = "C:\\Users\\Lab-4\\Documents\\parking\\parking-sign.png";
        try {
            int x1 = 10;
            int y1 = 10;
            int height1 = (split.length * 150) + (split.length * 10);
            jp_final_slots.setPreferredSize(new Dimension(getWidth() - 150, height1));
            jp_final_slots.setSize(getWidth() - 150, jp_final_slots.getHeight());
            for (int i = 0; i < split.length; i++) {

                SingleSlot singleSlot = new SingleSlot();
                singleSlot.setBounds(x1, y1, 120, 150);
                singleSlot.lbslotname.setText(split[i]);
                Image img = ImageIO.read(new File(photo1));
                Image bimg = img.getScaledInstance(singleSlot.lbslotphoto.getWidth(), singleSlot.lbslotphoto.getHeight(),
                        Image.SCALE_SMOOTH);
                ImageIcon imgic = new ImageIcon(bimg);
                singleSlot.lbslotphoto.setIcon(imgic);

                jp_final_slots.add(singleSlot);
                jp_final_slots.repaint();
                if (((i + 1) % 4) == 0) {
                    x1 = 10;
                    y1 = y1 + 150 + 10;
                } else {
                    x1 = x1 + singleSlot.getWidth() + 10;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        lb_bill.setText("Your Total Bill is " + bill);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb_slots_booked1 = new javax.swing.JLabel();
        lb_slots_booked = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jp_final_slots = new javax.swing.JPanel();
        lb_bill = new javax.swing.JLabel();
        lb_background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        lb_slots_booked1.setFont(new java.awt.Font("Georgia", 3, 18)); // NOI18N
        lb_slots_booked1.setForeground(new java.awt.Color(255, 255, 255));
        lb_slots_booked1.setText("Parking Slots Booked Successfully");
        getContentPane().add(lb_slots_booked1);
        lb_slots_booked1.setBounds(10, 10, 490, 60);

        lb_slots_booked.setFont(new java.awt.Font("Georgia", 3, 18)); // NOI18N
        lb_slots_booked.setForeground(new java.awt.Color(255, 255, 255));
        lb_slots_booked.setText("Your parking Slots are");
        getContentPane().add(lb_slots_booked);
        lb_slots_booked.setBounds(10, 60, 490, 60);

        jp_final_slots.setBackground(new java.awt.Color(255, 255, 255));
        jp_final_slots.setLayout(null);
        jScrollPane1.setViewportView(jp_final_slots);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 130, 420, 190);

        lb_bill.setFont(new java.awt.Font("Georgia", 3, 18)); // NOI18N
        lb_bill.setText("Total Bill is ");
        getContentPane().add(lb_bill);
        lb_bill.setBounds(20, 370, 410, 50);

        lb_background.setText("jLabel1");
        getContentPane().add(lb_background);
        lb_background.setBounds(-26, -146, 680, 660);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

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
            java.util.logging.Logger.getLogger(FinalSlotsBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FinalSlotsBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FinalSlotsBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FinalSlotsBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FinalSlotsBill(10, "").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jp_final_slots;
    private javax.swing.JLabel lb_background;
    private javax.swing.JLabel lb_bill;
    private javax.swing.JLabel lb_slots_booked;
    private javax.swing.JLabel lb_slots_booked1;
    // End of variables declaration//GEN-END:variables
}
