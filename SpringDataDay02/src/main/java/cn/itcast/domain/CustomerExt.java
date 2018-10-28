package cn.itcast.domain;

import javax.persistence.*;

@Entity
@Table(name = "customer_ext")
public class CustomerExt {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name="cust_ext_id")
    private Long custExtId;
    @Column
    private String ext;


    @OneToOne(mappedBy = "ext")
     private Customer customer;

    public Long getCustExtId() {
        return custExtId;
    }

    public void setCustExtId(Long custExtId) {
        this.custExtId = custExtId;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "CustomerExt{" +
                "custExtId=" + custExtId +
                ", ext='" + ext + '\'' +
                ", customer=" + customer +
                '}';
    }
}
