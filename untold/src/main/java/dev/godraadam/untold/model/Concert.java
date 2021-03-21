package dev.godraadam.untold.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Concert extends BaseModel {
    
    private String performer;
    private String title;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    @Enumerated(EnumType.STRING)
    private Genre genre;
    private Long maxTicketCount;
}
