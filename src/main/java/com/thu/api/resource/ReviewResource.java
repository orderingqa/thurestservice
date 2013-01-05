package com.thu.api.resource;

import java.net.URI;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.springframework.stereotype.Component;

import com.sun.jersey.api.spring.Autowire;
import com.sun.jersey.spi.resource.Singleton;
import com.thu.api.domain.Review;
import com.thu.api.domain.service.ReviewService;

@Singleton
@Path("/review")
@Component
@Autowire
public class ReviewResource {
    @Context
    private UriInfo uriInfo;
    private ReviewService reviewService;
	
    @POST
    public Response create(Review review) {
        Response response = null;
        reviewService.create(review);
        URI billUri = uriInfo.getAbsolutePathBuilder().
                path(String.valueOf(review.getId())).
                build();
        response = Response.created(billUri).build();
        return response;
    }
    
    @GET
    @Path("/{id}")
    public Review get(@PathParam("id") Long id) {
        return reviewService.load(id);
    }
    
    public void setReviewService(ReviewService reviewService) {
        this.reviewService = reviewService;
    }
}
