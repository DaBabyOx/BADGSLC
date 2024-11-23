package MnT;

public class Person {
    private String name, id, gender, role;

    public Person(String name, String id, String gender, String role){
        this.name = name;
        this.id = id;
        this.gender = gender;
        this.role = role;}

    public String getName(){
        return name;}

    public String getId(){
        return id;}

    public String getGender(){
        return gender;}

    public String getRole(){
        return role;}}
