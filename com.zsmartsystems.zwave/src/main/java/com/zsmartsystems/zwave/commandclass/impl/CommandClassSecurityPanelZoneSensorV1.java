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
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class to implement the Z-Wave command class <b>COMMAND_CLASS_SECURITY_PANEL_ZONE_SENSOR</b> version <b>1</b>.<br>
 *
 * Command Class Security Panel Zone Sensor<br>
 *
 * This class provides static methods for processing received messages (message handler) and
 * methods to get a message to send on the Z-Wave network.<br>
 *
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class CommandClassSecurityPanelZoneSensorV1 {
    private static final Logger logger = LoggerFactory.getLogger(CommandClassSecurityPanelZoneSensorV1.class);

    /**
     * Integer command class key for COMMAND_CLASS_SECURITY_PANEL_ZONE_SENSOR
     */
    public final static int COMMAND_CLASS_KEY = 0x2F;

    /**
     * Security Panel Zone Sensor Installed Get Command Constant
     */
    public final static int SECURITY_PANEL_ZONE_SENSOR_INSTALLED_GET = 0x01;
    /**
     * Command Class Security Panel Zone Sensor Installed Report Command Constant
     */
    public final static int COMMAND_CLASS_SECURITY_PANEL_ZONE_SENSOR_INSTALLED_REPORT = 0x02;
    /**
     * Security Panel Zone Sensor Type Get Command Constant
     */
    public final static int SECURITY_PANEL_ZONE_SENSOR_TYPE_GET = 0x03;
    /**
     * Security Panel Zone Sensor Type Report Command Constant
     */
    public final static int SECURITY_PANEL_ZONE_SENSOR_TYPE_REPORT = 0x04;
    /**
     * Security Panel Zone Sensor State Get Command Constant
     */
    public final static int SECURITY_PANEL_ZONE_SENSOR_STATE_GET = 0x05;
    /**
     * Security Panel Zone Sensor State Report Command Constant
     */
    public final static int SECURITY_PANEL_ZONE_SENSOR_STATE_REPORT = 0x06;

    /**
     * Creates a new message with the SECURITY_PANEL_ZONE_SENSOR_INSTALLED_GET command.<br>
     *
     * Security Panel Zone Sensor Installed Get<br>
     *
     *
     * @param zoneNumber {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getSecurityPanelZoneSensorInstalledGet(Integer zoneNumber) {
        logger.debug("Creating command message SECURITY_PANEL_ZONE_SENSOR_INSTALLED_GET version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(SECURITY_PANEL_ZONE_SENSOR_INSTALLED_GET);

        // Process 'Zone number'
        outputData.write(zoneNumber);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the SECURITY_PANEL_ZONE_SENSOR_INSTALLED_GET command<br>
     *
     * Security Panel Zone Sensor Installed Get<br>
     *
     *
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>ZONE_NUMBER {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleSecurityPanelZoneSensorInstalledGet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Zone number'
        response.put("ZONE_NUMBER", Integer.valueOf(payload[2]));

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the COMMAND_CLASS_SECURITY_PANEL_ZONE_SENSOR_INSTALLED_REPORT command.<br>
     *
     * Command Class Security Panel Zone Sensor Installed Report<br>
     *
     *
     * @param zoneNumber {@link Integer}
     * @param numberOfSensors {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getCommandClassSecurityPanelZoneSensorInstalledReport(Integer zoneNumber,
            Integer numberOfSensors) {
        logger.debug("Creating command message COMMAND_CLASS_SECURITY_PANEL_ZONE_SENSOR_INSTALLED_REPORT version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(COMMAND_CLASS_SECURITY_PANEL_ZONE_SENSOR_INSTALLED_REPORT);

        // Process 'Zone number'
        outputData.write(zoneNumber);

        // Process 'Number of Sensors'
        outputData.write(numberOfSensors);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the COMMAND_CLASS_SECURITY_PANEL_ZONE_SENSOR_INSTALLED_REPORT command<br>
     *
     * Command Class Security Panel Zone Sensor Installed Report<br>
     *
     *
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>ZONE_NUMBER {@link Integer}
     * <li>NUMBER_OF_SENSORS {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleCommandClassSecurityPanelZoneSensorInstalledReport(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Zone number'
        response.put("ZONE_NUMBER", Integer.valueOf(payload[2]));

        // Process 'Number of Sensors'
        response.put("NUMBER_OF_SENSORS", Integer.valueOf(payload[3]));

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the SECURITY_PANEL_ZONE_SENSOR_TYPE_GET command.<br>
     *
     * Security Panel Zone Sensor Type Get<br>
     *
     *
     * @param zoneNumber {@link Integer}
     * @param sensorNumber {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getSecurityPanelZoneSensorTypeGet(Integer zoneNumber, Integer sensorNumber) {
        logger.debug("Creating command message SECURITY_PANEL_ZONE_SENSOR_TYPE_GET version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(SECURITY_PANEL_ZONE_SENSOR_TYPE_GET);

        // Process 'Zone Number'
        outputData.write(zoneNumber);

        // Process 'Sensor Number'
        outputData.write(sensorNumber);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the SECURITY_PANEL_ZONE_SENSOR_TYPE_GET command<br>
     *
     * Security Panel Zone Sensor Type Get<br>
     *
     *
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>ZONE_NUMBER {@link Integer}
     * <li>SENSOR_NUMBER {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleSecurityPanelZoneSensorTypeGet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Zone Number'
        response.put("ZONE_NUMBER", Integer.valueOf(payload[2]));

        // Process 'Sensor Number'
        response.put("SENSOR_NUMBER", Integer.valueOf(payload[3]));

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the SECURITY_PANEL_ZONE_SENSOR_TYPE_REPORT command.<br>
     *
     * Security Panel Zone Sensor Type Report<br>
     *
     *
     * @param zoneNumber {@link Integer}
     * @param sensorNumber {@link Integer}
     * @param zwaveAlarmType {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getSecurityPanelZoneSensorTypeReport(Integer zoneNumber, Integer sensorNumber,
            Integer zwaveAlarmType) {
        logger.debug("Creating command message SECURITY_PANEL_ZONE_SENSOR_TYPE_REPORT version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(SECURITY_PANEL_ZONE_SENSOR_TYPE_REPORT);

        // Process 'Zone Number'
        outputData.write(zoneNumber);

        // Process 'Sensor Number'
        outputData.write(sensorNumber);

        // Process 'ZWave Alarm Type'
        outputData.write(zwaveAlarmType);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the SECURITY_PANEL_ZONE_SENSOR_TYPE_REPORT command<br>
     *
     * Security Panel Zone Sensor Type Report<br>
     *
     *
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>ZONE_NUMBER {@link Integer}
     * <li>SENSOR_NUMBER {@link Integer}
     * <li>ZWAVE_ALARM_TYPE {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleSecurityPanelZoneSensorTypeReport(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Zone Number'
        response.put("ZONE_NUMBER", Integer.valueOf(payload[2]));

        // Process 'Sensor Number'
        response.put("SENSOR_NUMBER", Integer.valueOf(payload[3]));

        // Process 'ZWave Alarm Type'
        response.put("ZWAVE_ALARM_TYPE", Integer.valueOf(payload[4]));

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the SECURITY_PANEL_ZONE_SENSOR_STATE_GET command.<br>
     *
     * Security Panel Zone Sensor State Get<br>
     *
     *
     * @param zoneNumber {@link Integer}
     * @param sensorNumber {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getSecurityPanelZoneSensorStateGet(Integer zoneNumber, Integer sensorNumber) {
        logger.debug("Creating command message SECURITY_PANEL_ZONE_SENSOR_STATE_GET version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(SECURITY_PANEL_ZONE_SENSOR_STATE_GET);

        // Process 'Zone Number'
        outputData.write(zoneNumber);

        // Process 'Sensor Number'
        outputData.write(sensorNumber);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the SECURITY_PANEL_ZONE_SENSOR_STATE_GET command<br>
     *
     * Security Panel Zone Sensor State Get<br>
     *
     *
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>ZONE_NUMBER {@link Integer}
     * <li>SENSOR_NUMBER {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleSecurityPanelZoneSensorStateGet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Zone Number'
        response.put("ZONE_NUMBER", Integer.valueOf(payload[2]));

        // Process 'Sensor Number'
        response.put("SENSOR_NUMBER", Integer.valueOf(payload[3]));

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the SECURITY_PANEL_ZONE_SENSOR_STATE_REPORT command.<br>
     *
     * Security Panel Zone Sensor State Report<br>
     *
     *
     * @param zoneNumber {@link Integer}
     * @param sensorNumber {@link Integer}
     * @param zwaveAlarmType {@link Integer}
     * @param zwaveAlarmEvent {@link Integer}
     * @param eventParameters {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getSecurityPanelZoneSensorStateReport(Integer zoneNumber, Integer sensorNumber,
            Integer zwaveAlarmType, Integer zwaveAlarmEvent, Integer eventParameters) {
        logger.debug("Creating command message SECURITY_PANEL_ZONE_SENSOR_STATE_REPORT version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(SECURITY_PANEL_ZONE_SENSOR_STATE_REPORT);

        // Process 'Zone Number'
        outputData.write(zoneNumber);

        // Process 'Sensor Number'
        outputData.write(sensorNumber);

        // Process 'ZWave Alarm Type'
        outputData.write(zwaveAlarmType);

        // Process 'ZWave Alarm Event'
        outputData.write(zwaveAlarmEvent);

        // Process 'Event Parameters'
        outputData.write(eventParameters);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the SECURITY_PANEL_ZONE_SENSOR_STATE_REPORT command<br>
     *
     * Security Panel Zone Sensor State Report<br>
     *
     *
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>ZONE_NUMBER {@link Integer}
     * <li>SENSOR_NUMBER {@link Integer}
     * <li>ZWAVE_ALARM_TYPE {@link Integer}
     * <li>ZWAVE_ALARM_EVENT {@link Integer}
     * <li>EVENT_PARAMETERS {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleSecurityPanelZoneSensorStateReport(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Zone Number'
        response.put("ZONE_NUMBER", Integer.valueOf(payload[2]));

        // Process 'Sensor Number'
        response.put("SENSOR_NUMBER", Integer.valueOf(payload[3]));

        // Process 'ZWave Alarm Type'
        response.put("ZWAVE_ALARM_TYPE", Integer.valueOf(payload[4]));

        // Process 'ZWave Alarm Event'
        response.put("ZWAVE_ALARM_EVENT", Integer.valueOf(payload[5]));

        // Process 'Event Parameters'
        response.put("EVENT_PARAMETERS", Integer.valueOf(payload[6]));

        // Return the map of processed response data;
        return response;
    }

}