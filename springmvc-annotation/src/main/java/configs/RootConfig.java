package configs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

//Spring容器：不扫描Controller ，是一个父容器
//useDefaultFilters = false 禁用默认的过滤规则（默认扫描），默认扫描所有
@ComponentScan(value = "java", excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class})
}, useDefaultFilters = false)
public class RootConfig {

}
