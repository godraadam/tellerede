package dev.godraadam.untold.service.serialization.implementation;

import dev.godraadam.untold.service.serialization.SerializerFactory;
import dev.godraadam.untold.service.serialization.TicketSerializer;


//concrete factory
public class JsonSerializerFactory extends SerializerFactory {

    @Override
    public TicketSerializer getTicketSerializer() {
        return new JsonTicketSerializer();
    }

    //getters for other serializers such as ConcertSerializer etc
    
}
