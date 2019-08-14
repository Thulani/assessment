package za.co.investec.thulani.dto.address;

/**
 * author: Thulani Hlongwane
 * Date: 2019/08/11
 */
public class AddressType {

    public enum Type {
        PHYSICAL_ADDRESS(1, "Physical Address"), POSTAL_ADDRESS(2, "Postal Address"), BUSINESS_ADDRESS(5, "Business Address");

        private long code;
        private String name;

        Type(final long code, final String name) {
            this.code = code;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public long getCode() {
            return code;
        }
    }

    private long code;
    private String name;

    AddressType(Type type) {
        this.code = type.getCode();
        this.name = type.getName();
    }

    public long getCode() {
        return code;
    }

    public AddressType setCode(final long code) {
        this.code = code;
        return this;
    }

    public String getName() {
        return name;
    }

    public AddressType setName(final String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return name;
    }
}
