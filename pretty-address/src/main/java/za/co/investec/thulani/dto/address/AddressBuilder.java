package za.co.investec.thulani.dto.address;

import java.sql.Timestamp;

/**
 * author: Thulani Hlongwane
 * Date: 2019/08/11
 */
public class AddressBuilder {

    private long id;
    private AddressType type;
    private AddressLineDetail addressLineDetail;
    private State provinceOrState;
    private String cityOrTown;
    private Country country;
    private String postalCode;
    private String suburbOrDistrict;
    private Timestamp lastUpdated;

    public AddressBuilder(final long id) {
        this.id = id;
    }

    public AddressBuilder setId(final long id) {
        this.id = id;
        return this;
    }

    public AddressBuilder setType(final AddressType.Type type) {
        this.type = new AddressType(type);
        return this;
    }

    public AddressBuilder setAddressLineDetail(final AddressLineDetail addressLineDetail) {
        this.addressLineDetail = addressLineDetail;
        return this;
    }

    public AddressBuilder setProvinceOrState(final State provinceOrState) {
        this.provinceOrState = provinceOrState;
        return this;
    }

    public AddressBuilder setCityOrTown(final String cityOrTown) {
        this.cityOrTown = cityOrTown;
        return this;
    }

    public AddressBuilder setCountry(final Country country) {
        this.country = country;
        return this;
    }

    public AddressBuilder setPostalCode(final String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public AddressBuilder setSuburbOrDistrict(final String suburbOrDistrict) {
        this.suburbOrDistrict = suburbOrDistrict;
        return this;
    }

    public AddressBuilder setLastUpdated(final Timestamp lastUpdated) {
        this.lastUpdated = lastUpdated;
        return this;
    }

    public Address build() {
        return new Address(id, type, addressLineDetail, provinceOrState, cityOrTown,
                country, postalCode, suburbOrDistrict, lastUpdated);
    }
}
