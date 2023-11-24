public class Player {

    private GUI_Player guiPlayer;
    private String name;
    private Account Account;
    private Type type = Type.CAT;
    private int prisonCards;


    
   
    private TurnAction turnAction;
   
    public enum Type {
        CAT,
        DOG,
        CAR,
        BOAT;

         
        public static Type toEnum(String name)
        {
            try {
                return Type.valueOf(name.toUpperCase());
            } catch (Exception exception) {
                return Type.CAT;
            }
        }

       
        public static String[] valuesToString()
        {
            Type[] types = Type.values();
            String[] typesString = new String[types.length];

            for (int i = 0; i < types.length; i++) {
                typesString[i] = types[i].toString();
            }

            return typesString;
        }
    }

    
    
    public Player(String name)
    {
        this(name, 0);
    }

    
   
    public Player(String name, int startBalance)
    {
        this.name = name;

        this.stash = new Stash(startBalance);
        this.guiPlayer = new GUI_Player(this.name, this.stash.getAmount());
        this.prisonCards = 0;
    }

    public String getName()
    {
        return this.name;
    }

    
    public int getBalance()
    {
        return this.stash.getAmount();
    }

   
    public void addBalance(int balance)
    {
        this.stash.addAmount(balance);
        this.guiPlayer.setBalance(this.stash.getAmount());
    }

    
    public int getPrisonCard () {return this.prisonCards; }

    
    public int addPrisonCard (int numbersOfPrisonCards)
    {
        this.prisonCards += numbersOfPrisonCards;

        return this.prisonCards;
    }

    /
    public int removePrisonCard (int numbersOfPrisonCards)
    {
   
