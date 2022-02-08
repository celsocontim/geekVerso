package aplicacao;

import Model.UsuariosDAO;
import java.util.ArrayList;

public class Usuarios {
    private int id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private String senha;
    
    public Usuarios(int id, String nome, String cpf, String senha,String email, String telefone) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.senha = senha;
            }

    public Usuarios() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
        
    public ArrayList<Usuarios> listarTodosUsuarios() {
	return new UsuariosDAO().getLista();
    }
}
