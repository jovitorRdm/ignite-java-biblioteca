package util;

import java.io.IOException;

public class ClearConsole {
    public static void clear() {
        try {
            if (System.getProperty("os.name").toLowerCase().contains("windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Para sistemas Unix-like (Linux/Mac)
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (IOException | InterruptedException ex) {
            System.out.println("Não foi possível limpar o terminal.");
        }
    }
}
