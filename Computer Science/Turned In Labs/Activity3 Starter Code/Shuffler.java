/**
 * This class provides a convenient way to test shuffling methods.
 */
public class Shuffler {

    /**
     * The number of consecutive shuffle steps to be performed in each call
     * to each sorting procedure.
     */
    private static final int SHUFFLE_COUNT = 1;

    /**
     * The number of values to shuffle.
     */
    private static final int VALUE_COUNT = 13;

    /**
     * Tests shuffling methods.
     * @param args is not used.
     */
    public static void main(String[] args) {
        System.out.println("Results of " + SHUFFLE_COUNT +
                                 " consecutive perfect shuffles:");
        int[] values1 = new int[VALUE_COUNT];
        for (int i = 0; i < values1.length; i++) {
            values1[i] = i;
            }
        for (int j = 1; j <= SHUFFLE_COUNT; j++) {
            perfectShuffle(values1);
            System.out.print("  " + j + ":");
            for (int k = 0; k < values1.length; k++) {
                System.out.print(" " + values1[k]);
            }
            System.out.println();
        }
        System.out.println();

        System.out.println("Results of " + SHUFFLE_COUNT +
                                 " consecutive efficient selection shuffles:");
        int[] values2 = new int[VALUE_COUNT];
        for (int i = 0; i < values2.length; i++) {
            values2[i] = i;
            }
        for (int j = 1; j <= SHUFFLE_COUNT; j++) {
            selectionShuffle(values2);
            System.out.print("  " + j + ":");
            for (int k = 0; k < values2.length; k++) {
                System.out.print(" " + values2[k]);
            }
            System.out.println();
        }
        System.out.println();
    }


    /**
     * Apply a "perfect shuffle" to the argument.
     * The perfect shuffle algorithm splits the deck in half, then interleaves
     * the cards in one half with the cards in the other.
     * @param values is an array of integers simulating cards to be shuffled.
     */
    public static void perfectShuffle(int[] values) 
    {

        // declare/initialize a temporary local array called temp, with length the same as "values"
        // INSERT CODE HERE
        int temp[]= new int[values.length];
        
        // mid represents the middle index of the array
        // e.g., for a 52-card deck, mid = (52 + 1) / 2 = 53/2 = 26
        int mid = (values.length + 1) / 2;
        
        // INSERT CODE FOR BOTH LOOPS (LOOPS 1 AND 2) BELOW, WHICH DO THE SHUFFLING
        // These 2 loops interleave elements 0 ... mid-1 with elements mid ... length-1
        
        int unshuffledPos = 0; //unshuffledPos is the present bucket of temp
        // LOOP 1;
        // Loop from k=0, k<mid, incrementing k by 1
            // copy element from bucket k of values to bucket unshuffledPos of temp
            // increment unshuffledPos by 2
        for(int k=0; k<mid;k++){temp[unshuffledPos]=values[k]; unshuffledPos+=2;}
        
        unshuffledPos = 1; // now we shift back to bucket 1 of temp
        // LOOP 2
        // Loop from k=mid, k< length of values, incrementing k by 1
            // copy element from bucket k of values to bucket unshuffledPos of temp
            // increment unshuffledPos by 2
        for(int k=mid; k<values.length;k++){temp[unshuffledPos]=values[k]; unshuffledPos+=2;}
            

        // INSERT CODE FOR THE LOOP BELOW, WHICH COPIES THE VALUE IN EACH BUCKET OF TEMP
        // BACK TO THE VALUE IN EACH BUCKET OF VALUES, ONE BY ONE (known as a "deep copy") .
        // NOTE: We cannot just say values = temp (known as a "shallow copy"). 
        // This would point values to the memory location of temp,
        // but this change would be local to the method.  As we exited
        // the method, values would refer back to the original, unchanged array
                
        // LOOP 3
        // Loop from k=0, k< length of values, incrementing k by 1
            // assign value in kth bucket of temp to value in kth bucket of values
            
        for(int i=0; i<values.length; i++){values[i]=temp[i];}
        
    }

    /**
     * Apply an "efficient selection shuffle" to the argument.
     * The selection shuffle algorithm conceptually maintains two sequences
     * of cards: the s  elected cards (initially empty) and the not-yet-selected
     * cards (initially the entire deck). It repeatedly does the following until
     * all cards have been selected: randomly remove a card from those not yet
     * selected and add it to the selected cards.
     * An efficient version of this algorithm makes use of arrays to avoid
     * searching for an as-yet-unselected card.
     * @param values is an array of integers simulating cards to be shuffled.
     */
    public static void selectionShuffle(int[] values) 
    {
        // INSERT ALL CODE FOR THE LOOP THAT DOES THE SHUFFLE
        
        // Loop from k = length of values - 1 backwards to k>0, decrementing k by 1
            // declare and initialize a local variable named "pos" that 
            // represents a random number between 0 and k, inclusive (use Math.random())
        for(int k=values.length-1; k>0;k--)
        {
            int pos=(int)((k+1)*Math.random()); 
            int temp= values[pos];
            values[pos]=values[k];
            values[k]=temp;
        }
            
            // Three-line swap of elements in values[pos] and values[k] below
               // 1. declare and initialize a local variable named "temp" that 
               //    gets the value in bucket "pos" of values
               // 2. assign value in bucket k of values to the value in bucket pos of values
               // 3. assign value of temp to the value in bucket k of temp
    }
}
