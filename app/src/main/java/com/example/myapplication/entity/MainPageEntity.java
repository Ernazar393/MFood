package com.example.myapplication.entity;

public class MainPageEntity {
    private String key;
    private String nameOfFood;
    private String categoryOfFood;
    private String descriptionOfFood;
    private String ingredientsOfFood;
    private String priceOfFood;
    private String timeOfFood;
    private String cookingOfFood;
    private String serviceSize;
    private String videoTutorial;
    private String onlineMarketOfFood;
    private String imageOfFood;

    public MainPageEntity() {}

    public MainPageEntity(String nameOfFood, String categoryOfFood, String descriptionOfFood, String ingredientsOfFood,
                          String priceOfFood, String timeOfFood, String cookingOfFood, String serviceSize, String videoTutorial,
                          String onlineMarketOfFood, String imageOfFood) {
        this.nameOfFood = nameOfFood;
        this.categoryOfFood = categoryOfFood;
        this.descriptionOfFood = descriptionOfFood;
        this.ingredientsOfFood = ingredientsOfFood;
        this.priceOfFood = priceOfFood;
        this.timeOfFood = timeOfFood;
        this.cookingOfFood = cookingOfFood;
        this.serviceSize = serviceSize;
        this.videoTutorial = videoTutorial;
        this.onlineMarketOfFood = onlineMarketOfFood;
        this.imageOfFood = imageOfFood;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getNameOfFood() {
        return nameOfFood;
    }

    public void setNameOfFood(String nameOfFood) {
        this.nameOfFood = nameOfFood;
    }

    public String getCategoryOfFood() {
        return categoryOfFood;
    }

    public void setCategoryOfFood(String categoryOfFood) {
        this.categoryOfFood = categoryOfFood;
    }

    public String getDescriptionOfFood() {
        return descriptionOfFood;
    }

    public void setDescriptionOfFood(String descriptionOfFood) {
        this.descriptionOfFood = descriptionOfFood;
    }

    public String getIngredientsOfFood() {
        return ingredientsOfFood;
    }

    public void setIngredientsOfFood(String ingredientsOfFood) {
        this.ingredientsOfFood = ingredientsOfFood;
    }

    public String getPriceOfFood() {
        return priceOfFood;
    }

    public void setPriceOfFood(String priceOfFood) {
        this.priceOfFood = priceOfFood;
    }

    public String getTimeOfFood() {
        return timeOfFood;
    }

    public void setTimeOfFood(String timeOfFood) {
        this.timeOfFood = timeOfFood;
    }

    public String getCookingOfFood() {
        return cookingOfFood;
    }

    public void setCookingOfFood(String cookingOfFood) {
        this.cookingOfFood = cookingOfFood;
    }

    public String getServiceSize() {
        return serviceSize;
    }

    public void setServiceSize(String serviceSize) {
        this.serviceSize = serviceSize;
    }

    public String getVideoTutorial() {
        return videoTutorial;
    }

    public void setVideoTutorial(String videoTutorial) {
        this.videoTutorial = videoTutorial;
    }

    public String getOnlineMarketOfFood() {
        return onlineMarketOfFood;
    }

    public void setOnlineMarketOfFood(String onlineMarketOfFood) {
        this.onlineMarketOfFood = onlineMarketOfFood;
    }

    public String getImageOfFood() {
        return imageOfFood;
    }

    public void setImageOfFood(String imageOfFood) {
        this.imageOfFood = imageOfFood;
    }
}
