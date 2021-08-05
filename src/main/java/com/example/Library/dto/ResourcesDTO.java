package com.example.Library.dto;

public class ResourcesDTO {

    private String resourceId;
    private String typeOfResource;
    private String typeOfThematic;
    private Boolean isAvailable;
    private String loanDate;
    private String userId;

    public ResourcesDTO(){

    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getTypeOfResource() {
        return typeOfResource;
    }

    public void setTypeOfResource(String typeOfResource) {
        this.typeOfResource = typeOfResource;
    }

    public String getTypeOfThematic() {
        return typeOfThematic;
    }

    public void setTypeOfThematic(String typeOfThematic) {
        this.typeOfThematic = typeOfThematic;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    public String getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(String loanDate) {
        this.loanDate = loanDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
