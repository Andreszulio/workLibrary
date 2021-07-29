package com.example.Library.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "Resource")
public class Resources {

    @Id
    private String resourceId;
    private String typeOfResource;
    private Boolean isAvailable;
    private LocalDateTime loanDate;

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

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    public LocalDateTime getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDateTime loanDate) {
        this.loanDate = loanDate;
    }
}
