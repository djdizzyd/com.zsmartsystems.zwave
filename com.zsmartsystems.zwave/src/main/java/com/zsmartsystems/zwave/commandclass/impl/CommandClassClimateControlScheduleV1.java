/**
 * Copyright (c) 2014-2016 by the respective copyright holders.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.zsmartsystems.zwave.commandclass.impl;

import java.io.ByteArrayOutputStream;
import java.lang.IllegalArgumentException;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class to implement the Z-Wave command class <b>COMMAND_CLASS_CLIMATE_CONTROL_SCHEDULE</b> version <b>1</b>.<br>
 *
 * Command Class Climate Control Schedule<br>
 *
 * This class provides static methods for processing received messages (message handler) and
 * methods to get a message to send on the Z-Wave network.<br>
 *
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class CommandClassClimateControlScheduleV1 {
    private static final Logger logger = LoggerFactory.getLogger(CommandClassClimateControlScheduleV1.class);

    /**
     * Integer command class key for COMMAND_CLASS_CLIMATE_CONTROL_SCHEDULE
     */
    public final static int COMMAND_CLASS_KEY = 0x46;

    /**
     * Schedule Set Command Constant
     */
    public final static int SCHEDULE_SET = 0x01;
    /**
     * Schedule Get Command Constant
     */
    public final static int SCHEDULE_GET = 0x02;
    /**
     * Schedule Report Command Constant
     */
    public final static int SCHEDULE_REPORT = 0x03;
    /**
     * Schedule Changed Get Command Constant
     */
    public final static int SCHEDULE_CHANGED_GET = 0x04;
    /**
     * Schedule Changed Report Command Constant
     */
    public final static int SCHEDULE_CHANGED_REPORT = 0x05;
    /**
     * Schedule Override Set Command Constant
     */
    public final static int SCHEDULE_OVERRIDE_SET = 0x06;
    /**
     * Schedule Override Get Command Constant
     */
    public final static int SCHEDULE_OVERRIDE_GET = 0x07;
    /**
     * Schedule Override Report Command Constant
     */
    public final static int SCHEDULE_OVERRIDE_REPORT = 0x08;

    /**
     * Creates a new message with the SCHEDULE_SET command.<br>
     *
     * Schedule Set<br>
     *
     *
     * @param weekday {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getScheduleSet(Integer weekday) {
        logger.debug("Creating command message SCHEDULE_SET version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(SCHEDULE_SET);

        // Process 'Properties1'
        outputData.write(weekday & 0x07);

        // Process 'Switchpoint 0'

        // Process 'Switchpoint 1'

        // Process 'Switchpoint 2'

        // Process 'Switchpoint 3'

        // Process 'Switchpoint 4'

        // Process 'Switchpoint 5'

        // Process 'Switchpoint 6'

        // Process 'Switchpoint 7'

        // Process 'Switchpoint 8'

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the SCHEDULE_SET command<br>
     *
     * Schedule Set<br>
     *
     *
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>WEEKDAY {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleScheduleSet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Properties1'
        response.put("WEEKDAY", Integer.valueOf(payload[2] & 0x07));

        // Process 'Switchpoint 0'

        // Process 'Switchpoint 1'

        // Process 'Switchpoint 2'

        // Process 'Switchpoint 3'

        // Process 'Switchpoint 4'

        // Process 'Switchpoint 5'

        // Process 'Switchpoint 6'

        // Process 'Switchpoint 7'

        // Process 'Switchpoint 8'

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the SCHEDULE_GET command.<br>
     *
     * Schedule Get<br>
     *
     *
     * @param weekday {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getScheduleGet(Integer weekday) {
        logger.debug("Creating command message SCHEDULE_GET version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(SCHEDULE_GET);

        // Process 'Properties1'
        outputData.write(weekday & 0x07);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the SCHEDULE_GET command<br>
     *
     * Schedule Get<br>
     *
     *
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>WEEKDAY {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleScheduleGet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Properties1'
        response.put("WEEKDAY", Integer.valueOf(payload[2] & 0x07));

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the SCHEDULE_REPORT command.<br>
     *
     * Schedule Report<br>
     *
     *
     * @param weekday {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getScheduleReport(Integer weekday) {
        logger.debug("Creating command message SCHEDULE_REPORT version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(SCHEDULE_REPORT);

        // Process 'Properties1'
        outputData.write(weekday & 0x07);

        // Process 'Switchpoint 0'

        // Process 'Switchpoint 1'

        // Process 'Switchpoint 2'

        // Process 'Switchpoint 3'

        // Process 'Switchpoint 4'

        // Process 'Switchpoint 5'

        // Process 'Switchpoint 6'

        // Process 'Switchpoint 7'

        // Process 'Switchpoint 8'

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the SCHEDULE_REPORT command<br>
     *
     * Schedule Report<br>
     *
     *
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>WEEKDAY {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleScheduleReport(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Properties1'
        response.put("WEEKDAY", Integer.valueOf(payload[2] & 0x07));

        // Process 'Switchpoint 0'

        // Process 'Switchpoint 1'

        // Process 'Switchpoint 2'

        // Process 'Switchpoint 3'

        // Process 'Switchpoint 4'

        // Process 'Switchpoint 5'

        // Process 'Switchpoint 6'

        // Process 'Switchpoint 7'

        // Process 'Switchpoint 8'

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the SCHEDULE_CHANGED_GET command.<br>
     *
     * Schedule Changed Get<br>
     *
     *
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getScheduleChangedGet() {
        logger.debug("Creating command message SCHEDULE_CHANGED_GET version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(SCHEDULE_CHANGED_GET);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the SCHEDULE_CHANGED_GET command<br>
     *
     * Schedule Changed Get<br>
     *
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleScheduleChangedGet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the SCHEDULE_CHANGED_REPORT command.<br>
     *
     * Schedule Changed Report<br>
     *
     *
     * @param changecounter {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getScheduleChangedReport(Integer changecounter) {
        logger.debug("Creating command message SCHEDULE_CHANGED_REPORT version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(SCHEDULE_CHANGED_REPORT);

        // Process 'ChangeCounter'
        outputData.write(changecounter);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the SCHEDULE_CHANGED_REPORT command<br>
     *
     * Schedule Changed Report<br>
     *
     *
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>CHANGECOUNTER {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleScheduleChangedReport(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'ChangeCounter'
        response.put("CHANGECOUNTER", Integer.valueOf(payload[2]));

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the SCHEDULE_OVERRIDE_SET command.<br>
     *
     * Schedule Override Set<br>
     *
     *
     * @param overrideType {@link Integer}
     * @param overrideState {@link String}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getScheduleOverrideSet(Integer overrideType, String overrideState) {
        logger.debug("Creating command message SCHEDULE_OVERRIDE_SET version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(SCHEDULE_OVERRIDE_SET);

        // Process 'Properties1'
        outputData.write(overrideType & 0x03);

        // Process 'Override State'
        switch (overrideState) {
            case "NO_OVERRIDE":
                outputData.write(0x00);
                break;
            case "TEMPORARY_OVERRIDE":
                outputData.write(0x01);
                break;
            case "PERMANENT_OVERRIDE":
                outputData.write(0x02);
                break;
            default:
                throw new IllegalArgumentException("Unknown constant value for overrideState: " + overrideState);
        }

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the SCHEDULE_OVERRIDE_SET command<br>
     *
     * Schedule Override Set<br>
     *
     *
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>OVERRIDE_TYPE {@link Integer}
     * <li>OVERRIDE_STATE {@link String}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleScheduleOverrideSet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Properties1'
        response.put("OVERRIDE_TYPE", Integer.valueOf(payload[2] & 0x03));

        // Process 'Override State'
        switch ((int) payload[3]) {
            case (byte) 0x00:
                response.put("OVERRIDE_STATE", "NO_OVERRIDE");
                break;
            case (byte) 0x01:
                response.put("OVERRIDE_STATE", "TEMPORARY_OVERRIDE");
                break;
            case (byte) 0x02:
                response.put("OVERRIDE_STATE", "PERMANENT_OVERRIDE");
                break;
            default:
                logger.debug("Unknown value {} for constant 'OVERRIDE_STATE'", String.format("%02X", payload[3]));
                response.put("OVERRIDE_STATE", "UNKNOWN_" + String.format("%02X", payload[3]));
                break;
        }

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the SCHEDULE_OVERRIDE_GET command.<br>
     *
     * Schedule Override Get<br>
     *
     *
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getScheduleOverrideGet() {
        logger.debug("Creating command message SCHEDULE_OVERRIDE_GET version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(SCHEDULE_OVERRIDE_GET);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the SCHEDULE_OVERRIDE_GET command<br>
     *
     * Schedule Override Get<br>
     *
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleScheduleOverrideGet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the SCHEDULE_OVERRIDE_REPORT command.<br>
     *
     * Schedule Override Report<br>
     *
     *
     * @param overrideType {@link Integer}
     * @param overrideState {@link String}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getScheduleOverrideReport(Integer overrideType, String overrideState) {
        logger.debug("Creating command message SCHEDULE_OVERRIDE_REPORT version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(SCHEDULE_OVERRIDE_REPORT);

        // Process 'Properties1'
        outputData.write(overrideType & 0x03);

        // Process 'Override State'
        switch (overrideState) {
            case "NO_OVERRIDE":
                outputData.write(0x00);
                break;
            case "TEMPORARY_OVERRIDE":
                outputData.write(0x01);
                break;
            case "PERMANENT_OVERRIDE":
                outputData.write(0x02);
                break;
            default:
                throw new IllegalArgumentException("Unknown constant value for overrideState: " + overrideState);
        }

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the SCHEDULE_OVERRIDE_REPORT command<br>
     *
     * Schedule Override Report<br>
     *
     *
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>OVERRIDE_TYPE {@link Integer}
     * <li>OVERRIDE_STATE {@link String}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleScheduleOverrideReport(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Properties1'
        response.put("OVERRIDE_TYPE", Integer.valueOf(payload[2] & 0x03));

        // Process 'Override State'
        switch ((int) payload[3]) {
            case (byte) 0x00:
                response.put("OVERRIDE_STATE", "NO_OVERRIDE");
                break;
            case (byte) 0x01:
                response.put("OVERRIDE_STATE", "TEMPORARY_OVERRIDE");
                break;
            case (byte) 0x02:
                response.put("OVERRIDE_STATE", "PERMANENT_OVERRIDE");
                break;
            default:
                logger.debug("Unknown value {} for constant 'OVERRIDE_STATE'", String.format("%02X", payload[3]));
                response.put("OVERRIDE_STATE", "UNKNOWN_" + String.format("%02X", payload[3]));
                break;
        }

        // Return the map of processed response data;
        return response;
    }

}