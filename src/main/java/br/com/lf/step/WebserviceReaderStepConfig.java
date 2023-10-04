package br.com.lf.step;

import br.com.lf.domain.User;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebserviceReaderStepConfig {

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Value("${chunkSize}")
    private int chunkSize;

    @Bean
    public Step webserviceReaderStep(
            ItemReader<User> reader,
            ItemWriter<User> writer
    ) {
        return stepBuilderFactory
                .get("webserviceReaderStep")
                .<User, User>chunk(chunkSize)
                .reader(reader)
                .writer(writer)
                .build();
    }
}
