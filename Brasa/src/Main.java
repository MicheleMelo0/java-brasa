import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanf = new Scanner(System.in);

        Garcom garcom1 = new Garcom("José", "1111111111", 2);
        Chef chef1 = new Chef();
        Cliente cliente1 = new Cliente("Rafael", "222222222");
        Pedido pedidoCliente = new Pedido();

            System.out.println("Bem-vindo à Brasa Churrascaria!\nEscolha uma das opções abaixo:\n1 - Chamar o garçom\n2 - Sair");
            int opcao_Cliente = scanf.nextInt();
            if (opcao_Cliente == 1) {
                cliente1.chamarGarcom(garcom1);
                do {
                    menuAtendimento();
                    opcao_Cliente = scanf.nextInt();
                    switch (opcao_Cliente) {
                        case 1:
                            garcom1.mostrarCardapio();
                            break;
                        case 2, 4:
                            cliente1.setAtendido(true);
                            garcom1.anotarPedido(pedidoCliente);
                            chef1.preparaPedido(pedidoCliente);
                            break;
                        case 3:
                            if(pedidoCliente.getStatus() == "entregue"){
                                cliente1.pagar(pedidoCliente);
                                 if (cliente1.getPago()) {
                                    System.out.println("Obrigada pela preferência!\nVolte sempre");
                                    opcao_Cliente = 6;
                                 } else{
                                     System.out.println("Algo ocorreu mal. Tente novamente");
                                 }
                            } else {
                                System.out.println("Não é possível pagar um pedido que ainda não foi entregue...");
                             }
                            break;
                        case 5:
                            if(pedidoCliente.getStatus() == "Pronto"){
                                garcom1.entregaPedido(pedidoCliente);
                            } else{
                                System.out.println("Seu pedido ainda não está pronto :(");
                            }
                            break;

                        case 6:
                            if(cliente1.getAtendido() && !cliente1.getPago()){
                             System.out.println("Você não pode sair sem pagar a conta!\n");
                             opcao_Cliente = 0;
                            } else {
                                System.out.println("Agradecemos a visita!");
                            }
                            break;
                        default:
                            System.out.println("Opção inválida!");
                    }
                } while(opcao_Cliente != 6);

            } else if (opcao_Cliente == 2) {
                System.out.println("Agradecemos a visita!");
            } else {
                System.out.println("Opção Inválida!");
            }
    }
    public static void menuAtendimento(){
        System.out.println("Opções");
        System.out.println("1 - Ver o cardápio");
        System.out.println("2 - Fazer o pedido");
        System.out.println("3 - Pagar a conta");
        System.out.println("4 - Fazer novo pedido");
        System.out.println("5 - Receber pedido");
        System.out.println("6 - Sair");
    }
}
