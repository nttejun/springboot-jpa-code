package com.boot.jpa.webservice.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "MEMBER")
public class Member {

    @Id
    @Column(name="ID")
    private String id;

    @Column(name="NAME", nullable = false, length = 10)
    private String username;

    private Integer age;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Lob
    private String description;

    public String getId(){return id;}
    public void setId(String id){this.id = id;}

    public String getUsername(){return username;}
    public void setUsername(String username){this.username = username;}

    public Integer getAge(){return age;}
    public void setAge(Integer age){this.age = age;}

    public Date getCreateDate(){return createDate;}
    public void setCreateDate(Date createDate){this.createDate = createDate;}

    public Date getLastModifiedDate(){return lastModifiedDate;}
    public void setLastModifiedDate(Date lastModifiedDate){this.lastModifiedDate = lastModifiedDate;}


    private enum RoleType {
        ADMIN, USER;
    }

}
