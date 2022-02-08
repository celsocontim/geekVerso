package Model;

import aplicacao.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;


@WebServlet(name = "ProdutoDAO", urlPatterns = {"/ProdutoDAO"})
public class ProdutoDAO extends HttpServlet {

    private Connection conexao;
    public ProdutoDAO() {
        try{
            conexao = Conexao.criaConexao();
        }catch( SQLException e ) {
            System.out.println("Erro de criação de conexão DAO");
            System.out.println(e);
        }
    }
    public ArrayList<Produto> getLista(int idConta) {
            
        ArrayList<Produto> resultado = new ArrayList<>();
        try {
                String sql = "SELECT * FROM lancamentos WHERE id_conta = ?";
                PreparedStatement ps = conexao.prepareStatement(sql);
                ps.setInt(1, idConta);

                ResultSet rs = ps.executeQuery();

                while( rs.next() ) {
                    Produto produto = new Produto();

                    produto.setId(rs.getInt("id") );
                    produto.setNome( rs.getString("nome") );
                    produto.setValor(rs.getDouble("valor") );
                    produto.setDescricao(rs.getString("descricao") );

                    resultado.add(produto);
                }
            }
        catch( SQLException e ){
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return resultado;
        
    }
    
    public Produto getProdutoporID(int codigo){
        Produto produto = new Produto();
        try {
            String sql = "SELECT * FROM lancamentos WHERE id = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, codigo);
            
            ResultSet rs = ps.executeQuery();
            
            if( rs.next() ) {
                produto.setId(rs.getInt("id") );
                produto.setNome( rs.getString("nome") );
                produto.setValor(rs.getDouble("valor") );
                produto.setDescricao(rs.getString("descricao") );
            }
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return produto;
    }
    
    public boolean gravar(Produto produto){
        try {
            String sql;
            if ( produto.getId() == 0 ) {
                // Realizar uma inclusão
                sql = "INSERT INTO lancamentos (id_conta, id_categoria, valor, operacao, data, descricao) VALUES (?,?,?,?,?,?)";
            } else {
                // Realizar uma alteração
                sql = "UPDATE contas SET id_conta, id_categoria=?, valor, operacao, data, descricao=? WHERE id=?";
            }
            
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, produto.getNome());
            ps.setDouble(2, produto.getValor());
            ps.setString(3, produto.getDescricao());
            
            if ( produto.getId()> 0 )
                ps.setInt(4, produto.getId());
            
            ps.execute();
            
            return true;
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
            return false;
        }
    }
    
     public boolean excluir( int id ) {
        try {
            String sql = "DELETE FROM lancamentos WHERE id = ?";
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
