package cn.itcast.domain;

import javax.persistence.*;

//表明该类为实体类
@Entity
//设置表名
@Table(name = "customer_user")

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
