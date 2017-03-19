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
 * Class to implement the Z-Wave command class <b>COMMAND_CLASS_SENSOR_BINARY</b> version <b>2</b>.<br>
 * <p>
 * Command Class Sensor Binary<br>
 *
 * This class provides static methods for processing received messages (message handler) and
 * methods to get a message to send on the Z-Wave network.<br>
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class CommandClassSensorBinaryV2 {
    private static final Logger logger = LoggerFactory.getLogger(CommandClassSensorBinaryV2.class);

    /**
     * Integer command class key for COMMAND_CLASS_SENSOR_BINARY
     */
    public final static int COMMAND_CLASS_KEY = 0x30;

    /**
     * Sensor Binary Supported Get Sensor Command Constant
     */
    public final static int SENSOR_BINARY_SUPPORTED_GET_SENSOR = 0x01;
    /**
     * Sensor Binary Get Command Constant
     */
    public final static int SENSOR_BINARY_GET = 0x02;
    /**
     * Sensor Binary Report Command Constant
     */
    public final static int SENSOR_BINARY_REPORT = 0x03;
    /**
     * Sensor Binary Supported Sensor Report Command Constant
     */
    public final static int SENSOR_BINARY_SUPPORTED_SENSOR_REPORT = 0x04;


    // Define constants for Sensor Value
    private static Map<Integer, String> constantSensorValue = new HashMap<Integer, String>();

    static {
        // Constants for Sensor Value
        constantSensorValue.put(0x00, "IDLE");
        constantSensorValue.put(0xFF, "DETECTED_AN_EVENT");
    }

    /**
     * Creates a new message with the SENSOR_BINARY_SUPPORTED_GET_SENSOR command.<br>
     * <p>
     * Sensor Binary Supported Get Sensor<br>
     *
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getSensorBinarySupportedGetSensor() {
        logger.debug("Creating command message SENSOR_BINARY_SUPPORTED_GET_SENSOR version 2");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(SENSOR_BINARY_SUPPORTED_GET_SENSOR);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the SENSOR_BINARY_SUPPORTED_GET_SENSOR command<br>
     * <p>
     * Sensor Binary Supported Get Sensor<br>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleSensorBinarySupportedGetSensor(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the SENSOR_BINARY_GET command.<br>
     * <p>
     * Sensor Binary Get<br>
     *
     * @param sensorType {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getSensorBinaryGet(Integer sensorType) {
        logger.debug("Creating command message SENSOR_BINARY_GET version 2");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(SENSOR_BINARY_GET);

        // Process 'Sensor Type'
        outputData.write(sensorType);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the SENSOR_BINARY_GET command<br>
     * <p>
     * Sensor Binary Get<br>
     * <p>
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>SENSOR_TYPE {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleSensorBinaryGet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Sensor Type'
        switch (payload[2] & 0xff) {
            case 0x00:
                response.put("SENSOR_TYPE", "RESERVED");
                break;
            case 0x01:
                response.put("SENSOR_TYPE", "GENERAL");
                break;
            case 0x02:
                response.put("SENSOR_TYPE", "SMOKE");
                break;
            case 0x03:
                response.put("SENSOR_TYPE", "CO");
                break;
            case 0x04:
                response.put("SENSOR_TYPE", "CO2");
                break;
            case 0x05:
                response.put("SENSOR_TYPE", "HEAT");
                break;
            case 0x06:
                response.put("SENSOR_TYPE", "WATER");
                break;
            case 0x07:
                response.put("SENSOR_TYPE", "FREEZE");
                break;
            case 0x08:
                response.put("SENSOR_TYPE", "TAMPER");
                break;
            case 0x09:
                response.put("SENSOR_TYPE", "AUX");
                break;
            case 0x0A:
                response.put("SENSOR_TYPE", "DOOR_WINDOW");
                break;
            case 0x0B:
                response.put("SENSOR_TYPE", "TILT");
                break;
            case 0x0C:
                response.put("SENSOR_TYPE", "MOTION");
                break;
            case 0x0D:
                response.put("SENSOR_TYPE", "GLASS_BREAK");
                break;
            case 0xFF:
                response.put("SENSOR_TYPE", "FIRST");
                break;
            default:
                response.put("SENSOR_TYPE", String.format("%02X", payload[2] & 0xff));
                logger.debug("Unknown value {}", payload[2] & 0xff);
                break;
        }

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the SENSOR_BINARY_REPORT command.<br>
     * <p>
     * Sensor Binary Report<br>
     *
     * @param sensorValue {@link String}
     * @param sensorType {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getSensorBinaryReport(String sensorValue, Integer sensorType) {
        logger.debug("Creating command message SENSOR_BINARY_REPORT version 2");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(SENSOR_BINARY_REPORT);

        // Process 'Sensor Value'
        for (Integer entry : constantSensorValue.keySet()) {
            if (constantSensorValue.get(entry).equals(sensorValue)) {
                outputData.write(entry);
                break;
            }
        }

        // Process 'Sensor Type'
        outputData.write(sensorType);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the SENSOR_BINARY_REPORT command<br>
     * <p>
     * Sensor Binary Report<br>
     * <p>
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>SENSOR_VALUE {@link String}
     * <li>SENSOR_TYPE {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleSensorBinaryReport(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Sensor Value'
        response.put("SENSOR_VALUE", constantSensorValue.get(payload[2] & 0xff));

        // Process 'Sensor Type'
        switch (payload[3] & 0xff) {
            case 0x00:
                response.put("SENSOR_TYPE", "RESERVED");
                break;
            case 0x01:
                response.put("SENSOR_TYPE", "GENERAL");
                break;
            case 0x02:
                response.put("SENSOR_TYPE", "SMOKE");
                break;
            case 0x03:
                response.put("SENSOR_TYPE", "CO");
                break;
            case 0x04:
                response.put("SENSOR_TYPE", "CO2");
                break;
            case 0x05:
                response.put("SENSOR_TYPE", "HEAT");
                break;
            case 0x06:
                response.put("SENSOR_TYPE", "WATER");
                break;
            case 0x07:
                response.put("SENSOR_TYPE", "FREEZE");
                break;
            case 0x08:
                response.put("SENSOR_TYPE", "TAMPER");
                break;
            case 0x09:
                response.put("SENSOR_TYPE", "AUX");
                break;
            case 0x0A:
                response.put("SENSOR_TYPE", "DOOR_WINDOW");
                break;
            case 0x0B:
                response.put("SENSOR_TYPE", "TILT");
                break;
            case 0x0C:
                response.put("SENSOR_TYPE", "MOTION");
                break;
            case 0x0D:
                response.put("SENSOR_TYPE", "GLASS_BREAK");
                break;
            case 0xFF:
                response.put("SENSOR_TYPE", "FIRST");
                break;
            default:
                response.put("SENSOR_TYPE", String.format("%02X", payload[3] & 0xff));
                logger.debug("Unknown value {}", payload[3] & 0xff);
                break;
        }

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the SENSOR_BINARY_SUPPORTED_SENSOR_REPORT command.<br>
     * <p>
     * Sensor Binary Supported Sensor Report<br>
     *
     * @param bitMask {@link List<String>}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getSensorBinarySupportedSensorReport(List<String> bitMask) {
        logger.debug("Creating command message SENSOR_BINARY_SUPPORTED_SENSOR_REPORT version 2");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(SENSOR_BINARY_SUPPORTED_SENSOR_REPORT);

        // Process 'Bit Mask'
        int valBitMask = 0;
        valBitMask |= (bitMask.contains("GENERAL") ? 0x02 : 0);
        valBitMask |= (bitMask.contains("SMOKE") ? 0x04 : 0);
        valBitMask |= (bitMask.contains("CO") ? 0x08 : 0);
        valBitMask |= (bitMask.contains("CO2") ? 0x10 : 0);
        valBitMask |= (bitMask.contains("HEAT") ? 0x20 : 0);
        valBitMask |= (bitMask.contains("WATER") ? 0x40 : 0);
        valBitMask |= (bitMask.contains("FREEZE") ? 0x80 : 0);
        outputData.write(valBitMask);
        valBitMask = 0;
        valBitMask |= (bitMask.contains("TAMPER") ? 0x01 : 0);
        valBitMask |= (bitMask.contains("AUX") ? 0x02 : 0);
        valBitMask |= (bitMask.contains("DOOR_WINDOW") ? 0x04 : 0);
        valBitMask |= (bitMask.contains("TILT") ? 0x08 : 0);
        valBitMask |= (bitMask.contains("MOTION") ? 0x10 : 0);
        valBitMask |= (bitMask.contains("GLASS_BREAK") ? 0x20 : 0);
        outputData.write(valBitMask);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the SENSOR_BINARY_SUPPORTED_SENSOR_REPORT command<br>
     * <p>
     * Sensor Binary Supported Sensor Report<br>
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
    public static Map<String, Object> handleSensorBinarySupportedSensorReport(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Bit Mask'
        List<String> responseBitMask = new ArrayList<String>();
        for (int cntBitMask = 0; cntBitMask < (payload.length - 2) * 8; cntBitMask++) {
            if ((payload[2 + (cntBitMask / 8)] & (1 << cntBitMask % 8)) == 0) {
                continue;
            }
            switch (cntBitMask) {
                case 0x01:
                    responseBitMask.add("GENERAL");
                    break;
                case 0x02:
                    responseBitMask.add("SMOKE");
                    break;
                case 0x03:
                    responseBitMask.add("CO");
                    break;
                case 0x04:
                    responseBitMask.add("CO2");
                    break;
                case 0x05:
                    responseBitMask.add("HEAT");
                    break;
                case 0x06:
                    responseBitMask.add("WATER");
                    break;
                case 0x07:
                    responseBitMask.add("FREEZE");
                    break;
                case 0x08:
                    responseBitMask.add("TAMPER");
                    break;
                case 0x09:
                    responseBitMask.add("AUX");
                    break;
                case 0x0A:
                    responseBitMask.add("DOOR_WINDOW");
                    break;
                case 0x0B:
                    responseBitMask.add("TILT");
                    break;
                case 0x0C:
                    responseBitMask.add("MOTION");
                    break;
                case 0x0D:
                    responseBitMask.add("GLASS_BREAK");
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
