// A class that represents a client appeal.
public class ClientAppeal {
    private String name; // The name of the person.
    private String id; // The id of the person.
    private String appeal; // The appeal.
    // Constructor for a ClientAppeal object.
    public ClientAppeal(String name, String id, String appeal){
        this.name = name;
        this.appeal = appeal;
        this.id = id;
    }
    // Returns the name of this object.
    public String getName(){
        return name;
    }
    // Returns the ID of this object.
    public String getID(){
        return id;
    }
    // Returns the appeal of this object.
    public String getAppeal(){
        return appeal;
    }
    // ToString

    @Override
    public String toString() {
        return "name: " + name + ", id:" + id + ", appeal:" + appeal;
    }
    // Equals

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof ClientAppeal)) return false;
        return ((ClientAppeal)obj).getID().equals(getID()) && ((ClientAppeal)obj).getAppeal().equals(getAppeal());
    }
}
