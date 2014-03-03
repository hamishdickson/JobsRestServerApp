package com.jhc.figleaf;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Created with IntelliJ IDEA.
 * User: DicksonH
 * Date: 03/03/14
 * Time: 11:22
 * To change this template use File | Settings | File Templates.
 */

@Path("/another")
public class SecondResource {
    @GET
    @Produces("text/plain")
    public String getIt() {
        return "this is another string";
    }
}
