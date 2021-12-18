package mayya.siv;

public enum SeriesNames {

    WITCHER("Ведьмак"),
    DEXTER("Декстер");

    private String name;

    SeriesNames(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
