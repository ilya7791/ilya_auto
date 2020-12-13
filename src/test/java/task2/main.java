package task2;


import java.util.ArrayList;
import java.util.Random;

public class main {

    public static final int NUM_OF_IDENTITIES=5;


    public static void main(String[] args)  {

        generatePersonalData();
    }

    public static void generatePersonalData() {

        Person p;
        ArrayList<Person> People;
        People = new ArrayList<>();

        for(int i=1;i<=NUM_OF_IDENTITIES;i++) {
            p = new Person(getRandomString(6) + "@company.com", getRandomString(6), getRandomString(6), getRandomString(6),
                           getRandomString(6), getRandomIDnum());
            People.add(p);
        }
        for(Person person:People)
            System.out.println(person.getEmail()+","+person.getFirstname()+","+person.getLastname()+","+person.getCity()+","+person.getCountry()+","+person.getID());
    }

    public static String getRandomString(int stringLength) {

        Random ran = new Random();
        char data = ' ';
        String randomString = "";

        for (int i = 0; i < stringLength; i++) {
            data = (char) (ran.nextInt(25) + 97);
            randomString = data + randomString;
        }

        return randomString;
    }

    public static int getRandomIDnum() {

        long timeSeed = System.nanoTime(); // to get the current date time value
        double randSeed = Math.random() * 1000; // random number generation
        long midSeed = (long) (timeSeed * randSeed); // mixing up the time and
        String s = midSeed + "";
        String subStr = s.substring(0, 9);
        int finalSeed = Integer.parseInt(subStr);    // integer value
        return finalSeed;
    }
}
