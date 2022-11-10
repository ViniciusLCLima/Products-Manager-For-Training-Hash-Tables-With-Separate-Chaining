
public class Product extends Node{
    public String cod;
    public String descricao;
    public double preco;
    
    public Product(String cod, String descricao, Double preco) {
    super();
    this.cod = cod;
    this.descricao = descricao;
    this.preco = preco;
    }
    
    public void showProduct(){
        System.out.println("Código:"+ cod+"\nDescrição: "+ descricao + "\nPreço: " + preco + "\n");
    }
}
