package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;


public class Contact {
	
    public static final String MESSAGE_PHONE_CONSTRAINTS = "Person phone numbers should only contain numbers";
    public static final String PHONE_VALIDATION_REGEX = "\\d+";    
    
    public static final String MESSAGE_EMAIL_CONSTRAINTS =
            "Person emails should be 2 alphanumeric/period strings separated by '@'";
    public static final String EMAIL_VALIDATION_REGEX = "[\\w\\.]+@[\\w\\.]+";
    
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses can be in any format";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";
	
	public final String value;
    private boolean isPrivate; 
    
    public Contact(String _value, boolean isPrivate, String type) throws IllegalValueException {
        this.isPrivate = isPrivate;
        String trimmedvalue = _value.trim();
        
        switch(type) {
        case "phone" :
        	if (!isValidPhone(trimmedvalue)) {
        		throw new IllegalValueException(MESSAGE_PHONE_CONSTRAINTS);
			}
        	break;
        	
        case "email" :
        	if (!isValidEmail(trimmedvalue)) {
                throw new IllegalValueException(MESSAGE_EMAIL_CONSTRAINTS);
            }
        	break;
        	
        case "address" :
        	if (!isValidAddress(trimmedvalue)) {
                throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
            }
        	break;
        	
        }    				
        this.value = trimmedvalue;
    }
        /**
         * Returns true if the given string is a valid person phone number.
         */
        public static boolean isValidPhone(String test) {
            return test.matches(PHONE_VALIDATION_REGEX);
        }
        
        /**
         * Returns true if the given string is a valid person email.
         */
        public static boolean isValidEmail(String test) {
            return test.matches(EMAIL_VALIDATION_REGEX);
        }
        
        /**
         * Returns true if a given string is a valid person address.
         */
        public static boolean isValidAddress(String test) {
            return test.matches(ADDRESS_VALIDATION_REGEX);
        }

        @Override
        public String toString() {
            return value;
        }

        @Override
        public int hashCode() {
            return value.hashCode();
        }

        public boolean isPrivate() {
            return isPrivate;
        }
    }
