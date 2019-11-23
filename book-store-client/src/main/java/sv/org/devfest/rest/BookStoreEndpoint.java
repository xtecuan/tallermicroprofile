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
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import sv.org.devfest.service.BookStoreService;

/**
 *
 * @author xtecuan
 */
@ApplicationScoped
@Path("/books")
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
    @Path("mp-config")
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed("mysimplerole")
    public Response mpConfig() {
        Map<String, Object> configProperties = new HashMap<>();
        configProperties.put("username", username);
        configProperties.put("password", config.getValue("password", String.class));
        configProperties.put("microprofile-apis", config.getValue("microprofile.apis", String[].class));
        return Response.ok(configProperties).build();
    }

}
