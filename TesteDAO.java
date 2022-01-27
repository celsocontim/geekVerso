import Teste;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(name = "ContaDAO", urlPatterns = {"/ContaDAO"})
public class TesteDAO extends HttpServlet {

    private Connection conexao;
    public TesteDAO() {
        try {
            // Cria a conexão com o banco de dados
            conexao = Conexao.criaConexao();
        }
        catch( SQLException e ) {
            System.out.println("Erro criação de conexao DAO");
            System.out.println(e);
        }
    }

}