/**
 * Copyright (c) 2016-2017 by the respective copyright holders.
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
 * Class to implement the Z-Wave command class <b>COMMAND_CLASS_SWITCH_ALL</b> version <b>1</b>.<br>
 * <p>
 * Command Class Switch All<br>
 *
 * This class provides static methods for processing received messages (message handler) and
 * methods to get a message to send on the Z-Wave network.<br>
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class CommandClassSwitchAllV1 {
    private static final Logger logger = LoggerFactory.getLogger(CommandClassSwitchAllV1.class);

    /**
     * Integer command class key for COMMAND_CLASS_SWITCH_ALL
     */
    public final static int COMMAND_CLASS_KEY = 0x27;

    /**
     * Switch All Set Command Constant
     */
    public final static int SWITCH_ALL_SET = 0x01;
    /**
     * Switch All Get Command Constant
     */
    public final static int SWITCH_ALL_GET = 0x02;
    /**
     * Switch All Report Command Constant
     */
    public final static int SWITCH_ALL_REPORT = 0x03;
    /**
     * Switch All On Command Constant
     */
    public final static int SWITCH_ALL_ON = 0x04;
    /**
     * Switch All Off Command Constant
     */
    public final static int SWITCH_ALL_OFF = 0x05;


    // Define constants for Mode
    private static Map<Integer, String> constantMode = new HashMap<Integer, String>();

    static {
        // Constants for Mode
        constantMode.put(0x00, "EXCLUDED_FROM_THE_ALL_ON_ALL_OFF_FUNCTIONALITY");
        constantMode.put(0xFF, "INCLUDED_IN_THE_ALL_ON_ALL_OFF_FUNCTIONALITY");
        constantMode.put(0x01, "EXCLUDED_FROM_THE_ALL_ON_FUNCTIONALITY_BUT_NOT_ALL_OFF");
        constantMode.put(0x02, "EXCLUDED_FROM_THE_ALL_OFF_FUNCTIONALITY_BUT_NOT_ALL_ON");
    }

    /**
     * Creates a new message with the SWITCH_ALL_SET command.<br>
     * <p>
     * Switch All Set<br>
     *
     * @param mode {@link String}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getSwitchAllSet(String mode) {
        logger.debug("Creating command message SWITCH_ALL_SET version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(SWITCH_ALL_SET);

        // Process 'Mode'
        for (Integer entry : constantMode.keySet()) {
            if (constantMode.get(entry).equals(mode)) {
                outputData.write(entry);
                break;
            }
        }

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the SWITCH_ALL_SET command<br>
     * <p>
     * Switch All Set<br>
     * <p>
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>MODE {@link String}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleSwitchAllSet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Mode'
        response.put("MODE", constantMode.get(payload[2] & 0xff));

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the SWITCH_ALL_GET command.<br>
     * <p>
     * Switch All Get<br>
     *
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getSwitchAllGet() {
        logger.debug("Creating command message SWITCH_ALL_GET version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(SWITCH_ALL_GET);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the SWITCH_ALL_GET command<br>
     * <p>
     * Switch All Get<br>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleSwitchAllGet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the SWITCH_ALL_REPORT command.<br>
     * <p>
     * Switch All Report<br>
     *
     * @param mode {@link String}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getSwitchAllReport(String mode) {
        logger.debug("Creating command message SWITCH_ALL_REPORT version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(SWITCH_ALL_REPORT);

        // Process 'Mode'
        for (Integer entry : constantMode.keySet()) {
            if (constantMode.get(entry).equals(mode)) {
                outputData.write(entry);
                break;
            }
        }

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the SWITCH_ALL_REPORT command<br>
     * <p>
     * Switch All Report<br>
     * <p>
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>MODE {@link String}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleSwitchAllReport(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Mode'
        response.put("MODE", constantMode.get(payload[2] & 0xff));

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the SWITCH_ALL_ON command.<br>
     * <p>
     * Switch All On<br>
     *
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getSwitchAllOn() {
        logger.debug("Creating command message SWITCH_ALL_ON version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(SWITCH_ALL_ON);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the SWITCH_ALL_ON command<br>
     * <p>
     * Switch All On<br>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleSwitchAllOn(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the SWITCH_ALL_OFF command.<br>
     * <p>
     * Switch All Off<br>
     *
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getSwitchAllOff() {
        logger.debug("Creating command message SWITCH_ALL_OFF version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(SWITCH_ALL_OFF);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the SWITCH_ALL_OFF command<br>
     * <p>
     * Switch All Off<br>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleSwitchAllOff(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Return the map of processed response data;
        return response;
    }

}
