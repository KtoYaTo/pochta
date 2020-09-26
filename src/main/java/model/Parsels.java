package model;

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
 
    public Parsels() {
  
    }
 
    public Parsels(String track, String address, String phone) {
         this.track = track;
         this.address = address;
         this.phone = phone;
         
    }
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
 
    @Column(name = "track", nullable = false)
    public String getTrack() {
        return track;
    }
    public void setTrack(String track) {
        this.track = track;
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

    @Override
    public String toString() {
        return "Parsels [id=" + id + ", track=" + track + ", address=" + address + ", phone=" + phone
       + "]";
    }
 
}
