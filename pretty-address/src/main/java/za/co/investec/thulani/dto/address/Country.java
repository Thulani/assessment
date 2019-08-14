package za.co.investec.thulani.dto.address;

import java.io.Serializable;

/**
 * author: Thulani Hlongwane
 * Date: 2019/08/11
 */
public class Country implements Serializable {

    private String code;
    private String name;

    public Country(final String code, final String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(final String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
