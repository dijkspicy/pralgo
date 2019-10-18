package _3;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * a self defined file system
 */
public class FileSystem {
    private final MyDir root = new MyDir("");

    /**
     * create a new file system
     */
    public FileSystem() {
    }

    /**
     * list all files in path
     *
     * @param path path
     * @return all files in path
     */
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

    /**
     * make new directories with path
     *
     * @param path path
     */
    public void mkdir(String path) {
        MyDir parent = this.root;
        for (String name : splitPaths(path)) {
            parent = parent.getSubOrCreate(name);
        }
    }

    /**
     * add content to the file
     *
     * @param filePath the file
     * @param content content to append
     */
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

    /**
     * read content from the file
     *
     * @param filePath the file
     * @return content of the file
     */
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
        final MyDir parentDir;

        /**
         * create a file instance named name
         *
         * @param name name
         * @param parent parent dir
         */
        MyFile(String name, MyDir parent) {
            this.name = name;
            this.parentDir = parent;
        }

        /**
         * current name
         *
         * @return name
         */
        public String getName() {
            return name;
        }

        /**
         * list the files
         *
         * @return files
         */
        public List<String> ls() {
            return Collections.singletonList(this.getName());
        }
    }

    /**
     * dir
     */
    private static class MyDir extends MyFile {
        List<MyFile> files = new LinkedList<>();

        /**
         * create a dir named name
         *
         * @param name dir name
         */
        MyDir(String name) {
            super(name, null);
        }

        /**
         * create a dir named name with parent dir
         *
         * @param name name
         * @param parent parent
         */
        MyDir(String name, MyDir parent) {
            super(name, parent);
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

        /**
         * get sub dir named name
         *
         * @param name name
         * @return sub dir or null
         */
        MyDir getSubDir(String name) {
            for (MyFile file : this.files) {
                if (file instanceof MyDir && file.name.equals(name)) {
                    return (MyDir) file;
                }
            }
            return null;
        }

        /**
         * make new sub directory named name
         *
         * @param name dir name
         * @return sub dir
         */
        MyDir mkdir(String name) {
            MyDir dir = new MyDir(name, this);
            this.files.add(dir);
            return dir;
        }

        /**
         * get sub file or null if not exists
         *
         * @param name name
         * @return sub file
         */
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
                MyFile file = new MyFile(name, this);
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
