
package ntitas;

import java.awt.Graphics;
import java.awt.PrintJob;
import java.awt.Toolkit;


public class Reciept_print extends javax.swing.JFrame
{

 
    public Reciept_print(String id,String name,String basic,String Ha,String Ea,String Ca,String It,String Cb,String o,String t)
    {
        initComponents();
        jLabel2.setText(id);
        jLabel4.setText(name);
        jLabel12.setText(basic);
        jLabel13.setText(Ha);
        jLabel14.setText(Ea);
        jLabel15.setText(Ca);
        jLabel16.setText(It);
        jLabel17.setText(Cb);
        jLabel18.setText(o);
        jLabel19.setText(t);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pan = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        back = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        pan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        pan.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 790, 10));

        jLabel1.setText("ID:");
        pan.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 30, 20));
        pan.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 100, 20));

        jLabel3.setText("Name:");
        pan.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 60, -1));
        pan.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, 140, 20));
        pan.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, 780, 10));

        jLabel5.setText("Basic:");
        pan.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 60, -1));

        jLabel6.setText("Home Allowance:");
        pan.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 100, -1));

        jLabel7.setText("Education Allowance:");
        pan.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 130, -1));

        jLabel8.setText("Conveyance Allow:");
        pan.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 170, -1));

        jLabel9.setText("Income Tax:");
        pan.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 110, -1));

        jLabel10.setText("Canteen Bill:");
        pan.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 110, -1));

        jLabel11.setText("Other:");
        pan.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, 110, -1));

        jLabel12.setText("num");
        pan.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 230, 60, 20));

        jLabel13.setText("num");
        pan.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 270, 60, -1));

        jLabel14.setText("num");
        pan.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 306, 60, 20));

        jLabel15.setText("num");
        pan.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 336, 60, 20));

        jLabel16.setText("num");
        pan.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 366, 60, 20));

        jLabel17.setText("num");
        pan.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 390, 60, 20));

        jLabel18.setText("num");
        pan.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 420, 50, 20));
        pan.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 450, 70, 20));

        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/payslip.png"))); // NOI18N
        pan.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(-70, -30, 900, 690));

        getContentPane().add(pan);
        pan.setBounds(0, 0, 790, 520);

        jButton1.setText("print");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(620, 530, 55, 23);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton1ActionPerformed
    {//GEN-HEADEREND:event_jButton1ActionPerformed
    Toolkit tkp = pan.getToolkit();
    PrintJob pjp = tkp.getPrintJob(this, null, null);
    Graphics g = pjp.getGraphics();
    pan.print(g);
    g.dispose();
    pjp.end();
    setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     @param args the command line arguments
     */
    public static void main(String args[])
    {

        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
              //  new Reciept_print().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel back;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel pan;
    // End of variables declaration//GEN-END:variables
}
