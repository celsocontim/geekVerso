import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(name = "Conexao", urlPatterns = {"/Conexao"})
public class Conexao extends HttpServlet {
   
    //Armazena a conexão com o BD
    private static Connection conexao = null;
    
    //Realiza a conexão com o BD
    public static Connection criaConexao() throws SQLException {
        
        //Verifica se existe conexão
        if (conexao == null) {
            try {
                //Carrega conexão
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Driver foi carregado!");
                //Abre conexão via JDBC
                conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda", "root", "");
                System.out.println("Conexão realizada com sucesso");
            }
            catch(ClassNotFoundException e) {
                System.out.println("Driver não foi localizado!");
            }
        }
        return conexao;
    }
}