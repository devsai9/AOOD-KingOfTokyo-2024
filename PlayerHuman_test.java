import java.util.Arrays;
public class PlayerHuman_test {
    PlayerHuman human = new PlayerHuman();
    
    public PlayerHuman_test() {

        if (leaveTokyoTest() && chooseDiceTest()) {
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }
    }
    
    private boolean leaveTokyoTest() {
        int[] testDice = new int[]{1,1,1};
        System.out.println("cheese,  , 123, then NO");
        if (human.leaveTokyo(0,0,0,testDice,testDice, testDice) != false) {
            return false;
        }
        
        System.out.println("y");
        if (human.leaveTokyo(0,0,0,testDice,testDice, testDice)!=true) {
            return false;    
        }
        System.out.println("n");
        if (human.leaveTokyo(0,0,0,testDice,testDice, testDice)!= false) {
            return false;
        }
        System.out.println("YES");
        if (human.leaveTokyo(0,0,0,testDice,testDice, testDice) != true) {
            return false;
        }
        
        return true;
    }
    
    private boolean chooseDiceTest() {
        int[] tempDice = {1, 2, 3, 4, 5, 4};
        boolean[] returnTest = {true, true, false, false, false, false};
        String returnTestString;
        
        System.out.println("1 2");
        // Note from Sai: You can't compare arrays with "==" in Java as it just compares memory locations
        // Import java.util.Arrays and use Arrays.equals() instead :)
        if (!Arrays.equals(human.rerollDice(0,0,0,tempDice,tempDice, tempDice), returnTest)) {
            return false;
        }
        
        System.out.println("8, 123, then 2");
        returnTest = new boolean[]{false, true, false, false, false, false};
        if (!Arrays.equals(human.rerollDice(0,0,0,tempDice,tempDice, tempDice), returnTest)) {
            return false;
        }
        
        System.out.println("4 6");
        returnTest = new boolean[]{false, false, false, true, false, true};
        if (!Arrays.equals(human.rerollDice(0,0,0,tempDice,tempDice, tempDice), returnTest)) {
            return false;
        }
        
        System.out.println("0");
        returnTest = new boolean[]{false, false, false, false, false, false};
        if (!Arrays.equals(human.rerollDice(0,0,0,tempDice,tempDice, tempDice), returnTest)) {
            return false;
        }
        
        System.out.println("7");
        returnTest = new boolean[]{true, true, true, true, true, true};
        if (!Arrays.equals(human.rerollDice(0,0,0,tempDice,tempDice, tempDice), returnTest)) {
            return false;
        }
        
        
        return true;
    }
}