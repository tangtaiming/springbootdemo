package com.example.demo.orm;

import javax.annotation.Generated;
import javax.persistence.*;

/**
 * Created by Administrator on 2017/8/16.
 */
@Entity
@Table(name = "p_user")
public class User {

    public int id;

    private String userName;


}
