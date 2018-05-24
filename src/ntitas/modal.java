
package ntitas;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Date;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import org.joda.time.*;


public class modal
{

   
   static String loginverify(String a,String b) throws SQLException
   {
       String c=null;
       PreparedStatement ps=dbconnect.ConnectDB().prepareStatement(query.login());
       PreparedStatement pst=dbconnect.ConnectDB().prepareStatement(query.login());
       ps.setString(1, a);
       ps.setString(2, b);
       ps.setString(3, "admin");
       pst.setString(1, a);
       pst.setString(2, b);
       pst.setString(3, "employee");
       
       ResultSet rsa=ps.executeQuery();
       ResultSet rse=pst.executeQuery();
       if(rsa.next())
       c="admin";
       if(rse.next())
       c="employee";
   return c;
   }
   
      static boolean insert_emp(int a,String b,String c,String d,String e,int f,File g,int h,String i,String j,String k,String l,String m,String n,int o,FileInputStream r) throws SQLException
   {
       boolean bool=false;
       PreparedStatement ps=dbconnect.ConnectDB().prepareStatement(query.insert_emp());
       ps.setInt(1, a);
       ps.setString(2, b);
       ps.setString(3, c);
       ps.setString(4, d);
       ps.setString(5, e);
       ps.setInt(6, f);
       ps.setBinaryStream(7, r,(int)g.length());
       ps.setInt(8, h);
       ps.setString(9, i);
       ps.setString(10, j);
       ps.setString(11, k);
       ps.setString(12, l);
       ps.setString(13, m);
       ps.setString(14, n);
       ps.setInt(15, o);

       
       int rs=ps.executeUpdate();

       if(rs>0)
       bool=true;

   return bool;
   }
      static boolean up_emp(String a,String b,String c,String d,String e,String f,String g,String h,String i,String j,String k,String l,String m) throws SQLException
   {
       boolean bool=false;
       PreparedStatement ps=dbconnect.ConnectDB().prepareStatement(query.up_emp());
       ps.setString(1, a);
       ps.setString(2, b);
       ps.setString(3, c);
       ps.setString(4, d);
       ps.setString(5, e);
       ps.setString(6, f);       
       ps.setString(7, g);
       ps.setString(8, h);
       ps.setString(9, i);
       ps.setString(10, j);
       ps.setString(11, k);
       ps.setString(12, l);
       ps.setString(13, m);
       

       
       int rs=ps.executeUpdate();

       if(rs>0)
       bool=true;

   return bool;
   }
   static boolean delete_emp(String a) throws SQLException
   {
       boolean c=false;
       PreparedStatement ps=dbconnect.ConnectDB().prepareStatement(query.delete_emp());
       ps.setString(1, a);
      
       int rs=ps.executeUpdate();
       if(rs>0)
       c=true;
       
   return c;
   }
   static boolean intime(String getID) throws SQLException
   {
       
       boolean c=false;
       PreparedStatement chk=dbconnect.ConnectDB().prepareStatement(query.time_check());
       chk.setString(1, getID);
       ResultSet rst = chk.executeQuery();
       if(rst.next())
       {
       c=false;
       }
       else
       {
       PreparedStatement ps=dbconnect.ConnectDB().prepareStatement(query.intime());
       ps.setString(1, getID);
      
       int rs=ps.executeUpdate();
       if(rs>0)
       c=true;
       }
   return c;
   }
   static boolean outtime(String getID) throws SQLException
   {
       boolean c=false;
       String check="in";
       PreparedStatement chk=dbconnect.ConnectDB().prepareStatement(query.time_check());
       chk.setString(1, getID);
       ResultSet rst = chk.executeQuery();
       while(rst.next())
       {
       check=rst.getString("outtime");
       }
       System.out.println(check);
       if(check==null)
       {
       PreparedStatement ps=dbconnect.ConnectDB().prepareStatement(query.outtime());
       ps.setString(1, getID);
      
       int rs=ps.executeUpdate();
       if(rs>0)
       c=true;
       }

   return c;
   }
   
   static ResultSet att_by_id(String a,String b) throws SQLException
   {
       
       PreparedStatement ps=dbconnect.ConnectDB().prepareStatement(query.att_by_id());
       ps.setString(1, a);
       ps.setString(2, b);
      
       ResultSet rs=ps.executeQuery();
       
   return rs;
   }
   
