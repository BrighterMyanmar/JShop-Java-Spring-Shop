package s.s.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageUploadService {
   static String UPLOAD_DIR = "src/main/resources/static/uploads/";

   public String saveFile(MultipartFile file) {
      String filename = file.getOriginalFilename();
      try {
         byte[] bytes = file.getBytes();
         Path path = Paths.get(UPLOAD_DIR + filename);
         Files.write(path, bytes);
      } catch (IOException e) {
         System.out.println("File Write Error");
      }
      return filename;
   }

   public String saveFiles(MultipartFile files[]) {
      String filenames = "";
      for (MultipartFile file : files) {
         filenames += "," + saveFile(file);
      }
      return filenames.substring(1);
   }
}
