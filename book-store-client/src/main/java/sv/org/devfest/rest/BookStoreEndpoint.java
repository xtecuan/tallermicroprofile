/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.org.devfest.rest;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import sv.org.devfest.response.BookResponse;
import sv.org.devfest.service.BookStoreService;

/**
 *
 * @author xtecuan
 */
@ApplicationScoped
@Path("/books")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookStoreEndpoint {

    @Inject
    @RestClient
    private BookStoreService bookStoreService;

    @Inject
    @ConfigProperty(name = "username", defaultValue = "admin")
    private String username;

    @Inject
    Config config;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response books() throws MalformedURLException {
        return Response.ok(bookStoreService.getAll()).build();
    }

    @GET
    @Path("{id}")
    public Response booksById(@PathParam("id") Long id) throws MalformedURLException {
        BookResponse r = bookStoreService.getBook(id);
        if (r != null) {
            return Response.ok(r).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    public Response create(BookResponse book) throws MalformedURLException {
        Response createResponse = bookStoreService.create(book);
        return Response.status(createResponse != null ? createResponse.getStatus() : 500).build();
    }

    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") Long id, BookResponse book) throws MalformedURLException {
        Response createResponse = bookStoreService.update(id, book);
        return Response.status(createResponse != null ? createResponse.getStatus() : 500).build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Long id) throws MalformedURLException {
        Response createResponse = bookStoreService.delete(id);
        return Response.status(createResponse != null ? createResponse.getStatus() : 500).build();
    }

    @GET
    @Path("mp-config")
    //@RolesAllowed("mysimplerole")
    public Response mpConfig() {
        Map<String, Object> configProperties = new HashMap<>();
        configProperties.put("username", username);
        configProperties.put("password", config.getValue("password", String.class));
        configProperties.put("microprofile-apis", config.getValue("microprofile.apis", String[].class));
        return Response.ok(configProperties).build();
    }

}
