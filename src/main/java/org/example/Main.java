package org.example;

// Importuojame Guava biblioteką, kad galėtume naudoti Range klasę
import com.google.common.collect.Range;

public class Main {
    public static void main(String[] args) {

        // 1. Sugeneruojame dvi Integer skaičių aibes (Range)

        // Uždara aibė nuo 1 iki 10, įskaitant 1 ir 10
        Range<Integer> closedRange = Range.closed(1, 10); // Sukuriame uždarą aibę nuo 1 iki 10

        // Pusiau atvira aibė nuo 5 iki 15, neįskaitant 5, bet įskaitant 15
        Range<Integer> openClosedRange = Range.openClosed(5, 15); // Sukuriame pusiau atvirą aibę nuo 5 iki 15

        // Spausdiname, kokios yra šios aibės
        System.out.println("Closed Range: " + closedRange);  // Išvedame uždarą aibę [1..10]
        System.out.println("Open-Closed Range: " + openClosedRange); // Išvedame pusiau atvirą aibę (5..15]

        // 2. Patikriname, ar skaičius 5 priklauso šioms aibėms
        int valueToCheck = 5; // Sukuriame kintamąjį ir priskiriame jam reikšmę 5, kurią norime patikrinti

        // Patikriname, ar skaičius 5 priklauso uždarai aibei [1..10]
        boolean isInClosedRange = closedRange.contains(valueToCheck); // Jei 5 yra uždaroje aibėje, grąžins true

        // Patikriname, ar skaičius 5 priklauso pusiau atvirai aibei (5..15]
        boolean isInOpenClosedRange = openClosedRange.contains(valueToCheck); // Jei 5 yra pusiau atviroje aibėje, grąžins true

        // Išvedame rezultatus
        System.out.println("Value " + valueToCheck + " in Closed Range: " + isInClosedRange);
        // Jei 5 priklauso uždarai aibei, išves true, jei ne – false
        System.out.println("Value " + valueToCheck + " in Open-Closed Range: " + isInOpenClosedRange);
        // Jei 5 priklauso pusiau atvirai aibei, išves true, jei ne – false

        // 3. Susikirtimo ir praplėtimo radimas
        // Rasti bendrą aibių dalį (kur jos susikerta)
        Range<Integer> intersection = closedRange.intersection(openClosedRange);
        // `intersection()` grąžina bendrą aibių dalį. Jei viena aibė yra [1..10] ir kita (5..15], susikirtimas bus [5..10].

        // Rasti visą aibių plotą (apima tiek uždarą, tiek pusiau atvirą aibę)
        Range<Integer> span = closedRange.span(openClosedRange);
        // `span()` grąžina visą plotą, apimantį tiek uždarą, tiek pusiau atvirą aibę. Jei viena aibė yra [1..10], o kita (5..15],
        // praplėtimas bus [1..15].

        // Išvedame susikirtimo ir praplėtimo rezultatus
        System.out.println("Intersection of ranges: " + intersection); // Išvedame susikirtimo rezultatus, tai bus [5..10]
        System.out.println("Span of ranges: " + span); // Išvedame praplėtimo rezultatus, tai bus [1..15]
    }
}