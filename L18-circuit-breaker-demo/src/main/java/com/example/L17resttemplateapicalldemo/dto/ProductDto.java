package com.example.L17resttemplateapicalldemo.dto;


public class ProductDto {

    private Long id;

    private String name;
    private Double cost;

    public ProductDto(Long id, String name, Double cost) {
        this.id = id;
        this.name = name;
        this.cost = cost;
    }

    public ProductDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "ProductDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                '}';
    }
}
