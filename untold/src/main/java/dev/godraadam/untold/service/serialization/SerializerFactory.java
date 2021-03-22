package dev.godraadam.untold.service.serialization;

import dev.godraadam.untold.service.serialization.implementation.JsonSerializerFactory;

//abstract factory
public abstract class SerializerFactory {

    private static SerializerFactory instance;

    public static SerializerFactory getInstance() {
        if (instance == null) instance = new JsonSerializerFactory();
        return instance;
    }

    public abstract TicketSerializer getTicketSerializer();
    //other getters for other serializers such ConcertSerializer etc.

}
