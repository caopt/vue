package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@RestController
public class Controller {

    @RequestMapping("/uploadversion")
    public void firstSpringBoot(@RequestParam("newclient") MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                BufferedOutputStream out = new BufferedOutputStream(
                        new FileOutputStream(new File(
                                file.getOriginalFilename())));
                out.write(file.getBytes());
                out.flush();
                out.close();
                FileReader fr = new FileReader("keylogger_set_sig.txt");
                BufferedReader br = new BufferedReader(fr);
                StringBuffer s = new StringBuffer();
                while (!br.readLine().isEmpty()) {
                    s.append(br.readLine());
                }
                System.out.print(s.toString());
                br.close();//关闭BufferReader流
                fr.close();    //关闭文件流
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.print("没有文件");
        }
    }
}
