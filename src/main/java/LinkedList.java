

public class LinkedList {

    private Product header; // início da lista ligada
    private Product trailer; // fim da lista ligada
    private int size;    // quantidade de elementos na lista ligada

    public LinkedList() {
        // construtor - cria uma lista vazia
        header = null;
        trailer = null;
        size = 0;
    }

    public int size() {
        // retorna o tamanho da lista	
        return size;
    }

    public boolean isEmpty() {
        // verifica se a lista está vazia
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    public Node first() {
        // retorna o Nó inicial da lista
        return header;
    }

    public Node last() {
        // retorna o nó final da lista
        return trailer;
    }

    public void addFirst(Product newProduct) {
        // adiciona um animal no início da Lista
        if (isEmpty()) {
            // a lista está vazia
            header = newProduct;
            trailer = newProduct;
        } else {
            // já existe pelo menos um animal na lista
            newProduct.next = header;
            header = newProduct;
        }
        size++;
    }

    public void addLast(Product newProduct) {
        // adiciona um animal no final da Lista
        if (isEmpty()) {
            // a lista está vazia
            header = newProduct;
            trailer = newProduct;
        } else {
            // já existe pelo menos um animal na lista
            trailer.next = newProduct;
            trailer = newProduct;
        }
        size++;
    }

    public void showList() {
        //mostra todos os elementos da lista
        if (isEmpty()){;
        } else{
        Product aux = header;
        header.showProduct();
        while (aux.next != null) {
            aux = aux.next;
            aux.showProduct();
        }
        }
    }

    public void remove(String codProduct) throws Exception {
        // remove o animal indicado como parâmetro
        if (isEmpty()) // se a lista estiver vazia
        {
            throw new Exception("Lista vazia!");
        } else {
            // verifica se o animal a ser removido é o primeiro da lista
            if (!header.cod.equals(codProduct)) {
                // procura pelo animal que será removido
                Product aux, ant = null;
                for (aux = header; !aux.cod.equals(codProduct); aux = aux.next) {
                    ant = aux;
                }
                ant.next = aux.next;
            } else {
                header = header.next;
            }
            size--;
        }
    }
     public Product searchNode(String codProduct) throws Exception {
        if (isEmpty()) // se a lista estiver vazia
        {
            throw new Exception("Lista vazia, produto não encontrado");
        } else {
            Product aux;
            int i = 0;
            for (aux = header; i<size; aux = aux.next) {
                if(aux.cod.equals(codProduct)){
                    return aux;
                }
            }
            throw new Exception("Produto não encontrado");
        }
    }
}