package hu.nive.ujratervezes.zarovizsga.aquarium;

public abstract class Fish {
    private final String name;
    private int weight;
    private final String colour;
    private final boolean memoryLoss;

    protected Fish(String name, int weight, String colour, boolean hasMemoryLoss) {
        this.name = name;
        this.weight = weight;
        this.colour = colour;
        this.memoryLoss = hasMemoryLoss;
    }
    public String status() {
        return name + ", weight: " + weight + ", color: " + colour + ", short term memory loss: " + memoryLoss;
    }
    public abstract void feed();

    protected void incWeight(int w) {
        weight += w;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public String getColor() {
        return colour;
    }

    public boolean hasMemoryLoss() {
        return memoryLoss;
    }
}

//Halak (OOP feladatrész, 20 pont, hozzá tartozó teszt: FishTest)
//Minden halnak van neve, súlya grammban és színe.
//
//Emellett minden hal számára elérhetőek az alábbi metódusok:
//
//status(): adja vissza a hal adatait egy Stringben, pl Dory, weight: 9, color: blue, short-term memory loss: true
//
//feed(): megnöveli a hal súlyát, a pontos implementáció a hal fajtájától függ.
//
//Clownfish
//A bohóchal 1 grammot hízik etetéskor.
//
//Tang
//A tang 1 grammot hízik etetéskor, és rövidtávú-memória zavarban szenvedhet.
//
//Kong
//A kong 2 grammot hízik etetéskor.
