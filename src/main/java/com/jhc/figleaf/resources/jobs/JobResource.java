package com.jhc.figleaf.resources.jobs;

import com.jhc.figleaf.hibernate.HibernateUtils;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.json.simple.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * User: DicksonH
 * Date: 03/03/14
 * Time: 12:32
 *
 * Main entry point for jobs
 */

@Path("/V1/job")
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
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/{jobNumber}")
    public Response getJob(@PathParam("jobNumber") String jobNumber) {
        try {
            HibernateUtils.setUp();

            Session session = HibernateUtils.getFactory().openSession();
            Transaction tx = null;
            tx = session.beginTransaction();

            String query = "FROM jobs3 where codex=" + jobNumber;
            List<Jobs3> list = session.createQuery(query).list();

            Jobs3 job = list.get(0);

            tx.commit();

            session.close();

            return Response.status(200).entity(job.toJson()).build();
        } catch (Exception e) {
            System.out.println("That didn't work now did it ..." + e);
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
}
