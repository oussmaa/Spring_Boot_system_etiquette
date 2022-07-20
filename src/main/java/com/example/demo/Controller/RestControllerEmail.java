package com.example.demo.Controller;

import com.example.demo.Entity.Event;
import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class RestControllerEmail {
    private Path foundFile;
    @Autowired
    private UserRepository userRepo;
    @Autowired
    JavaMailSender javaMailSender;

    @PostMapping("/sendEmail")
    public ResponseEntity<?>  helloSpringBoot(@RequestBody String version) {

        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("chaouachimariem67@gmail.com");
        message.setTo("gharianioussama24@gmail.com");
        message.setSubject(version);
        message.setText("Salut tout le maonde,"
                + "On a livrer APSYS-406_pr3 V4.06-30.32 le 30 juin");

        javaMailSender.send(message);

        System.out.println("Mail successfully sent..");

        return new ResponseEntity<>(HttpStatus.OK);
    }
    public UrlResource getFileAsResource(String fileCode) throws IOException {
        Path dirPath = Paths.get("Files-Upload");

        Files.list(dirPath).forEach(file -> {
            if (file.getFileName().toString().startsWith(fileCode)) {
                foundFile = file;
                return;
            }
        });

        if (foundFile != null) {
            return new UrlResource(foundFile.toUri());
        }

        return null;
    }
    @PostMapping("/uploadFile/{id}")
    public ResponseEntity<?> uploadFile(
            @RequestParam("file") MultipartFile multipartFile,@PathVariable("id") long id)
            throws IOException {
        System.out.println(id);
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        String filecode = saveFile(fileName, multipartFile);

        User user = userRepo.findById(id).orElse(null);
        if (user!=null)
        {
            user.setImageUrl(filecode);
            userRepo.save(user);
        }


        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/downloadFile/{id}")
    public ResponseEntity<?> downloadFile(@PathVariable("id") Long id) {
     User user =userRepo.findById(id).orElse(null);;
        UrlResource resource = null;
       if(user.getImageUrl().isEmpty())
       {
           try {
               resource = getFileAsResource("5wn17tlM");
           } catch (IOException e) {
               return ResponseEntity.internalServerError().build();
           }
       }
       else {
           try {
               resource = getFileAsResource(user.getImageUrl());
           } catch (IOException e) {
               return ResponseEntity.internalServerError().build();
           }
       }



        if (resource == null) {
            return new ResponseEntity<>("File not found", HttpStatus.NOT_FOUND);
        }

        String contentType = "application/octet-stream";
        String headerValue = "attachment; filename=\"" + resource.getFilename() + "\"";
        System.out.println("vfffffff");
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, headerValue)
                .body(resource);
    }
    public static String saveFile(String fileName, MultipartFile multipartFile)
            throws IOException {
        Path uploadPath = Paths.get("Files-Upload");

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        String fileCode = RandomStringUtils.randomAlphanumeric(8);

        try (InputStream inputStream = multipartFile.getInputStream()) {
            Path filePath = uploadPath.resolve(fileCode + "-" + fileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ioe) {
            throw new IOException("Could not save file: " + fileName, ioe);
        }

        return fileCode;
    }
}
