package raw_data;

public class Engine {

    public int engineSpeed;
    public int enginePower;

    public Engine(int engineSpeed, int enginePower) {
        this.engineSpeed = engineSpeed;
        this.enginePower = enginePower;
    }

    public int getEnginePower() {
        return this.enginePower;
    }
}
