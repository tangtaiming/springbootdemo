package com.example.demo.orm;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @auther ttm
 * @date 2017/10/16
 */
@Entity
@Table(name = "tt_product_status")
public class TomtopProductStatus implements Serializable {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "status")
    private int status;

    @Column(name = "name")
    private String name;

    @Column(name = "enname")
    private String enName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }
}
