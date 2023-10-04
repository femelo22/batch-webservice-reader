package br.com.lf.reader;

import br.com.lf.domain.ResponseUser;
import br.com.lf.domain.User;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class UserReaderConfig implements ItemReader<User> {

    private RestTemplate restTemplate = new RestTemplate();
    private int page = 1;

    @Override
    public User read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {

        fetchUserDataFromAPI();

        return null;
    }

    private List<User> fetchUserDataFromAPI() {
        ResponseEntity<ResponseUser> response = restTemplate
                .getForEntity(String.format("https://gorest.co.in/public/v2/users?page=%d", page), ResponseUser.class);

        List<User> userData = response.getBody().getData();
        return  userData;
    }
}
