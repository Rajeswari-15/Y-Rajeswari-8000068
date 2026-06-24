class LightOn implements Command {
    Light l;

    LightOn(Light l) { this.l = l; }

    public void execute() {
        l.on();
    }
}