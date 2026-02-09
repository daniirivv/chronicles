package edu.chronicles.model.entries;

import edu.chronicles.model.Address;
import edu.chronicles.model.Gastronomy;
import edu.chronicles.model.Rating;

import java.time.LocalDate;

public class RestaurantEntry extends Entry{

    private Address address;
    private Gastronomy gastronomy;
    private Boolean allowsPets;

    public RestaurantEntry(String name,
                           Rating rating,
                           String comments,
                           LocalDate entryDate,
                           Address address,
                           Gastronomy gastronomy,
                           Boolean allowsPets) {
        super(name, rating, comments);
        this.address = address;
        this.gastronomy = gastronomy;
        this.allowsPets = allowsPets;
    }

    public RestaurantEntry(String name) {
        super(name);
        this.address = null;
        this.gastronomy = null;
        this.allowsPets = null;
    }

    public Address getAddress() {
        return this.address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Gastronomy getGastronomyType() {
        return this.gastronomy;
    }

    public void setGastronomyType(Gastronomy gastronomy) {
        this.gastronomy = gastronomy;
    }

    public Boolean getAllowsPets() {
        return this.allowsPets;
    }

    public void setAllowsPets(Boolean allowsPets) {
        this.allowsPets = allowsPets;
    }
}
