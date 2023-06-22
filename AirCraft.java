import java.util.Scanner;


public class AirCraft //tamanho 30 FILEIRAS | 6 ASSENTOS POR FILEIRA
{
    private Seats [][] seats;
    private int column;
    private int line;
  
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
        String choice = command.substring(0).toUpperCase();
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
        this.line = number - 1;
        if(this.seats[line][column].getAvailable()){
            System.out.println("Seu assento foi reservado");
            this.seats[line][column].setAvailable(false);
            
        }
        
    }
    public void print()
    {
        this.seats = seats;
        System.out.println("     A  B  C     D  E  F    ");
        for ( int i = 0; i < this.seats.length; i++)
        {
            if(i < 9)
                System.out.printf("  %d ", i + 1);
            else 
                System.out.printf(" %d ", i + 1);
            for ( int j = 0; j < seats[i].length; j++)
            {
                if (this.seats[i][j].getAvailable() == false) 
                //checa se o assento está disponivel (true)
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
            if(i < 9)
                System.out.printf(" %d", i + 1);
            else 
                System.out.printf(" %d", i + 1);
            System.out.println();
            if ( i == 11 || i == 12){
                System.out.println();
            }
        }
        
    }
}       

