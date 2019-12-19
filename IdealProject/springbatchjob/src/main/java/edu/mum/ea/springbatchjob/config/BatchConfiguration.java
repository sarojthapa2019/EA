package edu.mum.ea.springbatchjob.config;

import edu.mum.ea.springbatchjob.domain.Student;
import edu.mum.ea.springbatchjob.utility.StudentProcessor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import javax.sql.DataSource;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {
    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Autowired
    public DataSource dataSource;

    @Bean
    public FlatFileItemReader<Student> reader(){
        return new FlatFileItemReaderBuilder<Student>()
                .name("StudentReader")
                .resource(new ClassPathResource("student-data.csv"))
                .delimited()
                .names(new String[]{"firstName", "lastName", "cgpa", "birthDate"})
                .fieldSetMapper(new BeanWrapperFieldSetMapper<Student>(){
            {
                setTargetType(Student.class);
            }
        })
                .build();
    }
    @Bean
    public StudentProcessor processor(){
        return new StudentProcessor();
    }
    @Bean
    public JdbcBatchItemWriter<Student> writer() {
        return new JdbcBatchItemWriterBuilder<Student>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql("INSERT INTO student (first_name, last_name, cgpa, birth_date) VALUES (:firstName, :lastName, :cgpa, :birthDate)")
                .dataSource(dataSource)
                .build();
    }
    @Bean
    public Job importJob(JobCompletionNotificationListener listener, Step step1) {
        return jobBuilderFactory.get("importJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(step1)
                .end()
                .build();
    }

    @Bean
    public Step step1(JdbcBatchItemWriter<Student> writer) {
        return stepBuilderFactory.get("step1")
                .<Student, Student> chunk(10)
                .reader(reader())
                .processor(processor())
                .writer(writer)
                .build();
    }
}
