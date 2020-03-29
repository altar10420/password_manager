package com.connectis.manager;

/*
Napisz program, który posłuży Ci jako menadżer haseł.
Program powinien mieć następujące funkcjonalności:

- Po podaniu adresu strony oraz nazwy użytkownika program zwraca zapisane dla danego loginu hasło
- Jeśli dla takiej domeny/loginu program nie posiada hasła, użytkownik otrzymuje odpowiedni komunikat
- Program potrafi na żądanie wygenerować nowe hasło (losowy ciąg znaków alfanumerycznych,
 można zaimplementować samemu lub użyć jakiegoś gotowego rozwiązania z sieci)
- Użytkownik ma możliwość dodania nowego hasła dla wybranej pary domena/login
    - Program nie przyjmuje duplikatów. Jeśli wpis istnieje, powinien poprosić użytkownika
     o to czy chce nadpisać hasło.
- Program potrafi wyświetlić pełny raport, posortowany po adresach domen,
 a następnie po loginach. Raport wyświetla Adres domeny, Login oraz zapamiętane hasło
- Wszystkie dane trzymamy w pamięci w odpowiednich strukturach danych (tj. bez bazy danych)
    - Dla chętnych: dane trzymane w pliku, podczas startu aplikacji,
     jeśli taki plik istnieje, program wczytuje zapisane dane z tego pliku (persystencja)
 */

/*
    private static String wczytajZnaki() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine();
    }
 */

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

public class MainManager {

    public static void main(String[] args) throws IOException {


        Database database = readCSVdatabase("/manager.csv");

//        CarRepository database = new CarRepository();
//
//        database.addDatabaseEntry("www", "user", null);

        System.out.println(database);

        boolean running = true;

        while(running) {

            System.out.println("\nWelcome to password manager. Choose your option");
            System.out.println("1 - create new user on domain entry");
            System.out.println("2 - show all");
            System.out.println("3 - enter domain and username to retrieve a password ");
            System.out.println("4 - change username password");
            System.out.println("5 - generate report");
            System.out.println("0 - exit manager\n");

            String userInput = readUserInput();
            String userInputDomain;
            String userInputLogin;
            String userInputPassword;

            switch (userInput) {
                case "1":
                    System.out.println("Enter domain address:");
                    userInputDomain = readUserInput();
                    System.out.println("Enter user login:");
                    userInputLogin = readUserInput();
                    if (database.checkIfEntryExist(userInputDomain, userInputLogin)) {
                        System.out.println("User already exists. Please try another one.");
                        continue;
                    } else {

                        System.out.println("Enter password:");
                        userInputPassword = readUserInput();
                        database.addDatabaseEntry(userInputDomain, userInputLogin, userInputPassword);
                        continue;
                    }

                case "2":
                    System.out.println(database.getDomainUserKeyPasswordMap());
                    System.out.println("Press any key to return.");
                    userInputDomain = readUserInput();
                    continue;

                case "3":
                    System.out.println("Enter domain address:");
                    userInputDomain = readUserInput();
                    System.out.println("Enter user login:");
                    userInputLogin = readUserInput();

                    if (!database.checkIfEntryExist(userInputDomain, userInputLogin)) {
                        System.out.println("Wrong domain or user name. Please try again.");
                        continue;
                    }

                    Optional<String> password = database.getDomainUserPassword(userInputDomain, userInputLogin);

                    if (password.isPresent()) {
                        System.out.println(password);
                    } else {
                        System.out.println("Password does not exist. Please choose another option.");
                    }

                    continue;

                case "4":
                    System.out.println("Enter domain address:");
                    userInputDomain = readUserInput();
                    System.out.println("Enter user login:");
                    userInputLogin = readUserInput();
                    if (!database.checkIfEntryExist(userInputDomain, userInputLogin)) {
                        System.out.println("Wrong domain or user name. Please try again.");
                        continue;
                    } else {
                        System.out.println("Enter new password:");
                        userInputPassword = readUserInput();
                        database.addDatabaseEntry(userInputDomain, userInputLogin, userInputPassword);
                        continue;
                    }
                case "5":
                case "0":
                    running = false;
                    break;

            }

        }
    }

    private static String readUserInput() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine();
    }

//    private static CarRepository readCSVdatabase() {
//        CarRepository database = new CarRepository();
//        try (BufferedReader br = new BufferedReader(new FileReader("/home/gordonfreeman/java_learn/programator/piotrek/src/com/connectis/programator/demo/zajecia_2019_10_06_pio/manager3/manager.csv"))) {
//            String line;
//            while ((line = br.readLine()) != null) {
//                String[] values = line.split(";");
////                database.addDatabaseEntry(Arrays.asList(values));
//                for (String value : values) {
//                    System.out.println(value);
//                }
//            }
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return new CarRepository();
//    }

    private static Database readCSVdatabase(String fileName) {
        Database database = new Database();

        Path pathToFile = Paths.get(fileName);

        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.UTF_8)) {

            String line = br.readLine();

            while (!line.isEmpty()) {

                String[] attributes = line.split(";");


//                if (!line.isEmpty()) {
//
//                    database.addDatabaseEntry(attributes[0], attributes[1], attributes[2]);
//                }

                database.addDatabaseEntry(attributes[0], attributes[1], attributes[2]);

                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return database;
    }


}
