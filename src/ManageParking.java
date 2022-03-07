
import java.awt.Image;
import java.awt.Toolkit;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class ManageParking extends javax.swing.JFrame {

    ArrayList<SingleOwnerParking> al_sop;
    ViewOwnerParkingModel vopm;
    Client c;
    String email;
    int row;

    public ManageParking(String email) {
        initComponents();
        setSize(620, 500);
        setVisible(true);
        setTitle("Manage your Parkings");
        setResizable(false);
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
        
        e.printStackTrace();}
        this.email = email;
        al_sop = new ArrayList<>();
        vopm = new ViewOwnerParkingModel();
        jt_manage_owner_parkings.setModel(vopm);
        c = new Client();
        new Thread(c).start();
        fetchparking();

    }

    public void fetchparking() {
        try {
            c.dos.writeBytes("send owner parkings\r\n");
            c.dos.writeBytes(email + "\r\n");

        } catch (Exception ex) {

            ex.printStackTrace();
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
                    if (resp.equals("sending owner parking info")) {
                        while (true) {
                            String parkingname = dis.readLine();
                            if (parkingname.equals("owner parking info done")) {

                                break;
                            }
                            String pphoto = dis.readLine();
                            String pareaid = dis.readLine();
                            String areaname = dis.readLine();
                            String pid = dis.readLine();
                            System.out.println("pphoto= "+pphoto);
                            al_sop.add(new SingleOwnerParking(parkingname, pphoto, areaname, pareaid, pid));
                        }
                        vopm.fireTableDataChanged();
                    }
                    else if(resp.equals("parking deleted successfully"))
                    {
                        JOptionPane.showMessageDialog(ManageParking.this,"Parking Deleted Successfully");
                        al_sop.remove(row);
                        vopm.fireTableDataChanged();
                    }

                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    class ViewOwnerParkingModel extends AbstractTableModel {

        String title[] = {"sno", "Parking name", "Parking Area"};

        public String getColumnName(int index) {
            return title[index];
        }

        @Override
        public int getRowCount() {
            return al_sop.size();
        }

        @Override
        public int getColumnCount() {
            return title.length;
        }

        @Override
        public Object getValueAt(int rowindex, int columnindex) {
            if (columnindex == 0) {
                return "" + (rowindex + 1);
            } else if (columnindex == 1) {
                return al_sop.get(rowindex).parkingname;
            } else {
                return al_sop.get(rowindex).parkingarea;
            }

        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jt_manage_owner_parkings = new javax.swing.JTable();
        bt_edit_owner_parking = new javax.swing.JButton();
        bt_delete_owner_parking = new javax.swing.JButton();
        lb_background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jScrollPane1.setViewportView(jt_manage_owner_parkings);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(60, 80, 360, 160);

        bt_edit_owner_parking.setBackground(new java.awt.Color(0, 0, 0));
        bt_edit_owner_parking.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        bt_edit_owner_parking.setForeground(new java.awt.Color(255, 255, 255));
        bt_edit_owner_parking.setText("Edit");
        bt_edit_owner_parking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_edit_owner_parkingActionPerformed(evt);
            }
        });
        getContentPane().add(bt_edit_owner_parking);
        bt_edit_owner_parking.setBounds(70, 290, 140, 40);

        bt_delete_owner_parking.setBackground(new java.awt.Color(0, 0, 0));
        bt_delete_owner_parking.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        bt_delete_owner_parking.setForeground(new java.awt.Color(255, 255, 255));
        bt_delete_owner_parking.setText("Delete");
        bt_delete_owner_parking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_delete_owner_parkingActionPerformed(evt);
            }
        });
        getContentPane().add(bt_delete_owner_parking);
        bt_delete_owner_parking.setBounds(280, 290, 130, 40);

        lb_background.setText("jLabel1");
        getContentPane().add(lb_background);
        lb_background.setBounds(-10, -6, 640, 480);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_edit_owner_parkingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_edit_owner_parkingActionPerformed
        int index = jt_manage_owner_parkings.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row");
        } else {
            String parkingname = al_sop.get(index).parkingname;
            String parkingarea = al_sop.get(index).parkingarea;
            String areaid = al_sop.get(index).parkingareaid;
            String pphoto = al_sop.get(index).parkingareaphoto;
            EditOwnerParking eop = new EditOwnerParking(parkingname, parkingarea, pphoto, areaid, email);

        }
    }//GEN-LAST:event_bt_edit_owner_parkingActionPerformed

    private void bt_delete_owner_parkingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_delete_owner_parkingActionPerformed
        try {
             row = jt_manage_owner_parkings.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Please select a row");
            } else {
                int dialogButton = JOptionPane.YES_NO_OPTION;
                int dialogResult = JOptionPane.showConfirmDialog(this, "Are you sure to delete this row",
                        "CONFIRM", dialogButton);
                if (dialogResult == JOptionPane.YES_OPTION) {
                    String pid = al_sop.get(row).pid;
                    c.dos.writeBytes("deleteparking\r\n");
                    c.dos.writeBytes(pid + "\r\n");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_bt_delete_owner_parkingActionPerformed

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
            java.util.logging.Logger.getLogger(ManageParking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageParking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageParking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageParking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               // new ManageParking("").setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_delete_owner_parking;
    private javax.swing.JButton bt_edit_owner_parking;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jt_manage_owner_parkings;
    private javax.swing.JLabel lb_background;
    // End of variables declaration//GEN-END:variables
}

class SingleOwnerParking {

    String parkingname;
    String parkingareaphoto;
    String parkingarea;
    String parkingareaid;
    String pid;

    SingleOwnerParking(String parkingname, String pphoto, String areaname, String pareaid, String pid) {
        this.pid = pid;
        this.parkingname = parkingname;
        this.parkingareaphoto = pphoto;
        this.parkingarea = areaname;
        this.parkingareaid = pareaid;
    }

}
