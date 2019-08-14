package za.co.investec.thulani.util;

import org.apache.commons.lang3.StringUtils;
import za.co.investec.thulani.dto.error.ValidationError;
import za.co.investec.thulani.dto.address.Address;
import za.co.investec.thulani.dto.address.Country;

/**
 * author: Thulani Hlongwane
 * Date: 2019/08/11
 */
public class AddressValidator {

    private static final String SOUTH_AFRICA = "ZA";
    private static final String INVALID_POSTAL_CODE = "Postal Code is invalid- must be numeric";
    private static final String INVALID_COUNTRY = "Country is invalid";
    private static final String INVALID_PROVINCE = "Province/State required";
    private static final String INVALID_ADDRESS_LINE = "Address line required";

    public static ValidationError validateAddress(final Address address) {
        if(address == null)
            throw new IllegalArgumentException("Please provide an address!");

        final ValidationError validationErrors = new ValidationError(address);

        if (!validatePostalCode(address.getPostalCode()))
            validationErrors.addError(INVALID_POSTAL_CODE);

        if (!validateCountry(address.getCountry())) {
            validationErrors.addError(INVALID_COUNTRY);
        } else {
            if(SOUTH_AFRICA.equals(address.getCountry().getCode()) && address.getProvinceOrState() == null) {
                validationErrors.addError(INVALID_PROVINCE);
            }
        }

        if (address.getAddressLineDetail() == null) {
            validationErrors.addError(INVALID_ADDRESS_LINE);
        } else if ((address.getAddressLineDetail().getLine1() == null || address.getAddressLineDetail().getLine1().isEmpty()) &&
                (address.getAddressLineDetail().getLine2() == null || address.getAddressLineDetail().getLine2().isEmpty())) {
            validationErrors.addError(INVALID_ADDRESS_LINE);
        }
        return validationErrors.getErrorMessages() != null ? validationErrors : null;
    }

    private static boolean validatePostalCode(final String postalCode) {
        return StringUtils.isNumeric(postalCode);
    }

    private static boolean validateCountry(final Country country) {
        return country != null;
    }
}