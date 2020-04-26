/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seven;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTester {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)){
            while(true){
                System.out.println("Unesi regex ");
                String regex = scanner.nextLine();
                Pattern pattern = Pattern.compile(regex);
                System.out.println("Unesi sada text ");
                String text = scanner.nextLine();
                Matcher matcher = pattern.matcher(text);
                boolean found = false;
                while(matcher.find()){
                    String matcherGroup = matcher.group();
                    int startPosition = matcher.start();
                    int endPosition = matcher.end();
                    System.out.format("I found text '%s' koji pocinje na indeksu '%d' a zavrsava na indexu '%s'.%n", matcherGroup, startPosition, endPosition);
                    found = true;
                }
                if(!found){
                    System.out.format("Nema nista u tekstu '%s' sto odgovara regularnom izrazu '%s'.%n", text, regex);
                }
            }
        }catch(Exception e){
            System.err.println("No matching");
        }
    }
    
}
