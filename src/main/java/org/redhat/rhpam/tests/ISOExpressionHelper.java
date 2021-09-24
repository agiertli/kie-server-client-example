package org.redhat.rhpam.tests;


import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;

public class ISOExpressionHelper {

    public static final String REPETITIONS = "R";
    public static final String FIELD_SEPARATOR = "/";
    public static final String DEFAULT_TIMEZONE = "Z";
    public static final String DATETIME_SEPARATOR = "T";
    public static final String INFINITY = "INFINITY";
    public static final String DAYS = "D";
    public static final String HOURS = "H";
    public static final String MINUTES = "M";
    public static final String INTERVAL = "P";
    public static final String ONE = "1";
    public static final String SECOND = "S";
    public static final String DAYS_VERBOSE = "DAYS";
    public static final String MINUTES_VERBOSE = "MINUTES";
    public static final String HOURS_VERBOSE = "HOURS";
    public static final String SECONDS_VERBOSE = "SECONDS";
    private ZoneId  zoneId;

    public static String generateISOExpression(NotificationConfiguration config) {

        String isoExpression = "";
        isoExpression += REPETITIONS;

        if (!config.getNumberOfRepetitions().equals(INFINITY)) {

            isoExpression += config.getNumberOfRepetitions();
        }

        isoExpression += FIELD_SEPARATOR;

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime future = now.plus(Long.valueOf(config.getInitialDelayValue()), ChronoUnit.valueOf(config.getInitialDelayUnit()));

        isoExpression += future;
        if (config.getZoneId() == null) {
            isoExpression += DEFAULT_TIMEZONE;
        } else {

            LocalDateTime tmp = LocalDateTime.now();
            ZoneOffset offset = config.getZoneId().getRules().getOffset(tmp);
            isoExpression += offset;
        }

        isoExpression += FIELD_SEPARATOR;
        isoExpression += INTERVAL;

        if (config.getSubsequentDelayValue() != null && !config.getSubsequentDelayValue().isEmpty()) {

            if (config.getSubsequentDelayUnit().equals("DAYS")) {

                isoExpression += config.getSubsequentDelayValue() + DAYS;
            } else {

                switch (config.getSubsequentDelayUnit()) {

                    case HOURS_VERBOSE: {
                        isoExpression += DATETIME_SEPARATOR + config.getSubsequentDelayValue() + HOURS;
                        break;
                    }

                    case SECONDS_VERBOSE: {
                        isoExpression += DATETIME_SEPARATOR + config.getSubsequentDelayValue() + SECOND;
                        break;
                    }

                    case MINUTES_VERBOSE: {
                        isoExpression += DATETIME_SEPARATOR + config.getSubsequentDelayValue() + MINUTES;
                        break;
                    }

                    default: {
                        break;
                    }
                }

            }

        }

        if (config.getSubsequentDelayValue() == null || config.getSubsequentDelayValue().isEmpty()) {

            if (config.getNumberOfRepetitions().equals(ONE)) {
                isoExpression += DATETIME_SEPARATOR + ONE + SECOND;

            }
        }

        return isoExpression;

    }

}
