public class Administrator extends HospitalWorker
{
    private String department;
    
    public Administrator(String n, int i, String t, String dep)
    {
       super(n, i, t);
       department = dep;
    }
    
    public void setDepartment(String dep)
    {
        department = dep;
    }
    
    public String getDepartment()
    {
        return department;
    }
    
    public String work()
    {
        return "Current Task: " + getTask(); 
    }
    
    public String toString()
    {
        return super.toString() + "\nDepartment: " + department + "\n" + work();
    }
}
