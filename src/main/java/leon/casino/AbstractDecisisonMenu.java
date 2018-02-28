package leon.casino;

import leon.tools.Console;
import leon.tools.StringAssembler;
import leon.tools.StringUtils;

import java.util.Arrays;

/**
 * Created by leon on 2/25/18.
 */
public abstract class AbstractDecisisonMenu<T extends Enum> implements Menu {
    private final T[] decisions;

    public AbstractDecisisonMenu(T[] enumerations) {
        this.decisions = enumerations;
        try {
            for(T decision : enumerations) {
                assert (decision instanceof Decision);
            }
        } catch (AssertionError ae) {
            Console.println("The enumeration provided to the abstract class must implement the `Decision` interface");
            throw ae;
        }
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

    // TODO -
    public abstract T getInput();

    public void handleIllegalArgument(String input) {
        Console.println("Invalid input! %s is not valid input!", input);
        display();
    }
}
