package sams;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class DatabaseHelper {
 // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost:3306/surgery";

   //  Database credentials
   static final String USER = "root";
   static final String PASS = "root";


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
   
   public static void main(String[] args) throws SQLException {
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
   
   int count = 0 ;
   while(rs.next())
   {
   count = count + 1;
   }
   
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
   
  
}//end Surgapp