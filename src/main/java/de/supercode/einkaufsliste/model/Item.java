package de.supercode.einkaufsliste.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String itemName;
    private int itemAnzahl;
    private String ladenName;
    private boolean gekauft;

    // Getter und Setter
    public Long getId(){
        return id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemAnzahl() {
        return itemAnzahl;
    }

    public void setItemAnzahl(int itemAnzahl) {
        this.itemAnzahl = itemAnzahl;
    }

    public String getLadenName() {
        return ladenName;
    }

    public void setLadenName(String ladenName) {
        this.ladenName = ladenName;
    }

    public boolean isGekauft() {
        return gekauft;
    }

    public void setGekauft(boolean gekauft) {
        this.gekauft = gekauft;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + itemName + '\'' +
                ", menge=" + itemAnzahl +
                ", laden='" + ladenName + '\'' +
                ", gekauft=" + gekauft +
                '}';
    }
}