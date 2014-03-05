package com.jhc.figleaf.resources.persons;

import org.json.simple.JSONObject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * User: DicksonH
 * Date: 05/03/14
 * Time: 15:37
 */

@Path("/V1/person")
public class PersonResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/jsonTest")
    public String getJsonTest() {
        JSONObject json = new JSONObject();
        json.put("one", "first thing");
        json.put("two", "another thing");
        return json.toJSONString();
    }
}
