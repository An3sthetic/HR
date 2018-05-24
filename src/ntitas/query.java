
package ntitas;

public class query
{
   static String query; 
   static String login()
    {
        query="SELECT * From login where username=? and password=? and type=?";
        return query;
    }
   
      static String insert_emp()
    {
        query="INSERT INTO employee Values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,20)";
        return query;
    }
       static String insert_dep()
    {
        query="INSERT INTO department Values (?,?,0,NULL)";
        return query;
    }
        static String up_dep()
    {
        query="UPDATE department SET dept_name=?,leave_allowed=? WHERE dept_id=?";
        return query;
    }
        static String delete_dep()
    {
        query="DELETE FROM department where dept_id=?";
        return query;
    }
        static String select_dep_at()
    {
        query="Select department.dept_id,department.on_leave,department.leave_allowed ,department.dept_name,count(employee.department_name) FROM department,employee where dept_name=? and department.dept_name=employee.department_name";
        return query;
    }
       static String delete_emp()
    {
        query="DELETE FROM employee where id=?";
        return query;
    }
       static String intime()
    {
        query="INSERT INTO attendance Values (?, CURRENT_DATE(), CURRENT_TIME(), NULL, NULL)";
        return query;
    }
       static String outtime()
               
    {
        query="UPDATE attendance SET outtime=CURRENT_TIME, duration=TIMEDIFF(CURRENT_TIME,intime) WHERE id=? AND date=CURRENT_DATE" ;
        return query;
    }
       static String time_check()
    {
        query="Select * FROM attendance WHERE id=? AND date=CURRENT_DATE";
        return query;
    }

       static String select_emp()
       {
        query="SELECT id,CONCAT(Firstname,' ',Lastname) as Name FROM `employee`";
        return query;
       }
       static String select_dep()
       {
        query="Select dept_name FROM department";
        return query;
       }
       static String ins_user()
       {
       query="INSERT INTO login Values (?,?,?)";
        return query;
       }
       static String up_user()
       {
       query="UPDATE login SET password=? WHERE username=?";
        return query;
       }
        static String del_user()
       {
       query="DELETE FROM login where username=?";
        return query;
       }
        static String select_user()
       {
        query="Select username FROM login";
        return query;
       }
        static String select_user_at()
       {
        query="Select * FROM login where username=?";
        return query;
       }
         static String select_emp_at()
       {
        query="SELECT * FROM employee where id=?";
        return query;
       }
       static String att_by_id()
       {
        query="SELECT * FROM attendance WHERE id=? AND date=?";
        return query;
       }
       static String att_by_dt()
       {
        query="SELECT * FROM attendance where month(date)=? and YEAR(date)=?";
        return query;
       }
        
       static String get_pay()
       {
        query="SELECT employee.Firstname,employee.Lastname,designation.basic_salary FROM employee,designation where employee.id=? and employee.designation=designation.desg_name";
        return query;
       }   
        static String get_att()
       {
        query="SELECT COUNT(id) FROM attendance where id=? and month(date)=? and YEAR(date)=?";
        return query;
       }
        static String chk_pay()
       {
        query="SELECT * FROM payroll where id=? and month=? and year=?";
        return query;
       } 
       static String ins_pay()
       {
        query="INSERT INTO payroll where id=? and month=? and year=?";
        return query;
       }
        static String ins_app()
       {
        query="INSERT INTO application values(?,?,?,?,CURRENT_DATE(),?)";
        return query;
       }
        static String chk_app()
       {
        query="SELECT * FROM application where id=? and month(sub_date)=month(CURRENT_DATE) and year(sub_date)=year(CURRENT_DATE)";
        return query;
       } 
        static String select_app()
       {
        query="SELECT id,sub_date,status FROM application";
        return query;
       }
        static String up_app()
       {
        query="UPDATE application SET status=? where id=?";
        return query;
       }
        static String select_leave_at()
       {
        query="SELECT application.id,application.start_date,application.end_date,application.msg_body,application.sub_date,application.status,employee.department_name,employee.designation,department.leave_allowed,department.on_leave FROM application left join employee ON application.id=employee.id LEFT JOIN department on employee.department_name=department.dept_name where application.id=? AND application.sub_date=?";
        return query;
       }
         static String get_datediff()
       {
        query="select datediff(?,?)";
        return query;
       }
          static String up_lv_att()
       {
        query="INSERT INTO attendance Values (?, ?, NULL, NULL, NULL)";
        return query;
       }
        static String insert_des()
    {
        query="INSERT INTO designation Values (?,?,?)";
        return query;
    }
       static String delete_des()
    {
        query="DELETE FROM designation where desg_id=?";
        return query;
    }
        static String up_des()
       {
       query="UPDATE designation SET basic_salary=? WHERE desg_id=?";
        return query;
       }
      static String select_des()
       {
        query="select desg_name from designation";
        return query;
       }
       static String select_des_at()
       {
        query="select * from designation where desg_name=?";
        return query;
       }
          static String up_emp()
       {
        query="UPDATE employee SET Firstname=?,Lastname=?,nid=?,department_name=?,designation=?,role=?,bank_acc=?,allocated_leave=?,pres_add=?,per_add=?,email=?,allocated_leave=? WHERE id=?";
        return query;
       }
}
