package za.co.investec.thulani;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import za.co.investec.thulani.dto.address.Address;
import za.co.investec.thulani.dto.address.AddressBuilder;
import za.co.investec.thulani.dto.address.AddressLineDetail;
import za.co.investec.thulani.dto.address.Country;
import za.co.investec.thulani.service.address.AddressService;
import za.co.investec.thulani.service.address.AddressServiceImpl;
import za.co.investec.thulani.util.FileUtil;
import za.co.investec.thulani.util.JsonUtil;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * author: Thulani Hlongwane
 * Date: 2019/08/11
 */
class PrettyPrintAddressTest {

    private AddressService addressService;

    @BeforeEach
    void init() {
        addressService = new AddressServiceImpl();
    }

    @Test
    @DisplayName("Test Null Address")
    void testNullAddress() {
        assertThrows(IllegalArgumentException.class, () -> addressService.prettyPrintAddress(null));
    }

    @Test
    @DisplayName("Test Pretty Print Address")
    void testPrettyPrint() {
        Address dummyAddress = new AddressBuilder(1)
                .setAddressLineDetail(new AddressLineDetail("21 Jump Street", ""))
                .setCityOrTown("Johannesburg")
                .setPostalCode("2000")
                .build();

        String prettyAddress = addressService.prettyPrintAddress(dummyAddress);
        assertEquals("21 Jump Street - Johannesburg - 2000", prettyAddress, "Address invalid");
    }

    @Test
    @DisplayName("Test Pretty Print Business Address")
    void testPrettyPrintBusinessAddress() {
        String addressString = FileUtil.getResourceFileAsString("business_addresses.json");
        Address[] address = JsonUtil.readJsonString(addressString, Address[].class);
        if(address != null)
            addressService.prettyPrintAddress(address[0]);
    }

    @Test
    @DisplayName("Test VAlidate Address")
    void testInvalidAddress() {
        Address invalidAddress = new AddressBuilder(1)
                .setAddressLineDetail(new AddressLineDetail("21 Jump Street", ""))
                .setCityOrTown("Johannesburg")
                .setPostalCode("2000")
                .setCountry(new Country("14", "Namibia"))
                .build();

        assertNull(addressService.validateAddress(invalidAddress));
    }

    @Test
    @DisplayName("Test VAlidate Address")
    void testValidAddress() {
        Address invalidAddress = new AddressBuilder(1)
                .setAddressLineDetail(new AddressLineDetail("21 Jump Street", ""))
                .setCityOrTown("Johannesburg")
                .setPostalCode("2000")
                .build();

        assertNotNull(addressService.validateAddress(invalidAddress));
    }
}
