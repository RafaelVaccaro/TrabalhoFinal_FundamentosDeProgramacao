import java.util.Arrays;
public class AirCraft //tamanho 30 | 6
{
    private Seats[][] seats = new Seats[30][6];
    
    
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
