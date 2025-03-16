package exercise;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.Arrays;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;
import java.io.File;
import java.nio.file.StandardOpenOption;

class App {

    // BEGIN
    /*
    Метод должен асинхронно читать содержимое двух файлов, объединять эту информацию и записывать её в третий файл.
    Метод принимает три аргумента – пути до файлов в виде строки. Первые два аргумента – пути до файлов-источников,
    третий – путь до итогового файла. Метод может принимать абсолютный и относительный путь до файлов.
    Если хотя-бы один из файлов-источников не существует, на экран должно выводиться сообщение о возникшем исключении.
    Если итоговый файл не существует, он должен быть создан.
    */
    public static CompletableFuture<String> unionFiles(String from1, String from2, String to) {

        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                return Files.readString(Paths.get(from1));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                return Files.readString(Paths.get(from2));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        return future1.thenCombine(future2, (s1, s2) -> {
            String s = s1 + s2;
            try {
                var path = Paths.get(to);
                if (!Files.exists(path)) {
                    Files.createFile(path);
                    Files.writeString(path, s);
                } else {
                    Files.writeString(path, s);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return s;
        }).exceptionally(e -> {
            System.out.println(e.getMessage());
            return null;
        });
    }
    // END

    public static void main(String[] args) throws Exception {
        // BEGIN
        CompletableFuture<String> result = App.unionFiles("file1.txt", "file2.txt", "dest.txt");
        // END
    }
}

