public class Chick  implements Animal
{
    private String myType;
    private String mySound;
    private int sounds;
    
    public Chick()
    {
        myType = "chick";
        mySound = "cluck";
    }
    
    public Chick(int s)
    {
        myType = "chick";
        mySound = "cluck";
        sounds=s;
       
    }

    public String getSound(){
        if(sounds==1)
        {
            return "cheep";
        }
        else if(sounds == 2)
        { int rand= (int)(Math.random()*2);
          //System.out.println(rand);
          if (rand==1)
          {
              return "cheep";
          }
          return "cluck";
            
        }
        return "cluck";
    }

    public String getType(){
        return myType; 
    }

}