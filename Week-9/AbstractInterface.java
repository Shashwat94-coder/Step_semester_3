abstract class Vehicle {
    abstract void start();

    void stop() {
        System.out.println("Vehicle stopped");
    }
}

interface Electric {
    void charge();
}

class ElectricCar extends Vehicle implements Electric {
    @Override
    void start() {
        System.out.println("Electric car started");
    }

    @Override
    public void charge() {
        System.out.println("Electric car charging");
    }
}

class Main {
    public static void main(String[] args) {
        ElectricCar car = new ElectricCar();

        car.start();
        car.charge();
        car.stop();
    }
}