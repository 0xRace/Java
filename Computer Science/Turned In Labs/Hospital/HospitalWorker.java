public abstract class HospitalWorker
{
    private String name;
    private int idNumber;
    private String task;
    private final String position = this.getClass().getSimpleName(); 

    public HospitalWorker(String n, int id, String t){
        name = n;
        idNumber = id;
        task = t;
    }

    public abstract String work();

    public String getName(){return name;}

    public void setName(String n){name = n;}

    public int getIdNumber(){return idNumber;}

    public void setIdNumber(int id){idNumber = id;}

    public String getTask(){return task;}

    public void setTask(String t){task = t;}

    public String toString(){
        return "Name: " + name + "\nID Number: " + idNumber + "\nPosition: " + position;
    }

}
