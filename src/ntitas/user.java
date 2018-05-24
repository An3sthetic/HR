
package ntitas;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;



public class user extends javax.swing.JFrame
{
    String Id;
    String perm=null;
    public user(String id)
    {
        Id=id;
        initComponents();
        front.setVisible(true);
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
            
            
            }
        } 
        catch(Exception e)
        {
         JOptionPane.showMessageDialog(null, e);
        }
        finally
        {
            try
            {
                dbconnect.ConnectDB().close();
                ist.close();
                s.close();
            }
            catch (Exception ex)
            {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
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
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jToggleButton3 = new javax.swing.JToggleButton();
        jPanel1 = new javax.swing.JPanel();
        front = new javax.swing.JPanel();
        viewinfo = new javax.swing.JPanel();
        jLabel67 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        Departmentads = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        attendance = new javax.swing.JPanel();
        jToggleButton4 = new javax.swing.JToggleButton();
        jToggleButton5 = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        adminmail = new javax.swing.JPanel();
        st_date = new com.toedter.calendar.JDateChooser();
        en_date = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        msg_bdy = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        clock = new javax.swing.JLabel();
        calendar = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jToggleButton1.setText("View Info");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jToggleButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jToggleButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 110, 60));

        jToggleButton2.setText("Attendance");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jToggleButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jToggleButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 110, 60));

        jToggleButton3.setText("Mail to Admin");
        jToggleButton3.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jToggleButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jToggleButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 110, 60));

        jPanel1.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout frontLayout = new javax.swing.GroupLayout(front);
        front.setLayout(frontLayout);
        frontLayout.setHorizontalGroup(
            frontLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 497, Short.MAX_VALUE)
        );
        frontLayout.setVerticalGroup(
            frontLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 315, Short.MAX_VALUE)
        );

        jPanel1.add(front, "card2");

        viewinfo.setLayout(null);

        jLabel67.setText("Name:");
        viewinfo.add(jLabel67);
        jLabel67.setBounds(30, 10, 40, 20);
        viewinfo.add(jLabel71);
        jLabel71.setBounds(100, 10, 180, 20);

        jLabel66.setText("Gender:");
        viewinfo.add(jLabel66);
        jLabel66.setBounds(30, 40, 50, 20);
        viewinfo.add(jLabel72);
        jLabel72.setBounds(100, 40, 150, 20);

        jLabel65.setText("Birthday:");
        viewinfo.add(jLabel65);
        jLabel65.setBounds(30, 70, 50, 20);
        viewinfo.add(jLabel73);
        jLabel73.setBounds(100, 70, 170, 20);

        jLabel70.setText("NID:");
        viewinfo.add(jLabel70);
        jLabel70.setBounds(30, 100, 30, 20);
        viewinfo.add(jLabel49);
        jLabel49.setBounds(70, 100, 150, 20);

        Departmentads.setText("Department:");
        viewinfo.add(Departmentads);
        Departmentads.setBounds(30, 130, 70, 20);
        viewinfo.add(jLabel64);
        jLabel64.setBounds(110, 130, 130, 20);

        jLabel68.setText("Designation:");
        viewinfo.add(jLabel68);
        jLabel68.setBounds(30, 160, 70, 20);
        viewinfo.add(jLabel19);
        jLabel19.setBounds(110, 160, 130, 20);

        jLabel50.setText("Contact NO.:");
        viewinfo.add(jLabel50);
        jLabel50.setBounds(30, 190, 70, 20);
        viewinfo.add(jLabel74);
        jLabel74.setBounds(130, 190, 90, 20);

        jLabel63.setText("Email:");
        viewinfo.add(jLabel63);
        jLabel63.setBounds(30, 220, 40, 20);
        viewinfo.add(jLabel75);
        jLabel75.setBounds(100, 220, 150, 20);

        jLabel18.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        viewinfo.add(jLabel18);
        jLabel18.setBounds(270, 10, 220, 260);

        jPanel1.add(viewinfo, "card3");

        jToggleButton4.setText("In Time");
        jToggleButton4.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jToggleButton4ActionPerformed(evt);
            }
        });

        jToggleButton5.setText("Out Time");
        jToggleButton5.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jToggleButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout attendanceLayout = new javax.swing.GroupLayout(attendance);
        attendance.setLayout(attendanceLayout);
        attendanceLayout.setHorizontalGroup(
            attendanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(attendanceLayout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addGroup(attendanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jToggleButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jToggleButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addGroup(attendanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE))
                .addContainerGap(114, Short.MAX_VALUE))
        );
        attendanceLayout.setVerticalGroup(
            attendanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(attendanceLayout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addGroup(attendanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jToggleButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(attendanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jToggleButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(151, Short.MAX_VALUE))
        );

        jPanel1.add(attendance, "card4");

        adminmail.setBorder(new javax.swing.border.MatteBorder(null));
        adminmail.setLayout(null);

        st_date.setDateFormatString("yyyy-MM-dd");
        st_date.addPropertyChangeListener(new java.beans.PropertyChangeListener()
        {
            public void propertyChange(java.beans.PropertyChangeEvent evt)
            {
                st_datePropertyChange(evt);
            }
        });
        adminmail.add(st_date);
        st_date.setBounds(60, 30, 152, 29);

        en_date.setDateFormatString("yyyy-MM-dd");
        en_date.addPropertyChangeListener(new java.beans.PropertyChangeListener()
        {
            public void propertyChange(java.beans.PropertyChangeEvent evt)
            {
                en_datePropertyChange(evt);
            }
        });
        adminmail.add(en_date);
        en_date.setBounds(324, 30, 120, 29);

        msg_bdy.setColumns(20);
        msg_bdy.setRows(5);
        msg_bdy.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                msg_bdyMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(msg_bdy);

        adminmail.add(jScrollPane1);
        jScrollPane1.setBounds(60, 88, 242, 165);

        jButton1.setText("Submit");
        jButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton1ActionPerformed(evt);
            }
        });
        adminmail.add(jButton1);
        jButton1.setBounds(374, 221, 120, 32);
        adminmail.add(jLabel3);
        jLabel3.setBounds(330, 130, 160, 60);

        jPanel1.add(adminmail, "card5");

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 124, -1, -1));

        jPanel6.setBorder(new javax.swing.border.MatteBorder(null));

        clock.setFont(new java.awt.Font("DS-Digital", 3, 18)); // NOI18N
        clock.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        clock.setText("TIME");

        calendar.setFont(new java.awt.Font("DS-Digital", 3, 18)); // NOI18N
        calendar.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        calendar.setText("DATE");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(115, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(clock, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                    .addComponent(calendar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(14, 14, 14))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(calendar, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(clock, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(346, 17, -1, -1));

        jButton2.setText("Log Out");
        jButton2.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 110, 60));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jToggleButton2ActionPerformed
    {//GEN-HEADEREND:event_jToggleButton2ActionPerformed
        front.setVisible(false);
        attendance.setVisible(true);
        viewinfo.setVisible(false);
        adminmail.setVisible(false);
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jToggleButton1ActionPerformed
    {//GEN-HEADEREND:event_jToggleButton1ActionPerformed
        front.setVisible(false);
        attendance.setVisible(false);
        viewinfo.setVisible(true);
        adminmail.setVisible(false);
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jToggleButton3ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jToggleButton3ActionPerformed
    {//GEN-HEADEREND:event_jToggleButton3ActionPerformed
        front.setVisible(false);
        attendance.setVisible(false);
        viewinfo.setVisible(false);
        adminmail.setVisible(true);
    }//GEN-LAST:event_jToggleButton3ActionPerformed

    private void jToggleButton4ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jToggleButton4ActionPerformed
    {//GEN-HEADEREND:event_jToggleButton4ActionPerformed
    try
    {
        boolean b =modal.intime(Id);
        if(b==true){
            JOptionPane.showMessageDialog(null, "Attendance Added");
              
    }
        else
            JOptionPane.showMessageDialog(null, "Failed");
        
    }
    catch (SQLException ex)
    {
        JOptionPane.showMessageDialog(null, ex);
    }
    }//GEN-LAST:event_jToggleButton4ActionPerformed

    private void jToggleButton5ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jToggleButton5ActionPerformed
    {//GEN-HEADEREND:event_jToggleButton5ActionPerformed
       try
    {
        boolean b =modal.outtime(Id);
        if(b==true){
            JOptionPane.showMessageDialog(null, "Record Added");
              
    }
        else
            JOptionPane.showMessageDialog(null, "Failed");
        
    }
    catch (SQLException ex)
    {
        JOptionPane.showMessageDialog(null, ex);
    }
    }//GEN-LAST:event_jToggleButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton1ActionPerformed
    {//GEN-HEADEREND:event_jButton1ActionPerformed
        if(perm=="permitted")
        {
        try
        {
            boolean b=modal.ins_app(Id, ((JTextField)st_date.getDateEditor().getUiComponent()).getText(), ((JTextField)en_date.getDateEditor().getUiComponent()).getText(),msg_bdy.getText());
            perm=null;
        }
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }
        }
        else
        {
        JOptionPane.showMessageDialog(null, "You have already taken leave this month");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void msg_bdyMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_msg_bdyMouseClicked
    {//GEN-HEADEREND:event_msg_bdyMouseClicked

    }//GEN-LAST:event_msg_bdyMouseClicked

    private void st_datePropertyChange(java.beans.PropertyChangeEvent evt)//GEN-FIRST:event_st_datePropertyChange
    {//GEN-HEADEREND:event_st_datePropertyChange
               try
        {
            PreparedStatement ps=dbconnect.ConnectDB().prepareStatement("select datediff(?,?)");
            ps.setString(1, ((JTextField)en_date.getDateEditor().getUiComponent()).getText());
            ps.setString(2, ((JTextField)st_date.getDateEditor().getUiComponent()).getText());
            
            ResultSet rs=ps.executeQuery();
            
            while(rs.next())
            if(rs.getInt(1)>5)
            {
                jLabel3.setText("Limit exedeed");
                perm=null;
            }
            else if(rs.getInt(1)<5 && rs.getInt(1)>0)
            {
                jLabel3.setText("Asking for \n"+rs.getString(1)+" days leave");
                perm="permitted";
            }
            else
            {
            jLabel3.setText(null);
            }
        }
        catch (SQLException ex)
        {
            Logger.getLogger(user.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_st_datePropertyChange

    private void en_datePropertyChange(java.beans.PropertyChangeEvent evt)//GEN-FIRST:event_en_datePropertyChange
    {//GEN-HEADEREND:event_en_datePropertyChange
        try
        {
            
            
            ResultSet rs=modal.get_datediff(((JTextField)en_date.getDateEditor().getUiComponent()).getText(),((JTextField)st_date.getDateEditor().getUiComponent()).getText());
            
            while(rs.next())
            {
            if(rs.getInt(1)>5)
            {
                jLabel3.setText("Limit exedeed");
                perm=null;
            }
            else if(rs.getInt(1)<5 && rs.getInt(1)>0)
            {
                jLabel3.setText("Asking for \n"+rs.getString(1)+" days leave");
                perm="permitted";
            }
            else
            {
            jLabel3.setText(null);
            perm=null;
            }
            }
        }
        catch (SQLException ex)
        {
            Logger.getLogger(user.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_en_datePropertyChange

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       setVisible(false);
        new login(null).setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed


    public static void main(String args[])
    {

        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                //new user().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Departmentads;
    private javax.swing.JPanel adminmail;
    private javax.swing.JPanel attendance;
    private javax.swing.JLabel calendar;
    private javax.swing.JLabel clock;
    private com.toedter.calendar.JDateChooser en_date;
    private javax.swing.JPanel front;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JToggleButton jToggleButton4;
    private javax.swing.JToggleButton jToggleButton5;
    private javax.swing.JTextArea msg_bdy;
    private com.toedter.calendar.JDateChooser st_date;
    private javax.swing.JPanel viewinfo;
    // End of variables declaration//GEN-END:variables
}
