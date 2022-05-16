public class Doctor extends HospitalWorker
{
    private String specialty;
    
    public Doctor(String n, int i, String t, String s)
    {
       super(n, i, t);
       specialty = s;
    }
    
    public void setSpecialty(String s)
    {
        specialty = s;
    }
    
    public String getSpecialty()
    {
        return specialty;
    }
    
    public String work()
    {
        return "Current Task: " + getTask(); 
    }
    
    public String toString()
    {
        return super.toString() + "\nSpecialty: " + specialty + "\n" + work();
    }
}
