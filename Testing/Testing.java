import org.junit.jupiter.api.Test;


public class Testing {

@Test
public void testIfPlayer1Wins(){
    Battle testBattle = new Battle();
    testBattle.player1.playerShipNumber = 3;
    testBattle.player2.playerShipNumber = 0;

    if(( testBattle.player1.playerShipNumber > 0) && (testBattle.player2.playerShipNumber <= 0)) {
        System.out.println("\nGood figth " +testBattle.player1.name + " !!! You won the battle!!!");
    }
}

@Test
public void testIfPlayer2Wins(){
        Battle testBattle = new Battle();
        testBattle.player1.playerShipNumber = 3;
        testBattle.player2.playerShipNumber = 0;

        if (testBattle.player2.playerShipNumber > 0 && testBattle.player1.playerShipNumber <=0){
            System.out.println("\nGood figth " + testBattle.player2.name + " !!! You won the battle!!!");
        }
    }
}


