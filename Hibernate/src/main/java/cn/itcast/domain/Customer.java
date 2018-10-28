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
    @Column
    private String cust_address;
    @Column
    private String cust_age;
    @Column(name = "cust_name")
    private String custName;
    @Column
    private String cust_birthday;



    public String getCust_address() {
        return cust_address;
    }

    public void setCust_address(String cust_address) {
        this.cust_address = cust_address;
    }

    public String getCust_age() {
        return cust_age;
    }

    public void setCust_age(String cust_age) {
        this.cust_age = cust_age;
    }

    public String getCust_birthday() {
        return cust_birthday;
    }

    public void setCust_birthday(String cust_birthday) {
        this.cust_birthday = cust_birthday;
    }

    public Long getCustId() {
        return custId;
    }

    public void setCustId(Long custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "custId=" + custId +
                ", cust_address='" + cust_address + '\'' +
                ", cust_age='" + cust_age + '\'' +
                ", custName='" + custName + '\'' +
                ", cust_birthday='" + cust_birthday + '\'' +
                '}';
    }
}
