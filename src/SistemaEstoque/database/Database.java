package SistemaEstoque.database;

import SistemaEstoque.model.Produto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rafael Borges
 * github.com/RafaelB13
 */
public class Database {
    
    private  Connection conn = null;
    private  Statement stmt;
    private PreparedStatement pstm;
    
    public void DataBaseGetConnection(){
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:db.sqlite");
            stmt = conn.createStatement();
            
            
            if (conn != null) {
                System.out.println("Conexão com banco de dados realizada");
            }
            
        } catch (SQLException ex) {
            System.out.println("Erro na conexão com o banco de dados");
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void criarTabela(){
        String sql = "CREATE TABLE IF NOT EXISTS produtos(id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + " descricao VARCHAR,"
                + " codigo VARCHAR, preco REAL,"
                + " quantidade INTEGER)";
        
        try {
            stmt = conn.createStatement();
            stmt.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    public void inserir(String descricao, String codigo, Double preco, Integer quantidade){
        
        try {
            String sql = "INSERT INTO produtos(descricao, codigo, preco, quantidade)"
                + "VALUES("+descricao+","+codigo+","+preco+","+quantidade+")";
        DataBaseGetConnection();
        stmt.execute(sql);
        conn.commit();
        } catch (SQLException e) {
            
            System.out.println(e.getSQLState());
        }
        
    }
    
    public void exibir(){
        String sql = "SELECT * FROM produtos";
        
        try {
            DataBaseGetConnection();
            pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            
            while (rs.next()) {
                Integer id = rs.getInt("id");
                String descricao = rs.getString("descricao");
                String codigo = rs.getString("codigo");
                Double preco = rs.getDouble("preco");
                Integer quantidade = rs.getInt("quantidade");
                
                System.out.println(id+" - \n"+ descricao +" - \n"
                        + codigo +" - \n"
                                + preco +" - \n"
                                        + quantidade+" - \n");
                
            }
            conn.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }

}
