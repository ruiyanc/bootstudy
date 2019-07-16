package rui.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@RestController
public class FileUploadController {
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");

    @PostMapping("upload")
    public String fileUpload(MultipartFile filename, HttpServletRequest request) {
        String realPath = request.getSession().getServletContext().getRealPath("/static/upload/");
        String format;
        format = simpleDateFormat.format(new Date());
        File folder = new File(realPath + format);
        if (!folder.isDirectory()) {
            folder.mkdirs();
        }
        String oldName = filename.getOriginalFilename();
        String newName = UUID.randomUUID().toString() + (oldName != null ? oldName.substring(oldName.lastIndexOf(".")) : null);
        try {
            filename.transferTo(new File(folder, newName));
            return request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/upload/" + format + newName;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "上传失败";
    }
}
