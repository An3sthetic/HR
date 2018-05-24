
package ntitas;

import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;


import java.io.File;
import java.io.FileInputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;



import javax.swing.ImageIcon;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;



public class mainpage extends javax.swing.JFrame
{

String path="";
String gnd="";

String id=null;
int payement=0;
int scale=0;
int datecount=0;
int pay;

    public mainpage()
    {
        initComponents();
        addemp.setVisible(false);
        layer.setVisible(true);
        side_pan.setVisible(true);
        first_sidepan.setVisible(true);

new Thread()
        {
            public void run()
            {
                while(true)
                {
                    Calendar cal = new GregorianCalendar();
                    String mnt,hr,sc;
                    int hour=cal.get(Calendar.HOUR);
                    int min=cal.get(Calendar.MINUTE);
                    int sec=cal.get(Calendar.SECOND);
                    int dn=cal.get(Calendar.AM_PM);
                    
                    mnt=Integer.toString(min);
                    hr=Integer.toString(hour);
                    sc=Integer.toString(sec);
                    if(min<10)
                        mnt ="0"+min;
                    if(hour<10)
                        hr="0"+hour;
                    if(sec<10)
                        sc="0"+sec;
                    
                    if(dn==1)
                        clock.setText(hr+":"+mnt+":"+sc+" PM");
                    else
                        clock.setText(hr+":"+mnt+":"+sc+" AM");
                    int date=cal.get(Calendar.DATE);
                    int month=cal.get(Calendar.MONTH);
                    int year=cal.get(Calendar.YEAR);
                    calendar.setText(date+"/"+month+"/"+year);
                    
                       
                }
            }
        }.start();
        
       empInfo();
       leaveInfo();
       userInfo();
       depInfo();
       desInfo();
    }
 public void empInfo()
    {
        PreparedStatement ist=null;
        ResultSet s=null;
        try
        {
           
            ist = dbconnect.ConnectDB().prepareStatement(query.select_emp());
            s =  ist.executeQuery();
            emp_list.setModel(DbUtils.resultSetToTableModel(s));
            
        } 
        catch(Exception e)
        {
         JOptionPane.showMessageDialog(null, "Encountered an Unexpected Error");
        }

    }
private Image fitimage(Image img , int w , int h)
{
    BufferedImage resizedimage = new BufferedImage(w,h,BufferedImage.TYPE_INT_RGB);
    Graphics2D g2 = resizedimage.createGraphics();
    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
    g2.drawImage(img, 0, 0,w,h,null);
    g2.dispose();
    return resizedimage;
}
 public void userInfo()
    {
        PreparedStatement ist=null;
        ResultSet s=null;
        try
        {
           
            ist = dbconnect.ConnectDB().prepareStatement(query.select_user());
            s =  ist.executeQuery();
            us_list.setModel(DbUtils.resultSetToTableModel(s));
            
        } 
        catch(Exception e)
        {
         JOptionPane.showMessageDialog(null, "Encountered an Unexpected Error");
        }

    }
 
 public void leaveInfo()
    {
        PreparedStatement ist=null;
        ResultSet s=null;
        try
        {
           
            ist = dbconnect.ConnectDB().prepareStatement(query.select_app());
            s =  ist.executeQuery();
            app.setModel(DbUtils.resultSetToTableModel(s));            
        } 
        catch(Exception e)
        {
         JOptionPane.showMessageDialog(null, "Encountered an Unexpected Error");
        }

    }

