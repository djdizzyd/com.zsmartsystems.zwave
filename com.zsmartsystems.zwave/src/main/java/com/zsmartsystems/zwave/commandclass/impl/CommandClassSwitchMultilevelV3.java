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
 * Class to implement the Z-Wave command class <b>COMMAND_CLASS_SWITCH_MULTILEVEL</b> version <b>3</b>.
 * <p>
 * Command Class Switch Multilevel
 * <p>
 * This class provides static methods for processing received messages (message handler) and
 * methods to get a message to send on the Z-Wave network.
 * <p>
 * Command class key is 0x26.
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class CommandClassSwitchMultilevelV3 {
    private static final Logger logger = LoggerFactory.getLogger(CommandClassSwitchMultilevelV3.class);

    /**
     * Integer command class key for COMMAND_CLASS_SWITCH_MULTILEVEL
     */
    public final static int COMMAND_CLASS_KEY = 0x26;

    /**
     * Switch Multilevel Set Command Constant
     */
    public final static int SWITCH_MULTILEVEL_SET = 0x01;
    /**
     * Switch Multilevel Get Command Constant
     */
    public final static int SWITCH_MULTILEVEL_GET = 0x02;
    /**
     * Switch Multilevel Report Command Constant
     */
    public final static int SWITCH_MULTILEVEL_REPORT = 0x03;
    /**
     * Switch Multilevel Start Level Change Command Constant
     */
    public final static int SWITCH_MULTILEVEL_START_LEVEL_CHANGE = 0x04;
    /**
     * Switch Multilevel Stop Level Change Command Constant
     */
    public final static int SWITCH_MULTILEVEL_STOP_LEVEL_CHANGE = 0x05;
    /**
     * Switch Multilevel Supported Get Command Constant
     */
    public final static int SWITCH_MULTILEVEL_SUPPORTED_GET = 0x06;
    /**
     * Switch Multilevel Supported Report Command Constant
     */
    public final static int SWITCH_MULTILEVEL_SUPPORTED_REPORT = 0x07;

    /**
     * Map holding constants for SwitchMultilevelStartLevelChangeProperties1
     */
    private static Map<Integer, String> constantSwitchMultilevelStartLevelChangeProperties1 = new HashMap<Integer, String>();

    /**
     * Map holding constants for SwitchMultilevelSetDimmingDuration
     */
    private static Map<Integer, String> constantSwitchMultilevelSetDimmingDuration = new HashMap<Integer, String>();

    /**
     * Map holding constants for SwitchMultilevelStartLevelChangeUpDown
     */
    private static Map<Integer, String> constantSwitchMultilevelStartLevelChangeUpDown = new HashMap<Integer, String>();

    /**
     * Map holding constants for SwitchMultilevelSetValue
     */
    private static Map<Integer, String> constantSwitchMultilevelSetValue = new HashMap<Integer, String>();

    /**
     * Map holding constants for SwitchMultilevelStartLevelChangeIncDec
     */
    private static Map<Integer, String> constantSwitchMultilevelStartLevelChangeIncDec = new HashMap<Integer, String>();

    /**
     * Map holding constants for SwitchMultilevelReportValue
     */
    private static Map<Integer, String> constantSwitchMultilevelReportValue = new HashMap<Integer, String>();

    static {
        // Constants for SwitchMultilevelStartLevelChangeProperties1
        constantSwitchMultilevelStartLevelChangeProperties1.put(0x20, "IGNORE_START_LEVEL");

        // Constants for SwitchMultilevelSetDimmingDuration
        constantSwitchMultilevelSetDimmingDuration.put(0x00, "INSTANTLY");
        constantSwitchMultilevelSetDimmingDuration.put(0xFF, "FACTORY_DEFAULT");

        // Constants for SwitchMultilevelStartLevelChangeUpDown
        constantSwitchMultilevelStartLevelChangeUpDown.put(0x00, "UP");
        constantSwitchMultilevelStartLevelChangeUpDown.put(0x01, "DOWN");
        constantSwitchMultilevelStartLevelChangeUpDown.put(0x02, "NONE");

        // Constants for SwitchMultilevelSetValue
        constantSwitchMultilevelSetValue.put(0x00, "OFF_DISABLE");
        constantSwitchMultilevelSetValue.put(0xFF, "ON_ENABLE");

        // Constants for SwitchMultilevelStartLevelChangeIncDec
        constantSwitchMultilevelStartLevelChangeIncDec.put(0x00, "INCREMENT");
        constantSwitchMultilevelStartLevelChangeIncDec.put(0x01, "DECREMENT");
        constantSwitchMultilevelStartLevelChangeIncDec.put(0x02, "NONE");

        // Constants for SwitchMultilevelReportValue
        constantSwitchMultilevelReportValue.put(0x00, "OFF_DISABLE");
        constantSwitchMultilevelReportValue.put(0xFF, "ON_ENABLE");
    }

    /**
     * Creates a new message with the SWITCH_MULTILEVEL_SET command.
     * <p>
     * Switch Multilevel Set
     *
     * @param value {@link String}
     *            Can be one of the following -:
     *            <p>
     *            <ul>
     *            <li>OFF_DISABLE
     *            <li>ON_ENABLE
     *            </ul>
     * @param dimmingDuration {@link String}
     *            Can be one of the following -:
     *            <p>
     *            <ul>
     *            <li>INSTANTLY
     *            <li>FACTORY_DEFAULT
     *            </ul>
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getSwitchMultilevelSet(String value, String dimmingDuration) {
        logger.debug("Creating command message SWITCH_MULTILEVEL_SET version 3");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(SWITCH_MULTILEVEL_SET);

        // Process 'Value'
        boolean foundValue = false;
        for (Integer entry : constantSwitchMultilevelSetValue.keySet()) {
            if (constantSwitchMultilevelSetValue.get(entry).equals(value)) {
                outputData.write(entry);
                foundValue = true;
                break;
            }
        }
        if (!foundValue) {
            throw new IllegalArgumentException("Unknown constant value '" + value + "' for value");
        }

        // Process 'Dimming Duration'
        boolean foundDimmingDuration = false;
        for (Integer entry : constantSwitchMultilevelSetDimmingDuration.keySet()) {
            if (constantSwitchMultilevelSetDimmingDuration.get(entry).equals(dimmingDuration)) {
                outputData.write(entry);
                foundDimmingDuration = true;
                break;
            }
        }
        if (!foundDimmingDuration) {
            throw new IllegalArgumentException("Unknown constant value '" + dimmingDuration + "' for dimmingDuration");
        }

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the SWITCH_MULTILEVEL_SET command.
     * <p>
     * Switch Multilevel Set
     * <p>
     * The output data {@link Map} has the following properties -:
     *
     * <ul>
     * <li>VALUE {@link String}
     * Can be one of the following -:
     * <p>
     * <ul>
     * <li>OFF_DISABLE
     * <li>ON_ENABLE
     * </ul>
     * <li>DIMMING_DURATION {@link String}
     * Can be one of the following -:
     * <p>
     * <ul>
     * <li>INSTANTLY
     * <li>FACTORY_DEFAULT
     * </ul>
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleSwitchMultilevelSet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Value'
        response.put("VALUE", constantSwitchMultilevelSetValue.get(payload[2] & 0xff));

        // Process 'Dimming Duration'
        response.put("DIMMING_DURATION", constantSwitchMultilevelSetDimmingDuration.get(payload[3] & 0xff));

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the SWITCH_MULTILEVEL_GET command.
     * <p>
     * Switch Multilevel Get
     *
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getSwitchMultilevelGet() {
        logger.debug("Creating command message SWITCH_MULTILEVEL_GET version 3");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(SWITCH_MULTILEVEL_GET);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the SWITCH_MULTILEVEL_GET command.
     * <p>
     * Switch Multilevel Get
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleSwitchMultilevelGet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the SWITCH_MULTILEVEL_REPORT command.
     * <p>
     * Switch Multilevel Report
     *
     * @param value {@link String}
     *            Can be one of the following -:
     *            <p>
     *            <ul>
     *            <li>OFF_DISABLE
     *            <li>ON_ENABLE
     *            </ul>
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getSwitchMultilevelReport(String value) {
        logger.debug("Creating command message SWITCH_MULTILEVEL_REPORT version 3");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(SWITCH_MULTILEVEL_REPORT);

        // Process 'Value'
        boolean foundValue = false;
        for (Integer entry : constantSwitchMultilevelReportValue.keySet()) {
            if (constantSwitchMultilevelReportValue.get(entry).equals(value)) {
                outputData.write(entry);
                foundValue = true;
                break;
            }
        }
        if (!foundValue) {
            throw new IllegalArgumentException("Unknown constant value '" + value + "' for value");
        }

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the SWITCH_MULTILEVEL_REPORT command.
     * <p>
     * Switch Multilevel Report
     * <p>
     * The output data {@link Map} has the following properties -:
     *
     * <ul>
     * <li>VALUE {@link String}
     * Can be one of the following -:
     * <p>
     * <ul>
     * <li>OFF_DISABLE
     * <li>ON_ENABLE
     * </ul>
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleSwitchMultilevelReport(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Value'
        response.put("VALUE", constantSwitchMultilevelReportValue.get(payload[2] & 0xff));

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the SWITCH_MULTILEVEL_START_LEVEL_CHANGE command.
     * <p>
     * Switch Multilevel Start Level Change
     *
     * @param incDec {@link String}
     *            Can be one of the following -:
     *            <p>
     *            <ul>
     *            <li>INCREMENT
     *            <li>DECREMENT
     *            <li>NONE
     *            </ul>
     * @param ignoreStartLevel {@link Boolean}
     * @param upDown {@link String}
     *            Can be one of the following -:
     *            <p>
     *            <ul>
     *            <li>UP
     *            <li>DOWN
     *            <li>NONE
     *            </ul>
     * @param startLevel {@link Integer}
     * @param dimmingDuration {@link Integer}
     * @param stepSize {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getSwitchMultilevelStartLevelChange(String incDec, Boolean ignoreStartLevel, String upDown,
            Integer startLevel, Integer dimmingDuration, Integer stepSize) {
        logger.debug("Creating command message SWITCH_MULTILEVEL_START_LEVEL_CHANGE version 3");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(SWITCH_MULTILEVEL_START_LEVEL_CHANGE);

        // Process 'Properties1'
        int valProperties1 = 0;
        int varIncDec = Integer.MAX_VALUE;
        for (Integer entry : constantSwitchMultilevelStartLevelChangeIncDec.keySet()) {
            if (constantSwitchMultilevelStartLevelChangeIncDec.get(entry).equals(incDec)) {
                varIncDec = entry;
                break;
            }
        }
        if (varIncDec == Integer.MAX_VALUE) {
            throw new IllegalArgumentException("Unknown constant value '" + incDec + "' for incDec");
        }
        valProperties1 |= varIncDec << 3 & 0x18;
        valProperties1 |= ignoreStartLevel ? 0x20 : 0;
        int varUpDown = Integer.MAX_VALUE;
        for (Integer entry : constantSwitchMultilevelStartLevelChangeUpDown.keySet()) {
            if (constantSwitchMultilevelStartLevelChangeUpDown.get(entry).equals(upDown)) {
                varUpDown = entry;
                break;
            }
        }
        if (varUpDown == Integer.MAX_VALUE) {
            throw new IllegalArgumentException("Unknown constant value '" + upDown + "' for upDown");
        }
        valProperties1 |= varUpDown << 6 & 0xC0;
        outputData.write(valProperties1);

        // Process 'Start Level'
        outputData.write(startLevel);

        // Process 'Dimming Duration'
        outputData.write(dimmingDuration);

        // Process 'Step Size'
        outputData.write(stepSize);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the SWITCH_MULTILEVEL_START_LEVEL_CHANGE command.
     * <p>
     * Switch Multilevel Start Level Change
     * <p>
     * The output data {@link Map} has the following properties -:
     *
     * <ul>
     * <li>INC_DEC {@link String}
     * Can be one of the following -:
     * <p>
     * <ul>
     * <li>INCREMENT
     * <li>DECREMENT
     * <li>NONE
     * </ul>
     * <li>IGNORE_START_LEVEL {@link Boolean}
     * <li>UP_DOWN {@link String}
     * Can be one of the following -:
     * <p>
     * <ul>
     * <li>UP
     * <li>DOWN
     * <li>NONE
     * </ul>
     * <li>START_LEVEL {@link Integer}
     * <li>DIMMING_DURATION {@link Integer}
     * <li>STEP_SIZE {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleSwitchMultilevelStartLevelChange(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Properties1'
        response.put("INC_DEC", constantSwitchMultilevelStartLevelChangeIncDec.get((payload[2] & 0x18) >> 3));
        response.put("IGNORE_START_LEVEL", Boolean.valueOf((payload[2] & 0x20) != 0));
        response.put("UP_DOWN", constantSwitchMultilevelStartLevelChangeUpDown.get((payload[2] & 0xC0) >> 6));

        // Process 'Start Level'
        response.put("START_LEVEL", Integer.valueOf(payload[3]));

        // Process 'Dimming Duration'
        response.put("DIMMING_DURATION", Integer.valueOf(payload[4]));

        // Process 'Step Size'
        response.put("STEP_SIZE", Integer.valueOf(payload[5]));

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the SWITCH_MULTILEVEL_STOP_LEVEL_CHANGE command.
     * <p>
     * Switch Multilevel Stop Level Change
     *
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getSwitchMultilevelStopLevelChange() {
        logger.debug("Creating command message SWITCH_MULTILEVEL_STOP_LEVEL_CHANGE version 3");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(SWITCH_MULTILEVEL_STOP_LEVEL_CHANGE);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the SWITCH_MULTILEVEL_STOP_LEVEL_CHANGE command.
     * <p>
     * Switch Multilevel Stop Level Change
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleSwitchMultilevelStopLevelChange(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the SWITCH_MULTILEVEL_SUPPORTED_GET command.
     * <p>
     * Switch Multilevel Supported Get
     *
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getSwitchMultilevelSupportedGet() {
        logger.debug("Creating command message SWITCH_MULTILEVEL_SUPPORTED_GET version 3");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(SWITCH_MULTILEVEL_SUPPORTED_GET);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the SWITCH_MULTILEVEL_SUPPORTED_GET command.
     * <p>
     * Switch Multilevel Supported Get
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleSwitchMultilevelSupportedGet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the SWITCH_MULTILEVEL_SUPPORTED_REPORT command.
     * <p>
     * Switch Multilevel Supported Report
     *
     * @param primarySwitchType {@link Integer}
     * @param secondarySwitchType {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getSwitchMultilevelSupportedReport(Integer primarySwitchType, Integer secondarySwitchType) {
        logger.debug("Creating command message SWITCH_MULTILEVEL_SUPPORTED_REPORT version 3");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(SWITCH_MULTILEVEL_SUPPORTED_REPORT);

        // Process 'Properties1'
        outputData.write(primarySwitchType & 0x1F);

        // Process 'Properties2'
        outputData.write(secondarySwitchType & 0x1F);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the SWITCH_MULTILEVEL_SUPPORTED_REPORT command.
     * <p>
     * Switch Multilevel Supported Report
     * <p>
     * The output data {@link Map} has the following properties -:
     *
     * <ul>
     * <li>PRIMARY_SWITCH_TYPE {@link Integer}
     * <li>SECONDARY_SWITCH_TYPE {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleSwitchMultilevelSupportedReport(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Properties1'
        response.put("PRIMARY_SWITCH_TYPE", Integer.valueOf(payload[2] & 0x1F));

        // Process 'Properties2'
        response.put("SECONDARY_SWITCH_TYPE", Integer.valueOf(payload[3] & 0x1F));

        // Return the map of processed response data;
        return response;
    }
}
