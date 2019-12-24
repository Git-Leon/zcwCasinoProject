package com.github.curriculeon.casino.games.mechanicalgames.slots;

import com.github.curriculeon.casino.profile.ProfileInterface;
import com.github.curriculeon.tools.Console;
import com.github.curriculeon.casino.games.mechanicalgames.MechanicalPlayer;

/**
 * Created by sarahweisser on 5/11/17.
 */
public class SlotPlayer extends MechanicalPlayer {

    private double bet = 5;

    public SlotPlayer(ProfileInterface profile) {
        super(profile);
    }


    public double getBet() {
        return bet;
    }

    public boolean placeBet() {
        //TODO - replace with super.createBetAmount() logic
        if (super.getProfile().getBalance() < 5) {
            Console.println("It is $5.00 to run this machine.");
            Console.println("You do not have enough in your account to run.");
            return false;
        } else {
            super.getProfile().decreaseBalance(5);
            return true;
        }
    }

    public void pullLever(SlotGame slotMachine) {
        slotMachine.spinReel();
    }


}
