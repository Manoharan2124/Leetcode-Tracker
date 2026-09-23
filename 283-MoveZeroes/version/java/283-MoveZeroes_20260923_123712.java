// Last updated: 9/23/2026, 12:37:12 PM
1class PeekingIterator implements Iterator<Integer> {  
2    private Integer next = null;
3    private Iterator<Integer> iter;
4
5    public PeekingIterator(Iterator<Integer> iterator) {
6        // initialize any member here.
7        iter = iterator;
8        if (iter.hasNext())
9            next = iter.next();
10    }
11    
12    // Returns the next element in the iteration without advancing the iterator. 
13    public Integer peek() {
14        return next; 
15    }
16
17    // hasNext() and next() should behave the same as in the Iterator interface.
18    // Override them if needed.
19    @Override
20    public Integer next() {
21        Integer res = next;
22        next = iter.hasNext() ? iter.next() : null;
23        return res; 
24    }
25
26    @Override
27    public boolean hasNext() {
28        return next != null;
29    }
30}