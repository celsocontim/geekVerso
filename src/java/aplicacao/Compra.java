package aplicacao;

public class Compra {
    private int id;
    private int idUsuario;
    private int idCarrinho;
    private long numerodocartao;
    private String cpf;
    private double valor;
    private String endereco;
    private String data;
    private String descricao;
    
    public Compra(int id, int idUsuario, int idCarrinho,long numerodocartao,String cpf, double valor, String data, String descricao) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.idCarrinho = idCarrinho;
        this.numerodocartao = numerodocartao;
        this.cpf = cpf;
        this.valor = valor;
        this.operacao = operacao;
        this.data = data;
        this.descricao = descricao;
    }
    public Compra() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdCarrinho() {
        return idCarrinho;
    }

    public void setIdCarrinho(int idCarrinho) {
        this.idCarrinho = idCarrinho;
    }
    public int getnumerodocartao() {
        return numerodocartao;
    }

    public void setnumerodocartao(long numerodocartao) {
        this.numerodocartao = numerodocartao;
    }
    public int getcpf() {
        return cpf;
    }

    public void setcpf(String cpf) {
        this.cpf = cpf;
    }

    public double getValor() {
        return valor;
    }
    /*Acho que a operação de calcular o valor não é aqui. Seria o somatório dos valores de cada item no carrinho.*/

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
