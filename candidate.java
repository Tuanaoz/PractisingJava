// Creating a Record named Candidate to store data.
class Candidate {
    String name;
    String party;
    int votes;
}
// End Candidate

// Start of class Elections
public class Elections {

    static Candidate[] candidates;

    // Start of main method
    public static void main(String[] args) {
        candidateInformation();
        results();
    }

    // End main

    // Gets information about two candidates and stores it in an array. Stores it in Candidate.
    public static void candidateInformation() {
        Scanner scanner = new Scanner(System.in);
        candidates = new Candidate[2];

        for (int i = 0; i < candidates.length; i++) {
            candidates[i] = create(i + 1, scanner);
        }
    }

// End candidateInformation

// Creates a candidate, takes user input, and returns the updated array of candidates.
    public static Candidate create(int candidateNumber, Scanner scanner) {
        Candidate candidate = new Candidate();

        System.out.println("What is the name of the " + candidateNumber + " candidate?");
        String name = scanner.nextLine();

        while (!isString(name)) {
            System.out.println("Please enter a valid name.");
            name = scanner.nextLine();
        }

        candidate.name = name;

        System.out.println("What party did they stand for?");
        String party = scanner.nextLine();

        while (!isString(party)) {
            System.out.println("Please enter a valid party name.");
            party = scanner.nextLine();
        }

        candidate.party = party;

        System.out.println("How many votes did they gain?");

        while (true) {
            if (scanner.hasNextInt()) {
                int votes = scanner.nextInt();
                scanner.nextLine();

                candidate.votes = votes;
                break;
            } else {
                System.out.println("Please enter a valid integer for votes.");
                scanner.nextLine();
            }
        }

        return candidate;
    }

    // End create

    // Declares the winner, it calculates the difference between the votes and prints it.
    public static void results() {
        int maxVotes = candidates[0].votes;
        int winner = 0;

        for (int i = 1; i < candidates.length; i++) {
            if (candidates[i].votes > maxVotes) {
                maxVotes = candidates[i].votes;
                winner = i;
            }
        }

        System.out.println(candidates[winner].name + " of " + candidates[winner].party +
                " is declared the winner with " + candidates[winner].votes + " votes.");

        for (int i = 0; i < candidates.length; i++) {
            if (i != winner) {
                int difference = candidates[winner].votes - candidates[i].votes;
                System.out.println(candidates[i].name + " of " + candidates[i].party +
                        " has a difference of " + difference + " votes compared to the winner.");
            }
        }
    }
 // End results
    
//checks if the input is a string.
    public static boolean isString(String input) {
        return input.matches("[a-zA-Z]+");
    }
//End isString

}
//End Elections
  
