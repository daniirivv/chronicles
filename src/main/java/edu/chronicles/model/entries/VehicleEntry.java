package edu.chronicles.model.entries;

import edu.chronicles.model.Dimension;
import edu.chronicles.model.Traction;

import java.time.Year;
import java.util.Currency;

public class VehicleEntry extends Entry{

    private String brand;
    private Year releaseYear;
    private Currency pvp;
    private Dimension dimension;
    private Float horsePower;
    private Traction traction;

    public VehicleEntry(String model,
                        Float rating,
                        String comments,
                        String brand,
                        Year releaseYear,
                        Currency pvp,
                        Dimension dimension,
                        Float horsePower,
                        Traction traction) {
        super(model, rating, comments);
        this.brand = brand;
        this.releaseYear = releaseYear;
        this.pvp = pvp;
        this.dimension = dimension;
        this.horsePower = horsePower;
        this.traction = traction;
    }

    public VehicleEntry(String brand) {
        super(brand);
        this.brand = null;
        this.releaseYear = null;
        this.pvp = null;
        this.dimension = null;
        this.horsePower = null;
        this.traction = null;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Year getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Year releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Currency getPvp() {
        return pvp;
    }

    public void setPvp(Currency pvp) {
        this.pvp = pvp;
    }

    public Dimension getDimension() {
        return dimension;
    }

    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }

    public Float getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(Float horsePower) {
        this.horsePower = horsePower;
    }

    public Traction getTraction() {
        return traction;
    }

    public void setTraction(Traction traction) {
        this.traction = traction;
    }
}
