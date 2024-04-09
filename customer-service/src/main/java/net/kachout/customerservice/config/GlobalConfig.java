package net.kachout.customerservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("global.params")
public record GlobalConfig(int p1,int p2) {
}
