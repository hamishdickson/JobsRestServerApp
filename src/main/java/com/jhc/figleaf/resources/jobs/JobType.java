package com.jhc.figleaf.resources.jobs;

/**
 * Created with IntelliJ IDEA.
 * User: DicksonH
 * Date: 03/03/14
 * Time: 13:54
 * To change this template use File | Settings | File Templates.
 */
public enum JobType {
    JOB("J"),
    WORK_ORDER("W");

    private String jobType;

    private JobType(String s) {
        jobType = s;
    }

    private String getJobType() {
        return jobType;
    }
}
