import java.util.Arrays;
public class AirCraft
{
    public static void main (String [] args)
    {
        boolean [][] aircraft = new boolean [30][6];
        print(aircraft);
        
    }
    public static void print(boolean aircraft [][])
    {
        System.out.println("    A  B  C     D  E  F    ");
        for ( int i = 0; i < aircraft.length; i++)
        {
            for ( int j = 0; j < aircraft[i].length; j++)
            {
                if (aircraft[i][j])
                {
                    System.out.print("[O]");
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