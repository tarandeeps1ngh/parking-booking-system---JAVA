
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

public class ManageArea extends javax.swing.JFrame
{

        ArrayList<Singlearea> al_sa;
 Viewareamodel va;   

    public ManageArea()
    {
        initComponents();
        setSize(670, 500);
        setVisible(true);
        setTitle("Manage your Areas");
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
        }
        al_sa=new ArrayList<>();
       va=new Viewareamodel();
       jt_manage_area.setModel(va);
        fetchareas();
        
    }
    public void fetchareas()
    {
        try
        {
           Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Loading done");
            
            Connection conn = DriverManager.getConnection
        ("jdbc:mysql://127.0.0.1:3306/parkingbookingsystem", "root", "system");
            System.out.println("Connection Created");
            
            Statement stmt = conn.createStatement
        (ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE);
            System.out.println("Statement Created");
            
            ResultSet rs = stmt.executeQuery("select * from areas");
            System.out.println("ResultSet Created\n\n");
            while(rs.next())
              {
                String areaname=rs.getString("areaname");
                String areaphoto=rs.getString("areaphoto");
                String areacity=rs.getString("areacity");
                al_sa.add(new Singlearea(areaname,areaphoto,areacity));
              }
            va.fireTableDataChanged();

        } catch (Exception e)
        {
          e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jt_manage_area = new javax.swing.JTable();
        bt_edit_area = new javax.swing.JButton();
        bt_delete_area = new javax.swing.JButton();
        lb_background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jScrollPane1.setViewportView(jt_manage_area);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 60, 590, 110);

        bt_edit_area.setBackground(new java.awt.Color(0, 0, 0));
        bt_edit_area.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        bt_edit_area.setForeground(new java.awt.Color(255, 255, 255));
        bt_edit_area.setText("EDIT");
        bt_edit_area.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_edit_areaActionPerformed(evt);
            }
        });
        getContentPane().add(bt_edit_area);
        bt_edit_area.setBounds(110, 230, 110, 50);

        bt_delete_area.setBackground(new java.awt.Color(0, 0, 0));
        bt_delete_area.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        bt_delete_area.setForeground(new java.awt.Color(255, 255, 255));
        bt_delete_area.setText("DELETE");
        bt_delete_area.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_delete_areaActionPerformed(evt);
            }
        });
        getContentPane().add(bt_delete_area);
        bt_delete_area.setBounds(390, 230, 110, 50);

        lb_background.setText("jLabel1");
        getContentPane().add(lb_background);
        lb_background.setBounds(0, -6, 720, 520);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_edit_areaActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_bt_edit_areaActionPerformed
    {//GEN-HEADEREND:event_bt_edit_areaActionPerformed
         int row = jt_manage_area.getSelectedRow();

if(row == -1)
{
    JOptionPane.showMessageDialog(this,"Please select a row");
}
else
{
    
String areaname=  al_sa.get(row).areaname;
String areaphoto=  al_sa.get(row).areaphoto;
    EditArea ea=new EditArea(areaname,areaphoto);
}
    }//GEN-LAST:event_bt_edit_areaActionPerformed

    private void bt_delete_areaActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_bt_delete_areaActionPerformed
    {//GEN-HEADEREND:event_bt_delete_areaActionPerformed
       int row = jt_manage_area.getSelectedRow();
        if(row == -1)
{
    JOptionPane.showMessageDialog(this,"Please select a row");
}
      else
{
  
    int dialogButton = JOptionPane.YES_NO_OPTION;
    int dialogResult = JOptionPane.showConfirmDialog (this,"Are you sure to delete this row","CONFIRM",dialogButton);
    if(dialogResult==JOptionPane.YES_OPTION)
    {
        String areaname=al_sa.get(row).areaname;
        try
          {
             Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Loading done");
            
            Connection conn = DriverManager.getConnection
        ("jdbc:mysql://127.0.0.1:3306/parkingbookingsystem", "root", "system");
            System.out.println("Connection Created");
            
            Statement stmt = conn.createStatement
        (ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE);
            System.out.println("Statement Created");
            
            ResultSet rs = stmt.executeQuery("select * from areas where areaname='"+areaname+"'");
            System.out.println("ResultSet Created\n\n");
            if(rs.next())
              {
                rs.deleteRow();
                al_sa.remove(row);
              va.fireTableDataChanged();
                        }
            
          } catch (Exception e)
          {
            e.printStackTrace();
          }
    }}   
    }//GEN-LAST:event_bt_delete_areaActionPerformed
class Viewareamodel extends AbstractTableModel
    {
        String title[]={"sno","Area name","Areacity"};
        public String getColumnName(int index)
        {
            return title[index];
        }
        @Override
        public int getRowCount()
        {
           return al_sa.size();
        }

        @Override
        public int getColumnCount()
        {
            return title.length;
        }

        @Override
        public Object getValueAt(int rowindex, int columnindex)
        {
            if(columnindex==0)
              {
               return ""+(rowindex+1);
              }
            else if(columnindex==1)
              {
               return al_sa.get(rowindex).areaname; 
              }
            else
              {
              return al_sa.get(rowindex).areacity;
              }
            
            
        }
        
    }
    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(ManageArea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (InstantiationException ex)
          {
            java.util.logging.Logger.getLogger(ManageArea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (IllegalAccessException ex)
          {
            java.util.logging.Logger.getLogger(ManageArea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (javax.swing.UnsupportedLookAndFeelException ex)
          {
            java.util.logging.Logger.getLogger(ManageArea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                //new ManageArea().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_delete_area;
    private javax.swing.JButton bt_edit_area;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jt_manage_area;
    private javax.swing.JLabel lb_background;
    // End of variables declaration//GEN-END:variables
}
class Singlearea
{
    String areaname;
    String areaphoto;
    String areacity;
    
    public Singlearea(String areaname,String areaphoto,String areacity)
    {
       
        this.areaname=areaname;
        this.areaphoto=areaphoto;
        this.areacity=areacity;
        
    }
            
}