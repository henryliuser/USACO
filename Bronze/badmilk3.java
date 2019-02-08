import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class badmilk3 {

    static class Drink {
        Milk type;
        int time;
        public Drink(Milk m, int t) {
            time = t;
            type = m;
        }
    }

    static class Person {
        ArrayList<Drink> drinks = new ArrayList<>();
        ArrayList<Drink> drinksAtTimeT = new ArrayList<>();
        int timeSick = -1;
    }

    static class Milk {
//        ArrayList<Drink> drinksWithThisMilk;
        boolean maybeBad;
        ArrayList<Person> peopleWhoDrunk = new ArrayList<>();
        ArrayList<Person> sickPeopleWhoDrunkBEFORE = new ArrayList<>();
    }


    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("Text Files/badmilk.in"));
        int N = in.nextInt(); //number of people
        int M = in.nextInt(); //number of milks
        int D = in.nextInt();
        int S = in.nextInt();


        ArrayList<Milk> hitlist = new ArrayList<>();
        ArrayList<Person> sick = new ArrayList<>();
        ArrayList<Person> people = new ArrayList<>();
        ArrayList<Milk> milks = new ArrayList<>();
        ArrayList<Milk> finalHitlist = new ArrayList<>();

        for (int z = 0; z < M; z++){
            milks.add(new Milk());
        }
        for (int z = 0; z < N; z++) {
            people.add(new Person());
        }

        for (int z = 0; z < D; z++) {

            int p = in.nextInt() - 1; //person p
            int m = in.nextInt() - 1; //imbibed milk m
            int t = in.nextInt() - 1; //at time t

            Drink a = new Drink(milks.get(m),t); //create a new Drink
            people.get(p).drinks.add(a);        //add this drink to the person's list of drinks
            milks.get(m).peopleWhoDrunk.add(people.get(p));  //add this person to the list of people who have drunk this milk

        }


        for (int z = 0; z < S; z++) { //iterate through each person who gets sick

            int p = in.nextInt() - 1; //person who got sick
            int t = in.nextInt() - 1; //time getting sick

            people.get(p).timeSick = t;  //set this person's time to t
            sick.add(people.get(p));     //add this person to the list of sick people
            Person suspect = people.get(p);

            for (int z1 = 0; z1 < suspect.drinks.size(); z1++) {   //iterate through the drinks this person has drunk
                Drink currentDrink = suspect.drinks.get(z1);
                if (currentDrink.time < suspect.timeSick) {
                    if (!suspect.drinksAtTimeT.contains(currentDrink)) suspect.drinksAtTimeT.add(currentDrink);
                    Milk x = currentDrink.type;
                    if (!hitlist.contains(x)) {
                        hitlist.add(x);                            //add this milk to the hitlist
                    }
                    x.sickPeopleWhoDrunkBEFORE.add(suspect);   //add this person to the list of sick people who drunk before
                }
            }

        }
        in.close();

        for (int z = 0; z < hitlist.size(); z++) {  //iterate through all milks on the hitlist
            Milk suspectMilk = hitlist.get(z);  //we need to iterate through all people who've drank this milk
            for (int z1 = 0; z1 < suspectMilk.peopleWhoDrunk.size(); z1++) {
                Person currentPerson = suspectMilk.peopleWhoDrunk.get(z1);

                for (int z2 = 0; z2 < currentPerson.drinksAtTimeT.size(); z2++) {
                    if (currentPerson.drinksAtTimeT.get(z2).type == suspectMilk) {
                        suspectMilk.maybeBad = true;
                        break;
                    }
                    else {
                        suspectMilk.maybeBad = false;
                    }
                }


            }

        }

        for (int z = 0; z < milks.size(); z++) {
            if (milks.get(z).maybeBad) {
                finalHitlist.add(milks.get(z));
            }
        }

        int max = 0;

        for (int z = 0; z < finalHitlist.size(); z++) {
            Milk d = finalHitlist.get(z);
            if (d.peopleWhoDrunk.size() > max) {
                max = d.peopleWhoDrunk.size();
            }
        }
        System.out.println(max);
        BufferedWriter out = new BufferedWriter(new FileWriter("badmilk.out"));
        out.write(max + "");
        out.close();







    }
}
