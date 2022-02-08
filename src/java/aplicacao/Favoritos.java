package aplicacao;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Favoritos {
    private int id;
      ArrayList<Integer> idProdutos = new ArrayList<Integer>();;

    public Favoritos(int id, ArrayList idProdutos) {
        this.id = id;
        this.idProdutos = idProdutos;
    }

    public Favoritos() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList getIdProdutos() {
        return idProdutos;
    }

    public void setIdProdutos(ArrayList idProdutos) {
        this.idProdutos = idProdutos;
    }

    public int getIdProdutos(int numero) {
        return idProdutos.get(numero);
    }

    public void setIdProdutos(int idproduto) {
        this.idProdutos.add(idproduto);
    }

}