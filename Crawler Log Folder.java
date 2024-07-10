class Solution {
    public int minOperations(String[] logs) {
          int step = 0; // Start at the home folder
        
        // Go through each operation in the list
        for (String log : logs) {
            switch (log) {
                case "../": // Go to parent folder
                    if (step > 0) step--; // Only go up if we're not already at home
                    break;
                case "./": // Stay in the same folder
                    // Do nothing
                    break;
                default: // Go to a subfolder
                    step++;
                    break;
            }
        }
        
        return step; // Return the number of steps to go back to home
    }
}
