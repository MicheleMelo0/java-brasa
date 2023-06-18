import java.util.Scanner;
public class Cliente extends Pessoa{
    private boolean atendido = false;
    Scanner scan = new Scanner(System.in);
    private boolean pago = false;
    Pagamento pgto = new Pagamento();
    public Cliente(){

    }

    public Cliente(String nome, String cpf){
        this.nome = nome;
        this.cpf = cpf;
    }

    public boolean getAtendido(){
        return atendido;
    }

    public void setAtendido(boolean atendido){
        this.atendido = atendido;
    }

    public boolean getPago(){
        return pago;
    }

    public void setPago(boolean pago){
        this.pago = pago;
    }

    public void chamarGarcom(Garcom garcom){
        garcom.atender();
    }

    public void pagar(Pedido pedido) {
        int option;
        do {
            System.out.println("Informe a forma de pagamento: ");
            System.out.println("1 - Cartão de débito");
            System.out.println("2 - Cartão de crédito");
            System.out.println("3 - Vale Refeição");
            System.out.println("4 - Dinheiro");

            option = scan.nextInt();

            switch (option){
                case 1:
                    setPago(pgto.pagarPorCartaoDebito(pedido));
                    break;
                case 2:
                    setPago(pgto.pagarPorCartaoCredito(pedido));
                    break;
                case 3:
                    setPago(pgto.pagarPorVR(pedido));
                    break;
                case 4:
                    setPago(pgto.pagarPorDinheiro(pedido));
                    break;
                default:
                    System.out.println("Opção Inválida. Tente novamente");
                    break;
            }
        } while(option < 1 || option > 4);
    }
}
