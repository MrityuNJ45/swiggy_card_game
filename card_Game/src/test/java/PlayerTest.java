import org.example.entity.Card;
import org.example.entity.Player;
import org.example.entity.Suits;
import org.junit.Assert;
import org.junit.Test;

public class PlayerTest {

    /* testing for checking if cards are added to player's
       hand or not.
     */

    @Test
    public void addingPlayerCard(){

        Card c = new Card(1,Suits.CLUBS);
        Player p = new Player(0);
        p.addCard(c);
        int ans = p.giveCards().size();
        Assert.assertEquals(1,ans);


    }

    @Test
    public void removingPlayerCard(){

        Card c = new Card(1,Suits.CLUBS);
        Player p = new Player(0);
        p.addCard(c);
        p.removeCard(c);
        int ans = p.giveCards().size();
        Assert.assertEquals(0,ans);


    }


}
