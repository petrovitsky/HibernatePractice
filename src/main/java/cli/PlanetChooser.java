package cli;

import lombok.RequiredArgsConstructor;
import org.h2.command.dml.ExecuteProcedure;
import planet.Planet;

import java.util.Scanner;

@RequiredArgsConstructor
public class PlanetChooser {
    private final Scanner scanner;

    public Planet ask() {
        while (true) {
            String input = scanner.nextLine();
            try {
                return Planet.valueOf(input);
            } catch (Exception ex) {
                System.out.println("Planet " + input + " not found. Enter correct planet");
            }
        }
    }
}
