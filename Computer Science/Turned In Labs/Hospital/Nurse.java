public class Nurse extends HospitalWorker
{
    private int numberOfPatients;
    
    public Nurse(String n, int i, String t, int p)
    {
       super(n, i, t);
       numberOfPatients = p;
    }
    
    public void setNumberOfPatients(int p)
    {
        numberOfPatients = p;
    }
    
    public int getNumberOfPatients()
    {
        return numberOfPatients;
    }
    
    public String work()
    {
        return "Current Task: " + getTask(); 
    }
    
    public String toString()
    {
        return super.toString() + "\nNumber of Patients: " + numberOfPatients + "\n" + work();
    }
}
