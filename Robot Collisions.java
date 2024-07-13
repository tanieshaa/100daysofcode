import java.util.*;

public class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        Integer[] indices = new Integer[n];
        List<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        // Create an array of indices to sort robots by their positions
        for (int index = 0; index < n; ++index) {
            indices[index] = index;
        }

        // Sort indices based on the robots' positions
        Arrays.sort(indices, (lhs, rhs) -> Integer.compare(positions[lhs], positions[rhs]));

        // Process each robot in sorted order of their positions
        for (int currentIndex : indices) {
            if (directions.charAt(currentIndex) == 'R') {
                // Add right-moving robots to the stack
                stack.push(currentIndex);
            } else {
                // Handle collisions with left-moving robots
                while (!stack.isEmpty() && healths[currentIndex] > 0) {
                    int topIndex = stack.pop();

                    if (healths[topIndex] > healths[currentIndex]) {
                        healths[topIndex] -= 1;
                        healths[currentIndex] = 0;
                        stack.push(topIndex);
                    } else if (healths[topIndex] < healths[currentIndex]) {
                        healths[currentIndex] -= 1;
                        healths[topIndex] = 0;
                    } else {
                        healths[currentIndex] = 0;
                        healths[topIndex] = 0;
                    }
                }
            }
        }

        // Collect surviving robots' healths
        for (int index = 0; index < n; ++index) {
            if (healths[index] > 0) {
                result.add(healths[index]);
            }
        }
        return result;
    }
}
