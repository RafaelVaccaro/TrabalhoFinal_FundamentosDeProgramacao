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
        String flightSelect;

        System.out.printf("%n                    __!__%n                _____(_)_____%n                   !  !  !%n     %n");
        System.out.println("===============================================");
        System.out.println("Bem vindo a compra de passagens da 14-BIS Corp.");
        System.out.println("===============================================");
        System.out.printf("Escolha seu voo:%n"); 
        System.out.println("[1] " + aircraft1.trajectory("POA-->SP ") + aircraft1.flightTime() + " 09:45-->11:20");
        System.out.println("[2] " + aircraft1.trajectory("POA-->RJ ") + aircraft1.flightTime() + " 05:30-->07:20");
        System.out.println("[3] " + aircraft1.trajectory("POA-->BSB ") + aircraft1.flightTime() + " 09:45-->12:15");

        flightSelect = in.next();
        //loop para a compra e a venda de passagens 
        do {

            if (flightSelect.startsWith("1"))
            {
                System.out.printf("Comandos:%n  show%n  buy%n  quit%n  ");
                input = in.next();
                if(input.startsWith("show"))
                    aircraft1.print(); //printar avião 

                else if (input.startsWith("buy")) {
                    boolean buying = true;
                    while(buying) //loop quebra apenas quando a compra é feita.
                    {

                        System.out.printf("Selecione seu assento [Letra][Num]%n");
                        aircraft1.buy(in.next());
                        String confirm = in.next();

                        if (seats.getAvailable() == true)
                        {
                            if(confirm.startsWith("Sim") || confirm.startsWith("sim"))
                            {   
                                System.out.printf("Assento confirmado!%n%n");
                                System.out.printf("Você deseja comprar mais algum assento? %n Responda com [Sim] ou [Nao]%n%n");
                                buyInput = in.next();
                                if(buyInput.startsWith("Nao") || buyInput.startsWith("nao")){
                                    System.out.println("Para o Checkout, informe o seu cpf");
                                    customer.setCpf(in.next());
                                    System.out.println("Informe seu nome:");
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
            }
            else if (flightSelect.startsWith("2"))
            {
                System.out.printf("Comandos:%n  show%n  buy%n  quit%n  ");
                input = in.next();
                if(input.startsWith("show"))
                    aircraft2.print(); //printar avião 

                else if (input.startsWith("buy")) {
                    boolean buying = true;
                    while(buying) //loop quebra apenas quando a compra é feita.
                    {

                        System.out.printf("Selecione seu assento [Letra][Num]%n");
                        aircraft2.buy(in.next());
                        String confirm = in.next();

                        if (seats.getAvailable() == true)
                        {
                            if(confirm.startsWith("Sim") || confirm.startsWith("sim"))
                            {   
                                System.out.printf("Assento confirmado!%n%n");
                                System.out.printf("Você deseja comprar mais algum assento? %n Responda com [Sim] ou [Nao]%n%n");
                                buyInput = in.next();
                                if(buyInput.startsWith("Nao") || buyInput.startsWith("nao")){
                                    System.out.println("Para o Checkout, informe o seu cpf");
                                    customer.setCpf(in.next());
                                    System.out.println("Informe seu nome:");
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
            }
            else if (flightSelect.startsWith("3"))
            {
                System.out.printf("Comandos:%n  show%n  buy%n  quit%n  ");
                input = in.next();
                if(input.startsWith("show"))
                    aircraft3.print(); //printar avião 

                else if (input.startsWith("buy")) {
                    boolean buying = true;
                    while(buying) //loop quebra apenas quando a compra é feita.
                    {

                        System.out.printf("Selecione seu assento [Letra][Num]%n");
                        aircraft3.buy(in.next());
                        String confirm = in.next();

                        if (seats.getAvailable() == true)
                        {
                            if(confirm.startsWith("Sim") || confirm.startsWith("sim"))
                            {   
                                System.out.printf("Assento confirmado!%n%n");
                                System.out.printf("Você deseja comprar mais algum assento? %n Responda com [Sim] ou [Nao]%n%n");
                                buyInput = in.next();
                                if(buyInput.startsWith("Nao") || buyInput.startsWith("nao")){
                                    System.out.println("Para o Checkout, informe o seu cpf");
                                    customer.setCpf(in.next());
                                    System.out.println("Informe seu nome:");
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
            }   
            else if (!flightSelect.startsWith("quit"))
                System.out.println("comando invalido");

        } while(!flightSelect.startsWith("quit"));
    }
}
