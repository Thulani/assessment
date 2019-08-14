package za.co.investec.thulani.dto.error;

import java.util.ArrayList;
import java.util.List;

/**
 * author: Thulani Hlongwane
 * Date: 2019/08/11
 */
public class ValidationError {

    private Object object;

    private List<String> errorMessages;

    public ValidationError(final Object address) {
        this.object = address;
    }

    public List<String> getErrorMessages() {
        return errorMessages;
    }

    public void setErrorMessages(final List<String> errorMessages) {
        this.errorMessages = errorMessages;
    }

    public void addError(final String message) {
        if(errorMessages == null)
            errorMessages = new ArrayList<>();
        errorMessages.add(message);
    }

    @Override
    public String toString() {
        return "Validation Error: [" + object.toString() + "] \n" +
                "-> Errors = " +
                getErrorMessages();
    }
}