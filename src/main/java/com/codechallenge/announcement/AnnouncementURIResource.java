package com.codechallenge.announcement;

import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.put;
import static spark.Spark.delete;

/**
 * 
 * @author sivakumaran
 *
 */
public class AnnouncementURIResource {

    private static final String API_CONTEXT = "/service";

    private final AnnouncementService announcementService;

    public AnnouncementURIResource(AnnouncementService service) {
        this.announcementService = service;
        setupEndpoints();
    }

    private void setupEndpoints() {
        post(API_CONTEXT + "/announcements", "application/json", (request, response) -> {
            announcementService.createNewAnnouncement(request.body());
            response.status(201);
            return response;
        }, new JsonTransformer());

        get(API_CONTEXT + "/announcements/:id", "application/json", (request, response)

                -> announcementService.find(request.params(":id")), new JsonTransformer());

        get(API_CONTEXT + "/announcements", "application/json", (request, response)

                -> announcementService.findAll(), new JsonTransformer());

        put(API_CONTEXT + "/announcements/:id", "application/json", (request, response)

                -> announcementService.update(request.params(":id"), request.body()), new JsonTransformer());
       
        delete(API_CONTEXT + "/announcements/:id", "application/json", (request, response)

                -> announcementService.delete(request.params(":id")), new JsonTransformer());
    }


}
