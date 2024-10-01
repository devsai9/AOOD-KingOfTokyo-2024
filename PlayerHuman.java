public class PlayerHuman extends Player {
    public PlayerHuman() {}
    
    public boolean[] rerollDice(int currentTurn, int currentPlayer, int inTokyo, int[] dice, int[] playerHealths, int[] playerFames) {
        boolean validRes = false;
        
        boolean[] ret = new boolean[]{false, false, false, false, false, false};
        
        while (!validRes) {
            System.out.println("Your Current Dice: ");
            for (int i = 0; i < dice.length; i++) {
                System.out.print(dice[i] + " ");
            }
            
            System.out.println("\n\nWhich dice would you like to re-roll? (1-6 separated by spaces; 0 to keep all dice; 7 to re-roll all): ");
            
            String[] userInput = Console.readLine().split(" ");
            
            if (userInput.length <= 0) {
                System.out.println("Invalid input: Please input numbers between 1 - 6 (inclusive) separated by space for what dice to keep, 0 to keep all dice, or 7 to re-roll all dice");
                continue;
            }
            
            validRes = true;
            for (int j = 0; j < userInput.length; j++) {
                if (userInput[j].equals(" ") || userInput[j].equals("")) {
                    System.out.println("Invalid input: Please input numbers between 1 - 6 (inclusive) separated by space for what dice to keep, 0 to keep all dice, or 7 to re-roll all dice");
                    validRes = false;
                    break;
                }
                
                try {
                    int temp = Integer.decode(userInput[j]);

                    if (temp == 7) {
                        ret = new boolean[]{true, true, true, true, true, true};
                        break;
                    } else if (temp == 0) {
                        if (userInput.length > 1) {
                            continue;
                        } else {
                            ret = new boolean[]{false, false, false, false, false, false};
                            break;
                        }
                    } else if (temp >= 1 && temp <= 6) {
                        ret[temp-1] = true;
                    } else {
                        validRes = false;
                        System.out.println("Invalid input: Please input numbers between 1 - 6 (inclusive) separated by space for what dice to keep, 0 to keep all dice, or 7 to re-roll all dice");
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input: Please input numbers between 1 - 6 (inclusive) separated by space for what dice to keep, 0 to keep all dice, or 7 to re-roll all dice");
                    validRes = false;
                    break;
                }
            }
        }
        
        // True: Re-roll; False: Keep
        return ret;
    }
    
    public boolean leaveTokyo(int currentTurn, int currentPlayer, int inTokyo, int[] dice, int[] playerHealths, int[] playerFames) { 
        // Selection method to leave Tokyo
        boolean validRes = false;
        boolean returnValue = false;
        
        while(!validRes) {
            System.out.println("Would you like to leave Tokyo (y/n)");
            String userInput = Console.readLine().toLowerCase();
            if (userInput.equals("y") || userInput.equals("yes")) {
                validRes = true;
                returnValue = true;
                System.out.println("You have left Tokyo!");
            } else if (userInput.equals("n") || userInput.equals("no")) {
                validRes = true;
                returnValue = false;
            } else {
                validRes = false;
                System.out.println("Invalid input: Please input either y for Yes or n for No.");
            }
        }
        
        return returnValue;
    }
}
