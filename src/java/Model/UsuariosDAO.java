package Model;

import aplicacao.Usuarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(name = "UsuariosDAO", urlPatterns = {"/UsuariosDAO"})
public class UsuariosDAO extends HttpServlet {

  private Connection conexao;
    public UsuariosDAO() {
        try {
            // Cria a conexão com o banco de dados
            conexao = Conexao.criaConexao();
        }
        catch( Exception e ) {
            System.out.println("Erro criação de conexao DAO");
            System.out.println(e);
        }
    }
    public ArrayList<Usuarios> getLista() {
        //Cria o objeto resultado que irá armazenar os registros retornados do BD
        ArrayList<Usuarios> resultado = new ArrayList<>();
        try {            
            Statement stmt = conexao.createStatement();

            ResultSet rs = stmt.executeQuery("select * from usuarios");

            while( rs.next() ) {
                Usuarios usuarios = new Usuarios();
                
                usuarios.setId(rs.getInt("id") );
                usuarios.setNome( rs.getString("nome") );
                usuarios.setCpf(rs.getString("cpf") );
                usuarios.setSenha( rs.getString("senha") );
                usuarios.setEmail(rs.getString("email") );
                usuarios.setTelefone(rs.getString("telefone") );
                resultado.add(usuarios);
            }
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        
        return resultado;
    }
    
    public Usuarios getUsuariosPorID( int codigo ) {
        Usuarios Usuarios = new Usuarios();
        try {
            String sql = "SELECT * FROM usuarios WHERE id = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, codigo);
            
            ResultSet rs = ps.executeQuery();
            
            if ( rs.next() ) {
                Usuarios.setId(rs.getInt("id"));
                Usuarios.setNome( rs.getString("nome") );
                Usuarios.setCpf(rs.getString("cpf") );
                Usuarios.setSenha( rs.getString("senha") );
                Usuarios.setEmail(rs.getString("email") );
                 Usuarios.setTelefone(rs.getString("telefone") );
            }
            
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return Usuarios;
    }
    
    public Usuarios getLogin( String cpf, String senha ) throws SQLException{    
            Usuarios Usuarios = new Usuarios();
        try {
            String sql = "SELECT * FROM administradores WHERE cpf = ? and senha = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, cpf);
            ps.setString(1, senha);
            
            ResultSet rs = ps.executeQuery(); 
                               
            if ( rs.next() ) {
                Usuarios.setId(rs.getInt("id"));
                Usuarios.setNome( rs.getString("nome") );
                Usuarios.setCpf(rs.getString("cpf") );
                Usuarios.setSenha(rs.getString("senha") );
                Usuarios.setEmail(rs.getString("email") );
                Usuarios.setEmail(rs.getString("telefone") );
            }
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return Usuarios;           
            
    }
    
    public boolean gravar( Usuarios Usuarios ) {
        try {
            String sql;
            if ( Usuarios.getId() == 0 ) {
                // Realizar uma inclusão
                sql = "INSERT INTO usuarios (nome, cpf, senha, email, senha) VALUES (?,?,?,?,?)";
            } else {
                // Realizar uma alteração
                sql = "UPDATE usuarios SET nome=?, cpf=?, senha=?, email=?, telefone=? WHERE id=?";
            }
            
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, Usuarios.getNome());
            ps.setString(2, Usuarios.getCpf());
            ps.setString(3, Usuarios.getSenha());
            ps.setString(4, Usuarios.getEmail());
            ps.setString(5, Usuarios.getTelefone());
            
            if ( Usuarios.getId()> 0 )
                ps.setInt(6, Usuarios.getId());
            
            ps.execute();
            
            return true;
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
            return false;
        }
    }
    
    public boolean excluir( int id ) {
        try {
            String sql = "DELETE FROM usuarios WHERE id = ?";
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
