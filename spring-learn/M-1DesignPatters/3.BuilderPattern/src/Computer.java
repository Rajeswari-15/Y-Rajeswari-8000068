class Computer {
    String cpu;
    int ram;
    int storage;

    private Computer(Builder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
    }

    static class Builder {
        String cpu;
        int ram;
        int storage;

        Builder setCPU(String cpu) {
            this.cpu = cpu;
            return this;
        }

        Builder setRAM(int ram) {
            this.ram = ram;
            return this;
        }

        Builder setStorage(int storage) {
            this.storage = storage;
            return this;
        }

        Computer build() {
            return new Computer(this);
        }
    }

    public void show() {
        System.out.println(cpu + " " + ram + "GB " + storage + "GB");
    }
}
