
package com.thu.api.resource;

import com.sun.jersey.api.spring.Autowire;
import com.sun.jersey.spi.resource.Singleton;
import com.thu.api.domain.User;
import com.thu.api.domain.service.UserService;

import java.net.URI;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import org.springframework.stereotype.Component;

/**
 *
 * @author craigmackay
 */
@Singleton
@Path("/user")
@Component
@Autowire
public class UserResource {

    @Context
    private UriInfo uriInfo;
    private UserService userService;

    @POST @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response create(User user) {
        Response response = null;
        userService.create(user);
        URI billUri = uriInfo.getAbsolutePathBuilder().
                path(String.valueOf(user.getId())).
                build();
        response = Response.created(billUri).build();
        return response;
    }
    
    @GET @Produces({ "application/xml", "application/json" })
    @Path("/{id}")
    public User get(@PathParam("id") Long id) {
        return userService.load(id);
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, User user) {
        Response response = null;
        userService.update(user);
        response = Response.noContent().build();
        return response;
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Long id) {
        userService.delete(id);
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

}
