public class Die {

   
    private int numberOfSides;
  
   
    private int faceValue;

    
    public Die()
    {
        this(6);
    }

    
    
    public Die(int numberOfSides)
    {
        this.numberOfSides = numberOfSides;
    }

    public void roll()
    {
        this.faceValue = (int) (Math.random() * this.numberOfSides) + 1;
    }


   
    public int getFaceValue()
    {
        return this.faceValue;
    }


   
    public int getNumberOfSides()
    {
        return this.numberOfSides;
    }

}
