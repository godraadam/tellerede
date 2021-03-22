package dev.godraadam.untold.service.serialization.implementation;

import dev.godraadam.untold.service.serialization.SerializerFactory;
import dev.godraadam.untold.service.serialization.TicketSerializer;


//concrete factory
public class CsvSerializerFactory extends SerializerFactory {

    @Override
    public TicketSerializer getTicketSerializer() {
        return new CsvTicketSerializer();
    }
    
}
