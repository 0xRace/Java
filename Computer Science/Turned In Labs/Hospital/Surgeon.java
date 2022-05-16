public class Surgeon extends Doctor
{
    private boolean operating;
    
    public Surgeon(String n, int i, String t, String s, boolean op)
    {
       super(n, i, t, s);
       operating = op;
    }
    
    public void setOperating(boolean op)
    {
        operating = op;
    }
    
    public boolean getOperating()
    {
        return operating;
    }
    
    public String work()
    {
        return "Current Task: " + getTask(); 
    }
    
    public String toString()
    {
        return super.toString() + "\nOperating: " + operating;
    }
}
