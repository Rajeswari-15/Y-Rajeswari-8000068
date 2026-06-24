class RealImage implements Image {
    String file;

    RealImage(String file) {
        this.file = file;
        load();
    }

    void load() {
        System.out.println("Loading " + file);
    }

    public void display() {
        System.out.println("Displaying " + file);
    }
}
