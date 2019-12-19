package cs544.formatter;

import cs544.domain.Authority;
import cs544.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;


@Component
public class AuthorityFormatter implements Formatter<Authority> {

    @Autowired
    private AuthorityService authorityService;

    @Override
    public String print(Authority role, Locale locale) {
        System.out.println("***********");
        return String.valueOf(role.getId());
    }

    @Override
    public Authority parse(String text, Locale locale) throws ParseException {
        System.out.println("-----------" + text);
        return authorityService.getById(Integer.valueOf(text));
    }

}
