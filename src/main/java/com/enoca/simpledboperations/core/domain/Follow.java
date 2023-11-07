package com.enoca.simpledboperations.core.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "FOLLOW")
@Data
public class Follow extends BaseEntity {

    @SequenceGenerator(name = "FOLLOW_ID_GENERATOR", sequenceName = "FOLLOW_ID_SEQ",allocationSize = 1)
    @GeneratedValue(generator = "FOLLOW_ID_GENERATOR")
    @Id
    private Long id;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name="IMAGE")
    private String image;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_FOLLOWER")
    private  User  follower;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_FOLLOWING")
    private User following;




}
