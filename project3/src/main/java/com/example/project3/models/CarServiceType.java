package com.example.project3.models;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "type")
public class CarServiceType {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="name")
    private String name;


    @OneToMany(mappedBy = "carServiceType")
    private List<CarServicePrice> carServicePrices;

    @OneToMany(mappedBy = "carServiceType")
    private List<RepairRequest> repairRequests;

    public CarServiceType() {}

    public CarServiceType(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<CarServicePrice> getServicePrices() {
        return carServicePrices;
    }

    public void setServicePrices(List<CarServicePrice> carServicePrices) {
        this.carServicePrices = carServicePrices;
    }

    public List<RepairRequest> getRepairRequests() {
        return repairRequests;
    }

    public void setRepairRequests(List<RepairRequest> repairRequests) {
        this.repairRequests = repairRequests;
    }

    public List<CarServicePrice> getCarServicePrices() {
        return carServicePrices;
    }

    public void setCarServicePrices(List<CarServicePrice> carServicePrices) {
        this.carServicePrices = carServicePrices;
    }

    @Override
    public String toString() {
        return "CarServiceType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

