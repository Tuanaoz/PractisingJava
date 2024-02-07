public class lapTimes {
    private static int i = 0;
    private static int totalRun = 0;
    private static boolean enteredSecretCode = false;
    private static ArrayList<Integer> givenRunData = new ArrayList<>();
    private static String dataInput;

    public static void main(String[] args) {
        final String secretCode = "XXX";
        runData(secretCode);
    }//End main
    
//Collects data for laps.
    public static void runData(String secretCode) {
        Scanner scanner = new Scanner(System.in);

        while (!enteredSecretCode) {
            System.out.println("What was lap time " + (i + 1) + " (in s)");
            dataInput = scanner.next();

            enteredSecretCode = laps(dataInput, secretCode);
            i++;
        }

        scanner.close();
    } //End runData
    
    // Calculates differences between lap times, ends the loop when secret code is given and adds the lap times. 
    public static boolean laps(String userInput, String secretCode) {
        if (userInput.equals(secretCode)) {
            System.out.println("You did " + i + " laps.");
            System.out.print("Your total time today was " + totalRun + "s");
            return true;
        } else {
            givenRunData.add(Integer.parseInt(userInput));
            totalRun += givenRunData.get(i);

            if (i > 0) {
                int largerTime = Math.max(givenRunData.get(i), givenRunData.get(i - 1));
                int smallerTime = Math.min(givenRunData.get(i), givenRunData.get(i - 1));
                System.out.println("Difference " + (largerTime - smallerTime) + " seconds");
            }

            return false;
        }
    }//End laps
}//End lapTimes
