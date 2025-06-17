import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LendingDatabase {
    private final Connection conn;

    public LendingDatabase(Connection conn) {
        this.conn = conn;
    }
    public boolean loanExists(String loancode){
        String sql = "SELECT loancode FROM lending WHERE loancode = ?";
        try(PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, loancode);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (SQLException e){
            System.out.println("Error checking invoice: " + e.getMessage());
            return false;
        }
    }
    
    public boolean addLoan(String loancode, String client, int loanamount, int loanterms, double loaninterest) {
        String insertQuery = "INSERT INTO lending(loancode, client, loanamount, loanterms, loaninterest, payment)VALUES(?,?,?,?,?,?)";
        if(loanExists(loancode)){
            return false;
        } else {
        try( PreparedStatement pst = conn.prepareStatement(insertQuery)){
                pst.setString(1, loancode);
                pst.setString(2, client);
                pst.setInt(3, loanamount);
                pst.setInt(4, loanterms);
                pst.setInt(5, (int) loaninterest);
                pst.setInt(6, 0);


                int rowsAffected = pst.executeUpdate();
                return rowsAffected > 0;
        
        }catch(SQLException e){
            if (e.getErrorCode() == 1062) {
                System.out.println("Username already exists.");
            }else{
                e.printStackTrace();
                    }
                }
            }
        return false;
        }

    public List<Lending> printLoans() throws SQLException{
            List<Lending> clients = new ArrayList<>();
            String sql = "SELECT loancode, client, loanamount, loanterms, loaninterest, payment FROM lending";
            
                try(Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
                    try(PreparedStatement pst =conn.prepareStatement(sql)){
                System.out.println("Loan Code   Client Name         Loan Amount     Interest       Payment      Balance");
                System.out.println("--------------------------------------------------------------------------------------------");
                
                while (rs.next()) {
                    
                        System.out.println();

                        String loancode = rs.getString("loancode");
                        String client = rs.getString("client");
                        int loanamount = rs.getInt("loanamount");
                        int loanterms = rs.getInt("loanterms");
                        int loaninterest = rs.getInt("loaninterest");
                        int payment = rs.getInt("payment");
                        int totalbalance = (int) (loanamount + loaninterest);
                        ;
                        
                        int interest = (int) (100 * loaninterest) ;
                int balance = (int) (loanamount + interest);
                System.out.println( loancode +"             " + client + "              " + loanamount + "              " + loaninterest+"%" + "         " + payment + "           " + balance);
        }
        } catch (SQLException e){
            System.out.println("Error checking invoice: " + e.getMessage());
            }
        }
                return clients;
    }
}

