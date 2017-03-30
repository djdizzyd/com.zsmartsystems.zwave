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
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class to implement the Z-Wave command class <b>COMMAND_CLASS_SENSOR_MULTILEVEL</b> version <b>8</b>.
 * <p>
 * Command Class Sensor Multilevel
 * <p>
 * This class provides static methods for processing received messages (message handler) and
 * methods to get a message to send on the Z-Wave network.
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class CommandClassSensorMultilevelV8 {
    private static final Logger logger = LoggerFactory.getLogger(CommandClassSensorMultilevelV8.class);

    /**
     * Integer command class key for COMMAND_CLASS_SENSOR_MULTILEVEL
     */
    public final static int COMMAND_CLASS_KEY = 0x31;

    /**
     * Multilevel Sensor Get Supported Sensor Command Constant
     */
    public final static int SENSOR_MULTILEVEL_SUPPORTED_GET_SENSOR = 0x01;
    /**
     * Multilevel Sensor Supported Sensor Report Command Constant
     */
    public final static int SENSOR_MULTILEVEL_SUPPORTED_SENSOR_REPORT = 0x02;
    /**
     * Multilevel Sensor Get Supported Scale Command Constant
     */
    public final static int SENSOR_MULTILEVEL_SUPPORTED_GET_SCALE = 0x03;
    /**
     * Multilevel Sensor Get Command Constant
     */
    public final static int SENSOR_MULTILEVEL_GET = 0x04;
    /**
     * Multilevel Sensor Report Command Constant
     */
    public final static int SENSOR_MULTILEVEL_REPORT = 0x05;
    /**
     * Multilevel Sensor Supported Scale Report Command Constant
     */
    public final static int SENSOR_MULTILEVEL_SUPPORTED_SCALE_REPORT = 0x06;


    /**
     * Map holding constants for Sensor Type
     */
    private static Map<Integer, String> constantSensorType = new HashMap<Integer, String>();

    /**
     * Map holding constants for Bit Mask
     */
    private static Map<Integer, String> constantBitMask = new HashMap<Integer, String>();
    static {

        // Constants for Sensor Type
        constantSensorType.put(0x01, "TEMPERATURE");
        constantSensorType.put(0x02, "GENERAL_PURPOSE_VALUE");
        constantSensorType.put(0x03, "LUMINANCE");
        constantSensorType.put(0x04, "POWER");
        constantSensorType.put(0x05, "RELATIVE_HUMIDITY");
        constantSensorType.put(0x06, "VELOCITY");
        constantSensorType.put(0x07, "DIRECTION");
        constantSensorType.put(0x08, "ATMOSPHERIC_PRESSURE");
        constantSensorType.put(0x09, "BAROMETRIC_PRESSURE");
        constantSensorType.put(0x0A, "SOLAR_RADIATION");
        constantSensorType.put(0x0B, "DEW_POINT");
        constantSensorType.put(0x0C, "RAIN_RATE");
        constantSensorType.put(0x0D, "TIDE_LEVEL");
        constantSensorType.put(0x0E, "WEIGHT");
        constantSensorType.put(0x0F, "VOLTAGE");
        constantSensorType.put(0x11, "CO2_LEVEL");
        constantSensorType.put(0x10, "CURRENT");
        constantSensorType.put(0x13, "TANK_CAPACITY");
        constantSensorType.put(0x12, "AIR_FLOW");
        constantSensorType.put(0x15, "ANGLE_POSITION");
        constantSensorType.put(0x14, "DISTANCE");
        constantSensorType.put(0x17, "WATER_TEMPERATURE");
        constantSensorType.put(0x16, "ROTATION");
        constantSensorType.put(0x19, "SEISMIC_INTENSITY");
        constantSensorType.put(0x18, "SOIL_TEMPERATURE");
        constantSensorType.put(0x1B, "ULTRAVIOLET");
        constantSensorType.put(0x1A, "SEISMIC_MAGNITUDE");
        constantSensorType.put(0x1D, "ELECTRICAL_CONDUCTIVITY");
        constantSensorType.put(0x1C, "ELECTRICAL_RESISTIVITY");
        constantSensorType.put(0x1F, "MOISTURE");
        constantSensorType.put(0x1E, "LOUDNESS");
        constantSensorType.put(0x22, "TARGET_TEMPERATURE");
        constantSensorType.put(0x23, "PARTICULATE_MATTER_2_5");
        constantSensorType.put(0x20, "FREQUENCY");
        constantSensorType.put(0x21, "TIME");
        constantSensorType.put(0x26, "METHANE_DENSITY_CH4");
        constantSensorType.put(0x27, "VOLATILE_ORGANIC_COMPOUND");
        constantSensorType.put(0x24, "FORMALDEHYDE_CH2O_LEVEL");
        constantSensorType.put(0x25, "RADON_CONCENTRATION");
        constantSensorType.put(0x2A, "SOIL_REACTIVITY");
        constantSensorType.put(0x2B, "SOIL_SALINITY");
        constantSensorType.put(0x28, "CARBON_MONOXIDE_CO_LEVEL");
        constantSensorType.put(0x29, "SOIL_HUMIDITY");
        constantSensorType.put(0x2E, "MUSCLE_MASS");
        constantSensorType.put(0x2F, "FAT_MASS");
        constantSensorType.put(0x2C, "HEART_RATE");
        constantSensorType.put(0x2D, "BLOOD_PRESSURE");
        constantSensorType.put(0x33, "BODY_MASS_INDEX_BMI");
        constantSensorType.put(0x32, "BASIC_METABOLIC_RATE_BMR");
        constantSensorType.put(0x31, "TOTAL_BODY_WATER_TBW");
        constantSensorType.put(0x30, "BONE_MASS");
        constantSensorType.put(0x37, "SMOKE_DENSITY");
        constantSensorType.put(0x36, "ACCELERATION_Z_AXIS");
        constantSensorType.put(0x35, "ACCELERATION_Y_AXIS");
        constantSensorType.put(0x34, "ACCELERATION_X_AXIS");

        // Constants for Bit Mask
        constantBitMask.put(0x01, "AIR_TEMPERATURE");
        constantBitMask.put(0x02, "GENERAL_PURPOSE_VALUE");
        constantBitMask.put(0x03, "LUMINANCE");
        constantBitMask.put(0x04, "POWER");
        constantBitMask.put(0x05, "HUMIDITY");
        constantBitMask.put(0x06, "VELOCITY");
        constantBitMask.put(0x07, "DIRECTION");
        constantBitMask.put(0x08, "ATMOSPHERIC_PRESSURE");
        constantBitMask.put(0x09, "BAROMETRIC_PRESSURE");
        constantBitMask.put(0x0A, "SOLAR_RADIATION");
        constantBitMask.put(0x0B, "DEW_POINT");
        constantBitMask.put(0x0C, "RAIN_RATE");
        constantBitMask.put(0x0D, "TIDE_LEVEL");
        constantBitMask.put(0x0E, "WEIGHT");
        constantBitMask.put(0x0F, "VOLTAGE");
        constantBitMask.put(0x11, "CO2_LEVEL");
        constantBitMask.put(0x10, "CURRENT");
        constantBitMask.put(0x13, "TANK_CAPACITY");
        constantBitMask.put(0x12, "AIR_FLOW");
        constantBitMask.put(0x15, "ANGLE_POSITION");
        constantBitMask.put(0x14, "DISTANCE");
        constantBitMask.put(0x17, "WATER_TEMPERATURE");
        constantBitMask.put(0x16, "ROTATION");
        constantBitMask.put(0x19, "SEISMIC_INTENSITY");
        constantBitMask.put(0x18, "SOIL_TEMPERATURE");
        constantBitMask.put(0x1B, "ULTRAVIOLET");
        constantBitMask.put(0x1A, "SEISMIC_MAGNITUDE");
        constantBitMask.put(0x1D, "ELECTRICAL_CONDUCTIVITY");
        constantBitMask.put(0x1C, "ELECTRICAL_RESISTIVITY");
        constantBitMask.put(0x1F, "MOISTURE");
        constantBitMask.put(0x1E, "LOUDNESS");
        constantBitMask.put(0x22, "TARGET_TEMPERATURE");
        constantBitMask.put(0x23, "PARTICULATE_MATTER_2_5");
        constantBitMask.put(0x20, "FREQUENCY");
        constantBitMask.put(0x21, "TIME");
        constantBitMask.put(0x26, "METHANE_DENSITY_CH4");
        constantBitMask.put(0x27, "VOLATILE_ORGANIC_COMPOUND");
        constantBitMask.put(0x24, "FORMALDEHYDE_CH2O_LEVEL");
        constantBitMask.put(0x25, "RADON_CONCENTRATION");
        constantBitMask.put(0x2A, "SOIL_REACTIVITY");
        constantBitMask.put(0x2B, "SOIL_SALINITY");
        constantBitMask.put(0x28, "CARBON_MONOXIDE_CO_LEVEL");
        constantBitMask.put(0x29, "SOIL_HUMIDITY");
        constantBitMask.put(0x2E, "MUSCLE_MASS");
        constantBitMask.put(0x2F, "FAT_MASS");
        constantBitMask.put(0x2C, "HEART_RATE");
        constantBitMask.put(0x2D, "BLOOD_PRESSURE");
        constantBitMask.put(0x33, "BODY_MASS_INDEX_BMI");
        constantBitMask.put(0x32, "BASIC_METABOLIC_RATE_BMR");
        constantBitMask.put(0x31, "TOTAL_BODY_WATER_TBW");
        constantBitMask.put(0x30, "BONE_MASS");
        constantBitMask.put(0x37, "SMOKE_DENSITY");
        constantBitMask.put(0x36, "ACCELERATION_Z_AXIS");
        constantBitMask.put(0x35, "ACCELERATION_Y_AXIS");
        constantBitMask.put(0x34, "ACCELERATION_X_AXIS");
    }

    /**
     * Creates a new message with the SENSOR_MULTILEVEL_SUPPORTED_GET_SENSOR command.
     * <p>
     * Multilevel Sensor Get Supported Sensor
     *
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getSensorMultilevelSupportedGetSensor() {
        logger.debug("Creating command message SENSOR_MULTILEVEL_SUPPORTED_GET_SENSOR version 8");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(SENSOR_MULTILEVEL_SUPPORTED_GET_SENSOR);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the SENSOR_MULTILEVEL_SUPPORTED_GET_SENSOR command.
     * <p>
     * Multilevel Sensor Get Supported Sensor
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleSensorMultilevelSupportedGetSensor(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Return the map of processed response data;
        return response;
    }


    /**
     * Creates a new message with the SENSOR_MULTILEVEL_SUPPORTED_SENSOR_REPORT command.
     * <p>
     * Multilevel Sensor Supported Sensor Report
     *
     * @param bitMask {@link List<String>}
     *            Can be one of the following -:
     *            <ul>
     *            <li>AIR_TEMPERATURE
     *            <li>GENERAL_PURPOSE_VALUE
     *            <li>LUMINANCE
     *            <li>POWER
     *            <li>HUMIDITY
     *            <li>VELOCITY
     *            <li>DIRECTION
     *            <li>ATMOSPHERIC_PRESSURE
     *            <li>BAROMETRIC_PRESSURE
     *            <li>SOLAR_RADIATION
     *            <li>DEW_POINT
     *            <li>RAIN_RATE
     *            <li>TIDE_LEVEL
     *            <li>WEIGHT
     *            <li>VOLTAGE
     *            <li>CO2_LEVEL
     *            <li>CURRENT
     *            <li>TANK_CAPACITY
     *            <li>AIR_FLOW
     *            <li>ANGLE_POSITION
     *            <li>DISTANCE
     *            <li>WATER_TEMPERATURE
     *            <li>ROTATION
     *            <li>SEISMIC_INTENSITY
     *            <li>SOIL_TEMPERATURE
     *            <li>ULTRAVIOLET
     *            <li>SEISMIC_MAGNITUDE
     *            <li>ELECTRICAL_CONDUCTIVITY
     *            <li>ELECTRICAL_RESISTIVITY
     *            <li>MOISTURE
     *            <li>LOUDNESS
     *            <li>TARGET_TEMPERATURE
     *            <li>PARTICULATE_MATTER_2_5
     *            <li>FREQUENCY
     *            <li>TIME
     *            <li>METHANE_DENSITY_CH4
     *            <li>VOLATILE_ORGANIC_COMPOUND
     *            <li>FORMALDEHYDE_CH2O_LEVEL
     *            <li>RADON_CONCENTRATION
     *            <li>SOIL_REACTIVITY
     *            <li>SOIL_SALINITY
     *            <li>CARBON_MONOXIDE_CO_LEVEL
     *            <li>SOIL_HUMIDITY
     *            <li>MUSCLE_MASS
     *            <li>FAT_MASS
     *            <li>HEART_RATE
     *            <li>BLOOD_PRESSURE
     *            <li>BODY_MASS_INDEX_BMI
     *            <li>BASIC_METABOLIC_RATE_BMR
     *            <li>TOTAL_BODY_WATER_TBW
     *            <li>BONE_MASS
     *            <li>SMOKE_DENSITY
     *            <li>ACCELERATION_Z_AXIS
     *            <li>ACCELERATION_Y_AXIS
     *            <li>ACCELERATION_X_AXIS
     *            </ul>
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getSensorMultilevelSupportedSensorReport(List<String> bitMask) {
        logger.debug("Creating command message SENSOR_MULTILEVEL_SUPPORTED_SENSOR_REPORT version 8");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(SENSOR_MULTILEVEL_SUPPORTED_SENSOR_REPORT);

        // Process 'Bit Mask'
        int valBitMask = 0;
        valBitMask |= (bitMask.contains("AIR_TEMPERATURE") ? 0x02 : 0);
        valBitMask |= (bitMask.contains("GENERAL_PURPOSE_VALUE") ? 0x04 : 0);
        valBitMask |= (bitMask.contains("LUMINANCE") ? 0x08 : 0);
        valBitMask |= (bitMask.contains("POWER") ? 0x10 : 0);
        valBitMask |= (bitMask.contains("HUMIDITY") ? 0x20 : 0);
        valBitMask |= (bitMask.contains("VELOCITY") ? 0x40 : 0);
        valBitMask |= (bitMask.contains("DIRECTION") ? 0x80 : 0);
        outputData.write(valBitMask);
        valBitMask = 0;
        valBitMask |= (bitMask.contains("ATMOSPHERIC_PRESSURE") ? 0x01 : 0);
        valBitMask |= (bitMask.contains("BAROMETRIC_PRESSURE") ? 0x02 : 0);
        valBitMask |= (bitMask.contains("SOLAR_RADIATION") ? 0x04 : 0);
        valBitMask |= (bitMask.contains("DEW_POINT") ? 0x08 : 0);
        valBitMask |= (bitMask.contains("RAIN_RATE") ? 0x10 : 0);
        valBitMask |= (bitMask.contains("TIDE_LEVEL") ? 0x20 : 0);
        valBitMask |= (bitMask.contains("WEIGHT") ? 0x40 : 0);
        valBitMask |= (bitMask.contains("VOLTAGE") ? 0x80 : 0);
        outputData.write(valBitMask);
        valBitMask = 0;
        valBitMask |= (bitMask.contains("CURRENT") ? 0x01 : 0);
        valBitMask |= (bitMask.contains("CO2_LEVEL") ? 0x02 : 0);
        valBitMask |= (bitMask.contains("AIR_FLOW") ? 0x04 : 0);
        valBitMask |= (bitMask.contains("TANK_CAPACITY") ? 0x08 : 0);
        valBitMask |= (bitMask.contains("DISTANCE") ? 0x10 : 0);
        valBitMask |= (bitMask.contains("ANGLE_POSITION") ? 0x20 : 0);
        valBitMask |= (bitMask.contains("ROTATION") ? 0x40 : 0);
        valBitMask |= (bitMask.contains("WATER_TEMPERATURE") ? 0x80 : 0);
        outputData.write(valBitMask);
        valBitMask = 0;
        valBitMask |= (bitMask.contains("SOIL_TEMPERATURE") ? 0x01 : 0);
        valBitMask |= (bitMask.contains("SEISMIC_INTENSITY") ? 0x02 : 0);
        valBitMask |= (bitMask.contains("SEISMIC_MAGNITUDE") ? 0x04 : 0);
        valBitMask |= (bitMask.contains("ULTRAVIOLET") ? 0x08 : 0);
        valBitMask |= (bitMask.contains("ELECTRICAL_RESISTIVITY") ? 0x10 : 0);
        valBitMask |= (bitMask.contains("ELECTRICAL_CONDUCTIVITY") ? 0x20 : 0);
        valBitMask |= (bitMask.contains("LOUDNESS") ? 0x40 : 0);
        valBitMask |= (bitMask.contains("MOISTURE") ? 0x80 : 0);
        outputData.write(valBitMask);
        valBitMask = 0;
        valBitMask |= (bitMask.contains("FREQUENCY") ? 0x01 : 0);
        valBitMask |= (bitMask.contains("TIME") ? 0x02 : 0);
        valBitMask |= (bitMask.contains("TARGET_TEMPERATURE") ? 0x04 : 0);
        valBitMask |= (bitMask.contains("PARTICULATE_MATTER_2_5") ? 0x08 : 0);
        valBitMask |= (bitMask.contains("FORMALDEHYDE_CH2O_LEVEL") ? 0x10 : 0);
        valBitMask |= (bitMask.contains("RADON_CONCENTRATION") ? 0x20 : 0);
        valBitMask |= (bitMask.contains("METHANE_DENSITY_CH4") ? 0x40 : 0);
        valBitMask |= (bitMask.contains("VOLATILE_ORGANIC_COMPOUND") ? 0x80 : 0);
        outputData.write(valBitMask);
        valBitMask = 0;
        valBitMask |= (bitMask.contains("CARBON_MONOXIDE_CO_LEVEL") ? 0x01 : 0);
        valBitMask |= (bitMask.contains("SOIL_HUMIDITY") ? 0x02 : 0);
        valBitMask |= (bitMask.contains("SOIL_REACTIVITY") ? 0x04 : 0);
        valBitMask |= (bitMask.contains("SOIL_SALINITY") ? 0x08 : 0);
        valBitMask |= (bitMask.contains("HEART_RATE") ? 0x10 : 0);
        valBitMask |= (bitMask.contains("BLOOD_PRESSURE") ? 0x20 : 0);
        valBitMask |= (bitMask.contains("MUSCLE_MASS") ? 0x40 : 0);
        valBitMask |= (bitMask.contains("FAT_MASS") ? 0x80 : 0);
        outputData.write(valBitMask);
        valBitMask = 0;
        valBitMask |= (bitMask.contains("BONE_MASS") ? 0x01 : 0);
        valBitMask |= (bitMask.contains("TOTAL_BODY_WATER_TBW") ? 0x02 : 0);
        valBitMask |= (bitMask.contains("BASIC_METABOLIC_RATE_BMR") ? 0x04 : 0);
        valBitMask |= (bitMask.contains("BODY_MASS_INDEX_BMI") ? 0x08 : 0);
        valBitMask |= (bitMask.contains("ACCELERATION_X_AXIS") ? 0x10 : 0);
        valBitMask |= (bitMask.contains("ACCELERATION_Y_AXIS") ? 0x20 : 0);
        valBitMask |= (bitMask.contains("ACCELERATION_Z_AXIS") ? 0x40 : 0);
        valBitMask |= (bitMask.contains("SMOKE_DENSITY") ? 0x80 : 0);
        outputData.write(valBitMask);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the SENSOR_MULTILEVEL_SUPPORTED_SENSOR_REPORT command.
     * <p>
     * Multilevel Sensor Supported Sensor Report
     * <p>
     * The output data {@link Map} has the following properties -:
     *
     * <ul>
     * <li>BIT_MASK {@link List}<{@link String}>
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleSensorMultilevelSupportedSensorReport(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Bit Mask'
        List<String> responseBitMask = new ArrayList<String>();
        for (int cntBitMask = 0; cntBitMask < (payload.length - 2) * 8; cntBitMask++) {
            if ((payload[2 + (cntBitMask / 8)] & (1 << cntBitMask % 8)) == 0) {
                continue;
            }
            responseBitMask.add(constantBitMask.get(cntBitMask));
        }
        response.put("BIT_MASK", responseBitMask);

        // Return the map of processed response data;
        return response;
    }


    /**
     * Creates a new message with the SENSOR_MULTILEVEL_SUPPORTED_GET_SCALE command.
     * <p>
     * Multilevel Sensor Get Supported Scale
     *
     * @param sensorType {@link String}
     *            Can be one of the following -:
     *            <ul>
     *            <li>TEMPERATURE
     *            <li>GENERAL_PURPOSE_VALUE
     *            <li>LUMINANCE
     *            <li>POWER
     *            <li>RELATIVE_HUMIDITY
     *            <li>VELOCITY
     *            <li>DIRECTION
     *            <li>ATMOSPHERIC_PRESSURE
     *            <li>BAROMETRIC_PRESSURE
     *            <li>SOLAR_RADIATION
     *            <li>DEW_POINT
     *            <li>RAIN_RATE
     *            <li>TIDE_LEVEL
     *            <li>WEIGHT
     *            <li>VOLTAGE
     *            <li>CO2_LEVEL
     *            <li>CURRENT
     *            <li>TANK_CAPACITY
     *            <li>AIR_FLOW
     *            <li>ANGLE_POSITION
     *            <li>DISTANCE
     *            <li>WATER_TEMPERATURE
     *            <li>ROTATION
     *            <li>SEISMIC_INTENSITY
     *            <li>SOIL_TEMPERATURE
     *            <li>ULTRAVIOLET
     *            <li>SEISMIC_MAGNITUDE
     *            <li>ELECTRICAL_CONDUCTIVITY
     *            <li>ELECTRICAL_RESISTIVITY
     *            <li>MOISTURE
     *            <li>LOUDNESS
     *            <li>TARGET_TEMPERATURE
     *            <li>PARTICULATE_MATTER_2_5
     *            <li>FREQUENCY
     *            <li>TIME
     *            <li>METHANE_DENSITY_CH4
     *            <li>VOLATILE_ORGANIC_COMPOUND
     *            <li>FORMALDEHYDE_CH2O_LEVEL
     *            <li>RADON_CONCENTRATION
     *            <li>SOIL_REACTIVITY
     *            <li>SOIL_SALINITY
     *            <li>CARBON_MONOXIDE_CO_LEVEL
     *            <li>SOIL_HUMIDITY
     *            <li>MUSCLE_MASS
     *            <li>FAT_MASS
     *            <li>HEART_RATE
     *            <li>BLOOD_PRESSURE
     *            <li>BODY_MASS_INDEX_BMI
     *            <li>BASIC_METABOLIC_RATE_BMR
     *            <li>TOTAL_BODY_WATER_TBW
     *            <li>BONE_MASS
     *            <li>SMOKE_DENSITY
     *            <li>ACCELERATION_Z_AXIS
     *            <li>ACCELERATION_Y_AXIS
     *            <li>ACCELERATION_X_AXIS
     *            </ul>
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getSensorMultilevelSupportedGetScale(String sensorType) {
        logger.debug("Creating command message SENSOR_MULTILEVEL_SUPPORTED_GET_SCALE version 8");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(SENSOR_MULTILEVEL_SUPPORTED_GET_SCALE);

        // Process 'Sensor Type'
        boolean foundSensorType = false;
        for (Integer entry : constantSensorType.keySet()) {
            if (constantSensorType.get(entry).equals(sensorType)) {
                outputData.write(entry);
                foundSensorType = true;
                break;
            }
        }
        if (!foundSensorType) {
            throw new IllegalArgumentException("Unknown constant value '" + sensorType + "' for sensorType");
        }

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the SENSOR_MULTILEVEL_SUPPORTED_GET_SCALE command.
     * <p>
     * Multilevel Sensor Get Supported Scale
     * <p>
     * The output data {@link Map} has the following properties -:
     *
     * <ul>
     * <li>SENSOR_TYPE {@link String}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleSensorMultilevelSupportedGetScale(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Sensor Type'
        response.put("SENSOR_TYPE", constantSensorType.get(payload[2] & 0xff));

        // Return the map of processed response data;
        return response;
    }


    /**
     * Creates a new message with the SENSOR_MULTILEVEL_GET command.
     * <p>
     * Multilevel Sensor Get
     *
     * @param sensorType {@link String}
     *            Can be one of the following -:
     *            <ul>
     *            <li>TEMPERATURE
     *            <li>GENERAL_PURPOSE_VALUE
     *            <li>LUMINANCE
     *            <li>POWER
     *            <li>RELATIVE_HUMIDITY
     *            <li>VELOCITY
     *            <li>DIRECTION
     *            <li>ATMOSPHERIC_PRESSURE
     *            <li>BAROMETRIC_PRESSURE
     *            <li>SOLAR_RADIATION
     *            <li>DEW_POINT
     *            <li>RAIN_RATE
     *            <li>TIDE_LEVEL
     *            <li>WEIGHT
     *            <li>VOLTAGE
     *            <li>CO2_LEVEL
     *            <li>CURRENT
     *            <li>TANK_CAPACITY
     *            <li>AIR_FLOW
     *            <li>ANGLE_POSITION
     *            <li>DISTANCE
     *            <li>WATER_TEMPERATURE
     *            <li>ROTATION
     *            <li>SEISMIC_INTENSITY
     *            <li>SOIL_TEMPERATURE
     *            <li>ULTRAVIOLET
     *            <li>SEISMIC_MAGNITUDE
     *            <li>ELECTRICAL_CONDUCTIVITY
     *            <li>ELECTRICAL_RESISTIVITY
     *            <li>MOISTURE
     *            <li>LOUDNESS
     *            <li>TARGET_TEMPERATURE
     *            <li>PARTICULATE_MATTER_2_5
     *            <li>FREQUENCY
     *            <li>TIME
     *            <li>METHANE_DENSITY_CH4
     *            <li>VOLATILE_ORGANIC_COMPOUND
     *            <li>FORMALDEHYDE_CH2O_LEVEL
     *            <li>RADON_CONCENTRATION
     *            <li>SOIL_REACTIVITY
     *            <li>SOIL_SALINITY
     *            <li>CARBON_MONOXIDE_CO_LEVEL
     *            <li>SOIL_HUMIDITY
     *            <li>MUSCLE_MASS
     *            <li>FAT_MASS
     *            <li>HEART_RATE
     *            <li>BLOOD_PRESSURE
     *            <li>BODY_MASS_INDEX_BMI
     *            <li>BASIC_METABOLIC_RATE_BMR
     *            <li>TOTAL_BODY_WATER_TBW
     *            <li>BONE_MASS
     *            <li>SMOKE_DENSITY
     *            <li>ACCELERATION_Z_AXIS
     *            <li>ACCELERATION_Y_AXIS
     *            <li>ACCELERATION_X_AXIS
     *            </ul>
     * @param scale {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getSensorMultilevelGet(String sensorType, Integer scale) {
        logger.debug("Creating command message SENSOR_MULTILEVEL_GET version 8");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(SENSOR_MULTILEVEL_GET);

        // Process 'Sensor Type'
        boolean foundSensorType = false;
        for (Integer entry : constantSensorType.keySet()) {
            if (constantSensorType.get(entry).equals(sensorType)) {
                outputData.write(entry);
                foundSensorType = true;
                break;
            }
        }
        if (!foundSensorType) {
            throw new IllegalArgumentException("Unknown constant value '" + sensorType + "' for sensorType");
        }

        // Process 'Properties1'
        outputData.write(((scale << 3) & 0x18));

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the SENSOR_MULTILEVEL_GET command.
     * <p>
     * Multilevel Sensor Get
     * <p>
     * The output data {@link Map} has the following properties -:
     *
     * <ul>
     * <li>SENSOR_TYPE {@link String}
     * <li>SCALE {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleSensorMultilevelGet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Sensor Type'
        response.put("SENSOR_TYPE", constantSensorType.get(payload[2] & 0xff));

        // Process 'Properties1'
        response.put("SCALE", Integer.valueOf(payload[3] & 0x18 >> 3));

        // Return the map of processed response data;
        return response;
    }


    /**
     * Creates a new message with the SENSOR_MULTILEVEL_REPORT command.
     * <p>
     * Multilevel Sensor Report
     *
     * @param sensorType {@link String}
     *            Can be one of the following -:
     *            <ul>
     *            <li>TEMPERATURE
     *            <li>GENERAL_PURPOSE_VALUE
     *            <li>LUMINANCE
     *            <li>POWER
     *            <li>RELATIVE_HUMIDITY
     *            <li>VELOCITY
     *            <li>DIRECTION
     *            <li>ATMOSPHERIC_PRESSURE
     *            <li>BAROMETRIC_PRESSURE
     *            <li>SOLAR_RADIATION
     *            <li>DEW_POINT
     *            <li>RAIN_RATE
     *            <li>TIDE_LEVEL
     *            <li>WEIGHT
     *            <li>VOLTAGE
     *            <li>CO2_LEVEL
     *            <li>CURRENT
     *            <li>TANK_CAPACITY
     *            <li>AIR_FLOW
     *            <li>ANGLE_POSITION
     *            <li>DISTANCE
     *            <li>WATER_TEMPERATURE
     *            <li>ROTATION
     *            <li>SEISMIC_INTENSITY
     *            <li>SOIL_TEMPERATURE
     *            <li>ULTRAVIOLET
     *            <li>SEISMIC_MAGNITUDE
     *            <li>ELECTRICAL_CONDUCTIVITY
     *            <li>ELECTRICAL_RESISTIVITY
     *            <li>MOISTURE
     *            <li>LOUDNESS
     *            <li>TARGET_TEMPERATURE
     *            <li>PARTICULATE_MATTER_2_5
     *            <li>FREQUENCY
     *            <li>TIME
     *            <li>METHANE_DENSITY_CH4
     *            <li>VOLATILE_ORGANIC_COMPOUND
     *            <li>FORMALDEHYDE_CH2O_LEVEL
     *            <li>RADON_CONCENTRATION
     *            <li>SOIL_REACTIVITY
     *            <li>SOIL_SALINITY
     *            <li>CARBON_MONOXIDE_CO_LEVEL
     *            <li>SOIL_HUMIDITY
     *            <li>MUSCLE_MASS
     *            <li>FAT_MASS
     *            <li>HEART_RATE
     *            <li>BLOOD_PRESSURE
     *            <li>BODY_MASS_INDEX_BMI
     *            <li>BASIC_METABOLIC_RATE_BMR
     *            <li>TOTAL_BODY_WATER_TBW
     *            <li>BONE_MASS
     *            <li>SMOKE_DENSITY
     *            <li>ACCELERATION_Z_AXIS
     *            <li>ACCELERATION_Y_AXIS
     *            <li>ACCELERATION_X_AXIS
     *            </ul>
     * @param scale {@link Integer}
     * @param precision {@link Integer}
     * @param sensorValue {@link byte[]}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getSensorMultilevelReport(String sensorType, Integer scale, Integer precision,
            byte[] sensorValue) {
        logger.debug("Creating command message SENSOR_MULTILEVEL_REPORT version 8");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(SENSOR_MULTILEVEL_REPORT);

        // Process 'Sensor Type'
        boolean foundSensorType = false;
        for (Integer entry : constantSensorType.keySet()) {
            if (constantSensorType.get(entry).equals(sensorType)) {
                outputData.write(entry);
                foundSensorType = true;
                break;
            }
        }
        if (!foundSensorType) {
            throw new IllegalArgumentException("Unknown constant value '" + sensorType + "' for sensorType");
        }

        // Process 'Level'
        // Size is used by 'Sensor Value'
        int size = sensorValue.length;
        int valLevel = 0;
        valLevel |= size & 0x07;
        valLevel |= ((scale << 3) & 0x18);
        valLevel |= ((precision << 5) & 0xE0);
        outputData.write(valLevel);

        // Process 'Sensor Value'
        if (sensorValue != null) {
            try {
                outputData.write(sensorValue);
            } catch (IOException e) {
            }
        }

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the SENSOR_MULTILEVEL_REPORT command.
     * <p>
     * Multilevel Sensor Report
     * <p>
     * The output data {@link Map} has the following properties -:
     *
     * <ul>
     * <li>SENSOR_TYPE {@link String}
     * <li>SCALE {@link Integer}
     * <li>PRECISION {@link Integer}
     * <li>SENSOR_VALUE {@link byte[]}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleSensorMultilevelReport(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // We're using variable length fields, so track the offset
        int msgOffset = 2;

        // Process 'Sensor Type'
        response.put("SENSOR_TYPE", constantSensorType.get(payload[msgOffset] & 0xff));
        msgOffset += 1;

        // Process 'Level'
        // Size is used by 'Sensor Value'
        int varSize = payload[msgOffset] & 0x07;
        response.put("SCALE", Integer.valueOf(payload[msgOffset] & 0x18 >> 3));
        response.put("PRECISION", Integer.valueOf(payload[msgOffset] & 0xE0 >> 5));
        msgOffset += 1;

        // Process 'Sensor Value'
        ByteArrayOutputStream valSensorValue = new ByteArrayOutputStream();
        for (int cntSensorValue = 0; cntSensorValue < varSize; cntSensorValue++) {
            valSensorValue.write(payload[msgOffset + cntSensorValue]);
        }
        response.put("SENSOR_VALUE", valSensorValue.toByteArray());
        msgOffset += varSize;

        // Return the map of processed response data;
        return response;
    }


    /**
     * Creates a new message with the SENSOR_MULTILEVEL_SUPPORTED_SCALE_REPORT command.
     * <p>
     * Multilevel Sensor Supported Scale Report
     *
     * @param sensorType {@link String}
     *            Can be one of the following -:
     *            <ul>
     *            <li>TEMPERATURE
     *            <li>GENERAL_PURPOSE_VALUE
     *            <li>LUMINANCE
     *            <li>POWER
     *            <li>RELATIVE_HUMIDITY
     *            <li>VELOCITY
     *            <li>DIRECTION
     *            <li>ATMOSPHERIC_PRESSURE
     *            <li>BAROMETRIC_PRESSURE
     *            <li>SOLAR_RADIATION
     *            <li>DEW_POINT
     *            <li>RAIN_RATE
     *            <li>TIDE_LEVEL
     *            <li>WEIGHT
     *            <li>VOLTAGE
     *            <li>CO2_LEVEL
     *            <li>CURRENT
     *            <li>TANK_CAPACITY
     *            <li>AIR_FLOW
     *            <li>ANGLE_POSITION
     *            <li>DISTANCE
     *            <li>WATER_TEMPERATURE
     *            <li>ROTATION
     *            <li>SEISMIC_INTENSITY
     *            <li>SOIL_TEMPERATURE
     *            <li>ULTRAVIOLET
     *            <li>SEISMIC_MAGNITUDE
     *            <li>ELECTRICAL_CONDUCTIVITY
     *            <li>ELECTRICAL_RESISTIVITY
     *            <li>MOISTURE
     *            <li>LOUDNESS
     *            <li>TARGET_TEMPERATURE
     *            <li>PARTICULATE_MATTER_2_5
     *            <li>FREQUENCY
     *            <li>TIME
     *            <li>METHANE_DENSITY_CH4
     *            <li>VOLATILE_ORGANIC_COMPOUND
     *            <li>FORMALDEHYDE_CH2O_LEVEL
     *            <li>RADON_CONCENTRATION
     *            <li>SOIL_REACTIVITY
     *            <li>SOIL_SALINITY
     *            <li>CARBON_MONOXIDE_CO_LEVEL
     *            <li>SOIL_HUMIDITY
     *            <li>MUSCLE_MASS
     *            <li>FAT_MASS
     *            <li>HEART_RATE
     *            <li>BLOOD_PRESSURE
     *            <li>BODY_MASS_INDEX_BMI
     *            <li>BASIC_METABOLIC_RATE_BMR
     *            <li>TOTAL_BODY_WATER_TBW
     *            <li>BONE_MASS
     *            <li>SMOKE_DENSITY
     *            <li>ACCELERATION_Z_AXIS
     *            <li>ACCELERATION_Y_AXIS
     *            <li>ACCELERATION_X_AXIS
     *            </ul>
     * @param scaleBitMask {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getSensorMultilevelSupportedScaleReport(String sensorType, Integer scaleBitMask) {
        logger.debug("Creating command message SENSOR_MULTILEVEL_SUPPORTED_SCALE_REPORT version 8");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(SENSOR_MULTILEVEL_SUPPORTED_SCALE_REPORT);

        // Process 'Sensor Type'
        boolean foundSensorType = false;
        for (Integer entry : constantSensorType.keySet()) {
            if (constantSensorType.get(entry).equals(sensorType)) {
                outputData.write(entry);
                foundSensorType = true;
                break;
            }
        }
        if (!foundSensorType) {
            throw new IllegalArgumentException("Unknown constant value '" + sensorType + "' for sensorType");
        }

        // Process 'Properties1'
        outputData.write(scaleBitMask & 0x0F);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the SENSOR_MULTILEVEL_SUPPORTED_SCALE_REPORT command.
     * <p>
     * Multilevel Sensor Supported Scale Report
     * <p>
     * The output data {@link Map} has the following properties -:
     *
     * <ul>
     * <li>SENSOR_TYPE {@link String}
     * <li>SCALE_BIT_MASK {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleSensorMultilevelSupportedScaleReport(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Sensor Type'
        response.put("SENSOR_TYPE", constantSensorType.get(payload[2] & 0xff));

        // Process 'Properties1'
        response.put("SCALE_BIT_MASK", Integer.valueOf(payload[3] & 0x0F));

        // Return the map of processed response data;
        return response;
    }

}
