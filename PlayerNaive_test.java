import java.util.Arrays;
public class PlayerNaive_test {
    PlayerNaive naive = new PlayerNaive();

    public PlayerNaive_test() {

        if (leaveTokyoTest() && rerollDiceTest()) {
            System.out.println("Player naive test passed");
        } else {
            System.out.println("Player naive test failed");
        }
    }
    
    private boolean rerollDiceTest() {
        int[] testDice = new int[]{6, 6, 6, 6, 6, 6};
        boolean[] expectedOutput = new boolean[]{false, false, false, false, false, false};
        if (!Arrays.equals(naive.rerollDice(0,0,0,testDice,testDice, testDice), expectedOutput)) {
            return false;
        }
        
        testDice = new int[]{1, 1, 1, 1, 1, 1};
        expectedOutput = new boolean[]{true, true, true, true, true, true};
        if (!Arrays.equals(naive.rerollDice(0,0,0,testDice,testDice, testDice), expectedOutput)) {
            return false;
        }
        
        testDice = new int[]{1, 6, 1, 6, 1, 1};
        expectedOutput = new boolean[]{true, false, true, false, true, true};
        if (!Arrays.equals(naive.rerollDice(0,0,0,testDice,testDice, testDice), expectedOutput)) {
            return false;
        }

        return true;
    }
    
    private boolean leaveTokyoTest() {
        //health is 10, shouldn't leave tokyo
        int[] testDice = new int[]{1,1,1};
        naive.setHealth(10);
        if (naive.leaveTokyo(0,0,0,testDice,testDice, testDice) != false) {
            return false;
        }
        //health is 1, leave tokyo
        naive.setHealth(1);
        if (naive.leaveTokyo(0,0,0,testDice,testDice, testDice) != true) {
            return false;
        }
        naive.setHealth(10);
        return true;
    }
}