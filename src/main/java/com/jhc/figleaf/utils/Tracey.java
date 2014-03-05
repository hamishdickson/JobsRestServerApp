package com.jhc.figleaf.utils;

import com.ibm.as400.access.*;
import com.jhc.figleaf.resources.jobs.JobImpl;
import com.jhc.figleaf.resources.jobs.exceptions.NoSuchJobException;
import org.apache.commons.dbcp.BasicDataSource;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * User: DicksonH
 * Date: 03/03/14
 * Time: 15:44
 */
public class Tracey {

    private static QSYSObjectPathName pathName;
    private static final String DRIVER_CLASS = "com.ibm.as400.access.AS400JDBCDriver";
    private static final String VALIDATION_QUERY = "SELECT * FROM F63HOLDDTA/CLIENT WHERE CLINO = '0000001'";
    private static final BasicDataSource BASIC_DATA_SOURCE = new BasicDataSource();
    private static final AS400 as400;
    private static final AtomicInteger uniqueInvocationNumber = new AtomicInteger();

    static {
        BASIC_DATA_SOURCE.setDriverClassName(DRIVER_CLASS);
        BASIC_DATA_SOURCE.setMaxActive(Integer.valueOf(Config.getSetting("connection.pool.max.active")));
        BASIC_DATA_SOURCE.setMaxIdle(Integer.valueOf(Config.getSetting("connection.pool.max.idle")));
        BASIC_DATA_SOURCE.setValidationQuery(VALIDATION_QUERY);
        BASIC_DATA_SOURCE.setTestOnBorrow(true);
        BASIC_DATA_SOURCE.setUsername(Config.getSetting("username"));
        BASIC_DATA_SOURCE.setPassword(Config.getSetting("password"));
        BASIC_DATA_SOURCE.setUrl("jdbc:as400://" + Config.getSetting("server.address") + ";naming=system;prompt=false");
        as400 = new AS400("TRACEY", Config.getSetting("username"), Config.getSetting("password"));
    }

    public static String getJob(int jobNumber) throws SQLException, NoSuchJobException {
        StringBuilder listing = new StringBuilder();

        ResultSet resultSet = null;
        Statement getJob = null;
        Connection connection = null;
        try {
            connection = BASIC_DATA_SOURCE.getConnection();
            getJob = connection.createStatement();
            resultSet = getJob.executeQuery("SELECT * FROM JOBS3 WHERE CODEX=" + jobNumber);
            while (resultSet.next()) {
                // TODO extract the data from the result set
            }

            getJob.close();
            resultSet.close();
        }
        catch (SQLException e) {
            throw e;
        }
        finally {
            try {
                if (connection != null)
                    connection.close();
            }
            catch (SQLException e) {
                System.err.println("Eh oh .. you're in trouble");
            }
        }

        return listing.toString();
    }

    public static List<JobImpl> getJobsForUser(String user) {

        return null;
    }

    // TODO investigate this a bit more
    public BigDecimal getJobNumber() {
        DecimalDataArea dataArea = new DecimalDataArea(as400, pathName.getPath());

        // get the next available job number
        BigDecimal jobNumber = null;
        try {
            jobNumber = dataArea.read();
        } catch (AS400SecurityException e) {
            e.printStackTrace();
        } catch (ErrorCompletingRequestException e) {
            e.printStackTrace();
        } catch (IllegalObjectTypeException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ObjectDoesNotExistException e) {
            e.printStackTrace();
        }

        try {
            if (jobNumber != null) {
                dataArea.write(jobNumber.add(new BigDecimal(1)));
            }
        } catch (AS400SecurityException e) {
            e.printStackTrace();
        } catch (ErrorCompletingRequestException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ObjectDoesNotExistException e) {
            e.printStackTrace();
        }
        return jobNumber;
    }


}
