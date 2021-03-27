package hu.nive.ujratervezes.zarovizsga.uniquefinder;

import java.util.LinkedList;
import java.util.List;

public class UniqueFinder {

    public List<Character> uniqueChars(String s) {
        if (s == null) {
            throw new IllegalArgumentException("Input parameter string cannot be null");
        }
        List<Character> chars = new LinkedList<>();
        for (char c : s.toCharArray()) {
            addIfUnique(chars,c);
        }
        return chars;
    }

    private void addIfUnique(List<Character> chars, char c) {
        for (char aChar : chars) {
            if(aChar == c) {
                return;
            }
        }
        chars.add(c);
    }
}

//Hozd létre a UniqueFinder osztályt, és abban a uniqueChars metódust, ami paraméternek kap egy String-et, és
// térjen vissza az abban levő karakterek listájával. Minden karakter csak egyszer szerepeljen a listában, az
// inputban nézett első előfordulásának megfelelő helyen.
//
//Ha a metódus null-t kap paraméterben, akkor dobj IllegalArgumentException-t!