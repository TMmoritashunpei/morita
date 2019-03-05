package com.example.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "ymlSetting")
public class Settings {
	private String slackbotAccessKey;
	public void setSlackbotKey(String slackbotAccessKey){
        this.slackbotAccessKey = slackbotAccessKey;
    }
	public String getStringKey(){
        return slackbotAccessKey;
    }
}
