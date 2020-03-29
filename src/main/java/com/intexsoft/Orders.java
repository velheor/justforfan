package com.intexsoft;

import java.util.Date;

public class Orders {
    int orderno;
    String date;
    String trackingno;
    int custid;
    Customer customer;

    public void setOrderno(int orderno) {
        this.orderno = orderno;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTrackingno(String trackingno) {
        this.trackingno = trackingno;
    }

    public void setCustid(int custid) {
        this.custid = custid;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
