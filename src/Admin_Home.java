
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Admin_Home extends javax.swing.JFrame {

    String email;

    public Admin_Home(String email) {
        initComponents();
        
        setSize(640,600);
        setVisible(true);
         setTitle("Welcome to Admin Home ");
        setResizable(false);
        try{
        File f=new File(System.getProperty("user.home")+"\\images\\backgroundimage.png");
                    Image scaledInstance = ImageIO.read(f).getScaledInstance(lb_background.getWidth(), lb_background.getHeight(),
                            Image.SCALE_SMOOTH);
                    lb_background.setIcon(new ImageIcon(scaledInstance));
        }catch(Exception e)
        {
            e.printStackTrace();
        }
                    int width=Toolkit.getDefaultToolkit().getScreenSize().width;
        int height=Toolkit.getDefaultToolkit().getScreenSize().height;
      int x=(width/2)-(this.getWidth()/2);
      int y=(height/2)-(this.getHeight()/2);
        setLocation(x, y);
        this.email = email;
        jp_manage_categories.setOpaque(false);
        jp_manage_areas.setOpaque(false);
        //jp_manage_categories.setBackground(Color.WHITE);
        new Thread(new Server()).start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bt_change_password = new javax.swing.JButton();
        jp_manage_categories = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        bt_add_category = new javax.swing.JButton();
        bt_view_category = new javax.swing.JButton();
        jp_manage_areas = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        bt_add_area = new javax.swing.JButton();
        bt_manage_area = new javax.swing.JButton();
        lb_background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        bt_change_password.setBackground(new java.awt.Color(0, 0, 0));
        bt_change_password.setFont(new java.awt.Font("Georgia", 3, 18)); // NOI18N
        bt_change_password.setForeground(new java.awt.Color(255, 255, 255));
        bt_change_password.setText("CHANGE PASSWORD");
        bt_change_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_change_passwordActionPerformed(evt);
            }
        });
        getContentPane().add(bt_change_password);
        bt_change_password.setBounds(210, 40, 250, 40);

        jp_manage_categories.setLayout(null);

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Georgia", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("     Manage categories");
        jp_manage_categories.add(jLabel1);
        jLabel1.setBounds(150, 0, 280, 60);

        bt_add_category.setBackground(new java.awt.Color(0, 0, 0));
        bt_add_category.setFont(new java.awt.Font("Georgia", 3, 18)); // NOI18N
        bt_add_category.setForeground(new java.awt.Color(255, 255, 255));
        bt_add_category.setText("Add Category");
        bt_add_category.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_add_categoryActionPerformed(evt);
            }
        });
        jp_manage_categories.add(bt_add_category);
        bt_add_category.setBounds(90, 90, 170, 40);

        bt_view_category.setBackground(new java.awt.Color(0, 0, 0));
        bt_view_category.setFont(new java.awt.Font("Georgia", 3, 18)); // NOI18N
        bt_view_category.setForeground(new java.awt.Color(255, 255, 255));
        bt_view_category.setText("View Category");
        bt_view_category.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_view_categoryActionPerformed(evt);
            }
        });
        jp_manage_categories.add(bt_view_category);
        bt_view_category.setBounds(280, 90, 180, 40);

        getContentPane().add(jp_manage_categories);
        jp_manage_categories.setBounds(80, 130, 500, 160);

        jp_manage_areas.setBackground(new java.awt.Color(255, 255, 255));
        jp_manage_areas.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Georgia", 3, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Manage areas");
        jp_manage_areas.add(jLabel2);
        jLabel2.setBounds(200, 10, 190, 30);

        bt_add_area.setBackground(new java.awt.Color(0, 0, 0));
        bt_add_area.setFont(new java.awt.Font("Georgia", 3, 18)); // NOI18N
        bt_add_area.setForeground(new java.awt.Color(255, 255, 255));
        bt_add_area.setText("Add area");
        bt_add_area.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_add_areaActionPerformed(evt);
            }
        });
        jp_manage_areas.add(bt_add_area);
        bt_add_area.setBounds(110, 80, 160, 40);

        bt_manage_area.setBackground(new java.awt.Color(0, 0, 0));
        bt_manage_area.setFont(new java.awt.Font("Georgia", 3, 18)); // NOI18N
        bt_manage_area.setForeground(new java.awt.Color(255, 255, 255));
        bt_manage_area.setText("Manage area");
        bt_manage_area.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_manage_areaActionPerformed(evt);
            }
        });
        jp_manage_areas.add(bt_manage_area);
        bt_manage_area.setBounds(300, 80, 170, 40);

        getContentPane().add(jp_manage_areas);
        jp_manage_areas.setBounds(70, 390, 520, 150);

        lb_background.setText("jLabel3");
        getContentPane().add(lb_background);
        lb_background.setBounds(0, 0, 630, 580);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_change_passwordActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_bt_change_passwordActionPerformed
    {//GEN-HEADEREND:event_bt_change_passwordActionPerformed
        Admin_Change_Password obj1 = new Admin_Change_Password(email);
    }//GEN-LAST:event_bt_change_passwordActionPerformed

    private void bt_add_categoryActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_bt_add_categoryActionPerformed
    {//GEN-HEADEREND:event_bt_add_categoryActionPerformed
        Addcategory obj2 = new Addcategory();
    }//GEN-LAST:event_bt_add_categoryActionPerformed

    private void bt_view_categoryActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_bt_view_categoryActionPerformed
    {//GEN-HEADEREND:event_bt_view_categoryActionPerformed
        Viewcategory obj3 = new Viewcategory();
    }//GEN-LAST:event_bt_view_categoryActionPerformed

    private void bt_add_areaActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_bt_add_areaActionPerformed
    {//GEN-HEADEREND:event_bt_add_areaActionPerformed
        Add_area obj4 = new Add_area();
    }//GEN-LAST:event_bt_add_areaActionPerformed

    private void bt_manage_areaActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_bt_manage_areaActionPerformed
    {//GEN-HEADEREND:event_bt_manage_areaActionPerformed
        ManageArea obj5 = new ManageArea();
    }//GEN-LAST:event_bt_manage_areaActionPerformed
    class Server implements Runnable {

        ServerSocket sersock;
        Socket sock;

        public Server() {
            try {
                sersock = new ServerSocket(4200);
                System.out.println("Server Started");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            while (true) {
                try {
                    sock = sersock.accept();
                    new Thread(new ClientHandler(sock)).start();
                    System.out.println("Client Connected");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }

    class ClientHandler implements Runnable {

        DataOutputStream dos;
        DataInputStream dis;
        Socket sock;

        public ClientHandler(Socket sock) {
            try {
                this.sock = sock;
                dos = new DataOutputStream(this.sock.getOutputStream());
                dis = new DataInputStream(this.sock.getInputStream());

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            while (true) {
                try {
                    String msg = dis.readLine();

                    if (msg == null) {
                        break;
                    }

                    if (msg.equals("Sign Up")) {
                        signUp();

                    } else if (msg.equals("Login")) {
                        login();
                    } else if (msg.equals("Add Parking Categories")) {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/parkingbookingsystem", "root", "system");
                        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                                ResultSet.CONCUR_UPDATABLE);
                        ResultSet rs = stmt.executeQuery("select * from  category");
                        dos.writeBytes("sending categories\r\n");
                        while (rs.next()) {
                            String cname = rs.getString("cname");
                            dos.writeBytes(cname + "\r\n");
                        }
                        dos.writeBytes("all categories done\r\n");
                    } else if (msg.equals("Add Parking Areas")) {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/parkingbookingsystem", "root", "system");
                        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                                ResultSet.CONCUR_UPDATABLE);
                        ResultSet rs = stmt.executeQuery("select * from  areas");
                        dos.writeBytes("sending areas\r\n");
                        while (rs.next()) {
                            String areaname = rs.getString("areaname");
                            int areaid = rs.getInt("areaid");

                            String data = areaname + "~~" + areaid + "~~";

                            dos.writeBytes(data + "\r\n");

                        }
                        dos.writeBytes("all areas done\r\n");
                    } else if (msg.equals("add parking values")) {
                        String parkingname = dis.readLine();
                        String parkingcategory = dis.readLine();
                        String areaid = dis.readLine();
                        String email = dis.readLine();
                        String photofile = dis.readLine();
                        int areaid1 = Integer.parseInt(areaid);
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/parkingbookingsystem", "root", "system");
                        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                                ResultSet.CONCUR_UPDATABLE);
                        ResultSet rs = stmt.executeQuery("select * from  parkings where"
                                + " pname='" + parkingname + "' and pareaid='" + areaid + "' "
                                + "and pcategory='" + parkingcategory + "'");

                        if (rs.next()) {
                            dos.writeBytes("parking already exists in this area\r\n");
                        } else {
                            rs.moveToInsertRow();
                            rs.updateString("pname", parkingname);
                            rs.updateString("pcategory", parkingcategory);
                            rs.updateInt("pareaid", areaid1);
                            rs.updateString("pphoto", photofile);
                            rs.updateString("pemail", email);
                            rs.insertRow();
                            dos.writeBytes("parking added successfully\r\n");
                        }
                    } else if (msg.equals("get parking names")) {
                        String email = dis.readLine();

                        Class.forName("com.mysql.jdbc.Driver");
                        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/parkingbookingsystem", "root", "system");
                        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                                ResultSet.CONCUR_UPDATABLE);
                        ResultSet rs = stmt.executeQuery("select * from  parkings where pemail='" + email + "'");

                        if (rs.next()) {
                            dos.writeBytes("sending parkings\r\n");
                            rs.beforeFirst();
                            while (rs.next()) {
                                String pname = rs.getString("pname");
                                int pid = rs.getInt("pid");
                                String data = pname + "~~" + pid + "~~";
                                dos.writeBytes(data + "\r\n");
                            }
                            dos.writeBytes("all parkings  done\r\n");
                        } else {
                            dos.writeBytes("not added any parkings\r\n");
                        }
                    } else if (msg.equals("add parking slots")) {
                        String pid = dis.readLine();
                        String slotname = dis.readLine();
                        String slotnumber = dis.readLine();
                        String priceperslot = dis.readLine();

                        int pid1 = Integer.parseInt(pid);
                        int no_ofslots = Integer.parseInt(slotnumber);
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/parkingbookingsystem", "root", "system");
                        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                                ResultSet.CONCUR_UPDATABLE);

                        String type = "";
                        if (slotname.startsWith("Big")) {
                            type = "Type 1";
                        } else if (slotname.startsWith("Med")) {
                            type = "Type 2";
                        } else if (slotname.startsWith("Small")) {
                            type = "Type 3";
                        }

                        for (int i = 1; i <= no_ofslots; i++) {
                            ResultSet rs = stmt.executeQuery("select * from  Parking_slots");
                            rs.moveToInsertRow();
                            rs.updateInt("parkingid", pid1);
                            rs.updateString("slotname", slotname + "_Slot_" + i);
                            rs.updateString("price", priceperslot);
                            rs.updateString("slot_type", type);
                            rs.insertRow();
                            rs.close();
                        }
                        dos.writeBytes("parking slots added successfully\r\n");
                    } else if (msg.equals("send owner parkings")) {
                        fetchOwnerParkings();
                    } else if (msg.equals("User Sign Up")) {
                        UsersignUp();

                    } else if (msg.equals("deleteparking")) {
                        deleteParking();

                    } else if (msg.equals("User Login")) {
                        Userlogin();
                    } else if (msg.equals("update parking values")) {
                        updateParkings();
                    } else if (msg.equals("Get Parking Areas")) {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/parkingbookingsystem", "root", "system");
                        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                                ResultSet.CONCUR_UPDATABLE);
                        ResultSet rs = stmt.executeQuery("select * from  areas");
                        dos.writeBytes("sending user areas\r\n");
                        while (rs.next()) {
                            String areaname = rs.getString("areaname");
                            int areaid = rs.getInt("areaid");

                            String data = areaname + "~~" + areaid + "~~";

                            dos.writeBytes(data + "\r\n");
                        }
                        dos.writeBytes("all user areas done\r\n");
                    } else if (msg.equals("send parkings for users")) {
                        String areaid = dis.readLine();
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/parkingbookingsystem", "root", "system");
                        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                                ResultSet.CONCUR_UPDATABLE);
                        ResultSet rs = stmt.executeQuery("select * from  parkings where pareaid='" + areaid + "'");
                        if (rs.next()) {
                            int count = 0;
                            rs.beforeFirst();
                            dos.writeBytes("sending user parkings\r\n");

                            while (rs.next()) {
                                int pid = rs.getInt("pid");
                                String pphoto = rs.getString("pphoto");
                                String pname = rs.getString("pname");
                                String data = pphoto + "~~" + pid + "~~" + pname + "~~";
                                dos.writeBytes(data + "\r\n");
                                count++;
                            }
                            dos.writeBytes("user parkings done\r\n");
                            dos.writeBytes(count + "\r\n");
                        }
                    }
                    else if(msg.equals("Get Parking Slots for users"))
                    {
                        String pid=dis.readLine();
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/parkingbookingsystem", "root", "system");
                        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                                ResultSet.CONCUR_UPDATABLE);
                        ResultSet rs = stmt.executeQuery("select * from  parking_slots where parkingid='" + pid + "'");
                        if(rs.next())
                        {
                            rs.beforeFirst();
                            dos.writeBytes("sending slots for users\r\n");
                            while(rs.next())
                            {      
                            int slotid1=rs.getInt("slotid");
                            String slotid=""+slotid1;
                            String slotname=rs.getString("slotname");
                            String slottype=rs.getString("slot_type");
                            String slotprice=rs.getString("price");
                            dos.writeBytes(slotid+"\r\n");
                            dos.writeBytes(slotname+"\r\n");
                            dos.writeBytes(slottype+"\r\n");
                            dos.writeBytes(slotprice+"\r\n");
                            
                            }
                            dos.writeBytes("slots for users done\r\n");
                            }
                    }
                    else if(msg.equals("book slots for users"))
                    {
                        String msg1=dis.readLine();
                        if(msg1.equals("sending slot ids"))
                        {
                            while(true)
                            { String slotprice="";
                                String slotid=dis.readLine();
                                if(slotid.equals("slotids sending done"))
                                {
                                    break;
                                }
                                String useremail=dis.readLine();
                                String dateofbooking=dis.readLine();
                                String pid=dis.readLine();
                                
                                Class.forName("com.mysql.jdbc.Driver");
                        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/parkingbookingsystem", "root", "system");
                        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                                ResultSet.CONCUR_UPDATABLE);
                        ResultSet rs = stmt.executeQuery("select * from  parking_slots where slotid='" + slotid + "'");
                                if(rs.next())
                                {
                                    slotprice=rs.getString("price");
                                }
                                Class.forName("com.mysql.jdbc.Driver");
                        Connection conn1= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/parkingbookingsystem", "root", "system");
                        Statement stmt1 = conn1.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                                ResultSet.CONCUR_UPDATABLE);
                        ResultSet rs1 = stmt.executeQuery("select * from  bookings");
                        rs1.next();
                        rs1.moveToInsertRow();
                        rs1.updateString("slotid",slotid);
                        rs1.updateString("parkingid",pid);
                        rs1.updateString("email",useremail);
                        rs1.updateString("dateofbooking",dateofbooking);
                        rs1.updateString("price",slotprice);
                        rs1.insertRow();
                       }
                            dos.writeBytes("all slots booked\r\n");
                        }
                        
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }

        public void signUp() {
            try {
                String email = dis.readLine();
                String name = dis.readLine();
                String sec_ques = dis.readLine();
                String sec_ans = dis.readLine();
                String contact = dis.readLine();
                String password = dis.readLine();

                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/parkingbookingsystem", "root", "system");
                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = stmt.executeQuery("select * from parking_owner_signup where email='" + email + "'");
                if (rs.next()) {
                    dos.writeBytes("email already exists\r\n");
                } else {
                    rs.moveToInsertRow();
                    rs.updateString("email", email);
                    rs.updateString("name", name);
                    rs.updateString("sec_ques", sec_ques);
                    rs.updateString("sec_ans", sec_ans);
                    rs.updateString("contact", contact);
                    rs.updateString("password", password);
                    rs.insertRow();
                    dos.writeBytes("Sign Up successful\r\n");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void UsersignUp() {
            try {
                String email = dis.readLine();
                String sec_ques = dis.readLine();
                String sec_ans = dis.readLine();
                String contact = dis.readLine();
                String password = dis.readLine();

                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/parkingbookingsystem", "root", "system");
                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = stmt.executeQuery("select * from user_signup where email='" + email + "'");
                if (rs.next()) {
                    dos.writeBytes("user email already exists\r\n");
                } else {
                    rs.moveToInsertRow();
                    rs.updateString("email", email);
                    rs.updateString("sec_ques", sec_ques);
                    rs.updateString("sec_ans", sec_ans);
                    rs.updateString("contact", contact);
                    rs.updateString("password", password);
                    rs.insertRow();
                    dos.writeBytes("User Sign Up successful\r\n");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void login() {
            try {
                String email = dis.readLine();
                String password = dis.readLine();

                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/parkingbookingsystem", "root", "system");
                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = stmt.executeQuery("select * from parking_owner_signup where email='" + email + "' and password='" + password + "'");
                if (rs.next()) {
                    dos.writeBytes("login successfull\r\n");
                } else {
                    dos.writeBytes("Login failed\r\n");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void Userlogin() {
            try {
                String email = dis.readLine();
                String password = dis.readLine();

                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/parkingbookingsystem", "root", "system");
                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = stmt.executeQuery("select * from user_signup where email='" + email + "' and password='" + password + "'");
                if (rs.next()) {
                    dos.writeBytes("User login successfull\r\n");
                } else {
                    dos.writeBytes("User Login failed\r\n");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void fetchOwnerParkings() {
            try {

                String owneremail = dis.readLine();
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/parkingbookingsystem", "root", "system");
                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = stmt.executeQuery("select * from  parkings where pemail='" + owneremail + "'");
                dos.writeBytes("sending owner parking info\r\n");
                while (rs.next()) {
                    String pid = rs.getString("pid");
                    String parkingname = rs.getString("pname");
                    String pphoto = rs.getString("pphoto");
                    int pareaid = rs.getInt("pareaid");
                    String pareaid1 = pareaid + "";
                    String areaname = "";
                    Statement stmt1 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                            ResultSet.CONCUR_UPDATABLE);
                    ResultSet rs1 = stmt1.executeQuery("select * from  areas where areaid='" + pareaid1 + "'");
                    if (rs1.next()) {
                        System.out.println("in server ");
                        areaname = rs1.getString("areaname");
                    }
                    //  areaname=rs1.getString("areaname");
                    dos.writeBytes(parkingname + "\r\n");
                    dos.writeBytes(pphoto + "\r\n");
                    dos.writeBytes(pareaid1 + "\r\n");
                    dos.writeBytes(areaname + "\r\n");
                    dos.writeBytes(pid + "\r\n");
                }
                dos.writeBytes("owner parking info done\r\n");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void updateParkings() {
            try {
                String parkingname = dis.readLine();
                String areaid = dis.readLine();
                String pareaname = dis.readLine();
                String parkingphoto = dis.readLine();
                String email = dis.readLine();
                String oldparkingname = dis.readLine();

                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Driver Loading done");

                Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/parkingbookingsystem", "root", "system");
                System.out.println("Connection Created");

                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);
                System.out.println("Statement Created");

                ResultSet rs = stmt.executeQuery("select * from parkings where pemail='" + email + "' and pareaid='" + areaid + "' and pname='" + oldparkingname + "'");
                System.out.println("ResultSet Created\n\n");
                if (rs.next()) {
                    rs.updateString("pname", parkingname);
                    rs.updateString("pareaid", areaid);
                    rs.updateString("pphoto", parkingphoto);
                    rs.updateString("pemail", email);
                    rs.updateRow();
                    dos.writeBytes("Updated successfully\r\n");
                }

            } catch (Exception e) {
            }
        }

        private void deleteParking() {
            try {
                String pid = dis.readLine();
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Driver Loading done");

                Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/parkingbookingsystem", "root", "system");
                System.out.println("Connection Created");

                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);
                System.out.println("Statement Created");

                ResultSet rs = stmt.executeQuery("select * from parkings where pid='" +pid + "'");
                System.out.println("ResultSet Created\n\n");
                if(rs.next())
                {
                    rs.deleteRow();
                    dos.writeBytes("parking deleted successfully\r\n");
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
            java.util.logging.Logger.getLogger(Admin_Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin_Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin_Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin_Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new Admin_Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_add_area;
    private javax.swing.JButton bt_add_category;
    private javax.swing.JButton bt_change_password;
    private javax.swing.JButton bt_manage_area;
    private javax.swing.JButton bt_view_category;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jp_manage_areas;
    private javax.swing.JPanel jp_manage_categories;
    private javax.swing.JLabel lb_background;
    // End of variables declaration//GEN-END:variables
}
