import org.example.entity.Card;
import org.example.entity.Deck;
import org.example.entity.Suits;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class DeckTest {

    @Test
    public void checkShuffling(){
        // unshuffled deck
        ArrayList<Card> unShuffled = new ArrayList<>();

        for(Suits suits : Suits.values()){

            for(int i = 1; i <= 13; i++){
                unShuffled.add(new Card(i,suits));
            }

        }

        Deck deck = new Deck();
        ArrayList<Card> shuffled = deck.getDeck();
        // to check if the new deck created is shuffled or not.
        Assert.assertEquals(false,unShuffled.toString() == shuffled.toString());


    }






}
