package sams;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;
import java.util.List;
import java.util.HashSet;
import sams.DataModels.Patient;
import sams.DataModels.Appointment;
import sams.DataModels.Condition;
import sams.DataModels.Summary;


public class DatabaseHelper {
 // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost:3306/surgery";

   //  Database credentials
   static final String USER = "turk";
   static final String PASS = "turk";


   public static Connection getConnection(){
       Connection conn = null;
   try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      conn = DriverManager.getConnection(DB_URL, USER, PASS);}
   catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return conn;
}
   
   public static void creates() throws SQLException {
   Connection conn;
   Statement stmt;
   conn = getConnection();

      //STEP 4: Execute a query
      stmt = conn.createStatement();
      String sql = "CREATE TABLE IF NOT EXISTS PATIENTS " +
                   "(pId INT not NULL AUTO_INCREMENT, " +
                   " pName VARCHAR(25), " + 
                   " pSurname VARCHAR(25), " + 
                   " pHomePhone VARCHAR(25), " + 
                   " pMobPhone VARCHAR(25), " + 
                   " pEmail VARCHAR(255), " + 
                   " pAddress VARCHAR(255), " + 
                   " pSex VARCHAR(25), " + 
                   " pDOB VARCHAR(25), " + 
                   " PRIMARY KEY ( pId ))";
      stmt.addBatch(sql);
             sql=  "CREATE TABLE IF NOT EXISTS USER " +
                   "(uName VARCHAR(25) not NULL, " +
                   " uPassword VARCHAR(255), " + 
                   " uRole VARCHAR(25), " +
                   " PRIMARY KEY ( uName ))";
     stmt.addBatch(sql);
             sql = "CREATE TABLE IF NOT EXISTS LOGIN " +
                   "(logNo INT not NULL AUTO_INCREMENT, " +
                   " uName VARCHAR(25) REFERENCES USER(uName), " + 
                   " logTime DATETIME, " + 
                   " logOut datetime, " +  
                   " PRIMARY KEY ( logNo ))";
      stmt.addBatch(sql);
             sql = "CREATE TABLE IF NOT EXISTS APPOINTMENT " +
                   "(aNo INT not NULL AUTO_INCREMENT, " +
                   " pId INT REFERENCES PATIENT(pId), " +
                   " uName VARCHAR(25) REFERENCES USER(uName), " + 
                   " aDate_Created DATE, " + 
                   " aDatetime datetime, " + 
                   " aType VARCHAR(25), " +
                   " aSummary VARCHAR(2550), " +
                   " PRIMARY KEY ( aNo ))";
      stmt.addBatch(sql);
             sql = "CREATE TABLE IF NOT EXISTS CONDITIONS " +
                   "(cId INT not NULL AUTO_INCREMENT, " +
                   " cName VARCHAR(255), " +
                   " cDesc VARCHAR(255), " + 
                   " cThreat_level VARCHAR(25), " + 
                   " cNotifiable VARCHAR(25), " + 
                   " cType VARCHAR(25), " +
                   " PRIMARY KEY ( cId ))";
      stmt.addBatch(sql);   
             sql = "CREATE TABLE IF NOT EXISTS PATIENT_HISTORY " +
                   "(hCaseNo INT not NULL AUTO_INCREMENT, " +
                   " pId INT REFERENCES PATIENT(pId), " +
                   " cID INT REFERENCES CONDITIONS(cID), " + 
                   " hDate_presented DATE, " + 
                   " PRIMARY KEY ( hCaseNo ))";
      stmt.addBatch(sql);        
             sql = "CREATE TABLE IF NOT EXISTS TREATMENT " +
                   "(hCaseNo INT not NULL REFERENCES PATIENT_HISTORY(hCaseNo), " +
                   " tAppNo INT REFERENCES APPOINTMENT(aNo), " +
                   " tPrescription VARCHAR(255), " + 
                   " tReferral VARCHAR(255), " + 
                   " tRecommendation VARCHAR(255), " + 
                   " PRIMARY KEY ( hCaseNo ))";
      stmt.addBatch(sql);          
             sql = "CREATE TABLE IF NOT EXISTS TODO " +
                   "(dItemNo INT not NULL, " +
                   " dTask VARCHAR(255), " +
                   " PRIMARY KEY ( dItemNo ))";
      stmt.addBatch(sql);         
      stmt.executeBatch();
      stmt.close();
      conn.close();
   }//end main
   
   public static void insert(String table, String data) throws SQLException{
   Connection conn;
   Statement stmt;
   conn = getConnection();
   stmt = conn.createStatement();
   
   String sql = "insert into '"+table+"' values('"+data+"')";
   stmt.executeUpdate(sql);
   stmt.close();
   conn.close();
   }
   
   public static int login(String username, String password) throws SQLException{
   Connection conn;
   Statement stmt;
   conn = getConnection();
   stmt = conn.createStatement();
   
   String sql= "SELECT * FROM user where uName='"+username+"' and uPassword='"+password+"'";
   ResultSet rs = stmt.executeQuery(sql);
   
   int count = 0;
   while(rs.next())
   {
   count = count + 1;
   }
   stmt.close();
   conn.close();
   return count;
   
   }
   
   public static void view(String table, String data) throws SQLException{
   Connection conn;
   Statement stmt;
   conn = getConnection();
   stmt = conn.createStatement();
   
   String sql = "select * from '"+table+"' values('"+data+"')";
   stmt.executeUpdate(sql);
   stmt.close();
   conn.close();
   }
   
  public static String getPrivileges(String username, String password) throws SQLException{
   Connection conn;
   Statement stmt;
   conn = getConnection();
   stmt = conn.createStatement();
   String uRole= "User";
   
   String sql= "SELECT uRole FROM user where uName='"+username+"' and uPassword='"+password+"'";
   ResultSet rs = stmt.executeQuery(sql);
   while(rs.next()){
   uRole = rs.getString("uRole");
   }
   return uRole;
  }
  
  public static List todaysApp() throws SQLException{
   Connection conn;
   Statement stmt;
   conn = getConnection();
   stmt = conn.createStatement();
   List array= new ArrayList();
   Date dNow= new Date();
   SimpleDateFormat ft = new SimpleDateFormat("yyyy MM dd hh:mm:ss");
   
   
   String sql = "SELECT pID, aDatetime from appointment where aDatetime='"+ft.format(dNow)+"'";
   ResultSet rs = stmt.executeQuery(sql);
   while(rs.next()){
   array.add(rs.getString(1));
   }
      return array;
  }
  
  void insertPatient(String name, String lastname, String homephone, String mobile, String email, String address, String sex, String dob) throws SQLException{
    Connection conn;
    Statement stmt;
    conn = getConnection();
    stmt = conn.createStatement();
   
    String sql = "insert into patients (pName, pSurname, pHomePhone, pMobPhone, pEmail, pAddress, pSex, pDOB) values('"+name+"', '"+lastname+"', '"+homephone+"', '"+mobile+"','"+email+"', '"+address+"', '"+sex+"', '"+dob+"')";
    stmt.executeUpdate(sql);
    stmt.close();
    conn.close();
   }
  
     public static List search(String table, String keyword) throws SQLException{
        Connection conn;
        Statement stmt;
        //PreparedStatement stmt = conn.prepareStatement("UPDATE user_table SET name=? WHERE id=?");
        conn = getConnection();
        stmt = conn.createStatement();
        String query[] = null;
        if (table.equals("Summaries")){
            query = new String[]{"SELECT * FROM Appointment join Patients using (pId) where pName like '%"+ keyword + "%'", 
                         "SELECT * FROM Appointment join Patients using (pId) where aSummary like '%"+ keyword + "%'"};
        }
        else if (table.equals("Patients")){
            query = new String[]{"SELECT * FROM Patients where pName like '%"+ keyword + "%'", 
                         "SELECT * FROM Patients where pSurname like '%"+ keyword + "%'",
                         "SELECT * FROM Patients where pEmail like '%"+ keyword + "%'",
                         "SELECT * FROM Patients where pAddress like '%"+ keyword + "%'"};
        }
        else if (table.equals("Appointment")){
            query = new String[]{"SELECT * FROM Appointment join Patients using (pId) where aDatetime like '%"+ keyword + "%'", 
                         "SELECT * FROM Appointment join Patients using (pId) where aType like '%"+ keyword + "%'",
                         "SELECT * FROM Appointment join Patients using (pId) where pName like '%"+ keyword + "%'"};
        }
        else if (table.equals("Conditions")){
            query = new String[]{"SELECT * FROM Conditions where cName like '%"+ keyword + "%'", 
                         "SELECT * FROM Conditions where cDesc like '%"+ keyword + "%'",
                         "SELECT * FROM Conditions where cThreat_level like '%"+ keyword + "%'"};
        }
        
        List results = new ArrayList<>();
        for (String q: query) {
           ResultSet rs = stmt.executeQuery(q);
           //results.add(rs);
           while(rs.next()) {
                switch(table){
                    case "Patients":
                        Patient p = new Patient();
                        p.setPName(rs.getString("pName"));
                        p.setPSurname(rs.getString("pSurname"));
                        p.setPEmail(rs.getString("pEmail"));
                        p.setPAddress(rs.getString("pAddress"));
                        p.setPMobPhone(rs.getString("pMobPhone"));
                        results.add(p);
                        break;
                    case "Appointment":
                        Appointment a = new Appointment();
                        a.setApName(rs.getString("pName"));
                        a.setADate(rs.getDate("aDatetime"));
                        a.setAType(rs.getString("aType"));
                        results.add(a);
                        break;
                    case "Conditions":
                        Condition c = new Condition();
                        c.setCName(rs.getString("cName"));
                        c.setCDesc(rs.getString("cDesc"));
                        c.setTLevel(rs.getString("cThreat_level"));
                        results.add(c);
                        break;
                    case "Summaries":
                        Summary s = new Summary();
                        s.setSpName(rs.getString("pName"));
                        s.setSummary(rs.getString("aSummary"));
                        results.add(s);
                        break;
                }
           }
        }
        Set s = new HashSet();
        s.addAll(results);
        results.clear();
        results.addAll(s);
        return results;

   }
}//end Surgapp