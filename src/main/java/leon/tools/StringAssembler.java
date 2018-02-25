package leon.tools;

/**
 * Created by leon on 2/25/18.
 */
public class StringAssembler {
    private final StringBuilder stringBuilder;
    private final String delimiter;

    public StringAssembler(String delimiter) {
        this.stringBuilder = new StringBuilder();
        this.delimiter = delimiter;
    }

    public StringAssembler() {
        this("");
    }

    public StringAssembler append(String str, Object... args) {
        stringBuilder.append(String.format(str, args));
        stringBuilder.append(delimiter);
        return this;
    }

    public StringBuilder toStringBuilder() {
        return new StringBuilder(stringBuilder.toString());
    }

    public String toString() {
        return stringBuilder.toString();
    }
}
