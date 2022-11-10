public class HashTable {
    public LinkedList[] table;

    public HashTable() {
        this.table = new LinkedList[10];
        for (int i = 0; i<10; i++){
        table[i]= new LinkedList();
        }
    }
    
    public void addProduct(Product product){
        int pos = hashFunction(product.cod);
        table[pos].addLast(product);
    }
    
    public void delProduct(String codProduct){
        int pos = hashFunction(codProduct);
        try{
        table[pos].remove(codProduct);
        } catch(Exception ex){
            System.out.println("Lista vazia, não há o que remover.");
        }
    }
    
    public Product searchProduct(String codProduct)throws Exception{
        int posTable = hashFunction(codProduct);
        Product product = table[posTable].searchNode(codProduct);
        return product;
    }
    
    public void showProducts(){
        for (int i = 0; i<table.length; i++){
            table[i].showList();
        }
    }
    
    public int hashFunction(String productCod){
        String cod = productCod.substring(0, 3);
        int codNum = Integer.valueOf(cod);
        int pos = codNum % 10;
        return pos;
    }
}
