package za.co.investec.thulani.dto.address;

import java.io.Serializable;

/**
 * author: Thulani Hlongwane
 * Date: 2019/08/11
 */
public class State implements Serializable {

    private long code;
    private String name;

    public long getCode() {
        return code;
    }

    public void setCode(final long code) {
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
