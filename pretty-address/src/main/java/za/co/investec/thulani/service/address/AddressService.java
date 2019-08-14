package za.co.investec.thulani.service.address;

import za.co.investec.thulani.dto.error.ValidationError;
import za.co.investec.thulani.dto.address.Address;
import za.co.investec.thulani.dto.address.AddressType;

import java.util.List;

/**
 * author: Thulani Hlongwane
 * Date: 2019/08/11
 */
public interface AddressService {

    String prettyPrintAddress(Address address);

    List<Address> getAddressesFromResource(String filename);

    void printAddresses(List<Address> addresses);

    void printAddressesByType(List<Address> addresses, AddressType.Type addressType);

    ValidationError validateAddress(Address address);

    List<ValidationError> validateAddresses(List<Address> addresses);

    void printErrors(List<ValidationError> errors);
}