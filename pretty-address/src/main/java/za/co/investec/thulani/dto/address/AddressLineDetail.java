package za.co.investec.thulani.dto.address;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

/**
 * author: Thulani Hlongwane
 * Date: 2019/08/11
 */
public class AddressLineDetail implements Serializable {

    private String line1;
    private String line2;

    public AddressLineDetail() {
    }

    public AddressLineDetail(final String line1, final String line2) {
        this.line1 = line1;
        this.line2 = line2;
    }

    public String getLine1() {
        return line1;
    }

    public void setLine1(final String line1) {
        this.line1 = line1;
    }

    public String getLine2() {
        return line2;
    }

    public void setLine2(final String line2) {
        this.line2 = line2;
    }

    @Override
    public String toString() {
        return line1 + (StringUtils.isNotBlank(line2) ? " " + line2 : "");
    }
}
