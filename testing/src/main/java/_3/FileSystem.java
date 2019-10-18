package _3;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class FileSystem {
    private MyDir root = new MyDir("");

    public FileSystem() {
    }

    public List<String> ls(String path) {
        if (path.equals("/")) {
            return this.root.ls();
        }

        String[] strings = splitPaths(path);
        int length = strings.length;
        String last = strings[length - 1];
        MyDir parent = this.root;
        for (int i = 0; i < length - 1; i++) {
            String name = strings[i];
            parent = parent.getSubOrCreate(name);
        }
        MyFile myFile = parent.get(last);
        if (myFile == null) {
            return Collections.emptyList();
        }
        return myFile.ls();
    }

    public void mkdir(String path) {
        MyDir parent = this.root;
        for (String name : splitPaths(path)) {
            parent = parent.getSubOrCreate(name);
        }
    }

    public void addContentToFile(String filePath, String content) {
        String[] strings = splitPaths(filePath);
        int length = strings.length;
        String last = strings[length - 1];
        MyDir parent = this.root;
        for (int i = 0; i < length - 1; i++) {
            String name = strings[i];
            parent = parent.getSubOrCreate(name);
        }

        parent.vim(last, content);
    }

    public String readContentFromFile(String filePath) {
        String[] strings = splitPaths(filePath);
        int length = strings.length;
        String last = strings[length - 1];
        MyDir parent = this.root;
        for (int i = 0; i < length - 1; i++) {
            String name = strings[i];
            parent = parent.getSubOrCreate(name);
        }
        MyFile myFile = parent.get(last);
        if (myFile instanceof MyDir) {
            return null;
        }
        return myFile.contentAppender.toString();
    }

    private static String[] splitPaths(String path) {
        return path.replaceFirst("^/", "").split("/");
    }

    /**
     * name: abc.txt
     * parentDir: /test
     */
    private static class MyFile {
        final StringBuilder contentAppender = new StringBuilder();
        final String name;
        MyDir parentDir;

        MyFile(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public List<String> ls() {
            return Collections.singletonList(this.getName());
        }
    }

    private static class MyDir extends MyFile {
        List<MyFile> files = new LinkedList<>();

        MyDir(String name) {
            super(name);
        }

        @Override
        public String getName() {
            String name = super.getName();
            return name.equals("") ? "/" : name;
        }

        @Override
        public List<String> ls() {
            List<String> lsList = new LinkedList<>();
            for (MyFile file : this.files) {
                lsList.add(file.getName());
            }

            lsList.sort(Comparator.naturalOrder());
            return lsList;
        }

        MyDir getSubDir(String name) {
            for (MyFile file : this.files) {
                if (file instanceof MyDir && file.name.equals(name)) {
                    return (MyDir) file;
                }
            }
            return null;
        }

        MyDir mkdir(String name) {
            MyDir dir = new MyDir(name);
            this.files.add(dir);
            return dir;
        }

        MyFile get(String name) {
            for (MyFile file : this.files) {
                if (file.name.equals(name)) {
                    return file;
                }
            }
            return null;
        }

        void vim(String name, String content) {
            MyFile myFile = this.get(name);
            if (myFile == null) {
                MyFile file = new MyFile(name);
                file.contentAppender.append(content);
                this.files.add(file);
            } else if (!(myFile instanceof MyDir)) {
                myFile.contentAppender.append(content);
            }
        }

        private MyDir getSubOrCreate(String name) {
            MyDir subDir = getSubDir(name);
            return subDir != null
                ? subDir
                : mkdir(name);
        }
    }
}
