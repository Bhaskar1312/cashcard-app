package example.cashcard;

import org.springframework.aot.hint.annotation.RegisterReflectionForBinding;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportRuntimeHints;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;
import org.springframework.lang.Nullable;

@SpringBootApplication
@RegisterReflectionForBinding({UserDto.class, CashCardDto.class})
@ImportRuntimeHints(CashCardApplication.Hints.class)

@SpringBootApplication
@RegisterReflectionForBinding({UserDto.class, CashCardDto.class})
public class CashCardApplication {

    static class Hints implements
        RuntimeHintsRegistrar {
        @Override
        public void registerHints(RuntimeHints hints, @Nullable ClassLoader classLoader) {
            hints.resources().registerPattern("cashcard-banner.txt");
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(CashCardApplication.class, args);
    }

}

//./gradlew clean build test
// ./gradlew bootRun
// curl http://localhost:8080/banner
// curl http://localhost:8080/list

// add id 'org.graalvm.buildtools.native' version '0.9.23' in plugins
// ./gradlew nativeCompile
// in native-image.cmd
// @echo off
// call "D:\Program Files\Microsoft Visual Studio\2022\Community\VC\Auxiliary\Build\vcvars64.bat" > null
// build/native/nativeCompile/cashcard
// see banner and list apis both fail
//java.io.FileNotFoundException: class path resource [cashcard-banner.txt] cannot be opened because it does not exist
//
//org.thymeleaf.exceptions.TemplateProcessingException: Exception evaluating SpringEL expression: "cashcard.id" (template: "list.html" - line 5, col 47)] with root cause
//
// org.springframework.expression.spel.SpelEvaluationException: EL1008E: Property or field 'id' cannot be found on object of type 'example.cashcard.CashCardDto' - maybe not public or not valid?
// ./gradlew nativeTest
// DisabledInNativeImage on banner test
// View the content of the build/generated/aotTestResources/META-INF/native-image/example/cashcard directory. It contains 3 files: proxy-config.json, reflect-config.json, and resource-config.json
