package com.jhc.figleaf.resources.jobs;

/**
 * User: DicksonH
 * Date: 03/03/14
 * Time: 13:42
 * To change this template use File | Settings | File Templates.
 */
public class JobImpl extends Job {
    public JobImpl(int jobNumber, Status status, String system, String client, String whoDo, String descrq, String descrp, String whoPay, String extra1, String contact, int workOrderNumber, JobType jobType) {
        super(jobNumber, status, system, client, whoDo, descrq, descrp, whoPay, extra1, contact, workOrderNumber, jobType);
    }

    /**
     * Brand new job...
     */
    public JobImpl(String system, String client, String whoDo, String descrq, String descrp, String whoPay, String extra1, String contact) {
        super(0, Status.NOT_STARTED, system, client, whoDo, descrq, descrp, whoPay, extra1, contact, 0, JobType.JOB);

        // TODO get the next available job number and set it

        // TODO create a work order and set that number

    }
}
