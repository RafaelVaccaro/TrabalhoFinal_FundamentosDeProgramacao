import java.util.Scanner;

public class AirCraftApp
{
    public static void main(String[] args) throws Exception
    {
        Seats seats = new Seats();

        AirCraft aircraft1 = new AirCraft();
        AirCraft aircraft2 = new AirCraft();
        AirCraft aircraft3 = new AirCraft();
        int number;
        Customer customer = new Customer();
        Scanner in = new Scanner(System.in);

        String answer;
        String input;
        String buyInput;
        String cpfInput;
        String flightSelect;
        String finalizeConfirmation;

        aircraft1.ClearCmd();
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
            String choice = flightSelect.substring(0);
            number = Integer.parseInt(choice.substring(0));
            if (flightSelect.equals("4"))
            {
                aircraft1.ClearCmd();
                break;
            }

            AirCraft selectedAircraft;

            if (flightSelect.equals("1")) {
                selectedAircraft = aircraft1;
            } else if (flightSelect.equals("2")) {
                selectedAircraft = aircraft2;
            } else if (flightSelect.equals("3")) {
                selectedAircraft = aircraft3;
            } else {
                System.out.println("Opção inválida. Por favor, selecione uma opção válida.");
                continue;
            }

            System.out.println("Voce escolheu o voo: " + selectedAircraft.getTrajectory());
            System.out.printf("Comandos:%n  mostrar%n  comprar%n  sair%n");

            input = in.next();
            
            if(input.startsWith("mostrar")){
                selectedAircraft.read(number);    
                selectedAircraft.print();
            }
            else if (input.startsWith("comprar"))
            {
                selectedAircraft.read(number);
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
                            selectedAircraft.write(number);
                            System.out.printf("Você deseja comprar mais algum assento? %n Responda com [Sim] ou [Nao]%n%n");
                            buyInput = in.next();

                            if(buyInput.startsWith("Nao") || buyInput.startsWith("nao"))
                            {
                                System.out.println("Para o Checkout, informe o seu cpf");
                                customer.setCpf(in.next());
                                System.out.println("Informe seu primeiro nome:");
                                customer.setName(in.next());

                                System.out.println("Informe sua idade");
                                customer.setAge(in.nextInt());
                                if(customer.getAge() >= 18)
                                {
                                    System.out.printf(customer.getName() + ", o total de suas passagens foi de " + selectedAircraft.getPrice() + " R$");
                                    System.out.printf("obrigado por comprar conosco!%n%n%n%n");
                                    buying = false;
                                } else {
                                    System.out.printf(customer.getName() + ", o total de suas passagens foi de " + ((selectedAircraft.getPrice())/2) + " R$");
                                    System.out.printf("obrigado por comprar conosco!%n%n%n%n");
                                    buying = false;
                                }
                                System.out.printf(customer.getName() + ", o total de suas passagens foi de " + selectedAircraft.getPrice() + " R$");
                                System.out.printf("obrigado por comprar conosco!%n%n%n%n");
                                buying = false;
                                selectedAircraft.resetPrice();

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
            System.out.println("Gostaria de comprar mais passagens?");
            finalizeConfirmation = in.next();
            if (finalizeConfirmation.startsWith("n") || finalizeConfirmation.startsWith("N"))
            {
                break;
            }
        }
        aircraft1.ClearCmd();
        System.out.printf("obrigado por comprar conosco!%n%n%n%n");
    }
}
