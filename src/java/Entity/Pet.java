/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author LENOVO
 */
public class Pet {
    private String petId;
    private String ownerId;
    private String petTypeId;
    private String name;
    private BigDecimal weight;
    private String breed;
    private Date birthdate;

    public Pet() {
    }

    public Pet(String ownerId, String petTypeId, String name, BigDecimal weight, String breed, Date birthdate) {
        this.ownerId = ownerId;
        this.petTypeId = petTypeId;
        this.name = name;
        this.weight = weight;
        this.breed = breed;
        this.birthdate = birthdate;
    }

    public Pet(String petId, String ownerId, String petTypeId, String name, BigDecimal weight, String breed, Date birthdate) {
        this.petId = petId;
        this.ownerId = ownerId;
        this.petTypeId = petTypeId;
        this.name = name;
        this.weight = weight;
        this.breed = breed;
        this.birthdate = birthdate;
    }

    public String getPetId() {
        return petId;
    }

    public void setPetId(String petId) {
        this.petId = petId;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getPetTypeId() {
        return petTypeId;
    }

    public void setPetTypeId(String petTypeId) {
        this.petTypeId = petTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public String toString() {
        return "Pet{" + "petId=" + petId + ", ownerId=" + ownerId + ", petTypeId=" + petTypeId + ", name=" + name + ", weight=" + weight + ", breed=" + breed + ", birthdate=" + birthdate + '}';
    }
    
}
