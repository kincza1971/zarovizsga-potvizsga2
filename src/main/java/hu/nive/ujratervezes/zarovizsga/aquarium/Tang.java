package hu.nive.ujratervezes.zarovizsga.aquarium;

public class Tang extends Fish{
    public Tang(String name, int weight, String colour) {
        super(name, weight, colour, true);
    }

    @Override
    public void feed() {
        super.incWeight(1);
    }
}
