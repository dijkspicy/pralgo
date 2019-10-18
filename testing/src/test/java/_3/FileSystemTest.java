package _3;

import org.junit.Test;

import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.*;

public class FileSystemTest {
    @Test
    public void test() {
        FileSystem fileSystem = new FileSystem();
        fileSystem.mkdir("/a/b/c");
        List<String> ls = fileSystem.ls("/");
        System.out.println(ls);
    }

    public static void main(String[] args) {
        FileSystem fileSystem = new FileSystem();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            try {
                String cmd = scanner.nextLine().trim();
                String[] split = cmd.split(" ");
                switch (split[0]) {
                    case "ls":
                        System.out.println(fileSystem.ls(split[1]));
                        break;
                    case "mkdir":
                        fileSystem.mkdir(split[1]);
                        break;
                    case "add":
                        fileSystem.addContentToFile(split[1], split[2]);
                        break;
                    case "read":
                        System.out.println(fileSystem.readContentFromFile(split[1]));
                        break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}