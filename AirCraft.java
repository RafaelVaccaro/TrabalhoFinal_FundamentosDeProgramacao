
import java.util.Scanner;
public class AirCraft //tamanho 30 FILEIRAS | 6 ASSENTOS POR FILEIRA
{
    private Seats [][] seats;
    private int column;
    private int line;
    private String confirmation;
    public AirCraft()
    {
        this.seats = new Seats[30][6];
        for(int i = 0; i < seats.length; i++)
        {
            for (int j = 0; j < seats[i].length; j++)
            {
                this.seats[i][j] = new Seats();
            }
        }
    }
    public void sell(String command)
    {
        System.out.println(command);
        String choice = command.substring(5).toUpperCase();
        System.out.println(choice);
        Scanner sc = new Scanner(System.in);
        char letter = choice.charAt(0);
        int number = Integer.parseInt(choice.substring(1));
        System.out.printf("Você escolheu a fileira %d e o assento %c?%n", number, letter);
        switch(letter)
        {
            case 'A':
                    this.column = 0;
                    break;
            case 'B':
                    this.column = 1;
                    break;
            case 'C':
                    this.column = 2;
                    break;
            case 'D':
                    this.column = 3;
                    break;
            case 'E':
                    this.column = 4;
                    break;
            case 'F':
                    this.column = 5;
                    break;
            
        }
        System.out.println("Confirme seu assento digitando [SIM] ou [NÃO]");
        
        confirm(sc.next());
    }
    public boolean confirm(String confirmation)
    {
        boolean status = true;
        this.confirmation = confirmation.toUpperCase(); 
        char c = this.confirmation.charAt(0);
         if(c == 'S')
         {
             status = true;
         }
         else if ( c == 'N')
         {
             status = false;
         }
         return status;
    }
    public void print()
    {
        this.seats = seats;
        System.out.println("   A  B  C     D  E  F    ");
        for ( int i = 0; i < this.seats.length; i++)
        {
            System.out.print(i + " ");
            for ( int j = 0; j < seats[i].length; j++)
            {
                if (this.seats[i][j].getAvailable() == true) //se true! 
                {
                    System.out.print("[$]");
                }// se estiver ocupado:
                else
                {
                    System.out.print("[ ]");    
                }
                if (j == 2)
                {
                    System.out.print("   ");
                }
            }
            System.out.println();
            if ( i == 11 || i == 12){
                System.out.println();
            }
        }
        System.out.println("    A  B  C     D  E  F    ");
    }
}       

