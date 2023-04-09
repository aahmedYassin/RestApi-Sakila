package gov.iti.jets.model.entities;
// Generated Apr 3, 2023, 5:27:06 AM by Hibernate Tools 6.1.7.Final


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import static jakarta.persistence.GenerationType.IDENTITY;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.UniqueConstraint;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Store generated by hbm2java
 */
@Entity
@Table(name="store"
    ,catalog="sakila"
    , uniqueConstraints = @UniqueConstraint(columnNames="manager_staff_id") 
)
public class Store  implements java.io.Serializable {


     private Byte storeId;
     private Staff staff;
     private Address address;
     private Timestamp lastUpdate;
     private Set<Staff> staffs = new HashSet<Staff>(0);
     private Set<Inventory> inventories = new HashSet<Inventory>(0);
     private Set<Customer> customers = new HashSet<Customer>(0);

    public Store() {
    }

	
    public Store(Staff staff, Address address, Timestamp lastUpdate) {
        this.staff = staff;
        this.address = address;
        this.lastUpdate = lastUpdate;
    }
    public Store(Staff staff, Address address, Timestamp lastUpdate, Set<Staff> staffs, Set<Inventory> inventories, Set<Customer> customers) {
       this.staff = staff;
       this.address = address;
       this.lastUpdate = lastUpdate;
       this.staffs = staffs;
       this.inventories = inventories;
       this.customers = customers;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="store_id", unique=true, nullable=false)
    public Byte getStoreId() {
        return this.storeId;
    }
    
    public void setStoreId(Byte storeId) {
        this.storeId = storeId;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="manager_staff_id", unique=true, nullable=false)
    public Staff getStaff() {
        return this.staff;
    }
    
    public void setStaff(Staff staff) {
        this.staff = staff;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="address_id", nullable=false)
    public Address getAddress() {
        return this.address;
    }
    
    public void setAddress(Address address) {
        this.address = address;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="last_update", nullable=false, length=19)
    public Timestamp getLastUpdate() {
        return this.lastUpdate;
    }
    
    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="store")
    public Set<Staff> getStaffs() {
        return this.staffs;
    }
    
    public void setStaffs(Set<Staff> staffs) {
        this.staffs = staffs;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="store")
    public Set<Inventory> getInventories() {
        return this.inventories;
    }
    
    public void setInventories(Set<Inventory> inventories) {
        this.inventories = inventories;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="store")
    public Set<Customer> getCustomers() {
        return this.customers;
    }
    
    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }




}