  public void empInfo_at(String id)
    {
        PreparedStatement ist=null;
        ResultSet s=null;
        try
        {
           
            ist = dbconnect.ConnectDB().prepareStatement(query.select_emp_at());
            ist.setString(1, id);
            s =  ist.executeQuery();
            while(s.next())
            {
            String st=s.getString("Firstname")+" "+s.getString("Lastname");
            jLabel71.setText(st);
            jLabel72.setText(s.getString("gender"));
            jLabel73.setText(s.getString("dob"));
            jLabel49.setText(s.getString("nid"));
            jLabel64.setText(s.getString("department_name"));
            jLabel19.setText(s.getString("designation"));
            jLabel74.setText(s.getString("contact"));
            jLabel75.setText(s.getString("email"));
            jLabel18.setIcon(new ImageIcon(s.getBytes("picture")));
            
            jTextField15.setText(s.getString("id"));
            jTextField16.setText(s.getString("Firstname"));
            jTextField17.setText(s.getString("Lastname"));
            jTextField18.setText(s.getString("nid"));
            jTextField20.setText(s.getString("department_name"));
            jTextField21.setText(s.getString("designation"));
            jComboBox2.setSelectedItem(s.getString("role"));
            jTextField19.setText(s.getString("bank_acc"));
            jTextField4.setText(s.getString("allocated_leave"));    
            jTextArea3.setText(s.getString("pres_add"));
            jTextArea4.setText(s.getString("per_add"));           
            jTextField22.setText(s.getString("email"));
            jTextField23.setText(s.getString("contact"));
            
            }
        } 
        catch(Exception e)
        {
         JOptionPane.showMessageDialog(null, e);
        }

    }
    public void leaveInfo_at(String id,String sd)
    {
        PreparedStatement ist=null;
        ResultSet s=null;
        try
        {
           
            ist = dbconnect.ConnectDB().prepareStatement(query.select_leave_at());
            ist.setString(1, id);
            ist.setString(2, sd);
            s =  ist.executeQuery();
            while(s.next())
            {
            
            jTextField38.setText(s.getString("id"));
            jTextArea5.setText(s.getString("msg_body"));
            jTextField39.setText(s.getString("start_date"));
            jTextField40.setText(s.getString("end_date"));
            jLabel55.setText("Department: "+s.getString("department_name"));
            jLabel86.setText("Designation: "+s.getString("designation"));
            }
        } 
        catch(Exception e)
        {
         JOptionPane.showMessageDialog(null, e);
        }

    }
  public void depInfo()
    {
        PreparedStatement ist=null;
        ResultSet s=null;
        try
        {
           
            ist = dbconnect.ConnectDB().prepareStatement(query.select_dep());
            s =  ist.executeQuery();
            dep_list.setModel(DbUtils.resultSetToTableModel(s));
            
        } 
        catch(Exception e)
        {

                JOptionPane.showMessageDialog(null, e);
            
        }
    }
  public void depinfo_at(String id)
    {
        PreparedStatement ist=null;
        ResultSet s=null;
        try
        {
           
            ist = dbconnect.ConnectDB().prepareStatement(query.select_dep_at());
            ist.setString(1, id);
            
            s =  ist.executeQuery();
            while(s.next())
            {            
               jLabel121.setText(s.getString("dept_id"));
               jLabel116.setText(s.getString("dept_name"));
               jLabel120.setText(s.getString(5));
               jLabel124.setText(s.getString("on_leave"));
               jLabel125.setText(s.getString("leave_allowed"));
               jLabel112.setText(s.getString("dept_id"));
               jTextField34.setText(s.getString("dept_name"));
               jTextField35.setText(s.getString("leave_allowed"));
            }
        } 
        catch(Exception e)
        {
         JOptionPane.showMessageDialog(null, e);
        }

    }
      public void usinfo_at(String id)
    {
        PreparedStatement ist=null;
        ResultSet s=null;
        try
        {
           
            ist = dbconnect.ConnectDB().prepareStatement(query.select_user_at());
            ist.setString(1, id);
            
            s =  ist.executeQuery();
            while(s.next())
            {            
            jLabel90.setText(s.getString("username"));
            jLabel94.setText(s.getString("username"));
            jTextField9.setText(s.getString("password"));
            jLabel95.setText(s.getString("password"));
            jLabel97.setText(s.getString("type"));
            jLabel96.setText(s.getString("type"));
           
            }
        } 
        catch(Exception e)
        {
         JOptionPane.showMessageDialog(null, e);
        }

    }
 public void desInfo()
    {
        PreparedStatement ist=null;
        ResultSet s=null;
        try
        {
           
            ist = dbconnect.ConnectDB().prepareStatement(query.select_des());
            s =  ist.executeQuery();
            des_list.setModel(DbUtils.resultSetToTableModel(s));
            
        } 
        catch(Exception e)
        {

                JOptionPane.showMessageDialog(null, e);
            
        }
    }
      public void desinfo_at(String id)
    {
        PreparedStatement ist=null;
        ResultSet s=null;
        try
        {
           
            ist = dbconnect.ConnectDB().prepareStatement(query.select_des_at());
            ist.setString(1, id);
            
            s =  ist.executeQuery();
            while(s.next())
            {            
            jLabel111.setText(s.getString("desg_id"));
            jLabel108.setText(s.getString("desg_id"));
            jLabel109.setText(s.getString("desg_name"));
            jLabel107.setText(s.getString("desg_name"));
            jTextField5.setText(s.getString("basic_salary"));
            jLabel110.setText(s.getString("basic_salary"));
           
            }
        } 
        catch(Exception e)
        {
         JOptionPane.showMessageDialog(null, e);
        }

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        clock = new javax.swing.JLabel();
        calendar = new javax.swing.JLabel();
        layer = new javax.swing.JLayeredPane();
        first = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        adduser_pan = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        role = new javax.swing.JComboBox<>();
        jPasswordField1 = new javax.swing.JPasswordField();
        jButton16 = new javax.swing.JButton();
        addemp = new javax.swing.JTabbedPane();
        pers_inf = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        txt_fn = new javax.swing.JTextField();
        txt_ln = new javax.swing.JTextField();
        male = new javax.swing.JRadioButton();
        female = new javax.swing.JRadioButton();
        txt_nid = new javax.swing.JTextField();
        image = new javax.swing.JLabel();
        imagename = new javax.swing.JLabel();
        txt_dob = new com.toedter.calendar.JDateChooser();
        dept_inf = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_bnk = new javax.swing.JTextField();
        txt_dn = new javax.swing.JTextField();
        txt_ds = new javax.swing.JTextField();
        txt_role = new javax.swing.JComboBox<>();
        con_det = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_ptadd = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_pradd = new javax.swing.JTextArea();
        txt_em = new javax.swing.JTextField();
        txt_con = new javax.swing.JTextField();
        emp_save = new javax.swing.JButton();
        updateemp = new javax.swing.JTabbedPane();
        pers_inf1 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jTextField15 = new javax.swing.JTextField();
        jTextField16 = new javax.swing.JTextField();
        jTextField17 = new javax.swing.JTextField();
        jTextField18 = new javax.swing.JTextField();
        imagename1 = new javax.swing.JLabel();
        dept_inf1 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jTextField19 = new javax.swing.JTextField();
        jTextField20 = new javax.swing.JTextField();
        jTextField21 = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel36 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        con_det1 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea4 = new javax.swing.JTextArea();
        jTextField22 = new javax.swing.JTextField();
        jTextField23 = new javax.swing.JTextField();
        jButton13 = new javax.swing.JButton();
        removeemp = new javax.swing.JPanel();
        jButton12 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        Departmentads = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        adddep = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jTextField29 = new javax.swing.JTextField();
        jTextField30 = new javax.swing.JTextField();
        save_dep = new javax.swing.JButton();
        updatedep = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jTextField34 = new javax.swing.JTextField();
        up_dep = new javax.swing.JButton();
        jLabel112 = new javax.swing.JLabel();
        jTextField35 = new javax.swing.JTextField();
        deletedep = new javax.swing.JPanel();
        jLabel114 = new javax.swing.JLabel();
        jLabel115 = new javax.swing.JLabel();
        jLabel117 = new javax.swing.JLabel();
        jLabel118 = new javax.swing.JLabel();
        jButton19 = new javax.swing.JButton();
        jLabel119 = new javax.swing.JLabel();
        jLabel120 = new javax.swing.JLabel();
        jLabel116 = new javax.swing.JLabel();
        jLabel121 = new javax.swing.JLabel();
        jLabel122 = new javax.swing.JLabel();
        jLabel123 = new javax.swing.JLabel();
        jLabel124 = new javax.swing.JLabel();
        jLabel125 = new javax.swing.JLabel();
        attendence = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        att_tbl = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        srchby = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        srchbyid = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        att_date = new com.toedter.calendar.JDateChooser();
        jLabel20 = new javax.swing.JLabel();
        att_id = new javax.swing.JTextField();
        srchbyyr = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        att_mnth = new com.toedter.calendar.JMonthChooser();
        att_yr = new com.toedter.calendar.JYearChooser();
        jLabel48 = new javax.swing.JLabel();
        leave = new javax.swing.JPanel();
        jLabel52 = new javax.swing.JLabel();
        jTextField38 = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jTextField39 = new javax.swing.JTextField();
        jTextField40 = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTextArea5 = new javax.swing.JTextArea();
        jButton3 = new javax.swing.JButton();
        jLabel55 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        payroll = new javax.swing.JPanel();
        jLabel57 = new javax.swing.JLabel();
        payr_id = new javax.swing.JTextField();
        jLabel59 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        HRA = new javax.swing.JTextField();
        jLabel60 = new javax.swing.JLabel();
        EA = new javax.swing.JTextField();
        jLabel61 = new javax.swing.JLabel();
        CA = new javax.swing.JTextField();
        jButton20 = new javax.swing.JButton();
        jLabel62 = new javax.swing.JLabel();
        jButton21 = new javax.swing.JButton();
        payr_mnth = new com.toedter.calendar.JMonthChooser();
        payr_yr = new com.toedter.calendar.JYearChooser();
        jLabel69 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        IT = new javax.swing.JTextField();
        CB = new javax.swing.JTextField();
        OT = new javax.swing.JTextField();
        jLabel84 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        upuser_pan = new javax.swing.JPanel();
        jTextField9 = new javax.swing.JTextField();
        jButton17 = new javax.swing.JButton();
        jLabel88 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        deluser_pan = new javax.swing.JPanel();
        jLabel91 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        jLabel94 = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        adddes_pan = new javax.swing.JPanel();
        jLabel98 = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        jButton18 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        updes_pan = new javax.swing.JPanel();
        jLabel101 = new javax.swing.JLabel();
        jLabel102 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        jButton22 = new javax.swing.JButton();
        jLabel111 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel107 = new javax.swing.JLabel();
        remdes_pan = new javax.swing.JPanel();
        jLabel104 = new javax.swing.JLabel();
        jLabel105 = new javax.swing.JLabel();
        jLabel106 = new javax.swing.JLabel();
        jButton23 = new javax.swing.JButton();
        jLabel108 = new javax.swing.JLabel();
        jLabel109 = new javax.swing.JLabel();
        jLabel110 = new javax.swing.JLabel();
        about = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel129 = new javax.swing.JLabel();
        jLabel130 = new javax.swing.JLabel();
        side_pan = new javax.swing.JPanel();
        first_sidepan = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        emp_sidepan = new javax.swing.JPanel();
        emp_add = new javax.swing.JButton();
        emp_up = new javax.swing.JButton();
        emp_rem = new javax.swing.JButton();
        jScrollPane10 = new javax.swing.JScrollPane();
        emp_list = new javax.swing.JTable();
        dep_sidepan = new javax.swing.JPanel();
        dep_add = new javax.swing.JButton();
        dep_up = new javax.swing.JButton();
        dep_del = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        dep_list = new javax.swing.JTable();
        des_sidepan = new javax.swing.JPanel();
        des_del = new javax.swing.JButton();
        des_up = new javax.swing.JButton();
        des_add = new javax.swing.JButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        des_list = new javax.swing.JTable();
        lve_sidepan = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        app = new javax.swing.JTable();
        us_sidepan = new javax.swing.JPanel();
        user_add = new javax.swing.JButton();
        user_up = new javax.swing.JButton();
        user_rem = new javax.swing.JButton();
        jScrollPane12 = new javax.swing.JScrollPane();
        us_list = new javax.swing.JTable();
        jLabel37 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        emp_menu = new javax.swing.JMenu();
        dep_menu = new javax.swing.JMenu();
        des_menu = new javax.swing.JMenu();
        att_menu = new javax.swing.JMenu();
        lv_menu = new javax.swing.JMenu();
        pay_menu = new javax.swing.JMenu();
        us_menu = new javax.swing.JMenu();
        op_menu = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        about_menu = new javax.swing.JMenu();
        logout = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(1178, 715));
        setPreferredSize(new java.awt.Dimension(1178, 715));
        addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                formMouseClicked(evt);
            }
        });
        getContentPane().setLayout(null);

        clock.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        clock.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(clock);
        clock.setBounds(958, 16, 170, 40);

        calendar.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        calendar.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(calendar);
        calendar.setBounds(750, 10, 150, 50);

        layer.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        layer.setLayout(new java.awt.CardLayout());

        first.setBorder(new javax.swing.border.MatteBorder(null));
        first.setLayout(null);

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/employee_banner.jpg"))); // NOI18N
        first.add(jLabel25);
        jLabel25.setBounds(-230, 0, 1090, 560);

        layer.add(first, "card2");

        adduser_pan.setLayout(null);

        jLabel12.setText("Password:");
        adduser_pan.add(jLabel12);
        jLabel12.setBounds(150, 234, 70, 20);

        jLabel13.setText("role:");
        adduser_pan.add(jLabel13);
        jLabel13.setBounds(160, 290, 50, 20);

        jLabel11.setText("User Id:");
        adduser_pan.add(jLabel11);
        jLabel11.setBounds(150, 190, 70, 20);

        jTextField8.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jTextField8ActionPerformed(evt);
            }
        });
        adduser_pan.add(jTextField8);
        jTextField8.setBounds(240, 184, 130, 30);

        role.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose One", "Admin", "Employee" }));
        role.setToolTipText("");
        role.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                roleActionPerformed(evt);
            }
        });
        adduser_pan.add(role);
        role.setBounds(240, 286, 130, 30);
        adduser_pan.add(jPasswordField1);
        jPasswordField1.setBounds(240, 230, 130, 30);

        jButton16.setText("Save");
        jButton16.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton16ActionPerformed(evt);
            }
        });
        adduser_pan.add(jButton16);
        jButton16.setBounds(590, 460, 90, 30);

        layer.add(adduser_pan, "card12");

        addemp.setBackground(new java.awt.Color(255, 255, 255));
        addemp.setBorder(new javax.swing.border.MatteBorder(null));

        pers_inf.setLayout(null);

        jLabel1.setText("First Name:");
        pers_inf.add(jLabel1);
        jLabel1.setBounds(70, 130, 125, 36);

        jLabel2.setText("Id:");
        pers_inf.add(jLabel2);
        jLabel2.setBounds(70, 80, 125, 33);

        jLabel3.setText("Last Name:");
        pers_inf.add(jLabel3);
        jLabel3.setBounds(70, 190, 125, 38);

        jLabel4.setText("Gender:");
        pers_inf.add(jLabel4);
        jLabel4.setBounds(70, 240, 125, 38);

        jLabel5.setText("Date of Birth:");
        pers_inf.add(jLabel5);
        jLabel5.setBounds(70, 320, 125, 38);

        jLabel6.setText("Nid:");
        pers_inf.add(jLabel6);
        jLabel6.setBounds(70, 370, 125, 38);
        pers_inf.add(txt_id);
        txt_id.setBounds(210, 80, 158, 24);
        pers_inf.add(txt_fn);
        txt_fn.setBounds(210, 140, 158, 24);
        pers_inf.add(txt_ln);
        txt_ln.setBounds(210, 200, 158, 24);

        male.setText("Male");
        male.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                maleActionPerformed(evt);
            }
        });
        pers_inf.add(male);
        male.setBounds(210, 250, 160, 19);

        female.setText("Female");
        female.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                femaleActionPerformed(evt);
            }
        });
        pers_inf.add(female);
        female.setBounds(210, 280, 160, 20);

        txt_nid.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                txt_nidActionPerformed(evt);
            }
        });
        pers_inf.add(txt_nid);
        txt_nid.setBounds(210, 380, 158, 24);

        image.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        image.setText("Click to choose picture");
        image.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        image.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                imageMouseClicked(evt);
            }
        });
        pers_inf.add(image);
        image.setBounds(550, 100, 260, 290);
        pers_inf.add(imagename);
        imagename.setBounds(570, 410, 200, 21);

        txt_dob.setDateFormatString("yyyy-MM-dd");
        pers_inf.add(txt_dob);
        txt_dob.setBounds(210, 330, 170, 29);

        addemp.addTab("Personal Information", pers_inf);

        dept_inf.setLayout(null);

        jLabel7.setText("Account No.");
        dept_inf.add(jLabel7);
        jLabel7.setBounds(280, 320, 73, 30);

        jLabel8.setText("Department:");
        dept_inf.add(jLabel8);
        jLabel8.setBounds(280, 170, 73, 20);

        jLabel9.setText("Designation:");
        dept_inf.add(jLabel9);
        jLabel9.setBounds(280, 220, 73, 20);

        jLabel10.setText("Type:");
        dept_inf.add(jLabel10);
        jLabel10.setBounds(280, 270, 73, 20);

        txt_bnk.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                txt_bnkActionPerformed(evt);
            }
        });
        dept_inf.add(txt_bnk);
        txt_bnk.setBounds(400, 320, 152, 30);

        txt_dn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                txt_dnActionPerformed(evt);
            }
        });
        dept_inf.add(txt_dn);
        txt_dn.setBounds(400, 170, 152, 30);
        dept_inf.add(txt_ds);
        txt_ds.setBounds(400, 220, 152, 30);

        txt_role.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose One", "Full time", "Part time" }));
        dept_inf.add(txt_role);
        txt_role.setBounds(400, 270, 152, 30);

        addemp.addTab("Departmental Information", dept_inf);

        con_det.setLayout(null);

        jLabel14.setText("Present Address:");
        con_det.add(jLabel14);
        jLabel14.setBounds(191, 142, 117, 16);

        jLabel15.setText("Permanent Address:");
        con_det.add(jLabel15);
        jLabel15.setBounds(191, 263, 117, 16);

        jLabel16.setText("Email:");
        con_det.add(jLabel16);
        jLabel16.setBounds(191, 385, 117, 16);

        jLabel17.setText("Contact No:");
        con_det.add(jLabel17);
        jLabel17.setBounds(191, 433, 117, 16);

        txt_ptadd.setColumns(20);
        txt_ptadd.setRows(5);
        jScrollPane1.setViewportView(txt_ptadd);

        con_det.add(jScrollPane1);
        jScrollPane1.setBounds(314, 112, 324, 83);

        txt_pradd.setColumns(20);
        txt_pradd.setRows(5);
        jScrollPane2.setViewportView(txt_pradd);

        con_det.add(jScrollPane2);
        jScrollPane2.setBounds(314, 232, 324, 83);
        con_det.add(txt_em);
        txt_em.setBounds(314, 381, 324, 24);
        con_det.add(txt_con);
        txt_con.setBounds(314, 429, 324, 24);

        emp_save.setText("Save");
        emp_save.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                emp_saveActionPerformed(evt);
            }
        });
        con_det.add(emp_save);
        emp_save.setBounds(700, 480, 58, 32);

        addemp.addTab("Contact Details", con_det);

        layer.add(addemp, "card3");

        updateemp.setBackground(new java.awt.Color(255, 255, 255));
        updateemp.setBorder(new javax.swing.border.MatteBorder(null));

        pers_inf1.setLayout(null);

        jLabel21.setText("First Name:");
        pers_inf1.add(jLabel21);
        jLabel21.setBounds(120, 190, 125, 36);

        jLabel22.setText("Id:");
        pers_inf1.add(jLabel22);
        jLabel22.setBounds(120, 140, 125, 33);

        jLabel23.setText("Last Name:");
        pers_inf1.add(jLabel23);
        jLabel23.setBounds(120, 250, 125, 38);

        jLabel27.setText("Nid:");
        pers_inf1.add(jLabel27);
        jLabel27.setBounds(120, 310, 125, 38);
        pers_inf1.add(jTextField15);
        jTextField15.setBounds(260, 134, 158, 30);
        pers_inf1.add(jTextField16);
        jTextField16.setBounds(260, 194, 158, 30);
        pers_inf1.add(jTextField17);
        jTextField17.setBounds(260, 254, 158, 30);

        jTextField18.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jTextField18ActionPerformed(evt);
            }
        });
        pers_inf1.add(jTextField18);
        jTextField18.setBounds(260, 314, 158, 30);
        pers_inf1.add(imagename1);
        imagename1.setBounds(570, 370, 200, 21);

        updateemp.addTab("Personal Information", pers_inf1);

        dept_inf1.setLayout(null);

        jLabel28.setText("Account No.");
        dept_inf1.add(jLabel28);
        jLabel28.setBounds(280, 310, 73, 30);

        jLabel29.setText("Department:");
        dept_inf1.add(jLabel29);
        jLabel29.setBounds(280, 170, 73, 20);

        jLabel30.setText("Designation:");
        dept_inf1.add(jLabel30);
        jLabel30.setBounds(280, 220, 73, 20);

        jLabel31.setText("Type:");
        dept_inf1.add(jLabel31);
        jLabel31.setBounds(280, 270, 73, 20);

        jTextField19.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jTextField19ActionPerformed(evt);
            }
        });
        dept_inf1.add(jTextField19);
        jTextField19.setBounds(400, 310, 152, 30);

        jTextField20.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jTextField20ActionPerformed(evt);
            }
        });
        dept_inf1.add(jTextField20);
        jTextField20.setBounds(400, 170, 152, 30);
        dept_inf1.add(jTextField21);
        jTextField21.setBounds(400, 220, 152, 30);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose One", "Full time", "Part time" }));
        dept_inf1.add(jComboBox2);
        jComboBox2.setBounds(400, 260, 152, 30);

        jLabel36.setText("Allocated Leave:");
        dept_inf1.add(jLabel36);
        jLabel36.setBounds(280, 370, 110, 30);
        dept_inf1.add(jTextField4);
        jTextField4.setBounds(400, 370, 150, 30);

        updateemp.addTab("Departmental Information", dept_inf1);

        con_det1.setLayout(null);

        jLabel32.setText("Present Address:");
        con_det1.add(jLabel32);
        jLabel32.setBounds(191, 142, 117, 16);

        jLabel33.setText("Permanent Address:");
        con_det1.add(jLabel33);
        jLabel33.setBounds(191, 263, 110, 30);

        jLabel34.setText("Email:");
        con_det1.add(jLabel34);
        jLabel34.setBounds(191, 385, 117, 16);

        jLabel35.setText("Contact No:");
        con_det1.add(jLabel35);
        jLabel35.setBounds(191, 433, 117, 16);

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jScrollPane3.setViewportView(jTextArea3);

        con_det1.add(jScrollPane3);
        jScrollPane3.setBounds(314, 112, 324, 83);

        jTextArea4.setColumns(20);
        jTextArea4.setRows(5);
        jScrollPane4.setViewportView(jTextArea4);

        con_det1.add(jScrollPane4);
        jScrollPane4.setBounds(314, 232, 324, 83);
        con_det1.add(jTextField22);
        jTextField22.setBounds(314, 381, 324, 24);
        con_det1.add(jTextField23);
        jTextField23.setBounds(314, 429, 324, 24);

        jButton13.setText("Save");
        jButton13.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton13ActionPerformed(evt);
            }
        });
        con_det1.add(jButton13);
        jButton13.setBounds(550, 490, 130, 30);

        updateemp.addTab("Contact Details", con_det1);

        layer.add(updateemp, "card3");

        removeemp.setLayout(null);

        jButton12.setText("Remove");
        jButton12.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton12ActionPerformed(evt);
            }
        });
        removeemp.add(jButton12);
        jButton12.setBounds(556, 462, 130, 40);
        removeemp.add(jLabel19);
        jLabel19.setBounds(220, 370, 200, 40);
        removeemp.add(jLabel49);
        jLabel49.setBounds(220, 240, 240, 40);

        jLabel50.setText("Contact NO.:");
        removeemp.add(jLabel50);
        jLabel50.setBounds(100, 430, 110, 40);

        jLabel63.setText("Email:");
        removeemp.add(jLabel63);
        jLabel63.setBounds(100, 490, 110, 40);
        removeemp.add(jLabel64);
        jLabel64.setBounds(220, 310, 190, 40);

        jLabel65.setText("Birthday:");
        removeemp.add(jLabel65);
        jLabel65.setBounds(100, 180, 110, 40);

        jLabel66.setText("Gender:");
        removeemp.add(jLabel66);
        jLabel66.setBounds(100, 110, 110, 40);

        jLabel67.setText("Name:");
        removeemp.add(jLabel67);
        jLabel67.setBounds(100, 40, 110, 40);

        jLabel68.setText("Designation:");
        removeemp.add(jLabel68);
        jLabel68.setBounds(100, 370, 110, 40);

        Departmentads.setText("Department:");
        removeemp.add(Departmentads);
        Departmentads.setBounds(100, 310, 110, 40);

        jLabel70.setText("NID:");
        removeemp.add(jLabel70);
        jLabel70.setBounds(100, 240, 110, 40);
        removeemp.add(jLabel71);
        jLabel71.setBounds(220, 40, 200, 40);
        removeemp.add(jLabel72);
        jLabel72.setBounds(220, 110, 170, 40);
        removeemp.add(jLabel73);
        jLabel73.setBounds(220, 180, 190, 40);
        removeemp.add(jLabel74);
        jLabel74.setBounds(220, 430, 210, 40);
        removeemp.add(jLabel75);
        jLabel75.setBounds(220, 490, 210, 40);

        jLabel18.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        removeemp.add(jLabel18);
        jLabel18.setBounds(500, 116, 240, 280);

        layer.add(removeemp, "card6");

        adddep.setLayout(null);

        jLabel42.setText("Deparment Id");
        adddep.add(jLabel42);
        jLabel42.setBounds(172, 104, 110, 20);

        jLabel43.setText("Department Name");
        adddep.add(jLabel43);
        jLabel43.setBounds(172, 175, 120, 20);
        adddep.add(jTextField29);
        jTextField29.setBounds(378, 100, 95, 24);
        adddep.add(jTextField30);
        jTextField30.setBounds(378, 177, 95, 24);

        save_dep.setText("Save");
        save_dep.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                save_depActionPerformed(evt);
            }
        });
        adddep.add(save_dep);
        save_dep.setBounds(267, 328, 66, 32);

        layer.add(adddep, "card7");

        updatedep.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel45.setText("Deparment Id");
        updatedep.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(172, 103, -1, -1));

        jLabel46.setText("Department Name");
        updatedep.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(172, 176, -1, -1));

        jLabel47.setText("Leave Allocation:");
        updatedep.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(172, 243, -1, -1));
        updatedep.add(jTextField34, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 180, 95, -1));

        up_dep.setText("Save");
        up_dep.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                up_depActionPerformed(evt);
            }
        });
        updatedep.add(up_dep, new org.netbeans.lib.awtextra.AbsoluteConstraints(267, 316, 66, -1));
        updatedep.add(jLabel112, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 100, 90, 30));
        updatedep.add(jTextField35, new org.netbeans.lib.awtextra.AbsoluteConstraints(361, 240, 95, -1));

        layer.add(updatedep, "card7");

        deletedep.setLayout(null);

        jLabel114.setText("Deparment Id:");
        deletedep.add(jLabel114);
        jLabel114.setBounds(170, 150, 110, 30);

        jLabel115.setText("Department Name:");
        deletedep.add(jLabel115);
        jLabel115.setBounds(170, 190, 120, 30);
        deletedep.add(jLabel117);
        jLabel117.setBounds(0, 0, 0, 0);
        deletedep.add(jLabel118);
        jLabel118.setBounds(0, 0, 0, 0);

        jButton19.setText("Delete");
        jButton19.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton19ActionPerformed(evt);
            }
        });
        deletedep.add(jButton19);
        jButton19.setBounds(270, 390, 160, 30);

        jLabel119.setText("Department Employees:");
        deletedep.add(jLabel119);
        jLabel119.setBounds(170, 230, 170, 30);
        deletedep.add(jLabel120);
        jLabel120.setBounds(380, 230, 170, 30);
        deletedep.add(jLabel116);
        jLabel116.setBounds(380, 190, 120, 30);
        deletedep.add(jLabel121);
        jLabel121.setBounds(380, 150, 110, 30);

        jLabel122.setText("Allocated Leave Days:");
        deletedep.add(jLabel122);
        jLabel122.setBounds(170, 310, 170, 30);

        jLabel123.setText("Unavailable Employees on Department:");
        deletedep.add(jLabel123);
        jLabel123.setBounds(170, 270, 190, 30);
        deletedep.add(jLabel124);
        jLabel124.setBounds(380, 270, 120, 30);
        deletedep.add(jLabel125);
        jLabel125.setBounds(380, 310, 170, 30);

        layer.add(deletedep, "card7");

        attendence.setLayout(null);

        att_tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {
                "Id", "Name", "date", "Time In", "Time out", "Overtime"
            }
        )
        {
            boolean[] canEdit = new boolean []
            {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex)
            {
                return canEdit [columnIndex];
            }
        });
        att_tbl.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        att_tbl.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        att_tbl.setDebugGraphicsOptions(javax.swing.DebugGraphics.BUFFERED_OPTION);
        att_tbl.setDoubleBuffered(true);
        att_tbl.setEditingColumn(0);
        att_tbl.setEditingRow(0);
        att_tbl.setName(""); // NOI18N
        jScrollPane6.setViewportView(att_tbl);
        if (att_tbl.getColumnModel().getColumnCount() > 0)
        {
            att_tbl.getColumnModel().getColumn(0).setResizable(false);
            att_tbl.getColumnModel().getColumn(1).setResizable(false);
            att_tbl.getColumnModel().getColumn(2).setResizable(false);
            att_tbl.getColumnModel().getColumn(3).setResizable(false);
            att_tbl.getColumnModel().getColumn(4).setResizable(false);
            att_tbl.getColumnModel().getColumn(5).setResizable(false);
        }

        attendence.add(jScrollPane6);
        jScrollPane6.setBounds(80, 260, 700, 220);

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton1ActionPerformed(evt);
            }
        });
        attendence.add(jButton1);
        jButton1.setBounds(670, 130, 100, 32);

        srchby.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Search Method", "Search by id", "Search by month" }));
        srchby.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                srchbyActionPerformed(evt);
            }
        });
        attendence.add(srchby);
        srchby.setBounds(490, 130, 160, 26);

        jPanel3.setLayout(new java.awt.CardLayout());

        jPanel7.setLayout(null);
        jPanel3.add(jPanel7, "card4");

        srchbyid.setLayout(null);

        jLabel51.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel51.setText("Select Date:");
        srchbyid.add(jLabel51);
        jLabel51.setBounds(60, 30, 90, 30);

        att_date.setDateFormatString("yyyy-MM-dd");
        srchbyid.add(att_date);
        att_date.setBounds(150, 30, 160, 29);

        jLabel20.setText("Id:");
        srchbyid.add(jLabel20);
        jLabel20.setBounds(60, 100, 70, 30);

        att_id.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                att_idActionPerformed(evt);
            }
        });
        srchbyid.add(att_id);
        att_id.setBounds(150, 100, 160, 30);

        jPanel3.add(srchbyid, "card2");

        srchbyyr.setLayout(null);

        jLabel38.setText("Month:");
        srchbyyr.add(jLabel38);
        jLabel38.setBounds(65, 28, 60, 30);

        att_mnth.setAutoscrolls(true);
        att_mnth.setMonth(12);
        att_mnth.setYearChooser(att_yr);
        srchbyyr.add(att_mnth);
        att_mnth.setBounds(165, 32, 140, 30);

        att_yr.setMinimum(0);
        att_yr.setValue(0);
        srchbyyr.add(att_yr);
        att_yr.setBounds(165, 102, 120, 30);

        jLabel48.setText("Year:");
        srchbyyr.add(jLabel48);
        jLabel48.setBounds(75, 108, 29, 20);

        jPanel3.add(srchbyyr, "card3");

        attendence.add(jPanel3);
        jPanel3.setBounds(80, 50, 370, 160);

        layer.add(attendence, "card10");

        leave.setLayout(null);

        jLabel52.setText("Id");
        leave.add(jLabel52);
        jLabel52.setBounds(130, 90, 70, 20);
        leave.add(jTextField38);
        jTextField38.setBounds(260, 90, 130, 24);

        jLabel53.setText("Start Date");
        leave.add(jLabel53);
        jLabel53.setBounds(130, 270, 60, 20);

        jLabel54.setText("End Date");
        leave.add(jLabel54);
        jLabel54.setBounds(130, 310, 60, 30);
        leave.add(jTextField39);
        jTextField39.setBounds(260, 270, 130, 20);
        leave.add(jTextField40);
        jTextField40.setBounds(260, 310, 130, 20);

        jLabel56.setText("Reason");
        leave.add(jLabel56);
        jLabel56.setBounds(130, 130, 60, 20);

        jTextArea5.setColumns(20);
        jTextArea5.setRows(5);
        jScrollPane7.setViewportView(jTextArea5);

        leave.add(jScrollPane7);
        jScrollPane7.setBounds(260, 130, 223, 83);

        jButton3.setText("Save");
        jButton3.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton3ActionPerformed(evt);
            }
        });
        leave.add(jButton3);
        jButton3.setBounds(370, 380, 90, 32);
        leave.add(jLabel55);
        jLabel55.setBounds(580, 150, 220, 50);
        leave.add(jLabel86);
        jLabel86.setBounds(580, 230, 180, 40);

        layer.add(leave, "card11");

        payroll.setLayout(null);

        jLabel57.setText("id:");
        payroll.add(jLabel57);
        jLabel57.setBounds(120, 70, 70, 20);
        payroll.add(payr_id);
        payr_id.setBounds(230, 70, 110, 20);

        jLabel59.setText("House Rent Allow:");
        payroll.add(jLabel59);
        jLabel59.setBounds(70, 320, 130, 24);
        payroll.add(jSeparator3);
        jSeparator3.setBounds(33, 215, 820, 10);

        HRA.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                HRAActionPerformed(evt);
            }
        });
        HRA.addPropertyChangeListener(new java.beans.PropertyChangeListener()
        {
            public void propertyChange(java.beans.PropertyChangeEvent evt)
            {
                HRAPropertyChange(evt);
            }
        });
        HRA.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                HRAKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt)
            {
                HRAKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                HRAKeyTyped(evt);
            }
        });
        payroll.add(HRA);
        HRA.setBounds(230, 320, 120, 24);

        jLabel60.setText("Education Allow:");
        payroll.add(jLabel60);
        jLabel60.setBounds(70, 370, 120, 20);

        EA.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                EAActionPerformed(evt);
            }
        });
        EA.addPropertyChangeListener(new java.beans.PropertyChangeListener()
        {
            public void propertyChange(java.beans.PropertyChangeEvent evt)
            {
                EAPropertyChange(evt);
            }
        });
        EA.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                EAKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt)
            {
                EAKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                EAKeyTyped(evt);
            }
        });
        payroll.add(EA);
        EA.setBounds(230, 370, 120, 24);

        jLabel61.setText("Conveyance Allow:");
        payroll.add(jLabel61);
        jLabel61.setBounds(70, 420, 140, 30);

        CA.addPropertyChangeListener(new java.beans.PropertyChangeListener()
        {
            public void propertyChange(java.beans.PropertyChangeEvent evt)
            {
                CAPropertyChange(evt);
            }
        });
        CA.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                CAKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt)
            {
                CAKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                CAKeyTyped(evt);
            }
        });
        payroll.add(CA);
        CA.setBounds(230, 420, 120, 24);

        jButton20.setText("Pay");
        jButton20.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton20ActionPerformed(evt);
            }
        });
        payroll.add(jButton20);
        jButton20.setBounds(540, 510, 100, 32);

        jLabel62.setText("Basic Salary:");
        payroll.add(jLabel62);
        jLabel62.setBounds(70, 270, 120, 20);

        jButton21.setText("Search");
        jButton21.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton21ActionPerformed(evt);
            }
        });
        payroll.add(jButton21);
        jButton21.setBounds(520, 90, 110, 30);
        payroll.add(payr_mnth);
        payr_mnth.setBounds(230, 140, 120, 24);
        payroll.add(payr_yr);
        payr_yr.setBounds(230, 170, 120, 24);

        jLabel69.setText("Month:");
        payroll.add(jLabel69);
        jLabel69.setBounds(124, 136, 50, 30);

        jLabel76.setText("Year:");
        payroll.add(jLabel76);
        jLabel76.setBounds(126, 166, 40, 30);
        payroll.add(jLabel77);
        jLabel77.setBounds(230, 110, 120, 0);
        payroll.add(jLabel78);
        jLabel78.setBounds(230, 270, 180, 20);

        jLabel79.setText("Total:");
        payroll.add(jLabel79);
        jLabel79.setBounds(660, 470, 70, 30);
        payroll.add(jLabel80);
        jLabel80.setBounds(700, 470, 150, 30);

        jLabel81.setText("Income Tax:");
        payroll.add(jLabel81);
        jLabel81.setBounds(480, 320, 80, 20);

        jLabel82.setText("Canteen Bill:");
        payroll.add(jLabel82);
        jLabel82.setBounds(480, 370, 80, 20);

        jLabel83.setText("Other:");
        payroll.add(jLabel83);
        jLabel83.setBounds(480, 420, 80, 20);

        IT.addPropertyChangeListener(new java.beans.PropertyChangeListener()
        {
            public void propertyChange(java.beans.PropertyChangeEvent evt)
            {
                ITPropertyChange(evt);
            }
        });
        IT.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                ITKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt)
            {
                ITKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                ITKeyTyped(evt);
            }
        });
        payroll.add(IT);
        IT.setBounds(620, 320, 140, 24);

        CB.addPropertyChangeListener(new java.beans.PropertyChangeListener()
        {
            public void propertyChange(java.beans.PropertyChangeEvent evt)
            {
                CBPropertyChange(evt);
            }
        });
        CB.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                CBKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt)
            {
                CBKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                CBKeyTyped(evt);
            }
        });
        payroll.add(CB);
        CB.setBounds(620, 370, 140, 24);

        OT.addPropertyChangeListener(new java.beans.PropertyChangeListener()
        {
            public void propertyChange(java.beans.PropertyChangeEvent evt)
            {
                OTPropertyChange(evt);
            }
        });
        OT.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                OTKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt)
            {
                OTKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                OTKeyTyped(evt);
            }
        });
        payroll.add(OT);
        OT.setBounds(620, 420, 140, 24);
        payroll.add(jLabel84);
        jLabel84.setBounds(540, 160, 160, 30);

        jButton2.setText("Clear");
        jButton2.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton2ActionPerformed(evt);
            }
        });
        payroll.add(jButton2);
        jButton2.setBounds(680, 510, 90, 32);

        jLabel24.setText("Name:");
        payroll.add(jLabel24);
        jLabel24.setBounds(120, 110, 60, 20);
        payroll.add(jLabel26);
        jLabel26.setBounds(230, 110, 100, 0);
        payroll.add(jLabel40);
        jLabel40.setBounds(230, 110, 120, 20);

        layer.add(payroll, "card12");

        upuser_pan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField9.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jTextField9ActionPerformed(evt);
            }
        });
        upuser_pan.add(jTextField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 200, 130, 30));

        jButton17.setText("Save");
        jButton17.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton17ActionPerformed(evt);
            }
        });
        upuser_pan.add(jButton17, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 360, 120, 30));

        jLabel88.setText("Password:");
        upuser_pan.add(jLabel88, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 200, 70, 30));

        jLabel89.setText("role:");
        upuser_pan.add(jLabel89, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 250, 70, 30));

        jLabel87.setText("UserID:");
        upuser_pan.add(jLabel87, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 150, 70, 30));
        upuser_pan.add(jLabel90, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 150, 120, 30));
        upuser_pan.add(jLabel97, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 250, 130, 30));

        layer.add(upuser_pan, "card13");

        jLabel91.setText("UserID:");

        jLabel92.setText("Password:");

        jLabel93.setText("role:");

        jButton4.setText("Delete");
        jButton4.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout deluser_panLayout = new javax.swing.GroupLayout(deluser_pan);
        deluser_pan.setLayout(deluser_panLayout);
        deluser_panLayout.setHorizontalGroup(
            deluser_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(deluser_panLayout.createSequentialGroup()
                .addGap(216, 216, 216)
                .addGroup(deluser_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel93, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel91, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel92, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(deluser_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel95, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel96, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                    .addComponent(jLabel94, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(453, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, deluser_panLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(237, 237, 237))
        );
        deluser_panLayout.setVerticalGroup(
            deluser_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(deluser_panLayout.createSequentialGroup()
                .addGap(202, 202, 202)
                .addGroup(deluser_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel91, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel94, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(deluser_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel95, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel92, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addGap(20, 20, 20)
                .addGroup(deluser_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel93, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel96, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addComponent(jButton4)
                .addContainerGap(163, Short.MAX_VALUE))
        );

        layer.add(deluser_pan, "card14");

        adddes_pan.setLayout(null);

        jLabel98.setText("Designation ID:");
        adddes_pan.add(jLabel98);
        jLabel98.setBounds(150, 186, 150, 20);

        jLabel99.setText("Designation Name:");
        adddes_pan.add(jLabel99);
        jLabel99.setBounds(150, 236, 110, 20);

        jLabel100.setText("Basic Salary:");
        adddes_pan.add(jLabel100);
        jLabel100.setBounds(150, 290, 100, 20);

        jButton18.setText("Save");
        jButton18.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton18ActionPerformed(evt);
            }
        });
        adddes_pan.add(jButton18);
        jButton18.setBounds(590, 460, 110, 32);
        adddes_pan.add(jTextField1);
        jTextField1.setBounds(340, 180, 110, 30);
        adddes_pan.add(jTextField2);
        jTextField2.setBounds(340, 230, 110, 30);

        jTextField3.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jTextField3ActionPerformed(evt);
            }
        });
        adddes_pan.add(jTextField3);
        jTextField3.setBounds(340, 280, 110, 30);

        layer.add(adddes_pan, "card15");

        updes_pan.setLayout(null);

        jLabel101.setText("Designation Id:");
        updes_pan.add(jLabel101);
        jLabel101.setBounds(150, 190, 83, 16);

        jLabel102.setText("Designation Name:");
        updes_pan.add(jLabel102);
        jLabel102.setBounds(150, 236, 120, 20);

        jLabel103.setText("Basic Salary:");
        updes_pan.add(jLabel103);
        jLabel103.setBounds(150, 280, 90, 30);

        jButton22.setText("Save");
        jButton22.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton22ActionPerformed(evt);
            }
        });
        updes_pan.add(jButton22);
        jButton22.setBounds(590, 460, 58, 32);
        updes_pan.add(jLabel111);
        jLabel111.setBounds(290, 180, 110, 40);
        updes_pan.add(jTextField5);
        jTextField5.setBounds(290, 280, 110, 30);
        updes_pan.add(jLabel107);
        jLabel107.setBounds(290, 226, 110, 40);

        layer.add(updes_pan, "card16");

        remdes_pan.setLayout(null);

        jLabel104.setText("Designation ID:");
        remdes_pan.add(jLabel104);
        jLabel104.setBounds(143, 180, 90, 40);

        jLabel105.setText("Designation Name:");
        remdes_pan.add(jLabel105);
        jLabel105.setBounds(141, 240, 120, 30);

        jLabel106.setText("Basic Salary:");
        remdes_pan.add(jLabel106);
        jLabel106.setBounds(140, 280, 100, 30);

        jButton23.setText("Delete");
        jButton23.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton23ActionPerformed(evt);
            }
        });
        remdes_pan.add(jButton23);
        jButton23.setBounds(590, 460, 100, 30);
        remdes_pan.add(jLabel108);
        jLabel108.setBounds(270, 180, 100, 40);
        remdes_pan.add(jLabel109);
        jLabel109.setBounds(270, 240, 110, 30);
        remdes_pan.add(jLabel110);
        jLabel110.setBounds(270, 280, 100, 30);

        layer.add(remdes_pan, "card17");

        about.setLayout(null);

        jLabel41.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel41.setText(" This project  Done by"); // NOI18N
        jLabel41.setToolTipText("");
        about.add(jLabel41);
        jLabel41.setBounds(190, 200, 217, 35);

        jLabel44.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel44.setText("Shadman Sakib Abir");
        about.add(jLabel44);
        jLabel44.setBounds(270, 240, 190, 26);

        jLabel129.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel129.setText("Department OF  Computer Science and Engineering ,IUBAT University");
        about.add(jLabel129);
        jLabel129.setBounds(270, 280, 470, 20);

        jLabel130.setText("shadmanabir@outlook.com");
        about.add(jLabel130);
        jLabel130.setBounds(270, 260, 280, 30);

        layer.add(about, "card18");

        getContentPane().add(layer);
        layer.setBounds(280, 100, 870, 570);

        side_pan.setBorder(new javax.swing.border.MatteBorder(null));
        side_pan.setLayout(new java.awt.CardLayout());

        jLabel39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/istock_000027366352medium_0.jpg"))); // NOI18N

        javax.swing.GroupLayout first_sidepanLayout = new javax.swing.GroupLayout(first_sidepan);
        first_sidepan.setLayout(first_sidepanLayout);
        first_sidepanLayout.setHorizontalGroup(
            first_sidepanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1600, Short.MAX_VALUE)
            .addGroup(first_sidepanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel39, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        first_sidepanLayout.setVerticalGroup(
            first_sidepanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1200, Short.MAX_VALUE)
            .addGroup(first_sidepanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        side_pan.add(first_sidepan, "card8");

        emp_sidepan.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        emp_sidepan.setLayout(null);

        emp_add.setText("Add Employee");
        emp_add.setDefaultCapable(false);
        emp_add.setFocusPainted(false);
        emp_add.setRequestFocusEnabled(false);
        emp_add.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                emp_addActionPerformed(evt);
            }
        });
        emp_sidepan.add(emp_add);
        emp_add.setBounds(-8, 20, 260, 60);

        emp_up.setText("Update Employee");
        emp_up.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                emp_upActionPerformed(evt);
            }
        });
        emp_sidepan.add(emp_up);
        emp_up.setBounds(0, 100, 270, 60);

        emp_rem.setText("View/Remove Employee");
        emp_rem.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                emp_remActionPerformed(evt);
            }
        });
        emp_sidepan.add(emp_rem);
        emp_rem.setBounds(-10, 180, 270, 60);

        emp_list.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        emp_list.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {
                "", "", ""
            }
        )
        {
            boolean[] canEdit = new boolean []
            {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex)
            {
                return canEdit [columnIndex];
            }
        });
        emp_list.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        emp_list.setSelectionBackground(new java.awt.Color(102, 102, 102));
        emp_list.setShowHorizontalLines(false);
        emp_list.setShowVerticalLines(false);
        emp_list.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                emp_listMouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(emp_list);
        if (emp_list.getColumnModel().getColumnCount() > 0)
        {
            emp_list.getColumnModel().getColumn(0).setResizable(false);
            emp_list.getColumnModel().getColumn(1).setResizable(false);
            emp_list.getColumnModel().getColumn(2).setResizable(false);
        }

        emp_sidepan.add(jScrollPane10);
        jScrollPane10.setBounds(-8, 266, 260, 300);

        side_pan.add(emp_sidepan, "card2");

        dep_sidepan.setLayout(null);

        dep_add.setText("Add Department");
        dep_add.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                dep_addActionPerformed(evt);
            }
        });
        dep_sidepan.add(dep_add);
        dep_add.setBounds(-11, 25, 270, 50);

        dep_up.setText("Update Department");
        dep_up.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                dep_upActionPerformed(evt);
            }
        });
        dep_sidepan.add(dep_up);
        dep_up.setBounds(-11, 100, 270, 50);

        dep_del.setText("View/Delete Department");
        dep_del.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                dep_delActionPerformed(evt);
            }
        });
        dep_sidepan.add(dep_del);
        dep_del.setBounds(-11, 175, 270, 50);

        jScrollPane5.setBorder(new javax.swing.border.MatteBorder(null));

        dep_list.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        dep_list.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {
                ""
            }
        )
        {
            boolean[] canEdit = new boolean []
            {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex)
            {
                return canEdit [columnIndex];
            }
        });
        dep_list.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        dep_list.setName(""); // NOI18N
        dep_list.setRowHeight(20);
        dep_list.setSelectionBackground(new java.awt.Color(102, 102, 102));
        dep_list.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        dep_list.setShowHorizontalLines(false);
        dep_list.setShowVerticalLines(false);
        dep_list.getTableHeader().setResizingAllowed(false);
        dep_list.getTableHeader().setReorderingAllowed(false);
        dep_list.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                dep_listMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(dep_list);
        dep_list.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (dep_list.getColumnModel().getColumnCount() > 0)
        {
            dep_list.getColumnModel().getColumn(0).setPreferredWidth(300);
        }

        dep_sidepan.add(jScrollPane5);
        jScrollPane5.setBounds(-11, 253, 270, 290);

        side_pan.add(dep_sidepan, "card3");

        des_sidepan.setLayout(null);

        des_del.setText("View/Delete Department");
        des_del.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                des_delActionPerformed(evt);
            }
        });
        des_sidepan.add(des_del);
        des_del.setBounds(-10, 150, 270, 60);

        des_up.setText("Update Designation");
        des_up.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                des_upActionPerformed(evt);
            }
        });
        des_sidepan.add(des_up);
        des_up.setBounds(-10, 80, 270, 60);

        des_add.setText("Add Designation");
        des_add.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                des_addActionPerformed(evt);
            }
        });
        des_sidepan.add(des_add);
        des_add.setBounds(-10, 10, 270, 60);

        jScrollPane9.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        des_list.setAutoCreateRowSorter(true);
        des_list.setBorder(new javax.swing.border.MatteBorder(null));
        des_list.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        des_list.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {

            }
        ));
        des_list.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        des_list.setRowHeight(18);
        des_list.setShowHorizontalLines(false);
        des_list.setShowVerticalLines(false);
        des_list.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                des_listMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(des_list);
        des_list.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        des_sidepan.add(jScrollPane9);
        jScrollPane9.setBounds(0, 230, 250, 310);

        side_pan.add(des_sidepan, "card4");

        app.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {
                {},
                {},
                {},
                {}
            },
            new String []
            {

            }
        ));
        app.setEditingColumn(0);
        app.setEditingRow(0);
        app.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                appMouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(app);

        javax.swing.GroupLayout lve_sidepanLayout = new javax.swing.GroupLayout(lve_sidepan);
        lve_sidepan.setLayout(lve_sidepanLayout);
        lve_sidepanLayout.setHorizontalGroup(
            lve_sidepanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE)
        );
        lve_sidepanLayout.setVerticalGroup(
            lve_sidepanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE)
        );

        side_pan.add(lve_sidepan, "card7");

        us_sidepan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        user_add.setText("Add User");
        user_add.setMaximumSize(new java.awt.Dimension(100, 32));
        user_add.setMinimumSize(new java.awt.Dimension(100, 32));
        user_add.setPreferredSize(new java.awt.Dimension(100, 32));
        user_add.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                user_addActionPerformed(evt);
            }
        });
        us_sidepan.add(user_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 20, 270, 50));

        user_up.setText("Change Password");
        user_up.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                user_upActionPerformed(evt);
            }
        });
        us_sidepan.add(user_up, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 90, 270, 50));

        user_rem.setText("Delete User");
        user_rem.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                user_remActionPerformed(evt);
            }
        });
        us_sidepan.add(user_rem, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 160, 270, 50));

        us_list.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        us_list.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {
                "", "", ""
            }
        )
        {
            boolean[] canEdit = new boolean []
            {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex)
            {
                return canEdit [columnIndex];
            }
        });
        us_list.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        us_list.setSelectionBackground(new java.awt.Color(102, 102, 102));
        us_list.setShowHorizontalLines(false);
        us_list.setShowVerticalLines(false);
        us_list.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                us_listMouseClicked(evt);
            }
        });
        jScrollPane12.setViewportView(us_list);
        if (us_list.getColumnModel().getColumnCount() > 0)
        {
            us_list.getColumnModel().getColumn(0).setResizable(false);
            us_list.getColumnModel().getColumn(1).setResizable(false);
            us_list.getColumnModel().getColumn(2).setResizable(false);
        }

        us_sidepan.add(jScrollPane12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 250, 310));

        side_pan.add(us_sidepan, "card8");

        getContentPane().add(side_pan);
        side_pan.setBounds(20, 100, 250, 570);

        jLabel37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/banner-products_hr.jpg"))); // NOI18N
        getContentPane().add(jLabel37);
        jLabel37.setBounds(0, 0, 1160, 690);

        jMenuBar1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N

        emp_menu.setText("Employee");
        emp_menu.setDelay(0);
        emp_menu.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        emp_menu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        emp_menu.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        emp_menu.setIconTextGap(8);
        emp_menu.setPreferredSize(new java.awt.Dimension(90, 30));
        emp_menu.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                emp_menuMouseClicked(evt);
            }
        });
        emp_menu.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                emp_menuActionPerformed(evt);
            }
        });
        jMenuBar1.add(emp_menu);

        dep_menu.setText("Department");
        dep_menu.setDelay(0);
        dep_menu.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        dep_menu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dep_menu.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        dep_menu.setIconTextGap(8);
        dep_menu.setPreferredSize(new java.awt.Dimension(105, 30));
        dep_menu.setVerifyInputWhenFocusTarget(false);
        dep_menu.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                dep_menuMouseClicked(evt);
            }
        });
        jMenuBar1.add(dep_menu);

        des_menu.setText("Designation");
        des_menu.setDelay(0);
        des_menu.setFocusable(false);
        des_menu.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        des_menu.setHideActionText(true);
        des_menu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        des_menu.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        des_menu.setIconTextGap(8);
        des_menu.setPreferredSize(new java.awt.Dimension(105, 30));
        des_menu.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                des_menuMouseClicked(evt);
            }
        });
        jMenuBar1.add(des_menu);

        att_menu.setText("Attendance");
        att_menu.setDelay(0);
        att_menu.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        att_menu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        att_menu.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        att_menu.setIconTextGap(8);
        att_menu.setPreferredSize(new java.awt.Dimension(101, 30));
        att_menu.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                att_menuMouseClicked(evt);
            }
        });
        jMenuBar1.add(att_menu);

        lv_menu.setText("Leave");
        lv_menu.setDelay(0);
        lv_menu.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lv_menu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lv_menu.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lv_menu.setIconTextGap(8);
        lv_menu.setPreferredSize(new java.awt.Dimension(63, 30));
        lv_menu.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                lv_menuMouseClicked(evt);
            }
        });
        lv_menu.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                lv_menuActionPerformed(evt);
            }
        });
        jMenuBar1.add(lv_menu);

        pay_menu.setText("Payment");
        pay_menu.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        pay_menu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pay_menu.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pay_menu.setIconTextGap(8);
        pay_menu.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                pay_menuMouseClicked(evt);
            }
        });
        jMenuBar1.add(pay_menu);

        us_menu.setText("User");
        us_menu.setDelay(0);
        us_menu.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        us_menu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        us_menu.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        us_menu.setIconTextGap(8);
        us_menu.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                us_menuMouseClicked(evt);
            }
        });
        jMenuBar1.add(us_menu);

        op_menu.setText("Option");
        op_menu.setDelay(0);
        op_menu.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        op_menu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        op_menu.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        op_menu.setIconTextGap(8);

        jMenuItem1.setText("Default");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jMenuItem1ActionPerformed(evt);
            }
        });
        op_menu.add(jMenuItem1);

        jMenuItem2.setText("Silver");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jMenuItem2ActionPerformed(evt);
            }
        });
        op_menu.add(jMenuItem2);

        jMenuItem3.setText("Black");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jMenuItem3ActionPerformed(evt);
            }
        });
        op_menu.add(jMenuItem3);

        jMenuItem4.setText("Blue");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jMenuItem4ActionPerformed(evt);
            }
        });
        op_menu.add(jMenuItem4);

        jMenuBar1.add(op_menu);

        about_menu.setText("About");
        about_menu.setDelay(0);
        about_menu.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        about_menu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        about_menu.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        about_menu.setIconTextGap(8);
        about_menu.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                about_menuMouseClicked(evt);
            }
        });
        about_menu.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                about_menuActionPerformed(evt);
            }
        });
        jMenuBar1.add(about_menu);

        logout.setText("Log Out");
        logout.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        logout.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                logoutMouseClicked(evt);
            }
        });
        jMenuBar1.add(logout);

        setJMenuBar(jMenuBar1);

        setSize(new java.awt.Dimension(1175, 762));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_dnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_dnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_dnActionPerformed

    private void txt_bnkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bnkActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bnkActionPerformed

    private void txt_nidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nidActionPerformed

    private void femaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_femaleActionPerformed
        male.setSelected(false);
        gnd="female";
    }//GEN-LAST:event_femaleActionPerformed

    private void maleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maleActionPerformed
        female.setSelected(false);
        gnd="male";
    }//GEN-LAST:event_maleActionPerformed

    private void dep_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dep_addActionPerformed
        first.setVisible(false);
        addemp.setVisible(false);
        updateemp.setVisible(false);
        removeemp.setVisible(false);
        adddep.setVisible(true);
        updatedep.setVisible(false);
        deletedep.setVisible(false);
        attendence.setVisible(false);
        leave.setVisible(false);
        payroll.setVisible(false);
         about.setVisible(false);
    }//GEN-LAST:event_dep_addActionPerformed

    private void dep_delActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dep_delActionPerformed
        first.setVisible(false);
        addemp.setVisible(false);
        updateemp.setVisible(false);
        removeemp.setVisible(false);
        adddep.setVisible(false);
        updatedep.setVisible(false);
        deletedep.setVisible(true);
        attendence.setVisible(false);
        leave.setVisible(false);
        payroll.setVisible(false);
         about.setVisible(false);
    }//GEN-LAST:event_dep_delActionPerformed

    private void dep_upActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dep_upActionPerformed
         first.setVisible(false);
        addemp.setVisible(false);
        updateemp.setVisible(false);
        removeemp.setVisible(false);
        adddep.setVisible(false);
        updatedep.setVisible(true);
        deletedep.setVisible(false);
        attendence.setVisible(false);
        leave.setVisible(false);
        payroll.setVisible(false);
         about.setVisible(false);
    }//GEN-LAST:event_dep_upActionPerformed

    private void imageMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_imageMouseClicked
    {//GEN-HEADEREND:event_imageMouseClicked
    FileDialog fd = new FileDialog(this);
    fd.show();
    path=fd.getDirectory()+fd.getFile();
    BufferedImage img = null;
    try 
    {
        img = ImageIO.read(new File(path));

    } catch (Exception e) 
    {
        e.printStackTrace();
    }

    ImageIcon imageIcon = new ImageIcon(fitimage(img, image.getWidth(), image.getHeight()));
    image.setIcon(imageIcon);
    }//GEN-LAST:event_imageMouseClicked

    private void emp_saveActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_emp_saveActionPerformed
    {//GEN-HEADEREND:event_emp_saveActionPerformed
           try
    {
        FileInputStream fin = null;
        File img = null;
        
        img= new File(path);
        fin=new FileInputStream(img);
        String s = txt_role.getSelectedItem().toString();
        boolean b=modal.insert_emp((Integer.parseInt(txt_id.getText())),txt_fn.getText(),txt_ln.getText(),gnd,((JTextField)txt_dob.getDateEditor().getUiComponent()).getText(),(Integer.parseInt(txt_nid.getText())), img,(Integer.parseInt(txt_bnk.getText())),txt_dn.getText(),txt_ds.getText(),s,txt_ptadd.getText(),txt_pradd.getText(),txt_em.getText(),(Integer.parseInt(txt_con.getText())),fin);
         if(b==true)
        {
        JOptionPane.showMessageDialog(null, "Successfully Inserted");
        new email(txt_em.getText(),txt_fn.getText(),txt_ln.getText());
        empInfo();
        }
        else
        {
        JOptionPane.showMessageDialog(null, "Failed");
        }
    }
    catch (Exception ex)
        
    {
        JOptionPane.showMessageDialog(null, ex);
    }
   
    }//GEN-LAST:event_emp_saveActionPerformed

    private void save_depActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_save_depActionPerformed
    {//GEN-HEADEREND:event_save_depActionPerformed
    try {
        modal.ins_dep(jTextField29.getText(), jTextField30.getText());
    } catch (SQLException ex) {
        Logger.getLogger(mainpage.class.getName()).log(Level.SEVERE, null, ex);
    }
    depInfo();
    }//GEN-LAST:event_save_depActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton12ActionPerformed
    {//GEN-HEADEREND:event_jButton12ActionPerformed
    try
    {
        boolean b =modal.delete_emp(id);
        if(b==true){
            JOptionPane.showMessageDialog(null, "Successfully Deleted");
            empInfo();
            jLabel71.setText(null);
            jLabel72.setText(null);
            jLabel73.setText(null);
            jLabel49.setText(null);
            jLabel64.setText(null);
            jLabel19.setText(null);
            jLabel74.setText(null);
            jLabel75.setText(null);
            jLabel18.setIcon(null);
                }
        else
            JOptionPane.showMessageDialog(null, "Failed");
        
    }
    catch (SQLException ex)
    {
        JOptionPane.showMessageDialog(null, ex);
    }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void emp_addActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_emp_addActionPerformed
    {//GEN-HEADEREND:event_emp_addActionPerformed
        first.setVisible(false);
        addemp.setVisible(true);
        updateemp.setVisible(false);
        removeemp.setVisible(false);
        adddep.setVisible(false);
        updatedep.setVisible(false);
        deletedep.setVisible(false);
        attendence.setVisible(false);
        leave.setVisible(false);
        payroll.setVisible(false);
         about.setVisible(false);
    }//GEN-LAST:event_emp_addActionPerformed

    private void emp_upActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_emp_upActionPerformed
    {//GEN-HEADEREND:event_emp_upActionPerformed
        first.setVisible(false);
        addemp.setVisible(false);
        updateemp.setVisible(true);
        removeemp.setVisible(false);
        adddep.setVisible(false);
        updatedep.setVisible(false);
        deletedep.setVisible(false);
        attendence.setVisible(false);
        leave.setVisible(false);
        payroll.setVisible(false);   
         about.setVisible(false);
    }//GEN-LAST:event_emp_upActionPerformed

    private void emp_remActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_emp_remActionPerformed
    {//GEN-HEADEREND:event_emp_remActionPerformed
        first.setVisible(false);
        addemp.setVisible(false);
        updateemp.setVisible(false);
        removeemp.setVisible(true);
        adddep.setVisible(false);
        updatedep.setVisible(false);
        deletedep.setVisible(false);
        attendence.setVisible(false);
        leave.setVisible(false);
        payroll.setVisible(false);  
        adduser_pan.setVisible(false);
         about.setVisible(false);
    }//GEN-LAST:event_emp_remActionPerformed

    private void emp_menuActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_emp_menuActionPerformed
    {//GEN-HEADEREND:event_emp_menuActionPerformed

    }//GEN-LAST:event_emp_menuActionPerformed

    private void dep_menuMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_dep_menuMouseClicked
    {//GEN-HEADEREND:event_dep_menuMouseClicked
        first.setVisible(true);
        addemp.setVisible(false);
        updateemp.setVisible(false);
        removeemp.setVisible(false);
        adddep.setVisible(false);
        updatedep.setVisible(false);
        deletedep.setVisible(false);
        attendence.setVisible(false);
        leave.setVisible(false);
        payroll.setVisible(false);
        adduser_pan.setVisible(false);
         about.setVisible(false);
        
        
        
        
        first_sidepan.setVisible(false);
        emp_sidepan.setVisible(false);
        dep_sidepan.setVisible(true);
        des_sidepan.setVisible(false);
        //att_sidepan.setVisible(false);
        lve_sidepan.setVisible(false);        
    }//GEN-LAST:event_dep_menuMouseClicked

    private void emp_listMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_emp_listMouseClicked
    {//GEN-HEADEREND:event_emp_listMouseClicked
       int i= emp_list.getSelectedRow();
       DefaultTableModel model = (DefaultTableModel)emp_list.getModel();
       id= model.getValueAt(i,0).toString();
       empInfo_at(id);
       
    }//GEN-LAST:event_emp_listMouseClicked

    private void emp_menuMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_emp_menuMouseClicked
    {//GEN-HEADEREND:event_emp_menuMouseClicked
        first.setVisible(false);
        addemp.setVisible(true);
        updateemp.setVisible(false);
        removeemp.setVisible(false);
        adddep.setVisible(false);
        updatedep.setVisible(false);
        deletedep.setVisible(false);
        attendence.setVisible(false);
        leave.setVisible(false);
        payroll.setVisible(false);
        adduser_pan.setVisible(false);
         about.setVisible(false);
        
       first_sidepan.setVisible(false);
        emp_sidepan.setVisible(true);
        dep_sidepan.setVisible(false);
        des_sidepan.setVisible(false);
       // att_sidepan.setVisible(false);
        lve_sidepan.setVisible(false);        
    }//GEN-LAST:event_emp_menuMouseClicked

    private void att_menuMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_att_menuMouseClicked
    {//GEN-HEADEREND:event_att_menuMouseClicked
        first.setVisible(false);
        addemp.setVisible(false);
        updateemp.setVisible(false);
        removeemp.setVisible(false);
        adddep.setVisible(false);
        updatedep.setVisible(false);
        deletedep.setVisible(false);
        attendence.setVisible(true);
        leave.setVisible(false);
        payroll.setVisible(false);
        adduser_pan.setVisible(false);
         about.setVisible(false);
        
       first_sidepan.setVisible(true);
        emp_sidepan.setVisible(false);
        dep_sidepan.setVisible(false);
        des_sidepan.setVisible(false);
       // att_sidepan.setVisible(true);
        lve_sidepan.setVisible(false);
    }//GEN-LAST:event_att_menuMouseClicked

    private void pay_menuMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_pay_menuMouseClicked
    {//GEN-HEADEREND:event_pay_menuMouseClicked
        first.setVisible(false);
        addemp.setVisible(false);
        updateemp.setVisible(false);
        removeemp.setVisible(false);
        adddep.setVisible(false);
        updatedep.setVisible(false);
        deletedep.setVisible(false);
        attendence.setVisible(false);
        leave.setVisible(false);
        payroll.setVisible(true);
        adduser_pan.setVisible(false);
         about.setVisible(false);
        
      first_sidepan.setVisible(true);
        emp_sidepan.setVisible(false);
        dep_sidepan.setVisible(false);
        des_sidepan.setVisible(false);
        //att_sidepan.setVisible(false);
        lve_sidepan.setVisible(false);
    }//GEN-LAST:event_pay_menuMouseClicked

    private void lv_menuActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_lv_menuActionPerformed
    {//GEN-HEADEREND:event_lv_menuActionPerformed

    }//GEN-LAST:event_lv_menuActionPerformed

    private void us_menuMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_us_menuMouseClicked
    {//GEN-HEADEREND:event_us_menuMouseClicked
        first.setVisible(false);
        addemp.setVisible(false);
        updateemp.setVisible(false);
        removeemp.setVisible(false);
        adddep.setVisible(false);
        updatedep.setVisible(false);
        deletedep.setVisible(false);
        attendence.setVisible(false);
        leave.setVisible(false);
        payroll.setVisible(false);
        adduser_pan.setVisible(false);
        adduser_pan.setVisible(true);
         about.setVisible(false);
        
       first_sidepan.setVisible(false);
        emp_sidepan.setVisible(false);
        dep_sidepan.setVisible(false);
        des_sidepan.setVisible(false);
        //att_sidepan.setVisible(false);
        lve_sidepan.setVisible(false);
        us_sidepan.setVisible(true);
    }//GEN-LAST:event_us_menuMouseClicked

    private void des_delActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_des_delActionPerformed
    {//GEN-HEADEREND:event_des_delActionPerformed
first.setVisible(false);
        addemp.setVisible(false);
        updateemp.setVisible(false);
        removeemp.setVisible(false);
        adddep.setVisible(false);
        updatedep.setVisible(false);
        deletedep.setVisible(false);
        attendence.setVisible(false);
        leave.setVisible(false);
        payroll.setVisible(false);
        adduser_pan.setVisible(false);
        adduser_pan.setVisible(false);
        adddes_pan.setVisible(false);
        updes_pan.setVisible(false);
        remdes_pan.setVisible(true);
         about.setVisible(false);
        
       first_sidepan.setVisible(false);
        emp_sidepan.setVisible(false);
        dep_sidepan.setVisible(false);
        des_sidepan.setVisible(true);
        //att_sidepan.setVisible(false);
        lve_sidepan.setVisible(false);
        us_sidepan.setVisible(false);
        

    }//GEN-LAST:event_des_delActionPerformed

    private void des_upActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_des_upActionPerformed
    {//GEN-HEADEREND:event_des_upActionPerformed
        first.setVisible(false);
        addemp.setVisible(false);
        updateemp.setVisible(false);
        removeemp.setVisible(false);
        adddep.setVisible(false);
        updatedep.setVisible(false);
        deletedep.setVisible(false);
        attendence.setVisible(false);
        leave.setVisible(false);
        payroll.setVisible(false);
        adduser_pan.setVisible(false);
        adduser_pan.setVisible(false);
         about.setVisible(false);
        
        first_sidepan.setVisible(false);
        emp_sidepan.setVisible(false);
        dep_sidepan.setVisible(false);
        des_sidepan.setVisible(true);
       // att_sidepan.setVisible(false);
        lve_sidepan.setVisible(false);
        us_sidepan.setVisible(false);
        adddes_pan.setVisible(false);
        updes_pan.setVisible(true);
        remdes_pan.setVisible(false);
    }//GEN-LAST:event_des_upActionPerformed

    private void des_addActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_des_addActionPerformed
    {//GEN-HEADEREND:event_des_addActionPerformed
        first.setVisible(false);
        addemp.setVisible(false);
        updateemp.setVisible(false);
        removeemp.setVisible(false);
        adddep.setVisible(false);
        updatedep.setVisible(false);
        deletedep.setVisible(false);
        attendence.setVisible(false);
        leave.setVisible(false);
        payroll.setVisible(false);
        adduser_pan.setVisible(false);
        adduser_pan.setVisible(false);
         about.setVisible(false);
        
       first_sidepan.setVisible(false);
        emp_sidepan.setVisible(false);
        dep_sidepan.setVisible(false);
        des_sidepan.setVisible(true);
       // att_sidepan.setVisible(false);
        lve_sidepan.setVisible(false);
        us_sidepan.setVisible(false);
        adddes_pan.setVisible(true);
        updes_pan.setVisible(false);
        remdes_pan.setVisible(false);
    }//GEN-LAST:event_des_addActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton13ActionPerformed
    {//GEN-HEADEREND:event_jButton13ActionPerformed
    try
    {
        boolean bool=modal.up_emp(jTextField16.getText(), jTextField17.getText(), jTextField18.getText(), jTextField20.getText(), jTextField21.getText(), jComboBox2.getSelectedItem().toString(), jTextField19.getText(), jTextField4.getText(), jTextArea3.getText(), jTextArea4.getText(), jTextField22.getText(), jTextField23.getText(), jTextField15.getText());
        if(bool==true)
            JOptionPane.showMessageDialog(null, "Update successful");
    }
    catch (SQLException ex)
    {
        Logger.getLogger(mainpage.class.getName()).log(Level.SEVERE, null, ex);
    }
    empInfo();
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jTextField20ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jTextField20ActionPerformed
    {//GEN-HEADEREND:event_jTextField20ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField20ActionPerformed

    private void jTextField19ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jTextField19ActionPerformed
    {//GEN-HEADEREND:event_jTextField19ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField19ActionPerformed

    private void jTextField18ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jTextField18ActionPerformed
    {//GEN-HEADEREND:event_jTextField18ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField18ActionPerformed

    private void att_idActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_att_idActionPerformed
    {//GEN-HEADEREND:event_att_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_att_idActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton1ActionPerformed
    {//GEN-HEADEREND:event_jButton1ActionPerformed
      if(srchby.getSelectedItem().toString()=="Search by month")
      {
            
            try
            {
                att_tbl.setModel(DbUtils.resultSetToTableModel(modal.att_by_dt(att_mnth.getMonth(),att_yr.getYear())));
            }
            catch (SQLException ex)
            {
                Logger.getLogger(mainpage.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        else if(srchby.getSelectedItem().toString()=="Search by id")
        {
            try
            {
                att_tbl.setModel(DbUtils.resultSetToTableModel(modal.att_by_id(att_id.getText(),((JTextField)att_date.getDateEditor().getUiComponent()).getText())));
            }
            catch (SQLException ex)
            {
                Logger.getLogger(mainpage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Either search by id and date  or  month and year");
        }
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void srchbyActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_srchbyActionPerformed
    {//GEN-HEADEREND:event_srchbyActionPerformed
    if(srchby.getSelectedItem().toString()=="Search by id")
    {
        jPanel7.setVisible(false);
        srchbyid.setVisible(true);
        srchbyyr.setVisible(false);
    }
    else if(srchby.getSelectedItem().toString()=="Search by month")
    {
        jPanel7.setVisible(false);
        srchbyyr.setVisible(true);
        srchbyid.setVisible(false);
    }
    }//GEN-LAST:event_srchbyActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton20ActionPerformed
    {//GEN-HEADEREND:event_jButton20ActionPerformed
        new Reciept_print(payr_id.getText(),jLabel40.getText(),jLabel78.getText(),HRA.getText(),EA.getText(),CA.getText(),IT.getText(),CB.getText(),OT.getText(),jLabel80.getText()).setVisible(true);
        payr_id.setText(null);
        jLabel40.setText(null);
        jLabel78.setText(null);
        HRA.setText(null);
        EA.setText(null);
        CA.setText(null);
        IT.setText(null);
        CB.setText(null);
        OT.setText(null);
        jLabel80.setText(null);
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton21ActionPerformed
    {//GEN-HEADEREND:event_jButton21ActionPerformed
    try
    {
        ResultSet rs=modal.chk_pay(Integer.parseInt(payr_id.getText()), payr_mnth.getMonth(), payr_yr.getYear());
        
        if(rs.next())
        {
            
       jLabel84.setText("Payment Done");
        jLabel84.setForeground(Color.green);
        }
        else 
        {
 
        String name=null;
         jLabel84.setText("Payment not Done");
         jLabel84.setForeground(Color.red);
         ResultSet rsp=modal.get_pay(Integer.parseInt(payr_id.getText()));
         ResultSet rsa=modal.get_att(Integer.parseInt(payr_id.getText()), payr_mnth.getMonth(), payr_yr.getYear());
         if(rsp.next()) {
             name=rsp.getString(1)+" "+rsp.getString(2);
             scale=rsp.getInt(3);
         }
         if(rsa.next()) {
             datecount=rsa.getInt(1);
         }
         jLabel40.setText(name);
         payement=scale*datecount;
         pay=payement;
         jLabel80.setText(Integer.toString(payement));
         jLabel78.setText(Integer.toString(scale));
         scale=0;
         datecount=0;
         
         }
    }
    catch (SQLException ex)
    {
        JOptionPane.showMessageDialog(null, ex);
    }
    }//GEN-LAST:event_jButton21ActionPerformed

    private void HRAKeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_HRAKeyReleased
    {//GEN-HEADEREND:event_HRAKeyReleased

                double  b=Double.parseDouble(HRA.getText())/100;
    double  a= b*payement;
    payement=Math.abs(payement+(int)a);
    jLabel80.setText(Integer.toString(payement));

                 if(HRA.equals(null) && EA.equals(null) && CA.equals(null) && IT.equals(null) && CB.equals(null) && OT.equals(null))
        {
      
            payement=pay;
            jLabel80.setText(Integer.toString(payement));
        }
    }//GEN-LAST:event_HRAKeyReleased

    private void EAKeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_EAKeyReleased
    {//GEN-HEADEREND:event_EAKeyReleased

                double  b=Double.parseDouble(EA.getText())/100;
    double  a= b*payement;
    payement=Math.abs(payement+(int)a);
    jLabel80.setText(Integer.toString(payement));
        if(HRA.equals(null) && EA.equals(null) && CA.equals(null) && IT.equals(null) && CB.equals(null) && OT.equals(null))
        {
      
            payement=pay;
            jLabel80.setText(Integer.toString(payement));
        }
    }//GEN-LAST:event_EAKeyReleased

    private void CAKeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_CAKeyReleased
    {//GEN-HEADEREND:event_CAKeyReleased

                double  b=Double.parseDouble(CA.getText())/100;
    double  a= b*payement;
    payement=Math.abs(payement+(int)a);
    jLabel80.setText(Integer.toString(payement));

        if(HRA.equals(null) && EA.equals(null) && CA.equals(null) && IT.equals(null) && CB.equals(null) && OT.equals(null))
        {
      
            payement=pay;
            jLabel80.setText(Integer.toString(payement));
        }
    }//GEN-LAST:event_CAKeyReleased

    private void ITKeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_ITKeyReleased
    {//GEN-HEADEREND:event_ITKeyReleased

                double  b=Double.parseDouble(IT.getText())/100;
    double  a= b*payement;
    payement=Math.abs(payement-(int)a);
    jLabel80.setText(Integer.toString(payement));

        if(HRA.equals(null) && EA.equals(null) && CA.equals(null) && IT.equals(null) && CB.equals(null) && OT.equals(null))
        {
      
            payement=pay;
            jLabel80.setText(Integer.toString(payement));
        }
    }//GEN-LAST:event_ITKeyReleased

    private void CBKeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_CBKeyReleased
    {//GEN-HEADEREND:event_CBKeyReleased

                double  b=Double.parseDouble(CB.getText())/100;
    double  a= b*payement;
    payement=Math.abs(payement-(int)a);
    jLabel80.setText(Integer.toString(payement));

        if(HRA.equals(null) && EA.equals(null) && CA.equals(null) && IT.equals(null) && CB.equals(null) && OT.equals(null))
        {
      
            payement=pay;
            jLabel80.setText(Integer.toString(payement));
        }
    }//GEN-LAST:event_CBKeyReleased

    private void OTKeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_OTKeyReleased
    {//GEN-HEADEREND:event_OTKeyReleased

                double  b=Double.parseDouble(OT.getText())/100;
    double  a= b*payement;
    payement=Math.abs(payement-(int)a);
    jLabel80.setText(Integer.toString(payement));
        

        if(HRA.equals(null) && EA.equals(null) && CA.equals(null) && IT.equals(null) && CB.equals(null) && OT.equals(null))
        {
      
            payement=pay;
            jLabel80.setText(Integer.toString(payement));
        }
    }//GEN-LAST:event_OTKeyReleased

    private void HRAActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_HRAActionPerformed
    {//GEN-HEADEREND:event_HRAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HRAActionPerformed

    private void EAActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_EAActionPerformed
    {//GEN-HEADEREND:event_EAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EAActionPerformed

    private void CBKeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_CBKeyPressed
    {//GEN-HEADEREND:event_CBKeyPressed

    }//GEN-LAST:event_CBKeyPressed

    private void ITKeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_ITKeyPressed
    {//GEN-HEADEREND:event_ITKeyPressed

    }//GEN-LAST:event_ITKeyPressed

    private void OTKeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_OTKeyPressed
    {//GEN-HEADEREND:event_OTKeyPressed

    }//GEN-LAST:event_OTKeyPressed

    private void HRAKeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_HRAKeyPressed
    {//GEN-HEADEREND:event_HRAKeyPressed
      
    }//GEN-LAST:event_HRAKeyPressed

    private void EAKeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_EAKeyPressed
    {//GEN-HEADEREND:event_EAKeyPressed

    }//GEN-LAST:event_EAKeyPressed

    private void CAKeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_CAKeyPressed
    {//GEN-HEADEREND:event_CAKeyPressed

    }//GEN-LAST:event_CAKeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton2ActionPerformed
    {//GEN-HEADEREND:event_jButton2ActionPerformed
    HRA.setText(null);
    EA.setText(null);
    CA.setText(null);
    IT.setText(null);
    CB.setText(null);
    OT.setText(null);
    jLabel78.setText(null);
    jLabel80.setText(null);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_formMouseClicked
    {//GEN-HEADEREND:event_formMouseClicked
       
    }//GEN-LAST:event_formMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton3ActionPerformed
    {//GEN-HEADEREND:event_jButton3ActionPerformed
        int i;
        org.joda.time.format.DateTimeFormatter fmt = DateTimeFormat.forPattern("YYYY-MM-dd");
        DateTime ds = fmt.parseDateTime(jTextField39.getText());
        DateTime de = fmt.parseDateTime(jTextField40.getText());

        try
        {
         i=JOptionPane.showConfirmDialog(null, "Confirm The Leave Approval");
         if(i==JOptionPane.YES_OPTION)
         {
        modal.up_app("Accepted", jTextField38.getText());
        modal.up_lv_att(jTextField38.getText(), ds, de,"CSE");
        leaveInfo();
         }
        else if(i==JOptionPane.NO_OPTION)
        {    
        modal.up_app("Rejected", jTextField38.getText());
        leaveInfo();
        }
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    
    }//GEN-LAST:event_jButton3ActionPerformed

    private void lv_menuMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_lv_menuMouseClicked
    {//GEN-HEADEREND:event_lv_menuMouseClicked
        first.setVisible(false);
        addemp.setVisible(false);
        updateemp.setVisible(false);
        removeemp.setVisible(false);
        adddep.setVisible(false);
        updatedep.setVisible(false);
        deletedep.setVisible(false);
        attendence.setVisible(false);
        leave.setVisible(true);
        payroll.setVisible(false);
        adduser_pan.setVisible(false);
         about.setVisible(false);
        
        first_sidepan.setVisible(false);
        emp_sidepan.setVisible(false);
        dep_sidepan.setVisible(false);
        des_sidepan.setVisible(false);
        //att_sidepan.setVisible(false);
        lve_sidepan.setVisible(true);
    }//GEN-LAST:event_lv_menuMouseClicked

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton16ActionPerformed
    {//GEN-HEADEREND:event_jButton16ActionPerformed
    try
    {
        modal.ins_user(jTextField8.getText(), jPasswordField1.getText(), role.getSelectedItem().toString());       
    }
    catch (Exception ex)
    {
        Logger.getLogger(mainpage.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jTextField8ActionPerformed
    {//GEN-HEADEREND:event_jTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void des_menuMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_des_menuMouseClicked
    {//GEN-HEADEREND:event_des_menuMouseClicked
        first.setVisible(false);
        addemp.setVisible(false);
        updateemp.setVisible(false);
        removeemp.setVisible(false);
        adddep.setVisible(false);
        updatedep.setVisible(false);
        deletedep.setVisible(false);
        attendence.setVisible(false);
        leave.setVisible(false);
        payroll.setVisible(false);
        adduser_pan.setVisible(false);
        about.setVisible(false);
   
        first_sidepan.setVisible(false);
        emp_sidepan.setVisible(false);
        dep_sidepan.setVisible(false);
        des_sidepan.setVisible(true);
      //  att_sidepan.setVisible(false);
        lve_sidepan.setVisible(false);
    }//GEN-LAST:event_des_menuMouseClicked

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jMenuItem4ActionPerformed
    {//GEN-HEADEREND:event_jMenuItem4ActionPerformed
        setVisible(false);
        new login("blue").setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jMenuItem1ActionPerformed
    {//GEN-HEADEREND:event_jMenuItem1ActionPerformed
        setVisible(false);
        new login(null).setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jMenuItem2ActionPerformed
    {//GEN-HEADEREND:event_jMenuItem2ActionPerformed
        setVisible(false);
        new login("silver").setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jMenuItem3ActionPerformed
    {//GEN-HEADEREND:event_jMenuItem3ActionPerformed
        setVisible(false);
        new login("green").setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void appMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_appMouseClicked
    {//GEN-HEADEREND:event_appMouseClicked
        
        String id=null;
        String sd=null;
        DefaultTableModel model = (DefaultTableModel)app.getModel();
        int i= app.getSelectedRow();
        id= model.getValueAt(i,0).toString();
        sd= model.getValueAt(i,1).toString();
        leaveInfo_at(id,sd);
    }//GEN-LAST:event_appMouseClicked

    private void user_addActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_user_addActionPerformed
    {//GEN-HEADEREND:event_user_addActionPerformed
adduser_pan.setVisible(true);
upuser_pan.setVisible(false);
deluser_pan.setVisible(false);
    }//GEN-LAST:event_user_addActionPerformed

    private void user_upActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_user_upActionPerformed
    {//GEN-HEADEREND:event_user_upActionPerformed
adduser_pan.setVisible(false);
upuser_pan.setVisible(true);
deluser_pan.setVisible(false);        
    }//GEN-LAST:event_user_upActionPerformed

    private void user_remActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_user_remActionPerformed
    {//GEN-HEADEREND:event_user_remActionPerformed
adduser_pan.setVisible(false);
upuser_pan.setVisible(false);
deluser_pan.setVisible(true); 
    }//GEN-LAST:event_user_remActionPerformed

    private void us_listMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_us_listMouseClicked
    {//GEN-HEADEREND:event_us_listMouseClicked
       int i= us_list.getSelectedRow();
       DefaultTableModel model = (DefaultTableModel)us_list.getModel();
       id= model.getValueAt(i,0).toString();
       usinfo_at(id);
    }//GEN-LAST:event_us_listMouseClicked

    private void roleActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_roleActionPerformed
    {//GEN-HEADEREND:event_roleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_roleActionPerformed

    private void jTextField9ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jTextField9ActionPerformed
    {//GEN-HEADEREND:event_jTextField9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton17ActionPerformed
    {//GEN-HEADEREND:event_jButton17ActionPerformed
    try
    {
        modal.up_user(jLabel90.getText(), jTextField9.getText());
    }
    catch (SQLException ex)
    {
        Logger.getLogger(mainpage.class.getName()).log(Level.SEVERE, null, ex);
    }
    userInfo();
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton4ActionPerformed
    {//GEN-HEADEREND:event_jButton4ActionPerformed

    try
    {
        modal.del_user(jLabel94.getText());
    }
    catch (SQLException ex)
    {
        Logger.getLogger(mainpage.class.getName()).log(Level.SEVERE, null, ex);
    }
    userInfo();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton18ActionPerformed
    {//GEN-HEADEREND:event_jButton18ActionPerformed
    try
    {
        modal.ins_des(jTextField1.getText(), jTextField2.getText(), jTextField3.getText());       
    }
    catch (Exception ex)
    {
        Logger.getLogger(mainpage.class.getName()).log(Level.SEVERE, null, ex);
    }
    desInfo();
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton22ActionPerformed
    {//GEN-HEADEREND:event_jButton22ActionPerformed
    try
    {
        modal.up_des(jTextField5.getText(), jLabel111.getText());
         JOptionPane.showMessageDialog(null, jTextField5.getText());
    }
    catch (Exception ex)
    {
        JOptionPane.showMessageDialog(null, ex);
    }
    desInfo();
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton23ActionPerformed
    {//GEN-HEADEREND:event_jButton23ActionPerformed

    try
    {
        modal.delete_des(jLabel111.getText());
    }
    catch (SQLException ex)
    {
        Logger.getLogger(mainpage.class.getName()).log(Level.SEVERE, null, ex);
    }
    desInfo();
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jTextField3ActionPerformed
    {//GEN-HEADEREND:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void des_listMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_des_listMouseClicked
    {//GEN-HEADEREND:event_des_listMouseClicked
        int i= des_list.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel)des_list.getModel();
        id= model.getValueAt(i,0).toString();
        desinfo_at(id);
    }//GEN-LAST:event_des_listMouseClicked

    private void up_depActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_up_depActionPerformed
 try
    {
        modal.up_dep(jLabel112.getText(), jTextField34.getText(),jTextField35.getText());
    }
    catch (SQLException ex)
    {
        Logger.getLogger(mainpage.class.getName()).log(Level.SEVERE, null, ex);
    }
    depInfo();
                                           
       
        
        
    }//GEN-LAST:event_up_depActionPerformed

    private void dep_listMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dep_listMouseClicked
       int i= dep_list.getSelectedRow();
       DefaultTableModel model = (DefaultTableModel)dep_list.getModel();
       id= model.getValueAt(i,0).toString();
       depinfo_at(id);
    }//GEN-LAST:event_dep_listMouseClicked

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
    try {
        modal.delete_dep(jLabel121.getText());
    } catch (SQLException ex) {
        Logger.getLogger(mainpage.class.getName()).log(Level.SEVERE, null, ex);
    }
    depInfo();
    }//GEN-LAST:event_jButton19ActionPerformed

    private void HRAPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_HRAPropertyChange

    }//GEN-LAST:event_HRAPropertyChange

    private void EAPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_EAPropertyChange

    }//GEN-LAST:event_EAPropertyChange

    private void CAPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_CAPropertyChange

    }//GEN-LAST:event_CAPropertyChange

    private void ITPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_ITPropertyChange

    }//GEN-LAST:event_ITPropertyChange

    private void CBPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_CBPropertyChange

    }//GEN-LAST:event_CBPropertyChange

    private void OTPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_OTPropertyChange
      
    }//GEN-LAST:event_OTPropertyChange

    private void OTKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_OTKeyTyped

    }//GEN-LAST:event_OTKeyTyped

    private void CBKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CBKeyTyped

    }//GEN-LAST:event_CBKeyTyped

    private void ITKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ITKeyTyped

    }//GEN-LAST:event_ITKeyTyped

    private void CAKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CAKeyTyped

    }//GEN-LAST:event_CAKeyTyped

    private void EAKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_EAKeyTyped

    }//GEN-LAST:event_EAKeyTyped

    private void HRAKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_HRAKeyTyped

    }//GEN-LAST:event_HRAKeyTyped

    private void about_menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_about_menuActionPerformed
       
        


    }//GEN-LAST:event_about_menuActionPerformed

    private void about_menuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_about_menuMouseClicked
        first.setVisible(false);
        addemp.setVisible(false);
        updateemp.setVisible(false);
        removeemp.setVisible(false);
        adddep.setVisible(false);
        updatedep.setVisible(false);
        deletedep.setVisible(false);
        attendence.setVisible(false);
        leave.setVisible(false);
        payroll.setVisible(false);
        adduser_pan.setVisible(false);
        about.setVisible(true);
        
        first_sidepan.setVisible(true);
        emp_sidepan.setVisible(false);
        dep_sidepan.setVisible(false);
        des_sidepan.setVisible(false);
       // att_sidepan.setVisible(true);
        lve_sidepan.setVisible(false); // TODO add your handling code here:
    }//GEN-LAST:event_about_menuMouseClicked

    private void logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseClicked
     
        
        setVisible(false);
        new login(null).setVisible(true);
       

            // TODO add your handling code here:
    }//GEN-LAST:event_logoutMouseClicked


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
                if ("windows".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }
        catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() ->
        {
            new mainpage().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CA;
    private javax.swing.JTextField CB;
    private javax.swing.JLabel Departmentads;
    private javax.swing.JTextField EA;
    private javax.swing.JTextField HRA;
    private javax.swing.JTextField IT;
    private javax.swing.JTextField OT;
    private javax.swing.JPanel about;
    private javax.swing.JMenu about_menu;
    private javax.swing.JPanel adddep;
    private javax.swing.JPanel adddes_pan;
    private javax.swing.JTabbedPane addemp;
    private javax.swing.JPanel adduser_pan;
    private javax.swing.JTable app;
    private com.toedter.calendar.JDateChooser att_date;
    private javax.swing.JTextField att_id;
    private javax.swing.JMenu att_menu;
    private com.toedter.calendar.JMonthChooser att_mnth;
    private javax.swing.JTable att_tbl;
    private com.toedter.calendar.JYearChooser att_yr;
    private javax.swing.JPanel attendence;
    private javax.swing.JLabel calendar;
    private javax.swing.JLabel clock;
    private javax.swing.JPanel con_det;
    private javax.swing.JPanel con_det1;
    private javax.swing.JPanel deletedep;
    private javax.swing.JPanel deluser_pan;
    private javax.swing.JButton dep_add;
    private javax.swing.JButton dep_del;
    private javax.swing.JTable dep_list;
    private javax.swing.JMenu dep_menu;
    private javax.swing.JPanel dep_sidepan;
    private javax.swing.JButton dep_up;
    private javax.swing.JPanel dept_inf;
    private javax.swing.JPanel dept_inf1;
    private javax.swing.JButton des_add;
    private javax.swing.JButton des_del;
    private javax.swing.JTable des_list;
    private javax.swing.JMenu des_menu;
    private javax.swing.JPanel des_sidepan;
    private javax.swing.JButton des_up;
    private javax.swing.JButton emp_add;
    private javax.swing.JTable emp_list;
    private javax.swing.JMenu emp_menu;
    private javax.swing.JButton emp_rem;
    private javax.swing.JButton emp_save;
    private javax.swing.JPanel emp_sidepan;
    private javax.swing.JButton emp_up;
    private javax.swing.JRadioButton female;
    private javax.swing.JPanel first;
    private javax.swing.JPanel first_sidepan;
    private javax.swing.JLabel image;
    private javax.swing.JLabel imagename;
    private javax.swing.JLabel imagename1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel130;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JTextArea jTextArea5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField23;
    private javax.swing.JTextField jTextField29;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField30;
    private javax.swing.JTextField jTextField34;
    private javax.swing.JTextField jTextField35;
    private javax.swing.JTextField jTextField38;
    private javax.swing.JTextField jTextField39;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField40;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JLayeredPane layer;
    private javax.swing.JPanel leave;
    private javax.swing.JMenu logout;
    private javax.swing.JMenu lv_menu;
    private javax.swing.JPanel lve_sidepan;
    private javax.swing.JRadioButton male;
    private javax.swing.JMenu op_menu;
    private javax.swing.JMenu pay_menu;
    private javax.swing.JTextField payr_id;
    private com.toedter.calendar.JMonthChooser payr_mnth;
    private com.toedter.calendar.JYearChooser payr_yr;
    private javax.swing.JPanel payroll;
    private javax.swing.JPanel pers_inf;
    private javax.swing.JPanel pers_inf1;
    private javax.swing.JPanel remdes_pan;
    private javax.swing.JPanel removeemp;
    private javax.swing.JComboBox<String> role;
    private javax.swing.JButton save_dep;
    private javax.swing.JPanel side_pan;
    private javax.swing.JComboBox<String> srchby;
    private javax.swing.JPanel srchbyid;
    private javax.swing.JPanel srchbyyr;
    private javax.swing.JTextField txt_bnk;
    private javax.swing.JTextField txt_con;
    private javax.swing.JTextField txt_dn;
    private com.toedter.calendar.JDateChooser txt_dob;
    private javax.swing.JTextField txt_ds;
    private javax.swing.JTextField txt_em;
    private javax.swing.JTextField txt_fn;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_ln;
    private javax.swing.JTextField txt_nid;
    private javax.swing.JTextArea txt_pradd;
    private javax.swing.JTextArea txt_ptadd;
    private javax.swing.JComboBox<String> txt_role;
    private javax.swing.JButton up_dep;
    private javax.swing.JPanel updatedep;
    private javax.swing.JTabbedPane updateemp;
    private javax.swing.JPanel updes_pan;
    private javax.swing.JPanel upuser_pan;
    private javax.swing.JTable us_list;
    private javax.swing.JMenu us_menu;
    private javax.swing.JPanel us_sidepan;
    private javax.swing.JButton user_add;
    private javax.swing.JButton user_rem;
    private javax.swing.JButton user_up;
    // End of variables declaration//GEN-END:variables
}
