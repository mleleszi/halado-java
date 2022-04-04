package com.example.springbatch.config;


import com.example.springbatch.dto.PersonDto;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.*;
import org.springframework.batch.item.xml.builder.StaxEventItemReaderBuilder;
import org.springframework.batch.item.xml.builder.StaxEventItemWriterBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;


@Configuration
@EnableBatchProcessing
public class BatchJobConfig {

    private final StepBuilderFactory stepBuilderFactory;

    public BatchJobConfig(StepBuilderFactory stepBuilderFactory) {
        this.stepBuilderFactory = stepBuilderFactory;
    }

    @Bean
    public ItemReader<PersonDto> xmlReader() {
        Jaxb2Marshaller productMarshaller = new Jaxb2Marshaller();
        productMarshaller.setClassesToBeBound(PersonDto.class);

        return new StaxEventItemReaderBuilder<PersonDto>()
                .name("xmlReader")
                .resource(new FileSystemResource("data/points.xml"))
                .addFragmentRootElements("person")
                .unmarshaller(productMarshaller)
                .build();
    }

    @Bean
    ItemWriter<PersonDto> xmlWriter() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setClassesToBeBound(PersonDto.class);

        return new StaxEventItemWriterBuilder<PersonDto>()
                .name("personWriter")
                .version("1.0")
                .rootTagName("people")
                .resource(new FileSystemResource("data/points.xml"))
                .marshaller(marshaller)
                .build();
    }

    @Bean
    public FlatFileItemWriter<PersonDto> csvWriter() {
        FlatFileItemWriter<PersonDto> writer = new FlatFileItemWriter<>();
        writer.setResource(new FileSystemResource("data/points.csv"));
        writer.setLineAggregator(new DelimitedLineAggregator<PersonDto>() {{
            setDelimiter(",");
            setFieldExtractor(new BeanWrapperFieldExtractor<PersonDto>() {{
                setNames(new String[]{"name", "points"});
            }});
        }});
        return writer;
    }

    @Bean
    public FlatFileItemReader<PersonDto> csvReader() {
        FlatFileItemReader<PersonDto> reader = new FlatFileItemReader<>();
        reader.setResource(new FileSystemResource("data/points.csv"));
        reader.setLineMapper(new DefaultLineMapper() {
            {
                setLineTokenizer(new DelimitedLineTokenizer() {
                    {
                        setNames(new String[]{"name", "points"});
                    }
                });
                setFieldSetMapper(new BeanWrapperFieldSetMapper<PersonDto>() {
                    {
                        setTargetType(PersonDto.class);
                    }
                });
            }
        });
        return reader;
    }


    @Bean
    public Step xmlToCsv() {
        return this.stepBuilderFactory
                .get("xmlToCsv")
                .<PersonDto, PersonDto>chunk(5)
                .reader(xmlReader())
                .writer(csvWriter())
                .allowStartIfComplete(true)
                .build();
    }

    @Bean
    public Step csvToXml() {
        return this.stepBuilderFactory
                .get("csvToXml")
                .<PersonDto, PersonDto>chunk(5)
                .reader(csvReader())
                .writer(xmlWriter())
                .allowStartIfComplete(true)
                .build();
    }

    @Bean
    public Step csvToConsole() {
        return this.stepBuilderFactory
                .get("csvToConsole")
                .<PersonDto, PersonDto>chunk(5)
                .reader(csvReader())
                .writer(people -> people.forEach(System.out::println))
                .allowStartIfComplete(true)
                .build();
    }

    @Bean
    public Step xmlToConsole() {
        return this.stepBuilderFactory
                .get("xmlToConsole")
                .<PersonDto, PersonDto>chunk(5)
                .reader(xmlReader())
                .writer(people -> people.forEach(System.out::println))
                .allowStartIfComplete(true)
                .build();
    }

}
