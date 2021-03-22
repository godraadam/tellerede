package dev.godraadam.untold.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TicketDTO extends BaseDTO {
    
    private Float price;
    private Long concertId;
    private Long seats;

    
    

}
