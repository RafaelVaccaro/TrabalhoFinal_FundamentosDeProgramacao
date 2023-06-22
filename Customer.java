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
    public String validateCpf()
    {
        if (this.cpf.length() != 11)
        {
            return "Cpf Invalido, por favor favor digite novamente";
        }
        return "Cpf Valido";
    }
}
