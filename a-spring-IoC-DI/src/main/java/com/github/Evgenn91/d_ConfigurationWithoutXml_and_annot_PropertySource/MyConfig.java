package com.github.Evgenn91.d_ConfigurationWithoutXml_and_annot_PropertySource;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration/* означает, что данный класс является конфигурацией */
@ComponentScan("com.github.Evgenn91.d_ConfigurationWithoutXml_and_annot_PropertySource") /* говорим, какой пакет нужно сканировать на наличие бинов и разных аннотаций */
@PropertySource("classpath:c_myApp.properties")/* эту аннотацию мы прописали, чтобы здесь(где мы будем сканировать) можно было использовать значения из файлов в папке resourses, а именно из файла c_myApp.properties-->*/
public class MyConfig {
}
