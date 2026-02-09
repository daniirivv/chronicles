package edu.chronicles.model.entries;

import edu.chronicles.model.Address;
import edu.chronicles.model.GastronomyType;
import edu.chronicles.model.Rating;

import java.time.LocalDate;

public class RestaurantEntry extends Entry{

    private Address address;
    private GastronomyType gastronomyType;
    private Boolean allowsPets;

    public RestaurantEntry(String name,
                           Rating rating,
                           String comments,
                           LocalDate entryDate,
                           Address address,
                           GastronomyType gastronomyType,
                           Boolean allowsPets) {
        super(name, rating, comments);
        this.address = address;
        this.gastronomyType = gastronomyType;
        this.allowsPets = allowsPets;
    }

    public RestaurantEntry(String name) {
        super(name);
        this.address = null;
        this.gastronomyType = null;
        this.allowsPets = null;
    }

    public Address getAddress() {
        return this.address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public GastronomyType getGastronomyType() {
        return this.gastronomyType;
    }

    public void setGastronomyType(GastronomyType gastronomyType) {
        this.gastronomyType = gastronomyType;
    }

    public Boolean getAllowsPets() {
        return this.allowsPets;
    }

    public void setAllowsPets(Boolean allowsPets) {
        this.allowsPets = allowsPets;
    }
}
