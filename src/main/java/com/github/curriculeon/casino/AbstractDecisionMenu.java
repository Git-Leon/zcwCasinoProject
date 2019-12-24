package com.github.curriculeon.casino;

import com.github.curriculeon.tools.Console;
import com.github.curriculeon.tools.StringAssembler;
import com.github.curriculeon.tools.StringUtils;

import java.util.Arrays;

/**
 * Created by leon on 2/25/18.
 */
public abstract class AbstractDecisionMenu<SomeDecision extends Enum<SomeDecision> & DecisionInterface> implements Menu {
    private final SomeDecision[] decisions;

    public AbstractDecisionMenu(SomeDecision[] decisions) {
        this.decisions = decisions;
    }

    public String getInputFromUser() {
        String border = StringUtils.repeatString("-", 50);
        Console.println(border);
        display();
        Console.println("Select an option.");
        return Console.getStringInput().toUpperCase();
    }

    public final void display() {
        Console.println(toString());
    }

    public String toString() {
        return new StringAssembler("\n")
                .append("Welcome to the %s !", getClass().getSimpleName())
                .append("From here you can select any of the following options:")
                .append(Arrays.toString(decisions))
                .toString();
    }

    @SuppressWarnings("all")
    public  SomeDecision getValueOf(String userInput) {
        return (SomeDecision) SomeDecision.valueOf(decisions[0].getClass(), userInput
                .replace(" ", "_")
                .toUpperCase());
    }

    // TODO -
    public final SomeDecision getInput() {
        return getValueOf(getInputFromUser());
    }

    public void handleIllegalArgument(String input) {
        Console.println("Invalid input! %s is not valid input!", input);
        display();
    }
}
