public class Account {

    private int amount = 0;
    public Account()
    {

    }

    
    
    public Account(int startAmount)
    {
        this.amount = startAmount;
    }

  
    public void addAmount(int amount)
    {
        this.amount += amount;
    }

    
    
    public int getAmount()
    {
        return this.amount;
    }

}
