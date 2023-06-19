import java.util.Arrays;
public class AirCraft //tamanho 30 | 6
{
    public static void main (String [] args)
    {
        Seats seats = new Seats();
        boolean [][] aircraft = new boolean [30][6];
        
        
        //aircraft[3][3] = true;
        //printAircraft(aircraft);
        
        //LOOP PRINCIPAL
        while(true) {
            System.out.printf("bem-vindo ao comprador de passagens\nGostaria de comprar uma passaegem?\n[1] Voo3\n[2] Voo2\n[3] Voo1");
            break;
            
        }
        
    }
    public static void printAircraft(boolean aircraft [][])
    {
        System.out.println("   A  B  C     D  E  F    ");
        for ( int i = 0; i < aircraft.length; i++)
        {
            System.out.print(i + " ");
            for ( int j = 0; j < aircraft[i].length; j++)
            {
                if (aircraft[i][j] == true) //se true! 
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