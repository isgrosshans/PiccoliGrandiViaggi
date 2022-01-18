package it.univr.studyholiday.model;

//import it.univr.studyholiday.util.Database.Add;
//import it.univr.studyholiday.util.Database.Delete;
//import it.univr.studyholiday.util.Database.Fetch;
//import it.univr.studyholiday.util.Database.Update;

//FAMILY
//(id, hhfirstname, hhlastname, hhemail, hhphone, address, members, pets, baths, beds, citydistance , schoolid)
public class Family {
    private String email;
    private String firstName;
    private String lastName;
    private School school;
    private int members;
    private boolean havePets;
    private int bedrooms;
    private int bathrooms;
    private String cityDistance;
    private String address;

    public Family(String email, String firstName, String lastName, School school,
                  int members, boolean havePets,
                  int bedrooms, int bathrooms,
                  String cityDistance) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.school = school;
        this.members = members;
        this.havePets = havePets;
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
        this.cityDistance = cityDistance;
    }

//    public Family(String email, String firstName, String lastName, String school,
//                  int members, boolean havePets,
//                  int bedrooms, int bathrooms,
//                  String cityDistance) {
//        this.email = email;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.school = School.fetch(school);
//        this.members = members;
//        this.havePets = havePets;
//        this.bedrooms = bedrooms;
//        this.bathrooms = bathrooms;
//        this.cityDistance = cityDistance;
//    }

    public String italianDescription(){
        String result="";
        result+=  "Famiglia             "+getFullName()+
                "\nComponent:           "+members+
                "\nCamere:              "+bedrooms+
                "\nBagni:               "+bathrooms+
                "\nAnimali domestici:   ";
        if(havePets) result+="sì";
        else result+="no";
        result+="\nDistanza dal centro: "+cityDistance;
        return result;
    }


    //TODO
//    public static Family fetch(String email){
//        return Fetch.family(email);
//    }
//
//    public void update() {
//        Update.update(this);
//    }
//    public void add() {
//        Add.add(this);
//    }
//    public void delete() {
//        Delete.delete(this);
//    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
//update();
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
//update();
    }
    public void setSchool(School school) {
        this.school = school;
//update();
    }
    public void setmembers(int members) {
        this.members = members;
//update();
    }
    public void setHavePets(boolean havePets) {
        this.havePets = havePets;
//update();
    }
    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
//update();
    }
    public void setBathrooms(int bathrooms) {
        this.bathrooms = bathrooms;
//update();
    }
    public void setCityDistance(String cityDistance) {
        this.cityDistance = cityDistance;
//update();
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setMembers(int members) {
        this.members = members;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public int getMembers() {
        return members;
    }
    public boolean isHavePets() {
        return havePets;
    }
    public String getAddress() {
        return address;
    }
    public String getEmail() {
        return email;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public School getSchool() {
        return school;
    }
    public int getmembers() {
        return members;
    }
    public boolean hasPets() {
        return havePets;
    }
    public int getBedrooms() {
        return bedrooms;
    }
    public int getBathrooms() {
        return bathrooms;
    }
    public String getCityDistance() {
        return cityDistance;
    }
    public String getFullName(){
        return firstName+" "+lastName;
    }
}
