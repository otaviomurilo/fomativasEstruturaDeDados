import java.util.*;

public class Restaurant {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> order = new ArrayList<>();
        List<Integer> subtotal = new ArrayList<>();
        boolean pursue = true;
        String name = "";

        while (true) {

            System.out.println("Menu - Selecione sua opção");
            System.out.println("1 - Fazer pedido");
            System.out.println("2 - Sair");
            int answer = scanner.nextInt();
            scanner.nextLine();
            
            if (answer == 2) {
                System.out.println("Até mais!");
                break; // encerra o programa
            }
            
            if (answer == 1 && name.isEmpty()) {
                System.out.println("Insira seu nome:");
                name = scanner.nextLine();
                System.out.printf("Bem-vindo, %s!%n", name); //%s --> marca posicao da string
                                                                    // %n --> nova linha
            }
            
            while (pursue) {
                System.out.println("Cardápio:");
                System.out.println("0 - Finalizar pedido");
                System.out.println("1 - Bife Acebolado - R$40");
                System.out.println("2 - Frango à Milanesa - R$35");
                System.out.println("3 - Peixe Assado - R$28");
                System.out.println("4 - Chicken Salad - R$25");

                
                int choice = scanner.nextInt();
                scanner.nextLine(); 
                
                switch (choice) {
                    case 0:
                        pursue = false;
                        break; 
                    case 1:
                        order.add("Bife Acebolado - R$40");
                        subtotal.add(40);
                        break;
                    case 2:
                        order.add("Frango à Milanesa - R$35");
                        subtotal.add(35);
                        break;
                    case 3:
                        order.add("Peixe Assado - R$28");
                        subtotal.add(28);
                        break;
                    case 4:
                        order.add("Chicken Salad - R$25");
                        subtotal.add(25);
                        break;

                    default:
                        System.out.println("Opção inválida! Tente novamente!");
                }
            }
            
            System.out.println("Pedido finalizado. Você escolheu:");
            int sum = 0;

            for (String item : order) {
                System.out.println("- " + item);
            }
            for (Integer itemValue : subtotal) {
                sum += itemValue;
            }

            double tip = sum * 0.10; //calcula taxa de serviço
            double total = sum + tip;

            System.out.println("Subtotal: R$" + sum);
            System.out.println("Taxa de serviço (10%): R$" + String.format("%.2f", tip)); 
            System.out.println("Total a pagar: R$" + String.format("%.2f", total));
            

            double payment;
            do {
                System.out.println("Digite o valor em dinheiro para pagamento:");
                payment = scanner.nextDouble();
                if (payment < total) {
                    System.out.println("Valor insuficiente! Forneça um valor maior ou igual a R$" + String.format("%.2f", total));
                }
            } while (payment < total);
            
            double change = payment - total;
            System.out.println("Pagamento recebido: R$" + String.format("%.2f", payment));
            System.out.println("Troco: R$" + String.format("%.2f", change));
            System.out.printf("Agradecemos seu pedido, %s!%n", name); 
            System.out.println("Volte sempre!");

            order.clear(); //limpar a lista de pedidos 
            subtotal.clear();
            pursue = true; // retorna ao menu inicial
        
        }

        scanner.close();
    }
}
