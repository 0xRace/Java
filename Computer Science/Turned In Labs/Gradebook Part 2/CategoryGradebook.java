/****************************************************
**
** CategoryGradebook class
**
** This class represents a CategoryGradebook that calculates
** grades according to the weighted category grading system.
**
****************************************************/
import java.util.ArrayList;

public class CategoryGradebook implements Gradebook {
    private ArrayList<CategoryAssignment> myGrades;
    private String[] myCategories;
    private int[] myWeights;       
    
    // precondition: categories.length == weights.length;
    // categories contains the names of all categories in this Gradebook;
    // weights contains the values of the weights of each corresponding category;
    // each value in weights is between 0 and 100 inclusive
    // postcondition: all instance variables are initialized;
    // if sum of elements in weights is not equal to 100, then the weight of
    // the last category is adjusted so that the sum is equal to 100
    public CategoryGradebook(String[] categories, int[] weights) {
        int i, sum = 0;
        // ADD CODE BELOW THIS LINE to initialize the instance variables
        myCategories=categories;
        myWeights=weights;      
        myGrades=new ArrayList<CategoryAssignment>();
        // do not change the code that follows -- it is the code that adjusts
        // the weights in case they don't add up to 100        
        for (i = 0; i < myWeights.length; i++) {
            sum += myWeights[i];
        }        
        if (sum < 100) {
            myWeights[myWeights.length-1] += (100 - sum);
        } else if (sum > 100) {
            myWeights[myWeights.length-1] -= (sum - 100);
        }
    }

    // calculateGrade accessor method
    //
    // postcondition: the grade represented by this Gradebook is calculated and
    // returned, according to the weighted category grading system. 
    public double calculateGrade() {
        double[] categoryPtsEarned = new double[myWeights.length];      // initialized to all zero's
        double[] categoryPtsAvail = new double[myWeights.length];       // initialized to all zero's
        int i, index;
        CategoryAssignment catAssign;
        double grade = 0;
        
        // this code will add the points earned and points available for each  
        // assignment to the correct position in the two arrays
        
        // ADD CODE BELOW THIS LINE: a for statement that loops through myGrades
        for(i=0;i<myGrades.size();i++){      
        
            // this line goes inside the for loop
            catAssign = (CategoryAssignment)myGrades.get(i);
            index = findCategory(catAssign);
            categoryPtsEarned[index] += catAssign.getPointsEarned();
            categoryPtsAvail[index] += catAssign.getPointsPossible();
           // end of the for loop
        }
        
        // find the average for each category (0 <= average < 1), multiply each of those values by the 
        // weight (0 <= weight <= 100), and add those values together to calculate total grade

        // ADD CODE BELOW THIS LINE: a for statement that loops through categoryPtsEarned
        
        
            // this line goes inside the for loop
        for(i=0;i<categoryPtsEarned.length;i++){
            grade += (categoryPtsEarned[i] / categoryPtsAvail[i]) * myWeights[i];
        }
        
        
        return grade;
    }
    
    // findCategory private accessor method
    // 
    // precondition: assign IS-A CategoryAssignment, and its category can be found in myCategories
    // postcondition: returns the index into myCategories at which assign's category is located
    // for example: if myCategories contains { "Quizzes", "Tests", "Projects" }, and the return
    // value of assign.getCategoryName() is "Tests", then this method returns 1.
    private int findCategory(Assignment assign) {
        int i;
        CategoryAssignment catAssign = (CategoryAssignment)assign;

        // ADD CODE BELOW THIS LINE: a for statement that loops through myCategories
        for(i=0;i<myCategories.length;i++){
            // this line goes inside the for loop
            if (catAssign.getCategoryName().equals(myCategories[i])) {
                return i;
            }
        }
        
        
        // the following line is present just so that this method compiles; 
        // if the precondition is met, then this line will never be reached
        // if the precondition is not met, then an ArrayIndexOutOfBoundsException will be thrown
        return -1;
    }
    
    // add mutator method
    //
    // precondition: assign IS-A CategoryAssignment
    // postcondition: the given Assignment object is added to this Gradebook
    public void add(Assignment assign) {
        myGrades.add((CategoryAssignment)assign);        
    }
}
