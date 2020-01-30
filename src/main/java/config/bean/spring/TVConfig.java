package config.bean.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TVConfig {
	@Bean //getTV의 결과를 bean으로 만들어줌. bean의 이름이 getTV
	public TV getTV() {
		return new SamsungTV();
		//return new LgTV();
	}
}
