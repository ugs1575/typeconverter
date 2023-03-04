package hello.typeconverter;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import hello.typeconverter.converter.IntegerToStringConverter;
import hello.typeconverter.converter.IpPortToStringConverter;
import hello.typeconverter.converter.StringToIntegerConverter;
import hello.typeconverter.converter.StringToIpPortConverter;
import hello.typeconverter.formatter.MyNumberFormatter;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addConverter(new StringToIpPortConverter());
		registry.addConverter(new IpPortToStringConverter());

		//주석처리 우선순위
		// registry.addConverter(new IntegerToStringConverter());
		// registry.addConverter(new StringToIntegerConverter());

		//추가
		registry.addFormatter(new MyNumberFormatter());
	}
}
