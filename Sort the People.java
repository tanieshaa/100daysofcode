class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int n = heights.length; // Get the number of elements

        // Outer loop iterates over each element in the heights array
        for(int i = 0; i < n; i++) {
            // Inner loop compares the current element with the rest of the elements
            for(int j = i + 1; j < n; j++) {
                // If the current element is smaller than the next element, swap them
                if(heights[j] > heights[i]) {
                    // Swap the names
                    String temp = names[i];
                    names[i] = names[j];
                    names[j] = temp;

                    // Swap the heights
                    int tem = heights[i];
                    heights[i] = heights[j];
                    heights[j] = tem;
                }
            }
        }
        return names; // Return the sorted names
    }
}
