public enum TypePhoneNumber {
    NORMAL(13), WITH_ONE_ZERO(10), WITH_TWO_ZERO(14);

    private int phoneNumberLength;

    TypePhoneNumber(int phoneNumberLength) {
        this.phoneNumberLength = phoneNumberLength;
    }

    public int getPhoneNumberLength() {
        return phoneNumberLength;
    }
}
