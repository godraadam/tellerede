package dev.godraadam.untold.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConcertDTO extends BaseDTO{
    
    private String performer;
    private String title;
    private String genre;
    private String startingDate;
    private String endingDate;
    private Long maxTicketCount;
    
}
