
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class BookParking extends javax.swing.JFrame {

    Client c;
    String piduserselected = "";
    ArrayList<GetArea> getareas;
    ArrayList<GetUserParking> al_user_parking;
    String email;

    public BookParking(String email) {
        initComponents();
        this.email = email;
        setSize(510, 670);
        setVisible(true);
        setTitle("Book Your parking");
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        int x = (width / 2) - (this.getWidth() / 2);
        int y = (height / 2) - (this.getHeight() / 2);
       
        setLocation(x, y);
        setResizable(false);
        try {
            File f=new File(System.getProperty("user.home")+"\\images\\d.png");
                    Image scaledInstance = ImageIO.read(f).getScaledInstance(lb_background.getWidth(), lb_background.getHeight(),
                            Image.SCALE_SMOOTH);
                    lb_background.setIcon(new ImageIcon(scaledInstance));
        } catch (Exception e) {
        e.printStackTrace();
        }
       // jScrollPane1.setOpaque(false);
        getareas = new ArrayList<>();
        al_user_parking = new ArrayList<>();
        c = new Client();
        new Thread(c).start();
        getAreas();

    }

    public void getAreas() {
        try {
            c.dos.writeBytes("Get Parking Areas\r\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class GetArea {

        String id;
        String areaname;

        public GetArea(String id, String areaname) {
            this.id = id;
            this.areaname = areaname;
        }

        @Override
        public String toString() {
            return areaname; //To change body of generated methods, choose Tools | Templates.
        }

    }

    class GetUserParking {

        String pid;
        String pphoto;
        String pname;

        public GetUserParking(String id, String areaname, String pname) {
            this.pid = id;
            this.pphoto = areaname;
            this.pname = pname;
        }

        @Override
        public String toString() {
            return pphoto; //To change body of generated methods, choose Tools | Templates.
        }

    }

    class Client implements Runnable {

        Socket sock;
        DataOutputStream dos;
        DataInputStream dis;

        public Client() {
            try {
                sock = new Socket("127.0.0.1", 4200);

                dos = new DataOutputStream(sock.getOutputStream());
                dis = new DataInputStream(sock.getInputStream());
            } catch (Exception e) {
            }
        }

        @Override
        public void run() {

            try {
                while (true) {
                    String resp = dis.readLine();
                    if (resp.equals("sending user areas")) {
                        while (true) {
                            String areaname = dis.readLine();

                            if (areaname.equals("all user areas done")) {
                                break;
                            } else if (areaname.contains("~~")) {
                                String[] split = areaname.split("~~");
                                getareas.add(new GetArea(split[1], split[0]));
                                cb_user_book_parking_area.addItem(split[0]);
                            }
                        }
                    } else if (resp.equals("sending user parkings")) {
                        String count = "";
                        while (true) {
                            String parkinginfo = dis.readLine();
                            if (parkinginfo.equals("user parkings done")) {
                                count = dis.readLine();
                                break;

                            } else if (parkinginfo.contains("~~")) {
                                String[] split = parkinginfo.split("~~");
                                al_user_parking.add(new GetUserParking(split[1], split[0], split[2]));

                            }
                        }

                        showParkings();
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        private void showParkings() {
            try {
                view_parking_info.setText("");
                int lcount = al_user_parking.size();
                int x = 50;
                int y = 30;
                jp_main.setPreferredSize(new Dimension(500, lcount * 50));
                jp_main.setBackground(Color.BLACK);

                JPanel jp[] = new JPanel[lcount];

                for (int i = 0; i < jp.length; i++) {
                    final int j = i;
                    if (x >= 500) {
                        x = 50;
                        y = 150;
                    }
                    jp[i] = new JPanel();
                    jp[i].setBounds(x, y, 100, 100);
                    jp[i].setBackground(Color.WHITE);
                    jp[i].setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.BLACK));
                    JLabel lb = new JLabel();
                    lb.setBounds(20, 40, 70, 70);
                    GetUserParking getUserParking = al_user_parking.get(i);

                    lb.setToolTipText(getUserParking.pname);
                    File f = new File(getUserParking.pphoto);
                    Image img = ImageIO.read(f);
                    Image bimg = img.getScaledInstance(lb.getWidth(), lb.getHeight(), Image.SCALE_SMOOTH);
                    ImageIcon imgic = new ImageIcon(bimg);
                    lb.setIcon(imgic);
                    jp[i].add(lb);
                    lb.addMouseListener(new MouseAdapter() {
                        public void mouseClicked(MouseEvent e) {
                            piduserselected = al_user_parking.get(j).pid;
                            view_parking_info.setText("You select " + getUserParking.pname + "\n");
                            view_parking_info.setToolTipText(piduserselected + "");
                        }
                    });
                    jp_main.add(jp[i]);
                    jp_main.repaint();
                    x = x + 150;
                }
                repaint();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cb_user_book_parking_city = new javax.swing.JComboBox<>();
        cb_user_book_parking_area = new javax.swing.JComboBox<>();
        cb_user_book_date = new javax.swing.JComboBox<>();
        cb_user_book_month = new javax.swing.JComboBox<>();
        cb__user_book_year = new javax.swing.JComboBox<>();
        bt_user_book_viewparkingslots = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jp_main = new javax.swing.JPanel();
        view_parking_info = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lb_background = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Georgia", 3, 10)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("PARKING CITY");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 90, 80, 30);

        jLabel2.setFont(new java.awt.Font("Georgia", 3, 10)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("AREA");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 130, 80, 40);

        cb_user_book_parking_city.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Amritsar" }));
        getContentPane().add(cb_user_book_parking_city);
        cb_user_book_parking_city.setBounds(110, 90, 220, 30);

        cb_user_book_parking_area.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));
        cb_user_book_parking_area.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_user_book_parking_areaItemStateChanged(evt);
            }
        });
        getContentPane().add(cb_user_book_parking_area);
        cb_user_book_parking_area.setBounds(110, 140, 220, 30);

        cb_user_book_date.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31" }));
        getContentPane().add(cb_user_book_date);
        cb_user_book_date.setBounds(390, 90, 80, 20);

        cb_user_book_month.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "January", "February", "March", "April","May","June","July","August","September","October","November","December" }));
        getContentPane().add(cb_user_book_month);
        cb_user_book_month.setBounds(390, 120, 80, 20);

        cb__user_book_year.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2017" }));
        cb__user_book_year.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb__user_book_yearActionPerformed(evt);
            }
        });
        getContentPane().add(cb__user_book_year);
        cb__user_book_year.setBounds(390, 150, 80, 20);

        bt_user_book_viewparkingslots.setBackground(new java.awt.Color(0, 0, 0));
        bt_user_book_viewparkingslots.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        bt_user_book_viewparkingslots.setForeground(new java.awt.Color(255, 255, 255));
        bt_user_book_viewparkingslots.setText("VIEW PARKING SLOTS");
        bt_user_book_viewparkingslots.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_user_book_viewparkingslotsActionPerformed(evt);
            }
        });
        getContentPane().add(bt_user_book_viewparkingslots);
        bt_user_book_viewparkingslots.setBounds(240, 580, 230, 40);

        javax.swing.GroupLayout jp_mainLayout = new javax.swing.GroupLayout(jp_main);
        jp_main.setLayout(jp_mainLayout);
        jp_mainLayout.setHorizontalGroup(
            jp_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 458, Short.MAX_VALUE)
        );
        jp_mainLayout.setVerticalGroup(
            jp_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 328, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jp_main);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 180, 460, 330);

        view_parking_info.setFont(new java.awt.Font("Georgia", 3, 12)); // NOI18N
        view_parking_info.setForeground(new java.awt.Color(255, 255, 255));
        view_parking_info.setText("jLabel3");
        getContentPane().add(view_parking_info);
        view_parking_info.setBounds(10, 520, 460, 50);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("dd");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(370, 90, 20, 14);

        jLabel4.setFont(new java.awt.Font("Georgia", 3, 8)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("     mm");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(356, 120, 30, 20);

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("yy");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(370, 150, 12, 14);

        jLabel6.setFont(new java.awt.Font("Georgia", 3, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("SELECT YOUR PARKING CRITERIA");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(10, 20, 460, 30);

        lb_background.setText("jLabel7");
        getContentPane().add(lb_background);
        lb_background.setBounds(-6, -10, 510, 650);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cb__user_book_yearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb__user_book_yearActionPerformed

    }//GEN-LAST:event_cb__user_book_yearActionPerformed

    private void bt_user_book_viewparkingslotsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_user_book_viewparkingslotsActionPerformed

        if (piduserselected.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please select a Parking to book!!");
        } else {
            int index = cb_user_book_parking_area.getSelectedIndex();
            String areaid = getareas.get(index).id;
            String day = (String) cb_user_book_date.getSelectedItem();
            String month = (String) cb_user_book_month.getSelectedItem();
            String year = (String) cb__user_book_year.getSelectedItem();
            String date = day + "-" + month + "-" + year;
            String pid = view_parking_info.getToolTipText();
            ParkingSlots parkingSlots = new ParkingSlots(pid, view_parking_info.getText(), date,email);
            parkingSlots.setVisible(true);
        }


    }//GEN-LAST:event_bt_user_book_viewparkingslotsActionPerformed

    private void cb_user_book_parking_areaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_user_book_parking_areaItemStateChanged
        try {
            al_user_parking.clear();
            jp_main.removeAll();
            String areaid = getareas.get(cb_user_book_parking_area.getSelectedIndex()).id;
            c.dos.writeBytes("send parkings for users\r\n");
            c.dos.writeBytes(areaid + "\r\n");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_cb_user_book_parking_areaItemStateChanged

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
            java.util.logging.Logger.getLogger(BookParking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BookParking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BookParking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookParking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               //new BookParking("a").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_user_book_viewparkingslots;
    public javax.swing.JComboBox<String> cb__user_book_year;
    public javax.swing.JComboBox<String> cb_user_book_date;
    public javax.swing.JComboBox<String> cb_user_book_month;
    public javax.swing.JComboBox<String> cb_user_book_parking_area;
    public javax.swing.JComboBox<String> cb_user_book_parking_city;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jp_main;
    private javax.swing.JLabel lb_background;
    private javax.swing.JLabel view_parking_info;
    // End of variables declaration//GEN-END:variables
}
