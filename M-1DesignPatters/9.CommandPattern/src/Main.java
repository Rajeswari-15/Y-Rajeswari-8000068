public class Main {
    public static void main(String[] args) {
        Light l = new Light();
        RemoteControl r = new RemoteControl();

        r.set(new LightOn(l));
        r.press();
    }
}