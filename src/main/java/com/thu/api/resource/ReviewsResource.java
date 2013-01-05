package com.thu.api.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.springframework.stereotype.Component;

import com.sun.jersey.api.spring.Autowire;
import com.sun.jersey.spi.resource.Singleton;
import com.thu.api.domain.Review;
import com.thu.api.domain.service.ReviewService;
import com.thu.api.management.Monitored;


@Singleton
@Path("/reviews")
@Component
@Autowire
public class ReviewsResource {
    
	private ReviewService reviewService;
	
    @GET
    @Monitored("Reviews Read All")
    public List<Review> readAll() {
        return reviewService.findAll();
    }

    public void setReviewService(ReviewService reviewService) {
        this.reviewService = reviewService;
    }
}
