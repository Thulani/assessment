package za.co.investec.thulani;

import za.co.investec.thulani.dto.address.Address;
import za.co.investec.thulani.dto.address.AddressBuilder;
import za.co.investec.thulani.dto.address.AddressLineDetail;
import za.co.investec.thulani.service.address.AddressService;
import za.co.investec.thulani.service.address.AddressServiceImpl;

import java.util.List;

import static za.co.investec.thulani.dto.address.AddressType.Type.*;

/**
 * author: Thulani Hlongwane
 * Date: 2019/08/14
 */
public class PrettyPrintAddressDemo {

    private static final String ADDRESS_FILE = "addresses.json";

    public static void main(String[] args) {
        final AddressService addressService = new AddressServiceImpl();

        final Address businessAddress = new AddressBuilder(1)
                .setType(BUSINESS_ADDRESS)
                .setAddressLineDetail(new AddressLineDetail("21 Jump Street", ""))
                .setCityOrTown("Johannesburg")
                .setPostalCode("2000")
                .build();

        //a - Write a function to return a pretty print version of an address
        System.out.println("\n************************A************************");
        System.out.println(addressService.prettyPrintAddress(businessAddress));


        //b - Write a function to pretty print all the addresses in the attached file
        System.out.println("\n************************B************************");
        List<Address> addresses = addressService.getAddressesFromResource(ADDRESS_FILE);
        addressService.printAddresses(addresses);

        //c - Write a function to print an address of a certain type (postal, physical, business)
        System.out.println("\n************************C************************");
        addressService.printAddressesByType(addresses, POSTAL_ADDRESS);
        addressService.printAddressesByType(addresses, BUSINESS_ADDRESS);

        //d - Write a function to validate an address
        System.out.println("\n************************D************************");
        System.out.println(addressService.validateAddress(businessAddress));

        //e - For each address in the attached file, determine if it is valid or not
        System.out.println("\n************************E************************");
        addressService.printErrors(addressService.validateAddresses(addresses));
    }
}
