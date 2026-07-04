class RemoteControl {
    Command c;

    void set(Command c) {
        this.c = c;
    }

    void press() {
        c.execute();
    }
}