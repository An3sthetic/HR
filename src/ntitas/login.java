
package ntitas;



import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;


public class login extends javax.swing.JFrame
{
 public login(String a)
    {
        try
        {
            if(a==null)
            {
             UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    
            }
            else if(a.equals("silver"))
            {
            try {
    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
            UIManager.setLookAndFeel(info.getClassName());
            break;
        }
    }
} catch (Exception e) {
    // If Nimbus is not available, you can set the GUI to another look and feel.
}
            }
//              UIManager.setLookAndFeel();
//            else if(a=="silver")
//              UIManager.setLookAndFeel(new SyntheticaSilverMoonLookAndFeel());
//            else if(a=="green")
//               UIManager.setLookAndFeel(new SyntheticaBlackStarLookAndFeel());
//            else if(a=="blue")
//                 UIManager.setLookAndFeel(new SyntheticaBlueIceLookAndFeel());
        }
        catch (Exception ex)
        {
           JOptionPane.showMessageDialog(null, ex);
        }
        initComponents();
        setBackground(new Color(1.0f,1.0f,1.0f,0.f));
        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        user = new javax.swing.JTextField();
        pass = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(0, 0));
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(600, 450));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(800, 430));
        getContentPane().setLayout(null);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/close_icon_norm.png"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setDoubleBuffered(true);
        jButton2.setFocusPainted(false);
        jButton2.setMinimumSize(new java.awt.Dimension(30, 30));
        jButton2.setPreferredSize(new java.awt.Dimension(30, 30));
        jButton2.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/close_icon_pre.png"))); // NOI18N
        jButton2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/close_icon_hov.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(730, 10, 40, 40);

        jLabel2.setBackground(new java.awt.Color(47, 52, 56));
        getContentPane().add(jLabel2);
        jLabel2.setBounds(50, 30, 700, 380);

        jPanel1.setBackground(new java.awt.Color(47, 52, 56));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 255, 255)));
        jPanel1.setDoubleBuffered(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(640, 425));
        jPanel1.setLayout(null);

        jSeparator2.setForeground(new java.awt.Color(51, 255, 255));
        jPanel1.add(jSeparator2);
        jSeparator2.setBounds(140, 170, 290, 20);

        jSeparator1.setForeground(new java.awt.Color(51, 255, 255));
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(140, 240, 290, 20);

        jPanel2.setBackground(new java.awt.Color(47, 52, 56));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 255, 255)));
        jPanel2.setLayout(new java.awt.CardLayout());

        jButton1.setBackground(new java.awt.Color(47, 52, 56));
        jButton1.setFont(new java.awt.Font("Segoe UI Semibold", 2, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(204, 204, 204));
        jButton1.setText("Login");
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setRequestFocusEnabled(false);
        jButton1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jButton1MouseMoved(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, "card2");

        jPanel1.add(jPanel2);
        jPanel2.setBounds(390, 280, 200, 40);

        user.setBackground(new java.awt.Color(47, 52, 56));
        user.setFont(new java.awt.Font("Segoe UI Semibold", 2, 18)); // NOI18N
        user.setForeground(new java.awt.Color(204, 204, 204));
        user.setText("UserName");
        user.setToolTipText("UserName");
        user.setBorder(null);
        user.setName("UserName"); // NOI18N
        user.setOpaque(false);
        user.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userMouseClicked(evt);
            }
        });
        user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userActionPerformed(evt);
            }
        });
        user.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                userPropertyChange(evt);
            }
        });
        jPanel1.add(user);
        user.setBounds(160, 130, 390, 40);

        pass.setBackground(new java.awt.Color(47, 52, 56));
        pass.setFont(new java.awt.Font("Segoe UI Semibold", 2, 18)); // NOI18N
        pass.setForeground(new java.awt.Color(204, 204, 204));
        pass.setText("Password");
        pass.setToolTipText("Password");
        pass.setBorder(null);
        pass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                passMouseClicked(evt);
            }
        });
        pass.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                passPropertyChange(evt);
            }
        });
        jPanel1.add(pass);
        pass.setBounds(160, 200, 350, 40);

        jLabel1.setFont(new java.awt.Font("Segoe UI Symbol", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Ntitas Limited");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(120, 50, 400, 50);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(50, 30, 700, 380);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton1ActionPerformed
    {//GEN-HEADEREND:event_jButton1ActionPerformed
                try
        {
            String s=modal.loginverify(user.getText(), pass.getText());
            if(s=="admin")
            {
               setVisible(false);
               new mainpage().setVisible(true);                
            }
            else if(s=="employee")
            {
                setVisible(false);
                new user(user.getText()).setVisible(true);
            }
            else
                JOptionPane.showMessageDialog(null, "Invalid username or password");
        }
        catch (Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1MouseMoved(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jButton1MouseMoved
    {//GEN-HEADEREND:event_jButton1MouseMoved
    jPanel2.setSize(192, 41);
    }//GEN-LAST:event_jButton1MouseMoved

    private void userMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_userMouseClicked
    {//GEN-HEADEREND:event_userMouseClicked
        user.setText(null);
    }//GEN-LAST:event_userMouseClicked

    private void passMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_passMouseClicked
    {//GEN-HEADEREND:event_passMouseClicked
pass.setText(null);
    }//GEN-LAST:event_passMouseClicked

    private void userPropertyChange(java.beans.PropertyChangeEvent evt)//GEN-FIRST:event_userPropertyChange
    {//GEN-HEADEREND:event_userPropertyChange

        if(user.getText()==null)
        {
           user.setText("Username");
        }   
    }//GEN-LAST:event_userPropertyChange

    private void passPropertyChange(java.beans.PropertyChangeEvent evt)//GEN-FIRST:event_passPropertyChange
    {//GEN-HEADEREND:event_passPropertyChange
          if(pass.getText()==null)
        {
           pass.setText("Password");
        }   
    }//GEN-LAST:event_passPropertyChange

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton2ActionPerformed
    {//GEN-HEADEREND:event_jButton2ActionPerformed
System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void userActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_userActionPerformed
    {//GEN-HEADEREND:event_userActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userActionPerformed


    public static void main(String args[])
    {
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new login(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPasswordField pass;
    private javax.swing.JTextField user;
    // End of variables declaration//GEN-END:variables
}
