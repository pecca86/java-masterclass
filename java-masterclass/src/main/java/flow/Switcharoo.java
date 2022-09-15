package flow;

public class Switcharoo {

    public static void main(String[] args) {
        printWeekday(8);
    }

    public static void printWeekday(int day) {
        switch (day) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
            case 8: case 9: case 10:
                System.out.println("You are a retard.");
                break;
            default:
                System.out.println("No such weekday");
                break;
        }
    }
}
