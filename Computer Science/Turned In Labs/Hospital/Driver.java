
public class Driver
{
    public static void main(String [] args)
    {
        
         
        HospitalWorker r = new Receptionist("Jane", 4431, "filing papers", true);
        System.out.println(r);
        System.out.println();
        
        HospitalWorker d = new Doctor("Jean", 1425, "filling prescription", "Neurology");
        System.out.println(d);
        System.out.println();
        
        HospitalWorker a = new Administrator("Nicole", 5214, "filling out time sheets", "Head of Diagnostic Medicine");
        System.out.println(a);
        System.out.println();
        
        HospitalWorker n = new Nurse("Greg", 1333, "serving lunch to a patient", 23);
        System.out.println(n);
        System.out.println();
        
        HospitalWorker s = new Surgeon("Amber", 7255, "looking at an X-ray", "Cardiology", false);
        System.out.println(s);
        System.out.println();
        
        
    }
}
