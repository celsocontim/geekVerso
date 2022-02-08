package Model;

import aplicacao.Item;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(name = "ItemDAO", urlPatterns = {"/ItemDAO"})
public class ItemDAO extends HttpServlet {

  private Connection conexao;
    public ItemDAO() {
        try {
            // Cria a conexão com o banco de dados
            conexao = Conexao.criaConexao();
        }
        catch( Exception e ) {
            System.out.println("Erro criação de conexao DAO");
            System.out.println(e);
        }
    }
    public ArrayList<Item> getLista() {
        //Cria o objeto resultado que irá armazenar os registros retornados do BD
        ArrayList<Item> resultado = new ArrayList<>();
        try {            
            // Cria o objeto para quer será utilizado para enviar comandos SQL
            // para o BD
            Statement stmt = conexao.createStatement();
            // Armazena o resultado do comando enviado para o banco de dados
            ResultSet rs = stmt.executeQuery("select * from categorias");
            // rs.next() Aponta para o próximo registro do BD, se houver um 
            while( rs.next() ) {
                Item item = new Item();
                
                item.setId(rs.getInt("id") );
                item.setIdProduto( rs.getInt("idProduto") );
                item.setQuantidade( rs.getInt("quantidade") );
  
                resultado.add(item);
            }
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        
        return resultado;
    }
    
    public Item getCategoriasPorID( int codigo ) {
        Item Item = new Item();
        try {
            String sql = "SELECT * FROM categorias WHERE id = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, codigo);
            
            ResultSet rs = ps.executeQuery();
            
            if ( rs.next() ) {
                Item.setId(rs.getInt("id"));
                Item.setIdProduto( rs.getInt("idProduto") );
                Item.setQuantidade( rs.getInt("quantidade") );
            }
            
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return Item;
    }
    
    public boolean gravar( Item item ) {
        try {
            String sql;

            if ( item.getId() == 0 ) {
                // Realizar uma inclusão
                sql = "INSERT INTO categorias (descricao) VALUES (?)";
            } else {
                // Realizar uma alteração
                sql = "UPDATE categorias SET descricao=? WHERE id=?";
            }
            
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, item.getIdProduto());
            ps.setInt(2, item.getQuantidade());
            
            if ( item.getId()> 0 )
                ps.setInt(3, item.getId());
            
            ps.execute();
            
            return true;
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
            return false;
        }
    }
    
    public boolean excluir( int id ) {
        try {
            String sql = "DELETE FROM categorias WHERE id = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            return true;
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
            return false;
        }
    }
}
