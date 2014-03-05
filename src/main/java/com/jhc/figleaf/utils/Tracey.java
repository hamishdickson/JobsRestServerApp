package com.jhc.figleaf.utils;

import com.ibm.as400.access.*;

import java.io.IOException;
import java.math.BigDecimal;

/**
 * User: DicksonH
 * Date: 03/03/14
 * Time: 15:44
 */
public class Tracey {

    private static QSYSObjectPathName pathName;
    private static AS400 system;

    public static void createTraceyConnection() {
        system = new AS400("JAYNE");
        pathName = new QSYSObjectPathName("MYLIB", "MYDATA", "DYAARA");
    }

    public BigDecimal getJobNumber() {
        DecimalDataArea dataArea = new DecimalDataArea(system, pathName.getPath());

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
