import java.util.Scanner;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.io.FileInputStream;
import java.io.PrintStream;
import java.io.FileOutputStream;

public class AirCraft //tamanho 30 FILEIRAS | 6 ASSENTOS POR FILEIRA
{
    private Seats [][] seats;
    private int column;
    private int line;
    private Date date;
    private DateFormat dateFormat;
    private String trajectory;
    private String flightTime;
    public int price;
    
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
    public void buy(String command)
    {
        String choice = command.substring(0).toUpperCase();
        char letter = choice.charAt(0);
        int number = Integer.parseInt(choice.substring(1));
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
        System.out.printf("Você escolheu a fileira %d e o assento %c?%n Responda com [Sim] ou [Nao]. %n%n", number, letter);

       
    }
    public void write() throws Exception {
        PrintStream file = new PrintStream(new  FileOutputStream("datas.txt"));
        for (int i = 0; i < this.seats.length; i++) {
            for (int j = 0; j < this.seats[i].length; j++) {            
                    file.print(this.seats[i][j].getAvailable()+" ");
            }
            file.println();
        }
        file.close();
    }    
    
    public String confirmation(String confirm)
    {
        if(confirm.startsWith("Sim") || confirm.startsWith("sim")){
            if(this.seats[line][column].getAvailable())
            {
                this.seats[line][column].setAvailable(false);
            
            } 
            else{
             throw new IllegalArgumentException("Assento já reservado");   
            }
        }
        
        return confirm;        
    }
    public void read() throws Exception {
        FileInputStream file = new FileInputStream("datas.txt");
        Scanner in = new Scanner(file);
        for (int i = 0; i < this.seats.length; i++) {
            for (int j = 0; j < this.seats[i].length; j++) {   
                this.seats[i][j] = new Seats();
                this.seats[i][j].setAvailable(in.nextBoolean());
            }
        }
        in.close();
        file.close();            
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
                    //precificador
                    if (i <= 3)
                        price += 1500;
                    else
                        price += 700;
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
            if ( i == 3 || i == 12){
                System.out.println();
            }
            this.price = price;
        }
        
    }
    public int getPrice()
    {
        return price;
    }
    public String setFlightTime(String fTime) 
    {
        this.flightTime = fTime;
        return flightTime;
    }
    public String getFlightTime()
    {
        return flightTime;
    }
    public String trajectory(String t)
    {
        this.trajectory = t;
        return trajectory;
    }
    public String getTrajectory()
    {
        return trajectory;
    }
    public void ClearCmd()
    {
        for (int i=0; i<=100; i++)
        {
            System.out.println("");
        }
    }
}       

