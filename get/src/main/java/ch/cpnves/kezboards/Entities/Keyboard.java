package ch.cpnves.kezboards.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Keyboard {

    private @Id
    @GeneratedValue Long id;
    private String name;
    private String PCBFormat;
    private String housing;
    private int numberOfKeycaps = 104;

    public Keyboard(){}

    public Keyboard(String name, String PCBFormat, String housing, int numberOfKeycaps){
        this.setName(name);
        this.setPCBFormat(PCBFormat);
        this.setHousing(housing);
        this.setNumberOfKeycaps(numberOfKeycaps);
    }

    public Long getID(){
        
        return this.id;
    }

    public void setId(Long id){
        
        this.id = id;
    }

    public String getName(){
        
        return this.name;
    }

    public void setName(String name){
        
        this.name = name;
    }

    public int getNumberOfKeycaps() {
        return numberOfKeycaps;
    }

    public void setNumberOfKeycaps(int numberOfKeycaps) {
        this.numberOfKeycaps = numberOfKeycaps;
    }

    public String getPCBFormat() {
        return PCBFormat;
    }

    public void setPCBFormat(String PCBFormat) {
        this.PCBFormat = PCBFormat;
    }

    public String getHousing() {
        return housing;
    }

    public void setHousing(String housing) {
        this.housing = housing;
    }

    @Override
    public boolean equals(Object o){
        if(this == o)
            return true;
        if(!(o instanceof Keyboard keyboard))
            return false;
        return Objects.equals(this.id, keyboard.id) && Objects.equals(this.name, keyboard.name)
                && Objects.equals(this.PCBFormat, keyboard.PCBFormat) && Objects.equals(this.housing, keyboard.housing);
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.id, this.name, this.PCBFormat, this.housing);
    }

    @Override
    public String toString(){
        return "Keyboard{" + "id=" + this.getID() + ", name='" + this.getName() + '\'' + ", PCBFormat='" + this.getPCBFormat() + '\'' + ", housing='" + this.getHousing() + '\'' + ", numberOfKeycaps=" + this.getNumberOfKeycaps() + '}';
    }
}
