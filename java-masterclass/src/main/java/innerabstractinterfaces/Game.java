package innerabstractinterfaces;

public class Game implements ISaveable {

    private String title;
    private String type;
    private HardDrive hd;

    private int level = 0;

    public Game(String title, String type, HardDrive hd) {
        this.title = title;
        this.type = type;
        this.hd = hd;
    }

    @Override
    public void save() {
        hd.save(this);
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    @Override
    public String toString() {
        return "Game: \n" +
                "title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", level=" + level;
    }
}
