public class BuildingField extends Field {

   
    private int rent;

   
    private Player owner;

   
    private Color type;



  
    public BuildingField(String title, int rent, Color type)
    {
        super(title);

        this.setDescription("");
        this.setSubText("");

        this.setBackgroundColor(type);
        this.setForegroundColor(Color.BLACK);

        this.rent = rent;
        this.type = type;

        this.getGuiField().setRent("M" + this.rent);
    }


  
    @Override
    protected GUI_Street createGUIFIeld()
    {
        return new GUI_Street();
    }


   
    @Override
    public GUI_Street getGuiField()
    {
        return (GUI_Street) this.guiField;
    }


    public Color getType()
    {
        return this.type;
    }

    public int getRent()
    {
        return this.rent;
    }


   
    public void buyProperty(Player player)
    {
        this.setOwner(player);

        player.addBalance(-this.getRent());
    }


   
    public void payRent(Board board, Player player)
    {
        BuildingField[] fields = board.getFieldsByTypes(this.type);

        for (BuildingField field : fields) {
            if (field.isOwnedByPlayer(this.owner)) {
                player.addBalance(-this.getRent());
                this.owner.addBalance(this.getRent());
            }
        }
    }

    public void payRentInt(Board board, Player player)
    {
        BuildingField[] fields = board.getFieldsByTypes(this.type);

        for (BuildingField field : fields) {
            if (field.isOwnedByPlayer(this.owner)) {
                player.addBalance(-this.getRent());
                this.owner.addBalance(this.getRent());
            }
        }
    }


   
    public boolean isOwned()
    {
        return this.owner != null;
    }


    
    public boolean isOwnedByPlayer(Player player)
    {
        return this.owner == player;
    }


    public void setOwner(Player player)
    {
        this.owner = player;

        this.getGuiField().setOwnerName(player.getName());
        this.getGuiField().setBorder(player.getGuiPlayer().getPrimaryColor());
    }


    public Player getOwner()
    {
        return this.owner;
    }


    @Override
    public void runAction(Game game)
    {
        Player player = game.getPlayers().getCurrentPlayer();

        if (! this.isOwned()) {
            this.buyProperty(player);
            game.getGui().showMessage("Dette felt har ingen ejer, " + player.getName() + " køber dette felt for " + this.getRent() + "M");
        } else if (! this.isOwnedByPlayer(player)) {
            this.payRent(game.getBoard(), player);
            game.getGui().showMessage("Dette felt tilhører " + this.owner.getName() + ", som derfor tjener " + this.getRent() + "M fra " + player.getName());
        }
    }

}

