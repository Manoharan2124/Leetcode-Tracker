// Last updated: 9/25/2026, 9:56:15 AM
1public class NumArray {
2	/**
3	 * Binary Indexed Trees (BIT or Fenwick tree):
4	 * https://www.topcoder.com/community/data-science/data-science-
5	 * tutorials/binary-indexed-trees/
6	 * 
7	 * Example: given an array a[0]...a[7], we use a array BIT[9] to
8	 * represent a tree, where index [2] is the parent of [1] and [3], [6]
9	 * is the parent of [5] and [7], [4] is the parent of [2] and [6], and
10	 * [8] is the parent of [4]. I.e.,
11	 * 
12	 * BIT[] as a binary tree:
13	 *            ______________*
14	 *            ______*
15	 *            __*     __*
16	 *            *   *   *   *
17	 * indices: 0 1 2 3 4 5 6 7 8
18	 * 
19	 * BIT[i] = ([i] is a left child) ? the partial sum from its left most
20	 * descendant to itself : the partial sum from its parent (exclusive) to
21	 * itself. (check the range of "__").
22	 * 
23	 * Eg. BIT[1]=a[0], BIT[2]=a[1]+BIT[1]=a[1]+a[0], BIT[3]=a[2],
24	 * BIT[4]=a[3]+BIT[3]+BIT[2]=a[3]+a[2]+a[1]+a[0],
25	 * BIT[6]=a[5]+BIT[5]=a[5]+a[4],
26	 * BIT[8]=a[7]+BIT[7]+BIT[6]+BIT[4]=a[7]+a[6]+...+a[0], ...
27	 * 
28	 * Thus, to update a[1]=BIT[2], we shall update BIT[2], BIT[4], BIT[8],
29	 * i.e., for current [i], the next update [j] is j=i+(i&-i) //double the
30	 * last 1-bit from [i].
31	 * 
32	 * Similarly, to get the partial sum up to a[6]=BIT[7], we shall get the
33	 * sum of BIT[7], BIT[6], BIT[4], i.e., for current [i], the next
34	 * summand [j] is j=i-(i&-i) // delete the last 1-bit from [i].
35	 * 
36	 * To obtain the original value of a[7] (corresponding to index [8] of
37	 * BIT), we have to subtract BIT[7], BIT[6], BIT[4] from BIT[8], i.e.,
38	 * starting from [idx-1], for current [i], the next subtrahend [j] is
39	 * j=i-(i&-i), up to j==idx-(idx&-idx) exclusive. (However, a quicker
40	 * way but using extra space is to store the original array.)
41	 */
42
43	int[] nums;
44	int[] BIT;
45	int n;
46
47	public NumArray(int[] nums) {
48		this.nums = nums;
49
50		n = nums.length;
51		BIT = new int[n + 1];
52		for (int i = 0; i < n; i++)
53			init(i, nums[i]);
54	}
55
56	public void init(int i, int val) {
57		i++;
58		while (i <= n) {
59			BIT[i] += val;
60			i += (i & -i);
61		}
62	}
63
64	void update(int i, int val) {
65		int diff = val - nums[i];
66		nums[i] = val;
67		init(i, diff);
68	}
69
70	public int getSum(int i) {
71		int sum = 0;
72		i++;
73		while (i > 0) {
74			sum += BIT[i];
75			i -= (i & -i);
76		}
77		return sum;
78	}
79
80	public int sumRange(int i, int j) {
81		return getSum(j) - getSum(i - 1);
82	}
83}
84
85// Your NumArray object will be instantiated and called as such:
86// NumArray numArray = new NumArray(nums);
87// numArray.sumRange(0, 1);
88// numArray.update(1, 10);
89// numArray.sumRange(1, 2);