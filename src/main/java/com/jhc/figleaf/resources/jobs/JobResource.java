package com.jhc.figleaf.resources.jobs;

import org.json.simple.JSONObject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * User: DicksonH
 * Date: 03/03/14
 * Time: 12:32
 *
 * Main entry point for jobs
 */

@Path("/job")
public class JobResource {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/stringTest")
    public String getJobTest() {
        return "hi there";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/jsonTest")
    public String getJsonTest() {
        JSONObject json = new JSONObject();
        json.put("one", "first thing");
        json.put("two", "another thing");
        return json.toJSONString();
    }

    @GET
    @Produces("application/json")
    @Path("/{jobNumber}")
    public JobImpl getJob(@PathParam("jobNumber") int jobNumber) {
        // TODO get the job details and return a job in json form
        return null;
    }
}
