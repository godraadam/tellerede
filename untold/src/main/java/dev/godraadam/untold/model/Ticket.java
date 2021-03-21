package dev.godraadam.untold.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Ticket extends BaseModel {
    
    private Float price;
    @ManyToOne
    private Concert concert;
    private Long seats;

}
