import java.io.File;
import java.io.PrintWriter;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        String[] words = new String[24];
        String[] prompts = new String[] {
                "a man's name", "a famous actor", "an occupation", "a number", "an obscure japanese movie title",
                "a verb", "a body part", "a verb", "a noun", "an obscure movie title",
                "a cool old car", "a man's name", "a very famous actor", "an older Tarantino movie", "an obscure movie title",
                "an adjective", "a verb", "a plural body part", "a plural noun", "an obscure movie title"
        };


        // get user input
        System.out.println("Welcome to a Quentin Tarantino Mad Lib!");

        for (int i = 0; i < prompts.length; i++) {
            System.out.print("Enter " + prompts[i] + " : ");

            Scanner s = new Scanner(System.in);
            String input = s.nextLine();

            words[i] = input;
        }

        for (int i = 0; i < words.length; i++) {
            System.out.println(words[i]);
        }

        // assemble our Mad Lib !

        StringBuilder mL = new StringBuilder();

        String ul = "\033[92m";
        String nl = "\033[0m";

        mL.append(ul + words[0] + nl + " is a very suave guy played by " + ul + words[1] + nl);
        mL.append(".  He's done some bad stuff, but he's very cool.  " +
                "He has a long conversation with a " + ul + words[2] +nl);
        mL.append(", in which he makes " + ul + words[3] + nl + " references to a classic hollywood film " +
                "that was based on the obscure Japanese film " + ul + words[4] + nl);
        mL.append(", then he kills him very violently by " + ul + words[5] + nl + "ing him in the " + ul + words[6] + nl);
        mL.append(" and then " + ul + words[7] + nl + "ing his " + ul + words[8] + nl + " off.");
        mL.append("  After making another really great reference to " + ul + words[9] + nl);
        mL.append(", he drives a " + ul + words[10] + nl + " to the home of " + ul + words[11] + nl);
        mL.append(", who is played by " + ul + words[12] + nl + ".  They have another very long, wordy");
        mL.append(", sharp-tongued conversation in which the cinematography references " + ul + words[13] + nl);
        mL.append(" and the dialogue is an homage to " + ul + words[14] + nl + ", and then they get in a very bloody");
        mL.append(", " + ul + words[15] + nl + " fight in which they " + ul + words[16] + nl);
        mL.append(" each other's " + ul + words[17] + nl + " with " + ul + words[18] + nl);
        mL.append(" and talk about " + ul + words[19] + nl + " for a really long time.");

        System.out.print("\033\143");
        System.out.print(mL);
        System.out.print("\n\nDo you want to save a copy of this Quentin Tarantino Mad Lib?  [y/n]: ");

        Scanner s = new Scanner(System.in);
        String yn = s.nextLine().toUpperCase();

        switch (yn) {
            case "Y":
                System.out.print("\n\nEnter a file name: ");

                Scanner sc = new Scanner(System.in);
                String fn = sc.nextLine().replace(' ', '_');

                try {
                    PrintWriter writer = new PrintWriter(fn, "UTF-8");
                    writer.print(mL);
                    writer.close();

                } catch(Exception e) {
                    System.out.println("Something broken with the file writer: " + e);
                }

                File f = new File(fn);
                if(f.exists() && !f.isDirectory()) {
                    System.out.println("Mad Libs File " + fn + " successfully saved!\n");

                } else {
                    System.out.println("Unable to create file " + fn + ".\n");
                }
                break;

            default:
                System.exit(0);
        }
    }
}
