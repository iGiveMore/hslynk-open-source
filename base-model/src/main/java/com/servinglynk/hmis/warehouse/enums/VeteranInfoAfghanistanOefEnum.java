package com.servinglynk.hmis.warehouse.enums;
import java.util.Map;
import java.util.HashMap;
/**
 * Defines the VeteranInfoAfghanistanOefEnum enumeration.
 * 
 * @author Sandeep Dolia
 *
 */
public enum VeteranInfoAfghanistanOefEnum {

	/** Enum Constant. */
	ZERO("0"),
	/** Enum Constant. */
	ONE("1"),
	/** Enum Constant. */
	EIGHT("8"),
	/** Enum Constant. */
	NINE("9"),
	/** Enum Constant. */
	NINTY_NINE("99");
	/**
	 * Internal storage of status field value, see the Enum spec for
 	 * clarification.
 	 */
	private final String status;
	
	/**
	 * Enum constructor for ActiveState.
	 * @param state Value.
	 */
	VeteranInfoAfghanistanOefEnum(final String state) {
		this.status = state;
	}
	
	/** Construct a map for reverse lookup. */
	private static Map<String, VeteranInfoAfghanistanOefEnum> valueMap = new HashMap<String, VeteranInfoAfghanistanOefEnum>();

    static {
    	// construct hashmap for later possible use.
        for (VeteranInfoAfghanistanOefEnum unit : values()) {
            valueMap.put(unit.getValue(), unit);
        }
    }
    
	/**
	 * Current string value stored in the enum.
	 * 
	 * @return string value.
	 */
	public String getValue() {
		return this.status;
	}

	/**
     * Perform a reverse lookup (given a value, obtain the enum).
     * 
     * @param value to search
     * @return Enum object.
     */
    public static VeteranInfoAfghanistanOefEnum lookupEnum(String value) {
        return VeteranInfoAfghanistanOefEnum.valueMap.get(value);
    }

}