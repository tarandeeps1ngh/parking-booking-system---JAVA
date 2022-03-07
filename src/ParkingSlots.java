
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ParkingSlots extends javax.swing.JFrame {

    String pid;
    FetchSlots fc;
    ArrayList<SlotsForUsers> al_slots;
    String slotentry = "<html>";
    String slotid = "";
    String email, dateofbooking, pname;
    int count;

    public ParkingSlots(String pid, String pname, String dateofbooking, String email) {
        initComponents();
        setSize(700, 500);
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        int x = (width / 2) - (this.getWidth() / 2);
        int y = (height / 2) - (this.getHeight() / 2);
        setLocation(x, y);
        try {
            File f=new File(System.getProperty("user.home")+"\\images\\e.jpg");
            Image scaledInstance = ImageIO.read(f).getScaledInstance(lb_background.getWidth(), lb_background.getHeight(),
                    Image.SCALE_SMOOTH);
            lb_background.setIcon(new ImageIcon(scaledInstance));
        } catch (Exception e) {
        }
        this.pid = pid;
        this.email = email;
        this.pname = pname;
        this.dateofbooking = dateofbooking;
        al_slots = new ArrayList<>();
        fc = new FetchSlots();
        lbParkingName.setText("Select slot to book in " + pname + " parking,for day " + dateofbooking);
        new Thread(fc).start();
        getSlots();
    }

    public void getSlots() {
        try {
            fc.dos.writeBytes("Get Parking Slots for users\r\n");
            fc.dos.writeBytes(pid + "\r\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbParkingName = new javax.swing.JLabel();
        lb_slot_entry = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jpPlots = new javax.swing.JPanel();
        lb_background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        lbParkingName.setFont(new java.awt.Font("Georgia", 3, 10)); // NOI18N
        lbParkingName.setForeground(new java.awt.Color(255, 255, 255));
        lbParkingName.setText("jLabel1");
        getContentPane().add(lbParkingName);
        lbParkingName.setBounds(10, 11, 601, 13);

        lb_slot_entry.setFont(new java.awt.Font("Georgia", 3, 12)); // NOI18N
        lb_slot_entry.setText("jLabel1");
        getContentPane().add(lb_slot_entry);
        lb_slot_entry.setBounds(10, 280, 630, 90);

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Book Parking Slots");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(10, 380, 180, 40);

        jpPlots.setBackground(new java.awt.Color(255, 255, 255));
        jpPlots.setLayout(null);
        jScrollPane1.setViewportView(jpPlots);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(2, 40, 640, 230);

        lb_background.setText("jLabel1");
        getContentPane().add(lb_background);
        lb_background.setBounds(0, 0, 800, 540);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (slotentry.equals("")) {
            JOptionPane.showMessageDialog(this, "Please select some slots to book....");
        } else {
            StringTokenizer st = new StringTokenizer(slotid, "~~");
            try {
                fc.dos.writeBytes("book slots for users\r\n");
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            fc.dos.writeBytes("sending slot ids\r\n");
                            while (st.hasMoreTokens()) {
                                String singleslotid = st.nextToken();
                                fc.dos.writeBytes(singleslotid + "\r\n");
                                fc.dos.writeBytes(email + "\r\n");
                                fc.dos.writeBytes(dateofbooking + "\r\n");
                                fc.dos.writeBytes(pid + "\r\n");
                                count++;
                            }
                            fc.dos.writeBytes("slotids sending done\rn");

                        } catch (Exception e) {
                            e.printStackTrace();

                        }
                    }
                }).start();

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
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
            java.util.logging.Logger.getLogger(ParkingSlots.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ParkingSlots.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ParkingSlots.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ParkingSlots.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
              //  new ParkingSlots("16", "R5", "", "a").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jpPlots;
    private javax.swing.JLabel lbParkingName;
    private javax.swing.JLabel lb_background;
    private javax.swing.JLabel lb_slot_entry;
    // End of variables declaration//GEN-END:variables

    class FetchSlots implements Runnable {

        Socket sock;
        DataOutputStream dos;
        DataInputStream dis;

        public FetchSlots() {
            try {
                sock = new Socket("127.0.0.1", 4200);
                dos = new DataOutputStream(sock.getOutputStream());
                dis = new DataInputStream(sock.getInputStream());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            try {

                while (true) {
                    String res = dis.readLine();
                    if (res.equals("sending slots for users")) {
                        while (true) {
                            String slotid = dis.readLine();
                            if (slotid.equals("slots for users done")) {
                                break;
                            }
                            String slotname = dis.readLine();
                            String slottype = dis.readLine();
                            String slotprice = dis.readLine();
                            al_slots.add(new SlotsForUsers(slotid, slotname, slottype, slotprice));
                        }

                        showSlots();
                    } else if (res.equals("all slots booked")) {
                        JOptionPane.showMessageDialog(ParkingSlots.this, "all slots booked");
                        System.out.println(slotentry);
                        if(slotentry.contains("<br>"))
                        {
                            slotentry=slotentry.replace("<br>","");
                        }
                        FinalSlotsBill ob = new FinalSlotsBill(count, slotentry);

                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private void showSlots() {
            File f=new File(System.getProperty("user.home")+"\\images\\dummy.jpg");
            String photo1 = f.getPath();
            //  String photo1 = "C:\\Users\\Lab-4\\Documents\\parking\\parking-sign.png";
            try {
                int x = 10;
                int y = 10;
                int height = (al_slots.size() * 150) + (al_slots.size() * 10);
                jpPlots.setPreferredSize(new Dimension(getWidth() - 150, height));
                jpPlots.setSize(getWidth() - 150, jpPlots.getHeight());
                for (int i = 0; i < al_slots.size(); i++) {
                    SlotsForUsers slot = al_slots.get(i);
                    SingleSlot singleSlot = new SingleSlot();
                    singleSlot.setBounds(x, y, 140, 150);
                    singleSlot.lbslotname.setText(slot.slotname);
                    Image img = ImageIO.read(new File(photo1));
                    Image bimg = img.getScaledInstance(singleSlot.lbslotphoto.getWidth(), singleSlot.lbslotphoto.getHeight(),
                            Image.SCALE_SMOOTH);
                    ImageIcon imgic = new ImageIcon(bimg);
                    singleSlot.lbslotphoto.setIcon(imgic);
                    singleSlot.lbslotphoto.setToolTipText("Price " + slot.slotprice);
                    singleSlot.lbslotphoto.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                           // lb_slot_entry.setText("<html>");
                            
                            
                            String s = slot.slotname + "~~";
                            String s1 = slot.slotid + "~~";
                            if (slotentry.contains(s)) {
                                slotentry = slotentry.replace(s, "");
                                slotid = slotid.replace(s1, "");
                            } else {
                                slotentry = slotentry + s+"<br>";
                                slotid = slotid + s1;
                            }
                            
                            lb_slot_entry.setText(slotentry + "</html>");
                            //lb_slot_entry.setText("</html>");
                            System.out.println("slotid is " + slotid);
                        }
                    });

                    jpPlots.add(singleSlot);
                    jpPlots.repaint();
                    if (((i + 1) % 4) == 0) {
                        x = 10;
                        y = y + 150 + 10;
                    } else {
                        x = x + singleSlot.getWidth() + 10;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}

class SlotsForUsers {

    String slotid, slotname, slottype, slotprice;

    public SlotsForUsers(String slotid, String slotname, String slottype, String slotprice) {
        this.slotid = slotid;
        this.slotname = slotname;
        this.slottype = slottype;
        this.slotprice = slotprice;
    }

}
