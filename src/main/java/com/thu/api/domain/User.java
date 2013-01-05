/*
 * Proprietary information
 * 
 * Copyright 2008 Craig MacKay. All rights reserved.
 */

package com.thu.api.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author craigmackay
 */
@Entity
@Table(name = "t_user")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "user")
public class User implements DomainObject<Long> {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pk_id")
    private Long id;
    
    @Column(name = "c_username")
    @XmlAttribute(required = true)
    private String username;
    
    @Column(name = "c_password")
    private String password;
    
    @Column(name = "c_email")
    private String email;
    
    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof User)) {
            return false;
        }
        final User other = (User) obj;
        if (hashCode() != other.hashCode()) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hashCode;
        if (id != null) {
            hashCode = 29 * id.hashCode();
        } else {
            hashCode = super.hashCode();
        }
        return hashCode;
    }

    @Override
    public String toString() {
        return new StringBuilder("User[")
            .append("id:").append(id).append(";")
            .append("]")
            .toString();
    }
    
}
