package dev.godraadam.untold.dto;

public class TicketDTO extends BaseDTO {
    
    private Float price;
    private Long concertId;
    private Long seats;
    
    /**
     * @return the price
     */
    public Float getPrice() {
        return price;
    }
    /**
     * @param price the price to set
     */
    public void setPrice(Float price) {
        this.price = price;
    }
    /**
     * @return the concertId
     */
    public Long getConcertId() {
        return concertId;
    }
    /**
     * @param concertId the concertId to set
     */
    public void setConcertId(Long concertId) {
        this.concertId = concertId;
    }
    /**
     * @return the seats
     */
    public Long getSeats() {
        return seats;
    }
    /**
     * @param seats the seats to set
     */
    public void setSeats(Long seats) {
        this.seats = seats;
    }

}
