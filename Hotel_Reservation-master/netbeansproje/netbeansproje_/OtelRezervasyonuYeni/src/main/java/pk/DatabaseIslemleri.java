package pk;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseIslemleri {
    
    static public Statement stmt = null;
    static public ResultSet rs = null;
    static public Connection conn = null;
    
    static public void connection() {
        try { 
            conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/otel", "root", "Adalet06");
            System.out.println("Bağlandı");
        }
        catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }
    
    static public ResultSet select(String SQL) {
        try {
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery(SQL);

            if (stmt.execute(SQL)) {
                rs = stmt.getResultSet();
            }
            else {
                rs.close();
                rs = null;
            }
            return rs;
        }
        catch (SQLException ex){
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            return null;
        }
    }
    
    static public int insert(String SQL) {
        System.out.println(SQL);
        try {
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stmt.executeUpdate(SQL);
            return 1;
        }
        catch (SQLException ex){
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            if(ex.getMessage() != null) return 2;
            if(ex.getSQLState() != null) return 3;
            return 4;
        }
    }
    
    static public int update(String SQL) {
        System.out.println(SQL);
        try {
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stmt.executeUpdate(SQL);
            return 1;
        }
        catch (SQLException ex){
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            if(ex.getMessage() != null) return 2;
            if(ex.getSQLState() != null) return 3;
            return 4;
        }
    }
    
    static public ResultSet checkRoom(Integer OdaTipID, String BaslangicTarihi, String BitisTarihi) {
        String SQL = "select * from odabilgileri WHERE OdaTipID = "+OdaTipID+" AND " +
"OdaID NOT IN (SELECT OdaID FROM rezervasyonbilgileri WHERE" +
"('"+BaslangicTarihi+"' BETWEEN RezervasyonBaslangicTarihi AND RezervasyonBitisTarihi)" +
"AND" +
"('"+BitisTarihi+"' BETWEEN RezervasyonBaslangicTarihi AND RezervasyonBitisTarihi)" +
"AND RezervasyonDurum = 1" +
")";
        System.out.println(SQL);
        try {
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery(SQL);

            if (stmt.execute(SQL)) {
                rs = stmt.getResultSet();
            }
            else {
                rs.close();
                rs = null;
            }
            return rs;
        }
        catch (SQLException ex){
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            return null;
        }
    }
    
}


