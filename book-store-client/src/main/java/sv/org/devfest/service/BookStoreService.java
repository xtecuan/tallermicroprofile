/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.org.devfest.service;

import java.util.List;
import javax.enterprise.context.Dependent;
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
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import sv.org.devfest.response.BookResponse;

/**
 *
 * @author xtecuan
 */
@Dependent
@RegisterRestClient
@Path("books")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface BookStoreService {

    @GET
    public List<BookResponse> getAll();

    @GET
    @Path("{id}")
    public BookResponse getBook(@PathParam("id") Long id);

    @POST
    public Response create(BookResponse book);

    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") Long id, BookResponse book);

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Long id);
}
