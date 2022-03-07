
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class Viewcategory extends javax.swing.JFrame {

    ArrayList<Singlecategory> al_sc;
    Viewcategorymodel vm;

    public Viewcategory() {
        initComponents();
        setSize(800, 500);
        setVisible(true);
          setResizable(false);
        setTitle("View your Categories");
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        int x = (width / 2) - (this.getWidth() / 2);
        int y = (height / 2) - (this.getHeight() / 2);
        setLocation(x, y);
        try{
            
        
         File f=new File(System.getProperty("user.home")+"\\images\\e.jpg");
                    Image scaledInstance = ImageIO.read(f).getScaledInstance(lb_background.getWidth(), lb_background.getHeight(),
                            Image.SCALE_SMOOTH);
                    lb_background.setIcon(new ImageIcon(scaledInstance));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        al_sc = new ArrayList<>();
        vm = new Viewcategorymodel();
        jt_view_categories.setModel(vm);
        fetchcategories();

    }

    public void fetchcategories() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Loading done");

            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/parkingbookingsystem", "root", "system");
            System.out.println("Connection Created");

            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            System.out.println("Statement Created");

            ResultSet rs = stmt.executeQuery("select * from category");
            System.out.println("ResultSet Created\n\n");
            while (rs.next()) {
                String cname = rs.getString("cname");
                String cdescription = rs.getString("cdescription");
                String cphoto = rs.getString("cphoto");
                al_sc.add(new Singlecategory(cname, cdescription, cphoto));
            }
            vm.fireTableDataChanged();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class Viewcategorymodel extends AbstractTableModel {

        String title[] = {"sno", "category name", "category description"};

        public String getColumnName(int index) {
            return title[index];
        }

        @Override
        public int getRowCount() {
            return al_sc.size();
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
                return al_sc.get(rowindex).cname;
            } else {
                return al_sc.get(rowindex).cdesc;
            }

        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jt_view_categories = new javax.swing.JTable();
        bt_editview = new javax.swing.JButton();
        bt_deleteview = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lb_background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jt_view_categories.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        jt_view_categories.setGridColor(new java.awt.Color(0, 0, 0));
        jt_view_categories.setRowHeight(30);
        jScrollPane1.setViewportView(jt_view_categories);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(40, 100, 660, 160);

        bt_editview.setBackground(new java.awt.Color(0, 0, 0));
        bt_editview.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        bt_editview.setForeground(new java.awt.Color(255, 255, 255));
        bt_editview.setText("EDIT");
        bt_editview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_editviewActionPerformed(evt);
            }
        });
        getContentPane().add(bt_editview);
        bt_editview.setBounds(50, 310, 290, 30);

        bt_deleteview.setBackground(new java.awt.Color(0, 0, 0));
        bt_deleteview.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        bt_deleteview.setForeground(new java.awt.Color(255, 255, 255));
        bt_deleteview.setText("DELETE");
        bt_deleteview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_deleteviewActionPerformed(evt);
            }
        });
        getContentPane().add(bt_deleteview);
        bt_deleteview.setBounds(440, 310, 260, 30);

        jLabel1.setFont(new java.awt.Font("Georgia", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("VIEW CATEGORIES");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(70, 20, 390, 50);

        lb_background.setText("jLabel2");
        getContentPane().add(lb_background);
        lb_background.setBounds(0, 0, 820, 480);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_editviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_editviewActionPerformed
        int row = jt_view_categories.getSelectedRow();

        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row");
        } else {

            String cname = al_sc.get(row).cname;
            String cdesc = al_sc.get(row).cdesc;
            String cphoto = al_sc.get(row).cphoto;
            EditCategory ec = new EditCategory(cname, cdesc, cphoto);

        }
    }//GEN-LAST:event_bt_editviewActionPerformed

    private void bt_deleteviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_deleteviewActionPerformed

        int row = jt_view_categories.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row");
        } else {

            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(this, "Are you sure to delete this row", "CONFIRM", dialogButton);
            if (dialogResult == JOptionPane.YES_OPTION) {
                String cname = al_sc.get(row).cname;
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    System.out.println("Driver Loading done");

                    Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/parkingbookingsystem", "root", "system");
                    System.out.println("Connection Created");

                    Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                            ResultSet.CONCUR_UPDATABLE);
                    System.out.println("Statement Created");

                    ResultSet rs = stmt.executeQuery("select * from category where cname='" + cname + "'");
                    System.out.println("ResultSet Created\n\n");
                    if (rs.next()) {
                        rs.deleteRow();
                        al_sc.remove(row);
                        vm.fireTableDataChanged();
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }//GEN-LAST:event_bt_deleteviewActionPerformed

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
            java.util.logging.Logger.getLogger(Viewcategory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Viewcategory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Viewcategory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Viewcategory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                 //new Viewcategory().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_deleteview;
    private javax.swing.JButton bt_editview;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jt_view_categories;
    private javax.swing.JLabel lb_background;
    // End of variables declaration//GEN-END:variables
}

class Singlecategory {

    String cname;
    String cdesc;
    String cphoto;

    public Singlecategory(String cname, String cdescription, String cphoto) {

        this.cname = cname;
        this.cdesc = cdescription;
        this.cphoto = cphoto;

    }

}
