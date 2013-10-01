package gps;

/**
 * Class for storing the pair of integers denoting the allowed value range.
 */
public class Range {
    
    /* Properties */ 
    
    private int begin;
    private int end;
    
    /* Methods */
    
    // constructor
    public Range(int begin, int end) {
        this.begin  = begin;
        this.end    = end;
    }
    
    // getter
    public int begin() {
        return this.begin;
    }
    
    public int end() {
        return this.end;
    }
}
