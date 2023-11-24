public class ChanceCard 
    public void play(Game game)
    {
        game.getGui().displayChanceCard(this.description);

        this.action.run(game);
    }


   
  
