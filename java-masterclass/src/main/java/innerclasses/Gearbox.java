package innerclasses;

import java.util.ArrayList;
import java.util.List;

public class Gearbox {
    private List<Gear> gears = new ArrayList<>();
    private List<PrivateGear> privateGears = new ArrayList<>();

    public Gearbox() {
        Gear neutral = new Gear(0);
        this.gears.add(neutral);
    }

    public void addPrivateGear(int gear, String name) {
        privateGears.add(new PrivateGear(gear, name));
    }

    @Override
    public String toString() {
        return "Gearbox{" +
                "gears=" + gears +
                ", privateGears=" + privateGears +
                '}';
    }

    private class PrivateGear {
        private int gear;
        private String humanReadable;

        public PrivateGear(int gear, String humanReadable) {
            this.gear = gear;
            this.humanReadable = humanReadable;
        }

        @Override
        public String toString() {
            return "PrivateGear{" +
                    "gear=" + gear +
                    ", humanReadable='" + humanReadable + '\'' +
                    '}';
        }
    }

    public class Gear {
        private int gearStep;
        public Gear() {
        }

        public Gear(int gearStep) {
            this.gearStep = gearStep;
        }

        @Override
        public String toString() {
            return "Gear{" +
                    "gearStep=" + gearStep +
                    '}';
        }
    }
}
