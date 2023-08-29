public enum Color {
    RED("red", 7),
    BLACK("black",3),
    GREEN("green", 11),
    WHITE("white", 0);

    public final String color;
    public final int ordinal;

    Color(String color, int ordinal) {
        this.color = color;
        this.ordinal = ordinal;
    }
}
