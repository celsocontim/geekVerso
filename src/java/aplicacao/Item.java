package aplicacao;

public class Item {
    private int id;
    private int idProduto;
    private int quantidade;
    
    public Item(int id, int idProduto, int quantidade) {
        this.id = id;
        this.idProduto = idProduto;
        this.quantidade = quantidade;
         
 }
    public Item() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    }
