package io.banifou.quarkus;

import io.banifou.quarkus.jpa.BookRepos;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.MediaType;

import org.jboss.logging.Logger;

@Path("/api")
@RequestScoped
public class BookResource implements PanacheRepository<Book> {

    private static final Logger LOGGER = Logger.getLogger(BookResource.class.getName());

    @Inject
    EntityManager entityManager;
    
    final BookRepos bookRepository;

    @Inject
    public BookResource(BookRepos bookOfferRepository) {
        this.bookRepository = bookOfferRepository;
    }
    
    @GET
    @Path("/books")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listBasket() {

        List<Basket> lstSet = bookRepository.findAllBaskets();
//            LOGGER.info("listBasket lstSet: " + lstSet.size());

        if (!lstSet.isEmpty()) {
            return Response.ok(lstSet).build();
        } else {
            LOGGER.info("No Basket found ");
            return Response.status(Response.Status.NO_CONTENT).build(); // 204
        }
    }

}
