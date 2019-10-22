package net.skhu.model;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
public class BaseBoard implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer number;

    public boolean isNew(){
        return this.number == 0;
    }
}
