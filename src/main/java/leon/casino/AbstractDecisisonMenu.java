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
        for (T decision : enumerations) {
            if (!(decision instanceof Decision)) {
                String errorMessage = "The enumeration provided to the abstract class must implement the `Decision` interface";
                throw new Error(errorMessage);
            }
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

    @Override
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
