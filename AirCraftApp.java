import java.util.Scanner;

public class AirCraftApp
{
    public static void main(String[] args)
    {
        Seats seats = new Seats();
        AirCraft aircraft = new AirCraft();
        Customer customer = new Customer();
        Scanner in = new Scanner(System.in);
        String answer;
        String input;
        String buyInput;
        String cpfInput;

        System.out.printf("    __!__%n_____(_)_____%n   !  !  !%n%n");
        System.out.println("Bem vindo a compra e venda de passagens");
        System.out.println("=======================================");
        System.out.printf("comandos:\n  show%n  sell\n  quit\n"); 

        //loop para a compra e a venda de passagens 
        do {
            input = in.next();
            if(input.startsWith("show"))
                aircraft.print(); //printar avião 

            else if (input.startsWith("sell")) {
                boolean buying = true;
                while(buying) //loop quebra apenas quando a compra é feita.
                {

                    System.out.printf("Selecione seu assento [Letra][Num]%n");
                    aircraft.sell(in.next());

                    if (seats.getAvailable() == true)
                    {
                        if(aircraft.confirmation(in.next()).startsWith("Sim"))
                        {   
                            System.out.printf("Assento confirmado!%n%n");
                            System.out.printf("Você deseja comprar mais algum assento? %n Responda com [Sim] ou [Nao]%n%n");
                            buyInput = in.next();
                            if(buyInput.startsWith("Nao") || buyInput.startsWith("nao")){
                                System.out.println("Para o Checkout, informe o seu cpf e depois seu nome:");
                                customer.setCpf(in.next());
    
                                customer.setName(in.next());
                                System.out.println(customer.getName() + ", o total de suas passagens foi de 5 reais");
                                buying = false;       

                            }
                        }
                        else{
                            System.out.printf("Parece que houve um erro... Nos desculpe! %n%n");
                            buying = false;

                        }
                    }
                }
            }   
            else if (!input.startsWith("quit"))
                System.out.println("comando invalido");

        } while(!input.startsWith("quit"));
    }
}
