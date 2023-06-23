import java.util.Scanner;

public class AirCraftApp
{
    public static void main(String[] args)
    {
        Seats seats = new Seats();
        
        AirCraft aircraft1 = new AirCraft();
        AirCraft aircraft2 = new AirCraft();
        AirCraft aircraft3 = new AirCraft();
        
        Customer customer = new Customer();
        Scanner in = new Scanner(System.in);
        String answer;
        String input;
        String buyInput;
        String cpfInput;
        String flightInput;

        System.out.printf("    __!__%n_____(_)_____%n   !  !  !%n%n");
        System.out.println("Bem vindo a compra e venda de passagens");
        System.out.println("=======================================");
        System.out.printf("Escolha seu voo:%n"); 
        System.out.println("[1]" + aircraft1.trajectory("POA-->SP ") + aircraft1.flightTime() + " 09:45-->11:20");
        System.out.println("[2]" + aircraft1.trajectory("POA-->RJ ") + aircraft1.flightTime() + " 05:30-->07:20");
        System.out.println("[3]" + aircraft1.trajectory("POA-->BSB ") + aircraft1.flightTime() + " 09:45-->12:15");
        

        //loop para a compra e a venda de passagens 
        do {
            input = in.next();
            if(input.startsWith("show"))
                aircraft1.print(); //printar avião 

            else if (input.startsWith("sell")) {
                boolean buying = true;
                while(buying) //loop quebra apenas quando a compra é feita.
                {

                    System.out.printf("Selecione seu assento [Letra][Num]%n");
                    aircraft1.sell(in.next());
                    String confirm = in.next();
                    
                    if (seats.getAvailable() == true)
                    {
                        if(confirm.startsWith("Sim") || confirm.startsWith("sim"))
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
