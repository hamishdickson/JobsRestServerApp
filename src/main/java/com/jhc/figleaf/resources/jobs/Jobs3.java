package com.jhc.figleaf.resources.jobs;

import org.json.simple.JSONObject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * User: DicksonH
 * Date: 04/03/14
 * Time: 12:27
 */
@Entity
@Table(name="JOBS3")
public class Jobs3 {

    private int codex;
    private String status;
    private String system;
    private String client;
    private String doing;
    private String priority;
    private String description;

    public Jobs3() {}

    public Jobs3(String status, String client, String description) {
        this.status = status;
        this.client = client;
        this.description = description;
    }

    @Id
    @Column(name = "CODEX")
    public int getCodex() {
        return codex;
    }

    public void setCodex(int codex) {
        this.codex = codex;
    }

    @Column(name = "STATUS")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Column(name = "CLIENT")
    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    @Column(name = "DESCRQ")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "SYSTEM")
    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    @Column(name = "WHODO")
    public String getDoing() {
        return doing;
    }

    public void setDoing(String doing) {
        this.doing = doing;
    }

    @Column(name = "PRIORI")
    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String toJson() {
        JSONObject json = new JSONObject();
        json.put("jobNumber", codex);
        json.put("system", system);
        json.put("status", status);
        json.put("client", client);
        json.put("doing", doing);
        json.put("priority", priority);
        json.put("description", description);

        return json.toString();
    }

}
