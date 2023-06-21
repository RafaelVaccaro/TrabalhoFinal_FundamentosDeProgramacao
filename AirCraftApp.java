import java.util.Scanner;

public class AirCraftApp
{
    public static void main(String[] args)
    {

        AirCraft aircraft = new AirCraft();
        Scanner in = new Scanner(System.in);
        String answer;
        String input;
        String buyInput;
        System.out.println("Bem vindo a compra e venda de passagens");
        System.out.println("=======================================");
        System.out.printf("comandos:\n a show%n  sell\n   read\n   quit\n"); 

        //loop para a compra e a venda de passagens 
        do {
            input = in.next();
            if(input.startsWith("show"))
                aircraft.print(); //vai printar aviao etc etc para proximos        
            else if (input.startsWith("sell")) {

                System.out.printf("Selecione seu assento %n");
                aircraft.sell(in.next());
                System.out.printf("Confirme seu assento: Responda com [Sim] ou [Nao] %n");
                String confirmation = in.next();
                if(confirmation.startsWith("Sim"))
                {   
                    System.out.printf("Assento confirmado!");    
                }
                System.out.printf("Você deseja comprar mais algum assento?%n Responda com [Sim] ou [Não]");
                buyInput = in.next();
                if (buyInput.startsWith("s") || buyInput.startsWith("S"))
                {
                    System.out.printf("Selecione seu assento %n");
                    aircraft.sell(in.next());
                    System.out.printf("Confirme seu assento: Responda com [Sim] ou [Nao] %n");
                    answer = in.next();
                
                }
                else if(buyInput.startsWith("n") || buyInput.startsWith("N")){
                    System.out.println("Obrigado pela sua compra");
                    }

               
            }   

            else if (input.startsWith("read"))
                System.out.println("*voce leu*");
            else if (!input.startsWith("quit"))
                System.out.println("comando invalido");

        } while(!input.startsWith("quit"));
    }
}
