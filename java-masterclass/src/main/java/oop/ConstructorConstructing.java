package oop;

public class ConstructorConstructing {
    private String name;
    private Boolean activeStatus;

    /**
     * No args constructor creating the object using the args constructor with default values
     */
    public ConstructorConstructing() {
        this("Unnamed", false);
    }

    public ConstructorConstructing(String name, Boolean activeStatus) {
        this.name = name;
        this.activeStatus = activeStatus;
    }

    public String getName() {
        return name;
    }

    public Boolean getActiveStatus() {
        return activeStatus;
    }

    public static void main(String[] args) {
        ConstructorConstructing cc = new ConstructorConstructing();
        System.out.println(cc.getName() + " " + cc.getActiveStatus());
    }
}
