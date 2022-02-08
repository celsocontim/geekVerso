package aplicacao;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Carrinho {
    private int id;
    ArrayList<Integer> idItens = new ArrayList<Integer>();;

    public void Carrinho(int id, ArrayList idItens) {
        this.id = id;
        this.idItens = idItens;
    }

    public Carrinho() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Integer> getIdItens() {
        return idItens;
    }

    public void setIdItens(ArrayList idItens) {
        this.idItens = idItens;
    }

    public int getIdItens(int numero) {
        return idItens.get(numero);
    }

    public void setIdItens(int iditem) {
        this.idItens.add(iditem);
    }

}