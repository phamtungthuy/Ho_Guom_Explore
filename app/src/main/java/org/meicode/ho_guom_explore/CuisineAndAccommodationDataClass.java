package org.meicode.ho_guom_explore;

public class CuisineAndAccommodationDataClass {
    private String dataTitle;
    private String dataDescription;
    private String dataLang;
    private String dataImage;

    public String getDataTitle() {
        return dataTitle;
    }

    public String getDataDescription() {
        return dataDescription;
    }

    public String getDataLang() {
        return dataLang;
    }

    public String getDataImage() {
        return dataImage;
    }

    public CuisineAndAccommodationDataClass(String dataTitle, String dataDescription, String dataLang, String dataImage) {
        this.dataTitle = dataTitle;
        this.dataDescription = dataDescription;
        this.dataLang = dataLang;
        this.dataImage = dataImage;
    }

    public CuisineAndAccommodationDataClass() {

    }
}
