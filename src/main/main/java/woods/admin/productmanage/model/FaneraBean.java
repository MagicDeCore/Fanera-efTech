package woods.admin.productmanage.model;


/**
 * Created by MagicDeCore on 06.01.2017.
 */
public class FaneraBean {
    public FaneraBean(){

    }



    private String faneraName;
    private String sizeFormat;
    private String depth;
    private String treatment;
    private String water_resistance;
    private String wetness;
    private String material;
    private String description;
    private int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    public String getFaneraName() {
        return faneraName;
    }

    public void setFaneraName(String faneraName) {
        this.faneraName = faneraName;
    }

    public String getSizeFormat() {
        return sizeFormat;
    }

    public void setSizeFormat(String sizeFormat) {
        this.sizeFormat = sizeFormat;
    }

    public String getDepth() {
        return depth;
    }

    public void setDepth(String depth) {
        this.depth = depth;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public String getWater_resistance() {
        return water_resistance;
    }

    public void setWater_resistance(String water_resistance) {
        this.water_resistance = water_resistance;
    }

    public String getWetness() {
        return wetness;
    }

    public void setWetness(String wetness) {
        this.wetness = wetness;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}


