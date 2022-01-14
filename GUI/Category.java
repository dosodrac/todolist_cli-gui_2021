public enum Category {
    Red("\033[0;31m"), White("\033[0;37m"), Blue("\033[0;34m"),
    Purple("\033[0;35m"), Yellow("\033[0;33m"), Green( "\033[0;32m");

    private String colour;

    Category(String c) {//category constructor
        colour = c;
    }

    public String getColour() {
        return colour;
    }
}