      static ResultSet att_by_dt(int a,int b) throws SQLException
   {
        a++;
       PreparedStatement ps=dbconnect.ConnectDB().prepareStatement(query.att_by_dt());
       ps.setInt(1, a);
       ps.setInt(2, b);
      
       ResultSet rs=ps.executeQuery();
       
       
   return rs;
   }
       static ResultSet chk_pay(int a,int b,int c) throws SQLException
   {
        a++;
       PreparedStatement ps=dbconnect.ConnectDB().prepareStatement(query.chk_pay());
       ps.setInt(1, a);
       ps.setInt(2, b);
       ps.setInt(3, c);
      
       ResultSet rs=ps.executeQuery();
       
       
   return rs;
   }
    static ResultSet get_pay(int a) throws SQLException
   {
       PreparedStatement ps=dbconnect.ConnectDB().prepareStatement(query.get_pay());
       ps.setInt(1, a);
      
       ResultSet rs=ps.executeQuery();
       
       
   return rs;
   }
        static ResultSet get_att(int a,int b,int c) throws SQLException
   {
        b++;
       PreparedStatement ps=dbconnect.ConnectDB().prepareStatement(query.get_att());
       ps.setInt(1, a);
       ps.setInt(2, b);
       ps.setInt(3, c);
      
       ResultSet rs=ps.executeQuery();
       
       
   return rs;
   }
    static boolean ins_app(String a,String b,String c,String d) throws SQLException
   {
       boolean bool=false;
       PreparedStatement p =dbconnect.ConnectDB().prepareStatement(query.chk_app());
       p.setString(1,a);
       
       ResultSet rs = p.executeQuery();
       if(rs.next())
       {
       }
       else
       {
       
       PreparedStatement ps=dbconnect.ConnectDB().prepareStatement(query.ins_app());
       ps.setString(1, a);
       ps.setString(2, b);
       ps.setString(3, c);
       ps.setString(4, d);
       ps.setString(5, "Pending");
       
       int r=ps.executeUpdate();
       
       if(r>1)
           bool=true;
       } 
   return bool;
   }
    static boolean stat_app(String a,String b) throws SQLException
   {
       boolean bool=false;
       PreparedStatement ps=dbconnect.ConnectDB().prepareStatement(query.get_att());
       ps.setString(1, b);
       ps.setString(2, a);
      
       ResultSet rs=ps.executeQuery();
       if(rs.next())
           bool=true;
       
   return bool;
   }
    static ResultSet get_datediff(String a,String b) throws SQLException
   {
       
       PreparedStatement ps=dbconnect.ConnectDB().prepareStatement(query.get_datediff());
       ps.setString(1, a);
       ps.setString(2, b);
       
      
       ResultSet rs=ps.executeQuery();
       
       
   return rs;
   }
      static void up_app(String a,String b) throws SQLException 
   {
       

           PreparedStatement ps=dbconnect.ConnectDB().prepareStatement(query.up_app());
           ps.setString(1, a);
           ps.setString(2, b);       
           
           ps.executeUpdate();
       

   }
         
      static void up_lv_att(String a,DateTime c,DateTime d,String dept) throws SQLException
   {
       String b=null;
       String e=null;
       PreparedStatement ps = dbconnect.ConnectDB().prepareStatement(query.up_lv_att());
       PreparedStatement ds=null;
       while(true)
       {      
           
           b=c.toString("yyyy-MM-dd");
           
           ps.setString(1, a);
           ps.setString(2, b);
           

           ps.executeUpdate();
           if(c.equals(d))
               break;
           c=c.plusDays(1);
           }
         c=c.plusDays(1);
         e=c.toString("yyyy-MM-dd HH:mm:ss");
         e="'"+e+"'";
         int x=Integer.parseInt(a);

        
        try{
        String s="set global event_scheduler = 1";
        ps = dbconnect.ConnectDB().prepareStatement(s);
        ps.execute();
        String query="CREATE EVENT `"+a+"` ON SCHEDULE AT "+e+" ON COMPLETION NOT PRESERVE ENABLE DO UPDATE department SET on_leave=on_leave-1 WHERE dept_name="+dept;
        ds=dbconnect.ConnectDB().prepareStatement(query);
        
        ds.executeUpdate();
        ds.close();
        ds=dbconnect.ConnectDB().prepareStatement("UPDATE department SET on_leave=on_leave+1 WHERE dept_name="+dept);
        ds.executeUpdate();
        ds.close();
        }
        catch(Exception k)
        {
            JOptionPane.showMessageDialog(null, k);                
        }
   }
      static void ins_user(String a,String b,String c) throws SQLException
      {
       PreparedStatement ps=dbconnect.ConnectDB().prepareStatement(query.ins_user());
           ps.setString(1, a);
           ps.setString(2, b);
           ps.setString(3, c);
           
           ps.executeUpdate();
      }
       static void up_user(String a,String b) throws SQLException
      {
       PreparedStatement ps=dbconnect.ConnectDB().prepareStatement(query.up_user());
           ps.setString(1, b);
           ps.setString(2, a);
           
           
           ps.executeUpdate();
      }
        static void del_user(String a) throws SQLException
      {
       PreparedStatement ps=dbconnect.ConnectDB().prepareStatement(query.del_user());
       ps.setString(1, a);
           
           
       ps.executeUpdate();
      }
        static void ins_des(String a,String b,String c) throws SQLException
      {
       PreparedStatement ps=dbconnect.ConnectDB().prepareStatement(query.insert_des());
           ps.setString(1, a);
           ps.setString(2, b);
           ps.setString(3, c);
           
           ps.executeUpdate();
      }
       static void up_des(String a,String b) throws SQLException 
      {

           PreparedStatement ps=dbconnect.ConnectDB().prepareStatement(query.up_des());
           ps.setString(1, b);
           ps.setString(2, a);  
           ps.executeUpdate();


      }
        static void delete_des(String a) throws SQLException
      {
       PreparedStatement ps=dbconnect.ConnectDB().prepareStatement(query.del_user());
       ps.setString(1, a);
           
           
       ps.executeUpdate();
      }
        static void ins_dep(String a,String b) throws SQLException
      {
       PreparedStatement ps=dbconnect.ConnectDB().prepareStatement(query.insert_dep());
           ps.setString(1, a);
           ps.setString(2, b);

           
           ps.executeUpdate();
      }
       static void up_dep(String a,String b,String c) throws SQLException
      {
       PreparedStatement ps=dbconnect.ConnectDB().prepareStatement(query.up_dep());
           ps.setString(1, b);
           ps.setString(2, c);
           ps.setString(3, a);
           
           
           ps.executeUpdate();
      }
        static void delete_dep(String a) throws SQLException
      {
       PreparedStatement ps=dbconnect.ConnectDB().prepareStatement(query.delete_dep());
       ps.setString(1, a);
           
           
       ps.executeUpdate();
      }
}
