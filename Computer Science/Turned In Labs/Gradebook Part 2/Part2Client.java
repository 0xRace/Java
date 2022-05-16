/****************************************************
 **
 ** Client class for Part 2
 **
 ** This class is a Gradebook client, and is used
 ** to test the CategoryAssignment and CategoryGradebook
 ** classes.
 **
 ** First, write a program that declares an CategoryAssignment 
 ** object, and then invokes all CategoryAssignment methods using
 ** that object. Print the return values to the screen, and
 ** verify that the CategoryAssignment class works properly. 
 ** Use your MainClass.java file from Part 1 as an example. 
 ** All methods available to CategoryAssignment objects, including
 ** those inherited from the Assignment class, must be tested. 
 **
 ** Then, uncomment the code at the bottom of this file. It will 
 ** declare a CategoryGradebook object, and adds one CategoryAssignment 
 ** object to it. Then, it will invoke the calculateGrade method on the 
 ** CategoryGradebook object, and print the resulting value to the screen. 
 **
 ** Add code in between the line that calls the add method and
 ** the line that calls the calculateGrade method, and add the following
 ** other CategoryAssignments to the gradebook. Don't run the code until
 ** you add the assignments shown below, because you will get strange results! 
 **
 ** name         pts available         pts earned    category
 ** Lab 2        30                    30            Labs
 ** Test 1       30                    30            Tests
 ** Lab 3        30                    30            Labs
 ** Lab 4        30                    30            Labs
 ** Test 2       30                    15            Tests
 ** Test 3       30                    0             Tests
 ** 
 ** The grade printed should be 73.75. 
 **
 ** After this works, you should change the code so that the
 ** CategoryGradebook is instantiated with weights of 50 and 75
 ** in each category. The constructor should reduce the second
 ** weight to 50, and the grade calculated for this data should
 ** be the same as above.
 **
 ** Then, instantiate the CategoryGradebook with weights of 50
 ** and 25 in each category. The constructor should increase the 
 ** second weight to 50, and the grade calculated for this data 
 ** should be the same as above.
 **
 ****************************************************/
public class Part2Client {
    public static void main(String[] args) {
        // write your code to test the CategoryAssignment class below
        // refer to the client code from Part 1 as your example
        CategoryAssignment assign = new CategoryAssignment("Lab 2", 10, 9.99, "Math");

        // this should print Lab 2
        System.out.println("Name of assign = " + assign.getName()); 

        // this should print 10
        System.out.println("Points possible = " + assign.getPointsPossible()); 

        // this should print 9.99
        System.out.println("Points earned = " + assign.getPointsEarned());

        // this should print Math
        System.out.println("Category Name = " + assign.getCategoryName());

        
 
        String[] categories = {"Labs", "Tests"};
        int[] weights = {50, 25};
        Gradebook catGradebook = new CategoryGradebook(categories, weights);
        catGradebook.add(new CategoryAssignment("Lab 1", 30, 27, "Labs"));
        catGradebook.add(new CategoryAssignment("Lab 2"     ,   30     ,               30     ,       "Labs"));
        catGradebook.add(new CategoryAssignment("Test 1"   ,    30      ,              30      ,      "Tests"));
        catGradebook.add(new CategoryAssignment("Lab 3"   ,   30      ,              30   ,         "Labs"));
        catGradebook.add(new CategoryAssignment("Lab 4"  ,      30       ,             30      ,      "Labs"));
        catGradebook.add(new CategoryAssignment( "Test 2"  ,     30        ,            15     ,       "Tests"));
        catGradebook.add(new CategoryAssignment("Test 3"    ,   30          ,          0        ,     "Tests"));

        // add the additional assignments shown above in the comments
        // to the gradebook below this comment line and before the grade is printed

        System.out.println("The grade is " + catGradebook.calculateGrade());

    }
}
