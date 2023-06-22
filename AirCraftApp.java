import java.util.Scanner;

public class AirCraftApp
{
    public static void main(String[] args)
    {

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
                aircraft.print();
                boolean buying = true;
                while(buying) //loop quebra apenas quando a compra é feita.
                {
                    
                    System.out.printf("Selecione seu assento [Letra][Num]%n");
                    aircraft.sell(in.next());
                    
                    if (aircraft.ocupied == false)
                    {
                        System.out.printf("Confirme seu assento: Responda com [Sim] ou [Nao] %n");
                        String confirmation = in.next(); //vai confirmar o assento;
                        if(confirmation.startsWith("S") || confirmation.startsWith("s"))
                        {   
                            System.out.printf("Assento confirmado!%n%n");    
                        }
                        if(confirmation.startsWith("N") || confirmation.startsWith("n"))
                        {
                            System.out.printf("Assento Cancelado%n");
                        }
                    }

                    System.out.printf("Você deseja comprar mais algum assento?%n Responda com [Sim] ou [Não]%n%n");
                    buyInput = in.next();
                    if(buyInput.startsWith("n") || buyInput.startsWith("N")){
                        System.out.println("Para o Checkout, informe o seu cpf e depois seu nome:");
                        customer.setCpf(in.next());
                        System.out.println(customer.validateCpf());
                        customer.setName(in.next());
                        System.out.println(customer.getName() + ", o total de suas passagens foi de 5 reais");
                        buying = false;                        
                    }
                }
            }   
            else if (!input.startsWith("quit"))
                System.out.println("comando invalido");

        } while(!input.startsWith("quit"));
    }
}
