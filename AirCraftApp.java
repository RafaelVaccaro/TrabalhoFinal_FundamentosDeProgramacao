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
            
            while (true) {
                System.out.printf("Escolha seu voo:%n"); 
                System.out.println("[1] " + aircraft1.trajectory("POA-->SP ") + aircraft1.setFlightTime(" 09:45-->11:20"));
                System.out.println("[2] " + aircraft2.trajectory("POA-->RJ ") + aircraft2.setFlightTime( " 05:30-->07:20"));
                System.out.println("[3] " + aircraft3.trajectory("POA-->BSB ") + aircraft3.setFlightTime(" 09:45-->12:15"));
                System.out.println("[4] Sair");
                
                flightSelect = in.next();
                
                if (flightSelect.equals("4"))
                {
                    System.out.println("Obrigado por Comprar conosco!");
                    break;
                }
                
                AirCraft selectedAircraft;
                String selectedFlight;
                
                if (flightSelect.equals("1")) {
                    selectedAircraft = aircraft1;
                    selectedFlight = aircraft1.getTrajectory();
                } else if (flightSelect.equals("2")) {
                    selectedAircraft = aircraft2;
                    selectedFlight = aircraft2.getTrajectory();
                } else if (flightSelect.equals("3")) {
                    selectedAircraft = aircraft3;
                    selectedFlight = aircraft3.getTrajectory();
                } else {
                    System.out.println("Opção inválida. Por favor, selecione uma opção válida.");
                    continue;
                }
                
                System.out.println("Voce escolheu o voo: " + selectedAircraft.getTrajectory());
                System.out.printf("Comandos:%n  show%n  buy%n  quit%n");
                
                input = in.next();
                
                if(input.startsWith("show"))
                    selectedAircraft.print();
                else if (input.startsWith("buy"))
                {
                    boolean buying = true;
                    while (buying) 
                    {
                        selectedAircraft.print();
                        System.out.printf("Selecione seu assento [Letra][Num]%n");
                        selectedAircraft.buy(in.next());
                        String confirm = in.next();
                        
                        if (seats.getAvailable() == true)
                        {
                            if(confirm.startsWith("Sim") || confirm.startsWith("sim"))
                            {   
                                selectedAircraft.confirmation(confirm);
                                System.out.printf("Assento confirmado!%n%n");
                                System.out.printf("Você deseja comprar mais algum assento? %n Responda com [Sim] ou [Nao]%n%n");
                                buyInput = in.next();
                                
                                if(buyInput.startsWith("Nao") || buyInput.startsWith("nao"))
                                {
                                    System.out.println("Para o Checkout, informe o seu cpf");
                                    customer.setCpf(in.next());
                                    System.out.println("Informe seu nome:");
                                    customer.setName(in.next());
                                    System.out.println(customer.getName() + ", o total de suas passagens foi de 5 reais");
                                    buying = false;      
    
                                }
                            }
                            else
                            {
                                    System.out.printf("Parece que houve um erro... Nos desculpe! %n%n");
                                    buying = false;
    
                            }
                        }
                    }
                    
                }
            }
    }
}
