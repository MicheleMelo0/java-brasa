public class Pedido {
    Prato prato;
    private int quantidade;
    private char adicional;
    private int qtdAdicional;
    private String status = "Em preparação";
    private double total = 0;

    public Pedido(){

    }
    public void setPrato(Prato prato){
        this.prato = prato;
    }

    public Prato getPrato(){
        return prato;
    }

    public int getQuantidade(){
        return quantidade;
    }

    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }

    public char getAdicional(){
        return adicional;
    }

    public void setAdicional(char adicional){
        this.adicional = adicional;
    }

    public void setQtdAdicional(int qtdAdicional){
        this.qtdAdicional = qtdAdicional;
    }

    public int getQtdAdicional(){
        return qtdAdicional;
    }

    public String getStatus(){
        return status;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public void setTotal(double total){
        this.total += total;
    }
    public double getTotal(){
        return total;
    }


}
