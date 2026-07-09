// Last updated: 7/9/2026, 3:05:14 PM
import java.util.*;

class Solution {
    public long maximumSum(int[] nums, int m, int l, int r) {
        int n = nums.length;

        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        long NEG = Long.MIN_VALUE / 4;

        long[] prev = new long[n + 1];
        Arrays.fill(prev, 0);

        long answer = NEG;

        for (int t = 1; t <= m; t++) {
            long[] curr = new long[n + 1];
            Arrays.fill(curr, NEG);

            Deque<Integer> dq = new ArrayDeque<>();

            for (int i = 1; i <= n; i++) {

                curr[i] = curr[i - 1];

                int addIdx = i - l;
                if (addIdx >= 0) {
                    long val = prev[addIdx] - prefix[addIdx];

                    while (!dq.isEmpty()) {
                        int last = dq.peekLast();
                        long lastVal = prev[last] - prefix[last];
                        if (lastVal <= val) {
                            dq.pollLast();
                        } else {
                            break;
                        }
                    }
                    dq.offerLast(addIdx);
                }

                while (!dq.isEmpty() && dq.peekFirst() < i - r) {
                    dq.pollFirst();
                }

                if (!dq.isEmpty()) {
                    int j = dq.peekFirst();
                    long take = prefix[i] + prev[j] - prefix[j];
                    curr[i] = Math.max(curr[i], take);
                }
            }

            answer = Math.max(answer, curr[n]);
            prev = curr;
        }

        return answer;
    }
}