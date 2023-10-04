package br.com.lf.writer;

import br.com.lf.domain.User;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PrintUserWriterConfig {

    /**
     *
     * @return Imprime os usuários lidos =)
     */
    @Bean
    public ItemWriter<User> printUserWriter() {
        return items -> items.forEach(System.out::println);
    }
}
