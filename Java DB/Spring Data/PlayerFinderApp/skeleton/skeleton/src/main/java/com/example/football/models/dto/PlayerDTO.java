package com.example.football.models.dto;

import com.example.football.models.entity.Position;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "player")
@XmlAccessorType(XmlAccessType.FIELD)
public class PlayerDTO {

    @NotNull
    @Size(min = 2)
    @XmlElement(name = "first-name")
    private String firstName;

    @NotNull
    @Size(min = 2)
    @XmlElement(name = "last-name")
    private String lastName;

    @Email
    @NotNull
    @XmlElement
    private String email;

    @NotNull
    @XmlElement(name = "birth-date")
    private String birthDate;

    @NotNull
    @XmlElement
    private Position position;

    @XmlElement(name = "town")
    private TownBasicDTO town;

    @XmlElement(name = "team")
    private TeamBasicDTO team;

    @XmlElement(name = "stat")
    private StatBasicDTO stat;

    public PlayerDTO() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public TownBasicDTO getTown() {
        return town;
    }

    public void setTown(TownBasicDTO town) {
        this.town = town;
    }

    public TeamBasicDTO getTeam() {
        return team;
    }

    public void setTeam(TeamBasicDTO team) {
        this.team = team;
    }

    public StatBasicDTO getStat() {
        return stat;
    }

    public void setStat(StatBasicDTO stat) {
        this.stat = stat;
    }
}
