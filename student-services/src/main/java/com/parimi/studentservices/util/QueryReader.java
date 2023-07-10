package com.parimi.studentservices.util;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

public final class QueryReader {

    public static final String GET_STUDENT_REGISTERED_COURSES;

    static {
        GET_STUDENT_REGISTERED_COURSES=loadQueryStatement("sql/getRegisteredCourses.sql");
    }
    private QueryReader() {

    }

    public static String loadQueryStatement(final String sqlPath) {

        final InputStream stream = Thread
                                    .currentThread()
                                    .getContextClassLoader()
                                    .getResourceAsStream(sqlPath);
        try {
            return IOUtils.toString(stream, Charset.defaultCharset());
        } catch (final IOException e) {
            throw new IllegalStateException(e);
        } finally {
            IOUtils.closeQuietly(stream);
        }
    }
}
