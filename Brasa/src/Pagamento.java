import java.util.Scanner;
public class Pagamento {
    Scanner scan = new Scanner(System.in);
    public Pagamento(){

    }

    public double calculaConta(Pedido pedido){
        double conta = pedido.getPrato().preco * pedido.getQuantidade();

        if(pedido.getAdicional() == 's' || pedido.getAdicional() == 'S'){
            conta += 7.00 * pedido.getQtdAdicional();
        }
        return conta;
    }

    public boolean pagarPorCartaoCredito(Pedido pedido){
        System.out.println("Insira o cartão de crédito");
        return pagarPorCartao(pedido);
    }
    public boolean pagarPorCartaoDebito(Pedido pedido){
        System.out.println("Insira o cartão de débito");
        return pagarPorCartao(pedido);
    }
    public boolean pagarPorVR(Pedido pedido){
        System.out.println("Insira o vale refeição");
        return pagarPorCartao(pedido);
    }
    public boolean pagarPorDinheiro(Pedido pedido){
        double notaCliente;
        do{
            System.out.println("Total da conta === R$ " + pedido.getTotal());
            System.out.println("Pagamento em espécie: ");
            notaCliente = scan.nextDouble();

            if(notaCliente >= pedido.getTotal()){
                System.out.println("Seu troco: R$ " + (notaCliente - pedido.getTotal()));
            } else{
                System.out.println("Valor insuficiente");
            }
        } while(notaCliente < pedido.getTotal());

        return true;
    }
    public boolean pagarPorCartao(Pedido pedido){
        System.out.println("Total da conta === R$ " + pedido.getTotal());
        System.out.println("Digite sua senha: ");
        String pwd = scan.next();
        return true;
    }

}
