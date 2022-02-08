package Model;

import aplicacao.Compra;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(name = "CompraDAO", urlPatterns = {"/CompraDAO"})
public class CompraDAO extends HttpServlet {

  private Connection conexao;
    public CompraDAO() {
        try {
            // Cria a conexão com o banco de dados
            conexao = Conexao.criaConexao();
        }
        catch( Exception e ) {
            System.out.println("Erro criação de conexao DAO");
            System.out.println(e);
        }
    }
    public ArrayList<Compra> getLista() {
        //Cria o objeto resultado que irá armazenar os registros retornados do BD
        ArrayList<Compra> resultado = new ArrayList<>();
        try {            
            // Cria o objeto para quer será utilizado para enviar comandos SQL
            // para o BD
            Statement stmt = conexao.createStatement();
            // Armazena o resultado do comando enviado para o banco de dados
            ResultSet rs = stmt.executeQuery("select * from administradores");
            // rs.next() Aponta para o próximo registro do BD, se houver um 
            while( rs.next() ) {
                Compra compra = new Compra();
                
                compra.setId(rs.getInt("id") );
                compra.setIdUsuario( rs.getInt("idUsuario") );
                compra.setIdCarrinho(rs.getInt("idCarrinho") );
                compra.setNumerodocartao(rs.getLong("senha") );
                compra.setCpf(rs.getLong("cpf") );
                compra.setValor(rs.getDouble("valor") );
                compra.setOperacao(rs.getString("operacao") );
                compra.setEndereco(rs.getString("endereco") );
                compra.setData(rs.getString("data") );
                compra.setDescricao(rs.getString("descricao") );
                
  
                resultado.add(compra);
            }
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        
        return resultado;
    }
    
    public Compra getCompraPorID( int codigo ) {
        Compra compra = new Compra();
        try {
            String sql = "SELECT * FROM administradores WHERE id = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, codigo);
            
            ResultSet rs = ps.executeQuery();
            
            if ( rs.next() ) {
                compra.setId(rs.getInt("id") );
                compra.setIdUsuario( rs.getInt("idUsuario") );
                compra.setIdCarrinho(rs.getInt("idCarrinho") );
                compra.setNumerodocartao(rs.getLong("senha") );
                compra.setCpf(rs.getLong("cpf") );
                compra.setValor(rs.getDouble("valor") );
                compra.setOperacao(rs.getString("operacao") );
                compra.setEndereco(rs.getString("endereco") );
                compra.setData(rs.getString("data") );
                compra.setDescricao(rs.getString("descricao") );
            }
            
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return compra;
    }
    
    public boolean gravar( Compra Compra ) {
        try {
            String sql;
            if ( Compra.getId() == 0 ) {
                // Realizar uma inclusão
                sql = "INSERT INTO administradores (nome, cpf, senha) VALUES (?,?,?)";
            } else {
                // Realizar uma alteração
                sql = "UPDATE administradores SET nome=?, cpf=?, senha=? WHERE id=?";
            }
            
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setLong(1, Compra.getNumerodocartao());
            ps.setLong(2, Compra.getCpf());
            ps.setDouble(3, Compra.getValor());
            ps.setString(4, Compra.getOperacao());
            ps.setString(5, Compra.getEndereco());
            ps.setString(6, Compra.getData());
            ps.setString(7, Compra.getDescricao());
            
            if ( Compra.getId()> 0 )
                ps.setInt(8,Compra.getId());
            
            ps.execute();
            
            return true;
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
            return false;
        }
    }
    
    public boolean excluir( int id ) {
        try {
            String sql = "DELETE FROM administradores WHERE id = ?";
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
