public enum Category {
    Blue("\033[0;34m"),
    Green("\033[0;32m"),
    Purple("\033[0;35m"),
    Red("\033[0;31m"),
    White("\033[0;37m"),
    Yellow("\033[0;33m");

    private String colour;

    Category(String c) {
        colour = c;
    }

    public String getColour() {
        return colour;
    }
}
