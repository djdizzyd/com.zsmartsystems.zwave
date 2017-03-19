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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class to implement the Z-Wave command class <b>COMMAND_CLASS_HUMIDITY_CONTROL_MODE</b> version <b>1</b>.<br>
 * <p>
 * Command Class Humidity Control Mode<br>
 *
 * This class provides static methods for processing received messages (message handler) and
 * methods to get a message to send on the Z-Wave network.<br>
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class CommandClassHumidityControlModeV1 {
    private static final Logger logger = LoggerFactory.getLogger(CommandClassHumidityControlModeV1.class);

    /**
     * Integer command class key for COMMAND_CLASS_HUMIDITY_CONTROL_MODE
     */
    public final static int COMMAND_CLASS_KEY = 0x6D;

    /**
     * Humidity Control Mode Set Command Constant
     */
    public final static int HUMIDITY_CONTROL_MODE_SET = 0x01;
    /**
     * Humidity Control Mode Get Command Constant
     */
    public final static int HUMIDITY_CONTROL_MODE_GET = 0x02;
    /**
     * Humidity Control Mode Report Command Constant
     */
    public final static int HUMIDITY_CONTROL_MODE_REPORT = 0x03;
    /**
     * Humidity Control Mode Supported Get Command Constant
     */
    public final static int HUMIDITY_CONTROL_MODE_SUPPORTED_GET = 0x04;
    /**
     * Humidity Control Mode Supported Report Command Constant
     */
    public final static int HUMIDITY_CONTROL_MODE_SUPPORTED_REPORT = 0x05;

    /**
     * Creates a new message with the HUMIDITY_CONTROL_MODE_SET command.<br>
     * <p>
     * Humidity Control Mode Set<br>
     *
     * @param mode {@link String}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getHumidityControlModeSet(String mode) {
        logger.debug("Creating command message HUMIDITY_CONTROL_MODE_SET version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(HUMIDITY_CONTROL_MODE_SET);

        // Process 'Properties1'
        int valmode;
        switch (mode) {
            case "OFF":
                valmode = 0;
                break;
            case "HUMIDIFY":
                valmode = 1;
                break;
            case "DEHUMIDIFY":
                valmode = 2;
                break;
            default:
                throw new IllegalArgumentException("Unknown enum value for mode: " + mode);
        }
        outputData.write(valmode & 0x0F);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the HUMIDITY_CONTROL_MODE_SET command<br>
     * <p>
     * Humidity Control Mode Set<br>
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
    public static Map<String, Object> handleHumidityControlModeSet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Properties1'
        switch (payload[2] & 0x0F) {
            case 0x00:
                response.put("MODE", "OFF");
                break;
            case 0x01:
                response.put("MODE", "HUMIDIFY");
                break;
            case 0x02:
                response.put("MODE", "DEHUMIDIFY");
                break;
            default:
                logger.debug("Unknown enum value {} for MODE", String.format("0x%02X", 2));
        }

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the HUMIDITY_CONTROL_MODE_GET command.<br>
     * <p>
     * Humidity Control Mode Get<br>
     *
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getHumidityControlModeGet() {
        logger.debug("Creating command message HUMIDITY_CONTROL_MODE_GET version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(HUMIDITY_CONTROL_MODE_GET);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the HUMIDITY_CONTROL_MODE_GET command<br>
     * <p>
     * Humidity Control Mode Get<br>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleHumidityControlModeGet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the HUMIDITY_CONTROL_MODE_REPORT command.<br>
     * <p>
     * Humidity Control Mode Report<br>
     *
     * @param mode {@link String}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getHumidityControlModeReport(String mode) {
        logger.debug("Creating command message HUMIDITY_CONTROL_MODE_REPORT version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(HUMIDITY_CONTROL_MODE_REPORT);

        // Process 'Properties1'
        int valmode;
        switch (mode) {
            case "OFF":
                valmode = 0;
                break;
            case "HUMIDIFY":
                valmode = 1;
                break;
            case "DEHUMIDIFY":
                valmode = 2;
                break;
            default:
                throw new IllegalArgumentException("Unknown enum value for mode: " + mode);
        }
        outputData.write(valmode & 0x0F);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the HUMIDITY_CONTROL_MODE_REPORT command<br>
     * <p>
     * Humidity Control Mode Report<br>
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
    public static Map<String, Object> handleHumidityControlModeReport(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Properties1'
        switch (payload[2] & 0x0F) {
            case 0x00:
                response.put("MODE", "OFF");
                break;
            case 0x01:
                response.put("MODE", "HUMIDIFY");
                break;
            case 0x02:
                response.put("MODE", "DEHUMIDIFY");
                break;
            default:
                logger.debug("Unknown enum value {} for MODE", String.format("0x%02X", 2));
        }

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the HUMIDITY_CONTROL_MODE_SUPPORTED_GET command.<br>
     * <p>
     * Humidity Control Mode Supported Get<br>
     *
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getHumidityControlModeSupportedGet() {
        logger.debug("Creating command message HUMIDITY_CONTROL_MODE_SUPPORTED_GET version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(HUMIDITY_CONTROL_MODE_SUPPORTED_GET);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the HUMIDITY_CONTROL_MODE_SUPPORTED_GET command<br>
     * <p>
     * Humidity Control Mode Supported Get<br>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleHumidityControlModeSupportedGet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the HUMIDITY_CONTROL_MODE_SUPPORTED_REPORT command.<br>
     * <p>
     * Humidity Control Mode Supported Report<br>
     *
     * @param bitMask {@link List<String>}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getHumidityControlModeSupportedReport(List<String> bitMask) {
        logger.debug("Creating command message HUMIDITY_CONTROL_MODE_SUPPORTED_REPORT version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(HUMIDITY_CONTROL_MODE_SUPPORTED_REPORT);

        // Process 'Bit Mask'
        int valBitMask = 0;
        valBitMask |= (bitMask.contains("OFF") ? 0x01 : 0);
        valBitMask |= (bitMask.contains("HUMIDIFY") ? 0x02 : 0);
        valBitMask |= (bitMask.contains("DEHUMIDIFY") ? 0x04 : 0);
        outputData.write(valBitMask);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the HUMIDITY_CONTROL_MODE_SUPPORTED_REPORT command<br>
     * <p>
     * Humidity Control Mode Supported Report<br>
     * <p>
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>BIT_MASK {@link List}<{@link String}>
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleHumidityControlModeSupportedReport(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Bit Mask'
        List<String> responseBitMask = new ArrayList<String>();
        int lenBitMask = 1;
        for (int cntBitMask = 0; cntBitMask < lenBitMask; cntBitMask++) {
            if ((payload[2 + (cntBitMask / 8)] & (1 << cntBitMask % 8)) == 0) {
                continue;
            }
            switch (cntBitMask) {
                case 0x00:
                    responseBitMask.add("OFF");
                    break;
                case 0x01:
                    responseBitMask.add("HUMIDIFY");
                    break;
                case 0x02:
                    responseBitMask.add("DEHUMIDIFY");
                    break;
                default:
                    responseBitMask.add("BITMASK_" + cntBitMask);
                    break;
            }
        }
        response.put("BIT_MASK", responseBitMask);

        // Return the map of processed response data;
        return response;
    }

}
