package com.jhc.figleaf.resources.jobs;

/**
 * User: DicksonH
 * Date: 03/03/14
 * Time: 14:00
 * To change this template use File | Settings | File Templates.
 */
public class WorkOrder extends Job {
    protected WorkOrder(int jobNumber, Status status, String system, String client, String whoDo, String descrq, String descrp, String whoPay, String extra1, String contact, int workOrderNumber, JobType jobType) {
        super(jobNumber, status, system, client, whoDo, descrq, descrp, whoPay, extra1, contact, workOrderNumber, jobType);
    }
}
