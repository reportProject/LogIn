package net.skhu.authority;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Table;

import net.skhu.model.BaseEntity;

@Entity
public class Authority extends BaseEntity {
    private String studentAuthority;
    private String professorAuthority;
    private String taAuthority;
}