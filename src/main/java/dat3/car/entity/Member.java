package dat3.car.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Member {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String username;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String street;
    private String city;
    private int zip;
    private boolean approved;
    private int ranking;

    public Member() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Member(String username, String email, String firstName, String lastName, String street, String city, int zip, boolean approved, int ranking){
        this.username = username;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.zip = zip;
        this.approved = approved;
        this.ranking = ranking;
    }

   public String getUsername(){
       return this.username;
   }

   public String getEmail(){
       return this.email;
   }

   public String getPassword(){
       return this.password;
   }

   public String getFirstName(){
       return this.firstName;
   }

   public String getLastName(){
       return this.lastName;
   }

   public String getStreet(){
       return this.street;
   }

   public String getCity(){
       return this.city;
   }

   public int getZip(){
       return this.zip;
   }

   public boolean getApproved(){
       return this.approved;
   }

   public int getRanking(){
       return this.ranking;
   }

   public void setUsername(String username){
       this.username = username;
   }

   public void setEmail(String email){
       this.email = email;
   }

   public void setPassword(String password){
       this.password = password;
   }

   public void setFirstName(String firstName){
       this.firstName = firstName;
   }

   public void setLastName(String lastName){
       this.lastName = lastName;
   }

   public void setStreet(String street){
       this.street = street;
   }

   public void setCity(String city){
       this.city = city;
   }

   public void setZip(int zip){
       this.zip = zip;
   }

   public void setApproved(boolean approved){
       this.approved = approved;
   }

   public void setRanking(int ranking){
       this.ranking = ranking;
   }
}
