class ProxyImage implements Image {
    RealImage img;
    String file;

    ProxyImage(String file) {
        this.file = file;
    }

    public void display() {
        if (img == null) {
            img = new RealImage(file);
        }
        img.display();
    }
}
