package cn.penguin.common.web.config;

import cn.penguin.common.core.constant.DateConstant;
import cn.penguin.common.core.utils.JsonUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.std.NumberSerializer;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * @author Wensy
 * @since 2022/11/24 16:20:00
 */
@Slf4j
@Configuration
@DependsOn("springUtil")
public class HttpMessageConvertConfig implements WebMvcConfigurer {

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.removeIf(converter -> converter instanceof MappingJackson2HttpMessageConverter);
        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = mappingJackson2HttpMessageConverter();
        if (Objects.isNull(mappingJackson2HttpMessageConverter)) {
            converters.add(0, new MappingJackson2HttpMessageConverter());
        } else {
            converters.add(0, mappingJackson2HttpMessageConverter);
        }
    }

    /**
     * ?????? http ???????????? jackson ?????????
     *
     * @return MappingJackson2HttpMessageConverter
     */
    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        //??????????????????
        ObjectMapper objectMapper = JsonUtil.MAPPER;
        mappingJackson2HttpMessageConverter.setObjectMapper(objectMapper);
        //????????????????????????
        List<MediaType> list = new ArrayList<>();
        list.add(MediaType.APPLICATION_JSON);
        mappingJackson2HttpMessageConverter.setSupportedMediaTypes(list);
        return mappingJackson2HttpMessageConverter;
    }


    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jacksonObjectMapperCustomization() {
        return builder ->
        {
            builder.locale(Locale.CHINA);
            //LocalDateTime
            builder.timeZone(TimeZone.getTimeZone(ZoneId.systemDefault()));
            builder.simpleDateFormat(DateConstant.TIME_FORMAT);

            builder.serializerByType(LocalDateTime.class,
                    new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(DateConstant.TIME_FORMAT)));
            builder.deserializerByType(LocalDateTime.class,
                    new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern(DateConstant.TIME_FORMAT)));
//            //LocalDate
//            builder.serializerByType(LocalDate.class,
//                    new LocalDateSerializer(DateTimeFormatter.ofPattern(DateConstant.DATE_FORMAT)));
//            builder.deserializerByType(LocalDate.class,
//                    new LocalDateDeserializer(DateTimeFormatter.ofPattern(DateConstant.DATE_FORMAT)));

            //Long ??????????????? String ??????????????????????????? Long ????????????????????????
            builder.serializerByType(Long.TYPE, ToStringSerializer.instance);
            builder.serializerByType(Long.class, ToStringSerializer.instance);
            builder.serializerByType(long.class, NumberSerializer.instance);
            // ?????????JavaTimeModule
            JavaTimeModule javaTimeModule = new JavaTimeModule();
            //??????LocalDateTime
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DateConstant.TIME_FORMAT);
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(DateConstant.DATE_FORMAT);
            javaTimeModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(dateTimeFormatter));
            javaTimeModule.addSerializer(LocalDate.class, new LocalDateSerializer(dateFormatter));
            javaTimeModule.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(dateTimeFormatter));
            javaTimeModule.addDeserializer(LocalDate.class, new LocalDateDeserializer(dateFormatter));
            //??????????????????, ??????jsr310, ??????????????????(java.time??????????????????)
            builder.modules(javaTimeModule);

        };
    }

}
