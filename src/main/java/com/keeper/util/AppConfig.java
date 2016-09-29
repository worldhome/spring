package com.keeper.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ UserConfig.class })
public class AppConfig {

}
