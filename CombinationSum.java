import java.util.*;

/**
 * This program finds all unique combinations of numbers from a given array
 * that sum up to a target number.
 * 
 * Example:
 * Input:  {10, 20, 30, 40, 50, 60, 70, 80, 90}
 * Target: 100
 * Output: [10, 20, 70], [10, 30, 60], [10, 40, 50], ...
 * 
 * It avoids duplicate combinations and uses backtracking to generate all valid subsets.
 */
public class CombinationSum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take input for the array
        System.out.println("Enter array elements separated by space:");
        String line = scanner.nextLine().trim();

        // Handle empty input case
        if (line.isEmpty()) {
            System.out.println("No input provided. Exiting...");
            scanner.close();
            return;
        }

        // Parse input string into integer array
        String[] input = line.split("\\s+");
        int[] arr = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        // Sort the array to help eliminate duplicate combinations
        Arrays.sort(arr);

        // Take input for the target sum
        System.out.print("Enter the target sum: ");
        int target = scanner.nextInt();

        // List to store all valid combinations
        List<List<Integer>> result = new ArrayList<>();

        // Start the recursive backtracking process
        findCombinations(arr, target, 0, new ArrayList<>(), result);

        // Print the results
        System.out.println("Combinations that sum to " + target + ":");
        if (result.isEmpty()) {
            System.out.println("No combination found.");
        } else {
            for (List<Integer> combination : result) {
                System.out.println(combination);
            }
        }

        scanner.close(); 
    }

    
    public static void findCombinations(int[] arr, int target, int index,
                                        List<Integer> current, List<List<Integer>> result) {
        // Base case: if target is exactly 0, add the current combination
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Loop through the array starting from current index
        for (int i = index; i < arr.length; i++) {
            // Skip duplicates to avoid duplicate combinations
            if (i > index && arr[i] == arr[i - 1]) {
                continue;
            }

            // If current number is greater than remaining target, stop searching
            if (arr[i] > target) {
                break;
            }

            // Include the current number
            current.add(arr[i]);

            // Recurse with reduced target and next index
            findCombinations(arr, target - arr[i], i + 1, current, result);

            // Backtrack: remove last added number
            current.remove(current.size() - 1);
        }
    }
}
