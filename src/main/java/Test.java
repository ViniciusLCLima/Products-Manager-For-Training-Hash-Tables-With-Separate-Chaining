import java.util.*;

public class Test {
    static HashTable table = new HashTable();
    static Scanner lineInp = new Scanner(System.in);
    static Scanner inp = new Scanner(System.in);
    static Scanner doubleInp = new Scanner(System.in);
    public static void main(String[] args){
        Scanner inp = new Scanner(System.in);
        int opt;
        
        boolean flag = true;
        while (flag){
            System.out.println("Menu de Opções");
            System.out.println("1 - Inserir produto.");
            System.out.println("2 - Excluir produto.");
            System.out.println("3 - Mostrar Produtos");
            System.out.println("4 - Buscar Produto");
            System.out.println("5 - Encerrar");
            opt = inp.nextInt();
            if ((opt >0) && (opt<6) ){
                if(opt == 1){
                    insertProduct();
                } else if (opt == 2){
                    delProduct();
                } else if (opt == 3){
                    showProducts();
                } else if (opt == 4){
                    searchProduct();
                } else{
                    flag = false;
                }
                } else {
                System.out.println("Número inválido, tente novamente.");
                }
        }
    }
    public static void insertProduct(){
        String cod;
        String desc;
        double preco;
        do{
            System.out.println("Insira um código com 13 dígitos:");
            cod = inp.next();
        }while(cod.length()!=13);
        do{
            System.out.println("Insira a descrição do produto:");
            desc = lineInp.nextLine();
        }while(desc.length()==0);
        do{
            System.out.println("Insira o preço do produto:");
            preco = doubleInp.nextDouble();
        }while(preco<=0);
        Product product = new Product(cod, desc, preco);
        table.addProduct(product);
    }
    public static void delProduct(){
        String cod;
        do{
            System.out.println("Insira o código do produto a ser excluído:");
            cod = inp.next();
        }while(cod.length()!= 13);
        table.delProduct(cod);
    }
    public static void showProducts(){
        table.showProducts();
    }
    public static void searchProduct(){
        String cod;
        do{
            System.out.println("Insira o código do produto que você procura, com 13 dígitos:");
            cod = inp.next();
        }while(cod.length()!=13);
        try{
            Product product = table.searchProduct(cod);
            System.out.println("Seu produto é o seguinte:");
            product.showProduct();
        } catch (Exception ex){
            System.out.println("Produto não encontrado, tente novamente.");
        }
    }
}
