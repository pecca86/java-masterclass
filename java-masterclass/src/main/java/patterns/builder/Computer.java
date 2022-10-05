package patterns.builder;

public class Computer {
    private String brand;
    private int mHz;
    private int ram;

    private boolean hasGraphicsCard;
    private boolean hasWifiAdapter;

    public String getBrand() {
        return brand;
    }

    public int getmHz() {
        return mHz;
    }

    public int getRam() {
        return ram;
    }

    public boolean hasGraphicsCard() {
        return hasGraphicsCard;
    }

    public boolean hasWifiAdapter() {
        return hasWifiAdapter;
    }

    private Computer(ComputerBuilder builder) {
        this.brand = builder.brand;
        this.mHz = builder.mHz;
        this.ram = builder.ram;
        this.hasWifiAdapter = builder.hasWifiAdapter;
        this.hasGraphicsCard = builder.hasGraphicsCard;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "brand='" + brand + '\'' +
                ", mHz=" + mHz +
                ", ram=" + ram +
                ", hasGraphicsCard=" + hasGraphicsCard +
                ", hasWifiAdapter=" + hasWifiAdapter +
                '}';
    }

    // Builder
    public static class ComputerBuilder {
        private String brand;
        private int mHz;
        private int ram;

        private boolean hasWifiAdapter;
        private boolean hasGraphicsCard;

        public ComputerBuilder(String brand, int mHz, int ram) {
            this.brand = brand;
            this.mHz = mHz;
            this.ram = ram;
        }

        public ComputerBuilder setHasWifiAdapter(boolean hasWifiAdapter) {
            this.hasWifiAdapter = hasWifiAdapter;
            return this;
        }

        public ComputerBuilder setHasGraphicsCard(boolean hasGraphicsCard) {
            this.hasGraphicsCard = hasGraphicsCard;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}
