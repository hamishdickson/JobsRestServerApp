package com.jhc.figleaf.resources.jobs;

import java.io.Serializable;
import java.util.regex.Pattern;

/**
 * User: DicksonH
 * Date: 05/03/14
 * Time: 11:14
 */
public class JobQuery implements Serializable {
    private static final long serialVersionUID = 1L;
    private int jobNumber;
    private static Pattern libraryPattern = Pattern.compile("[A-Z0-9[.#]]{4,10}");
    private static Pattern memberPattern = Pattern.compile("[A-Z0-9[.#@_]]{1,10}");

    public JobQuery(int jobNumber) {
        this.jobNumber = jobNumber;
    }

    /*public static JobQuery fromUserQuery(UserQuery userQuery)
    {
        if (userQuery == null) {
            return null;
        }

        String library = userQuery.getLibrary().toUpperCase();

        Matcher libraryMatcher = libraryPattern.matcher(library);
        if (!libraryMatcher.matches()) {
            return null;
        }

        File file = userQuery.getFile();

        DisplayMode displayMode = userQuery.getDisplayMode();

        if ((displayMode == DisplayMode.HIGHLIGHTED) && (file.getHighlightingType() == null)) {
            return null;
        }

        String member = userQuery.getMember().toUpperCase();

        Matcher memberMatcher = memberPattern.matcher(member);
        if (!memberMatcher.matches()) {
            return null;
        }

        return new JobQuery(library, file, member, displayMode);
    }*/

    public int getJobNumber()
    {
        return jobNumber;
    }

    @Override
    public String toString()
    {
        return "SourceQuery [jobNumber=" + jobNumber + "]";
    }
}
