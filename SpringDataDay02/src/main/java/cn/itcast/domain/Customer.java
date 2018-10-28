package cn.itcast.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

//表明该类为实体类
@Entity
//设置表名
@Table(name = "customer")
public class Customer {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long custId;

    @Column(name = "cust_address")
    private String custAddress;

    @Column(name = "cust_age")
    private String custAge;

    @Column(name = "cust_name")
    private String custName;

    @Column(name = "cust_birthday")
    private String custBirthday;

    @OneToOne
    @JoinColumn(name = "ext_id",referencedColumnName = "cust_ext_id")
    private CustomerExt ext;

    @OneToMany(mappedBy = "cus")
  //  @JoinColumn(name = "lkm_cust_id", referencedColumnName = "id")
     Set<LinkMan> linkMen = new HashSet<>();



    public Set<LinkMan> getLinkMen() {
        return linkMen;
    }

    public void setLinkMen(Set<LinkMan> linkMen) {
        this.linkMen = linkMen;
    }

    public Long getCustId() {
        return custId;
    }

    public void setCustId(Long custId) {
        this.custId = custId;
    }

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

    public String getCustAge() {
        return custAge;
    }

    public void setCustAge(String custAge) {
        this.custAge = custAge;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustBirthday() {
        return custBirthday;
    }

    public void setCustBirthday(String custBirthday) {
        this.custBirthday = custBirthday;
    }

    public CustomerExt getExt() {
        return ext;
    }

    public void setExt(CustomerExt ext) {
        this.ext = ext;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "custId=" + custId +
                ", custAddress='" + custAddress + '\'' +
                ", custAge='" + custAge + '\'' +
                ", custName='" + custName + '\'' +
                ", custBirthday='" + custBirthday + '\'' +
                '}';
    }
}
