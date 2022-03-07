
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

public class AddParkingSlots extends javax.swing.JFrame
{

    Client c;
    String email;
    ArrayList<Parkings> al_parkings;

    public AddParkingSlots(String email)
    {
        initComponents();
        setSize(450, 450);
        setVisible(true);
        setResizable(false);
        setTitle("Add Parking Slots to Database");
         int width=Toolkit.getDefaultToolkit().getScreenSize().width;
        int height=Toolkit.getDefaultToolkit().getScreenSize().height;
      int x=(width/2)-(this.getWidth()/2);
      int y=(height/2)-(this.getHeight()/2);
        setLocation(x, y);
        try {
           File f=new File(System.getProperty("user.home")+"\\images\\imageslot.jpg");
                    Image scaledInstance = ImageIO.read(f).getScaledInstance(lb_background.getWidth(), lb_background.getHeight(),
                            Image.SCALE_SMOOTH);
                    lb_background.setIcon(new ImageIcon(scaledInstance));
        } catch (Exception e) {
        e.printStackTrace();
        }
        c = new Client();
        al_parkings = new ArrayList<>();
        this.email = email;
        new Thread(c).start();
        getParkings();

    }

    public void getParkings()
    {
        try
          {
            c.dos.writeBytes("get parking names\r\n");
            c.dos.writeBytes(this.email + "\r\n");
          } catch (Exception e)
          {
            e.printStackTrace();
          }
    }

    class Client implements Runnable
    {

        Socket sock;
        DataOutputStream dos;
        DataInputStream dis;

        public Client()
        {
            try
              {
                sock = new Socket("127.0.0.1", 4200);

                dos = new DataOutputStream(sock.getOutputStream());
                dis = new DataInputStream(sock.getInputStream());
              } catch (Exception e)
              {
              }
        }

        @Override
        public void run()
        {

            try
              {
                while (true)
                  {
                    String resp = dis.readLine();
                    if (resp.equals("sending parkings"))
                      {
                        while (true)
                          {
                            String pname = dis.readLine();

                            if (pname.equals("all parkings  done"))
                              {
                                break;
                              } else if (pname.contains("~~"))
                              {
                                String[] split = pname.split("~~");
                                al_parkings.add(new Parkings(split[1], split[0]));
                                cb_parkingname.addItem(split[0]);
                              }
                          }

                      } else if (resp.equals("not added any parkings"))
                      {
                        JOptionPane.showMessageDialog(AddParkingSlots.this, "Firstly Add your parkings");
                        bt_addparkingslot.setEnabled(false);
                      } else if (resp.equals("parking slot already exists in this area"))
                      {
                        JOptionPane.showMessageDialog(AddParkingSlots.this, "parking slot already exists in this area");

                      } else if (resp.equals("parking slots added successfully"))
                      {
                        JOptionPane.showMessageDialog(AddParkingSlots.this, "parking slots added successfully");
                        tf_numberofslots.setText("");
                        tf_priceperslot.setText("");
                      }

                  }

              } catch (Exception e)
              {
                e.printStackTrace();
              }

        }

    }

    class Parkings
    {

        String pid;
        String pname;

        public Parkings(String pid, String pname)
        {
            this.pid = pid;
            this.pname = pname;

        }

        @Override
        public String toString()
        {

            return pname; //To change body of generated methods, choose Tools | Templates.
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cb_parkingname = new javax.swing.JComboBox<>();
        cb_parkingslots = new javax.swing.JComboBox<>();
        tf_numberofslots = new javax.swing.JTextField();
        tf_priceperslot = new javax.swing.JTextField();
        bt_addparkingslot = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lb_background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("PARKING NAME");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 22, 130, 40);

        getContentPane().add(cb_parkingname);
        cb_parkingname.setBounds(160, 30, 220, 30);

        cb_parkingslots.setModel(new
            javax.swing.DefaultComboBoxModel<>(new String[] { "Big", "Medium", "Small"}));
        getContentPane().add(cb_parkingslots);
        cb_parkingslots.setBounds(160, 90, 220, 30);
        getContentPane().add(tf_numberofslots);
        tf_numberofslots.setBounds(160, 150, 220, 30);
        getContentPane().add(tf_priceperslot);
        tf_priceperslot.setBounds(160, 250, 220, 30);

        bt_addparkingslot.setBackground(new java.awt.Color(0, 0, 0));
        bt_addparkingslot.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        bt_addparkingslot.setForeground(new java.awt.Color(255, 255, 255));
        bt_addparkingslot.setText("ADD PARKING SLOT");
        bt_addparkingslot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_addparkingslotActionPerformed(evt);
            }
        });
        getContentPane().add(bt_addparkingslot);
        bt_addparkingslot.setBounds(100, 310, 190, 30);

        jLabel2.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        jLabel2.setText("SLOT TYPE");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 100, 120, 20);

        jLabel3.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        jLabel3.setText("NO. OF SLOTS");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 150, 130, 30);

        jLabel4.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("PRICE PER SLOT");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 250, 140, 30);

        lb_background.setText("jLabel5");
        getContentPane().add(lb_background);
        lb_background.setBounds(-6, -6, 470, 420);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_addparkingslotActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_bt_addparkingslotActionPerformed
    {//GEN-HEADEREND:event_bt_addparkingslotActionPerformed
        int index = cb_parkingname.getSelectedIndex();
        String pid = al_parkings.get(index).pid;
        String slotname = (String) cb_parkingslots.getSelectedItem();
        String slotnumber = tf_numberofslots.getText();
        int no_of_slots = Integer.parseInt(slotnumber);

        String priceperslot = tf_priceperslot.getText();

        if (slotnumber.isEmpty() || priceperslot.isEmpty())
          {
            JOptionPane.showMessageDialog(this, "Please fill the reqd data");
          } else if (no_of_slots > 50)
          {
            JOptionPane.showMessageDialog(this, "No of slots cannot be more than 50");
          } else
          {
            try
              {
                c.dos.writeBytes("add parking slots\r\n");
                c.dos.writeBytes(pid + "\r\n");
                c.dos.writeBytes(slotname + "\r\n");
                c.dos.writeBytes(slotnumber + "\r\n");
                c.dos.writeBytes(priceperslot + "\r\n");
              } catch (Exception ex)
              {
                ex.printStackTrace();
              }

          }
    }//GEN-LAST:event_bt_addparkingslotActionPerformed

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
            java.util.logging.Logger.getLogger(AddParkingSlots.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (InstantiationException ex)
          {
            java.util.logging.Logger.getLogger(AddParkingSlots.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (IllegalAccessException ex)
          {
            java.util.logging.Logger.getLogger(AddParkingSlots.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (javax.swing.UnsupportedLookAndFeelException ex)
          {
            java.util.logging.Logger.getLogger(AddParkingSlots.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                //new AddParkingSlots("a@gmail.com").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_addparkingslot;
    public javax.swing.JComboBox<String> cb_parkingname;
    public javax.swing.JComboBox<String> cb_parkingslots;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lb_background;
    private javax.swing.JTextField tf_numberofslots;
    private javax.swing.JTextField tf_priceperslot;
    // End of variables declaration//GEN-END:variables
}
