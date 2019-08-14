package za.co.investec.thulani.dto.address;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * author: Thulani Hlongwane
 * Date: 2019/08/11
 */
public class Address implements Serializable {

    private long id;
    private AddressType type;
    private AddressLineDetail addressLineDetail;
    private State provinceOrState;
    private String cityOrTown;
    private Country country;
    private String postalCode;
    private String suburbOrDistrict;
    private Timestamp lastUpdated;

    protected Address() {
    }

    public Address(final long id, final AddressType type, final AddressLineDetail addressLineDetail,
                   final State provinceOrState, final String cityOrTown, final Country country,
                   final String postalCode, final String suburbOrDistrict, final Timestamp lastUpdated) {
        this.id = id;
        this.type = type;
        this.addressLineDetail = addressLineDetail;
        this.provinceOrState = provinceOrState;
        this.cityOrTown = cityOrTown;
        this.country = country;
        this.postalCode = postalCode;
        this.suburbOrDistrict = suburbOrDistrict;
        this.lastUpdated = lastUpdated;
    }

    public long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public AddressType getType() {
        return type;
    }

    public void setType(final AddressType type) {
        this.type = type;
    }

    public AddressLineDetail getAddressLineDetail() {
        return addressLineDetail;
    }

    public void setAddressLineDetail(final AddressLineDetail addressLineDetail) {
        this.addressLineDetail = addressLineDetail;
    }

    public State getProvinceOrState() {
        return provinceOrState;
    }

    public void setProvinceOrState(final State provinceOrState) {
        this.provinceOrState = provinceOrState;
    }

    public String getCityOrTown() {
        return cityOrTown;
    }

    public void setCityOrTown(final String cityOrTown) {
        this.cityOrTown = cityOrTown;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(final Country country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(final String postalCode) {
        this.postalCode = postalCode;
    }

    public String getSuburbOrDistrict() {
        return suburbOrDistrict;
    }

    public void setSuburbOrDistrict(final String suburbOrDistrict) {
        this.suburbOrDistrict = suburbOrDistrict;
    }

    public Timestamp getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(final Timestamp lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @Override
    public String toString() {
        return (type != null ? type.toString() + ": " : "") +
                (addressLineDetail != null ? addressLineDetail.toString() : "") +
                (StringUtils.isNotBlank(cityOrTown) ? " - " + cityOrTown : "") +
                (provinceOrState != null ? " - " + provinceOrState.toString() : "") +
                (StringUtils.isNotBlank(postalCode) ? " - " + postalCode : "") +
                (country != null ? " - " + country.toString() : "");
    }
}