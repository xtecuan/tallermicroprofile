/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.org.devfest.service;

import java.util.List;
import java.util.Map;
import javax.enterprise.context.Dependent;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
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
public interface BookStoreService {

    @GET
    public List<BookResponse> getAll();

//    @GET
//    @Path("mp-config")
//    public Map<String, Object> mpConfig();
}
