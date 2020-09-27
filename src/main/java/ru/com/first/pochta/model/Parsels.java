package ru.com.first.pochta.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "parsels")
public class Parsels {

    private long id;
    private String track;
    private String address;
    private String phone;
    private String name;
    private int indexfrom;
    private int indexto;
    private int indexnow; 
    private float price;
    private float weight;
    private int id_courier; // ID курьера
 
    public Parsels() {
  
    }
 
    public Parsels(String track, String address, String phone, String name, int indexfrom, int indexto, int indexnow, float price, float weight, int id_courier) {
/*         this.track = track;
         this.address = address;
         this.phone = phone;
         this.name = name;*/
         this.indexfrom = indexfrom;
         this.indexto = indexto; 
         this.indexnow = indexnow;
         this.price = price;
         this.weight = weight;
         this.id_courier = id_courier;
    }
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
/*
    @Column(name = "track", nullable = false)
    public String getTrack() {
        return track;
    }
    public void setTrack(String track) {
        this.track = track;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
 
    @Column(name = "address", nullable = false)
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name = "phone", nullable = false)
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }    
*/
    @Column(name = "indexfrom", nullable = false)
    public int getIndexfrom() {
        return indexfrom;
    }
    public void setIndexfrom(int indexfrom) {
        this.indexfrom = indexfrom;
    }

    @Column(name = "indexto", nullable = false)
    public int getIndexto() {
        return indexto;
    }
    public void setIndexto(int indexto) {
        this.indexto = indexto;
    }

    @Column(name = "indexnow", nullable = false)
    public int getIndexNow() {
        return indexnow;
    }
    public void setIndexNow(int indexnow) {
        this.indexnow = indexnow;
    }
    
    @Column(name = "price", nullable = false)
    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }
    
    @Column(name = "weight", nullable = false)
    public float getWeight() {
        return weight;
    }
    public void setWeight(float weight) {
        this.weight = weight;
    }
    
    @Column(name = "id_courier", nullable = false)
    public int getIdCourier() {
        return id_courier;
    }
    public void setIdCourier(int id_courier) {
        this.id_courier = id_courier;
    }

    @Override
    public String toString() {
        return "Parsels [id=" + id + ", track=" + track + ", address=" + address + ", phone=" + phone
       + "]";
    }
 
}
