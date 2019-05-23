package com.reaction.JavaReactor.controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.reaction.JavaReactor.model.Role;
import com.reaction.JavaReactor.repositories.PostRepo;
import com.reaction.JavaReactor.rx.TaxRx;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.aspectj.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Flux;

import javax.annotation.PostConstruct;
import javax.xml.crypto.OctetStreamData;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.HashMap;
import java.util.stream.Stream;

@Slf4j
@CrossOrigin(origins = "**/*")
@RestController
public class ReactorController {

    @Autowired
    RestTemplateBuilder restTemplate;

    @Autowired
    TaxRx taxRx;
    @Autowired
    PostRepo postRepo;
    @Autowired
    ObjectMapper objectMapper;

    private ClassLoader classLoader = ClassLoader.getSystemClassLoader();

    private byte[] prim;

    String home = System.getProperty("user.home");

    @SneakyThrows
    @PostConstruct
    public void init() {
        prim = FileUtil.readAsByteArray(classLoader.getResourceAsStream("pic.jpg"));

    }

    @SneakyThrows
    @GetMapping(value = "/thing.jpg")
    public Flux<Character> getpdf() {


        log.info("" + prim.length);
        Byte[] bytes = new Byte[prim.length];

        int i;
        String base = Base64.getEncoder().encodeToString(prim);
        char[] charBase = base.toCharArray();
        Character[] characters = new Character[charBase.length];

        for (i = 0; i < charBase.length; i++) {
            characters[i] = charBase[i];
            if (i < 20) {
                System.out.println(charBase[i]);
            }
        }

        log.info("" + i);

        Path path = Paths.get("jeffers");

        FileUtil.writeAsString(new File(path.toUri()), base);
        BufferedInputStream bufferedInputStream = new BufferedInputStream((new FileInputStream("ayy.txt")));

        return Flux.fromArray(characters).doOnNext(System.out::print);


    }

    @SneakyThrows
    @PostMapping("/role")
    public void getRoles(@RequestBody Role role) {

        String jsonString = objectMapper.writeValueAsString(role);
        HashMap<String, String> newMap = objectMapper.readValue(jsonString, new TypeReference<HashMap<String, String>>() {
        });
        HashMap<String, String> otherMap = new HashMap<>();

        otherMap.put("name", newMap.get("name"));
        log.info(jsonString);
        log.info(role.toString());
        log.info(newMap.get("name"));
        log.info(otherMap.get("name"));
    }

    @SneakyThrows
    @GetMapping(value = "/file.zip", produces = "application/zip")
    public byte[] getZip() {
        String home = System.getProperty("user.home");
        File file = Paths.get(home, "GCP.zip").toFile();
        return new BufferedInputStream(new FileInputStream(file)).readAllBytes();
//        return file.getAbsoluteFile();

    }

    @GetMapping("/self.zip")
    public byte[] getSelf() {
        ByteArrayInputStream bufferedInputStream = new ByteArrayInputStream(restTemplate.build().getForEntity("http://localhost:8080/file.zip", byte[].class).getBody());

        return bufferedInputStream.readAllBytes();
    }

@SneakyThrows
    @GetMapping("/chive")
    public byte[] getGo() {
        Path path = Paths.get(home, "archie.zip");

        return new BufferedInputStream(new FileInputStream(path.toFile())).readAllBytes();

    }


}
