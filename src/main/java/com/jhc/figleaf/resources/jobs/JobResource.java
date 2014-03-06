package com.jhc.figleaf.resources.jobs;

import com.jhc.figleaf.resources.jobs.exceptions.NoSuchJobException;
import com.jhc.figleaf.utils.Tracey;
import com.wordnik.swagger.annotations.*;
import org.json.simple.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * User: DicksonH
 * Date: 03/03/14
 * Time: 12:32
 *
 * Main entry point for jobs
 */

@Path("/V1/job")
@Api(value = "/V1/job", description = "Operations for jobs based shizzle")
public class JobResource {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/stringTest")
    @ApiOperation(value = "Find a boring string", notes = "Some note")
    @ApiResponses(value = {
            @ApiResponse(value = "ah ok", occurs = "1")
    })
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
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{jobNumber}")
    public Response getJob(@PathParam("jobNumber") int jobNumber) {
        try {
            String result = Tracey.getJob(jobNumber);
            return Response.status(200).entity(result).build();
        } catch (NoSuchJobException nsje) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } catch (Exception e) {
            System.out.println("That didn't work now did it ..." + e);
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createJob() {
        String result = "";
        return Response.status(200).entity(result).build();
    }
/*
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)*/

}
