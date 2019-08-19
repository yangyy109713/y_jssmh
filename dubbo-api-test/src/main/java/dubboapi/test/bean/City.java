package dubboapi.test.bean;

import java.io.Serializable;

public class City implements Serializable {
    private static final long serialVersionUID = -1L;

    private Long id;

    private Long provinceId;

    private String cityName;

    private String description;

    public City(){

    }

    public City(Long id, Long provinceId, String cityName, String description){
        this.id = id;
        this.provinceId = provinceId;
        this.cityName = cityName;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public Long getProvinceId() {
        return provinceId;
    }

    public String getCityName() {
        return cityName;
    }

    public String getDescription() {
        return description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
