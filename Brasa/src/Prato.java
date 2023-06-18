public class Prato {
    public int ref;
    public String nomePrato;
    public String ingredientes;
    public double preco;
    public int disponibilidade;

    public Prato(){

    }

    public Prato(int ref, String nomePrato, String ingredientes, double preco, int disponibilidade){
        this.ref = ref;
        this.nomePrato = nomePrato;
        this.ingredientes = ingredientes;
        this.preco = preco;
        this.disponibilidade = disponibilidade;
    }
}
