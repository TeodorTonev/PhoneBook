public class Contact {
    private static final int MAX_LENGTH_NORMAL_PHONE_NUMBER = TypePhoneNumber.NORMAL.getPhoneNumberLength();
    private static final String START_NORMAL_PHONE_NUMBER_WITH = "+359";
    private static final char DIGIT_4_OF_NORMAL_PHONE_NUMBER = '8';
    private static final char DIGIT_5_MIN_VALUE_OF_NORMAL_PHONE_NUMBER = '7';
    private static final char MAX_VALUE_OF_DIGIT_OF_PHONE_NUMBER = '9';
    private static final char MIN_VALUE_OF_DIGIT_OF_PHONE_NUMBER = '0';
    private static final int MAX_LENGTH_NUMBER_WITH_ONE_ZERO = TypePhoneNumber.WITH_ONE_ZERO.getPhoneNumberLength();
    private static final int MAX_LENGTH_NUMBER_WITH_TWO_ZERO = TypePhoneNumber.WITH_TWO_ZERO.getPhoneNumberLength();
    private static final String START_PHONE_NUMBER_WITH_ONE_ZERO_WITH = "0";
    private static final String START_PHONE_NUMBER_WITH_TWO_ZEROS_WITH = "00359";
    private static final char LAST_DIGIT_VALUE_ON_MOBILE_OPERATORS = '2';
    private String fullName;
    private String phoneNumber;
    private int countOutgoingCalls;

    public Contact(String fullName, String phoneNumber) throws ContactException {
        setFullName(fullName);
        setPhoneNumber(phoneNumber);
    }

    private void setFullName(String fName) throws ContactException {
        if (isValidName(fName)) {
            this.fullName = fName;
        }
        else {
            throw new ContactException("Invalid first name!");
        }
    }

    private void setPhoneNumber(String phNumber) throws ContactException {
        if (isValidNormalPhoneNumber(phNumber) || isValidPhoneNumberWithOneZero(phNumber) ||
                isValidPhoneNumberWithTwoZeros(phNumber)) {
            this.phoneNumber = phNumber;
        }
        else {
            throw new ContactException("Invalid mobile number!");
        }
    }

    private boolean isValidName(String name) {
        return name != null && name.trim().length() > 0;
    }

    private boolean isValidNormalPhoneNumber(String phoneNumber) {
        return phoneNumber != null && phoneNumber.trim().length() == MAX_LENGTH_NORMAL_PHONE_NUMBER &&
                phoneNumber.startsWith(START_NORMAL_PHONE_NUMBER_WITH) && phoneNumber.charAt(4) == DIGIT_4_OF_NORMAL_PHONE_NUMBER &&
                (phoneNumber.charAt(5) >= DIGIT_5_MIN_VALUE_OF_NORMAL_PHONE_NUMBER && phoneNumber.charAt(5) <= MAX_VALUE_OF_DIGIT_OF_PHONE_NUMBER) &&
                (phoneNumber.charAt(6) >= LAST_DIGIT_VALUE_ON_MOBILE_OPERATORS && phoneNumber.charAt(6) <= MAX_VALUE_OF_DIGIT_OF_PHONE_NUMBER) &&
                (phoneNumber.charAt(7) >= MIN_VALUE_OF_DIGIT_OF_PHONE_NUMBER && phoneNumber.charAt(7) <= MAX_VALUE_OF_DIGIT_OF_PHONE_NUMBER) &&
                (phoneNumber.charAt(8) >= MIN_VALUE_OF_DIGIT_OF_PHONE_NUMBER && phoneNumber.charAt(8) <= MAX_VALUE_OF_DIGIT_OF_PHONE_NUMBER) &&
                (phoneNumber.charAt(9) >= MIN_VALUE_OF_DIGIT_OF_PHONE_NUMBER && phoneNumber.charAt(9) <= MAX_VALUE_OF_DIGIT_OF_PHONE_NUMBER) &&
                (phoneNumber.charAt(10) >= MIN_VALUE_OF_DIGIT_OF_PHONE_NUMBER && phoneNumber.charAt(10) <= MAX_VALUE_OF_DIGIT_OF_PHONE_NUMBER) &&
                (phoneNumber.charAt(11) >= MIN_VALUE_OF_DIGIT_OF_PHONE_NUMBER && phoneNumber.charAt(11) <= MAX_VALUE_OF_DIGIT_OF_PHONE_NUMBER) &&
                (phoneNumber.charAt(12) >= MIN_VALUE_OF_DIGIT_OF_PHONE_NUMBER && phoneNumber.charAt(12) <= MAX_VALUE_OF_DIGIT_OF_PHONE_NUMBER);
    }

    private boolean isValidPhoneNumberWithOneZero(String phoneNumber) {
        return phoneNumber != null && phoneNumber.trim().length() == MAX_LENGTH_NUMBER_WITH_ONE_ZERO &&
                phoneNumber.startsWith(START_PHONE_NUMBER_WITH_ONE_ZERO_WITH) && phoneNumber.charAt(1) == DIGIT_4_OF_NORMAL_PHONE_NUMBER &&
                (phoneNumber.charAt(2) >= DIGIT_5_MIN_VALUE_OF_NORMAL_PHONE_NUMBER && phoneNumber.charAt(2) <= MAX_VALUE_OF_DIGIT_OF_PHONE_NUMBER) &&
                (phoneNumber.charAt(3) >= LAST_DIGIT_VALUE_ON_MOBILE_OPERATORS && phoneNumber.charAt(3) <= MAX_VALUE_OF_DIGIT_OF_PHONE_NUMBER) &&
                (phoneNumber.charAt(4) >= MIN_VALUE_OF_DIGIT_OF_PHONE_NUMBER && phoneNumber.charAt(4) <= MAX_VALUE_OF_DIGIT_OF_PHONE_NUMBER) &&
                (phoneNumber.charAt(5) >= MIN_VALUE_OF_DIGIT_OF_PHONE_NUMBER && phoneNumber.charAt(5) <= MAX_VALUE_OF_DIGIT_OF_PHONE_NUMBER) &&
                (phoneNumber.charAt(6) >= MIN_VALUE_OF_DIGIT_OF_PHONE_NUMBER && phoneNumber.charAt(6) <= MAX_VALUE_OF_DIGIT_OF_PHONE_NUMBER) &&
                (phoneNumber.charAt(7) >= MIN_VALUE_OF_DIGIT_OF_PHONE_NUMBER && phoneNumber.charAt(7) <= MAX_VALUE_OF_DIGIT_OF_PHONE_NUMBER) &&
                (phoneNumber.charAt(8) >= MIN_VALUE_OF_DIGIT_OF_PHONE_NUMBER && phoneNumber.charAt(8) <= MAX_VALUE_OF_DIGIT_OF_PHONE_NUMBER) &&
                (phoneNumber.charAt(9) >= MIN_VALUE_OF_DIGIT_OF_PHONE_NUMBER && phoneNumber.charAt(9) <= MAX_VALUE_OF_DIGIT_OF_PHONE_NUMBER);
    }
    private boolean isValidPhoneNumberWithTwoZeros(String phoneNumber) {
        return phoneNumber != null && phoneNumber.trim().length() == MAX_LENGTH_NUMBER_WITH_TWO_ZERO &&
                phoneNumber.startsWith(START_PHONE_NUMBER_WITH_TWO_ZEROS_WITH) && phoneNumber.charAt(5) == DIGIT_4_OF_NORMAL_PHONE_NUMBER &&
                (phoneNumber.charAt(6) >= DIGIT_5_MIN_VALUE_OF_NORMAL_PHONE_NUMBER && phoneNumber.charAt(6) <= MAX_VALUE_OF_DIGIT_OF_PHONE_NUMBER) &&
                (phoneNumber.charAt(7) >= LAST_DIGIT_VALUE_ON_MOBILE_OPERATORS && phoneNumber.charAt(7) <= MAX_VALUE_OF_DIGIT_OF_PHONE_NUMBER) &&
                (phoneNumber.charAt(8) >= MIN_VALUE_OF_DIGIT_OF_PHONE_NUMBER && phoneNumber.charAt(8) <= MAX_VALUE_OF_DIGIT_OF_PHONE_NUMBER) &&
                (phoneNumber.charAt(9) >= MIN_VALUE_OF_DIGIT_OF_PHONE_NUMBER && phoneNumber.charAt(9) <= MAX_VALUE_OF_DIGIT_OF_PHONE_NUMBER) &&
                (phoneNumber.charAt(10) >= MIN_VALUE_OF_DIGIT_OF_PHONE_NUMBER && phoneNumber.charAt(10) <= MAX_VALUE_OF_DIGIT_OF_PHONE_NUMBER) &&
                (phoneNumber.charAt(11) >= MIN_VALUE_OF_DIGIT_OF_PHONE_NUMBER && phoneNumber.charAt(11) <= MAX_VALUE_OF_DIGIT_OF_PHONE_NUMBER) &&
                (phoneNumber.charAt(12) >= MIN_VALUE_OF_DIGIT_OF_PHONE_NUMBER && phoneNumber.charAt(12) <= MAX_VALUE_OF_DIGIT_OF_PHONE_NUMBER) &&
                (phoneNumber.charAt(13) >= MIN_VALUE_OF_DIGIT_OF_PHONE_NUMBER && phoneNumber.charAt(13) <= MAX_VALUE_OF_DIGIT_OF_PHONE_NUMBER);
    }

    @Override
    public boolean equals(Object object) {
        if (object == null && !(object instanceof Contact)) {
            return false;
        }
        return ((Contact) object).fullName.equals(this.fullName) &&
                ((Contact) object).phoneNumber.equals(this.phoneNumber);
    }

    @Override
    public int hashCode() {
        return this.fullName.hashCode() * this.phoneNumber.hashCode();
    }

    @Override
    public String toString() {
        return "[Contact named " + this.fullName + " has a phone number " + this.phoneNumber + "]";
    }

    public String getFullName() {
        return fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getCountOutgoingCalls() {
        return countOutgoingCalls;
    }

    public void setCountOutgoingCalls(int countOutgoingCalls) {
        this.countOutgoingCalls = countOutgoingCalls;
    }
}
