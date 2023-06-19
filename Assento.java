public class Assento {
    private int[][] aviao = new int[10][2];
    
    public void printPlane() {
        //printar aviao
        for(int linhas = 0; linhas <= 10 -1 ; linhas++) {
            for(int colunas = 0; colunas <= 2 - 1; colunas++) {
                System.out.print(aviao[linhas][colunas]);
            }
        }
    }
}
// teste repositorio