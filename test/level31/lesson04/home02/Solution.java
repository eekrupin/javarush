package com.javarush.test.level31.lesson04.home02;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

/* Поиск скрытых файлов
В классе Solution переопределите логику двух методов:
-visitFile кроме своей логики должен добавлять в archived все пути к zip и rar файлам
-visitFileFailed должен добавлять в failed все пути к недоступным файлам и возвращать SKIP_SUBTREE
Пример вывода:
D:/mydir/BCD.zip
Метод main не участвует в тестировании
*/
public class Solution extends SimpleFileVisitor<Path> {
    public static void main(String[] args) throws IOException {
        EnumSet<FileVisitOption> options = EnumSet.of(FileVisitOption.FOLLOW_LINKS);
        final Solution solution = new Solution();
        Files.walkFileTree(Paths.get("E:\\Java"), options, 20, solution);

        List<String> result = solution.getArchived();
        System.out.println("All archived files:");
        for (String path : result) {
            System.out.println("\t" + path);
        }

        List<String> failed = solution.getFailed();
        System.out.println("All failed files:");
        for (String path : failed) {
            System.out.println("\t" + path);
        }
    }

    private List<String> archived = new ArrayList<>();
    private List<String> failed = new ArrayList<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        File fileObj = file.toFile();
        String name = fileObj.getName().toLowerCase();
        if (name.endsWith(".zip") || name.endsWith(".rar")) archived.add(fileObj.getAbsolutePath());
        else failed.add(fileObj.getAbsolutePath());
        return super.visitFile(file, attrs);
    }

    public List<String> getArchived() {
        return archived;
    }

    public List<String> getFailed() {
        return failed;
    }
}
