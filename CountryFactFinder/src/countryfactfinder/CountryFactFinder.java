package countryfactfinder;

import java.util.HashMap;
import java.util.*;
import java.io.*;

class Country { //create new class country 

    String birthrate;
    String unemployrate;
    String population;
    String gdp;
    String daterate;
}

public class CountryFactFinder {

    public static void main(String[] args) throws Exception {
        HashMap<String, Country> countries = new HashMap<>(); //initiates a hasmap with key and value
        File dir = new File("Data"); // File is an built an object, references directory called data
        File[] directoryListing = dir.listFiles(); // creates an array of file references
        if (directoryListing != null) {
            for (File file : directoryListing) {
                BufferedReader br = new BufferedReader(new FileReader(file)); // turns file into buffered reader
                String line;
                while ((line = br.readLine()) != null) { // reads the line of the file
                    String countryline = line.substring(7, 53); // separates string
                    countryline = countryline.trim(); // trims the spaces
                    String value = line.substring(54, 82);
                    value = value.trim();
                    if (!countries.containsKey(countryline)) { // checks if the hashmap contains the word (key)
                        countries.put(countryline, new Country());
                    }
                    Country c = countries.get(countryline); // sets country object to allow the changing of attributes
                    switch (file.getName()) { // assigns the value to the attribute of the object 
                        case "Birth-Rate.txt":
                            c.birthrate = value;
                            break;
                        case "Unemployment Rate.txt":
                            c.unemployrate = value;
                            break;
                        case "Population.txt":
                            c.population = value;
                            break;
                        case "GDP.txt":
                            c.gdp = value;
                            break;
                        case "Date Rate.txt":
                            c.daterate = value;
                            break;
                    }
                }
            }
            String y = "";
            while (y.equals("")) {
                System.out.println("Please enter a country.");
                Scanner input = new Scanner(System.in);
                String answer = input.nextLine();
                System.out.println("Country: " + answer);
                System.out.println("Birth Rate: " + (String) countries.get(answer).birthrate); // allows me to print the value based off of the key
                System.out.println("Unemployment Rate: " + (String) countries.get(answer).unemployrate);
                System.out.println("Population: " + (String) countries.get(answer).population);
                System.out.println("GDP: " + (String) countries.get(answer).gdp);
                System.out.println("Date Rate: " + (String) countries.get(answer).daterate);
                System.out.println("Press enter to enter another country. Enter anything else to exit the program.");
                y = input.nextLine();
            }
        }
    }
}
