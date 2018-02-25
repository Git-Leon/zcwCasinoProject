package leon.tools;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public final class Console {
    public static final ConsoleSingleton console = new ConsoleSingleton(System.in, System.out);


    public static void print(String val, Object... args) {
        console.print(val, args);
    }

    public static void println(String val, Object... vals) {
        console.println(val, vals);
    }

    public static String getStringInput(String prompt, Object... args) {
        return console.getStringInput(prompt, args);
    }

    public static Double getDoubleInput(String prompt, Object... args) {
        return console.getDoubleInput(prompt, args);
    }

    public static Long getLongInput(String prompt, Object... args) {
        return console.getLongInput(prompt, args);
    }

    public static Integer getIntegerInput(String prompt, Object... args) {
        return console.getLongInput(prompt, args).intValue();
    }


    public static void printDashes() {
        repeatPrint(80, "-");
        println("");
    }

    public static void repeatPrint(int numberOfRepeats, String val) {
        print(StringUtils.repeatString(val, numberOfRepeats));
    }

    private static class ConsoleSingleton {
        private final Scanner input;
        private final PrintStream output;

        private ConsoleSingleton(InputStream in, PrintStream out) {
            this.input = new Scanner(in);
            this.output = out;
        }

        public void print(String val, Object... args) {
            output.format(val, args);
        }

        public void println(String val, Object... vals) {
            print(val + "\n", vals);
        }

        public String getStringInput(String prompt, Object... args) {
            println(prompt, args);
            return input.nextLine();
        }

        public Double getDoubleInput(String prompt, Object... args) {
            String stringInput = getStringInput(prompt, args);
            try {
                Double doubleInput = Double.parseDouble(stringInput);
                return doubleInput;
            } catch (NumberFormatException nfe) {
                println("[ %s ] is an invalid user input!", stringInput);
                println("Try inputting a numeric value!");
                return getDoubleInput(prompt, args);
            }
        }

        public Long getLongInput(String prompt, Object... args) {
            String stringInput = getStringInput(prompt, args);
            try {
                Long longInput = Long.parseLong(stringInput);
                return longInput;
            } catch (NumberFormatException nfe) {
                println("[ %s ] is an invalid user input!", stringInput);
                println("Try inputting an integer value!");
                return getLongInput(prompt, args);
            }
        }

        public Integer getIntegerInput(String prompt, Object... args) {
            return getLongInput(prompt, args).intValue();
        }
    }
}
