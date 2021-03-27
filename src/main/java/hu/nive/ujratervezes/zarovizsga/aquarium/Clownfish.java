package hu.nive.ujratervezes.zarovizsga.aquarium;

public class Clownfish extends Fish{

    public Clownfish(String name, int weight, String colour) {
        super(name, weight, colour, false);
    }

    @Override
    public void feed() {
        super.incWeight(1);
    }
}
