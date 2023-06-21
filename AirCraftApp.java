import java.util.Scanner;

public class AirCraftApp
{
    public static void main(String[] args)
    {

        AirCraft aircraft = new AirCraft();
        Scanner in = new Scanner(System.in);

        
        String input;
        String buyInput;
        System.out.println("Bem vindo a compra e venda de passagens");
        System.out.println("=======================================");
        System.out.printf("comandos:\n   sell\n   buy\n   read\n   quit\n"); 
        
        //loop para a compra e a venda de passagens 
        do {
            input = in.next();
            if(input.startsWith("show"))
                aircraft.print(); //vai printar aviao etc etc para proximos        
            else if (input.startsWith("sell")) {
                do {
                    aircraft.sell(in.next());
                    System.out.println("*assentos:*");
                } while   (!input.startsWith("quit"));
            }   
                
            else if (input.startsWith("read"))
                System.out.println("*voce leu*");
            else if (!input.startsWith("quit"))
                System.out.println("comando invalido");
            
        } while(!input.startsWith("quit"));
    }
}
