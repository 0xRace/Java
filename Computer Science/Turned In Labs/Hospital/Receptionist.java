public class Receptionist extends HospitalWorker
{
    private boolean answeringPhone;
    
    public Receptionist(String n, int i, String t, boolean ans)
    {
       super(n, i, t);
       answeringPhone = ans;
    }

    public boolean getAnsweringPhone()
    {
        return answeringPhone;
    }
    
    public void setAnsweringPhone(boolean ans)
    {
        answeringPhone = ans;
    }
    
    public String work()
    {
        return "Answering Phone: " + answeringPhone + "\nCurrent Task: " + getTask(); 
    }
    
    public String toString()
    {
        return super.toString() + "\n" + work();
    }
}
