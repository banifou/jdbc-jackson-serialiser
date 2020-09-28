/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.banifou.quarkus;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import java.io.IOException;

/**
 *
 * @author fouad
 */
public class BookSerializer extends StdSerializer<Book> {

    public BookSerializer(Class<Book> t) {
        super(t);
    }
    
    public BookSerializer() {
       super(Book.class);
   }

    @Override
    public void serialize(Book bw, JsonGenerator jsonGenerator, SerializerProvider sp) throws IOException {

        jsonGenerator.writeStartObject();

        jsonGenerator.writeNumberField("bookid", bw.getBookid());
        jsonGenerator.writeStringField("title", bw.getTitle());
        jsonGenerator.writeStringField("author", bw.getAuthor());

        jsonGenerator.writeStringField("isbn", bw.getIsbn());
        jsonGenerator.writeEndObject();
    }

}
