package hu.nive.ujratervezes.zarovizsga.countchars;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class DaVinciCode {

    private static final String VALID_CODES = "01x";

    public int encode(String inputFileStr, char cToCount) {
        validateParameter2(cToCount);
        Path file = Path.of(inputFileStr);
        try (BufferedReader br = Files.newBufferedReader(file, StandardCharsets.UTF_8)){
            int c ;
            int counter =0;
            while ((c = br.read()) != -1) {
                if (c==cToCount) {
                    counter++;
                }
            }
            return counter;
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file");
        }
    }

    private void validateParameter2(char c) {
        if (VALID_CODES.contains(Character.toString(c))) {
            return;
        }
        throw new IllegalArgumentException("Invalide code");
    }
}

//Hozdd létre a DaVinciCode osztályt, és abban a decode metódust, ami paraméternek várja egy file elérési útját és a
// keresett karaktert, ami lehet '0', '1' vagy 'x'.
//
//Ha paraméterként nem ezen karakterek egyikét kapja, akkor dobjon egy kivételt!
//
//A fájl 0, 1 és x karaktereket tartalmaz. A metódus térjen vissza azzal, hogy a második paraméterben kapott
// karakter hányszor szerepel a fájlban.
