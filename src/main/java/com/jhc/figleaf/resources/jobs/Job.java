package com.jhc.figleaf.resources.jobs;

/**
 * User: DicksonH
 * Date: 03/03/14
 * Time: 13:58
 *
 * abstract class for Job - used by jobs and work orders
 */
public abstract class Job {
    private int jobNumber;
    private Status status;
    private String system;
    private String client;
    private String whoDo;
    private String descrq;
    private String descrp;
    private String whoPay;
    private String extra1;
    private String contact;
    private int workOrderNumber;
    private JobType jobType;

    protected Job(int jobNumber, Status status, String system, String client, String whoDo, String descrq, String descrp, String whoPay, String extra1, String contact, int workOrderNumber, JobType jobType) {
        this.jobNumber = jobNumber;
        this.status = status;
        this.system = system;
        this.client = client;
        this.whoDo = whoDo;
        this.descrq = descrq;
        this.descrp = descrp;
        this.whoPay = whoPay;
        this.extra1 = extra1;
        this.contact = contact;
        this.workOrderNumber = workOrderNumber;
        this.jobType = jobType;
    }

    public void getJobFromTracey(int jobNumber) {
        // go away and get everything from tracey for a specific job
    }

    public int getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(int jobNumber) {
        this.jobNumber = jobNumber;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getWhoDo() {
        return whoDo;
    }

    public void setWhoDo(String whoDo) {
        this.whoDo = whoDo;
    }

    public String getDescrq() {
        return descrq;
    }

    public void setDescrq(String descrq) {
        this.descrq = descrq;
    }

    public String getDescrp() {
        return descrp;
    }

    public void setDescrp(String descrp) {
        this.descrp = descrp;
    }

    public String getWhoPay() {
        return whoPay;
    }

    public void setWhoPay(String whoPay) {
        this.whoPay = whoPay;
    }

    public String getExtra1() {
        return extra1;
    }

    public void setExtra1(String extra1) {
        this.extra1 = extra1;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public int getWorkOrderNumber() {
        return workOrderNumber;
    }

    public void setWorkOrderNumber(int workOrderNumber) {
        this.workOrderNumber = workOrderNumber;
    }

    public JobType getJobType() {
        return jobType;
    }

    public void setJobType(JobType jobType) {
        this.jobType = jobType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Job)) return false;

        Job job = (Job) o;

        if (jobNumber != job.jobNumber) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return jobNumber;
    }
}
