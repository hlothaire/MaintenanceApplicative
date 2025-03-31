package ui;

import java.time.LocalDateTime;
import java.time.temporal.WeekFields;
import java.util.Locale;
import java.util.Scanner;

public class TerminalUI {
    private final Scanner scanner = new Scanner(System.in);

    public void afficherBanniere() {
        println("  _____         _                   _                __  __");
        println(" / ____|       | |                 | |              |  \\\\  / |");
        println("| |       __ _ | |  ___  _ __    __| |  __ _  _ __  | \\\\  / |  __ _  _ __    __ _   __ _   ___  _ __");
        println("| |      / _` || | / _ \\| '_ \\  / _` | / _` || '__| | | \\\\/| | / _` || '_ \\  / _` | / _` | / _ \\| '__|");
        println("| |____ | (_| || ||  __/| | | || (_| || (_| || |    | |  | || (_| || | | || (_| || (_| ||  __/| |");
        println(" \\_____| \\__,_||_| \\___||_| |_| \\__,_| \\__,_||_|    |_|  |_| \\__,_||_| |_| \\__,_| \\__, | \\___||_|");
        println("                                                                                   __/ |");
        println("                                                                                  |___/");
    }

    public String readLine() {
        return scanner.nextLine();
    }

    public void println(String message) {
        System.out.println(message);
    }

    public String saisirChaine(String prompt) {
        println(prompt);
        return readLine();
    }

    public int saisirEntier(String prompt) {
        println(prompt);
        return Integer.parseInt(readLine());
    }

    public LocalDateTime saisirDateHeure(String prompt) {
        println(prompt);
        int annee = saisirEntier("Année (AAAA) :");
        int mois = saisirEntier("Mois (1-12) :");
        int jour = saisirEntier("Jour (1-31) :");
        int heure = saisirEntier("Heure (0-23) :");
        int minute = saisirEntier("Minute (0-59) :");
        return LocalDateTime.of(annee, mois, jour, heure, minute);
    }

    public LocalDateTime saisirDebutSemaine(String prompt) {
        println(prompt);
        int annee = saisirEntier("Année (AAAA) :");
        int semaine = saisirEntier("Numéro de semaine (1-52) :");
        return LocalDateTime.now()
                .withYear(annee)
                .with(WeekFields.of(Locale.FRANCE).weekOfYear(), semaine)
                .with(WeekFields.of(Locale.FRANCE).dayOfWeek(), 1)
                .withHour(0)
                .withMinute(0);
    }

    public void pause() {
        println("Appuyez sur Entrée pour continuer...");
        readLine();
    }
}

