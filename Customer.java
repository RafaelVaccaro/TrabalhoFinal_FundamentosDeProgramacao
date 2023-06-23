public class Customer
{
    private String name;
    private String cpf;
    public Customer()
    {

    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return this.name;
    }

    public void setCpf(String cpf)
    {
        this.cpf = cpf;
    }

    public String getCpf()
    {
        String cpfFormat = "";
        int i = 0;
        while(i < 8)
        {
            cpfFormat += this.cpf.charAt(i);
            i++;
            cpfFormat += this.cpf.charAt(i);
            i++;
            cpfFormat += this.cpf.charAt(i);
            i++;    
            if(cpfFormat.length() < 9)
                cpfFormat += ".";

        }
        cpfFormat += "-";
        for ( int j = 9; j < this.cpf.length (); j++)
        {
            cpfFormat += this.cpf.charAt(j);
        }
        return cpfFormat;
    }

    public boolean validateCpf()
    {
        /*
         * a Fazer: quando usar throw new IllegalArgumentException queria que aparecesse na tela o aviso apenas ao invés de parar o programa
         * 
         */
        if(this.cpf.length() != 11)
        {
            throw new IllegalArgumentException("CPF INVÁLIDO");
        }
        String cpf= this.cpf.substring(0,9);
        boolean status = false;
        long a = 0;
        int b = 10;
        int firstSum = 0;
        int secondSum = 0;
        int firstRest;
        int secondRest;
        long cpfTenthDigit = Long.parseLong(this.cpf.substring(9,10)); //transforma o decimo digito do cpf em Long
        long cpfEleventhDigit = Long.parseLong(this.cpf.substring(10,11)); //transforma o decimo-primeiro digito do cpf em Long
        if(this.cpf.length() == 11){
            /*  1o loop :pega os nove primeiros digitos do cpf e multiplica por 2, 3, 4, ..., 10 da direita para esquerda, ou seja, começa do nono numero --  para descobrir o decimo
             *  2o loop :pega os dez primeiros digitos do cpf e multiplica por 2, 3, 4, ..., 11 da direita para esquerda, ou seja, começa do décimo numero --  para descobrir o decimo primeiro
             *  fonte : https://www.macoratti.net/alg_cpf.htm#:~:text=Algoritmo%20para%20valida%C3%A7%C3%A3o%20do%20CPF&text=O%20algoritmo%20de%20valida%C3%A7%C3%A3o%20do,d%C3%ADgito%2C%20obtido%20na%20primeira%20parte.
             */
            for(int i = 0; i < 9; i++){
                a = Long.parseLong(cpf.substring(i, i + 1));  
                a = a * b;
                firstSum += a;
                b--;
            }
            a = 0;
            b = 11;
            for(int j = 0; j < 10; j++){
                a = Long.parseLong(this.cpf.substring(j, j + 1));
                a = a * b;
                secondSum += a;
                b--;
            }
            firstRest = secondSum % 11;
            secondRest = secondSum % 11;
            
            firstRest = firstSum % 11;
            if((firstRest < 2 && cpfTenthDigit == 0) && (secondRest < 2 && cpfEleventhDigit == 0)){
                status = true;
            }
            else if((firstRest > 2 && cpfTenthDigit == 11 - firstRest ) && ( secondRest > 2 && cpfEleventhDigit == 11 - secondRest)){
                status = true;
            }
            
        }
        
        return status;
    }
}