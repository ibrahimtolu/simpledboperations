package com.enoca.simpledboperations.core.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    @JsonIgnore
    @Column(name = "CREATED_AT")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdAt;

    @JsonIgnore
    @Column(name = "UPDATE_AT")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime updateDate;

    @JsonIgnore
    @Column(name = "ID_UPDATE_USER",length = 19)
    private LocalDateTime idUpdateUser;


    public abstract Long getId();

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public LocalDateTime getIdUpdateUser() {
        return idUpdateUser;
    }

    public void setIdUpdateUser(LocalDateTime idUpdateUser) {
        this.idUpdateUser = idUpdateUser;
    }
}
