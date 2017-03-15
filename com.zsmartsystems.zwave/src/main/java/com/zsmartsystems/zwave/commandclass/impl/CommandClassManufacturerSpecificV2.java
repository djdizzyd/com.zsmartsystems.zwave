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
import java.io.IOException;
import java.lang.IllegalArgumentException;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class to implement the Z-Wave command class <b>COMMAND_CLASS_MANUFACTURER_SPECIFIC</b> version <b>2</b>.<br>
 *
 * Command Class Manufacturer Specific<br>
 *
 * This class provides static methods for processing received messages (message handler) and
 * methods to get a message to send on the Z-Wave network.<br>
 *
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class CommandClassManufacturerSpecificV2 {
    private static final Logger logger = LoggerFactory.getLogger(CommandClassManufacturerSpecificV2.class);

    /**
     * Integer command class key for COMMAND_CLASS_MANUFACTURER_SPECIFIC
     */
    public final static int COMMAND_CLASS_KEY = 0x72;

    /**
     * Manufacturer Specific Get Command Constant
     */
    public final static int MANUFACTURER_SPECIFIC_GET = 0x04;
    /**
     * Manufacturer Specific Report Command Constant
     */
    public final static int MANUFACTURER_SPECIFIC_REPORT = 0x05;
    /**
     * Device Specific Get Command Constant
     */
    public final static int DEVICE_SPECIFIC_GET = 0x06;
    /**
     * Device Specific Report Command Constant
     */
    public final static int DEVICE_SPECIFIC_REPORT = 0x07;

    /**
     * Creates a new message with the MANUFACTURER_SPECIFIC_GET command.<br>
     *
     * Manufacturer Specific Get<br>
     *
     *
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getManufacturerSpecificGet() {
        logger.debug("Creating command message MANUFACTURER_SPECIFIC_GET version 2");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(MANUFACTURER_SPECIFIC_GET);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the MANUFACTURER_SPECIFIC_GET command<br>
     *
     * Manufacturer Specific Get<br>
     *
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleManufacturerSpecificGet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the MANUFACTURER_SPECIFIC_REPORT command.<br>
     *
     * Manufacturer Specific Report<br>
     *
     *
     * @param manufacturerId {@link Integer}
     * @param productTypeId {@link Integer}
     * @param productId {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getManufacturerSpecificReport(Integer manufacturerId, Integer productTypeId, Integer productId) {
        logger.debug("Creating command message MANUFACTURER_SPECIFIC_REPORT version 2");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(MANUFACTURER_SPECIFIC_REPORT);

        // Process 'Manufacturer ID'
        outputData.write((manufacturerId >> 8) & 0xff);
        outputData.write(manufacturerId & 0xff);

        // Process 'Product Type ID'
        outputData.write((productTypeId >> 8) & 0xff);
        outputData.write(productTypeId & 0xff);

        // Process 'Product ID'
        outputData.write((productId >> 8) & 0xff);
        outputData.write(productId & 0xff);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the MANUFACTURER_SPECIFIC_REPORT command<br>
     *
     * Manufacturer Specific Report<br>
     *
     *
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>MANUFACTURER_ID {@link Integer}
     * <li>PRODUCT_TYPE_ID {@link Integer}
     * <li>PRODUCT_ID {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleManufacturerSpecificReport(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Manufacturer ID'
        response.put("MANUFACTURER_ID", Integer.valueOf(payload[2] << 8 + payload[3]));

        // Process 'Product Type ID'
        response.put("PRODUCT_TYPE_ID", Integer.valueOf(payload[4] << 8 + payload[5]));

        // Process 'Product ID'
        response.put("PRODUCT_ID", Integer.valueOf(payload[6] << 8 + payload[7]));

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the DEVICE_SPECIFIC_GET command.<br>
     *
     * Device Specific Get<br>
     *
     *
     * @param deviceIdType {@link String}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getDeviceSpecificGet(String deviceIdType) {
        logger.debug("Creating command message DEVICE_SPECIFIC_GET version 2");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(DEVICE_SPECIFIC_GET);

        // Process 'Properties1'
        int valdeviceIdType;
        switch (deviceIdType) {
            case "SERIAL_NUMBER":
                valdeviceIdType = 1;
                break;
            default:
                throw new IllegalArgumentException("Unknown enum value for deviceIdType: " + deviceIdType);
        }
        outputData.write(valdeviceIdType & 0x07);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the DEVICE_SPECIFIC_GET command<br>
     *
     * Device Specific Get<br>
     *
     *
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>DEVICE_ID_TYPE {@link String}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleDeviceSpecificGet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Properties1'
        switch ((int) payload[2] & 0x07) {
            case 0x01:
                response.put("DEVICE_ID_TYPE", "SERIAL_NUMBER");
                break;
            default:
                logger.debug("Unknown enum value {} for DEVICE_ID_TYPE", String.format("0x%02X", 2));
        }

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the DEVICE_SPECIFIC_REPORT command.<br>
     *
     * Device Specific Report<br>
     *
     *
     * @param deviceIdType {@link String}
     * @param deviceIdDataLengthIndicator {@link Integer}
     * @param deviceIdDataFormat {@link String}
     * @param deviceIdData {@link byte[]}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getDeviceSpecificReport(String deviceIdType, Integer deviceIdDataLengthIndicator,
            String deviceIdDataFormat, byte[] deviceIdData) {
        logger.debug("Creating command message DEVICE_SPECIFIC_REPORT version 2");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(DEVICE_SPECIFIC_REPORT);

        // Process 'Properties1'
        int valdeviceIdType;
        switch (deviceIdType) {
            case "SERIAL_NUMBER":
                valdeviceIdType = 1;
                break;
            default:
                throw new IllegalArgumentException("Unknown enum value for deviceIdType: " + deviceIdType);
        }
        outputData.write(valdeviceIdType & 0x07);

        // Process 'Properties2'
        int valProperties2 = 0;
        valProperties2 |= deviceIdDataLengthIndicator & 0x1F;
        int valdeviceIdDataFormat;
        switch (deviceIdDataFormat) {
            case "BINARY":
                valdeviceIdDataFormat = 1;
                break;
            default:
                throw new IllegalArgumentException("Unknown enum value for deviceIdDataFormat: " + deviceIdDataFormat);
        }
        valProperties2 |= valdeviceIdDataFormat >> 5 & 0xE0;
        outputData.write(valProperties2);

        // Process 'Device ID Data'
        try {
            outputData.write(deviceIdData);
        } catch (IOException e) {
        }

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the DEVICE_SPECIFIC_REPORT command<br>
     *
     * Device Specific Report<br>
     *
     *
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>DEVICE_ID_TYPE {@link String}
     * <li>DEVICE_ID_DATA_LENGTH_INDICATOR {@link Integer}
     * <li>DEVICE_ID_DATA_FORMAT {@link String}
     * <li>DEVICE_ID_DATA {@link byte[]}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleDeviceSpecificReport(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // We're using variable length fields, so track the offset
        int msgOffset = 2;

        // Process 'Properties1'
        switch ((int) payload[msgOffset] & 0x07) {
            case 0x01:
                response.put("DEVICE_ID_TYPE", "SERIAL_NUMBER");
                break;
            default:
                logger.debug("Unknown enum value {} for DEVICE_ID_TYPE", String.format("0x%02X", msgOffset));
        }
        msgOffset += 1;

        // Process 'Properties2'
        response.put("DEVICE_ID_DATA_LENGTH_INDICATOR", Integer.valueOf(payload[msgOffset] & 0x1F));
        switch ((payload[msgOffset] & 0xE0) >> 5) {
            case 0x01:
                response.put("DEVICE_ID_DATA_FORMAT", "BINARY");
                break;
            default:
                logger.debug("Unknown enum value {} for DEVICE_ID_DATA_FORMAT", String.format("0x%02X", msgOffset));
        }
        msgOffset += 1;

        // Process 'Device ID Data'
        int valDeviceIdData = 0;
        int lenDeviceIdData = payload[msgOffset - 1] & 0x1F;
        for (int cntDeviceIdData = 0; cntDeviceIdData < lenDeviceIdData; cntDeviceIdData++) {
            valDeviceIdData = (valDeviceIdData << 8) + payload[msgOffset + cntDeviceIdData];
        }
        response.put("DEVICE_ID_DATA", valDeviceIdData);
        msgOffset += lenDeviceIdData;

        // Return the map of processed response data;
        return response;
    }

}