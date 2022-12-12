package multi_userdata.myExecFiles;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Exp1 {

    public static void main(String[] args){

        //All return the abs path to project dir
        System.out.println(System.getProperty("user.dir"));

        Path currentWorkingDir = Paths.get("").toAbsolutePath();
        System.out.println(currentWorkingDir.normalize().toString());

        Path currentWorkingDir1 = Paths.get("../").toAbsolutePath();
        System.out.println(currentWorkingDir1.normalize().toString());

        String pattern = "hh:mm:ss a";
        
        //1. LocalTime
        LocalTime now = LocalTime.now();
        System.out.println(now.format(DateTimeFormatter.ofPattern(pattern)));

        //2. LocalDateTime
        LocalDateTime nowTime = LocalDateTime.now();
        System.out.println(nowTime.format(DateTimeFormatter.ofPattern(pattern)));
    }
    
}
