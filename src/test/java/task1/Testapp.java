package task1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Testapp {


    public static void main(String[] args) throws IOException, InterruptedException {

        mainModule();
    }

    public static void mainModule() throws IOException {

        BufferedReader br;
        String sCurrentLine;
        String text = "";
        String filePath;
        int minLineNum = 0;
        int maxLineNum = 999;
        filePath = "Files/file.txt";
        br = new BufferedReader(new FileReader(filePath));

        int currentLineNum = 0;
        while ((sCurrentLine = br.readLine()) != null) {
            if (currentLineNum <= maxLineNum) {
                if (text.equals(""))
                    text = sCurrentLine;
                else
                    text = text + "\n" + sCurrentLine;
            }
            currentLineNum++;
            if (currentLineNum == maxLineNum) {
                matcher(minLineNum, text);
                minLineNum = minLineNum + 1000;
                maxLineNum = maxLineNum + 999;
                text = "";
            }
        }
    }


    public static void matcher(int lineOffset, String INPUT) {

        String People[] = {"James", "John", "Robert", "Michael", "William", "David", "Richard", "Charles", "Joseph", "Thomas", "Christopher", "\n" +
                "Daniel", "Paul", "Mark", "Donald", "George", "Kenneth", "Steven", "Edward", "\n" +
                "Brian", "Ronald", "Anthony", "Kevin", "Jason", "Matthew", "Gary", "Timothy", "Jose", "Larry", "\n" +
                "Jeffrey", "Frank", "Scott", "Eric", "Stephen", "Andrew", "Raymond", "Gregory", "Joshua", "Jerry", "Dennis", "Walter", "\n" +
                "Patrick", "Peter", "Har old", "Douglas", "Henry", "Carl", "Arthur", "Ryan", "Roger"};

        ArrayList<String> foundMatches = new ArrayList<>();
        int charOffset;
        Pattern p;
        String currentFoundMatches;
        String REGEX;
        Matcher m;
        int count;

        for (int i = 0; i < People.length; i++) {
            REGEX = "\\b" + People[i] + "\\b";
            p = Pattern.compile(REGEX);
            m = p.matcher(INPUT);
            count = 0;
            currentFoundMatches = "";
            while (m.find()) {
                count++;
                //System.out.println("Match number " + count);
                //System.out.println("lineOffset: " + lineOffset);
                charOffset = m.start();
                //System.out.println("charOffset: " + charOffset);
                currentFoundMatches = currentFoundMatches + "[lineOffset=" + lineOffset + ", charOffset=" + charOffset + "],";
            }
            if (count > 0) {
                currentFoundMatches = People[i] + " -->" + currentFoundMatches;
                currentFoundMatches = currentFoundMatches.replace("-->[", "-->[[");
                currentFoundMatches = currentFoundMatches.substring(0, currentFoundMatches.length() - 1);
                currentFoundMatches = currentFoundMatches + "]";
                foundMatches.add(currentFoundMatches);
            } else
                foundMatches.add(People[i] + " -->" + "No matches for lineOffset=" + lineOffset);
        }
        aggregator(foundMatches);
    }

    public static void aggregator(ArrayList<String> foundMatches) {

        String foundMatchesPerPart = "";

        for (String match : foundMatches)
            foundMatchesPerPart = foundMatchesPerPart + "\n" + match;

        System.out.println("!!!!!!!!!!!!!!!!!!REPORT!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println(foundMatchesPerPart);
    }


}