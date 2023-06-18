import java.util.Scanner;
public class Garcom extends Funcionario{
    Chef chef = new Chef();
    Pagamento pgto = new Pagamento();
    Scanner scan = new Scanner(System.in);
    public Garcom(String nome, String cpf, int idFuncionario){
        this.nome = nome;
        this.cpf = cpf;
        this.idFuncionario = idFuncionario;
    }

    public void atender(){
        System.out.println("\nOlá!\nEu sou o " + nome + " e atenderei você hoje. Como posso ajudá-lo(a)?");
    }

    public void mostrarCardapio(){
        System.out.println(">>>>>>>> Cardápio <<<<<<<");
        for(int i = 0; i < chef.cardapio.length; i++) {
            System.out.println("Ref: " + chef.cardapio[i].ref);
            System.out.println("Prato: " + chef.cardapio[i].nomePrato);
            System.out.println("- " + chef.cardapio[i].ingredientes);
            System.out.println("R$ " + chef.cardapio[i].preco + "\n");
        }
    }

    public void mostrarAdicionais(){
        System.out.println(">>>>> Adicionais <<<<<");
        System.out.println("Qualquer adicional por apenas R$ 7,00. Aproveite!");
        System.out.println("1 - Batata frita");
        System.out.println("2 - Molho barbecue");
        System.out.println("3 - Molho chimichurri");
        System.out.println("4 - Vinagrete");
        System.out.println("5 - Pão de alho");
    }

    public void anotarPedido(Pedido pedido){
        mostrarCardapio();
        Prato pratoUsuario = anotaRefPedido(pedido);
        anotaQtdPedido(pratoUsuario, pedido);
        anotaAdicional(pedido);
        pedido.setStatus("Em preparação");

        pedido.setTotal(pgto.calculaConta(pedido));
        System.out.println("Pedido anotado!\n");
    }

    public Prato anotaRefPedido(Pedido pedido){
        int escolhaUsuario;
        Prato prato_cliente;

        do {
            System.out.println("Informe a referência (número) do Prato: ");
            escolhaUsuario = scan.nextInt();
            prato_cliente = chef.setPedidoByRef(escolhaUsuario);
            pedido.setPrato(prato_cliente);
        } while(escolhaUsuario < 1 || escolhaUsuario > 9);

        return prato_cliente;
    }

    public void anotaQtdPedido(Prato prato, Pedido pedido){
        System.out.println("Informe a quantidade desejada: ");
        int qtdUsuario = scan.nextInt();
            if (checaDisponibilidade(qtdUsuario, prato)) {
                pedido.setQuantidade(qtdUsuario);
                prato.disponibilidade -= pedido.getQuantidade();
            } else {
                System.out.println("Prato indisponível no momento. Por favor, escolha outra opção.");
            }
    }

    public void anotaAdicional(Pedido pedido){
        char adicional;
        do {
            mostrarAdicionais();
            System.out.println("Deseja algum adicional? (s/n)");
            adicional = scan.next().charAt(0);
            pedido.setAdicional(adicional);

            if (adicional == 's' || adicional == 'S') {
                 System.out.println("Informe a referência do adicional: ");
                 int refAdicional = scan.nextInt();

                 System.out.println("Informe a quantidade que deseja: ");
                 int qtdAdicional = scan.nextInt();
                 pedido.setQtdAdicional(qtdAdicional);
            } else if (adicional != 'n' && adicional != 'N') {
                System.out.println("Opção Inválida");
            }
        } while(adicional != 's' && adicional != 'S' && adicional != 'n' && adicional != 'N');

    }

    public boolean checaDisponibilidade(int qtd, Prato prato){
        if(qtd > prato.disponibilidade){
            return false;
        } else{
            return true;
        }
    }

    public void entregaPedido(Pedido pedido){
        pedido.setStatus("entregue");
        System.out.println("Pedido entregue.\nBom apetite!");
    }

}
