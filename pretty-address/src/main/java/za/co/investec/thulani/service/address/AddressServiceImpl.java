package za.co.investec.thulani.service.address;

import org.apache.commons.lang3.StringUtils;
import za.co.investec.thulani.dto.error.ValidationError;
import za.co.investec.thulani.dto.address.Address;
import za.co.investec.thulani.dto.address.AddressType;
import za.co.investec.thulani.util.AddressValidator;
import za.co.investec.thulani.util.FileUtil;
import za.co.investec.thulani.util.JsonUtil;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * author: Thulani Hlongwane
 * Date: 2019/08/11
 */
public class AddressServiceImpl implements AddressService {

    @Override
    public String prettyPrintAddress(final Address address) {
        if(address == null)
            throw new IllegalArgumentException("Please provide a valid address");

        return address.toString();
    }

    @Override
    public List<Address> getAddressesFromResource(final String filename) {
        String addressJson = FileUtil.getResourceFileAsString(filename);
        return Arrays.asList(JsonUtil.readJsonString(addressJson, Address[].class));
    }

    @Override
    public void printAddresses(final List<Address> addresses) {
        if(addresses == null || addresses.isEmpty())
            throw new IllegalArgumentException("No addresses provided");

        addresses.stream()
                .map(this::prettyPrintAddress)
                .forEach(System.out::println);
    }

    @Override
    public void printAddressesByType(final List<Address> addresses, final AddressType.Type addressType) {
        if(addresses != null) {
            addresses.stream()
                    .filter(address -> validateAddress(address) != null)
                    .filter(address -> StringUtils.equals(addressType.getName(), address.getType().getName()))
                    .map(this::prettyPrintAddress)
                    .forEach(System.out::println);
        }
    }

    @Override
    public ValidationError validateAddress(final Address address) {
        return AddressValidator.validateAddress(address);
    }

    @Override
    public List<ValidationError> validateAddresses(final List<Address> addresses) {
        return addresses.stream()
                .map(this::validateAddress)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    @Override
    public void printErrors(final List<ValidationError> errors) {
        if(errors != null) {
            errors.forEach(System.out::println);
        }
    }
}
