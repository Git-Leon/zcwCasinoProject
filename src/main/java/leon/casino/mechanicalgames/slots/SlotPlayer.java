package leon.casino.mechanicalgames.slots;

import leon.tools.Console;
import leon.casino.Profile;
import leon.casino.mechanicalgames.MechanicalPlayer;

/**
 * Created by sarahweisser on 5/11/17.
 */
public class SlotPlayer extends MechanicalPlayer {

    private double bet = 5;

    public SlotPlayer(Profile profile) {
        super(profile);
    }


    public double getBet() {
        return bet;
    }

    public boolean placeBet() {
        //TODO - replace with super.createBetAmount() logic
        if (super.profile.getBalance() < 5) {
            Console.println("It is $5.00 to play this machine.");
            Console.println("You do not have enough in your account to play.");
            return false;
        } else {
            super.profile.decreaseBalance(5);
            return true;
        }
    }

    public void pullLever(SlotMachine slotMachine) {
        slotMachine.spinReel();
    }


}
