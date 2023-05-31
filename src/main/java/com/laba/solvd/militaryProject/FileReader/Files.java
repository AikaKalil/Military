package com.laba.solvd.militaryProject.FileReader;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Files {
    public static Logger log = Logger.getLogger(Files.class);
    public static void main(String[] args) {
        try(Scanner input = new Scanner(System.in)){
        log.info("Enter your location here:");
        String locationOfFile = input.nextLine();
            File file = new File(locationOfFile);
            log.info("Write your text here: ");
            String text = input.nextLine();
            String[] words = StringUtils.split(text);
            Set<String> uniqueWords = new HashSet<>(Arrays.asList(words));
            int count = uniqueWords.size();
       File outputFile = new File("newOne.txt");
        FileUtils.writeStringToFile(outputFile,Integer.toString(count));
        log.info("Count of unique words written to file successfully.");
    } catch (IOException e) {
        e.printStackTrace();
        log.error("An error occurred!", e);
    }
    }
    }
