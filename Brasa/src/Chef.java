public class Chef extends Funcionario{
    Prato bife_ancho = new Prato(1,"Bife Ancho", "Legumes salteados e o molho da casa", 79.99, 100);
    Prato fraldinha = new Prato(2, "Fraldinha", "Arroz branco, farofa da casa e molho de ervas", 74.80, 120);
    Prato alcatra = new Prato(3, "Alcatra", "Arroz branco, farofa da casa e molho de ervas", 74.90, 100);
    Prato chorizo = new Prato(4,"Bife de Chorizo", "Vinagrete da casa e batatas fritas", 72.40, 80);
    Prato picanha = new Prato(5,"Picanha", "Arroz branco, pão de alho e chimichurri", 92.80, 100);
    Prato file_mignon = new Prato(6, "Filé Mignon", "Batatas rústicas e salada do chef", 119.90, 100);
    Prato costelinha = new Prato(7, "Costelinha", "Molho barbecue e batata rústica", 82.40, 80);
    Prato linguica = new Prato(8,"Linguiça de Pernil", "Pão crocante, farofa da casa e chimichurri", 55.90, 70);
    Prato frango = new Prato(9,"Peito de Frango", "Salada do chef e molho de mostarda", 64.99, 70);

    public Prato[] cardapio = {bife_ancho, fraldinha, alcatra, chorizo, picanha, file_mignon, costelinha, linguica, frango};

    public Chef(){

    }

    public void preparaPedido(Pedido pedido){
        pedido.setStatus("Pronto");
    }

    public Prato setPedidoByRef(int ref){
        Prato prato_cliente = new Prato();
        switch (ref){
            case 1:
                prato_cliente = bife_ancho;
                break;
            case 2:
                prato_cliente = fraldinha;
                break;
            case 3:
                prato_cliente = alcatra;
                break;
            case 4:
                prato_cliente = chorizo;
                break;
            case 5:
                prato_cliente = picanha;
                break;
            case 6:
                prato_cliente = file_mignon;
                break;
            case 7:
                prato_cliente = costelinha;
                break;
            case 8:
                prato_cliente = linguica;
                break;
            case 9:
                prato_cliente = frango;
                break;
            default:
                System.out.println("Opção Inválida!");
        }
        return prato_cliente;
    }
}
