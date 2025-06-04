import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Connection connection = new Connection();

        int option = 0;

        System.out.println("Insira sua Chave ExchangeAPI:");
        String key = input.next();

        connection.grabData(key);


        while (option != 7) {
            String menuMessage = """
                    Selecione a transação desejada:
                        1) Real para Dólar
                        2) Real para Euro
                        3) Dólar para Real
                        4) Dólar para Euro
                        5) Euro para Dólar
                        6) Euro para real
                        7) Encerrar
                    """;

            System.out.println(menuMessage);
            option = input.nextInt();
            Operations operation = new Operations();
            CatchedCoins coins = new CatchedCoins(connection.grabData(key));
            switch (option){
                case 1:
                    operation.valueToReturn(coins.getUsd());
                    break;
                case 2:
                    operation.valueToReturn(coins.getEur());
                    break;
                case 3:
                    //operation.valueToReturn(coins.getBrl());
                    operation.valueToReturnReverse(coins.getBrl());
                    break;
                case 4:
                    operation.valueToReturnReverse(coins.getEur());
                    break;
                case 5:
                    //operation.valueToReturnReverse(coins.getBrl());
                    operation.valueToReturn(coins.getBrl());
                    break;
                case 6:
                    operation.valueToReturnReverse(coins.getUsd());
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente!");
                    break;
            }
            //deseja salvar suas conversões em um arquivo .csv?

        }


    }

}
