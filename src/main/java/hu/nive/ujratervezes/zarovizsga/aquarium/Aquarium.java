package hu.nive.ujratervezes.zarovizsga.aquarium;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Aquarium {

    private List<Fish> fishList = new ArrayList<>();

    public void addFish(Fish fish) {
        fishList.add(fish);
    }

    public void feed() {
        for (Fish fish : fishList) {
            fish.feed();
        }
    }

    public void removeFish() {
        Iterator<Fish> it = fishList.iterator();
        Fish fish;
        while (it.hasNext()) {
            fish = it.next();
            if (fish.getWeight() > 10) {
                it.remove();
            }
        }
    }

    public List<String> getStatus() {
        List<String> result = new ArrayList<>();
        for (Fish fish : fishList) {
            result.add(fish.status());
        }
        return result;
    }

}

//Akvárium (Collections feladatrész, 20 pont, hozzá tartozó teszt: AquariumTest)
//Az Aquarium osztálynak az alábbi metódusai vannak:
//
//addFish(), amivel halakat lehet hozzáadni
//
//feed(), ami megeteti az összes halat az akváriumban, és ezzel megnöveli a súlyukat
//
//removeFish(), eltávolít minden olyan halat az akváriumból, ami legalább 11 grammos
//
//getStatus(), ami visszaadja a halak státuszát egy String listában
