# 384. Shuffle an Array

https://leetcode.com/problems/shuffle-an-array/

Given an integer array nums, design an algorithm to randomly shuffle the array. All permutations of the array should be equally likely as a result of the shuffling.

Implement the Solution class:

	Solution(int[] nums) Initializes the object with the integer array nums.
	int[] reset() Resets the array to its original configuration and returns it.
	int[] shuffle() Returns a random shuffling of the array.

 
Example 1:

Input
[&quot;Solution&quot;, &quot;shuffle&quot;, &quot;reset&quot;, &quot;shuffle&quot;]
[[[1, 2, 3]], [], [], []]
Output
[null, [3, 1, 2], [1, 2, 3], [1, 3, 2]]

Explanation
Solution solution = new Solution([1, 2, 3]);
solution.shuffle();    // Shuffle the array [1,2,3] and return its result.
                       // Any permutation of [1,2,3] must be equally likely to be returned.
                       // Example: return [3, 1, 2]
solution.reset();      // Resets the array back to its original configuration [1,2,3]. Return [1, 2, 3]
solution.shuffle();    // Returns the random shuffling of array [1,2,3]. Example: return [1, 3, 2]

 
Constraints:

	1 <= nums.length <= 50
	-106 <= nums[i] <= 106
	All the elements of nums are unique.
	At most 104 calls in total will be made to reset and shuffle.

```java
import java.util.Random;

class Solution {
    private final int[] original;
    private int[] current;
    private final Random rnd = new Random();

    public Solution(int[] nums) {
        original = nums.clone();
        current = nums.clone();
    }

    public int[] reset() {
        current = original.clone();
        return current.clone();
    }

    public int[] shuffle() {
        for (int i = current.length - 1; i > 0; i--) {
            int j = rnd.nextInt(i + 1);
            int t = current[i];
            current[i] = current[j];
            current[j] = t;
        }
        return current.clone();
    }
}
```
