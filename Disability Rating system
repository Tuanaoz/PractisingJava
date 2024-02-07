import java.util.Scanner;

public class DisabilityRating {

    // Inner class to represent information about a restaurant's disability accessibility
    static class Essentials {
        String restaurantName;
        int stepFreeAccessScore;
        int toiletsScore;
        int parkingScore;
        int totalRating;
        String calculatedRating;
    }
    
    // End Essentials

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        collectingData(scanner);
    }
    // End main

    // Create a new `Essentials` record with default values and the given restaurant name.
    public static Essentials createRecord(String restaurantName) {
        final Essentials record = new Essentials();
        record.restaurantName = restaurantName;
        record.stepFreeAccessScore = 0;
        record.toiletsScore = 0;
        record.parkingScore = 0;
        record.totalRating = 0;
        record.calculatedRating = "UNRATED";
        return record;
    }
    // End createRecord

    // Collect data from the user about a restaurant's disability accessibility.
    public static void collectingData(Scanner scanner) {
        boolean continueCollecting = true;

        while (continueCollecting) {
            System.out.println("What is the name of the restaurant?");
            String restaurantName = scanner.next();

            final Essentials essentials = createRecord(restaurantName);

            System.out.println("What is the score for step-free access?");
            int stepFreeAccessScore = scanner.nextInt();

            System.out.println("What is the score for disabled toilets?");
            int toiletsScore = scanner.nextInt();

            System.out.println("What is the score for disabled parking?");
            int parkingScore = scanner.nextInt();

            setRating(essentials, stepFreeAccessScore, toiletsScore, parkingScore);

            System.out.println(getRating(essentials));

            System.out.println("Another (y/n)?");
            String another = scanner.next();
            continueCollecting = another.equalsIgnoreCase("y");
        }

        System.out.println("Exiting the program.");
    }
    // End collectingData

    // Set the disability rating for a restaurant based on the provided scores.
    public static void setRating(Essentials record, int stepFreeAccessScore, int toiletsScore, int parkingScore) {
        if (isValidScore(stepFreeAccessScore) && isValidScore(toiletsScore) && isValidScore(parkingScore)) {
            record.stepFreeAccessScore = stepFreeAccessScore;
            record.toiletsScore = toiletsScore;
            record.parkingScore = parkingScore;

            record.totalRating = stepFreeAccessScore + toiletsScore + parkingScore;

            if (record.totalRating >= 9) {
                record.calculatedRating = "OUTSTANDING";
            } else if (record.totalRating > 5) {
                record.calculatedRating = "GOOD";
            } else if (record.totalRating > 0) {
                record.calculatedRating = "POOR";
            } else {
                record.calculatedRating = "UNRATED";
            }
        } else {
            System.out.println("Invalid scores. Scores must be between 1 and 3.");
        }
    }
    // End setRating

    // Get a formatted string representing the restaurant's disability rating.
    public static String getRating(Essentials record) {
        return record.restaurantName + " has a disability rating of " + record.calculatedRating + ".";
    }
    // End getRating

    // Check if a score is between 1 and 3.
    public static boolean isValidScore(int score) {
        return score >= 1 && score <= 3;
    }
    // End isValidScore
}
// End class DisabilityRating
