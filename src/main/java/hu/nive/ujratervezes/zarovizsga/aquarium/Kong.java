package hu.nive.ujratervezes.zarovizsga.aquarium;

public class Kong extends Fish{
    public Kong(String name, int weight, String colour) {
        super(name, weight, colour, false);
    }

    @Override
    public void feed() {
        super.incWeight(2);
    }
}
