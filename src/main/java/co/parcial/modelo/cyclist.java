package co.parcial.modelo;

import java.util.Date;

public class cyclist {
    private int id;
    private String name;
    private String email;
    private Date birthdate;
    private String country;
    private String team;

    public cyclist(int id, String name, String email, Date birthdate, String country, String team) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birthdate = birthdate;
        this.country = country;
        this.team = team;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }
    
    
}
