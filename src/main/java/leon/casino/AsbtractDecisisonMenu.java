package leon.casino;

import leon.tools.Console;
import leon.tools.StringAssembler;

import java.util.Arrays;

/**
 * Created by leon on 2/25/18.
 */
public abstract class AsbtractDecisisonMenu<T extends Enum> implements Menu {
    private final T[] decisions;

    public AsbtractDecisisonMenu(T[] enumerations) {
        this.decisions = enumerations;
        assert (decisions[0] instanceof Decision);
    }

    public void display() {
        Console.println(toString());
    }

    public String toString() {
        return new StringAssembler("\n")
                .append("Welcome to the %s !", getClass().getSimpleName())
                .append("From here you can select any of the following options")
                .append(Arrays.toString(decisions))
                .toString();
    }

    public abstract T getInput();

    public void handleIllegalArgument(String input) {
        Console.println("Invalid input! %s is not valid input!", input);
        display();
    }
}
