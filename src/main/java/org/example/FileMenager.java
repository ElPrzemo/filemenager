package org.example;

import java.io.File;
import java.util.ArrayList;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import static java.util.Objects.requireNonNull;

public class FileMenager {

    public void listFileesInDirectory (String directory) throws NullPointerException {
        try {
            Stream.of(Objects.requireNonNull(new File(directory).listFiles()))
                    .filter(File::isFile)
                    .map(File::getName)
                    .forEach(System.out::println);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public void sortFilesInDirectory(String directory){
        List<File> toSort = new ArrayList<>();
        for (File file : requireNonNull(new File(directory).listFiles())) {
            if (file.isFile()) {
                toSort.add(file);
            }
        }
        toSort.sort((o1, o2) -> Long.compare(o2.length(), o1.length()));
        for (File file : toSort) {
            System.out.println(file.getName());
            System.out.println(file.length());
            System.out.println();
        }
    }

}
