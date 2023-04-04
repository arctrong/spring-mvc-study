package springmvcstudy2.config.formatter;

import org.springframework.format.Formatter;
import springmvcstudy2.model.PhoneDto;

import java.util.Locale;

public class PhoneNumberFormatter implements Formatter<PhoneDto> {

    @Override
    public String print(PhoneDto object, Locale locale) {
        return object.getCountryCode() + "-" + object.getUserNumber();
    }

    @Override
    public PhoneDto parse(String text, Locale locale) {
        System.out.println("inside PhoneNumberFormatter#parse");
        String[] split = text.replaceAll("\\s", "").split("-");
        PhoneDto phoneDto = new PhoneDto();
        phoneDto.setCountryCode(split[0]);
        phoneDto.setUserNumber(split[1]);
        return phoneDto;
    }
}
