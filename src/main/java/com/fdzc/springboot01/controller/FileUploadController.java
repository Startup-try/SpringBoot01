package com.fdzc.springboot01.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

@RestController
public class FileUploadController {


    @PostMapping("/upload")
    public ResponseEntity uploadFile(@RequestParam("imgFile") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("请选择要上传的文件");
        }
        try {
            // 获取原始文件名
            String originalFilename = file.getOriginalFilename();
            // 生成新的文件名，以防止文件名冲突
            String newFilename = UUID.randomUUID().toString() + "_" + originalFilename;

            // 文件保存路径
            String filePath = "D:/zaoba/" + newFilename;
            // 保存文件到服务器
            file.transferTo(new File(filePath));

            // 返回文件上传成功的相关信息
            String message = "文件上传成功\n";

            return ResponseEntity.ok(message);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("文件上传失败: " + e.getMessage());
        }
    }

}
